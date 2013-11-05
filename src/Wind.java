// import java.awt.*; // awt och swing ska inte blandas. swing används i denna fil
import javax.swing.*;

class Wind { 
	private JFrame f; // JFrame är javax(swing)
	public Wind(){
		// Skapa ett GUI fönster
		f=new JFrame("Hello World!");
		
		// Stäng programmet även när man stänger
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Sätt storlek på fönstet
		f.setSize(200,50);
		
		// Var placeras fönstret, räknat från övre vänstra hörnet
		f.setLocation(100,100);
		
		f.setVisible(true);
	}
	
	public static void main (String args[]) {
		new Wind();
	}
}