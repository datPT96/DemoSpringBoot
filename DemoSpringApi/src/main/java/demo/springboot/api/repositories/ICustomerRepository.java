package demo.springboot.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.springboot.api.models.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}
