package Sorting;

public class ShellSort {
	public static void main(String []args) {
		Integer [] a = {7,16,25,14,13,12,2,44,1,91};
		int pow = (int)(Math.log(a.length)/Math.log(2));
		for(int i=1;i<=pow;i++) {
			int gap = (int) (a.length/(Math.pow(2, i)));
			if(gap>1) {
				for(int j=0;j<=gap;j++) {
					for(int next=j;(next+gap)<a.length;next=next+gap) {
					if(a[next]>a[next+gap]) {
						int temp=a[next];
						a[next]=a[next+gap];
						a[next+gap]=temp;
					}
					}
					}
				}
			else {
				boolean t= false;
				for(int z =0;z<a.length-1;z++) {
					if (a[z]>a[z+gap]) {
						int temp=a[z];
						a[z]=a[z+gap];
						a[z+gap]=temp;
						t=true;
					}
					if (t&&z>=1) {
						if (a[z]<a[z-1]) {
							int temp=a[z];
							a[z]=a[z-1];
							a[z-1]=temp;
						}
					}
				}
		}
		
		}
//		shellsort(a);
		for (int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}
//	public static <Integer extends Comparable<? super Integer>>void shellsort( Integer [ ] a ){
//		for( int gap = a.length / 2; gap > 0;gap = gap == 2 ? 1 : (int) ( gap / 2.2 ) ) {
//			for( int i = gap; i < a.length; i++ ){
//					Integer tmp = a[ i ];
//					int j = i;
//	
//					for( ; j >= gap && tmp.compareTo( a[j-gap] ) < 0; j -= gap ) {
//						a[ j ] = a[ j - gap ];
//						a[ j ] = tmp;
//						}
//				}
//		}
//	 }
}
