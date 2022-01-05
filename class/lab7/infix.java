package lab7;

import java.util.Arrays;
import java.util.Stack;

public class infix {
	public static void main(String []args) {
		String ex = "1+2^3*4^5^6-7-8/(9+1)";
		System.out.println(Arrays.toString(ex.split("")));
		
		postfix (ex);
	}
	public static void postfix(String line) {
		
		String [] list = line.split("");
		Stack<String> n = new Stack<String>();
		Stack<String> stack = new Stack<String>();

		for (int i = 0; i < list.length; i++) {	
//			word
			if (line.charAt(i)>=48 && line.charAt(i)<= 57) {
				n.push(list[i]);
			}
//			symbol
			else {
				switch (line.charAt(i)) {
				case '(':
					stack.push(list[i]);
					break;
				case ')':
					
					while(stack.lastElement().charAt(0)!='(') {
						n.push(stack.pop());
					}
					stack.pop();
					break;
				case '^':
					stack.push(list[i]);
					break;
				case '*':
					while(	check(stack.lastElement())>=1&&!stack.isEmpty()&&stack.lastElement().charAt(0)!='(') {
						n.push(stack.pop());
						if (stack.isEmpty()) {
							break;
						}
					}
					stack.push(list[i]);
					break;
				case '/':
					while(	check(stack.lastElement())>=1&&!stack.isEmpty()&&stack.lastElement().charAt(0)!='(') {
						n.push(stack.pop());
						if (stack.isEmpty()) {
							break;
						}
					}
					stack.push(list[i]);
					break;
				case '+':
					if(!stack.isEmpty()) {
					while(	check(stack.lastElement())>=0&&!stack.isEmpty()&&stack.lastElement().charAt(0)!='(') {
						n.push(stack.pop());
						if (stack.isEmpty()) {
							break;
						}
					}	}
					stack.push(list[i]);
					break;
				case '-':
					if(!stack.isEmpty()) {
						while(	check(stack.lastElement())>=0&&!stack.isEmpty()&&stack.lastElement().charAt(0)!='(') {
							n.push(stack.pop());
							if (stack.isEmpty()) {
								break;
							}
						}	
					}
					stack.push(list[i]);
					break;
				default:
					break;
				}
			}
		}
		while(!stack.isEmpty()) {
			n.push(stack.pop());
		}
		System.out.print(n);
		
	}
	static int check(String a) {
		if (a.charAt(0)=='*'||a.charAt(0)=='/') {
			return 1;
		}
		else if(a.charAt(0)=='^'){
			return 2;
		}
		else {
			return 0;
		}
	}
	
}
