package heritage;

public class Chien extends Canin {

	public Chien() {};
	public Chien(int poids, String couleur) {
		this.couleur=couleur;
		this.poids=poids;
	}
	
	void crier() {
	System.out.println("j'aboie pour rien");

	}

}
