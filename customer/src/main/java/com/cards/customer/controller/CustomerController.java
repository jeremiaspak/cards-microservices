package com.cards.customer.controller;

import com.cards.customer.dto.CreateCustomerRequest;
import com.cards.customer.dto.CreateCustomerResponse;
import com.cards.customer.dto.GetCustomerResponse;
import com.cards.customer.entity.Customer;
import com.cards.customer.mapper.CustomerMapper;
import com.cards.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping
  public Iterable<GetCustomerResponse> findAll() {
    return CustomerMapper.INSTANCE.customerToGetCustomerResponse(customerService.findAll());
  }

  @GetMapping("/{id}")
  public GetCustomerResponse getById(@PathVariable Long id) {
    return CustomerMapper.INSTANCE.customerToGetCustomerResponse(
      customerService.getById(id)
    );
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CreateCustomerResponse create(@Valid @RequestBody CreateCustomerRequest customerRequest) {
    Customer customer = customerService.create(
      CustomerMapper.INSTANCE.createCustomerRequestToCustomer(customerRequest)
    );
    return CustomerMapper.INSTANCE.customerToCreateCustomerResponse(customer);
  }
}
