package lab1;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class sieveprimenumber {
	public static void main(String []args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Please enter the number you want to sieve:");
		int number= s.nextInt();
		long start =System.currentTimeMillis();
		try {
		sieve(number);
	    }
		catch (NoSuchElementException e){
		}
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("\nThe runnig time is£º" +interval+ " ms");
		}
	public static void sieve(int number) {
		
		 int arry[]=new int [number+1];
         arry[2]=0;
         int k=2,t=0;
         while(t<Math.sqrt(number))
             {
                 for(int i=1; i<arry.length; i++)
                     {
                      if(i%k==0&&i!=k) arry[i]=1;
                     }
                 for(int i=1; i<arry.length; i++) 
                 { 
                    if(i>k&&arry[i]==0)
                    {
                      k=i;
                      break;
                    }
                 }
                 t++;
             }
         int count= 0;
         for(int i=1; i<arry.length; i++)
             if(arry[i]==0) { 
            	 if (count==15) {
            		 count=0;
            		 System.out.print("\n");
            	 }
            	 System.out.printf("%d ",i);
             	 count+=1;		
             }
		}	
}
