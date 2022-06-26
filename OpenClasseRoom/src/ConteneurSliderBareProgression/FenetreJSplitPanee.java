package ConteneurSliderBareProgression;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class FenetreJSplitPanee extends JFrame{
	JSplitPane split,split1,split2;
	

	public FenetreJSplitPanee(){
		this.setTitle("JSplit");
		this.setSize(200, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel pan1=new JPanel();
		pan1.setBackground(Color.blue);
		JPanel pan2=new JPanel();
		pan2.setBackground(Color.yellow);
		JPanel pan3=new JPanel();
		pan3.setBackground(Color.orange);
		JPanel pan4=new JPanel();
		pan4.setBackground(Color.red);
		
		split =new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pan1,pan2);
		split.setDividerLocation(80);
		split.setOneTouchExpandable(true);
		split.setDividerSize(15);
		
		split1 =new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pan3,pan4);
		split1.setDividerLocation(120);
		
		split2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,split,split1);
		split2.setDividerLocation(100);
		this.setContentPane(split2);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		FenetreJSplitPanee fen =new FenetreJSplitPanee();

	}

}
