package com.niladri.spring.data.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import lombok.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.niladri.spring.data.jpa.entity.Guardian;
import com.niladri.spring.data.jpa.entity.Student;


@SpringBootTest

class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		Student student = Student.builder()
				.emailId("bitnil156@gmail.com")
				.firstName("niladri")
				.lastName("bit")
//				.guardianName("abc")
//				.guardianEmail("a@s.com")
//				.guardianMobile("8878788778")
				.build();
		studentRepository.save(student);
	}
	
	@Test
	public void saveStudentWithGuardian() {
		Guardian guardian = Guardian.builder()
				.email("baha@s.com")
				.name("bshs")
				.mobile("9287398222")
				.build();
		Student student = Student.builder()
				.firstName("nil")
				.emailId("bit@nh2.com")
				.lastName("dhe")
				.guardian(guardian)
				.build();
		studentRepository.save(student);
	}
	
	@Test
	public void printStudentByFirstName() {
		List<Student> students=
				studentRepository.findByFirstName("nil");
		System.out.println("student = " + students);
	}
	
	@Test
	public void printStudentByFirstNameContaining() {
		List<Student> students=
				studentRepository.findByFirstNameContaining("nila");
		System.out.println("student = " + students);
	}
	
	@Test
	public void printStudentBasedOnGuardianName() {
		List<Student> students=
				studentRepository.findByGuardianName("abc");
		System.out.println("student = " + students);
	}
	@Test
	public void printgetStudentByEmailAddress() {
		Student students=
				studentRepository.getStudentByEmailAddress("bit@nh1.com");
		System.out.println("student = " + students);
	}
	
	@Test
	public void printgetStudentByEmailAddressNative() {
		Student students=
				studentRepository.getStudentByEmailAddressNative("bit@nh1.com");
		System.out.println("student = " + students);
	}
	
	@Test
	public void printgetStudentByEmailAddressNativeNamedParam() {
		Student students=
				studentRepository.getStudentByEmailAddressNativeNamedParam("bit@nh1.com");
		System.out.println("student1 = " + students);
	}
	
	@Test
	public void updateStudentByEmailId() {
		
				studentRepository.updateStudentNameByEmaidId("Neeladri","bitnil155@gmail.com");
		
	}
}
