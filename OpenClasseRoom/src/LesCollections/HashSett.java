package LesCollections;

import java.util.HashSet;
import java.util.Iterator;

public class HashSett {

	public static void main(String[] args) {
	//	*
	//  set==pas de doublons.
	//  *
		
	HashSet hs=new HashSet();
	hs.add("hehe");
	hs.add('C');
	hs.add(11);
	
	Iterator i=hs.iterator();
	while(i.hasNext()) {
		System.out.println(i.next());
	}
	
	Object[] obj =hs.toArray();
	for(Object o : obj) {
		System.out.println(o);
	}
	
	}

}
