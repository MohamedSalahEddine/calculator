package genericit�;

import java.util.ArrayList;
import java.util.List;

public class Genericit�EtH�ritageLaClasseGarage {
	
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
		
		Genericit�EtH�ritageLaClasseGarage garage =new Genericit�EtH�ritageLaClasseGarage();
		garage.add(listeVoiture);
		garage.add(listeVoitureSP);
		
	}
	
}
