package com.niladri.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.niladri.spring.data.jpa.entity.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	public List<Student> findByFirstName(String firstName);
	List<Student> findByFirstNameContaining(String name);
	List<Student> findByLastNameNotNull();
	List<Student> findByGuardianName(String guardianName);
	
	//JPQL BASED ON CLASSES CREATED NOT ON THE DB
	@Query("select s from Student s where s.emailId = ?1")
	Student getStudentByEmailAddress(String emailId);
	
	//Native query
	@Query(value = "select * from tbl_student s where s.email_address = ?1 ",
			nativeQuery = true)
	Student getStudentByEmailAddressNative(String emailId);
	
	//Native named Param
		@Query(value = "select * from tbl_student s where s.email_address = :emailId ",
				nativeQuery = true)
		Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

		@Modifying
		@Transactional 
		@Query(value="update tbl_Student set first_name = ?1 where email_address = ?2",
				nativeQuery = true)
		int updateStudentNameByEmaidId(String firstName,String emailId);
}
