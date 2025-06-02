package com.mourat.udemy.advhibernate;

import com.mourat.udemy.advhibernate.dao.AppDAO;
import com.mourat.udemy.advhibernate.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdvhibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvhibernateApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO dao){
		return runner -> {
			//createInstructorWithCoursesAndReviews(dao);
			//retrieveCourse(dao);

			createAll(dao);
			
			retrieveCourse(dao);
			retrieveStudent(dao);

			deleteCourse(dao);
			deleteStudent(dao);
			

			//createAll(dao);
			//addCourseToStudent(dao);
			
		};
	}

	private void addCourseToStudent(AppDAO dao) {

		Course course = new Course("c12");

		Student student = dao.findStudentById(2);

		student.addCourse(course);

		dao.updateStudent(student);

		System.out.println("Course " + course.getTitle() + " added to student " + student.getId());
	}

	private void deleteStudent(AppDAO dao) {
		int id = 1;

		System.out.println("Deleting student with id " + id);

		dao.deleteStudentById(id);

		System.out.println("Student has been deleted!");
	}

	private void retrieveStudent(AppDAO dao){

		int id = 1;

		Student student = dao.findStudentById(id);

		System.out.println(student);
		System.out.println(student.getCourses());
	}

	private void retrieveCourse(AppDAO dao){

		int id = 10;

		Course course = dao.findCourseById(id);

		System.out.println(course);
		System.out.println(course.getStudents());
	}

	private void deleteCourse(AppDAO dao) {

		int id = 10;

		System.out.println("Deleting course with id " + id);

		dao.deleteCourseById(id);

		System.out.println("Course has been deleted!");
	}

	private void deleteInstructor(AppDAO dao) {

		int id = 1;

		System.out.println(dao.findInstructorById(id));

		dao.deleteInstructorById(id);

		System.out.println("Instructor with id " + id + " has been deleted!");
		System.out.println(dao.findInstructorById(id));
	}

	private void searchInstructor(AppDAO dao) {

		int id = 3;

		System.out.println(dao.findInstructorById(id));
	}

	private void createInstructor(AppDAO dao) {
/*
		Instructor instructor = new Instructor("Mourat", "Achoi", "m@g.com");

		InstructorDetail detail = new InstructorDetail("youtube", "codding");

 */

		Instructor instructor = new Instructor("Kostas", "Vardakis", "k@g.com");

		InstructorDetail detail = new InstructorDetail("youtube2", "codding2");

		instructor.setDetail(detail);

		dao.saveInstructor(instructor);

		System.out.println("The instructor is saved successfully!");
	}

	private void deleteInstructorDetail(AppDAO dao) {

		int id = 22;

		dao.deleteInstructorDetailById(id);
		System.out.println("Instructor details with id " + id + " have been deleted!");
	}

	private void searchInstructorDetail(AppDAO dao) {

		int id = 22;

		System.out.println(dao.findInstructorDetailById(id));
	}

	private void createInstructorDetail(AppDAO dao) {

		Instructor instructor = new Instructor("Mourat2", "Achoi2", "m@g.com");

		InstructorDetail detail = new InstructorDetail("youtube", "codding");


		Instructor instructor2 = new Instructor("Kostas2", "Vardakis2", "k@g.com");

		InstructorDetail detail2 = new InstructorDetail("youtube2", "codding2");

		detail.setInstructor(instructor);
		instructor.setDetail(detail);

		detail2.setInstructor(instructor2);
		instructor2.setDetail(detail2);

		dao.saveInstructorDetail(detail);
		dao.saveInstructorDetail(detail2);

		System.out.println("The instructor details are saved successfully!");
	}

	private void createInstructorWithCoursesAndReviews(AppDAO dao){
		Instructor instructor = new Instructor("Mourat", "Achoi", "m@g.com");

		InstructorDetail detail = new InstructorDetail("youtube", "codding");


		Instructor instructor2 = new Instructor("Kostas", "Vardakis", "k@g.com");

		InstructorDetail detail2 = new InstructorDetail("youtube", "codding");

		detail.setInstructor(instructor);
		instructor.setDetail(detail);

		detail2.setInstructor(instructor2);
		instructor2.setDetail(detail2);

		Course course = new Course("c1");
		course.add(new Review("r11"));
		course.add(new Review("r12"));
		instructor.add(course);

		course = new Course("c2");
		course.add(new Review("r21"));
		course.add(new Review("r22"));
		instructor.add(course);

		course = new Course("c3");
		course.add(new Review("r31"));
		course.add(new Review("r32"));
		instructor2.add(course);

		course = new Course("c4");
		course.add(new Review("r41"));
		course.add(new Review("r42"));
		instructor2.add(course);

		dao.saveInstructor(instructor);
		dao.saveInstructor(instructor2);

		System.out.println("The instructors are saved successfully!");
	}

	private void findInstructorWithCourses(AppDAO dao){

		int id = 1;

		Instructor instructor = dao.findInstructorByIdJoinFetch(id);

		System.out.println(instructor);

		System.out.println(instructor.getCourses());
	}

	private void updateInstructor(AppDAO dao){

		int id = 1;

		Instructor instructor = dao.findInstructorById(id);

		System.out.println(instructor);

		instructor.setEmail("mayrit@gmail.com");

		dao.update(instructor);

		System.out.println("Update complete: " + instructor);
	}

	private void createAll(AppDAO dao){
		Instructor instructor = new Instructor("Mourat", "Achoi", "m@g.com");

		InstructorDetail detail = new InstructorDetail("youtube", "codding");


		Instructor instructor2 = new Instructor("Kostas", "Vardakis", "k@g.com");

		InstructorDetail detail2 = new InstructorDetail("youtube", "codding");

		detail.setInstructor(instructor);
		instructor.setDetail(detail);

		detail2.setInstructor(instructor2);
		instructor2.setDetail(detail2);

		Course course;
		Student student1, student2;
		student1 = new Student("mourat", "achoi", "m@g.com");
		student2 = new Student("kostas", "vardakis", "kv@g.com");

		course = new Course("c1");
		course.add(new Review("r11"));
		course.add(new Review("r12"));
		course.addStudent(student1);
		course.addStudent(student2);
		instructor.add(course);

		course = new Course("c2");
		course.add(new Review("r21"));
		course.add(new Review("r22"));
		course.addStudent(student1);
		instructor.add(course);

		dao.saveInstructor(instructor);

		//student1 = new Student("mourat", "achoi", "m@g.com");
		//student2 = new Student("kostas", "vardakis", "kv@g.com");

		course = new Course("c3");
		course.add(new Review("r31"));
		course.add(new Review("r32"));
		course.addStudent(student2);
		instructor2.add(course);

		course = new Course("c4");
		course.add(new Review("r41"));
		course.add(new Review("r42"));
		course.addStudent(student1);
		course.addStudent(student2);
		instructor2.add(course);


		dao.saveInstructor(instructor2);

		System.out.println("Everything saved successfully!");
	}


}
