import java.io.*;


public class LabbTvaFilhantering {
	private LabbTvaView v;
	private LabbTvaControl c;

	private static LabbTvaFilhantering instance = null;
	
	private LabbTvaFilhantering(){}
	
	public String oppna(String filnamnIn) {
		String textFieldReadable="";
		try {
			
			BufferedReader las=new BufferedReader (new InputStreamReader 
			(new BufferedInputStream 
			(new FileInputStream(filnamnIn)))); 

			 textFieldReadable=las.readLine();

			if(las != null){
				textFieldReadable = textFieldReadable+las.readLine();
			}
			
			//Behovs kanske inte men ser bra ut
			las.close();
			
		}
		catch (IOException e) {
			System.out.println("Filen ar slut!!");
		}
		return textFieldReadable;
	}

	public void skriv(String filnamn,String rader) {
		try{
			// Create file
			BufferedWriter fstream=new BufferedWriter(new OutputStreamWriter (new BufferedOutputStream 
			(new FileOutputStream(filnamn))));
			
			fstream.write(rader);
			
			//Close the output stream
			fstream.close();
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
