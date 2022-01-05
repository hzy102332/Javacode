package Class;
import java.io.*;
import java.text.*;
public class FileDate {
	public static void main(String[]args) {
		File f= new File("F:\\newabc.txt");
		SimpleDateFormat dt=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SS");
		System.out.println("Last modified at Date:"+dt.format(f.lastModified()));
	} 
}
