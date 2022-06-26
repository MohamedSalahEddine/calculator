
public class tabBiDimensionel {

	public static void main(String[] args) {
		String [][] kk= {{"toko","koko","momo","lolo"},
						 {"titi","kiki","mimi","lili"},
						 {"tata","kaka","mama","lala"},
						 {"tutu","kuku","mumu","lulu"}};
		
		for(String []p:kk) {
			for(String m:p) {
				System.out.println("la valeur est "+m);
			}
		}

	}

}
