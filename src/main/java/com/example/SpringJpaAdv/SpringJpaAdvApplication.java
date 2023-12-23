package com.example.SpringJpaAdv;

import com.example.SpringJpaAdv.DAO.AppDAO;
import com.example.SpringJpaAdv.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringJpaAdvApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaAdvApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//DeleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
			//createInstructorWithCourse(appDAO);
			//findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);
			//updateInstructor(appDAO);
			//updateCourse(appDAO);
			//deleteInstructor(appDAO);
			//deleteCourseByid(appDAO);
			//saveCourseAndReview(appDAO);
			//retrieveCourseAndReviews(appDAO);
			//deleteCourseAndReviews(appDAO);
			//CreateCoursAndStudent(appDAO);
			//findCouseAndStudent(appDAO);
			//findCourseAndStudentwithStudentid(appDAO);
			//addMoreToStudent(appDAO);\
			deleteStudentById(appDAO);


			
		};
	}

	private void deleteStudentById(AppDAO appDAO) {
		Course tempCourse = new Course("Pacman");

		Student tempStudent1 = new Student("chad", "derby", "derby@luv2code.com");
		Student tempStudent2 = new Student("Ranga", "28", "Ranga@in28minutes.com");

		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		System.out.println("Saving Course:"+tempCourse);
		System.out.println("Saving Student"+tempCourse.getStudents());
		appDAO.save(tempCourse);
		int theId=1;
		System.out.println("Deleting student with id:"+theId);
		appDAO.deleteStudentById(theId);
		System.out.println("Done");

	}

	private void addMoreToStudent(AppDAO appDAO) {
		Course tempCourse = new Course("Pacman");

		Student tempStudent1 = new Student("chad", "derby", "derby@luv2code.com");
		Student tempStudent2 = new Student("Ranga", "28", "Ranga@in28minutes.com");

		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		System.out.println("Saving Course:"+tempCourse);
		System.out.println("Saving Student"+tempCourse.getStudents());
		appDAO.save(tempCourse);
		int theId=1;
		Student theStudent =appDAO.findCourseAndStudentByStudentId(theId);

		Course tempCourse1 = new Course("Rubiks");
		Course tempCourse2 = new Course("Driving");

		theStudent.addCourse(tempCourse1);
		theStudent.addCourse(tempCourse2);

		appDAO.update(theStudent);
		System.out.println("Done");
	}

	private void findCourseAndStudentwithStudentid(AppDAO appDAO) {
		Course tempCourse = new Course("Pacman");

		Student tempStudent1 = new Student("chad", "derby", "derby@luv2code.com");
		Student tempStudent2 = new Student("Ranga", "28", "Ranga@in28minutes.com");

		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		System.out.println("Saving Course:"+tempCourse);
		System.out.println("Saving Student"+tempCourse.getStudents());
		appDAO.save(tempCourse);
		int theId=1;
		Student theStudent = appDAO.findCourseAndStudentByStudentId(theId);
		System.out.println("Loaded Student:"+theStudent);
		System.out.println("Courses:"+theStudent.getCourses().size());
		System.out.println("Done");
	}

	private void findCouseAndStudent(AppDAO appDAO) {
		Course tempCourse = new Course("Pacman");

		Student tempStudent1 = new Student("chad", "derby", "derby@luv2code.com");
		Student tempStudent2 = new Student("Ranga", "28", "Ranga@in28minutes.com");

		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		System.out.println("Saving Course:"+tempCourse);
		System.out.println("Saving Student"+tempCourse.getStudents());
		appDAO.save(tempCourse);
		int theId=1;
		Course tempCourse1 = appDAO.findCourseAndStudentByCourseId(theId);
		System.out.println("Loaded Course"+tempCourse1);
		System.out.println("Students:"+tempCourse1.getStudents());
		System.out.println("Done!");
	}

	private void CreateCoursAndStudent(AppDAO appDAO) {
		Course tempCourse = new Course("Pacman");

		Student tempStudent1 = new Student("chad", "derby", "derby@luv2code.com");
		Student tempStudent2 = new Student("Ranga", "28", "Ranga@in28minutes.com");

		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		System.out.println("Saving Course:"+tempCourse);
		System.out.println("Saving Student"+tempCourse.getStudents());
		appDAO.save(tempCourse);
		System.out.println("Done!");

	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("chad", "derby", "derby@luv2code.com");
		Instructor tempInstructor1 = new Instructor("Ranga", "28", "Ranga@in28minutes.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("luv 2 code");
		InstructorDetail tempInstructorDetail1 = new InstructorDetail("In28Minutes");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);


		//create Course
		Course course = new Course("Spring Boot 3");
		Course course1= new Course("Microservices");

		//adding courses to instructor
		tempInstructor.add(course);
		tempInstructor1.add(course1);
		appDAO.save(tempInstructor);
		appDAO.save(tempInstructor1);

		Course tempCourse = new Course("Pacman");
		tempCourse.addReview(new Review("nice"));
		tempCourse.addReview(new Review("good"));
		tempCourse.addReview(new Review("bad"));

		appDAO.save(tempCourse);
		int theId = 3;
		System.out.println("Deleting Course with id:"+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("chad", "derby", "derby@luv2code.com");
		Instructor tempInstructor1 = new Instructor("Ranga", "28", "Ranga@in28minutes.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("luv 2 code");
		InstructorDetail tempInstructorDetail1 = new InstructorDetail("In28Minutes");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);

		//create Course
		Course course = new Course("Spring Boot 3");
		Course course1= new Course("Microservices");

		//adding courses to instructor
		tempInstructor.add(course);
		tempInstructor1.add(course1);
		appDAO.save(tempInstructor);
		appDAO.save(tempInstructor1);

		Course tempCourse = new Course("Pacman");
		tempCourse.addReview(new Review("nice"));
		tempCourse.addReview(new Review("good"));
		tempCourse.addReview(new Review("bad"));

		appDAO.save(tempCourse);
		int theId = 3;
		Course theCourse = appDAO.findCourseReviewByCourseId(theId);
		System.out.println(tempCourse);
		System.out.println("Reviews:"+tempCourse.getReviews().toString());
		System.out.println("done!");
	}

	private void saveCourseAndReview(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("chad", "derby", "derby@luv2code.com");
		Instructor tempInstructor1 = new Instructor("Ranga", "28", "Ranga@in28minutes.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("luv 2 code");
		InstructorDetail tempInstructorDetail1 = new InstructorDetail("In28Minutes");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);

		//create Course
		Course course = new Course("Spring Boot 3");
		Course course1= new Course("Microservices");

		//adding courses to instructor
		tempInstructor.add(course);
		tempInstructor1.add(course1);
		appDAO.save(tempInstructor);
		appDAO.save(tempInstructor1);

		Course tempCourse = new Course("Pacman");
		tempCourse.addReview(new Review("nice"));
		tempCourse.addReview(new Review("good"));
		tempCourse.addReview(new Review("bad"));

		System.out.println("saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		appDAO.save(tempCourse);
		System.out.println("done!");


	}

	private void deleteCourseByid(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("chad", "derby", "derby@luv2code.com");
		Instructor tempInstructor1 = new Instructor("Ranga", "28", "Ranga@in28minutes.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("luv 2 code");
		InstructorDetail tempInstructorDetail1 = new InstructorDetail("In28Minutes");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);

		//create Course
		Course course = new Course("Spring Boot 3");
		Course course1= new Course("Microservices");
		//adding courses to instructor
		tempInstructor.add(course);
		tempInstructor1.add(course1);
		appDAO.save(tempInstructor);
		appDAO.save(tempInstructor1);
		int theId = 1;
		System.out.println("Deleting course id: " +theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done");
	}

	private void deleteInstructor(AppDAO appDAO){
		Instructor tempInstructor = new Instructor("chad", "derby", "derby@luv2code.com");
		Instructor tempInstructor1 = new Instructor("Ranga", "28", "Ranga@in28minutes.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("luv 2 code");
		InstructorDetail tempInstructorDetail1 = new InstructorDetail("In28Minutes");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);

		//create Course
		Course course = new Course("Spring Boot 3");
		Course course1= new Course("Microservices");
		//adding courses to instructor
		tempInstructor.add(course);
		tempInstructor1.add(course1);
		appDAO.save(tempInstructor);
		appDAO.save(tempInstructor1);
		int theId = 1;
		System.out.println("Deleting instructro id: "+theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done!");
	}
	private void updateCourse(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("chad", "derby", "derby@luv2code.com");
		Instructor tempInstructor1 = new Instructor("Ranga", "28", "Ranga@in28minutes.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("luv 2 code");
		InstructorDetail tempInstructorDetail1 = new InstructorDetail("In28Minutes");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);

		//create Course
		Course course = new Course("Spring Boot 3");
		Course course1= new Course("Microservices");
		//adding courses to instructor
		tempInstructor.add(course);
		tempInstructor1.add(course1);
		appDAO.save(tempInstructor);
		appDAO.save(tempInstructor1);
		int theId = 1;
		System.out.println("Finding Course id: " +theId);
		Course tempCourse = appDAO.findCourseById(theId);

		System.out.println("Updating Course id: "+theId);
		tempCourse.setTitle("Enjoy the simple things");//change course data

		appDAO.updateCourse(tempCourse);//Call DAO method to update database

		System.out.println("Done");
	}

	private void updateInstructor(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("chad", "derby", "derby@luv2code.com");
		Instructor tempInstructor1 = new Instructor("Ranga", "28", "Ranga@in28minutes.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("luv 2 code");
		InstructorDetail tempInstructorDetail1 = new InstructorDetail("In28Minutes");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);

		//create Course
		Course course = new Course("Spring Boot 3");
		Course course1= new Course("Microservices");
		//adding courses to instructor
		tempInstructor.add(course);
		tempInstructor1.add(course1);
		appDAO.save(tempInstructor);
		appDAO.save(tempInstructor1);
		int theId = 1;
		System.out.println("Finding instructor id: " +theId);
		Instructor tempInstructor3 = appDAO.findById(theId);

		System.out.println("Updating instructor id: "+theId);
		tempInstructor3.setLastName("Tester");//change instructor's data

		appDAO.update(tempInstructor3);//Call DAO method to update database

		System.out.println("Done");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("chad", "derby", "derby@luv2code.com");
		Instructor tempInstructor1 = new Instructor("Ranga", "28", "Ranga@in28minutes.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("luv 2 code");
		InstructorDetail tempInstructorDetail1 = new InstructorDetail("In28Minutes");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);

		//create Course
		Course course = new Course("Spring Boot 3");
		Course course1= new Course("Microservices");
		//adding courses to instructor
		tempInstructor.add(course);
		tempInstructor1.add(course1);
		appDAO.save(tempInstructor);
		appDAO.save(tempInstructor1);
		int theId= 1;
		//find the instructor
		System.out.println("finding instructor id:" +theId);
		Instructor tempInstructor3 = appDAO.findCourseInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " +tempInstructor);
		System.out.println("the associated courses: " +tempInstructor.getCourses());
		System.out.println("Done" );
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("chad", "derby", "derby@luv2code.com");
		Instructor tempInstructor1 = new Instructor("Ranga", "28", "Ranga@in28minutes.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("luv 2 code");
		InstructorDetail tempInstructorDetail1 = new InstructorDetail("In28Minutes");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);
		int theId=1;

		//create Course
		Course course = new Course("Spring Boot 3");
		Course course1= new Course("Microservices");
		//adding courses to instructor
		tempInstructor.add(course);
		tempInstructor1.add(course1);
		appDAO.save(tempInstructor);
		appDAO.save(tempInstructor1);

		//find the instructor
//since fetch type for courses is lazy this will retrive the instructor without courses
		Instructor tempInstructor3 = appDAO.findById(theId);
		System.out.println("tempInstructor:" + tempInstructor3);

		//find courses for instructor
		List<Course> courses = appDAO.findCourseInstructorById(theId);

		//associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());
	}

	private void createInstructorWithCourse(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("chad", "derby", "derby@luv2code.com");
		Instructor tempInstructor1 = new Instructor("Ranga", "28", "Ranga@in28minutes.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("luv 2 code");
		InstructorDetail tempInstructorDetail1 = new InstructorDetail("In28Minutes");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);
		int theId=1;

		//create Course
		Course course = new Course("Spring Boot 3");
		Course course1= new Course("Microservices");
		//adding courses to instructor
		tempInstructor.add(course);
		tempInstructor1.add(course1);

		System.out.println("Saving Instructor:"+tempInstructor);
		System.out.println("saving course:"+tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Saving Instructor:"+tempInstructor1);
		System.out.println("saving course:"+tempInstructor1.getCourses());
		appDAO.save(tempInstructor1);
		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("chad", "derby", "derby@luv2code.com");
		Instructor tempInstructor1 = new Instructor("Ranga", "28", "Ranga@in28minutes.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("luv 2 code");
		InstructorDetail tempInstructorDetail1 = new InstructorDetail("In28Minutes");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);
		appDAO.save(tempInstructor);
		appDAO.save(tempInstructor1);
		int theId=1;

		System.out.println("Deleted instructor detail with Id:"+theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done");
	}

	private void createInstructor(AppDAO appDAO){
		Instructor tempInstructor = new Instructor("chad", "derby", "derby@luv2code.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("luv 2 code");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor:"+tempInstructor);
		appDAO.save(tempInstructor);
//this will also save details object
//because of cascadeType.All
//In AppDAO, delegated to entityManager.persist(...)

		System.out.println("Done");
	}
	private void findInstructor(AppDAO appDAO){
		Instructor tempInstructor = new Instructor("chad", "derby", "derby@luv2code.com");
		Instructor tempInstructor1 = new Instructor("Ranga", "28", "Ranga@in28minutes.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("luv 2 code");
		InstructorDetail tempInstructorDetail1 = new InstructorDetail("In28Minutes");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);
		appDAO.save(tempInstructor);
		appDAO.save(tempInstructor1);
		int theId=2;

		System.out.println("Finding instructor with Id:" +theId);
		Instructor instructor = appDAO.findById(theId);
		System.out.println("The Instructor: "+instructor);
		System.out.println("Associated Instructor detail:"+instructor.getInstructorDetail());
		System.out.println("Done!");
	}
	public void DeleteInstructor(AppDAO appDAO){
		Instructor tempInstructor = new Instructor("chad", "derby", "derby@luv2code.com");
		Instructor tempInstructor1 = new Instructor("Ranga", "28", "Ranga@in28minutes.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("luv 2 code");
		InstructorDetail tempInstructorDetail1 = new InstructorDetail("In28Minutes");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);
		appDAO.save(tempInstructor);
		appDAO.save(tempInstructor1);
		int theId=2;

		System.out.println("Deleting instructor with id: "+theId);
		appDAO.deleteById(theId);
		System.out.println("Done");
	}
	public void findInstructorDetail(AppDAO appDAO){
		Instructor tempInstructor = new Instructor("chad", "derby", "derby@luv2code.com");
		Instructor tempInstructor1 = new Instructor("Ranga", "28", "Ranga@in28minutes.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("luv 2 code");
		InstructorDetail tempInstructorDetail1 = new InstructorDetail("In28Minutes");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);
		appDAO.save(tempInstructor);
		appDAO.save(tempInstructor1);
		int theId=1;

		System.out.println("Finding instructor detail with Id 2"+theId);
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("Instructor Detail found:"+instructorDetail);
		System.out.println("The associated Instructor:"+instructorDetail.getInstructor());
		System.out.println("Done!");
	}
}

