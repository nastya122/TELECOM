package java_project;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class CustomerBase{
    public volatile ArrayList<Customer> customers = new ArrayList<Customer>();
    Scanner scan = new Scanner(System.in);
    FileWorker basecustom = new FileWorker();
    
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

    public void deletebase() throws IOException {
        basecustom.deleteCustomer(customers);
    }

    public void searchbase() throws ParseException, IOException {
        basecustom.searchNumber(customers);
    }
}