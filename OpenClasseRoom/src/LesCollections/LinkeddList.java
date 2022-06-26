package LesCollections;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkeddList {
	
	public static void main(String[]args) {
 	LinkedList l=new LinkedList();
 	l.add("toko");
 	l.add(12);
 	l.add(12.3f);
 	
 	//*******cpécifique à la linked liste (une insertion a l'indice voulu) *******
 	l.add(1, "element");
 	
 	for(int i=0; i<l.size();i++) {
 		System.out.println("l'élement à l'indice "+i +" est : "+l.get(i));
 	}
 	
 	Iterator i=l.iterator();
 	while(i.hasNext()) {
 		System.out.println(i.next());
 	}
 	
	}
}
