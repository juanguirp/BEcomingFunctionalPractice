import BEcomingFunctional.Contact
import Contract

class Customer {
    static public ArrayList<Customer> allCustomers = new ArrayList<Customer>()

    public final Integer customer_id = 0
    public final String name = ""
    public final String address = ""
    public final String state = ""
    public final String primaryContact = ""
    public final String domain = ""
    public final Boolean enabled = true
    public final Contract contract
    public final List<Contact> contacts

    Customer(
            Integer customer_id,
            String name,
            String address,
            String state,
            String primaryContact,
            String domain,
            Boolean enabled,
            Contract contract,
            List<Contact> contacts) {
        this.customer_id = customer_id
        this.name = name
        this.address = address
        this.state = state
        this.primaryContact = primaryContact
        this.domain = domain
        this.enabled = enabled
        this.contract = contract
        this.contacts = contacts
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

    static void sendEnabledCustomersEmails(String msg) {
        Customer.allCustomers.findAll(
                { customer -> customer.enabled && customer.contract.enabled }
        ).each { customer ->
            customer.contacts.findAll {
                contact -> contact.enabled
            }.each { contact -> contact.sendEmail(msg) }
        }
    }

    static void eachEnabledContact(Closure cls) {
        Customer.allCustomers.findAll
        { customer -> customer.enabled && customer.contract.enabled }
                .each { customer ->
                    customer.contacts.each(cls)
                }
    }

    static List<Customer> updateContractForCustomerList(List<Integer> ids, Closure cls) {
        Customer.allCustomers.collect { customer ->
            if (ids.indexOf(customer.customer_id >= 0)) {
                new Customer(
                        customer.customer_id,
                        customer.name,
                        customer.state,
                        customer.domain,
                        customer.enabled,
                        cls(customer.contract),
                        customer.contacts
                )
            } else {
                customer
            }
        }
    }

    static List<Customer> setContractForCustomerList(List<Integer> ids, Boolean status){
        Customer.updateContractForCustomerList(ids, {
            contract -> new Contract(contract.begin_date, contract.end_date, status)
        })
    }

    static List<Customer> updateContact(Integer customer_id, Integer contact_id, Closure cls){
        updateCustomerByIdList([customer_id],{
            customer -> new Customer(
                    customer.customer_id,
                    customer.name,
                    customer.state,
                    customer.domain,
                    customer.enabled,
                    customer.contract,
                    customer.contacts.collect{contact ->
                        if(contact.contact_id == contact_id){
                            cls(contact)
                        } else {
                            contact
                        }
                    }
            )
        })
    }

    static List<Customer> updateCustomerByIdList(List<Integer> ids, Closure cls){
        Customer.allCustomers.collect{
            customer -> if(ids.indexOf(customer.customer_id) >= 0){
                cls(customer)
            } else {
                customer
            }
        }
    }

    // Todo: trampoline
    public static int countEnabledCustomersWithNoEnabledContacts(
            List<Customer> customers,
            int sum
    ) {
        if(customers.isEmpty()){
            return sum
        } else {
            int addition = (customers.head().enabled && (customers.head().contacts.find(
                    {contact -> contact.enabled}
            ) == null)) ? 1 : 0
            return  countEnabledCustomersWithNoEnabledContacts(customers.tail(), sum + addition)
        }
    }

    @Lazy public volatile List<Contact> enabledContacts = contacts.findAll(contact -> contact.enabled)

}