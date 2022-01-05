package Class;

import java.io.IOException;

public class Throw2 {
	void m() throws IOException{
		throw new IOException("Some Problems");
	}
	void n() throws IOException{
		m();
	}
	void p() {
		try {
			n();
		}
		catch (Exception e){
			System.out.print("Exception Handled");
		}
	}
	public static void main(String[]args) {
		Throw2 obj=new Throw2();
		obj.p();
	}
}
