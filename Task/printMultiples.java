/**
 * 
 */
package Task;

/**
 * @author ºúÔóÑô
 *
 */
public class printMultiples {
	public static void main(String[]args) {
		printMultiples(3,5);
	}
	public static void printMultiples(int n,int time) {
		System.out.print("The first "+ time+"mutiples of "+n+"are "+n);
		for (int i=2;i<=time;i++) {
			System.out.print(", "+i*n);
		}
	}

}
