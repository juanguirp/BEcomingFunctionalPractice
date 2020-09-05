package FirstClassFunctions;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	static public ArrayList<Customer> allCustomers = new ArrayList<Customer>();
	public Integer id = 0;
	public String name = "";
	public String address = "";
	public String state = "";
	public String primaryContact = "";
	public String domain = "";
	public Boolean enabled = true;
	
	public Customer(){}

	public static <B> List<B> getEnabledCustomerField(
			Function1<Customer, B> function
	){
		ArrayList<B> outList = new ArrayList<>();
		for(Customer customer : Customer.allCustomers){
			if(customer.enabled){
				outList.add(function.call(customer));
			}
		}
		return outList;
	}

	public static List<String> getEnabledCustomersAddress(){
		return Customer.getEnabledCustomerField(new CustomerAddress());
	}
	
	public static List<String> getEnabledCustomersNames(){
		return Customer.getEnabledCustomerField(new CustomerName());
	}
	
	public static List<String> getEnabledCustomersStates(){
		return Customer.getEnabledCustomerField(new CustomerState());
	}
	
	public static List<String> getEnabledCustomersPrimaryContacts(){
		return Customer.getEnabledCustomerField(new CustomerPrimaryContact());
	}
	
	public static List<String> getEnabledCustomersDomains(){
		return Customer.getEnabledCustomerField(new CustomerDomain());
	}

	public static List<Customer> getEnabledCustomers(){
		return Customer.getEnabledCustomerField(new CustomerAsCustomer());
	}
	
	public static void main(String[] args){
		System.out.println("Added no much beautiful example code into the class.");
	}
}
