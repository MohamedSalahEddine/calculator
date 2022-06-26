package Etudiant;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import net.proteanit.sql.DbUtils;

public class FenGesEtu extends JFrame{
	
	void fermer() {
		dispose();
	}
	
	Connection co;
	PreparedStatement pre;
	ResultSet res;
	String idSel;
	
	String s;
	
	JButton par =new JButton("parcour");
	JPanel tof= new JPanel();
	JComboBox combo =new JComboBox();
	JLabel labTof=new JLabel();
	JLabel labFil=new JLabel("Type filiere");
	JLabel prenom =new JLabel("Prenom");
	JLabel nom =new JLabel("Nom");
	JLabel cin =new JLabel("CIN");
	JLabel numTel =new JLabel("Num Tel");
	JLabel adresse =new JLabel("Adresse");
	JLabel dateNai =new JLabel("Date De Naissance");
	JTextField fieldPre =new JTextField();
	JTextField fieldNom =new JTextField();
	JTextField fieldCin =new JTextField();
	JTextField fieldNumTel =new JTextField();
	JTextField fieldAdr =new JTextField();
	JTextField fieldDateNai =new JTextField();
	
	JButton btAdd=new JButton(new ImageIcon("btAdd.png"));
	JButton btSup=new JButton(new ImageIcon("btSup.png"));
	JButton btMod=new JButton(new ImageIcon("btMod.png"));
	JButton btPdf=new JButton(new ImageIcon("btPdf.png"));
	//JButton btBac=new JButton(new ImageIcon("backk.png"));
	
	
	JPanel container =new JPanel();
	PanHaut haut =new PanHaut();
	JPanel droite =new JPanel();
	
	JPanel gauche =new JPanel();
	JPanel gaucheH =new JPanel();
	JPanel gaucheB =new JPanel();
	
	JTable table =new JTable();
	JScrollPane scroll =new JScrollPane(table);
	
	
	
