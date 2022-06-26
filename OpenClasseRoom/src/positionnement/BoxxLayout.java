package positionnement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoxxLayout extends JFrame{
	
	BoxxLayout(){
		
		this.setTitle("ma fenetre");
		this.setSize(300, 120);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel p1 =new JPanel();
		p1.setLayout(new BoxLayout(p1,BoxLayout.LINE_AXIS));
		p1.add(new JButton("Bouton 1"));
		
		JPanel p2=new JPanel();
		p2.setLayout(new BoxLayout(p2,BoxLayout.LINE_AXIS));
		p2.add(new JButton("Bouton 2"));
		p2.add(new JButton("Bouton 3"));
		
		JPanel p3=new JPanel();
		p3.setLayout(new BoxLayout(p3,BoxLayout.LINE_AXIS));
		p3.add(new JButton("Bouton 4"));
		p3.add(new JButton("Bouton 5"));
		p3.add(new JButton("Bouton 6"));
		
		JPanel p4=new JPanel();
		p4.setLayout(new BoxLayout(p4,BoxLayout.PAGE_AXIS));
		p4.add(p1);
		p4.add(p2);
		p4.add(p3);
		
		this.getContentPane().add(p4);
		
		this.setVisible(true);
	}
	public static void main(String[]args) {
		BoxxLayout fen=new BoxxLayout();
	}

}
