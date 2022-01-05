package chapter17;

import java.io.FileInputStream;

public class fileinputstream {
	public static void main(String[] args) {
	 try {
		 FileInputStream fi = new FileInputStream("D:\\Text2.txt");
		 int i = 0;
		 while ((i=fi.read())!=-1) {
			 System.out.println((char)i);
		 }
		 fi.close();
	 }
	 catch (Exception e ) {
		 System.out.println();
	 }
 }
}
