package Entity;

public class Customer {

    private int customerID;
    private String customerName;
    private int postalCode;
    private int Address;

    // CONSTRUCTOR - from DB to object
    public Customer(int customerID, String customerName, int postalCode, int address) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.postalCode = postalCode;
        Address = address;
    }

    // CONSTRUCTOR - from object to DB (first time)
    public Customer(String customerName, int postalCode, int address) {
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

    public int getAddress() {
        return Address;
    }

    public void setAddress(int address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", postalCode=" + postalCode +
                ", Address=" + Address +
                '}';
    }
}
