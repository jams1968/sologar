package modelosComboBox;

import java.awt.Cursor;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class ComboDocumentoIdentidad extends JComboBox<String>{

	public ComboDocumentoIdentidad() {
		super();
		this.addItem("V-");
		this.addItem("J-");
		this.addItem("G-");
		this.addItem("I-");
		this.addItem("E-");
		this.setCursor(new Cursor(12));
	}

}
