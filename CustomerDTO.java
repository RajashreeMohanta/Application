package com.salonservice.entity;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerDTO {

	private Integer id;

	@NotNull(message = "Name cannot be null")
	@Size(min = 3, message = "Customer name should be of min 3 chars")
	private String name;
	@Email(message = "Email should be valid")
	private String email;
	@Size(min = 8, message = "Password should have min 8 chars")
	private String password;
    @Pattern(regexp = "^[0-9]{10}$",message = "Contact number must be of 10 digits")
  	private String contactNo;
    
    private LocalDate dob;
	
	public CustomerDTO() {
		super();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public CustomerDTO(Integer id, String name, String password, String contactNo, String email, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.contactNo = contactNo;
		this.email = email;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


}


