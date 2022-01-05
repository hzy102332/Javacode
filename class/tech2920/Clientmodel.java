package tech2920;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Clientmodel {
	public static void main(String[]args) {
		try {
			
			Socket s = new Socket("localhost",8);
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			String input;
			while (true) {
				System.out.print("Message:");
				input = br.readLine();
//				input = "asd";
				dos.writeUTF(input);

				if(input.equals("bye")) {
					break;
				}
				System.out.println("1");
				input = dis.readUTF();
				
				System.out.println("Server says:"+input);
				
				if (input.equals("bye")) {
					break;
				}
			}
			
			dis.close();
			dos.close();
			s.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
