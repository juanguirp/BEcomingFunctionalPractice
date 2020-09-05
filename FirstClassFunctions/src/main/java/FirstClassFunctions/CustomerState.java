package FirstClassFunctions;

public class CustomerState implements Function1<Customer, String> {
    @Override
    public String call(Customer in1) {
        return in1.state;
    }
}
