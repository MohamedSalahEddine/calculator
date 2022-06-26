package ConteneurSliderBareProgression;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class FenetreJScrollPAne extends JFrame{
	
	//JTable table =new JTable();
	JTextArea text = new JTextArea();
	JScrollPane scroll=new JScrollPane(text);
	JButton bt=new JButton("bouton");
	
	public FenetreJScrollPAne() {
		this.setTitle("jscoll");
		this.setSize(200, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		bt.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
			System.out.println("Text Ecrit dans le JTextArea");
			System.out.println("----------------------------");
			System.out.println(text.getText());
				
			}
			
		});
		this.getContentPane().add(scroll,BorderLayout.CENTER);
		this.getContentPane().add(bt,BorderLayout.SOUTH);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		FenetreJScrollPAne jsp =new FenetreJScrollPAne();

	}

}
