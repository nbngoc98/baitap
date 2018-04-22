package FileDemo;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class SaveFile extends JFrame implements ActionListener {

	JTextArea ta = new JTextArea();
	JButton saveAs = new JButton("Save as..");
	FileWriter fw;
	JFileChooser chooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		new SaveFile();
	}

	/**
	 * Create the application.
	 */
	public SaveFile() {
		Container cont = this.getContentPane();
		saveAs.addActionListener(this);
		cont.add(ta);
		cont.add(saveAs, "South");
		this.setSize(400, 400);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0) {
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Save as ..");
		if (chooser.showSaveDialog(this)==JFileChooser.APPROVE_OPTION) {
			String filename =chooser.getSelectedFile().getAbsolutePath();
			saveFile(filename);
		}
	}
	public void saveFile(String filename) {
		try {
			String content = ta.getText();
			fw = new FileWriter(filename);
			fw.write(content);
			fw.flush();
			fw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
