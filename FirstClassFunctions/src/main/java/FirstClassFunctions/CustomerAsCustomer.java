package FirstClassFunctions;

public class CustomerAsCustomer implements Function1<Customer, Customer> {
    @Override
    public Customer call(Customer in1) {
        return in1;
    }
}
