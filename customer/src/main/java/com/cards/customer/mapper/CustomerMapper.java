package com.cards.customer.mapper;

import com.cards.customer.dto.CreateCustomerRequest;
import com.cards.customer.dto.CreateCustomerResponse;
import com.cards.customer.dto.GetCustomerResponse;
import com.cards.customer.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

  CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

  GetCustomerResponse customerToGetCustomerResponse(Customer customer);
  Iterable<GetCustomerResponse> customerToGetCustomerResponse(Iterable<Customer> customers);

  Customer createCustomerRequestToCustomer(CreateCustomerRequest createCustomerRequest);
  CreateCustomerResponse customerToCreateCustomerResponse(Customer customer);
}
