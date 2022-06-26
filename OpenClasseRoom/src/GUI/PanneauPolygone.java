package GUI;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PanneauPolygone extends JPanel {
	
	public void paintComponent(Graphics g) {
		int x[]= {20,30,70,80,80,70,30,20};
		int y[]= {20,10,10,20,70,80,80,70};
		
		g.drawPolygon(x, y, 8);
	}

}
