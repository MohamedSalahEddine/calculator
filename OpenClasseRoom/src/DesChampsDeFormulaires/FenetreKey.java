package DesChampsDeFormulaires;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FenetreKey extends JFrame{
	
	JPanel container =new JPanel();
	JLabel label=new JLabel("Telephone FR");
	JTextField jtf=new JTextField();
	JButton bt=new JButton("OK");
	
	
	public FenetreKey() {
		this.setTitle("Animation");
		this.setSize(300, 150);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		container.add(label);
		jtf.setPreferredSize(new Dimension(150,30));
		jtf.setForeground(Color.blue);
		jtf.setFont(new Font("Arial",Font.BOLD,20));
		container.add(jtf);
		jtf.addKeyListener(new ClavierListener());
		container.add(bt);
		this.setContentPane(container);
		this.setVisible(true);
	} 
	
	class ClavierListener implements KeyListener{
		  public void keyReleased(KeyEvent event) {
		    if(!isNumeric(event.getKeyChar()))
		      jtf.setText(jtf.getText().replace(String.valueOf(event.getKeyChar()), ""));      	
		    }

		    //Inutile de redéfinir ces méthodes, ous n'en avons plus l'utilité !
		    public void keyPressed(KeyEvent event) {}
		    public void keyTyped(KeyEvent event) {}

		    //Retourne true si le paramètre est numérique, false dans le cas contraire
		    private boolean isNumeric(char carac){
		    try {
		      Integer.parseInt(String.valueOf(carac));
		    }
		    catch (NumberFormatException e) {
		      return false;            
		    }
		    return true;
		  }
		}
	
	void pause() {
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FenetreKey f =new FenetreKey();
	}

}
