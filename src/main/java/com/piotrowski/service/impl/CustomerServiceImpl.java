package com.piotrowski.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.piotrowski.dao.CustomerDao;
import com.piotrowski.model.Customer;
import com.piotrowski.service.CustomerService;

@Service("customerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	@Override
	public List<Customer> listCustomers() {
		return customerDao.listCustomers();
	}

	@Override
	public Customer getCustomer(int id) {
		return customerDao.getCustomer(id);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
	}
}
