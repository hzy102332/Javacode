package Task;

public class Trycatch {
	public static void main(String[] args) {
		
			System.out.println("We are in try block now");
			int a[]=new int[7];
			for (int b=0,i=8;i>=6;i--,b++) {
		try {
				a[i]=7/b;
				if (i==6) {
					String s="abc";
					System.out.println(s.charAt(3));
				}
		}
		catch(ArithmeticException e) {
			System.out.println("Warning: ArithmeticException");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception caught : ArrayIndexOutOfBounds");
		}
		catch(Exception e) {
			System.out.println("Warning : Some other Exception");
		}}
		System.out.println("we are out of catch block now");
	}
}
