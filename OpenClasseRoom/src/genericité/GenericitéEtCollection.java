package genericité;

import java.util.ArrayList;
import java.util.List;

public class GenericitéEtCollection {

	public static void main(String[] args) {
		
		List<String> listeString=new ArrayList<String>();
		listeString.add("une chaine");
		listeString.add("une autre");
		listeString.add("encore une chaine");
		listeString.add("allé une derniere");
		System.out.println("Liste String");
		System.out.println("--------------------");
		for(String s:listeString) {
	
			System.out.println(s);
		}
		
		List<Float> listeFloat=new ArrayList<Float>();
		listeFloat.add(12.25f);
		listeFloat.add(15.25f);
		listeFloat.add(2.25f);
		listeFloat.add(128764.25f);
		System.out.println("\nListe Float");
		System.out.println("--------------------");
		for(Float s:listeFloat) {
	
			System.out.println(s);
		}
		
		
		
	}

}
