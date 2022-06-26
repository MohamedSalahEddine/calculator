package positionnement;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutt extends JFrame{
	

	
		
		GridLayoutt(){
			this.setTitle("ma fenetre");
			this.setSize(300, 300);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			//le Layout
			GridLayout gl=new GridLayout(3,2);
			gl.setHgap(5);
			gl.setVgap(5);
			this.setLayout(gl);
			
			this.getContentPane().add(new JButton("nord"));
			this.getContentPane().add(new JButton("sud"));
			this.getContentPane().add(new JButton("est"));
			this.getContentPane().add(new JButton("ouest"));
			this.getContentPane().add(new JButton("centre"));
			
			this.setVisible(true);}

			public static void main(String[] args) {
				GridLayoutt fen =new GridLayoutt();
			}

}
