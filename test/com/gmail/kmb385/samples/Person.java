package com.gmail.kmb385.samples;

import java.util.Date;

import com.gmail.kmb385.annotations.Column;
import com.gmail.kmb385.annotations.PrimaryKey;
import com.gmail.kmb385.annotations.Table;

@Table(name="PERSON")
public class Person {
	
	@PrimaryKey
	@Column(name="PERSON_ID")
	int personId;
	
	@Column(name="FIRST_NAME")
	String firstName;
	
	@Column(name="LAST_NAME")
	String lastName;
	
	@Column(name="AGE")
	int age;
	
	@Column(name="DATE_OF_BIRTH")
	Date dateOfBirth;
	
	@Column(name="CREATED_DT")
	Date createdDt;
	
	@Column(name="CREATED_BY")
	String createdBy;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
