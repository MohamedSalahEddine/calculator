package DesChampsDeFormulaires;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class FenetreText extends JFrame{
	
	JPanel container =new JPanel();
	JPanel top =new JPanel();
	JLabel lab=new JLabel("Telephone FR : ");
	JLabel lab1=new JLabel("Telephone USA : ");
	JFormattedTextField ft;
	JButton bt=new JButton("OK");
	MaskFormatter maskFR=new MaskFormatter("##-##-##-##-##");
	JFormattedTextField ftFR =new JFormattedTextField(maskFR);
	MaskFormatter maskUSA=new MaskFormatter("###-###-####");
	JFormattedTextField ftUSA =new JFormattedTextField(maskUSA);
	
	public FenetreText() throws ParseException {
		this.setTitle("Fenetre Java TextField");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		top.add(lab);
		Font police =new Font("Arial",Font.BOLD,20);
		
			
		ftFR.setForeground(Color.blue);
		ftFR.setFont(police);
		ftFR.setHorizontalAlignment(JTextField.CENTER);
		ftFR.setPreferredSize(new Dimension(150,30));
		top.add(ftFR);
		top.add(lab1);
		ftUSA.setForeground(Color.blue);
		ftUSA.setFont(police);
		ftUSA.setHorizontalAlignment(JTextField.CENTER);
		ftUSA.setPreferredSize(new Dimension(150,30));
		top.add(ftUSA);
		bt.addActionListener(new BtListener());
		top.add(bt);
		
		
		this.setContentPane(top);
		this.setVisible(true);
		
	}
	
		class BtListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("téléphone Français : "+ftFR.getText());
				System.out.println("téléphone USA : "+ftUSA.getText());
				
			}
			
		}
	
	public static void main(String[] args) throws ParseException {
		FenetreText c =new FenetreText();

	}

}
