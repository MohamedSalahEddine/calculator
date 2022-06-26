package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanneauImage extends JPanel{
	Image img;
	
	
	public void paintComponent(Graphics g) {
		
try {
	 img =ImageIO.read(new File("soy.png"));

	g.drawImage(img,0,0,this);
	

}

catch(IOException e) {e.printStackTrace();}
}
	

}
