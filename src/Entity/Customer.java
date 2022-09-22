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

    public String setCustomerName(String customerName) {
        this.customerName = customerName;
        return customerName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public int setPostalCode(int postalCode) {
        this.postalCode = postalCode;
        return postalCode;
    }

    public String getAddress() {
        return Address;
    }

    public String setAddress(String address) {
        Address = address;
        return address;
    }

    @Override
    public String toString() {
        return "Customer {" +
                "customerID = " + customerID +
                ", customerName = '" + customerName + '\'' +
                ", postalCode = " + postalCode +
                ", Address = '" + Address + '\'' +
                '}';
    }
}
