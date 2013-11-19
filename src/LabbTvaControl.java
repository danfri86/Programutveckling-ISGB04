import java.awt.event.*;
import java.io.*; 

import javax.swing.*;

import java.util.*;

public class LabbTvaControl extends WindowAdapter implements ActionListener{
	private LabbTvaView l;
	private LabbTvaModell ll;

	public LabbTvaControl(LabbTvaView lin){
		l=lin;
		ll=new LabbTvaModell();
	}
	
	public void actionPerformed(ActionEvent e) {
		String rad=ll.getRad();

		JMenuItem grejj;
		
		grejj=(JMenuItem)e.getSource();
		if(grejj.getText()=="Öppna"){
			/*String s="";

			JFileChooser chooser = new
					JFileChooser("d:"+File.separator+"Java-program");
			int returnVal = chooser.showSaveDialog(f);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				s=(chooser.getCurrentDirectory()
						+File.separator+chooser.getSelectedFile
						().getName());
			}*/
			
			LabbTvaFilhantering instanceOppna = LabbTvaFilhantering.getInstance(); 
		}

		grejj=(JMenuItem)e.getSource();
		if(grejj.getText()=="Spara"){
			LabbTvaFilhantering instanceSpara = LabbTvaFilhantering.getInstance();
		}
		
		grejj=(JMenuItem)e.getSource();
		if(grejj.getText()=="Slumpa"){
			l.skrivNyRad(rad);
		}
		
		grejj=(JMenuItem)e.getSource();
		if(grejj.getText()=="Rensa"){
			l.rensaText();
		}

		grejj=(JMenuItem)e.getSource();
		if(grejj.getText()=="Avsluta"){
			System.out.println("Hej då");
			System.exit(0);
		}
	}
	
	public void windowClosing (WindowEvent e){
		System.exit(0);
	}
}