// Step 1: Repository Interface
interface CustomerRepository {
    String findCustomerById(int id);
}

// Step 2: Concrete Repository Implementation
class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(int id) {
        // Simulate database fetch
        if (id == 1) return "Alice (ID: 1)";
        else if (id == 2) return "Bob (ID: 2)";
        else return "Customer not found (ID: " + id + ")";
    }
}

// Step 3: Service Class that depends on the Repository
class CustomerService {
    private CustomerRepository customerRepository;

    // Step 5: Constructor-based Dependency Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void displayCustomer(int id) {
        String customer = customerRepository.findCustomerById(id);
        System.out.println("Customer Info: " + customer);
    }
}

// Step 6: Main class to test Dependency Injection
public class DependencyInjectionExample {
    public static void main(String[] args) {
        // Create the repository
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject repository into service
        CustomerService service = new CustomerService(repository);

        // Use the service to fetch customers
        service.displayCustomer(1);  // Should return Alice
        service.displayCustomer(2);  // Should return Bob
        service.displayCustomer(3);  // Not found
    }
}
