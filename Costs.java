package java_project;

public class Costs {
    private int phone_number_;
    private int cost_;
    
    public Costs(int phone_number, int cost) {
        phone_number_ = phone_number;
        cost_ = cost;
    }
    
    public int getNumber() {
        return phone_number_;
    }
    public double getCost() {
        return cost_;
    }
    
    public void setNumber(int phone_number) {
       phone_number_ = phone_number;
    }
    public void setCost(int cost) {
       cost_ = cost;
    }
    
    public void print() {
        System.out.println(" Quantity: " + phone_number_);
        System.out.println(" Cost of the tour: " + cost_);
    }
}
