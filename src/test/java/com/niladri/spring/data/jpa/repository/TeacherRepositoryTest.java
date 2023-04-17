package com.niladri.spring.data.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.niladri.spring.data.jpa.entity.Course;
import com.niladri.spring.data.jpa.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Test
	public void saveTeacher() {
		Course courseCS = Course.builder()
				.title("CS")
				.credit(5)
				.build();
		Course courseJava = Course.builder()
				.title("Java")
				.credit(4)
				.build();
		Teacher teacher =
				Teacher.builder()
				.firstName("imran")
				.lastName("khan")
				//.courses(List.of(courseCS,courseJava))
				.build();
		teacherRepository.save(teacher);
	}
	

}
