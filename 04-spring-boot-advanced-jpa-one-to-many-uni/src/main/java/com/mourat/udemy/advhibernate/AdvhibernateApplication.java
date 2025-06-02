package com.mourat.udemy.advhibernate;

import com.mourat.udemy.advhibernate.dao.AppDAO;
import com.mourat.udemy.advhibernate.entity.Course;
import com.mourat.udemy.advhibernate.entity.Instructor;
import com.mourat.udemy.advhibernate.entity.InstructorDetail;
import com.mourat.udemy.advhibernate.entity.Review;
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

			deleteCourse(dao);
		};
	}

	private void retrieveCourse(AppDAO dao){

		int id = 10;

		Course course = dao.findCourseById(id);

		System.out.println(course);
		System.out.println(course.getReviews());
	}

	private void deleteCourse(AppDAO dao) {

		int id = 12;

		Instructor instructor = dao.findInstructorByIdJoinFetch(2);

		System.out.println("Deleteing course with id " + id);

		dao.deleteCourseById(instructor.getCourses().getFirst().getId());

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

}
