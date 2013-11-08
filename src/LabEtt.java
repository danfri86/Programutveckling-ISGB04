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

	public LabEtt(String b){
		//Filhantering
		filnamn=b; 
		inmat=new BufferedReader 
				(new InputStreamReader(System.in));

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

			}

			grejj=(JMenuItem)e.getSource();
			if(grejj.getText()=="Spara"){
				LabEtt b=new LabEtt("fil.txt");
				b.las();
				b.skriv();

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
		try { 
			lagra=new BufferedWriter(new OutputStreamWriter 
					(new BufferedOutputStream 
							(new FileOutputStream(filnamn)))); 
			//System.out.println("Ange den nya texten: "); 
			in=inmat.readLine(); 
			do { 
				lagra.write(in+"\n");
				in=inmat.readLine();
			} while (!in.equals("slut"));
			lagra.close(); 
		} 
		catch (IOException e) {
			System.out.println("Går ej att skriva till filen"); 
		} 
	} 

	public void newMessage(String s) { 
		t.append(s+"\n");
	}

	public static void main (String args[])throws IOException {
		LabEtt f=new LabEtt("Fil.txt");
	}
}