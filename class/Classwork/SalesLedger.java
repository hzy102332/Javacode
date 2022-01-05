package Classwork;

import java.util.ArrayList;
import java.util.Scanner;

public class SalesLedger {
	public static int saleSoFar;
	public static String[] saleAmt;
	public static void main(String[]args) {
		System.out.println("WENZHOU ELECTRONOCS.COM");
		System.out.println("Testing Ledger:");
		System.out.print("Adding sales ");
		SalesLedger obj=new SalesLedger ();
		Scanner in=new Scanner(System.in);
		String number= in.nextLine();
		saleAmt=number.split(",");
		saleSoFar= saleAmt.length;
		
	    System.out.println("The total number of sales are:"+obj.getNumberOfSales());
	    System.out.println("The total amount of sales is: "+obj.getTotalSales());
	    System.out.println("The average sale amout is: "+obj.getTotalSales()/saleSoFar);
	    
	}
    void Ledger(double maxSales) {
    	maxSales=0;
		for (int i=0;i<=saleAmt.length;i++) {
			if (maxSales<Double.valueOf(saleAmt[i])) {
				maxSales=Double.valueOf(saleAmt[i]);
			}
		}
	}
	public void addSale(double d) {
		
	}
	public int getNumberOfSales() {
		return saleSoFar;
	}
	public double getTotalSales() {
		double s=0;
		for (int i=0;i<=saleAmt.length-1;i++) {
			s=s+Double.valueOf(saleAmt[i]);
		}
		return s;
	}
}
