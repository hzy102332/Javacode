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
 * Socket֮�ͻ���
 */
public class c1 {
    public static void main(String[] args) throws IOException, InterruptedException {
//        System.out.println("���ǿͻ���");
        
        //ָ��Ŀ������ip��˿�113.214.197.211
        int port = 877;
        System.out.println("���ǽ�����");
        ServerSocket serverSocket = new ServerSocket(port);
        //��������
        Socket socket = serverSocket.accept();
        
        
        

        System.out.println("\n��ʼ��������");
        
        InputStream is = socket.getInputStream();
		byte [] back = new byte [1024];
		int le = 0;
		StringBuilder sb1 = new StringBuilder();
		while ((le = is.read(back)) != -1 ) {
			sb1.append(new String(back, 0, le, "utf-8"));
		}
		System.out.println("The result is: "+ sb1.toString());					
		is.close();
		
        //����close��������ֱ�ӹر�����Socket����
//        outputStream.close();
        socket.close();
        serverSocket.close();
        
    }
}

