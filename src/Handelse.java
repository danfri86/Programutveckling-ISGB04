import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Handelse extends WindowAdapter {
	private JFrame f;
	private JButton b;
	private JTextArea t;
	private JScrollPane sb;
	public Handelse(){
		f=new JFrame("Hello world!");
		f.addWindowListener(this);
		b=new JButton("Tryck mig");
		t=new JTextArea();
		sb=new JScrollPane(t);
		f.getContentPane().add(b,BorderLayout.SOUTH);
		b.addActionListener(new Lyssnare(this));
		f.getContentPane().add(sb);
		f.setSize(250,200);
		f.setLocation(100,100);
		f.setVisible(true);
	}
	public void newMessage(String s) {
		t.append(s+"\n");
	}
	public void windowClosing (WindowEvent e) {
		System.out.println("Hej då");
		System.exit(1);
	}
	public static void main (String args[]) {
		new Handelse();
	}
}