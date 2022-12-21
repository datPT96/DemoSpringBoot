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
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> getCustomerById(int id) {
		return customerRepository.findById(id);
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(int id, Customer customer) {
		Optional<Customer> customerUpdate = customerRepository.findById(id);
		if(customerUpdate.isPresent()){
			customerUpdate.get().setFirstName(customer.getFirstName());
			customerUpdate.get().setLastName(customer.getLastName());
			customerUpdate.get().setEmail(customer.getEmail());
			customerUpdate.get().setActive(customer.isActive());
			return customerRepository.save(customerUpdate.get());
		}
		return null;
	}

	@Override
	public boolean deleteCustomer(int id) {
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isPresent()) {
			customerRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
