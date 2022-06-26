package ConteneurSliderBareProgression;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

///////////////////////////////      ** **  Servent pour faire les flashScreen (comme au lancement de Eclipse).

public class Window extends JWindow{

public static void main(String[] args){
  Window wind = new Window();
  wind.setVisible(true);
}
 
public Window(){      
  setSize(220, 165);
  setLocationRelativeTo(null);      
  JPanel pan = new JPanel();
  JLabel img = new JLabel(new ImageIcon("planète.jpeg"));
  img.setVerticalAlignment(JLabel.CENTER);
  img.setHorizontalAlignment(JLabel.CENTER);      
  pan.setBorder(BorderFactory.createLineBorder(Color.blue));
  pan.add(img);
  getContentPane().add(pan);
}
}