import java.io.File;
import java.util.Random;

import javax.swing.JFileChooser;

public class LabbTvaModell {

	private int slump[];
	private String Lottorad;
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

	public static void main(String[] args) {
		LabbTvaModell m=new LabbTvaModell();
		System.out.println(m.getRad());
	}
}