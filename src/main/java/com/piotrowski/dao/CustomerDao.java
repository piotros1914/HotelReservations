package com.piotrowski.dao;

import java.util.List;
import com.piotrowski.model.Customer;


public interface CustomerDao {

	public void addCustomer(Customer user);
	
	public Customer addCustomerAndReturnWithId(Customer customer);

	public List<Customer> listCustomers();

	public Customer getCustomer(int id);

	public void deleteCustomer(Customer customer);
}