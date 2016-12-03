/****************************************************************************
 * programa: VistaRepuestos.java
 * objetivo: interface del modelo persona
 ****************************************************************************/
package vistas;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import controladoresVistas.ControladorVistaRepuestos;
import controladoresVistas.ControladorVistaTiposAparatos;
import modelos.TipoAparato;
import modelos.Usuario;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorListener;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

import modelosComboBox.ComboTipoAparatos;
import java.awt.Toolkit;

public class VistaTipoAparato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton cancelButton;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVaciar;
	private JTextField textTipo;
	private JLabel lblMensaje;
	private TipoAparato registroAparato;
	private ComboTipoAparatos comboTipoAparatos;

	/**
	 * Launch the application.
	 */
	
	public ComboTipoAparatos getComboTipoAparatos() {
		return comboTipoAparatos;
	}

	/**
	 * Create the dialog.
	 */   
	public VistaTipoAparato() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaTipoAparato.class.getResource("/imagenes/iconos/ventilador.png")));
		setTitle("TIPOS DE APARATOS");
		setResizable(false);
		
		setBounds(100, 100, 421, 280);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panelBotones = new JPanel();
			panelBotones.setBorder(new TitledBorder(null, "Botones", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
			panelBotones.setBounds(10, 175, 395, 69);
			contentPanel.add(panelBotones);
			panelBotones.setLayout(null);
			{
				cancelButton = new JButton("");
				cancelButton.setBounds(306, 17, 65, 41);
				panelBotones.add(cancelButton);
				cancelButton.setToolTipText("Cerrar Ventana");
				cancelButton.setIcon(new ImageIcon(VistaTipoAparato.class.getResource("/imagenes/iconos/iconos_32x32/door.png")));
				cancelButton.setRolloverIcon(new ImageIcon(VistaTipoAparato.class.getResource("/imagenes/iconos/iconos_32x32/door_out.png")));
				cancelButton.setCursor(new Cursor(12));
				cancelButton.setActionCommand("Cancel");
			}
			
			btnRegistrar = new JButton("");
			btnRegistrar.setEnabled(false);
			btnRegistrar.setToolTipText("Registrar Tipo de Aparato");
			btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRegistrar.setRolloverIcon(new ImageIcon(VistaTipoAparato.class.getResource("/imagenes/iconos/iconos_32x32/plus.png")));
			btnRegistrar.setIcon(new ImageIcon(VistaTipoAparato.class.getResource("/imagenes/iconos/iconos_32x32/iconoAparato.png")));
			btnRegistrar.setBounds(10, 17, 65, 41);
			panelBotones.add(btnRegistrar);
			{
				btnModificar = new JButton("");
				btnModificar.setEnabled(false);
				btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnModificar.setRolloverIcon(new ImageIcon(VistaTipoAparato.class.getResource("/imagenes/iconos/iconos_32x32/pencil2.png")));
				btnModificar.setToolTipText("Modicar Tipo de Aparato");
				btnModificar.setIcon(new ImageIcon(VistaTipoAparato.class.getResource("/imagenes/iconos/iconos_32x32/iconoAparatoModificar.png")));
				btnModificar.setBounds(85, 17, 65, 41);
				panelBotones.add(btnModificar);
			}
			{
				btnEliminar = new JButton("");
				btnEliminar.setEnabled(false);
				btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnEliminar.setToolTipText("Eliminar Tipo de Aparato");
				btnEliminar.setRolloverIcon(new ImageIcon(VistaTipoAparato.class.getResource("/imagenes/iconos/iconos_32x32/busy.png")));
				btnEliminar.setIcon(new ImageIcon(VistaTipoAparato.class.getResource("/imagenes/iconos/iconos_32x32/iconoAparatoEliminar.png")));
				btnEliminar.setBounds(160, 17, 65, 41);
				panelBotones.add(btnEliminar);
			}
			{
				btnVaciar = new JButton("");
				btnVaciar.setToolTipText("Vaciar Formulario");
				btnVaciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnVaciar.setRolloverIcon(new ImageIcon(VistaTipoAparato.class.getResource("/imagenes/iconos/iconos_32x32/refresh.png")));
				btnVaciar.setIcon(new ImageIcon(VistaTipoAparato.class.getResource("/imagenes/iconos/iconos_32x32/page_refresh.png")));
				btnVaciar.setBounds(231, 17, 65, 41);
				panelBotones.add(btnVaciar);
			}
		}
		
		JLabel lblTipo = new JLabel("Tipo Aparato:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipo.setBounds(10, 11, 91, 24);
		contentPanel.add(lblTipo);
		
		textTipo = new JTextField();
		textTipo.setBounds(98, 12, 256, 25);
		contentPanel.add(textTipo);
		textTipo.setColumns(10);
		
		
		MaskFormatter mascaraTelefono,mascaraCorreo;
		try {
			mascaraTelefono = new MaskFormatter("(####)-###-##-##");
			mascaraTelefono.setPlaceholderCharacter('_');
			
			
			JPanel panelMensaje = new JPanel();
			panelMensaje.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mensaje del Sistema", TitledBorder.RIGHT, TitledBorder.TOP, null, Color.BLUE));
			panelMensaje.setBounds(63, 118, 335, 46);
			contentPanel.add(panelMensaje);
			panelMensaje.setLayout(null);
			
			lblMensaje = new JLabel("");
			lblMensaje.setForeground(Color.RED);
			lblMensaje.setBounds(10, 11, 308, 24);
			panelMensaje.add(lblMensaje);
			
			
			
			JLabel labelRegistrados = new JLabel("Registrados:");
			labelRegistrados.setFont(new Font("Tahoma", Font.BOLD, 12));
			labelRegistrados.setBounds(10, 63, 84, 24);
			contentPanel.add(labelRegistrados);
			
			comboTipoAparatos = new ComboTipoAparatos();
			comboTipoAparatos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboTipoAparatos.llenar();
			comboTipoAparatos.setBounds(91, 66, 263, 25);
			contentPanel.add(comboTipoAparatos);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//-------->enlaces<-------------
		
		ControladorVistaTiposAparatos eco = new ControladorVistaTiposAparatos(this);
		comboTipoAparatos.addActionListener(eco);
		cancelButton.addActionListener(eco);
		btnRegistrar.addActionListener(eco);
		
		textTipo.addKeyListener(eco);
		/*	
		btnAgregarCantidad.addActionListener(eco);
		btnEliminar.addActionListener(eco);
		btnModificar.addActionListener(eco);
		btnVaciar.addActionListener(eco);
		btnReportePantalla.addActionListener(eco);
		
		textCodigo.addKeyListener(eco);
		textRepuesto.addKeyListener(eco);
		textMarca.addKeyListener(eco);
		textCantidad.addKeyListener(eco);
		textPrecioVenta.addKeyListener(eco);
		textDescripcion.addKeyListener(eco);*/
		
		
		
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}//fin del constructor
//------------->getters<------------------

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JButton getBtnVaciar() {
		return btnVaciar;
	}

	
	
	

	public JLabel getLblMensaje() {
		return lblMensaje;
	}

	


	
	public JTextField getTextTipo() {
		return textTipo;
	}

	public static void main(String[] args) {
		new VistaTipoAparato();
	}
}//fin de la clase
