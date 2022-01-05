package Exercise;
public class Shakeshands {
	public static void main(String[]args) {

		for (int number=0;number<21;number++) {
		System.out.println("If there are "+number+" people in the room then there is a total of "+shakehands(number)+" handshakes");		
	}}
	public static int shakehands(int n) {
		int d=0;
		for (int i=0; i<n;i++) {
			d+=i;
		}
		return d;
	}
}
