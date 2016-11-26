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

public class VistaRepuestos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton cancelButton;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVaciar;
	private JButton btnReportePantalla;
	private JTextField textCodigo;
	private JTextField textRepuesto;
	private JTextField textMarca;
	private JLabel lblMensaje;
	private JLabel lblContarTelefono1;
	private JTextField textCantidad;
	private JTextField textPrecioVenta;
	private JTextArea textDescripcion;
	private ComboTipoAparatos comboTipoAparatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VistaRepuestos dialog = new VistaRepuestos();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VistaRepuestos() {
		setTitle("REGISTRO DE REPUESTOS");
		setResizable(false);
		
		setBounds(100, 100, 700, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panelBotones = new JPanel();
			panelBotones.setBorder(new TitledBorder(null, "Botones", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
			panelBotones.setBounds(10, 281, 664, 69);
			contentPanel.add(panelBotones);
			panelBotones.setLayout(null);
			{
				cancelButton = new JButton("");
				cancelButton.setBounds(589, 17, 65, 41);
				panelBotones.add(cancelButton);
				cancelButton.setToolTipText("Cerrar Ventana");
				cancelButton.setIcon(new ImageIcon(VistaRepuestos.class.getResource("/imagenes/iconos/iconos_32x32/door.png")));
				cancelButton.setRolloverIcon(new ImageIcon(VistaRepuestos.class.getResource("/imagenes/iconos/iconos_32x32/door_out.png")));
				cancelButton.setCursor(new Cursor(12));
				cancelButton.setActionCommand("Cancel");
			}
			
			btnRegistrar = new JButton("");
			btnRegistrar.setToolTipText("Registrar Cliente");
			btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRegistrar.setRolloverIcon(new ImageIcon(VistaRepuestos.class.getResource("/imagenes/iconos/iconos_32x32/plus.png")));
			btnRegistrar.setIcon(new ImageIcon(VistaRepuestos.class.getResource("/imagenes/iconos/iconos_32x32/group_add.png")));
			btnRegistrar.setBounds(10, 17, 65, 41);
			panelBotones.add(btnRegistrar);
			{
				btnModificar = new JButton("");
				btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnModificar.setRolloverIcon(new ImageIcon(VistaRepuestos.class.getResource("/imagenes/iconos/iconos_32x32/pencil2.png")));
				btnModificar.setToolTipText("Modicar Cliente");
				btnModificar.setIcon(new ImageIcon(VistaRepuestos.class.getResource("/imagenes/iconos/iconos_32x32/group_edit.png")));
				btnModificar.setBounds(85, 17, 65, 41);
				panelBotones.add(btnModificar);
			}
			{
				btnEliminar = new JButton("");
				btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnEliminar.setToolTipText("Eliminar Cliente");
				btnEliminar.setRolloverIcon(new ImageIcon(VistaRepuestos.class.getResource("/imagenes/iconos/iconos_32x32/busy.png")));
				btnEliminar.setIcon(new ImageIcon(VistaRepuestos.class.getResource("/imagenes/iconos/iconos_32x32/group_delete.png")));
				btnEliminar.setBounds(160, 17, 65, 41);
				panelBotones.add(btnEliminar);
			}
			{
				btnVaciar = new JButton("");
				btnVaciar.setToolTipText("Vaciar Formulario");
				btnVaciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnVaciar.setRolloverIcon(new ImageIcon(VistaRepuestos.class.getResource("/imagenes/iconos/iconos_32x32/refresh.png")));
				btnVaciar.setIcon(new ImageIcon(VistaRepuestos.class.getResource("/imagenes/iconos/iconos_32x32/page_refresh.png")));
				btnVaciar.setBounds(231, 17, 65, 41);
				panelBotones.add(btnVaciar);
			}
			{
				btnReportePantalla = new JButton("");
				btnReportePantalla.setToolTipText("Reporte Clientes por pantalla");
				btnReportePantalla.setRolloverIcon(new ImageIcon(VistaRepuestos.class.getResource("/imagenes/iconos/iconos_32x32/application_view_detail.png")));
				btnReportePantalla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnReportePantalla.setIcon(new ImageIcon(VistaRepuestos.class.getResource("/imagenes/iconos/iconos_32x32/graphic-design.png")));
				btnReportePantalla.setBounds(306, 17, 65, 41);
				panelBotones.add(btnReportePantalla);
			}
		}
		
		JLabel lblCedula = new JLabel("Codigo:");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCedula.setBounds(369, 13, 50, 24);
		contentPanel.add(lblCedula);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(418, 14, 256, 25);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblNombres = new JLabel("Repuesto:");
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombres.setBounds(10, 51, 68, 24);
		contentPanel.add(lblNombres);
		
		textRepuesto = new JTextField();
		textRepuesto.setBounds(77, 52, 277, 25);
		contentPanel.add(textRepuesto);
		textRepuesto.setColumns(30);
		
		JLabel lblTelfonoCelular = new JLabel("Marca:");
		lblTelfonoCelular.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelfonoCelular.setBounds(369, 56, 50, 14);
		contentPanel.add(lblTelfonoCelular);
		
		
		MaskFormatter mascaraTelefono,mascaraCorreo;
		try {
			mascaraTelefono = new MaskFormatter("(####)-###-##-##");
			mascaraTelefono.setPlaceholderCharacter('_');
			
			
			JPanel panelMensaje = new JPanel();
			panelMensaje.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mensaje del Sistema", TitledBorder.RIGHT, TitledBorder.TOP, null, Color.BLUE));
			panelMensaje.setBounds(63, 235, 611, 46);
			contentPanel.add(panelMensaje);
			panelMensaje.setLayout(null);
			
			lblMensaje = new JLabel("");
			lblMensaje.setForeground(Color.RED);
			lblMensaje.setBounds(10, 11, 591, 24);
			panelMensaje.add(lblMensaje);
			
			lblContarTelefono1 = new JLabel("");
			lblContarTelefono1.setForeground(Color.RED);
			lblContarTelefono1.setBounds(232, 63, 35, 14);
			contentPanel.add(lblContarTelefono1);
			ButtonGroup grupoSexo=new ButtonGroup();
			
			textMarca = new JTextField();
			textMarca.setColumns(10);
			textMarca.setBounds(418, 52, 256, 25);
			contentPanel.add(textMarca);
			
			JLabel lblCantidad = new JLabel("Cantidad:");
			lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblCantidad.setBounds(10, 103, 69, 14);
			contentPanel.add(lblCantidad);
			
			textCantidad = new JTextField();
			textCantidad.setColumns(10);
			textCantidad.setBounds(77, 99, 238, 25);
			contentPanel.add(textCantidad);
			
			comboTipoAparatos = new ComboTipoAparatos();
			comboTipoAparatos.setBounds(91, 16, 263, 25);
			contentPanel.add(comboTipoAparatos);
			
			JLabel lblTipoEquipo = new JLabel("Tipo Equipo:");
			lblTipoEquipo.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblTipoEquipo.setBounds(10, 13, 84, 24);
			contentPanel.add(lblTipoEquipo);
			
			textPrecioVenta = new JTextField();
			textPrecioVenta.setColumns(10);
			textPrecioVenta.setBounds(418, 99, 256, 25);
			contentPanel.add(textPrecioVenta);
			
			JLabel lblPrecioVenta = new JLabel("Precio Venta:");
			lblPrecioVenta.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPrecioVenta.setBounds(325, 103, 110, 14);
			contentPanel.add(lblPrecioVenta);
			
			JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
			lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblDescripcion.setBounds(10, 151, 84, 14);
			contentPanel.add(lblDescripcion);
			
			textDescripcion = new JTextArea();
			textDescripcion.setCaretColor(Color.BLACK);
			textDescripcion.setBorder(new LineBorder(Color.GRAY, 1, true));
			textDescripcion.setBounds(91, 147, 583, 86);
			contentPanel.add(textDescripcion);
			comboTipoAparatos.llenar();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//-------->enlaces<-------------
		
		ControladorVistaRepuestos eco = new ControladorVistaRepuestos(this);
		
		btnRegistrar.addActionListener(eco);
		textCodigo.addKeyListener(eco);
		textCantidad.addKeyListener(eco);
		
		
		
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

	public JButton getBtnReportePantalla() {
		return btnReportePantalla;
	}

	public JTextField getTextCodigo() {
		return textCodigo;
	}

	public JTextField getTextRepuesto() {
		return textRepuesto;
	}

	public JTextField getTextMarca() {
		return textMarca;
	}

	public JLabel getLblMensaje() {
		return lblMensaje;
	}

	public JLabel getLblContarTelefono1() {
		return lblContarTelefono1;
	}

	public JTextField getTextCantidad() {
		return textCantidad;
	}

	public JTextField getTextPrecioVenta() {
		return textPrecioVenta;
	}

	public JTextArea getTextDescripcion() {
		return textDescripcion;
	}

	public ComboTipoAparatos getComboTipoAparatos() {
		return comboTipoAparatos;
	}

	
	
	
}//fin de la clase
