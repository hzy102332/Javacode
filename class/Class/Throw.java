package Class;

public class Throw {
	static void P(int age) {
		if (age <18) {
			throw new ArithmeticException ("not vaild");}
		else {
			System.out.println("Welcome !");}
	}
	public static void main(String[]args) {
		P(12);
		System.out.println("out of code");
	}
}
