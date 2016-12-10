package java_project;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.*;
import javax.swing.JOptionPane;

public class CustomerBase{
    public volatile ArrayList<Customer> customers = new ArrayList<Customer>();
    Scanner scan = new Scanner(System.in);
    static FileWorker basecustom = new FileWorker();
    public static final String FileName = "Contacts.txt";
    
    public void readbase() throws FileNotFoundException, ParseException {
        basecustom.readCustomers(customers);
    }

    public void writebase() throws IOException {
        basecustom.writeCustomers(customers);
    }
    
    public void viewbase() {
        basecustom.viewCustomers(customers);
    }

    public void addbase() throws ParseException, IOException {
        basecustom.addNumber(customers);
    }

    public void editbase() throws ParseException, IOException {
        basecustom.editNumber(customers);
    }

    public void deletebase(Customer customer) throws IOException {
        basecustom.deleteCustomer(customer);
    }

    public void searchbase() throws ParseException, IOException {
        basecustom.searchNumber(customers);
    }
    
    public static boolean appendTextContact(String appendValue) {
        boolean success = false;
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FileName, true)));
            out.println(appendValue);
            out.close();
            success = true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return success;
    }
}