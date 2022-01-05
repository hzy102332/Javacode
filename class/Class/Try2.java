package Class;

public class Try2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			for (int i=5;i>=0;i--) {
//				System.out.println(10/i);
//			Object s=null;
//			System.out.println(s.toString());
			Object s=new Object();
			String d=(String)s;
//			System.out.println(1.0/0);
		}
		catch (Exception e) {
			System.out.println("Exception in message :"+e.getMessage());
			e.printStackTrace();
		}
		System.out.println("outside for loop");
	}

}

