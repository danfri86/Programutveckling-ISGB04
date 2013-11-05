import java.awt.*; 
import java.awt.event.*; 
import java.io.File; 
import javax.swing.*;

import java.util.*;

public class LabEtt extends WindowAdapter implements ActionListener {
	
	private int slump[];
	private String Lottorad;
	private JFrame f; 
	private JButton b; 
	private JTextArea t; 
	private JScrollPane sb;
	
	// Menyobjekt
	private JMenuBar mainMenu; 
	private JMenu meny; 
	private JMenuItem ch1,ch2, ch3, ch4, ch5;

	public LabEtt(){		
		f=new JFrame("Lab 1"); 
		f.addWindowListener(this); 
		b=new JButton("Slumpa"); 
		t=new JTextArea(); 
		sb=new JScrollPane(t); 
		f.add(b,BorderLayout.SOUTH); 
		b.addActionListener(new Inner(this));
		f.add(sb);
		
		mainMenu=new JMenuBar(); 
		meny=new JMenu("Meny"); 
		ch1=new JMenuItem("Öppna"); 
		ch2=new JMenuItem("Spara"); 
		ch3=new JMenuItem("Slumpa"); 
		ch4=new JMenuItem("Rensa"); 
		ch5=new JMenuItem("Avsluta"); 
		ch2.addActionListener(this); 
		meny.add(ch1);
		meny.add(ch2); 
		meny.add(ch3); 
		meny.add(ch4);
		meny.addSeparator(); 
		meny.add(ch5);
		mainMenu.add(meny); 
		f.setJMenuBar(mainMenu); 
		
		f.setSize(400,300);
		f.setLocation(100,100);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

	class Inner implements ActionListener { 
		private LabEtt o; 
		public Inner(LabEtt oin) { 
			o=oin; 
			o.newMessage("Nu associeras lyssnaren med händelsekällan"); 
			o.newMessage("Konstruktor klar");
		}
		public void actionPerformed(ActionEvent e) { 
			slump = new int[7];
			Random number = new Random();
			Lottorad="";

			for(int i=0; i<=6; i++){			
				slump[i] = number.nextInt(34)+1;
				Lottorad=Lottorad+slump[i]+" ";
			}
			o.newMessage(Lottorad);
		} 
	} 
	public void newMessage(String s) { 
		t.append(s+"\n");
	} 
	public void windowClosing (WindowEvent e) { 
		System.out.println("Hej då"); 
		System.exit(1); 
	}
	public static void main (String args[]) {
		new LabEtt();
	}
}