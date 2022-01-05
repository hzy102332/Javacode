package Classwork;

public class TestPoint {
	public static void main(String[]args) {
		int a=7;
		int b=9;
		Point p1=new Point();
		Point p2=new Point();
		TotalTwice(a,p1 );
		System.out.println(a+" "+b+" "+p1.x  +" "+p2.x  );
		
		TotalTwice(b,p2);
		System.out.println(a+" "+b+" "+p1.x +" "+p2.x  );
	}
	public static void TotalTwice(int a,Point p1) {
		a=a+a;
		p1.x=a;
		System.out.println(a+" "+ p1.x );
	}

}
