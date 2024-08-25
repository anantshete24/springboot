package com.orm.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="jpa.student")
public class Student {

	
	@Id
	private int studentId;
	private String studentName;
	private String about;
	
	@OneToOne(mappedBy="student", cascade=CascadeType.ALL)
	private Laptop laptop;
	
	@OneToMany(mappedBy="student", cascade=CascadeType.ALL)
	private List<Address> addressList= new ArrayList<>();

	public Student(int studentId, String studentName, String about, Laptop laptop) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.about = about;
		this.laptop = laptop;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public Student() {
		super();

	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	
	
	
	
}
