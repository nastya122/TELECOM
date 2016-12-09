package java_project;

import java.io.*;
import java.text.ParseException;
import java.util.*;


public class FileWorker {
    Scanner scan = new Scanner(System.in);

    public void readCustomers(ArrayList<Customer> customers) throws FileNotFoundException, ParseException {
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
    
    public void readCosts(ArrayList<Costs> costs) throws FileNotFoundException, ParseException {
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

    public void writeCustomers(ArrayList<Customer> customers) throws IOException {
            FileWriter fileWriter = new FileWriter("res//Customers.txt");
            Integer size = customers.size();
            fileWriter.write(size.toString() + " ");
            for (int i=0; i<customers.size(); i++) {
                fileWriter.write(customers.get(i).getNumber() + " " + customers.get(i).getName() + " " + customers.get(i).getAdress() + " " + customers.get(i).getCost() + " ");
            }
            fileWriter.close();
    }
    
    public void writeCosts(ArrayList<Costs> costs) throws IOException {
            FileWriter fileWriter = new FileWriter("res//Costs.txt");
            Integer size = costs.size();
            fileWriter.write(size.toString() + " ");
            for (int i=0; i<costs.size(); i++) {
                fileWriter.write(costs.get(i).getNumber() + " " + costs.get(i).getCost() + " ");
            }
            fileWriter.close();
    }

    public void viewCustomers(ArrayList<Customer> customers){
        for (int i = 0; i< customers.size(); i++){
            customers.get(i).print();
        }
    }
    
    public void viewCosts(ArrayList<Costs> costs){
        for (int i = 0; i< costs.size(); i++){
            costs.get(i).print();
        }
    }
    
    public void deleteCustomer(ArrayList<Customer> customers) throws IOException {
        System.out.println("Enter index:");
        int ind = scan.nextInt();
        customers.remove(ind-1);
        
        writeCustomers(customers);
    }

    public void editNumber(ArrayList<Customer> customers) throws ParseException, IOException {
        System.out.println("Enter index:");
        int ind = scan.nextInt();
        
        System.out.println("Enter phone number:");
        int phone_number = scan.nextInt();

        System.out.println("Enter customer's name:");
        String name = scan.next();

        System.out.println("Enter customer's address:");
        String adress = scan.next();

        System.out.println("Enter cost of the phone talking:");
        int cost = scan.nextInt();

        Customer customer = new Customer(phone_number, name, adress, cost);
        customers.set(ind-1, customer);
        
        writeCustomers(customers);
    }
    
    public void editCost(ArrayList<Costs> costs) throws ParseException, IOException {
        System.out.println("Enter index:");
        int ind = scan.nextInt();
        
        System.out.println("Enter phone number:");
        int phone_number = scan.nextInt();

        System.out.println("Enter cost of the phone talking:");
        int cost = scan.nextInt();

        Costs cost_ = new Costs(phone_number, cost);
        costs.set(ind-1, cost_);
        
        writeCosts(costs);
    }
    
    public void addNumber(ArrayList<Customer> customers) throws ParseException, IOException {
        System.out.println("Enter phone number:");
        int phone_number = scan.nextInt();
        
        System.out.println("Enter customer's name:");
        String name = scan.nextLine();

        System.out.println("Enter customer's adress:");
        String adress = scan.nextLine();

        System.out.println("Enter cost of the phone talking:");
        int cost = scan.nextInt();

        Customer customer = new Customer(phone_number, name, adress, cost);
        customers.add(customer);
        
        writeCustomers(customers);
    } 
    
    public void searchNumber(ArrayList<Customer> customers) throws ParseException, IOException {
        System.out.println("Enter phone number:");
        int phone_number = scan.nextInt();
        for (int i=0; i<customers.size(); i++) {
            if (customers.get(i).getNumber()== phone_number){ 
                System.out.println(customers.get(i).getNumber() + " " + customers.get(i).getName() + " " + customers.get(i).getAdress() + " " + customers.get(i).getCost() + " ");
            }
        }
    }
}