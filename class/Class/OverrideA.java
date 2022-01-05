package Class;

public class OverrideA {
	public void more() {
		System.out.println("Animals can more");
	}
}
class OverrideB extends OverrideA{
	public void more() {
//		System.out.println("Animals can walk & fly too");
		super.more();
		System.out.println("Animal can walk & fly too");
	}
}