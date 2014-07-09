package com.binary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
/*
 * @author   : Sandeep Kumar
 * @version  : 1.0
 * @since    : 03-07-2014
 */
public class ShareServiceImpl  implements ShareService{

	/*
	 * @see com.binary.ShareService#readCSVFile(java.lang.String)
	 * 
	 * This method will read csv file and find out the max share price for that year and month of a company
	 * @param : fileName name of the csv file
	 * @return : void
	 * 
	 */
	public void readCSVFile(String fileName){
		
		// This will reference one line at a time
        String line = null;
        Map companyMap = new HashMap();
        int index=0;
        int max=0;
        try{
        	// FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            // read csv file line by line
            while((line = bufferedReader.readLine()) != null) {
               
            	// split csv line in string array
                String[] strArray = line.split(",");
                max=0;
                
                // check header data
                if(!line.startsWith("Year")) {
                	
                	//comapre and find max share prices
	                for(int i =2; i<strArray.length;i++) {
	                	
	                	if(max < Integer.parseInt(strArray[i].trim())) {
	                		
	                		max = (Integer.parseInt(strArray[i].trim()));
	                		index = i;
	                	}
	                	
	                	
	                }
	                
	                // print data with company name, year, month and max share price
	                System.out.println(" company : "+companyMap.get(index)+" Year: "+strArray[0] +" month: "+strArray[1]+" max: "+max);
	                System.out.println("************************************************************************************");
                }
                else {
                	for(int i =2; i<strArray.length;i++) {
                		
                		companyMap.put(i, strArray[i]);
                	}
                	
                }
            }
            
        }
        catch(Exception e){
        	e.printStackTrace();
        }
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShareServiceImpl shareServiceImpl = new ShareServiceImpl();
		 // The name of the file to open.		
        String fileName = "shareprices.txt";
        
        shareServiceImpl.readCSVFile(fileName);
        
	}

}
