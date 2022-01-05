package lab5BST;

import java.util.Arrays;

public class percolateDown {
	public static void main(String[]args) {
		Integer [] a = {15, 14, 13, 12, 9, 11, 8, 10, 3, 6, 7, 4, 5, 1, 2};
		
		
		percolateDown(a, 0, a.length);
		
	}
	public static  void percolateDown(Integer [] a ,int index,int size) {
		Integer [] a1 = new Integer [a.length]; 
		Integer [] a2 = new Integer [a.length];
		for(int i=0 ;i<a.length;i++) {
			a1[i]=a[i];
			if(i>=1) {
				int next =i;
				for(int k=(i-1)/2;k>=0;k=k/2) {
					int l = k*2+1;
					int r = k*2+2;
					if (next%2==0) {
						check(a,k,l,r);
					}else {
						if (a[r]>a[k]) {
							swap(a,r,k);
						}
					}
					next=k;
					if(k==0) {
						break;
					}
				}
			}
		}
		
		for(int j=a.length-1;j>=0;j--) {
			a2[j]=a[0];
			a[0]=0;
			int i=0;
			while(i<a.length) {
				int l=i*2+1;
				int r=i*2+2;
				if (l>a.length ||r>a.length) {
					break;
				}
				if(a[l]>a[r]) {
					swap(a,i,l);
					i=2*i+1;
				}
				else if (a[l]<a[r]){
					swap(a,i,r);
					i=i*2+2;
				}
				else {
					break;
				}
			}
		}
		System.out.print(Arrays.toString(a2));
	}
	public static void check(Integer[] a,int x, int y,int z) {
		if(a[z]>a[y]) {
			if(a[z]>a[x]) {
			swap(a,x,z);
			}
		}else {
			if(a[y]>a[x]) {
			swap(a,x,y);
		}}
	}
	public static void swap(Integer[] a2,int a ,int b){
        int temp=a2[a];
        a2[a] = a2[b];
        a2[b] = temp;
    }
}
