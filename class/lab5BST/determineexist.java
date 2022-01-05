package lab5BST;

import java.util.Scanner;

public class determineexist {
	public static void main(String[]args) {
		int [] a = {1,3,5,7,9,10,12,14,16,18,20};
		int e1 = 0,e2=0;
		boolean t = true;
		Scanner s = new Scanner (System.in);
		System.out.print("Enter the number you want to check:");
		int key = s.nextInt();
		int count = 1;
		for(int i=a.length-1;i>0;i--) {
			e1 = 0;
			e2 = 0;
			int rest=0;
			if(a[i]<key) {
				e1=a[i];
				rest = key-a[i];
				for (int j=i-1;j>=0;j--) {
					if (a[j]==rest) {
						e2=a[j];
						if(count==1) {
							System.out.println("Yes, they are ("+e1+" and "+e2+")");
						}else {
							System.out.println("and ("+e1+" and "+e2+")");
						}
					
						t=false;
						count++;
						break;
					}
				}
			}
		}
		if(t) {
			System.out.println("No, there are no two numbers that add up to "+key);
		}
	
	}
	
}
