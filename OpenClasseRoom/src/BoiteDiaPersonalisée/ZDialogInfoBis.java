package BoiteDiaPersonalisée;

public class ZDialogInfoBis {
	String nom,age,sexe,taille,couleur;
	
	
	public ZDialogInfoBis() {}
	public ZDialogInfoBis(String nom,String age,String sexe,String taille,String couleur) {
		this.nom=nom;
		this.age=age;
		this.sexe=sexe;
		this.taille=taille;
		this.couleur=couleur;
	}
	@Override
	public String toString() {
		String str="";
		if(this.nom!=null &&this.age!=null && this.sexe!=null && this.taille!=null && this.couleur!=null)
		{	str+= "nom du perso : "  + nom ;
		str+="\n age : " + age ;
		str+=" \nsexe : " + sexe ; 
		str+=" \ntaille : " + taille ;
		str+=" \n couleur :"+ couleur;}
		else {
			str="Aucune information";
		}
		return str;
	
	}
	
	

}
