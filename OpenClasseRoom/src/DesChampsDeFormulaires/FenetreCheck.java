package DesChampsDeFormulaires;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreCheck extends JFrame{
	
	JPanel container =new JPanel();
	JPanel top =new JPanel();
	JCheckBox check1=new JCheckBox("case 1");
	JCheckBox check2=new JCheckBox("case 2");
	
	
	
	FenetreCheck(){
		this.setTitle("checkbox");
		this.setSize(400,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		container.setLayout(new BorderLayout());
		container.setBackground(Color.white);
		top.add(check1);
		top.add(check2);
		check1.addActionListener(new Hey());
		check2.addActionListener(new Hey());
		container.add(top,BorderLayout.NORTH);
		this.setContentPane(container);
		this.setVisible(true);
		
	}
	class Hey implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("source : " + ((JCheckBox)e.getSource()).getText() + " - état : " + ((JCheckBox)e.getSource()).isSelected());
			
		}
		
	}

	public static void main(String[] args) {
		FenetreCheck  f = new FenetreCheck();
		
	}

}
