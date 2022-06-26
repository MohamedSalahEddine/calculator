package heritage;

public class Lion extends Canin {

	public Lion() {};
	public Lion(int poids, String couleur) {
		this.couleur=couleur;
		this.poids=poids;
	}
	
	void crier() {
		System.out.println("Hear Me Roar !");

	}

}
