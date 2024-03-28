package entity;

public class Customer {
    private String customerID;
    private String customerName;
    private String customerPhone;
    private String customerAddress;
    private String customerEmail;
    private String customerNote;

    public Customer() {
    }

    public Customer(String customerID, String customerName, String customerPhone, String customerAddress,
            String customerEmail, String customerNote) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.customerNote = customerNote;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerNote() {
        return customerNote;
    }

    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
    }

    @Override
    public String toString() {
        return "Customer [customerAddress=" + customerAddress + ", customerEmail=" + customerEmail + ", customerID="
                + customerID + ", customerName=" + customerName + ", customerNote=" + customerNote + ", customerPhone="
                + customerPhone + "]";
    }
}
