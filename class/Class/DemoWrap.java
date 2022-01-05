package Class;

public class DemoWrap {
	public static void main(String[] args) {
		Integer intwrap1=Integer.valueOf("123");
		Integer intwrap2=Integer.valueOf("11011",2);
		Integer intwrap3=Integer.valueOf("1AD",16);
		System.out.println("Value of intwrap1: "+intwrap1);
		System.out.println("Value of intwrap2: "+intwrap2);
		System.out.println("Value of intwrap3: "+intwrap3);
		System.out.println("Hex value of intwrap1:"+Integer.toHexString(intwrap1));
		System.out.println("Binary value of intwrap2: "+Integer.toBinaryString(intwrap2));
		System.out.println("Binary value of intwrap3: "+Integer.toBinaryString(intwrap3));
	}

}
