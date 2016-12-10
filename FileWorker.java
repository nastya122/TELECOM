package java_project;

import java.io.*;
import java.text.ParseException;
import java.util.*;
import javax.swing.JOptionPane;


public class FileWorker {
    Scanner scan = new Scanner(System.in);
    public static final String FileName = "Contacts.txt";

    public void readCustomers(ArrayList<Customer> customers) throws FileNotFoundException, ParseException {
        File f = new File("res//Customers.txt");
        Scanner cust_scan = new Scanner(new FileReader(f));
        
        if (f.length()!=0) {
            int s = Integer.parseInt(cust_scan.next());
            for (int i = 0; i < s; i++) {
                String phone_number = cust_scan.nextLine();
                
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
                String phone_number = cost_scan.nextLine();

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
    
    public void deleteContacts(ArrayList<Customer> customers, Customer C) throws ParseException {
        BufferedReader br = null;
        String ReWrite = "";
        try {
            if (new File(FileName).exists()) {
                br = new BufferedReader(new FileReader(FileName));
                String line = "";
                while ((line = br.readLine()) != null) {
                    String[] _temp = line.split(",");
                    if (_temp[0].equalsIgnoreCase(C.getName()) && _temp[1].equalsIgnoreCase(C.getNumber())
                            && _temp[2].equalsIgnoreCase(C.getAdress())) {
                        //ignore line to delete this contact
                    } else {
                        ReWrite += line + "\r\n";
                    }
                }
                br.close();
 
                if (writeCustomers(ReWrite)) {
                    JOptionPane.showMessageDialog(null, "Successfully delete contact " + C.getName());
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete contact " + C.getName());
                }
 
                readCustomers(customers);
                Telecom_panel.BindIntoJTable();
 
            } else {
                new File(FileName).createNewFile();
                readCustomers(customers);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void editNumber(ArrayList<Customer> customers) throws ParseException, IOException {
        System.out.println("Enter index:");
        int ind = scan.nextInt();
        
        System.out.println("Enter phone number:");
        String phone_number = scan.next();

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
        String phone_number = scan.next();

        System.out.println("Enter cost of the phone talking:");
        int cost = scan.nextInt();

        Costs cost_ = new Costs(phone_number, cost);
        costs.set(ind-1, cost_);
        
        writeCosts(costs);
    }
    
    public void addNumber(ArrayList<Customer> customers) throws ParseException, IOException {
        System.out.println("Enter phone number:");
        String phone_number = scan.next();
        
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
        String phone_number = scan.next();
        for (int i=0; i<customers.size(); i++) {
            if (customers.get(i).getNumber()== phone_number){ 
                System.out.println(customers.get(i).getNumber() + " " + customers.get(i).getName() + " " + customers.get(i).getAdress() + " " + customers.get(i).getCost() + " ");
            }
        }
    }
}