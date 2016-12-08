package java_project;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class CostsBase {
    private ArrayList<Costs> costs = new ArrayList<Costs>();
    FileWorker basecost = new FileWorker();
    
    public void readbasecost() throws FileNotFoundException, ParseException {
        basecost.readCosts(costs);
    }
  
    public void writebasecost() throws IOException {
        basecost.writeCosts(costs); 
    }
    
    public void viewbasecost() {
        basecost.viewCosts(costs);
    }
    
    public void editbasecost() throws ParseException, IOException {
        basecost.editCost(costs);
    }
}