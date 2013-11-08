import java.io.*; 
class Spara { 
	private String filnamn; 
	private BufferedReader las; 
	private BufferedWriter lagra; 
	private BufferedReader inmat; 
	private String in; 
	public Spara(String f) { 
		filnamn=f; 
		inmat=new BufferedReader 
				(new InputStreamReader(System.in)); 
	}

	public void las() { 
		try { 
			las=new BufferedReader (new InputStreamReader 
					(new BufferedInputStream 
							(new FileInputStream(filnamn)))); 
			System.out.println("Innehåll i filen: "); 
			in=las.readLine(); 
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
			System.out.println("Ange den nya texten: "); 
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
	
	public static void main(String[] args)throws IOException { 
		Spara f=new Spara("fil.txt"); 
		f.las(); 
		f.skriv(); 
	} 
} 