package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import controladoresVistas.ControladorVistaRangoFechas;

public class VistaRangoFecha extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JDateChooser fecha1;
	private JButton okButton;
	private JButton cancelButton;
	private JDateChooser fecha2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		VistaRangoFecha dialog = new VistaRangoFecha();
	}

	/**
	 * Create the dialog.
	 */
	public VistaRangoFecha() {
		setBounds(100, 100, 450, 154);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelTitulo = new JPanel();
			contentPanel.add(panelTitulo, BorderLayout.NORTH);
			{
				JLabel lblTitulo = new JLabel("Indique Rango de Fechas");
				lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
				panelTitulo.add(lblTitulo);
			}
		}
		{
			JPanel panelFechas = new JPanel();
			contentPanel.add(panelFechas, BorderLayout.CENTER);
			{
				JLabel lblDesde = new JLabel("Desde:");
				lblDesde.setFont(new Font("Tahoma", Font.BOLD, 12));
				panelFechas.add(lblDesde);
			}
			{
				fecha1 = new JDateChooser();
				panelFechas.add(fecha1);
			}
			{
				JLabel lblFecha2 = new JLabel("Hasta:");
				lblFecha2.setFont(new Font("Tahoma", Font.BOLD, 12));
				panelFechas.add(lblFecha2);
			}
			{
				fecha2 = new JDateChooser();
				panelFechas.add(fecha2);
			}
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
		
		//-------->enlcaces<-------------
		ControladorVistaRangoFechas eco=new ControladorVistaRangoFechas(this);
		okButton.addActionListener(eco);
		cancelButton.addActionListener(eco);
		
		
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}//fin constructor

	public JDateChooser getFecha1() {
		return fecha1;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JDateChooser getFecha2() {
		return fecha2;
	}
	

}//fin de la clase
