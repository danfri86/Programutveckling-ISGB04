import java.awt.*; // Måste finnas när FlowLayout finns nedan. FlowLayout ärver från awt.
import javax.swing.*;

class Question { 
	public Question(){ 
		JFrame f=new JFrame("Question?"); // OBS Lokal 
		JLabel l=new JLabel("Do you want to Save?"); 
		JButton b1=new JButton("Yes"); 
		JButton b2=new JButton("No"); 
		f.setSize(180,100); 
		f.setLocation(100,100); 
		f.getContentPane().setLayout(new FlowLayout()); 
		
		// getContentPane behövs inte egentligen, men är det gamla sättet att göra på
		f.getContentPane().add(l);
		f.getContentPane().add(b1);
		f.getContentPane().add(b2);
		f.setVisible(true); 
	}
	
	public static void main (String args[]) { 
		new Question(); 
	} 
}