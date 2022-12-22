package demo.springboot.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import demo.springboot.api.models.Customer;
import demo.springboot.api.services.ICustomerService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
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

	@DeleteMapping("/customer/delete")
	public boolean deleteCustomer(@RequestParam int id) {
		return customerService.deleteCustomer(id);
	}
}
