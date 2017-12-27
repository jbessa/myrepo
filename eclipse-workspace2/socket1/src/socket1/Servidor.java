package socket1;

import java.io.*;
import java.net.*;


public class Servidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ssock = null;
		
		try {
			ssock = new ServerSocket(9999);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			System.err.println("Não consegui lançar o servidor");
			System.exit(1);
		}
		
		Socket csock = null;
		
		try {
			csock = ssock.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Falhou a aceitação da ligação");
			System.exit(1);
		}
		
		PrintWriter out = new PrintWriter(csock.getOutputStream(), true);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(csock.getInputStream()));
		
		String entrada, saida;
		
		OMeuProtocolo mp = new OMeuProtocolo();
		
		saida = mp.processInput(null);
		out.println(saida);
		
		while((entrada=in.readLine())!=null) {
			saida = mp.processInput(entrada);
			out.println(saida);
			if(saida.equals("Adeus."))
				break;
		}
		out.close();
		in.close();
		csock.close();
		ssock.close();
		
	}

}
