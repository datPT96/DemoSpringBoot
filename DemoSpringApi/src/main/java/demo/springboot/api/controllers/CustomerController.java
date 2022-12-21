package demo.springboot.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.springboot.api.models.Customer;
import demo.springboot.api.services.ICustomerService;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;

	@GetMapping("/customer/all")
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}

	@GetMapping("/customer")
	public Optional<Customer> getById(@RequestParam int id) {
		return customerService.getCustomerById(id);
	}

	@PostMapping("/customer/add")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}

	@PutMapping("/customer/update")
	public Customer updateCustomer(@RequestParam int id, @RequestBody Customer customer) {
		return customerService.updateCustomer(id, customer);
	}

	@DeleteMapping("/customer/dell")
	public boolean deleteCustomer(@RequestParam int id) {
		return customerService.deleteCustomer(id);
	}
}
