package Entity;

public class Customer {

    private int customerID;
    private String customerName;
    private int postalCode;
    private String Address;

    // CONSTRUCTOR - from DB to object
    public Customer(int customerID, String customerName, int postalCode, String address) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.postalCode = postalCode;
        Address = address;
    }


    // CONSTRUCTOR - from object to DB (first time)
    public Customer(String customerName, int postalCode, String address) {
        this.customerName = customerName;
        this.postalCode = postalCode;
        Address = address;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", postalCode=" + postalCode +
                ", Address='" + Address + '\'' +
                '}';
    }
}
