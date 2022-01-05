package Class;

public class TestStringBuilder {

	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder();
		sb.append("ABC");
		System.out.println("String: "+sb.toString());
		StringBuilder sb1=new StringBuilder("Wenzhou");
		System.out.println("String1: "+sb1.toString());
		StringBuilder sb2=new StringBuilder(10);
		System.out.println("String2 Capacity: "+sb2.capacity());
		StringBuilder sb3=new StringBuilder(sb);
		System.out.println("String3: "+sb3.toString());
	}

}
