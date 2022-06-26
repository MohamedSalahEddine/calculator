package InputOutputFiles;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterReaderTresSimple {
	public static void main(String[]args) {
		
		FileWriter fw;
		FileReader fr;
		String str;
		
		File file=new File("towkow.txt");
		try {
			
			//ecriture
		fw=new FileWriter(file);
		str="salut tout le monde cv la sante?";
		fw.write(str);
		fw.close();
		
		
			//lecture
		fr=new FileReader(file);
		int i=0;
		while((i=fr.read())!= -1) {
			str=str+(char)i;
		}
		System.out.println(str);
		
		
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
