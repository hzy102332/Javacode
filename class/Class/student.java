package Class;

public class student {
public void study() {
	System.out.println("Student");
}
}
class D extends student {
	void sleep() {
	System.out.println("Sleeping");	
	}
}
class C extends D{
	void play() {
		System.out.println("Playing");
	}
	
}
