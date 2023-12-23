package com.example.SpringJpaAdv.DAO;

import com.example.SpringJpaAdv.entity.*;

import java.util.List;

public interface AppDAO {
    public void save(Instructor instructor);

    public Instructor findById(int theId);

    public void deleteById(int theId);
    public InstructorDetail findInstructorDetailById(int theId);
    public void deleteInstructorDetailById(int theId);
    public List<Course> findCourseInstructorById(int theId);

    public Instructor findCourseInstructorByIdJoinFetch(int theId);


    void update(Instructor instructor);
    void updateCourse(Course course);
    Course findCourseById(int theId);
    void deleteInstructorById(int theId);
    void deleteCourseById(int theId);

    void save(Course theCourse);
    Course findCourseReviewByCourseId(int theId);
    Course findCourseAndStudentByCourseId(int theId);
    Student findCourseAndStudentByStudentId(int theId);
    void update(Student theStudent);

    void deleteStudentById(int theId);
}
