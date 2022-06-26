package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JPanel;
 
public class Panneau extends JPanel { 
	private int posX=-50;
	private int posY=-50;
	
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

public void paintComponent(Graphics g){
	  g.setColor(Color.WHITE);
	  g.fillRect(0, 0, this.getWidth(), this.getHeight());
	  g.setColor(Color.RED);
	  g.fillOval(posX, posY, 50, 50);
	  
  }               
}