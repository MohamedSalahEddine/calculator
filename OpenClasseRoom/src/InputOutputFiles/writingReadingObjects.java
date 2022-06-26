package InputOutputFiles;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class writingReadingObjects {

	public static void main(String[] args) {
		
		ObjectOutputStream oos;
		ObjectInputStream ois;
		
		try{
			oos=new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(new File("game.txt"))));
			oos.writeObject(new Game("assasinCreed","guerre",22.23));
			oos.writeObject(new Game("Dofus","MMORPG",00.00));
			
			oos.close();
			
			ois= new ObjectInputStream(
					 new BufferedInputStream(
							new FileInputStream (new File("game.txt"))));
			System.out.println("Affichage des jeux \n-----------------------\n");
			System.out.println(ois.readObject().toString());
			System.out.println("\n");
			System.out.println(ois.readObject());
			
			oos.close();
			
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		catch(FileNotFoundException e ) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		} 

	}

}
