package DesChampsDeFormulaires;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FenetreTextOC extends JFrame {
private JPanel container = new JPanel();
private JFormattedTextField jtf = new JFormattedTextField(NumberFormat.getIntegerInstance());
private JFormattedTextField jtf2 = new JFormattedTextField(NumberFormat.getPercentInstance());
private JLabel label = new JLabel("Un JTextField");
private JButton b = new JButton ("OK");

public FenetreTextOC(){
  this.setTitle("Animation");
  this.setSize(300, 300);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setLocationRelativeTo(null);
// container.setBackground(Color.white);
// container.setLayout(new BorderLayout());
  JPanel top = new JPanel();        
  Font police = new Font("Arial", Font.BOLD, 14);
  jtf.setFont(police);
  jtf.setPreferredSize(new Dimension(150, 30));
  jtf.setForeground(Color.BLUE);
  jtf2.setPreferredSize(new Dimension(150, 30));
  b.addActionListener(new BoutonListener());
  top.add(label);
  top.add(jtf);
  top.add(jtf2);
  top.add(b);
  this.setContentPane(top);
  this.setVisible(true);            
}       

class BoutonListener implements ActionListener{
  public void actionPerformed(ActionEvent e) {
    System.out.println("TEXT : jtf " + jtf.getText());
    System.out.println("TEXT : jtf2 " + jtf2.getText());
  }
}
public static void main(String[] args) {
	FenetreTextOC c =new FenetreTextOC();

}
}