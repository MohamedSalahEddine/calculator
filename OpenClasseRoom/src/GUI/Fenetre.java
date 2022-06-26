package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fenetre extends JFrame {

	Panneau pan=new Panneau();
	JPanel container =new JPanel();
	//BoutonImage bt=new BoutonImage("mon bouton");
	JButton bt1 =new JButton("go");
	JButton bt2 =new JButton("stop");
	JLabel label =new JLabel("Le JLabel");
	int compteurBT1=0;
	int compteurBT2=0;
	JPanel south =new JPanel();
	boolean animated=true;
	Thread t;
	
	public Fenetre() {
		this.setTitle("Ma fentre");
		this.setSize(new Dimension(400,400));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		container.setLayout(new BorderLayout());
		container.setBackground(Color.white);
		container.add(pan,BorderLayout.CENTER);
		south.add(bt1);
		south.add(bt2);
		bt1.setEnabled(false);
		container.add(south,BorderLayout.SOUTH);
		bt1.addActionListener(new Bouton1Listener());
		bt2.addActionListener(new Bouton2Listener());
		//container.add(bt,BorderLayout.SOUTH);
		Font font=new Font("Tahoma",Font.BOLD,20);
		label.setFont(font);
		label.setForeground(Color.BLUE);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		container.add(label,BorderLayout.NORTH);
		//choose the panel to draw (panneauImage/PanneauPolygone/panneau)
		this.setContentPane(container);
		this.setVisible(true);
		go();
		
	}
	
	void go() {
		boolean backX=false;
		boolean backY=false;
		
		while(animated)    {
		        	//boucle infini
			int x=pan.getPosX();
			int y=pan.getPosY();
			
			if(x>pan.getWidth()-50) {backX=true;}
			if(y>pan.getHeight()-50) {backY=true;}
			if(x<0) {backX=false;}
			if(y<0) {backY=false;}
			
			if(backX) {
				pan.setPosX(--x);
			}else {pan.setPosX(++x);}
			if(backY) {
				pan.setPosY(--y);
				
			}else {pan.setPosY(++y);}
			
			pan.repaint();
			try {
				Thread.sleep(3);
				
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
				
			
			                      }
	}
		
public static void main(String[]args) {
	Fenetre fen =new Fenetre();	
}


public class Bouton1Listener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		animated=true;
		bt1.setEnabled(false);
		bt2.setEnabled(true);
		t=new Thread(new Play());
		t.start();
		
	}
	
	
}
public class Bouton2Listener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		animated=false;
		bt1.setEnabled(true);
		bt2.setEnabled(false);
		
		
	}
	
}
public class Play implements Runnable{

	@Override
	public void run() {
		go();
		
	}
	
} 

}
