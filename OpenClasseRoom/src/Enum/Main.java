package Enum;

public class Main {

	public static void main(String[] args) {
		for(Langage lang : Langage.values()){
		      if(Langage.CPlus.equals(lang))
		        System.out.println("J'aime le : " + lang);
		      else
		        System.out.println(lang);
		    }
	}

}
