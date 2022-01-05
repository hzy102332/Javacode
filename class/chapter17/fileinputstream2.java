package chapter17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;

public class fileinputstream2 {
	public static void main(String[] args) {
		 try {
			 FileInputStream fi = new FileInputStream("D:\\Text2.txt");
			 FileInputStream f2 = new FileInputStream("D:\\Text1.txt");
			 FileOutputStream fo =  new FileOutputStream("D:\\Textresult.txt");
			 SequenceInputStream sis = new SequenceInputStream(fi, f2);
			 int i = 0;			 
			 while ((i=sis.read())!=-1) {
//				 System.out.println((char)i);
				 fo.write(i);
			 }
			 sis.close();
			 fi.close();
			 f2.close();
		 }
		 catch (Exception e ) {
			 System.out.println(e);
		 }
	 }
}
