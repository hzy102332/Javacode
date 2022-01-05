package lab4;

import java.util.Arrays;

public class genericPriorityQueue {

	public static void main(String[] args) {
		int [] a= {10,12,1,14,6,5,8,15,3,9,7,4,11,13,2};
		heapsort(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static void heapsort(int [] a) {
		for(int i =a.length/2-1;i>=0;i--) {
			creat(a,i,a.length);
		}
		
//		重新排序
		for(int j =a.length-1;j>0;j--){
			swap(a,0,j);
			creat(a,0,j);
		}
		
	}
	
	public static void creat(int [] a,int i,int l) {
//		构建heap
		int temp =a[i];
//		i 是父节点，k ,k+1是子节点
		for (int k=2*i+1;k<l;k=k*2+1) {
			
			if(k+1<l&&a[k]<a[k+1]) {
				k++;
			}
			if (a[k]>temp) {
				a[i]=a[k];
				i=k;
			}
			else {
				break;
			} 
		}
		a[i]=temp;
	} 
	
	public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
