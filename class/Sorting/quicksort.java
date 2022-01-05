package Sorting;

public class quicksort {

	public static void main(String[] args) {
		
		int []arr = {6,5,8,9,3,17,15,12,16 };
		int len =arr.length;
		int count = 0;
		int h=0;
		int p=0;
		while(p<arr.length-1){
			boolean t= false;
			boolean ifcontinue= true;
			int pivot=0;
			for (int i=p+1;i<len;i++) {
				
				if (!ifcontinue) {
					break;
				}
				if (arr[i]>arr[p]) {
					ifcontinue=false;
					count++;
					if (count==1) {
						 h=i;
					}
					for(int j=len-1;j>i;j--) {
						if(arr[j]<arr[p]) {
						swap(arr,i,j);
						pivot=i;
						t = true;
						ifcontinue=true;
						break;}
						}
					}
			}
			if (ifcontinue && arr[p]>arr[len-1]) {
				for(int i=p;i<len-1;i++) {
					swap(arr,i,i+1);
					for(int a=p;a<len-1;a++) {
						if (arr[a]>arr[p]) {
							h=a;
							break;
						}
					}
				}
			}
//			Swap
			if (t) {
				for(int i=p;i<pivot;i++) {
					swap(arr,i,i+1);
				}
				count = 0;
			}
//			not swap
		    if(!t ) {
		    	if (arr[p]>arr[p+1]) {
		    		for(int i=p;i<h-1;i++) {
					swap(arr,i,i+1);
					}
		    	}
		    	p++;
		    	count = 0;
			}
		}
			for(int c=0;c<arr.length;c++) {
				System.out.print(arr[c]+" ");
			}
	}
	public static void swap(int [] arr,int i ,int j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
	}
}

