package com.niladri.spring.data.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

	@Id
	@SequenceGenerator(
			name="course_sequence",
			sequenceName = "course_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator="course_sequence")
	private Long courseId;
	private String title;
	private Integer credit;
	//mapped by course in course material class
	//its already defined by course attribute
	//for bidirectional one to one mapping
	@OneToOne(mappedBy = "course")
	private CourseMaterial courseMaterial;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_id",
				referencedColumnName = "teacherId")
	private Teacher teacher;
	
	//many to many between course and student
	@ManyToMany(cascade = CascadeType.ALL,fetch =FetchType.EAGER)
	@JoinTable(name="student_course_map",
			joinColumns = @JoinColumn(
					name="course_id",
					referencedColumnName = "courseId"),
			inverseJoinColumns = @JoinColumn(
					name="student_id",
					referencedColumnName = "studentId"))
	
	private List<Student> students;
	
	public void addStudents(Student student) {
		if(students == null) students = new ArrayList<>();
		students.add(student);
	}
}
