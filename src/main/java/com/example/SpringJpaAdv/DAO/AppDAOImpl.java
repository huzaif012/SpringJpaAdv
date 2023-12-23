package com.example.SpringJpaAdv.DAO;

import com.example.SpringJpaAdv.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {
    EntityManager entityManager;
    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
         entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Instructor tempInstructor = findById(theId);
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, theId);
        entityManager.remove(instructorDetail);

    }

    @Override
    public List<Course> findCourseInstructorById(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data",theId);

        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Instructor findCourseInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id = :data", Instructor.class);
        query.setParameter("data", theId);
        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructor){
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        //retrieve the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);
        List<Course> courses = tempInstructor.getCourses();

        //break associations of all courses for instructor
        for (Course tempCourse : courses){
            tempCourse.setInstructor(null); //remove the instructor from the courses
        }
        //delete the instructor
        entityManager.remove(tempInstructor);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        //retrieve the course
        Course tempCourse = entityManager.find(Course.class, theId);

        //delete the course
        entityManager.remove(tempCourse);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseReviewByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c JOIN FETCH c.reviews where c.id = :data", Course.class);
        query.setParameter("data", theId);
        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public Course findCourseAndStudentByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery(
                "SELECT c FROM Course c JOIN FETCH c.Students s WHERE c.id = :data",
                Course.class
        );
        query.setParameter("data", theId);
        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public Student findCourseAndStudentByStudentId(int theId) {
        TypedQuery<Student> query = entityManager.createQuery(
                "SELECT s FROM Student s JOIN FETCH s.courses WHERE s.id = :data",
                Student.class
        );
        query.setParameter("data", theId);
        Student student = query.getSingleResult();
        return student;
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void deleteStudentById(int theId) {
        Student theStudent = entityManager.find(Student.class, theId);
        entityManager.remove(theStudent);
    }


}