	public FenGesEtu() {
		this.setTitle("Fenetre Gestion Etudiants");
		this.setSize(900, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		initCompo();
		updateTable();
		this.setVisible(true);
	}

	void initCompo() {
		container.setLayout(new BorderLayout());
		haut.setPreferredSize(new Dimension(900,100));
		droite.setPreferredSize(new Dimension(450,500));
		gauche.setPreferredSize(new Dimension(450,500));
		gaucheH.setPreferredSize(new Dimension(450,350));
		gaucheB.setPreferredSize(new Dimension(450,150));
		
		par.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileC=new JFileChooser();
				fileC.setCurrentDirectory(new File("C:\\Users\\HP\\Desktop"));
				FileNameExtensionFilter fileT = new FileNameExtensionFilter("IMAGE","jpg","png","gif");
				fileC.addChoosableFileFilter(fileT);
				int result =fileC.showSaveDialog(null);
				
				if(result==JFileChooser.APPROVE_OPTION) {
				File file =	fileC.getSelectedFile();
				String path=file.getAbsolutePath();
				ImageIcon imgI=new ImageIcon(path);
				java.awt.Image img=imgI.getImage();
				java.awt.Image imgNew =img.getScaledInstance(tof.getWidth(), tof.getHeight(), java.awt.Image.SCALE_SMOOTH);
				ImageIcon imgI2=new  ImageIcon(imgNew);
				labTof.setIcon(imgI2);
				s=path;
				
				}
				else if(result==JFileChooser.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "vous n'avez rien choisi");
				}
				
			}
			
		});
		
	//	btBac.setPreferredSize(new Dimension (50,50));
		tof.setPreferredSize(new Dimension(80,80));
		tof.add(labTof);
		tof.setBorder(BorderFactory.createTitledBorder(""));
		par.setPreferredSize(new Dimension(10,10));
		gaucheB.add(tof);
		
		gaucheB.add(par);
		GridLayout gl=new GridLayout(7,2);
		gl.setHgap(20);
		gl.setVgap(20);
		gaucheH.setLayout(gl);
		
		gaucheH.add(prenom);
		gaucheH.add(fieldPre);
		gaucheH.add(nom);
		gaucheH.add(fieldNom);
		gaucheH.add(cin);
		gaucheH.add(fieldCin);
		gaucheH.add(numTel);
		gaucheH.add(fieldNumTel);
		gaucheH.add(adresse);
		gaucheH.add(fieldAdr);
		gaucheH.add(dateNai);
		gaucheH.add(fieldDateNai);
		gaucheH.add(labFil);
		gaucheH.add(combo);
		labFil.setHorizontalAlignment(JLabel.RIGHT);
		
		
		gaucheB.add(btAdd);
		gaucheB.add(btSup);
		gaucheB.add(btMod);
		gaucheB.add(btPdf);
	//	gaucheB.add(btBac);
		
		
		
		prenom.setHorizontalAlignment(JLabel.RIGHT);
		nom.setHorizontalAlignment(JLabel.RIGHT);
		cin.setHorizontalAlignment(JLabel.RIGHT);
		numTel.setHorizontalAlignment(JLabel.RIGHT);
		adresse.setHorizontalAlignment(JLabel.RIGHT);
		dateNai.setHorizontalAlignment(JLabel.RIGHT);
		
		
		
		gauche.add(gaucheH);
		gauche.add(gaucheB);
		
		scroll.setPreferredSize(new Dimension(430,450));
		droite.add(scroll);
		
		co=Connexion.ConnexionDB();
		
		container.add(haut,BorderLayout.NORTH);
		container.add(droite,BorderLayout.EAST);
		container.add(gauche,BorderLayout.WEST);
		this.setContentPane(container);
		
		btPdf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Document doc =new Document();
				try {
					PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\HP\\Desktop\\etudiants.pdf"));
					doc.open();
					
					
					
					
					
					Image img =Image.getInstance("C:\\Users\\HP\\Desktop\\jcode.png");
					img.scaleAbsoluteWidth(600);
					img.scaleAbsoluteHeight(92);
					img.setAlignment(Image.ALIGN_CENTER);
					doc.add(img);
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph("Liste des etudiants"));
					doc.add(new Paragraph(" "));
					
					
					PdfPTable table =new PdfPTable(6);
					table.setWidthPercentage(100);
					PdfPCell cell;
					
					////////////////////////////////////////////////////////////////
					cell=new PdfPCell(new Phrase("prenom",FontFactory.getFont("Comic Sans MS", 12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(BaseColor.GRAY);
					table.addCell(cell);
					
					cell=new PdfPCell(new Phrase("nom",FontFactory.getFont("Comic Sans MS", 12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(BaseColor.GRAY);
					table.addCell(cell);
					
					cell=new PdfPCell(new Phrase("cin",FontFactory.getFont("Comic Sans MS", 12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(BaseColor.GRAY);
					table.addCell(cell);
					
					cell=new PdfPCell(new Phrase("tel",FontFactory.getFont("Comic Sans MS", 12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(BaseColor.GRAY);
					table.addCell(cell);
					
					cell=new PdfPCell(new Phrase("date naissance",FontFactory.getFont("Comic Sans MS", 12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(BaseColor.GRAY);
					table.addCell(cell);
					
					cell=new PdfPCell(new Phrase("adresse",FontFactory.getFont("Comic Sans MS", 12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(BaseColor.GRAY);
					table.addCell(cell);
					
					////////////////////////////////////////////////////////////////////////////////
					
					String sql="Select * FROM etudiant";
					try {
						pre=co.prepareStatement(sql);
						res=pre.executeQuery();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					///////////////////////////////////////////////////////////////////////////////
					
					try {
						while(res.next()) {
							cell=new PdfPCell(new Phrase(res.getString("prenom"),FontFactory.getFont("Comic Sans MS", 12)));
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							cell.setBackgroundColor(BaseColor.WHITE);
							table.addCell(cell);
							
							cell=new PdfPCell(new Phrase(res.getString("nom"),FontFactory.getFont("Comic Sans MS", 12)));
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							cell.setBackgroundColor(BaseColor.WHITE);
							table.addCell(cell);
							
							cell=new PdfPCell(new Phrase(res.getString("cin"),FontFactory.getFont("Comic Sans MS", 12)));
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							cell.setBackgroundColor(BaseColor.WHITE);
							table.addCell(cell);
							
							cell=new PdfPCell(new Phrase(res.getString("tel"),FontFactory.getFont("Comic Sans MS", 12)));
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							cell.setBackgroundColor(BaseColor.WHITE);
							table.addCell(cell);
							
							cell=new PdfPCell(new Phrase(res.getString("datenaissance"),FontFactory.getFont("Comic Sans MS", 12)));
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							cell.setBackgroundColor(BaseColor.WHITE);
							table.addCell(cell);
							
							cell=new PdfPCell(new Phrase(res.getString("adresse"),FontFactory.getFont("Comic Sans MS", 12)));
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							cell.setBackgroundColor(BaseColor.WHITE);
							table.addCell(cell);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					doc.add(table);
					
					
					//Desktop.getDesktop().open(new File("C:\\Users\\HP\\Desktop\\jcode.pdf"));
						
						doc.close();
				} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
					
					
				 catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		btAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				String sql="INSERT INTO etudiant (prenom, nom, cin, tel, datenaissance, adresse, filiere,image) VALUES (?,?,?,?,?,?,?,?)";
				try {
					InputStream imgg =new FileInputStream(new File(s));
					pre=co.prepareStatement(sql);
					pre.setString(1, fieldPre.getText());
					pre.setString(2, fieldNom.getText());
					pre.setString(3, fieldCin.getText());
					
					pre.setString(4, fieldNumTel.getText());
					pre.setString(5, fieldDateNai.getText());
					pre.setString(6, fieldAdr.getText());
					pre.setString(7, combo.getSelectedItem().toString());
					pre.setBlob(8, imgg);
					pre.execute();
					updateTable();
					fieldPre.setText("");
					fieldNom.setText("");
					fieldCin.setText("");
					fieldNumTel.setText("");
					fieldDateNai.setText("");
					fieldAdr.setText("");
					
					JOptionPane.showMessageDialog(null, "Etudiant ajouté  =)"); 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		combo.addItem("Selectionnez");
		
		btMod.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(fieldPre.equals("")|| fieldNom.equals("")|| fieldCin.equals("")||fieldNumTel.equals("")||fieldAdr.equals("")||fieldDateNai.equals("")||combo.getSelectedItem().equals("Selectionnez")) {
					JOptionPane.showMessageDialog(null, "Remplissez les champs et choisissez une option");
				}
				else {
						
String sql="UPDATE etudiant SET prenom =? , nom =?, cin =?, tel=?, datenaissance =?, adresse=?, filiere=? WHERE id_etudiant = "+idSel;
				try {
					pre=co.prepareStatement(sql);
					pre.setString(1, fieldPre.getText());
					pre.setString(2, fieldNom.getText());
					pre.setString(3, fieldCin.getText());
					pre.setString(4, fieldNumTel.getText());
					pre.setString(5, fieldDateNai.getText());
					pre.setString(6, fieldAdr.getText());
				//	pre.setString(7, idSel); you can use ? instead of idSel in the sql query above
					pre.setString(7, combo.getSelectedItem().toString());
					pre.executeUpdate();
					fieldPre.setText("");
					fieldNom.setText("");
					fieldCin.setText("");
					fieldNumTel.setText("");
					fieldDateNai.setText("");
					fieldAdr.setText("");
					updateTable();
					JOptionPane.showMessageDialog(null, "Utilisateur modifié  =) ");
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				}
			}
			
		});
		btSup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String sql="DELETE FROM etudiant where id_etudiant = ?";
				try {
					pre=co.prepareStatement(sql);
					pre.setString(1, idSel );
					pre.execute();
					updateTable();
					JOptionPane.showMessageDialog(null, "Utilisateur supprimé  =) ");
					fieldNom.setText("");
					fieldPre.setText("");
					fieldCin.setText("");
					fieldNumTel.setText("");
					fieldDateNai.setText("");
					fieldAdr.setText("");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		});
	//	btBac.addActionListener(new ActionListener() {
//
	//		@Override
		//	public void actionPerformed(ActionEvent arg0) {
			//	fermer();
				//fenTout fenn=new fenTout();
				//
			//}
			
		//});
	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String sql="SELECT * FROM etudiant";
				
				try {
					pre=co.prepareStatement(sql);
					res=pre.executeQuery();
					if(res.next()) {
						fieldPre.setText(res.getString("prenom"));
						fieldNom.setText(res.getString("nom"));
						fieldCin.setText(res.getString("cin"));
						fieldNumTel.setText(res.getString("tel"));
						fieldDateNai.setText(res.getString("datenaissance"));
						fieldAdr.setText(res.getString("adresse"));
						combo.setSelectedItem(res.getShort("filiere"));
						
						byte[] img =res.getBytes("image");
						ImageIcon image=new ImageIcon(img);
						java.awt.Image im=image.getImage();
						java.awt.Image myImg=im.getScaledInstance(labTof.getWidth(), labTof.getHeight(), java.awt.Image.SCALE_SMOOTH);
						ImageIcon imggg=new ImageIcon(myImg);
						labTof.setIcon(imggg);
						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		
		ajouAuCombo();
		
	}
		
	void ajouAuCombo() {
		String sql="SELECT * FROM filière";
		try {
			pre=co.prepareStatement(sql);
			res=pre.executeQuery();
			while(res.next()) {
				String tem=res.getString("nom");
				tem=tem+" , ";
				tem=tem+ res.getString("type");
				combo.addItem(tem);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	
	
	void updateTable() {
		String sql ="Select * FROM etudiant";
		
		try {
			pre=co.prepareStatement(sql);
			res=pre.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		table.setModel(DbUtils.resultSetToTableModel(res));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FenGesEtu fd=new FenGesEtu();
	}

}
