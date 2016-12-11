package java_project;

import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;

public class CustomerBase{
    public static ArrayList<Customer> customers = new ArrayList<Customer>();
    Scanner scan = new Scanner(System.in);
    static FileWorker basecustom = new FileWorker();
    public static final String FileName = "Customers.txt";
    
    public CustomerBase() {
        customers = new ArrayList<Customer>();
    }
    
    private static String MessageStatus;
    public static String getMessageStatus() {
        return MessageStatus;
    }

    public static void setMessageStatus(String message_status) {
        MessageStatus = message_status;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected static boolean writeFile(String TextToWrite) {
        FileWriter writer = null;
        boolean successfulWrite = false;
        try {
            writer = new FileWriter(FileName);
            writer.write(TextToWrite);
            writer.close();
            successfulWrite = true;
        } catch (IOException ex) {
            successfulWrite = false;
            MessageStatus = ex.getMessage();
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                MessageStatus = ex.getMessage();
            }
        }
        return successfulWrite;
    }
    //////////////////////////////////////////////////////////////--чтение нашего списка
    public static void readCustomers() {
        BufferedReader br = null;
        try {
            if (new File(FileName).exists()) {
 
                if (customers == null) {
                    customers = new ArrayList<>();
                } else {
                    customers.clear();
                }
                br = new BufferedReader(new FileReader(FileName));
                StringBuilder sb = new StringBuilder();
                String line = "";
                Customer ContactClass = null;
                while ((line = br.readLine()) != null) {
                    if (!line.equalsIgnoreCase("")) {                      
                        String[] _temp = line.split(",");
                        String _temp_name = _temp[0];
                        if (_temp_name.equalsIgnoreCase("NULL")) {
                            _temp_name = "";
                        }
 
                        String _temp_phone = _temp[1];
                        if (_temp_phone.equalsIgnoreCase("NULL")) {
                            _temp_phone = "";
                        }
 
                        String _temp_adress = _temp[2];
                        if (_temp_adress.equalsIgnoreCase("NULL")) {
                            _temp_adress = "";
                        }
                        
                        String _temp_cost = _temp[3];
                        if (_temp_cost.equalsIgnoreCase("NULL")) {
                            _temp_cost = "";
                        }
                        
                        ContactClass = new Customer(_temp_name, _temp_phone, _temp_adress, _temp_cost);
                        customers.add(ContactClass);
                    }
                }
            } else {
                new File(FileName).createNewFile();
                readCustomers();
            }
 
        } catch (NullPointerException | IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(CustomerBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////-редактирование данных
    public static boolean editCustomer(String name, String number, String adress, String cost, String NewStringLine) {
        BufferedReader br = null;
        String ReWrite = "";
        boolean success = false;
        try {
            if (new File(FileName).exists()) {
                br = new BufferedReader(new FileReader(FileName));
                String line = "";
                while ((line = br.readLine()) != null) {
                    if (!"".equals(line)) {
                        String[] _temp = line.split(",");
                        if (_temp[0].equalsIgnoreCase(name) && _temp[1].equalsIgnoreCase(number)
                                && _temp[2].equalsIgnoreCase(adress) && _temp[3].equalsIgnoreCase(cost)) {
                            ReWrite += NewStringLine + "\r\n";
                        } else {
                            ReWrite += line + "\r\n";
                        }
                    }
                }
                br.close();
 
                if (writeFile(ReWrite)) {
                    success = true;
                } else {
                    success = false;
                }
                //update ArrayList with new Contact List
                readCustomers();
 
            } else {
                new File(FileName).createNewFile();
                readCustomers();
                success = false;
            }
        } catch (FileNotFoundException ex) {
            MessageStatus = ex.getMessage();
            success = false;
        } catch (IOException ex) {
            MessageStatus = ex.getMessage();
            success = false;
        }
        return success;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////--удаление абонента
    public static void deleteCustomer(Customer C) {
        BufferedReader br = null;
        String ReWrite = "";
        try {
            if (new File(FileName).exists()) {
                br = new BufferedReader(new FileReader(FileName));
                String line = "";
                while ((line = br.readLine()) != null) {
                    String[] _temp = line.split(",");
                    if (_temp[0].equalsIgnoreCase(C.getName()) && _temp[1].equalsIgnoreCase(C.getNumber())
                            && _temp[2].equalsIgnoreCase(C.getAdress()) && _temp[3].equalsIgnoreCase(C.getAdress())) {
                        //ignore line to delete this contact
                    } else {
                        ReWrite += line + "\r\n";
                    }
                }
                br.close();
 
                if (writeFile(ReWrite)) {
                    JOptionPane.showMessageDialog(null, "Successfully delete contact " + C.getName());
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete contact " + C.getName());
                }
 
                CustomerBase.readCustomers();
                Telecom_panel.BindIntoJTable();
                
            } else {
                new File(FileName).createNewFile();
                readCustomers();
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
/////////////////////////////////////////////////////////////--поиск абонента
    public static ArrayList<Customer> searchCustomer(String searchValue) {
        ArrayList<Customer> cnt = new ArrayList<>();
        BufferedReader br = null;
 
        try {
            if (new File(FileName).exists()) {
                br = new BufferedReader(new FileReader(FileName));
                String line = "";
                while ((line = br.readLine()) != null) {
                    if (!"".equals(line)) {
                        String[] _temp = line.split(",");
                        if (_temp[0].equalsIgnoreCase(searchValue) || _temp[1].equalsIgnoreCase(searchValue)
                                || _temp[2].equalsIgnoreCase(searchValue) || _temp[3].equalsIgnoreCase(searchValue)) {
                            Customer c = new Customer(_temp[0], _temp[1], _temp[2], _temp[3]);
                            cnt.add(c);
                        }
                    }
                }
            } else {
                new File(FileName).createNewFile();
                cnt = searchCustomer(searchValue);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
 
        return cnt;
    }
   /////////////////////////////////////////////////////////////////////////////////////////////////////////-- не изменяла ничего 
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
    ///////////////////////////////////////////////////////-- 
    public static ArrayList<Customer> getAllCustomers() {
        return customers;
    }
/////////////////////////////////////////////////////////////
    public static void setAllCustomers(ArrayList<Customer> all_customers) {
        customers = all_customers;
    }
}
