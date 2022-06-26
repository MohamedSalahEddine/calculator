package heritage;

public class Tigre extends Felin {

	public Tigre() {};
	public Tigre(int poids, String couleur) {
		this.couleur=couleur;
		this.poids=poids;
	}
	
	void crier() {
		System.out.println("je grogne tres fort");

	}

}
