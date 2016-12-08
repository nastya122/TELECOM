package java_project;
import java.util.ArrayList;
public class CustomerBase{
    private int phone_number_;
    private String name_;
    private String adress_;
    
    public CustomerBase(ArrayList<Customer> customers_) {
       customers = customers_;
    }
   public CustomerBase(int phone_number, String name, String adress, int cost) {
        phone_number_ = phone_number;
        name_ = name;
        adress_ = adress;
        cost_ = cost;
    }
   private ArrayList<CustomerBase> customers = new ArrayList<CustomerBase>();
   
   FileWorker basecustom = new FileWorker();
   
   public void writebase{
     basecustom.writeCustomers(); 
   }
   
   public void addbase{
   basecustom.addNumber();}
   
   public void readbase{
    basecustom.readCustomers();
    customers.add(basecustom);
   }
   public void viewbase{
   basecustom.viewCustomers();}
   
   public void editbase{
   basecustom.editNumber();}
   
   public void deletebase(){
   basecustom.deleteCustomer();}
   
   public void searchbase(){
   basecustom.searchNumber();  
   }
}
