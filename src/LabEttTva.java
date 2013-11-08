import java.awt.*;
import java.awt.event.*; 
import java.io.*; 
import javax.swing.*;

import java.util.*;

public class LabEttTva extends WindowAdapter {

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

	public LabEttTva(){
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
		private LabEttTva o; 

		public Inner(LabEttTva oin) {
			o=oin; 
			//o.newMessage("Tryck på 'Meny' och slumpa ett tal."); 
		}

		public void actionPerformed(ActionEvent e) {

			JMenuItem grejj; 

			grejj=(JMenuItem)e.getSource();
			if(grejj.getText()=="Öppna"){

			}

			grejj=(JMenuItem)e.getSource();
			if(grejj.getText()=="Spara"){
				//las();
				skriv();

				JFileChooser chooser = new
						JFileChooser("d:"+File.separator+"Java-program");
				int returnVal = chooser.showSaveDialog(f);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					sparaFil(chooser.getCurrentDirectory()
							+File.separator+chooser.getSelectedFile
							().getName());
				}
			}

			grejj=(JMenuItem)e.getSource();
			if(grejj.getText()=="Slumpa"){
				slumpa();
				o.newMessage(Lottorad);
			}

			grejj=(JMenuItem)e.getSource();
			if(grejj.getText()=="Rensa"){

			}

			grejj=(JMenuItem)e.getSource();
			if(grejj.getText()=="Avsluta"){
				System.out.println("Hej då");
				f.setVisible(false);
				f.dispose();
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

	private void sparaFil(String text) { 
		System.out.println(text);
	}

	public void las() { 
		try { 
			las=new BufferedReader (new InputStreamReader 
					(new BufferedInputStream 
							(new FileInputStream(filnamn)))); 
			//System.out.println("Innehåll i filen: "); 
			in=Lottorad;
			while (in!=null) { 
				System.out.println(in); 
				in=las.readLine(); 
			} 
		} 
		catch (IOException e) { 
			System.out.println("Filen är slut!!"); 
		} 
	}

	public void skriv() { 
		try{
			// Create file
			FileWriter fstream = new FileWriter("fil.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			
			//Detta sparar den sista slumpade lottoraden, och inte hela innehållet i jscrollpane
			out.write(Lottorad);
			
			//Close the output stream
			out.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	} 

	public void newMessage(String s) { 
		t.append(s+"\n");
	}

	public static void main (String args[])throws IOException {
		new LabEttTva();
	}
}