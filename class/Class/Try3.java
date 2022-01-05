package Class;

public class Try3 {

	public static void main(String[] args) {
		try {
			int a[]=new int[7];
			a[5]=25/0;
			System.out.println("We are in try block now");
			System.out.println("2");
		}
		catch(ArithmeticException e) {
			System.out.println("Warning: AruthmeticException");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception caught : ArrayIndexOutOfBounds");
		}
		catch(Exception e) {
			System.out.println("Warning : Some other Exception");
		}
		System.out.println("we are out of catch block now");
	}

}
