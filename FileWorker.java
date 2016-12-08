package java_project;

import java.io.*;
import java.text.ParseException;
import java.util.*;


public class FileWorker {
    public FileWorker(ArrayList<Customer> customers_, ArrayList<Costs> costs_) {
       customers = customers_;
       costs = costs_;
    }
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private ArrayList<Costs> costs = new ArrayList<Costs>();
    Scanner scan=new Scanner(System.in);

    public void readCustomers() throws FileNotFoundException, ParseException {
        File f = new File("res//Customers.txt");
        Scanner cust_scan = new Scanner(new FileReader(f));
        
        if (f.length()!=0) {
            int s = Integer.parseInt(cust_scan.next());
            for (int i = 0; i < s; i++) {
                String strNumber = cust_scan.next();
                int phone_number = Integer.parseInt(strNumber);
                
                String name = cust_scan.nextLine();
                String adress = cust_scan.nextLine();              

                String strCost = cust_scan.next();
                int cost = Integer.parseInt(strCost);

                Customer c = new Customer(phone_number, name, adress, cost);
                customers.add(c);
            }
        }
    }
    
    public void readCosts() throws FileNotFoundException, ParseException {
        File f = new File("res//Costs.txt");
        Scanner cost_scan = new Scanner(new FileReader(f));
        
        if (f.length()!=0) {
            int s = Integer.parseInt(cost_scan.next());
            for (int i = 0; i < s; i++) {
                String strNumber = cost_scan.next();
                int phone_number = Integer.parseInt(strNumber);

                String strCost = cost_scan.next();
                int cost = Integer.parseInt(strCost);

                Costs c_ = new Costs(phone_number, cost);
                costs.add(c_);
            }
        }
    }

    public void writeCustomers() throws IOException {
            FileWriter fileWriter = new FileWriter("res//Customers.txt");
            Integer size = customers.size();
            fileWriter.write(size.toString() + " ");
            for (int i=0; i<customers.size(); i++) {
                fileWriter.write(customers.get(i).getNumber() + " " + customers.get(i).getName() + " " + customers.get(i).getAdress() + " " + customers.get(i).getCost() + " ");
            }
            fileWriter.close();
    }
    
    public void writeCosts() throws IOException {
            FileWriter fileWriter = new FileWriter("res//Costs.txt");
            Integer size = costs.size();
            fileWriter.write(size.toString() + " ");
            for (int i=0; i<costs.size(); i++) {
                fileWriter.write(costs.get(i).getNumber() + " " + costs.get(i).getCost() + " ");
            }
            fileWriter.close();
    }

    public void viewCustomers(){
        for (int i = 0; i< customers.size(); i++){
            customers.get(i).print();
        }
    }
    
    public void viewCosts(){
        for (int i = 0; i< costs.size(); i++){
            costs.get(i).print();
        }
    }
    
    public void deleteCustomer() throws IOException {
        System.out.println("Enter index:");
        int ind = scan.nextInt();
        customers.remove(ind-1);
        
        writeCustomers();
    }

    public void editNumber() throws ParseException, IOException {
        System.out.println("Enter index:");
        int ind = scan.nextInt();
        
        System.out.println("Enter phone number:");
        int phone_number = scan.nextInt();

        System.out.println("Enter subscriber's name:");
        String name = scan.next();

        System.out.println("Enter subscriber's address:");
        String adress = scan.next();

        System.out.println("Enter cost of the phone talking:");
        int cost = scan.nextInt();

        Customer customer = new Customer(phone_number, name, adress, cost);
        customers.set(ind-1,customer);
        
        writeCustomers();
    }
    
    public void editCost() throws ParseException, IOException {
        System.out.println("Enter index:");
        int ind = scan.nextInt();
        
        System.out.println("Enter phone number:");
        int phone_number = scan.nextInt();

        System.out.println("Enter cost of the phone talking:");
        int cost = scan.nextInt();

        Costs cost_ = new Costs(phone_number, cost);
        costs.set(ind-1,cost_);
        
        writeCosts();
    }
    
    public void addNumber() throws ParseException, IOException {
        System.out.println("Enter phone number:");
        int phone_number = scan.nextInt();
        
        System.out.println("Enter subscriber's name:");
        String name = scan.nextLine();

        System.out.println("Enter subscriber's adress:");
        String adress = scan.nextLine();

        System.out.println("Enter cost of the phone talking:");
        int cost = scan.nextInt();

        Customer customer = new Customer(phone_number, name, adress, cost);
        customers.add(customer);
        
        writeCustomers();
    }
    public void searchNumber() throws ParseException, IOException {
        System.out.println("Enter phone number:");
        int phone_number = scan.nextInt();
        if customers.get(i).getNumber()== phone_number{ 
        System.out.println(customers.get(i).getNumber() + " " + customers.get(i).getName() + " " + customers.get(i).getAdress() + " " + customers.get(i).getCost() + " ");
        }
    }
}
