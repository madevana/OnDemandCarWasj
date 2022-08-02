package com.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="washer")
public class Washer {
	@Id
	private int id;
	@NotNull(message = " name should not be empty")
	@Size(min = 2, message = "Username should not be less than 2 characters")
	private String name;
	@NotNull(message = "location should not be empty")
	
	private String location;
	
	@NotNull(message = "Password should not be empty")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password Should contain:\n1)a digit must occur at least once\n 2)a lower case letter must occur at least once\n\r\n 3)an upper case letter must occur at least once\n4)a special character must occur at least once\n\r\n5)no whitespace allowed in the entire string\n6)at least 8 characters")
	private String password;

	public Washer(int id,
			@NotNull(message = " name should not be empty") @Size(min = 2, message = "Username should not be less than 2 characters") String name,
			@NotNull(message = "location should not be empty") String location,
			@NotNull(message = "Password should not be empty") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password Should contain:\n1)a digit must occur at least once\n 2)a lower case letter must occur at least once\n\r\n 3)an upper case letter must occur at least once\n4)a special character must occur at least once\n\r\n5)no whitespace allowed in the entire string\n6)at least 8 characters") String password) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.password = password;
	}

	public Washer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Washer [id=" + id + ", name=" + name + ", location=" + location + ", password=" + password + "]";
	}

	public Integer id() {
		// TODO Auto-generated method stub
		return null;
	}


	

	

}
