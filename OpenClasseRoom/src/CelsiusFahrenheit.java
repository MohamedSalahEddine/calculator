import java.util.Scanner;

public class CelsiusFahrenheit {
	

	public static void main(String[] args) {
		String Top ="convertisseur degrÈ celsius et degrÈ fahrenheit";
		String Aff="Choisissez le mode de conversion :\n1 - Convertisseur Celsius - Fahrenheit \n2 - Convertisseur Fahrenheit - Celius ";
		System.out.println(Top.toUpperCase());
		System.out.println("-----------------------------------------------");
		char rep='o';
		int choix;
		double ‡Convertir;
		double convertie;
		
		do {
		do {
				do {
					System.out.println(Aff);
					Scanner kk=new Scanner(System.in);
					choix=kk.nextInt();} while(choix!=1 && choix!=2);
			System.out.println("TempÈrature ‡ convertir :");	
			Scanner pp=new Scanner(System.in);
			‡Convertir=pp.nextDouble();
			
			if(choix==1) {convertie = ((9.0/5.0) * ‡Convertir) + 32.0;
			System.out.println(‡Convertir+" ∞C Correspond ‡ : "+convertie+" ∞F.");}
			else {convertie=((‡Convertir-32)*5)/9;
			System.out.println(‡Convertir+" ∞F Correspond ‡ : "+convertie+" ∞C.");}
			
			
			
			
			
			System.out.println("souhaitez-vous convertir une autre tempÈrature? O/N");
			Scanner sc=new Scanner(System.in);
			rep=(sc.nextLine().toUpperCase().charAt(0));
			if(rep=='N') {System.out.println("Au Revoir !");}
			else {System.out.println("rÈponsez par\'o\' ou par \'n\' la prochaine fois");}
			
			
		}
		
		while(rep=='O'); 
				
	}while(rep!='n');
	
		

	}

}
