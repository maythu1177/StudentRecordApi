package com.student.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.student.config.ConfigData;
import com.student.entity.Course;
import com.student.entity.Student;
import com.student.util.CSVHelper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourseDto {

	private Long id;
	private String courseId;
	private String courseName;
	
	private String status;
	private String sector;
	private String courseLevel;
	private String duration;
	private String startDate;
	private String endDate;
	

	private Integer cohortSizeMale;
	private Integer cohortSizeFemale;
	private Integer numberOfApplicantsMale;
	private Integer numberOfApplicantsFemale;
	private Integer numberOfCertifiedMale;
	private Integer numberOfCertifiedFemale;
	
	
	private String batchNo;
	private String trainingLoaction;
	private String trainerNationality;
	private String trainerAffiliation;
	private String trainerId;
	private String cId;
	private String dId;
	private Long totalRecords;
	
	private List<StudentDto> studentList;
	
//	private TrainerDto trainerDto;
//	private StudentDto studentDto;
	
	public Course getEntity() throws ParseException {
		DateFormat df = new SimpleDateFormat(ConfigData.DateFormat);
		Course course = new Course();
		if(this.id != 0 && this.id != null) {
			course.setId(this.id);
		}
		if(CSVHelper.validateDateFormat(this.startDate, ConfigData.DateFormat)) {
			course.setStartDate(df.parse(this.startDate));
		}
		if(CSVHelper.validateDateFormat(this.endDate, ConfigData.DateFormat)) {
			course.setEndDate(df.parse(this.endDate));
		}
		course.setCourseId(this.courseId);
		course.setCourseName(this.courseName);
		
		
		
		course.setStatus(this.status);
		course.setSector(this.sector);
		course.setCourseLevel(this.courseLevel);
		course.setDuration(this.duration);
		course.setBatchNo(this.batchNo);
		course.setTrainingLoaction(this.trainingLoaction);
		course.setTrainerId(this.trainerId);
		course.setCId(this.cId);
		course.setDId(this.dId);
		return course;
	}

	public CourseDto(Course course) {
		if(course != null) {
			DateFormat df = new SimpleDateFormat(ConfigData.DateFormat);
			this.id = course.getId();
			this.courseId = course.getCourseId();
			this.courseName = course.getCourseName();
			this.status = course.getStatus();
			this.sector = course.getSector();
			this.courseLevel = course.getCourseLevel();
			this.duration = course.getDuration();
			this.startDate = course.getStartDate() != null ? df.format(course.getStartDate()) :null;
			this.endDate = course.getEndDate() != null ? df.format(course.getEndDate()) :null;
			
			this.cohortSizeFemale = course.getCohortSizeFemale();
			this.cohortSizeMale = course.getCohortSizeMale();
			
			this.numberOfApplicantsFemale = course.getNumberOfApplicantsFemale();
			this.numberOfApplicantsMale = course.getNumberOfApplicantsMale();
			
			this.numberOfCertifiedFemale = course.getNumberOfCertifiedFemale();
			this.numberOfCertifiedMale = course.getNumberOfCertifiedMale();
			
			
			this.batchNo = course.getBatchNo();
			this.trainingLoaction = course.getTrainingLoaction();
			this.trainerId = course.getTrainerId();
			this.cId = course.getCId();
			this.dId = course.getDId();

		}
	}
	
	
}
