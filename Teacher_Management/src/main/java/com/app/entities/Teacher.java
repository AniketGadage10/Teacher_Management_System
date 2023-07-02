package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "Teacher")
public class Teacher extends Basentity
{
	@Column(length = 20)
	private String tname;

	@Column(nullable = false)
	private double salary;

	@Column(unique = true)
	private int phoneno;

	@Column(length = 20,nullable=false)
	private String subject;

	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	public Teacher(String tname, double salary, int phoneno, String subject) {
		super();
		this.tname = tname;
		this.salary = salary;
		this.phoneno = phoneno;
		this.subject = subject;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
