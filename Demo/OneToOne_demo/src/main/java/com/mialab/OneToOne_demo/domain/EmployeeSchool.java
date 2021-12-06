package com.mialab.OneToOne_demo.domain;

import java.io.Serializable;

public class EmployeeSchool implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String emp_id;
	private String emp_xueli;
	private String emp_major;
	private String by_date;
	private String by_school;
	
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_xueli() {
		return emp_xueli;
	}
	public void setEmp_xueli(String emp_xueli) {
		this.emp_xueli = emp_xueli;
	}
	public String getEmp_major() {
		return emp_major;
	}
	public void setEmp_major(String emp_major) {
		this.emp_major = emp_major;
	}
	public String getBy_date() {
		return by_date;
	}
	public void setBy_date(String by_date) {
		this.by_date = by_date;
	}
	public String getBy_school() {
		return by_school;
	}
	public void setBy_school(String by_school) {
		this.by_school = by_school;
	}

	@Override
	public String toString() {
		return "EmployeeSchool [emp_id=" + emp_id + ", emp_xueli=" + emp_xueli + ", emp_major=" + emp_major
				+ ", by_date=" + by_date + ", by_school=" + by_school + "]";
	}
}
