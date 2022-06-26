package Etudiant;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class FenetreGesUti extends JFrame {
	
	void fermer() {
		dispose();
	}
	
	JPanel container=new JPanel();
	PanHaut haut =new PanHaut();
	PanDroite droite=new PanDroite();
	PanGauche gauche=new PanGauche();
	JButton btAjo =new JButton("Ajouter");
	JButton btSup =new JButton("Supprimer");
	JButton btMod =new JButton("Modifier");
	JButton btBac =new JButton(new ImageIcon("backk.png"));
	//JButton btAct =new JButton("Actualiser");
	JLabel labUser=new JLabel("User Name");
	JLabel labMDP=new JLabel("Mot de Passe");
	JTextField fieldUser=new JTextField();
	JTextField fieldMDP=new JTextField();
	Connection co=null;
	ResultSet res=null;
	JTable table=new JTable();
	JScrollPane scroll= new JScrollPane(table);
	
	PreparedStatement pre=null;
	
	
	public FenetreGesUti() throws SQLException {
		this.setTitle("Gestion des Utilisateurs");
		this.setSize(900, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		initComponent();
	//	btAct.addActionListener(new ActionListener() {

			//@Override
		//	public void actionPerformed(ActionEvent arg0) {
				//UpdateTable();
				
		//	}
			
		//});
		btBac.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				fermer();
				fenTout fenn=new fenTout();
				
			}
			
		});
		
		btAjo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(fieldUser.getText().equals("")|| fieldMDP.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "y'a que deux champs à remplir MERDE !");
					}
				else {
					
					try {
						String nom  =fieldUser.getText();
						String pass =fieldMDP.getText();
						String sql  ="INSERT into utilisateur (userNameUti,passeWordUti) VALUES (?, ?)";
						
						
						
						pre=co.prepareStatement(sql);
						
						pre.setString(1,nom);
						pre.setString(2,pass);
						pre.execute();
						fieldUser.setText("");
						fieldMDP.setText("");
						UpdateTable();
						JOptionPane.showMessageDialog(null, "utilisateur créé");
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			
			}});
		
		btSup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String req="DELETE FROM utilisateur where userNameUti = ? AND passeWordUti= ?";
				try {
					pre =co.prepareStatement(req);
					pre.setString(1, fieldUser.getText());
					pre.setString(2, fieldMDP.getText());
					pre.execute();
					fieldUser.setText("");
					fieldMDP.setText("");
					btSup.setEnabled(false);
					btMod.setEnabled(false);
					UpdateTable();
					JOptionPane.showMessageDialog(null, "utilisateur supprimé");
				
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
			
		});
		fieldUser.addKeyListener(new KeyAdapter() {
			@Override 
			public void keyReleased (KeyEvent ee) {
				String sql="SELECT PasseWordUti FROM utilisateur WHERE userNameUti= ?";
				try {
					
					pre=co.prepareStatement(sql);
					pre.setString(1, fieldUser.getText().toString());
					res=pre.executeQuery();
					if(res.next()) {
						fieldMDP.setText(res.getString("PasseWordUti"));
						btSup.setEnabled(true);
						btMod.setEnabled(true);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btMod.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String sql="UPDATE utilisateur SET passeWordUti = ? WHERE userNameUti = ? ";
				try {
					pre=co.prepareStatement(sql);
					pre.setString(1, fieldMDP.getText());
					pre.setString(2, fieldUser.getText());
					pre.execute();
					fieldUser.setText("");
					fieldMDP.setText("");
					btMod.setEnabled(false);
					btSup.setEnabled(false);
					UpdateTable();
					JOptionPane.showMessageDialog(null, "utilisateur modifié");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		});
		
		this.setContentPane(container);
		this.setVisible(true);
		
	}
	
	
	void initComponent() throws SQLException{
		// if faut enlever le cast
		 co=  Connexion.ConnexionDB();
		
		 scroll.setPreferredSize(new Dimension(430,450));
		haut.setPreferredSize(new Dimension(700,100));
		droite.setPreferredSize(new Dimension(this.getWidth()/2,400));
		gauche.setPreferredSize(new Dimension(this.getWidth()/2,400));
		btAjo.setBounds(300, 120, 100, 50);
		btSup.setBounds(300, 210, 100, 50);
		//btAct.setBounds(300, 50, 80, 40);
		btSup.setEnabled(false);
		btMod.setBounds(300, 300, 100, 50);
		btMod.setEnabled(false);
		labUser.setBounds(10, 150, 100, 30);
		labMDP.setBounds(10, 220, 100, 30);
		fieldUser.setBounds(110, 150, 150, 30);
		fieldMDP.setBounds(110, 220, 150, 30);
		btBac.setBounds(0, 0, 50, 50);
		gauche.add(btBac);
		gauche.setLayout(null);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i =table.getSelectedRow();
				btMod.setEnabled(true);
				btSup.setEnabled(true);
				
				String user=(String) table.getModel().getValueAt(i, 0);
				String pass=(String) table.getModel().getValueAt(i, 1);
				
				fieldUser.setText(user);
				fieldMDP.setText(pass);
			}
		});
		gauche.add(btAjo);
		gauche.add(btSup);
		gauche.add(btMod);
		gauche.add(labUser);
		gauche.add(labMDP);
		gauche.add(fieldUser);
		gauche.add(fieldMDP);
	//	gauche.add(btAct);
		
		droite.add(scroll);
		container.setLayout(new BorderLayout());
		container.add(haut,BorderLayout.NORTH);
		container.add(droite,BorderLayout.EAST);
		container.add(gauche,BorderLayout.WEST);
	}
	
	void UpdateTable(){
		String sql="SELECT UserNameUti, passeWordUti FROM utilisateur";
		try {
			pre=co.prepareStatement(sql);
			res=pre.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(res));
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws SQLException {
		FenetreGesUti fen=new FenetreGesUti();

	}

}
