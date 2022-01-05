package lab9;

import java.util.Scanner;

public class heightofn {
	public static void main(String []args) {
		Scanner s  = new Scanner (System.in);
		int [] a = new int [46];
		int p=0;
		a[0] = 1; 
		a[1] = 2;
		System.out.print("Please enter the number of the AVLtree node:");
		int node = s.nextInt();
		if (node <= 2) {
			p=1;
		}else {
			for (int i =2;i<46;i++) {
				a[i] = a[i-1]+a[i-2]+1;
				
				if (a[i]==node) {
					p=i;
					break;
				}else if (a[i]>node) {
					p=i-1;
					break;
				}
			}
		}
		int b1 = (int)(Math.log(p)/Math.log(2))+1;
		System.out.println("The max height of "+node+"-node AVLtree is:"+p);
		System.out.println("The bit of per node to store the height is:"+b1);
		System.out.print("Enter the bit of height: ");
		node = s.nextInt();
		node= (int)Math.pow(2, node)-1;
		long [] b = new long [node+1];
		b[0]=1;b[1]=2;
		for (int i =2;i<=node;i++) {
			b[i] = b[i-1]+b[i-2]+1;
			System.out.println(i+"  "+b[i]);
			}
		
		System.out.print("The smallest AVLtree has "+b[node-1]+" nodes");	
	}
}
