import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.io.*; 

import java.util.*;

public class LabbTvaView {
	private JFrame f;
	private JTextArea t; 
	private JScrollPane sb;
	private LabbTvaControl c;

	// Menyobjekt
	private JMenuBar mainMenu; 
	private JMenu meny; 
	private JMenuItem ch1,ch2, ch3, ch4, ch5;

	public LabbTvaView(){
		f=new JFrame("Lab 2");
		c=new LabbTvaControl(this);
		f.addWindowListener(c);
		t=new JTextArea();
		sb=new JScrollPane(t);
		f.add(sb);

		mainMenu=new JMenuBar(); 
		meny=new JMenu("Meny"); 
		ch1=new JMenuItem("Öppna"); 
		ch2=new JMenuItem("Spara"); 
		ch3=new JMenuItem("Slumpa"); 
		ch4=new JMenuItem("Rensa"); 
		ch5=new JMenuItem("Avsluta");

		// Lägg till meny-items
		meny.add(ch1);
		meny.add(ch2); 
		meny.add(ch3); 
		meny.add(ch4);
		meny.addSeparator(); 
		meny.add(ch5);
		mainMenu.add(meny); 
		f.setJMenuBar(mainMenu);
		
		// Lyssna på knapptryckningar
		ch1.addActionListener(c);
		ch2.addActionListener(c);
		ch3.addActionListener(c);
		ch4.addActionListener(c);
		ch5.addActionListener(c);

		f.setLocation(200,100);
		f.setSize(200,300);
		f.setVisible(true);
	}

	public void skrivNyRad(String s){
		t.append(s+"\n");
	}
	
	public String oppna(){
		System.out.println("View>Oppna anropad. Öppna fönster");
		
		String fil="";

		JFileChooser chooser = new
				JFileChooser("d:"+File.separator+"Java-program");
		int returnVal = chooser.showOpenDialog(f);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			fil=(chooser.getCurrentDirectory()
					+File.separator+chooser.getSelectedFile
					().getName());
		}
		
		return fil;
	}
	
	public String skriv(){ 
		System.out.println("View>Skriv anropad. Öppna fönster");
				
		String filnamn="";

		JFileChooser chooser = new
				JFileChooser("d:"+File.separator+"Java-program");
		int returnVal = chooser.showSaveDialog(f);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			filnamn=(chooser.getCurrentDirectory()
					+File.separator+chooser.getSelectedFile
					().getName());
		}
		
		return filnamn;
	}
	
	public JTextArea getTextArea(){
		JTextArea textArea=t;
		return textArea;
	}
	
	public void rensaText(){
		t.setText("");
	}

	public static void main(String []args){
		new LabbTvaView();
	}
}
