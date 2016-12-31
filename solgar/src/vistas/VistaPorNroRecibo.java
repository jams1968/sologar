package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladoresVistas.ControladorVistaPorNroRecibo;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class VistaPorNroRecibo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNRecibo;
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VistaPorNroRecibo dialog = new VistaPorNroRecibo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VistaPorNroRecibo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaPorNroRecibo.class.getResource("/imagenes/iconos/ventilador.png")));
		setBounds(100, 100, 450, 127);
		getContentPane().setLayout(new BorderLayout());
		FlowLayout fl_contentPanel = new FlowLayout();
		fl_contentPanel.setAlignment(FlowLayout.LEFT);
		contentPanel.setLayout(fl_contentPanel);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblNRecibo = new JLabel("Indique Nro. de Recibo:");
			lblNRecibo.setFont(new Font("Tahoma", Font.BOLD, 12));
			contentPanel.add(lblNRecibo);
		}
		{
			textNRecibo = new JTextField();
			contentPanel.add(textNRecibo);
			textNRecibo.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		//-------------->enlaces <-------------
		ControladorVistaPorNroRecibo eco=new ControladorVistaPorNroRecibo(this);
		cancelButton.addActionListener(eco);
		okButton.addActionListener(eco);
		//this.toFront();
		this.isAlwaysOnTop();
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}//fin constructor

	public JTextField getTextNRecibo() {
		return textNRecibo;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

}//fin de la clase
