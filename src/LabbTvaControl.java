import java.awt.event.*;
import java.io.*; 
import javax.swing.*;
import java.util.*;

public class LabbTvaControl extends WindowAdapter implements ActionListener{
	private LabbTvaView l;
	private LabbTvaModell ll;
	private LabbTvaFilhantering fh;

	public LabbTvaControl(LabbTvaView lin){
		l=lin;
		ll=new LabbTvaModell();
	}
	
	public void actionPerformed(ActionEvent e) {
		String rad=ll.getRad();

		JMenuItem grejj;
		
		grejj=(JMenuItem)e.getSource();
		if(grejj.getText()=="Oppna"){
			String o = l.oppna();
			
			LabbTvaFilhantering instanceOppna = LabbTvaFilhantering.getInstance();
			String resultat=instanceOppna.oppna(o);
			l.setTextArea(resultat);
		}

		grejj=(JMenuItem)e.getSource();
		if(grejj.getText()=="Spara"){
			String b = l.skriv();
			
			LabbTvaFilhantering instanceSpara = LabbTvaFilhantering.getInstance();
			String rader=l.getTextArea();
			instanceSpara.skriv(b,rader);
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
			System.out.println("Hej da");
			System.exit(0);
		}
	}
	
	public String lottoRad(){
		String rad=ll.getRad();
		return rad;
	}
	
	public void windowClosing (WindowEvent e){
		System.exit(0);
	}
}