package FirstClassFunctions;

public class CustomerAddress implements Function1<Customer, String> {

    @Override
    public String call(Customer in1) {
        return in1.address;
    }
}
