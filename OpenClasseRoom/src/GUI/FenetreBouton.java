package GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


//une JFrame peut contenir des JFrame
public class FenetreBouton extends JFrame{

	JButton btNorth=new JButton("nord");
	JButton btSouth=new JButton("sud");
	JButton btEast=new JButton("est");
	JButton btWest=new JButton("ouest");
	JButton btCenter=new JButton("centre");
	
	public FenetreBouton() {
		this.setTitle("Boutonns");
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.getContentPane().add(btNorth,BorderLayout.NORTH);
		this.getContentPane().add(btSouth,BorderLayout.SOUTH);
		this.getContentPane().add(btEast,BorderLayout.EAST);
		this.getContentPane().add(btWest,BorderLayout.WEST);
		this.getContentPane().add(btCenter,BorderLayout.CENTER);
		this.setVisible(true);
	}
}
