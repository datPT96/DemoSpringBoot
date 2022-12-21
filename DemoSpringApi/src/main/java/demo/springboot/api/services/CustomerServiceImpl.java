package demo.springboot.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.springboot.api.models.Customer;
import demo.springboot.api.repositories.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> list = customerRepository.findAll();
		return list;
	}

	@Override
	public Optional<Customer> getCustomerById(int id) {
		Optional<Customer> customer = customerRepository.findById(id);
		return customer;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(int id, Customer customer) {
		Optional<Customer> customerUpdate = customerRepository.findById(id);
		customerUpdate.get().setFirstName(customer.getFirstName());
		customerUpdate.get().setLastName(customer.getLastName());
		customerUpdate.get().setEmail(customer.getEmail());
		customerUpdate.get().setActive(customer.isActive());
		return customerRepository.save(customerUpdate.get());
	}

	@Override
	public boolean deleteCustomer(int id) {
		Optional<Customer> list = customerRepository.findById(id);
		if (list != null) {
			customerRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
