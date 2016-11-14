/****************************************************************************
 * programa: VistaPersona.java
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

import controladoresVistas.ControladorVistaPersona;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JRadioButton;

public class VistaPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton cancelButton;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVaciar;
	private JButton btnReportePantalla;
	private JTextField textCedula;
	private JTextField textNombres;
	private JTextField textApellidos;
	private JTextField txtTelefono1;
	private JTextField textTelefono1;
	private JLabel lblTelfono2;
	private JTextField textTelefono2;
	private JLabel lblCorreo;
	private JTextField textCorreo;
	private JTextArea textDireccion;
	private JLabel lblContarCedula;
	private JLabel lblMensaje;
	private JLabel lblContarNombres;
	private JLabel lblContrarApellidos;
	private JLabel lblContarTelefono1;
	private JLabel lblContarDirec;
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VistaPersona dialog = new VistaPersona();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VistaPersona() {
		setTitle("REGISTRO DE CLIENTES");
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
				cancelButton.setIcon(new ImageIcon(VistaPersona.class.getResource("/imagenes/iconos/iconos_32x32/door.png")));
				cancelButton.setRolloverIcon(new ImageIcon(VistaPersona.class.getResource("/imagenes/iconos/iconos_32x32/door_out.png")));
				cancelButton.setCursor(new Cursor(12));
				cancelButton.setActionCommand("Cancel");
			}
			
			btnRegistrar = new JButton("");
			btnRegistrar.setToolTipText("Registrar Cliente");
			btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRegistrar.setRolloverIcon(new ImageIcon(VistaPersona.class.getResource("/imagenes/iconos/iconos_32x32/plus.png")));
			btnRegistrar.setIcon(new ImageIcon(VistaPersona.class.getResource("/imagenes/iconos/iconos_32x32/group_add.png")));
			btnRegistrar.setBounds(10, 17, 65, 41);
			panelBotones.add(btnRegistrar);
			{
				btnModificar = new JButton("");
				btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnModificar.setRolloverIcon(new ImageIcon(VistaPersona.class.getResource("/imagenes/iconos/iconos_32x32/pencil2.png")));
				btnModificar.setToolTipText("Modicar Cliente");
				btnModificar.setIcon(new ImageIcon(VistaPersona.class.getResource("/imagenes/iconos/iconos_32x32/group_edit.png")));
				btnModificar.setBounds(85, 17, 65, 41);
				panelBotones.add(btnModificar);
			}
			{
				btnEliminar = new JButton("");
				btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnEliminar.setToolTipText("Eliminar Cliente");
				btnEliminar.setRolloverIcon(new ImageIcon(VistaPersona.class.getResource("/imagenes/iconos/iconos_32x32/busy.png")));
				btnEliminar.setIcon(new ImageIcon(VistaPersona.class.getResource("/imagenes/iconos/iconos_32x32/group_delete.png")));
				btnEliminar.setBounds(160, 17, 65, 41);
				panelBotones.add(btnEliminar);
			}
			{
				btnVaciar = new JButton("");
				btnVaciar.setToolTipText("Vaciar Formulario");
				btnVaciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnVaciar.setRolloverIcon(new ImageIcon(VistaPersona.class.getResource("/imagenes/iconos/iconos_32x32/refresh.png")));
				btnVaciar.setIcon(new ImageIcon(VistaPersona.class.getResource("/imagenes/iconos/iconos_32x32/page_refresh.png")));
				btnVaciar.setBounds(231, 17, 65, 41);
				panelBotones.add(btnVaciar);
			}
			{
				btnReportePantalla = new JButton("");
				btnReportePantalla.setToolTipText("Reporte Clientes por pantalla");
				btnReportePantalla.setRolloverIcon(new ImageIcon(VistaPersona.class.getResource("/imagenes/iconos/iconos_32x32/application_view_detail.png")));
				btnReportePantalla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnReportePantalla.setIcon(new ImageIcon(VistaPersona.class.getResource("/imagenes/iconos/iconos_32x32/graphic-design.png")));
				btnReportePantalla.setBounds(306, 17, 65, 41);
				panelBotones.add(btnReportePantalla);
			}
		}
		
		JLabel lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCedula.setBounds(3, 11, 50, 24);
		contentPanel.add(lblCedula);
		
		textCedula = new JTextField();
		textCedula.setBounds(50, 11, 98, 25);
		contentPanel.add(textCedula);
		textCedula.setColumns(10);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombres.setBounds(183, 11, 68, 24);
		contentPanel.add(lblNombres);
		
		textNombres = new JTextField();
		textNombres.setEditable(false);
		textNombres.setBounds(243, 11, 151, 25);
		contentPanel.add(textNombres);
		textNombres.setColumns(30);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellidos.setBounds(429, 14, 68, 14);
		contentPanel.add(lblApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setEditable(false);
		textApellidos.setBounds(494, 11, 151, 25);
		contentPanel.add(textApellidos);
		textApellidos.setColumns(30);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDireccion.setBounds(10, 133, 68, 14);
		contentPanel.add(lblDireccion);
		
		JLabel lblTelfonoCelular = new JLabel("Tel\u00E9fono Celular:");
		lblTelfonoCelular.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelfonoCelular.setBounds(10, 62, 110, 14);
		contentPanel.add(lblTelfonoCelular);
		
		txtTelefono1 = new JTextField();
		txtTelefono1.setBounds(130, 60, 109, 20);
		
		MaskFormatter mascaraTelefono,mascaraCorreo;
		try {
			mascaraTelefono = new MaskFormatter("(####)-###-##-##");
			mascaraTelefono.setPlaceholderCharacter('_');
			textTelefono1= new JFormattedTextField(mascaraTelefono);
			textTelefono1.setEditable(false);
			textTelefono1.setBounds(118, 60, 109, 25);
			contentPanel.add(textTelefono1);
			textTelefono1.setColumns(10);
			
			lblTelfono2 = new JLabel("Otro Tel\u00E9fono:");
			lblTelfono2.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblTelfono2.setBounds(278, 63, 98, 14);
			contentPanel.add(lblTelfono2);
			
			textTelefono2 = new JTextField();
			textTelefono2= new JFormattedTextField(mascaraTelefono);
			textTelefono2.setEditable(false);
			textTelefono2.setBounds(371, 60, 109, 25);
			contentPanel.add(textTelefono2);
			textTelefono2.setColumns(10);
			
			lblCorreo = new JLabel("Correo:");
			lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblCorreo.setBounds(10, 104, 50, 14);
			contentPanel.add(lblCorreo);
			
			textCorreo = new JTextField();
			textCorreo.setEditable(false);
			textCorreo.setBounds(63, 102, 246, 25);
			contentPanel.add(textCorreo);
			textCorreo.setColumns(10);
			
			textDireccion = new JTextArea();
			textDireccion.setEditable(false);
			textDireccion.setCaretColor(Color.BLACK);
			textDireccion.setBorder(new LineBorder(Color.GRAY, 1, true));
			textDireccion.setBounds(73, 134, 573, 86);
			contentPanel.add(textDireccion);
			
			lblContarCedula = new JLabel("");
			lblContarCedula.setBorder(new LineBorder(Color.GRAY));
			lblContarCedula.setForeground(Color.RED);
			lblContarCedula.setBounds(149, 11, 27, 25);
			contentPanel.add(lblContarCedula);
			
			JPanel panelMensaje = new JPanel();
			panelMensaje.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mensaje del Sistema", TitledBorder.RIGHT, TitledBorder.TOP, null, Color.BLUE));
			panelMensaje.setBounds(63, 235, 611, 46);
			contentPanel.add(panelMensaje);
			panelMensaje.setLayout(null);
			
			lblMensaje = new JLabel("");
			lblMensaje.setForeground(Color.RED);
			lblMensaje.setBounds(10, 11, 591, 24);
			panelMensaje.add(lblMensaje);
			
			lblContarNombres = new JLabel("");
			lblContarNombres.setBorder(new LineBorder(Color.GRAY));
			lblContarNombres.setForeground(Color.RED);
			lblContarNombres.setBounds(395, 11, 27, 25);
			contentPanel.add(lblContarNombres);
			
			lblContrarApellidos = new JLabel("");
			lblContrarApellidos.setBorder(new LineBorder(Color.GRAY));
			lblContrarApellidos.setForeground(Color.RED);
			lblContrarApellidos.setBounds(647, 11, 27, 25);
			contentPanel.add(lblContrarApellidos);
			
			lblContarTelefono1 = new JLabel("");
			lblContarTelefono1.setForeground(Color.RED);
			lblContarTelefono1.setBounds(232, 63, 35, 14);
			contentPanel.add(lblContarTelefono1);
			
			lblContarDirec = new JLabel("");
			lblContarDirec.setBorder(new LineBorder(Color.GRAY));
			lblContarDirec.setForeground(Color.RED);
			lblContarDirec.setBounds(648, 200, 27, 20);
			contentPanel.add(lblContarDirec);
			
			JLabel lblPoseeCorreo = new JLabel("Posee Correo:");
			lblPoseeCorreo.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPoseeCorreo.setBounds(317, 105, 105, 14);
			contentPanel.add(lblPoseeCorreo);
			
			rdbtnSi = new JRadioButton("Si");
			rdbtnSi.setBounds(410, 101, 44, 23);
			contentPanel.add(rdbtnSi);
			rdbtnSi.setEnabled(false);
			
			rdbtnNo = new JRadioButton("No");
			rdbtnNo.setBounds(456, 101, 58, 23);
			
			rdbtnNo.setEnabled(false);
			contentPanel.add(rdbtnNo);
			ButtonGroup grupoSexo=new ButtonGroup();
			grupoSexo.add(rdbtnSi);
			grupoSexo.add(rdbtnNo);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//-------->enlaces<-------------
		ControladorVistaPersona eco=new ControladorVistaPersona(this);
		cancelButton.addActionListener(eco);
		btnRegistrar.addActionListener(eco);
		rdbtnNo.addActionListener(eco);
		rdbtnSi.addActionListener(eco);
		
		rdbtnSi.addMouseListener(eco);
		rdbtnNo.addMouseListener(eco);
		
		textCedula.addKeyListener(eco);
		textNombres.addKeyListener(eco);
		textApellidos.addKeyListener(eco);
		textTelefono1.addKeyListener(eco);
		textTelefono2.addKeyListener(eco);
		textCorreo.addKeyListener(eco);
		
		textCedula.addFocusListener(eco);
		textNombres.addFocusListener(eco);
		textApellidos.addFocusListener(eco);
		textTelefono1.addFocusListener(eco);
		textTelefono2.addFocusListener(eco);
		textCorreo.addFocusListener(eco);
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}//fin del constructor
//------------->getters<------------------

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

	public JTextField getTextCedula() {
		return textCedula;
	}

	public JTextField getTextNombres() {
		return textNombres;
	}

	public JTextField getTextApellidos() {
		return textApellidos;
	}

	public JTextField getTxtTelefono1() {
		return txtTelefono1;
	}

	public JTextField getTextTelefono1() {
		return textTelefono1;
	}

	public JLabel getLblTelfono2() {
		return lblTelfono2;
	}

	public JTextField getTextTelefono2() {
		return textTelefono2;
	}

	public JLabel getLblCorreo() {
		return lblCorreo;
	}

	public JTextField getTextCorreo() {
		return textCorreo;
	}

	public JTextArea getTextDireccion() {
		return textDireccion;
	}

	public JLabel getLblContarCedula() {
		return lblContarCedula;
	}

	public JLabel getLblMensaje() {
		return lblMensaje;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public JLabel getLblContarNombres() {
		return lblContarNombres;
	}

	public JLabel getLblContrarApellidos() {
		return lblContrarApellidos;
	}

	
	public JLabel getLblContarTelefono1() {
		return lblContarTelefono1;
	}

	public JRadioButton getRdbtnSi() {
		return rdbtnSi;
	}

	public JRadioButton getRdbtnNo() {
		return rdbtnNo;
	}
}//fin de la clase
