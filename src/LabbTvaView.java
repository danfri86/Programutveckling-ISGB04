import java.awt.*;
import javax.swing.*;

public class LabbTvaView {
	private JFrame f;
	private JTextArea t; 
	private JScrollPane sb;
	private LabbTvaControl ly;

	// Menyobjekt
	private JMenuBar mainMenu; 
	private JMenu meny; 
	private JMenuItem ch1,ch2, ch3, ch4, ch5;

	public LabbTvaView(){
		f=new JFrame("Lab 2");
		ly=new LabbTvaControl(this);
		f.addWindowListener(ly);
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
		ch1.addActionListener(ly);
		ch2.addActionListener(ly);
		ch3.addActionListener(ly);
		ch4.addActionListener(ly);
		ch5.addActionListener(ly);

		f.setLocation(200,100);
		f.setSize(200,300);
		f.setVisible(true);
	}

	public void skrivNyRad(String s){
		t.append(s+"\n");
	}
	
	public void rensaText(){
		t.setText("");
	}

	public static void main(String []args){
		new LabbTvaView();
	}
}
