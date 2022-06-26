package Etudiant;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanHaut extends JPanel {
	
	
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.black);
		g.setFont(new Font("Arial",Font.BOLD,30));
		g.drawString("GESTION DES ETUDIANTS",this.getWidth()/4-30 , 30);
		g.setColor(Color.black);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("ECOLE  ANONYME", this.getWidth()/3+20, 60);
	}
	
}
