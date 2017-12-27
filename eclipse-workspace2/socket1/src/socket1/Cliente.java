package socket1;

import java.io.*;
import java.net.*;

public class Cliente {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Socket meuSocket = null;
		PrintWriter out = null;
		BufferedReader in= null;
		
		try {
			meuSocket = new Socket("localhost", 9999);
			out = new PrintWriter(meuSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(meuSocket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		String linhaserv;
		String linhacli;
		
		while((linhaserv = in.readLine())!=null) {
			System.out.println("Servidor: " + linhaserv);
			if (linhaserv.equals("Adeus"))
				break;
			
			linhacli = bin.readLine();
			if(linhacli!=null) {
				System.out.println("Cliente " + linhacli);
				out.println(linhacli);
			}
			
		}
		out.close();
		in.close();
		bin.close();
		meuSocket.close();
		
		
	}

}
