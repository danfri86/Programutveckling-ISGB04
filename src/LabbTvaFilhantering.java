import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class LabbTvaFilhantering {
	private LabbTvaView v;
	private LabbTvaControl c;

	private static LabbTvaFilhantering instance = null;
	
	private LabbTvaFilhantering(){}
	
	public void oppna(String filnamnIn) {
		try {
			FileReader fileReader = new FileReader(filnamnIn);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String inputFile="";
			String textFieldReadable=bufferedReader.readLine();

			while(textFieldReadable != null){
				inputFile += textFieldReadable;
				textFieldReadable = bufferedReader.readLine();
			}
			c.setTextArea().setText(inputFile);
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
			out.write(c.lottoRad());

			//Detta sparar allt innehåll i textarean
			//out.write(t.getText());

			//Close the output stream
			out.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	} 

	public static LabbTvaFilhantering getInstance() {
		System.out.println("getInstance anropad");
		
		if(instance == null) {
			instance = new LabbTvaFilhantering();
		}
		return instance;
	}
}
