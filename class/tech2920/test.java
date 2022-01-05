package tech2920;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class test {
	public static void main (String[]args) {
		IPname("49.234.84.12");

	}
	
	public static void IPname (String ip){

		InetAddress host;
		
		try {
			host = InetAddress.getLocalHost();
			String localname = host.getHostName();
			String localip = host.getHostAddress();
			System.out.println("host name:"+localname+"\nhost ip:"+localip);
		}
		catch (UnknownHostException e){
			e.printStackTrace();
		}
		
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

}
