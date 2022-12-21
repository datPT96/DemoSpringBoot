package demo.springboot.api.services;

import java.util.List;
import java.util.Optional;

import demo.springboot.api.models.Customer;

public interface ICustomerService {
	public List<Customer> getAllCustomer();

	public Optional<Customer> getCustomerById(int id);

	public Customer createCustomer(Customer customer);

	public Customer updateCustomer(int id, Customer customer);

	public boolean deleteCustomer(int id);
}
