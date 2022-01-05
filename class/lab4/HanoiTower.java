package lab4;

import java.util.Scanner;

public class HanoiTower {

	static int  count = 0;
	static int  move =1;
	public static void main(String args[]) {
 
		int n = 0;
		Scanner s = new Scanner(System.in);
		System.out.print("Please enter the number of the disk(s): ");
		n = s.nextInt();
		
		System.out.println("Display the movement(s): ");
		hanoi(n, 'A', 'B', 'C');
		System.out.println("Moving specified number of disk(s): " + count);
 
	}
 
	public static void hanoi(int n, char a, char b, char c) { 
		
		if (n == 1){  
			 
			if (move==1) {
				System.out.println("The " + (move++) + " time " + a + "-->" + c);  
			}
			else {
            System.out.println("The " + (move++) + " times " + a + "-->" + c);
            }  
           count++;
        }
		else{  
          
            hanoi(n-1,a,c,b);  
            System.out.println("The " + (move++) + " times " + a + "-->" + c);  
            hanoi(n-1,b,a,c);  
            count++;
        }
	}


}
