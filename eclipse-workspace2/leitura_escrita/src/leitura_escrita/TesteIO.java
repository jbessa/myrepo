package leitura_escrita;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class TesteIO {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		//File fin=new File("entrada.txt");
		//File fout=new File("saida.txt");
		
		//FileReader in = new FileReader(fin);
		//FileWriter out = new FileWriter(fout);
		//while((c=in.read()) !=-1)
			//out.write(c);
		//in.close();
		//out.close();
		
		FileInputStream fin = new FileInputStream("entrada.txt");
		FileOutputStream fout = new FileOutputStream("saida.txt");
		FileChannel in = fin.getChannel();
		FileChannel out = fout.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(4096);
		while(in.read(buffer)!=-1||buffer.position()>0) {
			buffer.flip();
			out.write(buffer);
			buffer.compact();
			
		
	}
in.close();
out.close();
fin.close();
fout.close();
	}
}
