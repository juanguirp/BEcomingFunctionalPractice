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
	
	public static List<String> getEnabledCustomersNames(){
		ArrayList<String> outList = new ArrayList<String>();
		for(Customer customer : Customer.allCustomers) {
			if(customer.enabled){
				outList.add(customer.name);
			}
		}
		return outList;
	}
	
	public static List<String> getEnabledCustomersStates(){
		ArrayList<String> outList = new ArrayList<String>();
		for(Customer customer : Customer.allCustomers) {
			if(customer.enabled){
				outList.add(customer.state);
			}
		}
		return outList;
	}
	
	public static List<String> getEnabledCustomersPrimaryContacts(){
		ArrayList<String> outList = new ArrayList<String>();
		for(Customer customer : Customer.allCustomers) {
			if(customer.enabled){
				outList.add(customer.primaryContact);
			}
		}
		return outList;
	}
	
	public static List<String> getEnabledCustomersDomains(){
		ArrayList<String> outList = new ArrayList<String>();
		for(Customer customer : Customer.allCustomers) {
			if(customer.enabled){
				outList.add(customer.domain);
			}
		}
		return outList;
	}
	
	public static void main(String[] args){
		System.out.println("Added no much beautiful example code into the class.");
	}
}
