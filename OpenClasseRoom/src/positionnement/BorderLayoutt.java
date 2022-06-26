package positionnement;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutt extends JFrame {
	
	BorderLayoutt(){
	this.setTitle("ma fenetre");
	this.setSize(300, 300);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	//le Layout
	this.setLayout(new BorderLayout());
	
	this.getContentPane().add(new JButton("nord"),BorderLayout.NORTH);
	this.getContentPane().add(new JButton("sud"),BorderLayout.SOUTH);
	this.getContentPane().add(new JButton("est"),BorderLayout.EAST);
	this.getContentPane().add(new JButton("ouest"),BorderLayout.WEST);
	this.getContentPane().add(new JButton("centre"),BorderLayout.CENTER);
	
	this.setVisible(true);
	}
	public static void main(String[]args) {
		BorderLayoutt fen=new BorderLayoutt();
	}

}
