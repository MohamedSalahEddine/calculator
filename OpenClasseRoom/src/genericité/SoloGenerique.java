package genericité;

public class SoloGenerique<T> {

	T val;
	SoloGenerique(){}
	SoloGenerique(T o){
		this.val=o;
	}
	public void setObject(T o) {
		this.val=o;
	}
	public T getObject() {
		return this.val;
	}
	public static void main(String[]args) {
		SoloGenerique<Integer> g=new SoloGenerique<Integer>(14);
		int l=g.getObject();
		System.out.println(l);
		
		//SoloGenerique<A> iA=new SoloGenerique<A>();
		SoloGenerique<String> s=new SoloGenerique<String>("toto");
		SoloGenerique<Integer> i=new SoloGenerique<Integer>(5);
		SoloGenerique<Character> c=new SoloGenerique<Character>('r');
		SoloGenerique<Double> d=new SoloGenerique<Double>(23.44);
		//SoloGenerique<Integer> iVide=new SoloGenerique<Integer>();
		//System.out.println(iVide.getObject());     elle affiche null, meme si jlé pas
		//précisé dans le constructeur par default
		
	}
}
