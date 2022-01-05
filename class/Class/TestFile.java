package Class;
import java.io.*;
public class TestFile {
	public static void main(String[]args) {
	try {
		File f=new File("F:\\abc.txt");
		boolean b=f.createNewFile();
		if(b) {
			System.out.println("File create successfully");
		}
		else {
			System.out.println("File Already present at special location!");
		}
	}
	catch (Exception ex){
		System.out.println("Exception occursed!");
		ex.printStackTrace();
	}
}}
