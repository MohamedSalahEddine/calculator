package DesChampsDeFormulaires;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class FenetreJRadio extends JFrame {
	
	JPanel container =new JPanel();
	JPanel top =new JPanel();
	JRadioButton Jbt1=new JRadioButton("radio 1");
	JRadioButton Jbt2=new JRadioButton("radio 2");
	ButtonGroup bg =new ButtonGroup();
	

	public FenetreJRadio(){
		this.setTitle("Radio");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		top.add(Jbt1);
		top.add(Jbt2);
		Jbt1.addActionListener(new hey());
		Jbt2.addActionListener(new hey());
		bg.add(Jbt1);
		bg.add(Jbt2);
		container.setLayout(new BorderLayout());
		container.add(top,BorderLayout.NORTH);
		this.setContentPane(container);
		this.setVisible(true);
	}
	class hey implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Source : "+Jbt1.getText()+ " - état : "+Jbt1.isSelected());
			System.out.println("Source : "+Jbt2.getText()+ " - état : "+Jbt2.isSelected());
			
		}
		
	}
	
	public static void main(String[] args) {
	
		FenetreJRadio f = new FenetreJRadio();
	}

}
