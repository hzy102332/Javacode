package Class;

public class Try {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int a[]=new int[2];
			System.out.println("Access value 3 :"+a[3]);
		}
		catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Exception Throw : "+ ex);
		}
		System.out.println("outof catch blak");
	}

}
