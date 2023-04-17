package com.niladri.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niladri.spring.data.jpa.entity.Teacher;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
