package lab7;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class symbolsbalance {
		public static void main(String[]args) {
			Scanner s = new Scanner (System.in);
			System.out.print("Please enter the expression: ");
			String ex = s.nextLine();
			
			char[] line = ex.toCharArray();
			System.out.println(Arrays.toString(line));
			ifbalanhce (line);
			
		}
		public static void ifbalanhce(char [] line) {

			Stack<Character> stack = new Stack<Character>();
			boolean t = true;
			for (int i = 0; i < line.length; i++) {	
				switch (line[i]) {
				case '[':
					stack.push('[');
					break;
				case '(':
					stack.push('(');
					break;
				case '{':
					stack.push('{');
					break;
				case '/':
					if (i < line.length - 1 && line[i+1] == '*') {
						stack.push('/');
						stack.push('*');
					}
					break;
				case ']':
					if (stack.size() == 0 || stack.pop() != '[') {
						System.out.println("illigal character" + "[]");
						t = false;
					}
					break;
				case ')':
					if (stack.size() == 0 || stack.pop() != '(') {
						System.out.println("illigal character" + "()");
						t = false;
					}
					break;
				case '}':
					if (stack.size() == 0 || stack.pop() != '{') {
						System.out.println("illigal character" + "{}");
						t = false;
					}
					break;
				case '*':
					if ((i < line.length - 1 && line[i+1] == '/')&& (stack.size() < 2 || (stack.pop() != '*' || stack.pop() != '/'))) {
						System.out.println("illigal character" + "");
						t = false;
					}
					break;
				default:
					break;
				}
			}
			if (t) {
				while (!stack.isEmpty()) {
					t = false;
					System.out.println("There remain the symbol:"+stack.pop()+" ");
				}
				if (t) {
					System.out.println("Symbol balanced");
				}
			}
		}
	}
