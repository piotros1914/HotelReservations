package com.piotrowski.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.piotrowski.dao.CustomerDao;
import com.piotrowski.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addCustomer(Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
		
	}
	
	@Override
	public Customer addCustomerAndReturnWithId(Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
		return customer;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> listCustomers() {
		return (List<Customer>) sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
	}

	@Override
	public Customer getCustomer(int id) {
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM User WHERE id = " + customer.getId())
				.executeUpdate();

	}
}