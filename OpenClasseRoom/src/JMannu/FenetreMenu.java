package JMannu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class FenetreMenu extends JFrame {
	
	JMenuBar mb=new JMenuBar();
	JMenu jmFichier=new JMenu("Fichier");
	JMenu jmEdition=new JMenu("Edition");
	JMenu jmSousFichier=new JMenu("Sous Fichier");
	
	JMenuItem jmiOuvrir=new JMenuItem("ouvrir");
	JMenuItem jmiFermer=new JMenuItem("fermer");
	JMenuItem jmiLancer=new JMenuItem("lancer");
	JMenuItem jmiArreter=new JMenuItem("arreter");
	
	JCheckBoxMenuItem jcbmi1=new JCheckBoxMenuItem("choix 1");
	JCheckBoxMenuItem jcbmi2=new JCheckBoxMenuItem("choix 2");
	
	JRadioButtonMenuItem jrbmi1=new JRadioButtonMenuItem("Radio 1");
	JRadioButtonMenuItem jrbmi2=new JRadioButtonMenuItem("Radio 2");
	
	
	
	public FenetreMenu() {
		this.setTitle("ma fenetre menu");
		this.setSize(300,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jmFichier.add(jmiOuvrir);
		jmSousFichier.add(jcbmi1);
		jmSousFichier.add(jcbmi2);
		jmSousFichier.addSeparator();
		
		jrbmi2.setSelected(true);
		ButtonGroup bg=new ButtonGroup();
		bg.add(jrbmi1);
		bg.add(jrbmi2);
		jrbmi2.setSelected(true);
		jmSousFichier.add(jrbmi1);
		jmSousFichier.add(jrbmi2);
		jmFichier.add(jmSousFichier);
		jmFichier.addSeparator();
		jmFichier.add(jmiFermer);
		jmiFermer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
			
		});
		jmEdition.add(jmiLancer);
		jmEdition.add(jmiArreter);
		mb.add(jmFichier);
		mb.add(jmEdition);
		this.setJMenuBar(mb);
		this.setVisible(true);
	}
	

	public static void main(String[] args) {
		FenetreMenu fen=new FenetreMenu();

	}

}
