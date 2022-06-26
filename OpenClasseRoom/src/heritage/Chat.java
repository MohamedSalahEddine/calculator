package heritage;

public class Chat extends Felin {

	public Chat() {};
	public Chat(int poids, String couleur) {
		this.couleur=couleur;
		this.poids=poids;
	}
	
	void crier() {
		System.out.println("je fais miaww");

	}

}
