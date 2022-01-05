package Class;

public class Finally {
	public static void main(String[]args) {
		int a[]=new int[3];
		System.out.println("Still out of Try block");
		try {
			System.out.println("Try to access invalid element :"+a[5]);
		}
		finally {
			System.out.println("This block is alway Executed");
		}
	}

}
