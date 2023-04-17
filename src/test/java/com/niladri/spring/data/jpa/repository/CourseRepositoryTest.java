package com.niladri.spring.data.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.niladri.spring.data.jpa.entity.Course;
import com.niladri.spring.data.jpa.entity.Student;
import com.niladri.spring.data.jpa.entity.Teacher;

@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void printCourses() {
		List<Course> courses = 
				courseRepository.findAll();
		System.out.println("Course = " + courses);
	}
	@Test
	public void saveCourseWithTeacher() {
		Teacher teacher = Teacher.builder()
				.firstName("priya")
				.lastName("singh")
				.build();
		Course course = Course.builder()
				.title("python")
				.credit(3)
				.teacher(teacher)
				.build();
		courseRepository.save(course);
	}
	
	@Test
	public void findAllPagination() {
		Pageable firstPageWithThreeRecords =
				PageRequest.of(0, 3);
		Pageable secondPageWithTwoRecords =
				PageRequest.of(1, 2);
		
		List<Course> courses=
				courseRepository.findAll(firstPageWithThreeRecords)
				.getContent();
		Long totalElements=
				courseRepository.findAll(firstPageWithThreeRecords)
				.getTotalElements();
		long totalPages=
				courseRepository.findAll(firstPageWithThreeRecords)
				.getTotalPages();
		System.out.println("courses with 3 records = " + courses);
		System.out.println("total elements" + totalElements);
		System.out.println("total Pages" + totalPages);
	}
	
	@Test
	public void findAllBySorting() {
		Pageable sortByTitle = PageRequest.of(0, 2,Sort.by("title"));
		Pageable sortByCredit = PageRequest.of(0, 2,Sort.by("credit").descending());
	
		List<Course> courses=
				courseRepository.findAll(sortByTitle).getContent();
		System.out.println("courses sorted "+courses);
	}
	
	@Test
	public void saveCourseWithStudentAndTeacher() {
		Teacher teacher = Teacher.builder()
				.firstName("LAZY")
				.lastName("joe")
				.build();
		Student student = Student.builder()
				.firstName("soham")
				.lastName("mohanty")
				.emailId("soham@b.com")
				.build();
		Course course = Course.builder()
				.title("AI")
				.credit(12)
				.teacher(teacher)
				.build();
		course.addStudents(student);
		courseRepository.save(course);
	}

}
