package CPS3410;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class choclate {
	public static void main(String []args) {
		int [] a = {8,8,8,8,16};
//		int [] a = {5,10,9,8};
//		int [] a = {15,12,8};
//		int [] a = {10,2};
		System.out.print(divide5(6,8,a));
//		System.out.print(divide4(4,8,a));
//		System.out.print(divide3(5,7,a));
//		System.out.print(divide2(5,7,a));
		
	}
//two case
public static boolean divide2(int x, int y , int[]a) {
	if (a[0]+a[1] != x*y)
		return false;
	for (int i = 0; i < 2; i ++) {
		if (a[i] % x == 0 || a[i] % y == 0)
			return true;
	}
	return false;
}
//three case
public static boolean divide3(int x,int y, int[]a) {
		int total = x*y;
		int new_a[] = new int [a.length-1];		
		if (a[0]+a[1]+a[2] != total)
			return false;
		for(int i = 0; i < 3; i++) {
			int y1 = y;
			int x1 = x;
			if (a[i] % x == 0) {
				y1 -= a[i]/x;
				new_a[0] = a[(i+1)%3];
				new_a[1] = a[(i+2)%3];
				if (divide2(x,y1,new_a))
					return true;
			}
			if (a[i] % y ==0) { 
				x1 -= a[i]/y;
				new_a[0] = a[(i+1)%3];
				new_a[1] = a[(i+2)%3];
				if (divide2(x1,y,new_a))
					return true;
			}
		}
		return false;
	}
//four case
public static boolean divide4(int x,int y, int[]a) {
	if (a[0]+a[1]+a[2]+a[3] != x*y)
		return false;
	int len = a.length;
	boolean check = false;
	int [] new_a = new int[len-1];
	
	for (int i = 0; i < len; i++) {
		int x1 = x, y1 = y;
		//check if the chocolates are broken on one side
		if (a[i]%x == 0) {
			y1 -= a[i]/x;
			check = true;
			new_a[0] = a[(i+1)%4];
			new_a[1] = a[(i+2)%4];
			new_a[2] = a[(i+3)%4];	
			if (divide3(x,y1,new_a)) return true;
		}
		if(a[i]%y == 0){
			x1 -= a[i]/y;
			check = true;
			new_a[0] = a[(i+1)%4];
			new_a[1] = a[(i+2)%4];
			new_a[2] = a[(i+3)%4];	
			if (divide3(x1,y,new_a)) return true;
		}
	}
	if (!check) {//if the chocolate break on both side
		// 01 02 03		
		List<Integer> temp = Arrays.stream(a).boxed().collect(Collectors.toList());		
		for (int i = 1; i < len; i++) {//combine in pairs 
			int x1 = x, y1 = y, x2 = x, y2 = y;
			int sum1 = 0;
			int new2[] = new int [2];
			int new3[] = new int [2];
			new2[0] = temp.get(0);
			new2[1] = temp.get(i);
			sum1 = temp.get(i)+temp.get(0);
			if (sum1 % x != 0 && sum1 % y != 0)	 continue;
			else {
				if (sum1 % x == 0) {
					y1 = sum1 / x;
					y2 = y - y1;
				}
				else {
					x1 = sum1 / y;
					x2 = x - x1;
				}
				if (divide2(x1,y1,new2)) {
					if (i == 1) {
						new3[0] = temp.get(2);
						new3[1] = temp.get(3);
					}else if (i == 2) {
						new3[0] = temp.get(1);
						new3[1] = temp.get(3);
					}else {
						new3[0] = temp.get(1);
						new3[1] = temp.get(2);
					}
					if (divide2(x2,y2,new3))
						return true;
				}
				else	continue;
			}
		}
	}
	return false;
}
//five case
public static boolean divide5(int x,int y, int[]a) {
	if (a[0]+a[1]+a[2]+a[3]+a[4] != x*y)	return false;
	int len = a.length;
	boolean check = false;
	int [] new_a = new int[len-1];
	
	for (int i = 0; i < len; i++) {
	//check if the chocolates are broken on one side
		if (a[i]%x == 0) {
			y -= a[i]/x;
			check = true;
			new_a[0] = a[(i+1)%5];
			new_a[1] = a[(i+2)%5];
			new_a[2] = a[(i+3)%5];
			new_a[3] = a[(i+4)%5];
			if (divide4(x,y,new_a)) return true;
		}else if(a[i]%y == 0){
			x -= a[i]/y;
			check = true;
			new_a[0] = a[(i+1)%5];
			new_a[1] = a[(i+2)%5];
			new_a[2] = a[(i+3)%5];
			new_a[3] = a[(i+4)%5];
			if (divide4(x,y,new_a)) return true;
		}
	}
	if (!check) {//if the chocolate break on both side
		// 01 02 03		
		List<Integer> temp = Arrays.stream(a).boxed().collect(Collectors.toList());		
		for (int i = 1; i < len; i++) {//combine in pairs 
			int x1 = x, y1 = y, x2 = x, y2 = y;
			int sum1 = 0;
			int new2[] = new int [2];
			int new3[] = new int [3];
			new2[0] = temp.get(0);
			new2[1] = temp.get(i);
			sum1 = temp.get(i)+temp.get(0);
			if (sum1 % x != 0 && sum1 % y != 0)	 continue;
			else {
				if (sum1 % x == 0) {
					y1 = sum1 / x;
					y2 = y - y1;
				}
				else {
					x1 = sum1 / y;
					x2 = x - x1;
				}
				if (divide2(x1,y1,new2)) {
					if (i == 1) {
						new3[0] = temp.get(2);
						new3[1] = temp.get(3);
						new3[2] = temp.get(4);
					}else if (i == 2) {
						new3[0] = temp.get(1);
						new3[1] = temp.get(3);
						new3[2] = temp.get(4);
					}else if (i == 3) {
						new3[0] = temp.get(1);
						new3[1] = temp.get(2);
						new3[2] = temp.get(4);
					}else {
						new3[0] = temp.get(1);
						new3[1] = temp.get(2);
						new3[2] = temp.get(3);
					}
					if (divide3(x2,y2,new3))
						return true;
				}
				else	continue;
			}
		}
	}
	return false;
}
}
