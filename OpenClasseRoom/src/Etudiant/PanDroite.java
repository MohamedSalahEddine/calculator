package Etudiant;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PanDroite extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2d=(Graphics2D)g;
		GradientPaint gp=new GradientPaint(0,0,new Color(255, 240, 230),350,0,new Color(255, 225, 205));
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

}
