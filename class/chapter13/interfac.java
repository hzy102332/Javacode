package chapter13;

public class interfac {
public static void main(String[]args) {
	in a= new M();
	a.x();
	a.y();
	a.z();
	a.w();
}
}
interface in{
	void x();
	void y();
	void z();
	void w();
}
abstract class B implements in{
	public void z() {System.out.println("I am method z");}
}
class M extends B{
	public void x() {System.out.println("I am method x");}
	public void y() {System.out.println("I am method y");}
	public void w() {System.out.println("I am method w");}
}

