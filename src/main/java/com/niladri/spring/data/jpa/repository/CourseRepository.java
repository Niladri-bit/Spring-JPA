package com.niladri.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niladri.spring.data.jpa.entity.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
