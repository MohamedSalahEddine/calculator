package positionnement;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardLAyout extends JFrame {
	
		JPanel contenu =new JPanel();
		CardLayout c1=new CardLayout();
		String[] tab= {"Card_1","Card_2"," Card_3"};
		int i=0;
		
		
	CardLAyout(){
		this.setTitle("ma fenetre");
		this.setSize(300, 120);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panBouton=new JPanel();
		JButton btSuivant=new JButton("contenu suivant");
		JButton btContenu=new JButton("contenu par indice");
		
		JPanel p1=new JPanel();
		p1.setBackground(Color.BLUE);
		JPanel p2=new JPanel();
		p2.setBackground(Color.RED);
		JPanel p3=new JPanel();
		p3.setBackground(Color.GREEN);
		
		btSuivant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				c1.next(contenu);
				}});
		
		
		btContenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(++i>2) {
					i=0;
				
			}
				c1.show(contenu, tab[i]);
				System.out.println("btContenu actionné");
			}
			
		});
		
		
		contenu.setLayout(c1);
		contenu.add(p1,tab[0]);
		contenu.add(p2,tab[1]);
		contenu.add(p3,tab[2]);
		
		
		
		panBouton.add(btSuivant);
		panBouton.add(btContenu);
		
		JPanel tt =new JPanel();
		tt.setLayout(new BorderLayout());
		tt.add(contenu,BorderLayout.CENTER);
		tt.add(panBouton,BorderLayout.NORTH);
		this.getContentPane().add(tt);
		
		
	
	
		this.setVisible(true);
	}
	public static void main(String[]args) {
		CardLAyout fen=new CardLAyout();
	}
}
