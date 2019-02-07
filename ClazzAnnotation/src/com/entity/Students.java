package com.entity;

import java.util.Date;

import javax.persistence.Entity; /*JPA ×¢½â*/
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_students", schema="hibernate")
public class Students {
	private int sid;
	private String snameString;
	private String gender;
	private Date birthday;
	private String majorString;
	private Address address;
	
	public Students () {
		
	}

	public Students(int sid, String snameString, String gender, Date birthday, String majorString, Address address) {
		super();
		this.sid = sid;
		this.snameString = snameString;
		this.gender = gender;
		this.birthday = birthday;
		this.majorString = majorString;
		this.address = address;
	}
	
	@Id
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSnameString() {
		return snameString;
	}

	public void setSnameString(String snameString) {
		this.snameString = snameString;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMajorString() {
		return majorString;
	}

	public void setMajorString(String majorString) {
		this.majorString = majorString;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
