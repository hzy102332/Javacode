package wartproject;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IP {
	public static void main(String []args) throws InterruptedException {
		String ip = "49.234.84.12";
		InetAddress host;
		String filename  = "F:\\"+String.valueOf(System.currentTimeMillis()%1000000000)+".png";
		System.out.println(filename);
		try {
			
			host = InetAddress.getLocalHost();
			System.out.println(host);
			String localname = host.getHostName();
			String localip = host.getHostAddress();
			System.out.println(
					"host name:"+localname+"\nhost ip:"+localip);
			readtxt("G:\\test.txt");
			
		}
		catch (UnknownHostException e){
			e.printStackTrace();
		}
//		for (int i= 0; i<=60 ;i++) {
//			System.out.println(i);
//			Thread.sleep(1000);
//		}
		
		try {
			
			host = InetAddress.getByName("www.wartdiagnosis.xyz");
			if (host.isReachable(1000)) {
				String hostname = host.getHostName();
				String ha = host.getHostAddress();
				System.out.println("Server IP:"+ha+"\nhost name is: "+hostname);
			}
			
		}catch (UnknownHostException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void readtxt (String path) {
		try {
		    File file = new File(path);
		    if(file.isFile() && file.exists()) {
		      InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
		      BufferedReader br = new BufferedReader(isr);
		      String lineTxt = null;
		      String txt = null;
		      while ((lineTxt = br.readLine()) != null) {
		    	  txt =lineTxt;
		      }
		      System.out.println(txt);
		      br.close();
		    } else {
		      System.out.println("not exist!");
		    }
		  } catch (Exception e) {
		    System.out.println("read error!");
		  }
	}

}
