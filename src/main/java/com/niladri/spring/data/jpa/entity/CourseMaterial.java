package com.niladri.spring.data.jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {

	@Id
	@SequenceGenerator(
			name="course_material_sequence",
			sequenceName = "course_material_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator="course_material_sequence")
	private Long courseMaterialId;
	private String url;
	
	//CASCADING and FETCH
	// when you add a new teacher ,a new course gets teacher id but to also make it mandatory for a course to have course material 
	@OneToOne(cascade =CascadeType.ALL,
			fetch =FetchType.EAGER,
			optional = false)
	@JoinColumn(
			name = "course_id",
			referencedColumnName = "courseId")
	private Course course;
}
