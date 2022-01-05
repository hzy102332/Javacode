package Class;

public class DemoWrap1 {
	public static void main(String[]args) {
	Integer obj1=new Integer(25);
	Integer obj2=new Integer("25");
	Integer obj3=new Integer(48);
	System.out.println("Compare obj1 & obj2 using compareTo: "+obj1.compareTo(obj2));
	System.out.println("Compare obj2 & obj3 using compareTo: "+obj2.compareTo(obj3));
	System.out.println("Compare obj1 & obj2 using equals: "+obj1.equals(obj2));
	System.out.println("Compare obj2 & obj3 using equals: "+obj2.equals(obj3));
	Float f1=new Float("2.25f");
	Float f2=new Float("3.29f");
	Float f3=new Float(2.25f);
	System.out.println("Comparing f1 & f2: "+Float.compare(f1, f2));
	System.out.println("Comparing f2 & f3: "+Float.compare(f2, f3));
	Float f=obj1.floatValue();
	System.out.println("Addition of obj1 &f1 is: "+f);
	}

}
