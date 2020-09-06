import Customer

class Contract {

    public Calendar begin_date
    public Calendar end_date
    public Boolean enabled = true

    Contract(Calendar begin_date) {
        this.begin_date = begin_date
        this.end_date = Calendar.getInstance()
        this.end_date.setTimeInMillis(this.begin_date.getTimeInMillis())
        this.end_date.add(Calendar.YEAR, 2)
    }

    def setContractForCustomer(Integer customerId) {
        Customer.allCustomers
                .findAll({ customer -> customer.customer_id == customerId })
                .collect({ customer -> customer.contract.setEnabled(false) })
                .each({ contract -> println contract })
    }

    Contract setBegin_date(Calendar begin_date) {
        this.begin_date = begin_date
        return this
    }

    Contract setEnd_date(Calendar end_date) {
        this.end_date = end_date
        return this
    }

    Contract setEnabled(Boolean enabled) {
        this.enabled = enabled
        return this
    }

}