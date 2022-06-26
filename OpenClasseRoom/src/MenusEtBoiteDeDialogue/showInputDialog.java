package MenusEtBoiteDeDialogue;

import javax.swing.JOptionPane;

public class showInputDialog {

	public static void main(String[] args) {
		JOptionPane jop=new JOptionPane(),jop1=new JOptionPane();
		String [] tab= {"Masculin","Feminin","Indeterminé"};
		String sexe =(String)jop.showInputDialog(null,"Veuillez indiquer votre sexe!","Gendarmerie nationale",JOptionPane.QUESTION_MESSAGE,null,tab,tab[0]);
		jop1.showMessageDialog(null, "Votre sexe est : "+sexe,"sexe",JOptionPane.INFORMATION_MESSAGE);
		
	}

}
