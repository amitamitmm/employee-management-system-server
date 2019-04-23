package com.aptota.beans;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_TAB")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String firstName;
	private String lastName;
	private Date doj;
	private Date dob;
	private String gender;
	private String job;
	private double salary;
	private String email;
	private String mobileNumber;
	public Employee() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getFirstLastName() {
		return getFirstName()+" "+getLastName();
	}
	
	@Override
	public String toString() {
		return "ID : "+getId()+", Name :  "+getFirstLastName();
	}
	
	public static Employee getSampleEmployee() {
		Employee employee = new Employee();
		employee.setId(1001);
		employee.setFirstName("Amit");
		employee.setLastName("Choudhary");
		employee.setEmail("aptota@outlook.com");
		employee.setGender("Male");
		employee.setJob("Solution Architech");
		employee.setMobileNumber("9971888441");
		employee.setSalary(7800);
		Calendar calendar = Calendar.getInstance();
		calendar.set(2019, 2, 20);
		employee.setDoj(calendar.getTime());
		calendar.set(1990, 10, 25);
		employee.setDob(calendar.getTime());
		return employee;		
	}
}
