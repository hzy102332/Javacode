package lab4;

public class Insertionsort {

	public static void main(String[] args) {
		String []name= {"A","B","C","D","E","F"};
		int []a = {65,80,70,85,55,60};
		
		int l=0;
		for (int i=1;i<a.length;i++) {
			boolean t=false;
			int key=a[i];
			String k= name[i];
			for(int j=i-1;j>=0;j--) {
				if (a[j]>key) {
					a[j+1]=a[j];
					name[j+1]=name[j];
					t=true;
					l=j;
				}
			}
			if (t) {
				a[l]=key;
				name[l]=k;
			}
		}
		for (int i=0;i<a.length;i++) {
			System.out.println(name[i]+": "+a[i]);
			
		}
		
	}

}
