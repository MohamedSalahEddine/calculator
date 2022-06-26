package InputOutputFiles;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// Data writing and reading
		
		DataInputStream dis;
		DataOutputStream dos;
		try {
		dos = new DataOutputStream(
				  (new BufferedOutputStream(
						  new FileOutputStream( new File("tokoto.txt")))));
		
		dos.writeInt(100);
		dos.writeBoolean(true);
		dos.writeChar('c');
		
		dos.close();
		
		dis=new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(new File("tokoto.txt"))));
		
		System.out.println(dis.readInt());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readChar());
		dis.close();
		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
