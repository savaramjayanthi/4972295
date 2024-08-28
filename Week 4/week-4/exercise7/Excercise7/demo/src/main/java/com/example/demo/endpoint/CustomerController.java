package com.example.demo.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // POST /customers (JSON Request Body)
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        if (customer == null) {
            return ResponseEntity.badRequest().build(); // Handling case where customer is null
        }
        Customer savedCustomer = customerRepository.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }

    // POST /customers/register (Form Data)
    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String password) {
        
        if (firstName == null || lastName == null || email == null || password == null) {
            return ResponseEntity.badRequest().build(); // Handling case where required parameters are missing
        }

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setPassword(password);
        
        Customer savedCustomer = customerRepository.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }
}


