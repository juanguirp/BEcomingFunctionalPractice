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

    public static void setContractForCustomer(final Boolean status,
                                              Integer customer_id){
        Customer.foreach(
                Customer.getCustomerById(Customer.allCustomers, customer_id),
                new Foreach1<Customer>() {
                    @Override
                    public void call(Customer in1) {
                        in1.contract.enabled = status;
                    }
                }
        );
    }

    public Contract setBegin_date(Calendar begin_date) {
        this.begin_date = begin_date;
        return this;
    }

    public Contract setEnd_date(Calendar end_date) {
        this.end_date = end_date;
        return this;
    }

    public Contract setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }
}
