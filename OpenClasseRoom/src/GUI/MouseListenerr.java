package GUI;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseListenerr extends JFrame {
	
	Panneau pan =new Panneau();
	BoutonImage bt=new BoutonImage("mon bouton");
	JPanel container =new JPanel();
	
	public MouseListenerr() {
		this.setTitle("Fenetre Mouse");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		container.setLayout(new BorderLayout());
		container.add(pan,BorderLayout.CENTER);
		
		container.add(bt,BorderLayout.SOUTH);
		this.setContentPane(container);
		this.setVisible(true);
	}



	
	public static void main(String[]args) {
		MouseListenerr l=new MouseListenerr();
	}

}
