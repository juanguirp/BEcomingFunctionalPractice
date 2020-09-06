package BEcomingFunctional;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    public static final Function1<Customer, Boolean> EnabledCustomers = new Function1<Customer, Boolean>() {
        @Override
        public Boolean call(Customer in1) {
            return in1.enabled;
        }
    };
    public static final Function1<Customer, Boolean> DisabledCustomers = new Function1<Customer, Boolean>() {
        @Override
        public Boolean call(Customer in1) {
            return !in1.enabled;
        }
    };
    static public ArrayList<Customer> allCustomers = new ArrayList<Customer>();
    public Integer id = 0;
    public String name = "";
    public String address = "";
    public String state = "";
    public String primaryContact = "";
    public String domain = "";
    public Boolean enabled = true;
    public Contract contract;

    public Customer() {
    }

    public static <B> List<B> getField(
            Function1<Customer, Boolean> test,
            Function1<Customer, B> function
    ) {
        ArrayList<B> outList = new ArrayList<>();
        for (Customer customer : Customer.filter(Customer.allCustomers, test)) {
            if (test.call(customer)) {
                outList.add(function.call(customer));
            }
        }
        return outList;
    }

    public static void foreach(List<Customer> inList, Foreach1<Customer> function){
        for (Customer customer : inList) {
            function.call(customer);
        }
    }

    public static List<Customer> filter(
            List<Customer> inList,
            Function1<Customer, Boolean> test
    ){
        List<Customer> outList = new ArrayList<>();
        for (Customer customer : inList) {
            if(test.call(customer)){
                outList.add(customer);
            }
        }
        return outList;
    }

    public static List<Customer> getCustomerById(
            List<Customer> inList,
            final Integer customer_id
    ){
        return Customer.filter(inList,
                new Function1<Customer, Boolean>() {
            @Override
            public Boolean call(Customer in1) {
                return customer_id == in1.id;
            }
        });
    }

    public static List<String> getDisabledCustomerNames() {
        return Customer.getField(
                Customer.DisabledCustomers,
                new Function1<Customer, String>() {
                    @Override
                    public String call(Customer in1) {
                        return in1.name;
                    }
                }
        );
    }

    public static List<String> getEnabledCustomersAddress() {
        return Customer.getField(
                Customer.EnabledCustomers,
                new Function1<Customer, String>() {
                    @Override
                    public String call(Customer in1) {
                        return in1.address;
                    }
                }
        );
    }

    public static List<String> getEnabledCustomersNames() {
        return Customer.getField(
                Customer.EnabledCustomers,
                new Function1<Customer, String>() {
                    @Override
                    public String call(Customer in1) {
                        return in1.name;
                    }
                }
        );
    }

    public static List<String> getEnabledCustomersStates() {
        return Customer.getField(
                Customer.EnabledCustomers,
                new Function1<Customer, String>() {
                    @Override
                    public String call(Customer in1) {
                        return in1.state;
                    }
                }
        );
    }

    public static List<String> getEnabledCustomersPrimaryContacts() {
        return Customer.getField(
                Customer.EnabledCustomers,
                new Function1<Customer, String>() {
                    @Override
                    public String call(Customer in1) {
                        return in1.primaryContact;
                    }
                }
        );
    }

    public static List<String> getEnabledCustomersDomains() {
        return Customer.getField(
                Customer.EnabledCustomers,
                new Function1<Customer, String>() {
                    @Override
                    public String call(Customer in1) {
                        return in1.domain;
                    }
                }
        );
    }

    public static List<Customer> getEnabledCustomers() {
        return Customer.getField(
                Customer.EnabledCustomers,
                new Function1<Customer, Customer>() {
                    @Override
                    public Customer call(Customer in1) {
                        return in1;
                    }
                });
    }

    public static List<String> getEnabledCustomerEmails(final String someone) {
        return Customer.getField(
                Customer.EnabledCustomers,
                new Function1<Customer, String>() {
                    @Override
                    public String call(Customer in1) {
                        return someone + "@" + in1.domain;
                    }
                }
        );
    }

    public Customer setId(Integer id) {
        this.id = id;
        return this;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public Customer setAddress(String address) {
        this.address = address;
        return this;
    }

    public Customer setState(String state) {
        this.state = state;
        return this;
    }

    public Customer setPrimaryContact(String primaryContact) {
        this.primaryContact = primaryContact;
        return this;
    }

    public Customer setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public Customer setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Customer setContract(Contract contract) {
        this.contract = contract;
        return this;
    }
}