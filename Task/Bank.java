package Task;

public class Bank {
	public static void main(String[]args) {
	 ABCBank obj=new ABCBank ();
	 obj.Rateofinterest();
	}
}
class ICBC {
	public void Rateofinterest() {
		System.out.println("ICBC Rateofinterest : 8.5%");
	}
}
class BankofChina extends ICBC{
	public void Rateofinterest() {
		super.Rateofinterest();
	    System.out.println("BOC  Rateofinterest : 9.3%");
}
}
class ABCBank extends BankofChina{
	public void Rateofinterest() {
		super.Rateofinterest();
	    System.out.println("ABCB Rateofinterest : 7.9%");
}
	
}