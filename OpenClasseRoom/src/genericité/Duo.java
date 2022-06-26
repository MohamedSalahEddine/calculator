package genericité;

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Duo<L,T> {
	
	L val1;
	T val2;
	
	 Duo() {}
	 Duo(L l,T t) {
		this.val1=l;
		this.val2=t;
	}
	 
	 public L getVal1() {return val1;}
	 public T getVal2() {return val2;}
	 
	 public void setVal1(L l) {this.val1=l;}
	 public void setVal2(T t) {this.val2=t;}

	public static void main(String[] args) {
		
		Duo<String,Boolean> Dual1     =new Duo<String,Boolean>("toto",true);
		System.out.println("valaurs de l'objet dual1: val1 = "+Dual1.getVal1()+", valeur 2 = "+Dual1.getVal2());
		Duo<Double,Character> Dual2  =new Duo<Double,Character>(12.2595,'C');
		System.out.println("valaurs de l'objet dual2: val1 = "+Dual2.getVal1()+", valeur 2 = "+Dual2.getVal2());
		
		

	}

}
