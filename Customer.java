package java_project;

public class Customer {
    private String phone_number_;
    private String name_;
    private String adress_;
    private String cost_;
    
    public Customer()
    {
        phone_number_ = "";
        name_ = "";
        adress_ = "";
        cost_ = "";
    }
    
    public Customer(String phone_number, String name, String adress, int cost) {
        phone_number_ = phone_number;
        name_ = name;
        adress_ = adress;
        cost_ = cost;
    }
    
    public String getNumber() {
        return phone_number_;
    }
    public String getName() {
        return name_;
    }
    public String getAdress() {
        return adress_;
    }
    public double getCost() {
        return cost_;
    }
    
    public void setNumber(String phone_number) {
       phone_number_ = phone_number; 
    }
    public void setName(String name) {
       name_ = name; 
    }
    public void setAdress(String adress) {
       adress_ = adress; 
    }
    public void setCost(String cost) {
       cost_ = cost; 
    }
    
    public void print() {
        System.out.println(" Name of the customer: " + name_);
        System.out.println(" Phone number: " + phone_number_);       
        System.out.println(" Customer's address: " + adress_);
        System.out.println(" Cost of the phone talking: " + cost_);
    }
}
