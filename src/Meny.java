import java.awt.*; 
import java.awt.event.*; 
import java.io.File; 
import javax.swing.*; 
class Meny extends WindowAdapter implements ActionListener{
	private JFrame f; 
	private JMenuBar mainMenu; 
	private JMenu val, edit; 
	private JMenuItem ch1,ch2, ch3, ch4;
	public Meny(){ 
		f=new JFrame("Menyval");
		f.addWindowListener(this); 
		mainMenu=new JMenuBar(); 
		val=new JMenu("Val"); 
		edit=new JMenu("Edit"); 
		ch1=new JMenuItem("Första val"); 
		ch2=new JMenuItem("Spara"); 
		ch3=new JMenuItem("Tredje val"); 
		ch4=new JMenuItem("Fjärde val"); 
		ch2.addActionListener(this); 
		val.add(ch1);
		val.add(ch2); 
		val.add(ch3); 
		val.addSeparator(); 
		val.add(ch4); 
		mainMenu.add(val); 
		mainMenu.add(edit); 
		f.setJMenuBar(mainMenu); 
		f.setSize(200,200); 
		f.setVisible(true);
	} 
	public void actionPerformed(ActionEvent e) {
		JMenuItem grejj; 
		grejj=(JMenuItem)e.getSource();
		if(grejj.getText()=="Spara"){ 
			JFileChooser chooser = new
					JFileChooser("d:"+File.separator+"Java-program"); 
			int returnVal =
					chooser.showSaveDialog(f);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				this.sparaFil(chooser.getCurrentDirectory()
						+File.separator+chooser.getSelectedFile
						().getName()); 
			}
		}
	}
	private void sparaFil(String text) { 
		System.out.println(text);
	} 
	public void windowClosing (WindowEvent e){
		System.exit(1);
	} 
	public static void main(String args[]){
		new Meny();
	}
}