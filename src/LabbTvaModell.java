import java.io.File;
import java.util.Random;

import javax.swing.JFileChooser;

public class LabbTvaModell {
	
	private int slump[];
	private String Lottorad;
	private String text;
	
	public String getRad(){
		slump = new int[7];
		Random number = new Random();
		Lottorad="";

		for(int i=0; i<=6; i++){			
			slump[i] = number.nextInt(34)+1;
			Lottorad=Lottorad+slump[i]+" ";
		}
		return Lottorad;
	}
}