package tanks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

	
	public static void main (String [] args) throws Exception{
		
		System.out.println("Server has started");
		ServerSocket ss = new ServerSocket(9999);
		System.out.println("Waiting for client request...");

		Socket s = ss.accept();
		System.out.println("Client Connected");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str = br.readLine();
		System.out.println("Client says:"+ str);

	}
}
