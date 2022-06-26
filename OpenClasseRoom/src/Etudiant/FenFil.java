package Etudiant;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class FenFil extends JFrame{
	
	Connection co;
	PreparedStatement pre;
	ResultSet res;
	
	PanHaut haut =new PanHaut();
	JPanel container =new JPanel();
	JPanel droite =new JPanel();
	JPanel gauche =new JPanel();
	JPanel gaucheH =new JPanel();
	JPanel gaucheB =new JPanel();
	JTable table =new JTable();
	JScrollPane scroll=new JScrollPane(table);
	JButton btAFil =new JButton(new ImageIcon("btAFil.png"));
	JButton btSFil =new JButton(new ImageIcon("btSFil.png"));
	JButton btMFil =new JButton(new ImageIcon("btMFil.png"));
	JButton back =new JButton(new ImageIcon("backk.png"));
	
	JTextField fieldNomFil=new JTextField();
	JComboBox comboFil =new JComboBox();
	JLabel labTypeFil =new JLabel("Type");
	JLabel labNomFil =new JLabel("Nom Filière");

	public FenFil(){
		this.setTitle("Fenetre Gestion Filière");
		this.setSize(900, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		initCompo();
	//	updateTable();
		this.setVisible(true);
	}
	void initCompo(){
		container.setLayout(new BorderLayout());
		haut.setPreferredSize(new Dimension(900,100));
		droite.setBackground(Color.white);
		
		container.add(haut,BorderLayout.NORTH);
		this.setContentPane(container);
		droite.setPreferredSize(new Dimension(450,500));
		gauche.setPreferredSize(new Dimension(450,500));
		gaucheH.setPreferredSize(new Dimension(450,350));
		gaucheB.setPreferredSize(new Dimension(450,150));
		gauche.setLayout(new BorderLayout());
		btAFil.setBounds(90, 50, 75, 75);
		btSFil.setBounds(190, 50, 75, 75);
		btMFil.setBounds(290, 50, 75, 75);
		gaucheH.setLayout(null);
		gaucheB.setLayout(null);
		gaucheB.add(btAFil);
		gaucheB.add(btSFil);
		gaucheB.add(btMFil);
		labNomFil.setBounds(10, 150, 100, 30);
		labTypeFil.setBounds(50, 200, 50, 30);
		fieldNomFil.setBounds(120, 150, 300, 30);
		comboFil.setBounds(120, 200, 300, 30);
		back.setBounds(0, 0, 50, 50);
		gaucheH.add(labNomFil);
		gaucheH.add(labTypeFil);
		gaucheH.add(fieldNomFil);
		comboFil.addItem("Selectionez");
		comboFil.addItem("Licence Profesionelle");
		comboFil.addItem("Licence Academique");
		gaucheH.add(comboFil);
		
		scroll.setPreferredSize(new Dimension(430,460));
		droite.add(scroll);
		
		gaucheH.add(back);
		gauche.add(gaucheH,BorderLayout.NORTH);
		gauche.add(gaucheB,BorderLayout.SOUTH);
		container.add(gauche,BorderLayout.WEST);
		container.add(droite,BorderLayout.EAST);
		co= Connexion.ConnexionDB();
		
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				fenTout ok=new fenTout();
				fermer();
				
			}
			
		});
		btAFil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {/*
				String sql ="INSERT INTO filière (nom, type) VALUES (?,?)";
				String feildFill=fieldNomFil.getText();
				String comboFill=comboFil.getSelectedItem().toString();
				
				if (feildFill.equals("")|| comboFil.getSelectedItem().toString().equals("Selectionez")) {
					JOptionPane.showMessageDialog(null, "remplissez le champs et choisissez un type");
				}
				else {
					try {
						pre=co.prepareStatement(sql);
						pre.setString(1, feildFill);
						pre.setString(2, comboFill);
						pre.execute();
						feildFill="";
						JOptionPane.showMessageDialog(null, "Filiere ajoutée  =) ");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				updateTable();*/
			}
			
		});
		btSFil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Selectionnez une ligne dans la table !");
				}else {
					
				String sql="DELETE FROM filière WHERE id=?";
				int k=table.getSelectedRow();
				// get objet retourne un Object, il faut caster avant d'utiliser la valeur																							**§§//
				int id= (int) table.getModel().getValueAt(k, 0);
				System.out.println(id);
			String idd=Integer.toString(id);
				try {
					pre=co.prepareStatement(sql);
					pre.setString(1, idd);
					pre.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				updateTable();
				JOptionPane.showMessageDialog(null, "Utilisateur supprimé  =) "); 
				}
				
				
				
				
			}
			
		});
		btMFil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String sql ="UPDATE filière SET nom=?, type=? WHERE ID=?";
				if(table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Selectionnez une ligne !");
				}else {
					int k=table.getSelectedRow();
					int id = (int)table.getModel().getValueAt(k, 0);
					String idd =Integer.toString(id);
					try {
						pre=co.prepareStatement(sql);
						pre.setString(1, fieldNomFil.getText());
						pre.setString(2, comboFil.getSelectedItem().toString());
						pre.setString(3, idd);
						pre.execute();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					updateTable();
					JOptionPane.showMessageDialog(null, "Utilisateur Modifié  =) ");
					
				}
				
			}
			
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int k=table.getSelectedRow();
				fieldNomFil.setText( (table.getModel().getValueAt(k, 1)).toString());
				comboFil.setSelectedItem(table.getModel().getValueAt(k, 2));
				
			}
		});
		
		updateTable();
	}
	void updateTable() {/*
		String sql ="SELECT * FROM filière";
		try {
			pre=co.prepareStatement(sql);
			res=pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setModel(DbUtils.resultSetToTableModel(res));
		*/
	};
	void fermer(){
		dispose();
	}
	
	public static void main(String[] args) {
		FenFil ds=new FenFil();

	}

}
