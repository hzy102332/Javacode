package wartproject;


import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;


public class wartServer implements Runnable{
	public static void main(String[]args) {		
		
		try {
			ServerSocket ss = new ServerSocket(877);
			Thread th = new Thread(new Runnable() {
				public void run () {
					while (true) {						
						try{
							System.out.println("Start listening");
							Socket s = ss.accept();
							System.out.println("There is a link !\n"+
							"Client IP address:"+s.getInetAddress().getHostAddress());
//							write("/www/ip",s.getInetAddress().getHostAddress() );
//							接受图片
							receivefile(s);	
							
//							for (int i= 1; i<=10 ;i++) {
//								System.out.print(i);
//								 TimeUnit.SECONDS.sleep(1);
//							}
//							返回结果
							ServerSocket ss = new ServerSocket(8777);
							s = ss.accept();
							returnresult(s);
							System.out.println("Diagnosis completed !");
							
						}catch (Exception e) {
							
						}
					}
				}});
			th.run();			
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {		
	}
	
	public static void receivefile (Socket socket) {
		byte [] inputbyte = null;
		int length = 0;
		InputStream dis = null;
		FileOutputStream fos = null;				
//		F:\\"+"
		String filename  = "/www/wwwroot/picture/uploadpicture"+".png";	
		
		try {
			try {
//				接收图片
				dis = socket.getInputStream();
				fos = new FileOutputStream(new File(filename));
				inputbyte = new byte[1024*4];
				System.out.println("Begin to receive");
				while ((length = dis.read(inputbyte, 0, inputbyte.length))>0) {
					fos.write(inputbyte, 0, length);
					fos.flush();
				}
				System.out.println("Finished ！\nWaiting for the result ...");
	
//				等待结果1min
//				for (int i= 1; i<=10 ;i++) {
////					System.out.print(i);
//					TimeUnit.SECONDS.sleep(1);
//				}
																		
			}finally {
				fos.close();
			    dis.close();
//				socket.close();
			}			
		}catch (Exception e) {			
			
		}
				
	}

	public static void returnresult (Socket socket) {
		System.out.println("发送数据");			
		try {
		File file = new File("/usr/enviroment/test.txt");  
		InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
		BufferedReader br = new BufferedReader(isr);
		DataOutputStream dos = null;
		OutputStream ops = null;
		String lineTxt = null;
		String result =null;	
						
		if(file.isFile() && file.exists()) {
								 				 				 
			while ((lineTxt = br.readLine()) != null) {
				System.out.println(lineTxt);
				result =lineTxt;							    	  
			}
						      
			dos = new DataOutputStream(socket.getOutputStream());
			ops = socket.getOutputStream();							      
						      
			System.out.println(result);
			ops.write(result.getBytes("utf-8"));
						      
			ops.flush();				      
			br.close();							      
						      
		} else {
			System.out.println("not exist!");
		}										      						   
			ops.close();
			dos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void write (String path, String data) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(path));
		bw.write(data);
		bw.close();
		System.out.println("successed !");
	}
}








