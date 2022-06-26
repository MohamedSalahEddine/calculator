package DesChampsDeFormulaires;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panneau extends JPanel {
	int posX=50;
	int posY=50;
	String forme="ROND";
	
	public Color couFor =Color.red;
	public Color couFon =Color.white;

	public void paintComponent(Graphics g) {
		g.setColor(couFon);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(couFor);
		draw(g);
		
	}
	public void setCouFor(Color couFor) {
		this.couFor = couFor;
	}
	public void setCouFon(Color couFon) {
		this.couFon = couFon;
	}
	void draw(Graphics g){
		if(forme.equals("ROND")) {
			g.fillOval(posX, posY, 50, 50);
		}
		else if(forme.equals("CARRE")|| forme.equals("Carré")) {
			g.fillRect(posX, posY, 50, 50);
		}
		else if(forme.equals("TRIANGLE")) {
			 //Calcul des sommets            
		      //Le sommet 1 se situe à la moitié du côté supérieur du carré
		      int s1X = posX + 25;
		      int s1Y = posY;
		      //Le sommet 2 se situe en bas à droite
		      int s2X = posX + 50;
		      int s2Y = posY + 50;
		      //Le sommet 3 se situe en bas à gauche
		      int s3X = posX;
		      int s3Y = posY + 50;      
		      //Nous créons deux tableaux de coordonnées
		      int[] ptsX = {s1X, s2X, s3X};
		      int[] ptsY = {s1Y, s2Y, s3Y};      
		      //Nous utilisons la méthode fillPolygon()
		      g.fillPolygon(ptsX, ptsY, 3);
		}
		else if(forme.equals("ETOILE")){
			int s1X = posX + 25;
		      int s1Y = posY;
		      int s2X = posX + 50;
		      int s2Y = posY + 50;        
		      g.drawLine(s1X, s1Y, s2X, s2Y);      
		      int s3X = posX;
		      int s3Y = posY + 17;
		      g.drawLine(s2X, s2Y, s3X, s3Y);      
		      int s4X = posX + 50;
		      int s4Y = posY + 17;
		      g.drawLine(s3X, s3Y, s4X, s4Y);            
		      int s5X = posX;
		      int s5Y = posY + 50;
		      g.drawLine(s4X, s4Y, s5X, s5Y);       
		      g.drawLine(s5X, s5Y, s1X, s1Y); 
		}
	}
	public void setForme(String forme) {
		this.forme = forme.toUpperCase();
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
}
