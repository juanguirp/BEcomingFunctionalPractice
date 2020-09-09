import Customer

class Contract {

    public final Calendar begin_date
    public final Calendar end_date
    public final Boolean enabled = true

    Contract(Calendar begin_date) {
        this.begin_date = begin_date
        this.end_date = Calendar.getInstance()
        this.end_date.setTimeInMillis(this.begin_date.getTimeInMillis())
        this.end_date.add(Calendar.YEAR, 2)
    }

    Contract(
            Calendar begin_date,
            Calendar end_date,
            Boolean enabled
    ) {
        this.begin_date = begin_date
        this.end_date = end_date
        this.enabled = enabled
    }

    def setContractForCustomer(Integer customerId) {
        Customer.allCustomers
                .findAll({ customer -> customer.customer_id == customerId })
                .collect({ customer -> customer.contract.setEnabled(false) })
                .each({ contract -> println contract })
    }

}