package chapter17;

import java.io.FileOutputStream;

public class fileoutputstream2 {
	public static void main(String[] args) {
		try{
			FileOutputStream fo = new FileOutputStream("D:\\Text2.txt");
			String s = "Welcome to Wenzhou";
			byte b[]=s.getBytes();
			fo.write(b);
			fo.close();
			System.out.println("Success ...");
			
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}
}
