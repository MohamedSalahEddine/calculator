package ConteneurSliderBareProgression;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class FentreTapped extends JFrame{
	int j=4;
	
	

	public FentreTapped() {
		this.setTitle("tapped");
		this.setSize(400, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	//	PAnneau[] tabPan= {new PAnneau(Color.red),new PAnneau(Color.green),new PAnneau(Color.blue),new PAnneau(Color.blue)};
		JTabbedPane tabbed =new JTabbedPane(JTabbedPane.BOTTOM);
		
		int i=0;
		
	//	for(PAnneau p:tabPan) {
			
	//	tabbed.add("Onglet n² "+(++i),p);
	//	tabbed.setIconAt((i-1),new ImageIcon("orange.png"));
		
	//	}
		JButton add=new JButton("ajouter panneau");
		
		add.addActionListener(new ActionListener() {
			int j=0;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				tabbed.add("Onglet n² "+(j++),new PAnneau(Color.gray));
				
			}
			
		});
		JButton rem=new JButton("Supprimer");
		rem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index =tabbed.getSelectedIndex();
				tabbed.remove(index);
				
				
			}
			
		});
		JPanel south =new JPanel();
		south.add(add);
		south.add(rem);
		this.getContentPane().add(tabbed,BorderLayout.CENTER);
		this.getContentPane().add(south,BorderLayout.SOUTH);
		this.setVisible(true);
		}
	
	public static void main(String[] args) {
		FentreTapped tt=new FentreTapped();

	}

}
