package Classwork;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class writefile {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		File f;
		String a = "Welcome to Wenzhou" +
		" It is a beautiful city! \n";
		try {
		//Specify the file path here
		f = new File("D:/Test.txt");
		fos = new FileOutputStream(f);
		if (!f.exists()) {
		f.createNewFile();
		}
		byte[] arr = a.getBytes();
		fos.write(arr);
		fos.flush();
		System.out.println("File Written Successfully");
		}
		catch (IOException e) {
		e.printStackTrace();
		}
		finally {
		try {
		if (fos != null)
		{
		fos.close();
		}
		}
		catch (IOException e) {
		System.out.println("Error in closing the Stream");
		}
		}
		}
}

