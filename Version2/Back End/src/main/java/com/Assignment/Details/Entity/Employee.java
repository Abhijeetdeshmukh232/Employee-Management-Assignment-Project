package com.Assignment.Details.Entity;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 
 * This class will defined employee entity
 *
 */
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Long phoneno;
	private String streetaddress1;
	private String streetaddressline2;
	private String city;
	private String state;
	private String country;
	private Long postalcode;
	private String type;
	
	public Employee() {
		
	}

	public Employee(Long id, String firstName, String lastName, String email, Long phoneno, String streetaddress1,
			String streetaddressline2, String city, String state, String country, Long postalcode, String type) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneno = phoneno;
		this.streetaddress1 = streetaddress1;
		this.streetaddressline2 = streetaddressline2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalcode = postalcode;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
	}

	public String getStreetaddress1() {
		return streetaddress1;
	}

	public void setStreetaddress1(String streetaddress1) {
		this.streetaddress1 = streetaddress1;
	}

	public String getStreetaddressline2() {
		return streetaddressline2;
	}

	public void setStreetaddressline2(String streetaddressline2) {
		this.streetaddressline2 = streetaddressline2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(Long postalcode) {
		this.postalcode = postalcode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
	
}
