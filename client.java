package tanks;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class client {

	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
		
		
		Socket s= new Socket("localhost",9999);
		String str = "test";
		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
		PrintWriter out = new PrintWriter(os);
		os.write(str);
		os.close();
		
		//os.flush();
		
		
		
		
    }
		
		
	}

			
		
			