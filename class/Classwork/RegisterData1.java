package Classwork;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RegisterData1 {
	public static void main(String[] args) throws FileNotFoundException {
		int subtotal;
		int current=0;
		File f=new File("D:\\ab.txt");
		PrintWriter pw=new PrintWriter(f);
		pw.println("Starting a new sale.\n");
		boolean loop=true;
		do {
		Scanner in=new Scanner(System.in);
		System.out.println("What is the item name, count and cost?\n(seperate with spaces and name must be a single word)");
	    String name= in.next();
		int count=in.nextInt();
		int cost=in.nextInt();
		subtotal=cost*count;
		current+=subtotal;
		System.out.println("The subtotal for "+name+ " is "+subtotal);
		System.out.println("The current total is "+current);
		System.out.println("Is the sales done? (1/0 1=yes, 0=no) ");
		pw.println(count+""+name+""+" @ "+cost+" is "+subtotal);
		int answer=in.nextInt();
		if (answer!=1) { 
			loop=false;
		}
		}	while (loop);
			System.out.println("Sale completed, total is "+current +"\nThe file RegisterData.txt has been written.");
			pw.close();
		}
	}
