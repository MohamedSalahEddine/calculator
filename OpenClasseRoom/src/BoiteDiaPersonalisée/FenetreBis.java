package BoiteDiaPersonalisée;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FenetreBis extends JFrame{
	
	JButton bt=new JButton("appel de la ZDialogue ");
	
	
	
	
	
	public FenetreBis() {
		this.setTitle("Fentre bis");
		this.setSize(300, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.getContentPane().add(bt);
		bt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ZDialogBis z=new ZDialogBis(null,"Couou les zero",true);
				ZDialogInfoBis zInfo=z.showZDialogBis();
				JOptionPane op=new JOptionPane();
				op.showMessageDialog(null, zInfo.toString(), "titre", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		
		this.setVisible(true);
	}
	public static void main(String[]args) {
		FenetreBis fenn=new FenetreBis();
	}
}
