package Etudiant;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class fenTout extends JFrame {
	
	JPanel container =new JPanel();
	JPanel center =new JPanel();
	PanHaut north =new PanHaut();
	JPanel northh=new JPanel();
	
	JLabel uti=new JLabel("Gestion Utilisateur");
	JLabel etu=new JLabel("Gestion des etudiants");
	JLabel fil=new JLabel("Gestion de filieres");
	JLabel abs=new JLabel("Gestion des absence");
	JLabel mat=new JLabel("Gestion de matières");
	JLabel not=new JLabel("Gestion des notes ");
	
	void fermer() {
		dispose();
	};
	
	public fenTout() {
		this.setTitle("Fenetre principale");
		this.setSize(900, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		initCompo();
		this.setVisible(true);
	}

		void initCompo(){
			
			
			container.setLayout(new BorderLayout());
			north.setPreferredSize(new Dimension(900,100));
			
			
			
			
			JButton btUti=new JButton(new ImageIcon("utilisateur.png"));
			JButton btEtu=new JButton(new ImageIcon("etudiants.png"));
			JButton btFil=new JButton(new ImageIcon("filiere.png"));
			JButton btAbs=new JButton(new ImageIcon("absence.png"));
			JButton btMat=new JButton(new ImageIcon("matiere.png"));
			JButton btNot=new JButton(new ImageIcon("note.png"));
			
			btUti.setBounds(180, 110, 100, 100);
			btEtu.setBounds(380, 110, 100, 100);
			btFil.setBounds(580, 110, 100, 100);
			btAbs.setBounds(180, 250, 100, 100);
			btMat.setBounds(380, 250, 100, 100);
			btNot.setBounds(580, 250, 100, 100);
			
			uti.setBounds(175, 80, 110, 20);
			etu.setBounds(375, 80, 130, 20);
			fil.setBounds(575, 80, 110, 20);
			abs.setBounds(175, 360, 130, 20);
			mat.setBounds(375, 360, 130, 20);
			not.setBounds(575, 360, 110, 20);
			
			center.setBackground(Color.orange);
			center.setLayout(null);
			center.add(btUti);
			center.add(btEtu);
			center.add(btFil);
			center.add(btAbs);
			center.add(btMat);
			center.add(btNot);
			center.add(uti);
			center.add(etu);
			center.add(fil);
			center.add(abs);
			center.add(mat);
			center.add(not);
			
			btFil.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					FenFil fil =new FenFil();
					fermer();
					
				}
				
			});
			
			btUti.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					try {
						FenetreGesUti aut =new FenetreGesUti();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					fermer();
				}
				
			});
			btEtu.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					FenGesEtu aut =new FenGesEtu();
					fermer();
				}
				
			});
			
			container.add(north,BorderLayout.NORTH);
			container.add(center,BorderLayout.CENTER);
			this.setContentPane(container);
			
			
	}
	
		
		
	public static void main(String[] args) {
		fenTout fen =new fenTout();

	}

}
