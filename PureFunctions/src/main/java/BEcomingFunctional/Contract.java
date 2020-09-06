package BEcomingFunctional;

import java.util.Calendar;

public class Contract {
    public Calendar begin_date;
    public Calendar end_date;
    public Boolean enabled = true;

    public Contract(Calendar begin_date){
        this.begin_date = begin_date;
        this.end_date = Calendar.getInstance();
        this.end_date.setTimeInMillis(this.begin_date.getTimeInMillis());
        this.end_date.add(Calendar.YEAR, 2);
    }

    public static void setContractDisabledForCustomers(Integer customer_id){
        for (Customer customer : Customer.getCustomerById(customer_id)) {
            customer.contract.enabled = false;
        }
    }

    public static void setContractEnabledForCustomers(Integer customer_id){
        for (Customer customer : Customer.getCustomerById(customer_id)) {
                customer.contract.enabled = true;
        }
    }

}
