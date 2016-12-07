package java_project;

public class Customer {
    private int phone_number_;
    private String name_;
    private String adress_;
    private int cost_;
    
    public Customer(int phone_number, String name, String adress, int cost) {
        phone_number_ = phone_number;
        name_ = name;
        adress_ = adress;
        cost_ = cost;
    }
    
    public int getNumber() {
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
    
    public void setNumber(int phone_number) {
       phone_number_ = phone_number; 
    }
    public void setName(String name) {
       name_ = name; 
    }
    public void setAdress(String adress) {
       adress_ = adress; 
    }
    public void setCost(int cost) {
       cost_ = cost; 
    }
    
    public void print() {
        System.out.println(" Quantity: " + phone_number_);
        System.out.println(" Name of a tour: " + name_);
        System.out.println(" Country of the tour: " + adress_);
        System.out.println(" Cost of the tour: " + cost_);
    }
}