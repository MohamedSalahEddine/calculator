package Etudiant;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FenAuthentifier extends JFrame {
	
	JLabel labUti=new JLabel("nom d'utilisateur");
	JLabel labPas=new JLabel("mot de passe");
	JTextField fieldUti=new JTextField();
	JTextField fieldPas=new JTextField();
	JPanel container=new JPanel();
	JButton btCon=new JButton("Se connecter");
	Connection conn;
	PreparedStatement prep;
	ResultSet res;
	boolean fen =false;
	boolean fenAut =true;
	
	void fermer() {
		dispose();
	}
public 	FenAuthentifier() {
	this.setTitle("authenification");
	this.setSize(600, 500);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	conn =Connexion.ConnexionDB();
	btCon.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String pass=fieldPas.getText().toString();
			String uti=fieldUti.getText().toString();
			String sql="Select * FROM utilisateur";
			
			try {
				prep =conn.prepareStatement(sql);
				res =prep.executeQuery();
				while(res.next()) {	
					if(uti.equals(res.getString(2))&& pass.equals(res.getString(3))) {
						
						fenAut=false;
						//affOuPas();
						fenTout fen = new fenTout();
						fermer();
						
					}
					
					
					
				}
				if(fenAut) {
					JOptionPane.showMessageDialog(null, "idientifiants erronés");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}});
	initComponent();
	affOuPas();
}

 void affOuPas() {
	 if(fenAut) {
		 this.setVisible(true);
	 }
	 else{
		 this.setVisible(false);}
 }

void initComponent() {
	container.setLayout(null);
	container.setBackground(Color.orange);
	labUti.setBounds(150, 130, 100, 30);
	labPas.setBounds(150, 170, 100, 30);
	fieldUti.setBounds(300,130,100,30);
	fieldPas.setBounds(300,170,100,30);
	container.add(labUti);
	container.add(labPas);
	container.add(fieldUti);
	container.add(fieldPas);
	btCon.setBounds(225, 220, 150, 50);
	container.add(btCon);
	this.setContentPane(container);
	
}
	public static void main(String[] args) {
		FenAuthentifier f=new FenAuthentifier();

	}

}
