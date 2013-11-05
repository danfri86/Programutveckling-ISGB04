import java.awt.event.*; 
class Lyssnare implements ActionListener { 
	private Handelse h; 
	public Lyssnare(Handelse hin) { 
		h=hin; 
		h.newMessage("Nu ass. lyssnaren med händelsekällan"); 
		h.newMessage("Konstruktor klar"); 
	} 
	public void actionPerformed(ActionEvent e) { 
		h.newMessage("actionPerformed: Wow! Knappklick"); 
	} 
} 
