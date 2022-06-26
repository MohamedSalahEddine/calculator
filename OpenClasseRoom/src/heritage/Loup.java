package heritage;

public class Loup extends Canin {

	public Loup() {};
	public Loup(int poids, String couleur) {
		this.couleur=couleur;
		this.poids=poids;
	}
	
	void crier() {
		System.out.println("je crie whooo");

	}

}
