package java_project;

public class Costs {
    private String phone_number_;
    private int cost_;
    
    public Costs(String phone_number, int cost) {
        phone_number_ = phone_number;
        cost_ = cost;
    }
    
    public String getNumber() {
        return phone_number_;
    }
    public double getCost() {
        return cost_;
    }
    
    public void setNumber(String phone_number) {
       phone_number_ = phone_number;
    }
    public void setCost(int cost) {
       cost_ = cost;
    }
    
    public void print() {
        System.out.println(" Quantity: " + phone_number_);
        System.out.println(" Cost of the phone talking: " + cost_);
    }
}
