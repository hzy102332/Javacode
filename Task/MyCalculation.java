package Task;

public class MyCalculation extends Calculation{
		public static void main(String[]args) {
			MyCalculation obj=new MyCalculation();
			obj.Output();
			System.out.println("Total is: "+obj.Addition(9, 7));
			System.out.println("Subtraction is: "+obj.Subtraction(9, 7));
			System.out.println("Product is: "+obj.Multiplication(9, 7));
		}
		int Multiplication(int x,int y) {
			return (x*y);
	}
}
