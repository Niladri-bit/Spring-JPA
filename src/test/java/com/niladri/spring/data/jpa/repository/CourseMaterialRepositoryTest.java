package com.niladri.spring.data.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.niladri.spring.data.jpa.entity.Course;
import com.niladri.spring.data.jpa.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository repository;

	@Test
	public void SaveCourseMaterial() {
		Course course = 
				Course.builder()
				.title("DSA")
				.credit(6)
				.build();
		
		CourseMaterial courseMaterial = 
				CourseMaterial.builder()
				.url("www.google.com.course")
				.course(course)
				.build();
		repository.save(courseMaterial);
	}
	
	@Test
	public void printAllCourseMaterial() {
		List<CourseMaterial> courseMaterials = 
				repository.findAll();
		System.out.println("CourseMaterial = " + courseMaterials);
	}
}
