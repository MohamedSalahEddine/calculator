package DesChampsDeFormulaires;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class Fenetre extends JFrame{
	
	String[] st = {"Rond","Carre","Triangle","Etoile"};
	JComboBox comb=new JComboBox(st);
	JPanel container =new JPanel();
	Panneau pan      =new Panneau();
	JLabel label =new JLabel("Choix de la Forme");
	JPanel bottom =new JPanel();
	JButton btGo=new JButton("Go");
	JButton btStop=new JButton("Stop");
	Thread t;
	boolean animated=true;
	boolean backX,backY=false;
	JPopupMenu jpum=new JPopupMenu();
	JToolBar jtb=new JToolBar();
	
	JButton play =new JButton(new ImageIcon("play.jpg"));
	JButton arreter =new JButton(new ImageIcon("arreter.jpg"));
	JButton rond =new JButton(new ImageIcon("rond.jpg"));
	JButton triangle =new JButton(new ImageIcon("triangle.jpg"));
	JButton carre =new JButton(new ImageIcon("carre.jpg"));
	JButton etoile =new JButton(new ImageIcon("etoile.jpg"));
	
	JMenuBar mb =new JMenuBar();
	JMenu jmAnimation =new JMenu("Animation");
	JMenu jmForme =new JMenu("Forme");
	JMenu jmType =new JMenu("Type de forme");
	JMenu jmApropos=new JMenu("A Propos");
	
	//JMenuPop
	JMenu jmCouleurForme= new JMenu("Couleur de la forme");
	JMenu jmCouleurFond= new JMenu("Couleur de Fond");
	
	
	JMenuItem jmiLancer =new JMenuItem("Lancer l'animation");
	JMenuItem jmiLancerr =new JMenuItem("Lancer l'animation");
	JMenuItem jmiArreter =new JMenuItem("Arreter l'animation");
	JMenuItem jmiArreterr =new JMenuItem("Arreter l'animation");
	JMenuItem jmiQuiter =new JMenuItem("Quiter");
	JMenuItem jmiApropos =new JMenuItem("?");
	
	JCheckBoxMenuItem jcbmiMorph=new JCheckBoxMenuItem("Morphing");
	
	JRadioButtonMenuItem jrbmiRond=new JRadioButtonMenuItem("Rond");
	JRadioButtonMenuItem jrbmiCarré=new JRadioButtonMenuItem("Carre");
	JRadioButtonMenuItem jrbmiTriangle=new JRadioButtonMenuItem("Triangle");
	JRadioButtonMenuItem jrbmiEtoile=new JRadioButtonMenuItem("Etoile");
	
	//JRBMI Couleur Fond
	JRadioButtonMenuItem jrbmiCFondRouge =new JRadioButtonMenuItem("rouge");
	JRadioButtonMenuItem jrbmiCFondVert =new JRadioButtonMenuItem("vert");
	JRadioButtonMenuItem jrbmiCFondBleu =new JRadioButtonMenuItem("bleu");
	JRadioButtonMenuItem jrbmiCFondJaune =new JRadioButtonMenuItem("jaune");
	
	//JRBMI Couleur Forme
		JRadioButtonMenuItem jrbmiCFormeRouge =new JRadioButtonMenuItem("rouge");
		JRadioButtonMenuItem jrbmiCFormeVert =new JRadioButtonMenuItem("vert");
		JRadioButtonMenuItem jrbmiCFormeBleu =new JRadioButtonMenuItem("bleu");
		JRadioButtonMenuItem jrbmiCFormeJaune =new JRadioButtonMenuItem("jaune");
	
	
	
	public Fenetre() {
		this.setTitle("combo");
		this.setSize(300,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		container.setLayout(new BorderLayout());
		jmiLancer.setEnabled(false);
		
		jtb.add(play);
		play.setEnabled(false);
		jtb.add(arreter);
		jtb.addSeparator();
		jtb.add(rond);
		jtb.add(carre);
		jtb.add(triangle);
		jtb.add(etoile);
		
		play.addActionListener(new BtGo());
		arreter.addActionListener(new BtStop());
		rond.addActionListener(new FormeListener());
		carre.addActionListener(new FormeListener());
		triangle.addActionListener(new FormeListener());
		etoile.addActionListener(new FormeListener());
		
		ButtonGroup bgFond=new ButtonGroup();
		bgFond.add(jrbmiCFondRouge);
		bgFond.add(jrbmiCFondVert);
		bgFond.add(jrbmiCFondBleu);
		bgFond.add(jrbmiCFondJaune);
		
		ButtonGroup bgForme=new ButtonGroup();
		bgForme.add(jrbmiCFormeRouge);
		bgForme.add(jrbmiCFormeVert);
		bgForme.add(jrbmiCFormeBleu);
		bgForme.add(jrbmiCFormeJaune);
		
		jmCouleurForme.add(jrbmiCFormeRouge);
		jmCouleurForme.add(jrbmiCFormeVert);
		jrbmiCFormeVert.setSelected(true);
		jmCouleurForme.add(jrbmiCFormeBleu);
		jmCouleurForme.add(jrbmiCFormeJaune);
		
		jmCouleurFond.add(jrbmiCFondRouge);
		jrbmiCFondRouge.setSelected(true);
		jmCouleurFond.add(jrbmiCFondVert);
		jmCouleurFond.add(jrbmiCFondBleu);
		jmCouleurFond.add(jrbmiCFondJaune);
		
		jrbmiCFormeRouge.addActionListener(new CFormeListener());
		jrbmiCFormeVert.addActionListener(new CFormeListener());
		jrbmiCFormeBleu.addActionListener(new CFormeListener());
		jrbmiCFormeJaune.addActionListener(new CFormeListener());
		
		jrbmiCFondRouge.addActionListener(new CFondListener());
		jrbmiCFondVert.addActionListener(new CFondListener());
		jrbmiCFondBleu.addActionListener(new CFondListener());
		jrbmiCFondJaune.addActionListener(new CFondListener());
		
		// PopUp
				jpum.add(jmiLancerr);
				jpum.add(jmiArreterr);
				jpum.add(jmCouleurForme);
				jpum.add(jmCouleurFond);
		
		jmiLancer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,KeyEvent.CTRL_DOWN_MASK));
		jmiArreter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK+KeyEvent.SHIFT_DOWN_MASK));
		jmAnimation.add(jmiLancer);
		jmiLancer.addActionListener(new BtGo());
		jmiLancerr.addActionListener(new BtGo());
		jmAnimation.add(jmiArreter);
		
		jmiArreter.addActionListener(new BtStop());
		jmiArreterr.addActionListener(new BtStop());
		jmAnimation.addSeparator();
		jmAnimation.add(jmiQuiter);
		jmiQuiter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
			
		});
		ButtonGroup bg=new ButtonGroup();
		bg.add(jrbmiRond);
		bg.add(jrbmiCarré);
		bg.add(jrbmiTriangle);
		bg.add(jrbmiEtoile);
		
		jmType.add(jrbmiRond);
		jrbmiRond.setSelected(true);
		jmType.add(jrbmiCarré);
		jmType.add(jrbmiTriangle);
		jmType.add(jrbmiEtoile);
		
		jrbmiRond.addActionListener(new FormeListener());
		jrbmiCarré.addActionListener(new FormeListener());
		jrbmiTriangle.addActionListener(new FormeListener());
		jrbmiEtoile.addActionListener(new FormeListener());
		
		jmForme.add(jmType);
		jmForme.add(jcbmiMorph);
		
		jmApropos.add(jmiApropos);
		
		jmAnimation.setMnemonic('A');
		jmForme.setMnemonic('F');
		jmApropos.setMnemonic('P');
		
		mb.add(jmAnimation);
		mb.add(jmForme);
		mb.add(jmApropos);
				
		//btGo.addActionListener(new BtGo());
		//btStop.addActionListener(new BtStop());
		comb.setSize(new Dimension(100,20));
	//	comb.addItemListener(new ItemState());
		comb.setForeground(Color.blue);
	//	comb.addActionListener(new CombAction());
		
		JPanel top =new JPanel();
		container.setBackground(Color.WHITE);
		top.add(jtb);
		
	//	top.add(comb);
		btGo.setEnabled(false);
		bottom.add(btGo);
		bottom.add(btStop);
		container.add(top,BorderLayout.NORTH);
		container.add(pan,BorderLayout.CENTER);
	//	container.add(bottom,BorderLayout.SOUTH);
		pan.addMouseListener(new LaMouseAdapter());
		
		this.setJMenuBar(mb);
		this.setContentPane(container);
		this.setVisible(true);
		go();
		
	}
	class CFormeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String l=((JRadioButtonMenuItem)arg0.getSource()).getText();
			switch(l){
			case "rouge" : pan.setCouFor(Color.red);
			break;
			case "vert" : pan.setCouFor(Color.green);
			break;
			case "bleu" : pan.setCouFor(Color.blue);
			break;
			case "jaune" : pan.setCouFor(Color.yellow);
			break;
			default :System.out.println("erreur");
			
			}}}
	class CFondListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String l=((JRadioButtonMenuItem)arg0.getSource()).getText();
			switch(l){
			case "rouge" : pan.setCouFon(Color.red);
			break;
			case "vert" : pan.setCouFon(Color.green);
			break;
			case "bleu" : pan.setCouFon(Color.blue);
			break;
			case "jaune" : pan.setCouFon(Color.yellow);
			break;
			default :System.out.println("erreur");
			
			}}}
	
	
	
	
	class LaMouseAdapter extends MouseAdapter{
		public void mouseReleased(MouseEvent event){
			if(event.isPopupTrigger()){
				jpum.show(pan, event.getX(), event.getY());
			}
		}
	}
	class BtGo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane opGo=new JOptionPane();
		int k=	opGo.showConfirmDialog(null, "Lancement de L'animation", "Voulez-vous lancer l'animation ?",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE );
			if(k==JOptionPane.OK_OPTION) {
			animated =true;
			t=new Thread(new Play());
			t.start();
			jmiLancer.setEnabled(false);
			play.setEnabled(false);
			jmiArreter.setEnabled(true);
			arreter.setEnabled(true);
			}
		}
		
	}
	class BtStop implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane opSto=new JOptionPane();
			int k= opSto.showConfirmDialog(null, "Voulez-vous arreter l'animation ? ", "Arret de l'animation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(k!=JOptionPane.CANCEL_OPTION && k!=JOptionPane.CLOSED_OPTION && k!= JOptionPane.NO_OPTION) { 
			animated=false;
			jmiLancer.setEnabled(true);
			play.setEnabled(true);
			jmiArreter.setEnabled(false);
			arreter.setEnabled(false);
			}
		}
		
	}
	class Play implements Runnable {

		@Override
		public void run() {
			go();
			
		}
		
	}
	class FormeListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String clas=arg0.getSource().getClass().getName();
			if(clas.equals("javax.swing.JRadioButtonMenuItem")) {
			pan.setForme(((JRadioButtonMenuItem)arg0.getSource()).getText());}
			
			else {
				JButton bt= ((JButton)arg0.getSource());
				if(bt==carre) {
					jrbmiCarré.doClick();
				}
				else if(bt==rond) {
					jrbmiRond.doClick();
				}
				else if(bt==triangle) {
					jrbmiTriangle.doClick();
				}
				else  {
					jrbmiEtoile.doClick();
				}
				
			}
			
			
		}}
	
	void go() {
		int x=pan.getPosX();
		int y=pan.getPosY();
		while(animated) {
			if(x>pan.getWidth()-50) {
				backX=true;
			}
			if(x<1) {
				backX=false;
			}
			if(y>pan.getHeight()-50) {
				backY=true;
			}
			if(y<1) {
				backY=false;
			}
			if(backX) {
				
				pan.setPosX(--x);
			}else if(!backX) {
				
				pan.setPosX(++x);}
			
			if(backY) {
				
				pan.setPosY(--y);
			}else if (!backY){
				
				pan.setPosY(++y);
			}
			pan.repaint();
			try {
				Thread.sleep(3);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		Fenetre fen =new Fenetre();

	}

}
