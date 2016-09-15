package com.github.eduzol.domain;

import java.util.Date;
import java.util.List;

public class Schedule {
	
	private Integer instructorId;
	private List<Integer> studentIds;
	private Date sceduleTime;
	
	public Schedule(Integer instructorId, List<Integer> studentIds, Date sceduleTime) {
		super();
		this.instructorId = instructorId;
		this.studentIds = studentIds;
		this.sceduleTime = sceduleTime;
	}
	public Integer getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(Integer instructorId) {
		this.instructorId = instructorId;
	}
	public List<Integer> getStudentIds() {
		return studentIds;
	}
	public void setStudentIds(List<Integer> studentIds) {
		this.studentIds = studentIds;
	}
	public Date getSceduleTime() {
		return sceduleTime;
	}
	public void setSceduleTime(Date sceduleTime) {
		this.sceduleTime = sceduleTime;
	}
	
	
}
