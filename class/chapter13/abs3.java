package chapter13;
abstract class Bank{
	abstract double getRateofinterest();
}
class ICBC extends Bank{
	double getRateofinterest() {return 7.8;};
}
class BOC extends Bank {
	double getRateofinterest() {return 8.3;};
}
public class abs3 {
	public static void main(String[]args) {
		Bank b;
		b =new ICBC();
		System.out.println("ICBC Rate of interest:"+b.getRateofinterest());
		b=new BOC();
		System.out.println("BOC Rate of interest:"+b.getRateofinterest());
	}
	
}
