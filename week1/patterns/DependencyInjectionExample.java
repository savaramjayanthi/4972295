
public class DependencyInjectionExample {

    public static void main(String[] args) {
      
        CustomerRepository repository = new CustomerRepositoryImpl();

        CustomerService service = new CustomerService(repository);

        Customer customer = service.findCustomerById(1);
        if (customer != null) {
            System.out.println("Customer found: " + customer.getName());
        } else {
            System.out.println("Customer not found.");
        }
    }
}

interface CustomerRepository {
    Customer findCustomerById(int id);
}

class CustomerRepositoryImpl implements CustomerRepository {
  
    public Customer findCustomerById(int id) {
       
        if (id == 1) {
            return new Customer(1, "John Doe");
        }
        return null;
    }
}

class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findCustomerById(int id) {
        return customerRepository.findCustomerById(id);
    }
}

class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

