package heritage;

public abstract class Animal {

	protected int poids;
	protected String couleur;
	
	protected void manger() {
		System.out.println("je mange de la viande");
	}
	protected void boire() {
		System.out.println("je bois de l'eau");
	}
	
	abstract void deplacer();
	abstract void crier();
	
	public String toString() {
		return "je suis de la "+this.getClass()+" je suis "+this.couleur+" je pèse "+this.poids+" kilos.";
	}
}
