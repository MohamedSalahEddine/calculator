package MenusEtBoiteDeDialogue;

import javax.swing.JOptionPane;

public class showOptionDialog {

	public static void main(String[] args) {
		JOptionPane jop =new JOptionPane(), jop1=new JOptionPane();
		String[] tab= {"Masculin","Feminin","Indeterminé"};
		int rang=jop.showOptionDialog(null, "choisissez votre sexe",
				"Gendarmerie nationale", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, tab, tab[1]);
		jop1.showMessageDialog(null, "votre sexe est "+tab[rang],"etat civil",JOptionPane.INFORMATION_MESSAGE);
	
	}

}
