package com.piotrowski.service;

import java.util.List;

import com.piotrowski.model.Customer;

public interface CustomerService {
 
 public void addCustomer(Customer customer);

 public List<Customer> listCustomers();
 
 public Customer getCustomer(int id);
 
 public void deleteCustomer(Customer customer);
}