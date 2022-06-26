package heritage;

public class Main {

	public static void main(String[] args) {
		Lion l = new Lion(20,"ocre");
		l.boire();
		l.manger();
		l.deplacer();
		l.crier();
		System.out.println(l.toString());
		

	}

}
