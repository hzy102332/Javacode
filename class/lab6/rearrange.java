package lab6;

import java.util.Arrays;

public class rearrange {
	public static void main(String []args) {
		String [] a = new String[10];
		
		for(int i=0;i<a.length;i++) {
			int t = (int)(Math.random()+0.5);
			if (t==1) {
				a[i]="false";
			}
			else {
				a[i]="true";
			}
		}
		System.out.println("The original array:"+Arrays.toString(a));
		Rearrange(a);
		
	}
	static void Rearrange (String [] a) {
		
		int count=0;
		for (int i=0;i<a.length;i++) {
			if (a[i]=="false") {
				count++;
			}
		}
		for(int i=0;i<a.length;i++) {
			if (count>0) {
				a[i]="false";
				count--;
			}
			else {
				a[i]="true";
			}
		}
		System.out.print("After rearrange  : "+Arrays.toString(a));
	}
}
