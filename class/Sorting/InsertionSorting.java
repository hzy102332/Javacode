package Sorting;

public class InsertionSorting {

	public static void main(String[] args) {
		int [] a = {7,16,2,14,13,27,42,5,1,91};
		int l=0;
		for (int i=1;i<a.length;i++) {
			boolean t=false;
			int key=a[i];
			for(int j=i-1;j>=0;j--) {
				if (a[j]>key) {
					a[j+1]=a[j];
					t=true;
					l=j;
				}
			}
			if (t) {
				a[l]=key;
			}
		}
		for (int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}

	}

}
