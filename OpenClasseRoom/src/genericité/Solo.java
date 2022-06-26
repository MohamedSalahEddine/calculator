package genericité;

public class Solo {
	
	Object valeur;
	Solo(Object o){
		this.valeur=o;
	}
	public void setObject(Object o) {
		this.valeur=o;
	}
	public Object getObject() {
		return this.valeur;
	}
	public static void main(String[]args) {
		Solo k=new Solo(13);
		int p=(int)k.getObject();
		System.out.println(p);
	}
}
