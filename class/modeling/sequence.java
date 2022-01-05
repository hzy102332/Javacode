package modeling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class sequence {
	public static void main (String []args) {
		
		
		String instanceName = "src/modeling/data.txt";
		
		try {
		     File myObj = new File(instanceName);
		     Scanner myReader = new Scanner(myObj);
		     int nbLine = 0;
		     int totaln = 0;
		     while (myReader.hasNextLine()) {
		    	 if (totaln < nbLine) break;
				 String dataStr = myReader.nextLine();
				 ArrayList<String> seq = new ArrayList<String>();
				 String dataArr[] = dataStr.split("\\.");
				 String data = dataArr[1];
				 for(int i = 0; i < data.length() - 2; i++) {
					 
				 }
				 
				 
				 nbLine++;
			 }
		     myReader.close();
		 } catch (FileNotFoundException e) {
		     System.out.println("An error occurred.");
		     e.printStackTrace();
		 }
		
		
	}


}
