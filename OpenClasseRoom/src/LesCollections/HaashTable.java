package LesCollections;

import java.util.Enumeration;
import java.util.Hashtable;

public class HaashTable {

	public static void main(String[] args) {
		Hashtable ht=new Hashtable();

		ht.put(1, "�t�");
		ht.put(4, "automne");
		ht.put(8, "hiver");
		ht.put(10, "printemps");
		
		Enumeration e= ht.elements();	
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		//methods
		System.out.println(!ht.isEmpty());
		System.out.println(ht.containsValue("�t�"));
		System.out.println(ht.containsKey(4));
		System.out.println(ht.elements());
		System.out.println(ht.keys());
	
	}

}
