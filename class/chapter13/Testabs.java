package chapter13;
abstract class shape{
	abstract void Draw();
}
class Rectangle extends shape{
	void Draw() {
		System.out.println("Drawing Rectangle");
	}
}
class Circle extends Rectangle{
	void Draw () {
		System.out.println("Drawnig Circle");
	}
}
class Testabs {
	public static void main(String[]args) {
		shape s=new Circle();
		shape s1=new Rectangle();
		s.Draw();
		s1.Draw();
	}
}