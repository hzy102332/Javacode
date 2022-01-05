package cps3440;

public class RandomAndMedianAlgorithem {
	
	public static void main (String [] args) {
		
		String [] x= {"A","C","B"};
		String []y = {"A","B"};
		String temp = x[0];
		
		int look[][] = new int [6][6];
		for (int a = 0; a <= 5; a++) {
			look[a][0] = 0;	
		}
        for (int j = 0; j <= 5; j++) {
        	look[0][j] = 0;
        }
        look[2][2] = 0;
		System.out.println(look[2][2] == 0);
	}
	private static void RandomSelect (int [] a) {
		int position = (int)Math.random()*a.length;
		int pivot = a[position];
		
		
	}
	private static void partition (int [] a, int low, int high) {
		
	}
}
