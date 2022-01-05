package Sorting;

public class SelectSorting {

	public static void main(String[] args) {
		int [] a = {7,16,25,14,13,12,2,44,1,91};
		for (int i=0; i<a.length;i++) {
			int minvalue = a[i];
			int min=0;
			boolean t =false;
			for(int j=i+1;j<a.length;j++) {
				if(a[j]<minvalue) {
					min=j;
					minvalue = a[j];
					t=true;
				}
			}
			if (t) {	
				int temp= a[min];
				a[min]=a[i];
				a[i]=temp;
			}
		}
		
		for (int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}

}
