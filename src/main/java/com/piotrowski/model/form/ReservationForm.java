package com.piotrowski.model.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.piotrowski.model.Customer;

public class ReservationForm {

	@NotNull(message = "{reservationForm.notEmpty}")
    @DateTimeFormat(pattern="dd-MM-yyyy")
	private Date fromDate;

	@NotNull(message = "{reservationForm.notEmpty}")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date toDate;

	@NotEmpty(message = "{reservationForm.notEmpty}")
	@Size(min=2,max=15,message="{reservationForm.firstName}")
	private String firstName;
	
	@NotEmpty(message = "{reservationForm.notEmpty}")
	@Size(min=2,max=30,message="{reservationForm.lastName}")
	private String lastName;
	
	@NotEmpty(message = "{reservationForm.notEmpty}")
	private String address;
	
	@NotEmpty(message = "{reservationForm.notEmpty}")
	private String postalCode;

	@NotEmpty(message = "{reservationForm.notEmpty}")
	private String city;

	@NotEmpty(message = "{reservationForm.notEmpty}")
	@Pattern(regexp = "^[0-9]*$", message = "{reservationForm.phone}")
	private String phone;

	@NotEmpty(message = "{reservationForm.notEmpty}")
	@Email(message = "{reservationForm.email}")
	private String email;
	
	private List<Date> breakfastList;
	
	public ReservationForm(){
		breakfastList = new ArrayList<Date>();
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public List<Date> getBreakfastList() {
		return breakfastList;
	}

	public void setBreakfastList(List<Date> breakfastList) {
		this.breakfastList = breakfastList;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customer getCustomer() {
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setPostalCode(postalCode);
		customer.setPhone(phone);
		customer.setEmail(email);
		return customer;
	}	
}
