package chapter13;

abstract class abstract1 {
	
	abstract void Does();
}

class abstractclass extends abstract1{
	void Does() {
		System.out.println("Doing...");
	}
	public static void main(String[]args) {
		abstractclass obj=new abstractclass();
		obj.Does();
	}

}
