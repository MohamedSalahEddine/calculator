package MenusEtBoiteDeDialogue;

import javax.swing.JOptionPane;

public class Test {

	public static void main(String[] args) {
		
		JOptionPane jop =new JOptionPane(),jop1=new JOptionPane();
		String nom = jop.showInputDialog(null, "identifiez-vous", "Gendarmerie nationale", JOptionPane.QUESTION_MESSAGE);
		jop1.showMessageDialog(null, "votre nom est : "+nom , "Identifié", JOptionPane.INFORMATION_MESSAGE);
	}

}
