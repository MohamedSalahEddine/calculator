package ConteneurSliderBareProgression;

import java.awt.BorderLayout; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class DesktopEtSesInternalFrames extends JFrame {
	public static int nbr=0;
	JDesktopPane desktop =new JDesktopPane();
	public static int xy=10;
	JButton bt=new JButton("add mini Fentre");
	
	
	public DesktopEtSesInternalFrames() {
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		
		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				desktop.add(new PetitesFenetres(nbr),nbr);
				xy+=20;
				nbr+=1;
				
			}
			
		});
		
		this.getContentPane().add(desktop,BorderLayout.CENTER);
		this.getContentPane().add(bt,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	
	class PetitesFenetres extends JInternalFrame{
		public PetitesFenetres(int nbr) {
			this.setTitle("Fenetre N° "+nbr);
			this.setLocation(xy,xy);
			
			this.setResizable(true);
			this.setClosable(true);
			this.setSize(150, 80);
			this.setVisible(true);
		}
	}
public static void main (String[]args) {
	DesktopEtSesInternalFrames fen =new DesktopEtSesInternalFrames();
}
}
