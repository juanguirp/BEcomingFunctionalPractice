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
		return Customer.getEnabledCustomerField(
				new Function1<Customer, String>() {
					@Override
					public String call(Customer in1) {
						return in1.address;
					}
				}
		);
	}
	
	public static List<String> getEnabledCustomersNames(){
		return Customer.getEnabledCustomerField(
				new Function1<Customer, String>() {
					@Override
					public String call(Customer in1) {
						return in1.name;
					}
				}
		);
	}
	
	public static List<String> getEnabledCustomersStates(){
		return Customer.getEnabledCustomerField(
				new Function1<Customer, String>() {
					@Override
					public String call(Customer in1) {
						return in1.state;
					}
				}
		);
	}
	
	public static List<String> getEnabledCustomersPrimaryContacts(){
		return Customer.getEnabledCustomerField(
				new Function1<Customer, String>() {
					@Override
					public String call(Customer in1) {
						return in1.primaryContact;
					}
				}
		);
	}
	
	public static List<String> getEnabledCustomersDomains(){
		return Customer.getEnabledCustomerField(
				new Function1<Customer, String>() {
					@Override
					public String call(Customer in1) {
						return in1.domain;
					}
				}
		);
	}

	public static List<Customer> getEnabledCustomers(){
		return Customer.getEnabledCustomerField(new Function1<Customer, Customer>() {
			@Override
			public Customer call(Customer in1) {
				return in1;
			}
		});
	}

	public static List<String> getEnabledCustomerEmails(final String someone){
		return Customer.getEnabledCustomerField(
				new Function1<Customer, String>() {
					@Override
					public String call(Customer in1) {
						return someone + "@" + in1.domain;
					}
				}
		);
	}
	
	public static void main(String[] args){
		System.out.println("Added no much beautiful example code into the class.");
	}
}
