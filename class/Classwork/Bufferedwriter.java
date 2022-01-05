package Classwork;
import java.io.*;
public class Bufferedwriter {
	public static void main( String[] args ){ 
	try{
	String s = "Wenzhou is situated in Zhejiang provice " +
	"and it has cultural importance.";
	File f =new File("D://Test.txt");
	if(!f.exists()){
	f.createNewFile();
	}
	FileWriter fw = new FileWriter(f, true);
    BufferedWriter bw = new BufferedWriter(fw);
	bw.write("\r\n"+s);
	bw.close();
	System.out.println("Data successfully appended at the end of file");
	}catch(IOException e){
	System.out.println("Exception occurred:");
	e.printStackTrace();
	}
	}
}
