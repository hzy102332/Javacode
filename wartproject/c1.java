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
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
 
/**
 * Socket之客户端
 */
public class c1 {
    public static void main(String[] args) throws IOException, InterruptedException {
//        System.out.println("我是客户端");
        
        //指定目标主机ip与端口113.214.197.211
        int port = 877;
        System.out.println("我是接受者");
        ServerSocket serverSocket = new ServerSocket(port);
        //建立连接
        Socket socket = serverSocket.accept();
        
        
        

        System.out.println("\n开始接收数据");
        
        InputStream is = socket.getInputStream();
		byte [] back = new byte [1024];
		int le = 0;
		StringBuilder sb1 = new StringBuilder();
		while ((le = is.read(back)) != -1 ) {
			sb1.append(new String(back, 0, le, "utf-8"));
		}
		System.out.println("The result is: "+ sb1.toString());					
		is.close();
		
        //调用close方法，会直接关闭整个Socket连接
//        outputStream.close();
        socket.close();
        serverSocket.close();
        
    }
}

