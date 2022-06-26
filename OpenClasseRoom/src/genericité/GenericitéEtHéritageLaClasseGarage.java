package genericité;

import java.util.ArrayList;
import java.util.List;

public class GenericitéEtHéritageLaClasseGarage {
	
	List<Voiture> liste=new ArrayList<Voiture>();
	
	public void add(List<? extends Voiture> l) {
		for(Voiture v: l) {
			liste.add(v);
		}
	
		System.out.println("contenu de mon garage");
		for(Voiture v:liste) {
			System.out.println(v.toString());
		}
		
	}
	public static void main(String[]args) {
		List<Voiture> listeVoiture=new ArrayList<Voiture>();
		listeVoiture.add(new Voiture());
		listeVoiture.add(new Voiture());
		
		List<VoitureSansPermis> listeVoitureSP = new ArrayList<VoitureSansPermis>();
		listeVoitureSP.add(new VoitureSansPermis());
		listeVoitureSP.add(new VoitureSansPermis());
		
		GenericitéEtHéritageLaClasseGarage garage =new GenericitéEtHéritageLaClasseGarage();
		garage.add(listeVoiture);
		garage.add(listeVoitureSP);
		
	}
	
}
