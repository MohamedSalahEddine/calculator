package ConteneurSliderBareProgression;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PAnneau extends JPanel {
	
	String st="";
	Color color=Color.red;
	int i=1;

	PAnneau(Color color){
		
		this.color=color;
		this.st="Contenu du Panneau N² : "+(i++);
		
	}
	public void paintComponent(Graphics g) {
		g.setColor(this.color);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(color.white);
		g.setFont(new Font("Arial",Font.BOLD,15));
		g.drawString(st, 10, 20);
	}
}
