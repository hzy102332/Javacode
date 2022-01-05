package lab7;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class postfixexpression {
	public static void main(String[]args) {
		
		Scanner s = new Scanner (System.in);
		System.out.print("Please enter the postfix expression: ");
		String ex = s.nextLine();

		System.out.println(Arrays.toString(ex.split("")));
		postfix(ex);
	}
	public static void postfix(String c) {
//		2*3+5    325*+
//		0-9: 48-57
//	( 40 ) 41	* 42  + 43  - 45 /47
		String [] list = c.split("");
		Stack<Integer> n = new Stack<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		int out = 0;
		for (int i =0; i<c.length();i++) {
			if(c.charAt(i)>=48 && c.charAt(i)<=57) {
				n.add(Integer.parseInt(list[i]));
			}
			else if(c.charAt(i)>=42 && c.charAt(i)<=47) {
					int first = n.pop();
					int second = n.pop();
//					*
					if (c.charAt(i)==42) {
						int cal = first*second;
						n.add(cal);
						}
//					+
					else if (c.charAt(i)==43) {
						int cal = second+first;
						n.add((int)(char)cal);
						}
//					-
					else if (c.charAt(i)==45) {
						int cal = second-first;
						;
						n.add(cal);}
//					/
					else if (c.charAt(i)==47) {
						int cal = second/first;
						;
						n.add(cal);}
				}
			if (i==c.length()-1) {
				int t= n.pop();
				out = t;
			}
			}
		System.out.println(out);
		}
}
