package wartproject;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class Clientmodel {
	public static void main(String[]args) throws InterruptedException {
		
		String ip = "";
		int port = 877;
//		ip封装
		
		InetAddress host;	
		try {
			host = InetAddress.getLocalHost();
//			System.out.println(host);
			String localname = host.getHostName();
			String localip = host.getHostAddress();
//			System.out.println("host name:"+localname+"\nhost ip:"+localip);
		}
		catch (UnknownHostException e){
			e.printStackTrace();}
		
		try {
			host = InetAddress.getByName("www.wartdiagnosis.xyz");
			if (host.isReachable(1000)) {
				String hostname = host.getHostName();
				ip = host.getHostAddress();
				System.out.println("Server IP:"+ip+"\nhost name is: "+hostname);
			}			
		}catch (UnknownHostException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}			

//		发送数据
		int length= 0;
		byte[] sendbyte = null;
		Socket s = null;
	    OutputStream dos = null;
		FileInputStream fis = null;		
				
		try {
//			"localhost"
			s = new Socket(ip,port);			
						
//			图片处理		
			try {
				dos = s.getOutputStream();
				File file = new File("G:\\tank1.png");
				fis =  new FileInputStream(file);
				sendbyte = new byte [1024*4];
				while ((length = fis.read(sendbyte,0,sendbyte.length))>0) {
					dos.write(sendbyte,0,length);
					dos.flush();				
				}
//				等待时间
							
			}finally {
				dos.close();
				fis.close();
				s.close();
			}			
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(s.isClosed());
		
//			接收结果		
//		Thread.sleep(1000*5);	
		for (int i= 1; i<=10 ;i++) {
			System.out.print(i);
			 TimeUnit.SECONDS.sleep(1);
		}
		System.out.println("\n接收结果");	
		
		try {
			port = 8777;
			s = new Socket(ip,port);			
			
			try {					
				InputStream is = s.getInputStream();
				byte [] back = new byte [1024];
				int len = 0;
				StringBuilder sb = new StringBuilder();	
				
				while ((len = is.read(back)) != -1 ) {
					sb.append(new String(back, 0, len, "utf-8"));							
				}

				System.out.println("The result is: "+ sb.toString());					
				is.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}	
			
			s.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}