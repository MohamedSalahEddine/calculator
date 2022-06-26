package UML;

public class ObjectA {
	ObjectC objC=new ObjectC();
	ObjectD[] objD=new ObjectD[5];
	
	protected ObjectC getObjectC() {
		return objC;
	}
	protected ObjectD[] getObjectsD() {
		return objD;
	} 

}
