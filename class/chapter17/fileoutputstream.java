package chapter17;

import java.io.FileOutputStream;

public class fileoutputstream {

	public static void main(String[] args) {
		try{
			FileOutputStream fo = new FileOutputStream("D:\\Text1.txt");
			fo.write(65);
			fo.close();
			System.out.println("Success ...");
			
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
