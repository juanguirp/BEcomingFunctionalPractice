import BEcomingFunctional.Contact
import Contract

class Customer {
    static public ArrayList<Customer> allCustomers = new ArrayList<Customer>()
    public Integer customer_id = 0
    public String name = ""
    public String address = ""
    public String state = ""
    public String primaryContact = ""
    public String domain = ""
    public Boolean enabled = true
    public Contract contract
    public List<Contact> contacts

    Customer() {}

    Customer setCustomerId(Integer customer_id) {
        this.customer_id = customer_id
        return this
    }

    Customer setName(String name) {
        this.name = name
        return this
    }

    Customer setState(String state) {
        this.state = state
        return this
    }

    Customer setDomain(String domain) {
        this.domain = domain
        return this
    }

    Customer setEnabled(Boolean enabled) {
        this.enabled = enabled
        return this
    }

    Customer setContract(Contract contract) {
        this.contract = contract
        return this
    }

    Customer setContacts(Contact contacts){
        this.contacts = contacts
        return this
    }

    static def EnabledCustomer = { customer -> customer.enabled == true }

    static def DisabledCustomer = { customer -> customer.enabled == false }

    static List<String> getDisabledCustomerNames() {
        Customer.allCustomers
                .findAll(DisabledCustomer)
                .collect({ customer -> customer.name })
    }

    static List<String> getEnabledCustomersNames() {
        Customer.allCustomers
                .findAll(EnabledCustomer)
                .collect(customer -> customer.name)
    }

    static void sendEnabledCustomersEmails(String msg){
        Customer.allCustomers.findAll(
                {customer -> customer.enabled && customer.contract.enabled }
        ).each {customer ->
            customer.contacts.findAll {
            contact -> contact.enabled
            }.each {contact -> contact.sendEmail(msg) }}
    }



}