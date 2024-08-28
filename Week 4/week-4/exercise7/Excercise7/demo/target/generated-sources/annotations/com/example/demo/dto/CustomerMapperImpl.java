package com.example.demo.dto;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-20T19:59:27+0530",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240725-1906, environment: Java 17.0.11 (Eclipse Adoptium)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO customerToCustomerDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setEmail( customer.getEmail() );
        customerDTO.setId( customer.getId() );

        return customerDTO;
    }

    @Override
    public Customer customerDTOToCustomer(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setEmail( customerDTO.getEmail() );
        customer.setId( customerDTO.getId() );

        return customer;
    }
}
