package LesCollections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayLList {

	public static void main(String[] args) {
		ArrayList a=new ArrayList();
		a.add(13);
		a.add("koko");
		a.add(null);
		a.add(22.34);
		a.remove(2);
		
		Iterator i=a.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		if(a.contains(null)) {
			System.out.println("Il y a un element null dans la liste a");
		}
		else {System.out.println("la liste ne contient pas d'éléments null");}
	}

}
