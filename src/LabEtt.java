import java.awt.*;
import java.awt.event.*; 
import java.io.*; 
import javax.swing.*;

import java.util.*;

public class LabEtt extends WindowAdapter {

	private int slump[];
	private String Lottorad;
	private JFrame f;
	private JTextArea t; 
	private JScrollPane sb;

	// Filhantering
	private String filnamn; 
	private BufferedReader las; 
	private BufferedWriter lagra; 
	private BufferedReader inmat; 
	private String in;

	// Menyobjekt
	private JMenuBar mainMenu; 
	private JMenu meny; 
	private JMenuItem ch1,ch2, ch3, ch4, ch5;

	public LabEtt(){
		//Fönster
		f=new JFrame("Lab 1");
		f.addWindowListener(this);
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

		// Lyssna på knapptryckningar
		ch1.addActionListener(new Inner(this));
		ch2.addActionListener(new Inner(this));
		ch3.addActionListener(new Inner(this));
		ch4.addActionListener(new Inner(this));
		ch5.addActionListener(new Inner(this));

		// Lägg till meny-items
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

	class Inner implements ActionListener {
		private LabEtt o; 

		public Inner(LabEtt oin) {
			o=oin; 
			//o.newMessage("Tryck på 'Meny' och slumpa ett tal."); 
		}

		public void actionPerformed(ActionEvent e) {

			JMenuItem grejj; 

			grejj=(JMenuItem)e.getSource();
			if(grejj.getText()=="Öppna"){
				String s="";
				
				JFileChooser chooser = new
						JFileChooser("d:"+File.separator+"Java-program");
				int returnVal = chooser.showOpenDialog(f);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					s=(chooser.getCurrentDirectory()
							+File.separator+chooser.getSelectedFile
							().getName());
				}
				las(s);
			}

			grejj=(JMenuItem)e.getSource();
			if(grejj.getText()=="Spara"){
				String s="";

				JFileChooser chooser = new
						JFileChooser("d:"+File.separator+"Java-program");
				int returnVal = chooser.showSaveDialog(f);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					s=(chooser.getCurrentDirectory()
							+File.separator+chooser.getSelectedFile
							().getName());
				}
				skriv(s);
			}

			grejj=(JMenuItem)e.getSource();
			if(grejj.getText()=="Slumpa"){
				slumpa();
				o.newMessage(Lottorad);
			}

			grejj=(JMenuItem)e.getSource();
			if(grejj.getText()=="Rensa"){
				t.setText("");
			}

			grejj=(JMenuItem)e.getSource();
			if(grejj.getText()=="Avsluta"){
				System.out.println("Hej då");
				System.exit(0);
			}
		} 
	}

	private void slumpa(){
		slump = new int[7];
		Random number = new Random();
		Lottorad="";

		for(int i=0; i<=6; i++){			
			slump[i] = number.nextInt(34)+1;
			Lottorad=Lottorad+slump[i]+" ";
		}
	}
	
	public void las(String filnamn) {
		try {
			FileReader fileReader = new FileReader(filnamn);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String inputFile="";
			String textFieldReadable=bufferedReader.readLine();
			
			while(textFieldReadable != null){
				inputFile += textFieldReadable;
				textFieldReadable = bufferedReader.readLine();
			}
			t.setText(inputFile);
			System.out.println(inputFile);
			
			//Behövs kanske inte men ser bra ut
			bufferedReader.close();
		}
		catch (IOException e) {
			System.out.println("Filen är slut!!");
		}
	}

	public void skriv(String filnamn) { 
		try{
			// Create file
			FileWriter fstream = new FileWriter(filnamn);
			BufferedWriter out = new BufferedWriter(fstream);
			
			//Detta sparar bara den sista slumpade lottoraden
			out.write(Lottorad);
			
			//Detta sparar allt innehåll i textarean
			//out.write(t.getText());
			
			//Close the output stream
			out.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public void windowClosing(WindowEvent e){
		System.out.println("Hej då");
		System.exit(0);
	}

	public void newMessage(String s) { 
		t.append(s+"\n");
	}

	public static void main (String args[])throws IOException {
		new LabEtt();
	}
}