package wartproject;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
	 
	/**
	 * Socket之服务端
	 */
public class s1 {
	   public static void main(String[] args) 
			   throws IOException, InterruptedException {
//	        System.out.println("我是服务端");
	        //监听端口
//	       读取ip
		    String host = "";
		    int port = 877;
	        File file = new File("/www/ip");
	        BufferedReader br = new BufferedReader(
	        		new InputStreamReader(new FileInputStream(file), "utf-8"));
	        host = br.readLine();
	        System.out.println(host);
	        Socket socket = new Socket(host, port);
	        br.close();
	        
	        File result = new File("/usr/enviroment/test.log");  
	        InputStreamReader isr = new InputStreamReader(new FileInputStream(result), "utf-8");
			BufferedReader br1 = new BufferedReader(isr);
			OutputStream ops = null;
			String lineTxt = null;
			String out = null;
			
			if(file.isFile() && file.exists()) {			 				 				 
		      while ((lineTxt = br1.readLine()) != null) {
		    	  out =lineTxt;							    	  
		      }
		      
		      ops = socket.getOutputStream();		      
		      System.out.println(result);
		      ops.write(out.getBytes("utf-8"));
		      
		      ops.flush();				      
		      br1.close();
		      
		      
		    } else {
		      System.out.println("not exist!");
		    }
	   
	        ops.close();	      
	        socket.close();
	   
	        
	    }

}
