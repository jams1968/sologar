/****************************************************************************
 * programa: VistaUsuario.java
 * objetivo: interface del modelo usuario
 ****************************************************************************/
package vistas; 


import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import controladoresVistas.ControladorVistaUsuario;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;


public class VistaUsuario extends JDialog {
	private JTextField textCedula;
	private JLabel labelContarCedula;
	private JTextField textNombres;
	private JTextField textApellidos;
	private JLabel labelContarNombres;
	private JTextField textTelefono2;
	private JTextField textTelefono1;
	private JTextField textCorreo;
	private JLabel labelContarDireccion;
	private JTextArea textDireccion;
	private JLabel labelContarApellidos;
	private JPanel panelDU;
	private JTextField textLogin;

	private JPasswordField textClave;
	private JPasswordField textClave2;
	private JLabel labelContarClave2;
	private JLabel labelContarClave;
	private JPanel panelMensaje;
	private JLabel labelMensaje;
	private JPanel panelBotones;
	private JButton cancelButton;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVaciar;
	private JButton btnReportePantalla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaUsuario dialog = new VistaUsuario();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public VistaUsuario() {
		JLabel labelContarLogin;
		
		
		setResizable(false);
		setTitle("REGISTRO DE USUARIOS");
		
		setBounds(100, 100, 700, 422);
		getContentPane().setLayout(null);
		
		
		
		
		JPanel panelDP = new JPanel();
		panelDP.setBorder(new TitledBorder(null, "Datos Usuario", TitledBorder.RIGHT, TitledBorder.TOP, null, Color.BLUE));
		panelDP.setBounds(0, 0, 689, 219);
		getContentPane().add(panelDP);
		panelDP.setLayout(null);
		
		JLabel labelCedula = new JLabel("C\u00E9dula:");
		labelCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelCedula.setBounds(10, 24, 50, 24);
		
		panelDP.add(labelCedula);
		
		textCedula = new JTextField();
		textCedula.setColumns(10);
		
		textCedula.setBounds(57, 24, 98, 25);
		panelDP.add(textCedula);
		
		
		labelContarCedula = new JLabel("");
		labelContarCedula.setForeground(Color.RED);
		labelContarCedula.setBorder(new LineBorder(Color.GRAY));
		labelContarCedula.setBounds(156, 24, 27, 25);
		panelDP.add(labelContarCedula);
		
		JLabel labelNombres = new JLabel("Nombres:");
		labelNombres.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelNombres.setBounds(188, 24, 68, 24);
		panelDP.add(labelNombres);
		
		textNombres = new JTextField();
		textNombres.setEditable(false);
		textNombres.setColumns(30);
		textNombres.setBounds(248, 24, 151, 25);
		panelDP.add(textNombres);
		
		labelContarNombres = new JLabel("");
		labelContarNombres.setForeground(Color.RED);
		labelContarNombres.setBorder(new LineBorder(Color.GRAY));
		labelContarNombres.setBounds(400, 24, 27, 25);
		panelDP.add(labelContarNombres);
		
		JLabel labelApellidos = new JLabel("Apellidos:");
		labelApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelApellidos.setBounds(434, 27, 68, 14);
		panelDP.add(labelApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setEditable(false);
		textApellidos.setColumns(30);
		textApellidos.setBounds(499, 24, 151, 25);
		panelDP.add(textApellidos);
		
		labelContarApellidos = new JLabel("");
		labelContarApellidos.setForeground(Color.RED);
		labelContarApellidos.setBorder(new LineBorder(Color.GRAY));
		labelContarApellidos.setBounds(652, 24, 27, 25);
		panelDP.add(labelContarApellidos);
		MaskFormatter mascaraTelefono,mascaraCorreo;
		try {
			mascaraTelefono = new MaskFormatter("(####)-###-##-##");
			mascaraTelefono.setPlaceholderCharacter('_');
			
			textTelefono2 = new JTextField();
			JLabel labelCelular = new JLabel("Tel\u00E9fono Celular:");
			labelCelular.setFont(new Font("Tahoma", Font.BOLD, 12));
			labelCelular.setBounds(10, 62, 110, 14);
			panelDP.add(labelCelular);
			textTelefono1= new JFormattedTextField(mascaraTelefono);
			textTelefono1.setEditable(false);
			textTelefono1.setBounds(118, 59, 109, 25);
			panelDP.add(textTelefono1);
			textTelefono1.setColumns(10);
			
			JLabel lblTelefono2 = new JLabel("Otro Tel\u00E9fono:");
			lblTelefono2.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblTelefono2.setBounds(278, 62, 98, 14);
			panelDP.add(lblTelefono2);
			textTelefono2= new JFormattedTextField(mascaraTelefono);
			textTelefono2.setEditable(false);
			textTelefono2.setBounds(371, 59, 109, 25);
			panelDP.add(textTelefono2);
			textTelefono2.setColumns(10);
			panelDP.add(textTelefono2);
			
			JLabel labelCorreo = new JLabel("Correo:");
			labelCorreo.setFont(new Font("Tahoma", Font.BOLD, 12));
			labelCorreo.setBounds(10, 89, 50, 14);
			panelDP.add(labelCorreo);
			
			textCorreo = new JTextField();
			textCorreo.setEditable(false);
			textCorreo.setColumns(10);
			textCorreo.setBounds(63, 87, 246, 25);
			panelDP.add(textCorreo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel labelDireccion = new JLabel("Direcci\u00F3n:");
		labelDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelDireccion.setBounds(10, 118, 68, 14);
		panelDP.add(labelDireccion);
		
		textDireccion = new JTextArea();
		textDireccion.setEditable(false);
		textDireccion.setCaretColor(Color.BLACK);
		textDireccion.setBorder(new LineBorder(Color.GRAY, 1, true));
		textDireccion.setBounds(73, 119, 573, 86);
		panelDP.add(textDireccion);
		
		labelContarDireccion = new JLabel("");
		labelContarDireccion.setForeground(Color.RED);
		labelContarDireccion.setBorder(new LineBorder(Color.GRAY));
		labelContarDireccion.setBounds(652, 181, 27, 20);
		panelDP.add(labelContarDireccion);
		
		panelDU = new JPanel();
		panelDU.setBorder(new TitledBorder(null, "Datos de la Cuenta", TitledBorder.RIGHT, TitledBorder.TOP, null, Color.BLUE));
		panelDU.setBounds(0, 222, 689, 53);
		getContentPane().add(panelDU);
		panelDU.setLayout(null);
		
		JLabel labelLogin = new JLabel("Login:");
		labelLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelLogin.setBounds(10, 19, 46, 14);
		panelDU.add(labelLogin);
		
		textLogin = new JTextField();
		textLogin.setEditable(false);
		textLogin.setColumns(10);
		textLogin.setBounds(52, 16, 117, 25);
		panelDU.add(textLogin);
		
		labelContarLogin = new JLabel("");
		labelContarLogin.setForeground(Color.RED);
		labelContarLogin.setBorder(new LineBorder(Color.GRAY));
		labelContarLogin.setBounds(172, 16, 27, 25);
		panelDU.add(labelContarLogin);
		
		JLabel labelClave = new JLabel("Clave:");
		labelClave.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelClave.setBounds(209, 19, 79, 14);
		panelDU.add(labelClave);
		
		textClave = new JPasswordField();
		textClave.setEditable(false);
		textClave.setColumns(10);
		textClave.setBounds(249, 16, 101, 26);
		panelDU.add(textClave);
		
		labelContarClave = new JLabel("");
		labelContarClave.setForeground(Color.RED);
		labelContarClave.setBorder(new LineBorder(Color.GRAY));
		labelContarClave.setBounds(353, 16, 27, 25);
		panelDU.add(labelContarClave);
		
		JLabel labelClave2 = new JLabel("Confirme Clave:");
		labelClave2.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelClave2.setBounds(387, 19, 101, 14);
		panelDU.add(labelClave2);
		
		textClave2 = new JPasswordField();
		textClave2.setEditable(false);
		textClave2.setColumns(10);
		textClave2.setBounds(488, 16, 101, 26);
		panelDU.add(textClave2);
		
		labelContarClave2 = new JLabel("");
		labelContarClave2.setForeground(Color.RED);
		labelContarClave2.setBorder(new LineBorder(Color.GRAY));
		labelContarClave2.setBounds(592, 16, 27, 25);
		panelDU.add(labelContarClave2);
		
		panelMensaje = new JPanel();
		panelMensaje.setBorder(new TitledBorder(null, "Mensaje del Sistema", TitledBorder.RIGHT, TitledBorder.TOP, null, Color.BLUE));
		panelMensaje.setBounds(0, 273, 684, 46);
		getContentPane().add(panelMensaje);
		panelMensaje.setLayout(null);
		
		labelMensaje = new JLabel("");
		labelMensaje.setForeground(Color.RED);
		labelMensaje.setBounds(10, 11, 664, 24);
		panelMensaje.add(labelMensaje);
		
		panelBotones = new JPanel();
		panelBotones.setBorder(new TitledBorder(null, "Botones", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLUE));
		panelBotones.setBounds(0, 317, 684, 65);
		getContentPane().add(panelBotones);
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
		btnRegistrar.setToolTipText("Registrar Usuario");
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.setRolloverIcon(new ImageIcon(VistaPersona.class.getResource("/imagenes/iconos/iconos_32x32/plus.png")));
		btnRegistrar.setIcon(new ImageIcon(VistaPersona.class.getResource("/imagenes/iconos/iconos_32x32/group_add.png")));
		btnRegistrar.setBounds(10, 17, 65, 41);
		panelBotones.add(btnRegistrar);
		{
			btnModificar = new JButton("");
			btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnModificar.setRolloverIcon(new ImageIcon(VistaPersona.class.getResource("/imagenes/iconos/iconos_32x32/pencil2.png")));
			btnModificar.setToolTipText("Modicar Usuario");
			btnModificar.setIcon(new ImageIcon(VistaPersona.class.getResource("/imagenes/iconos/iconos_32x32/group_edit.png")));
			btnModificar.setBounds(85, 17, 65, 41);
			panelBotones.add(btnModificar);
		}
		{
			btnEliminar = new JButton("");
			btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEliminar.setToolTipText("Eliminar Usuario");
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
			btnReportePantalla.setToolTipText("Reporte Usuario por pantalla");
			btnReportePantalla.setRolloverIcon(new ImageIcon(VistaPersona.class.getResource("/imagenes/iconos/iconos_32x32/application_view_detail.png")));
			btnReportePantalla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnReportePantalla.setIcon(new ImageIcon(VistaPersona.class.getResource("/imagenes/iconos/iconos_32x32/graphic-design.png")));
			btnReportePantalla.setBounds(306, 17, 65, 41);
			panelBotones.add(btnReportePantalla);
		}
		
		this.setLocationRelativeTo(null);
		
		//----------->enlaces<--------------
		ControladorVistaUsuario eco=new ControladorVistaUsuario(this);
		cancelButton.addActionListener(eco);
		btnVaciar.addActionListener(eco);
	
	}//fin del constructor

	public JTextField getTextCedula() {
		return textCedula;
	}

	public JLabel getLabelContarCedula() {
		return labelContarCedula;
	}

	public JTextField getTextNombres() {
		return textNombres;
	}

	public JTextField getTextApellidos() {
		return textApellidos;
	}

	public JLabel getLabelContarNombres() {
		return labelContarNombres;
	}

	public JTextField getTextTelefono2() {
		return textTelefono2;
	}

	public JTextField getTextTelefono1() {
		return textTelefono1;
	}

	public JTextField getTextCorreo() {
		return textCorreo;
	}

	public JLabel getLabelContarDireccion() {
		return labelContarDireccion;
	}

	public JTextArea getTextDireccion() {
		return textDireccion;
	}

	public JLabel getLabelContarApellidos() {
		return labelContarApellidos;
	}

	public JPanel getPanelDU() {
		return panelDU;
	}

	public JTextField getTextLogin() {
		return textLogin;
	}

	public JPasswordField getTextClave() {
		return textClave;
	}

	public JPasswordField getTextClave2() {
		return textClave2;
	}

	public JLabel getLabelContarClave2() {
		return labelContarClave2;
	}

	public JLabel getLabelContarClave() {
		return labelContarClave;
	}

	public JPanel getPanelMensaje() {
		return panelMensaje;
	}

	public JLabel getLabelMensaje() {
		return labelMensaje;
	}

	public JPanel getPanelBotones() {
		return panelBotones;
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
	
}//fin  de la clase
