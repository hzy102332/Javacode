package tech2920;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[]args) {
		try {
			ServerSocket ss = new ServerSocket(8);
			Socket s = ss.accept();
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			String input;
			while (true) {
				input = dis.readUTF();
				System.out.println("Client says:"+ input);
				System.out.print("Message to return: ");
				if(input.equals("bye")) {
					break;
				}
				input = br.readLine();
//				input = "123";
				dos.writeUTF(input);
				
				if (input.equals("bye")) {
					break;
				}
			}
			
			dis.close();
			dos.close();
			s.close();
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
