package InputOutputFiles;

import java.io.Serializable;

public class Game implements Serializable {
	
	String nom, style;
	double prix;
	
	Game(String nom, String style, double prix){
		this.nom=nom;
		this.prix=prix;
		this.style=style;
	}

	@Override
	public String toString() {
		return "nom du jeu :"+this.nom+"\nSon style : "+this.style+"\nil coûte :"+this.prix;
	}
}
