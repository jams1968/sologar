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
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;


public class VistaUsuario extends JDialog {
	private JTextField textCedula;
	private JTextField textNombres;
	private JTextField textApellidos;
	private JTextField textTelefono1;
	private JTextField textCorreo;
	private JTextArea textDireccion;
	private JPanel panelDU;
	private JTextField textLogin;

	private JPasswordField textClave;
	private JPasswordField textClave2;
	private JPanel panelMensaje;
	private JLabel lblMensaje;
	private JPanel panelBotones;
	private JButton cancelButton;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVaciar;
	private JButton btnReportePantalla;
	private JComboBox comboNivel;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaUsuario.class.getResource("/imagenes/iconos/ventilador.png")));
		setTitle("REGISTRO DE USUARIOS");
		
		setBounds(100, 100, 700, 422);
		getContentPane().setLayout(null);
		
		
		JPanel panelDP = new JPanel();
		panelDP.setBorder(new TitledBorder(null, "Datos Usuario", TitledBorder.RIGHT, TitledBorder.TOP, null, Color.BLUE));
		panelDP.setBounds(0, 0, 689, 202);
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
		
		JLabel labelNombres = new JLabel("Nombres:");
		labelNombres.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelNombres.setBounds(188, 24, 68, 24);
		panelDP.add(labelNombres);
		
		textNombres = new JTextField();
		textNombres.setEditable(false);
		textNombres.setColumns(30);
		textNombres.setBounds(248, 24, 151, 25);
		panelDP.add(textNombres);
		
		JLabel labelApellidos = new JLabel("Apellidos:");
		labelApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelApellidos.setBounds(434, 27, 68, 14);
		panelDP.add(labelApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setEditable(false);
		textApellidos.setColumns(30);
		textApellidos.setBounds(499, 24, 151, 25);
		panelDP.add(textApellidos);
		MaskFormatter mascaraTelefono,mascaraCorreo;
		try {
			mascaraTelefono = new MaskFormatter("(####)-###-##-##");
			mascaraTelefono.setPlaceholderCharacter('_');
			
			
			JLabel labelCelular = new JLabel("Tel\u00E9fono:");
			labelCelular.setFont(new Font("Tahoma", Font.BOLD, 12));
			labelCelular.setBounds(10, 62, 68, 14);
			panelDP.add(labelCelular);
			textTelefono1= new JFormattedTextField(mascaraTelefono);
			textTelefono1.setEditable(false);
			textTelefono1.setBounds(77, 58, 109, 25);
			panelDP.add(textTelefono1);
			textTelefono1.setColumns(10);
			
			JLabel labelCorreo = new JLabel("Correo:");
			labelCorreo.setFont(new Font("Tahoma", Font.BOLD, 12));
			labelCorreo.setBounds(198, 59, 50, 14);
			panelDP.add(labelCorreo);
			
			textCorreo = new JTextField();
			textCorreo.setEditable(false);
			textCorreo.setColumns(10);
			textCorreo.setBounds(258, 59, 289, 25);
			panelDP.add(textCorreo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel labelDireccion = new JLabel("Direcci\u00F3n:");
		labelDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelDireccion.setBounds(14, 106, 68, 14);
		panelDP.add(labelDireccion);
		
		textDireccion = new JTextArea();
		textDireccion.setEditable(false);
		textDireccion.setCaretColor(Color.BLACK);
		textDireccion.setBorder(new LineBorder(Color.GRAY, 1, true));
		textDireccion.setBounds(77, 107, 573, 86);
		panelDP.add(textDireccion);
		
		panelDU = new JPanel();
		panelDU.setBorder(new TitledBorder(null, "Datos de la Cuenta", TitledBorder.RIGHT, TitledBorder.TOP, null, Color.BLUE));
		panelDU.setBounds(0, 213, 689, 53);
		getContentPane().add(panelDU);
		panelDU.setLayout(null);
		
		JLabel labelLogin = new JLabel("Login:");
		labelLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelLogin.setBounds(181, 19, 43, 14);
		panelDU.add(labelLogin);
		
		textLogin = new JTextField();
		textLogin.setEditable(false);
		textLogin.setColumns(10);
		textLogin.setBounds(222, 17, 101, 26);
		panelDU.add(textLogin);
		
		JLabel labelClave = new JLabel("Clave:");
		labelClave.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelClave.setBounds(333, 19, 36, 14);
		panelDU.add(labelClave);
		
		textClave = new JPasswordField();
		textClave.setEditable(false);
		textClave.setColumns(10);
		textClave.setBounds(373, 17, 101, 26);
		panelDU.add(textClave);
		
		JLabel labelClave2 = new JLabel("Confirme Clave:");
		labelClave2.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelClave2.setBounds(475, 20, 101, 14);
		panelDU.add(labelClave2);
		
		textClave2 = new JPasswordField();
		textClave2.setEditable(false);
		textClave2.setColumns(10);
		textClave2.setBounds(578, 17, 101, 26);
		panelDU.add(textClave2);
		
		JLabel labelNivel = new JLabel("Nivel Usuario:");
		labelNivel.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelNivel.setBounds(6, 19, 81, 14);
		panelDU.add(labelNivel);
		
		comboNivel = new JComboBox();
		comboNivel.setModel(new DefaultComboBoxModel(new String[] {"Seleccione","Admin", "Asistente"}));
		comboNivel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboNivel.setBounds(89, 17, 91, 26);
		comboNivel.setEnabled(false);
		panelDU.add(comboNivel);
		
		panelMensaje = new JPanel();
		panelMensaje.setBorder(new TitledBorder(null, "Mensaje del Sistema", TitledBorder.RIGHT, TitledBorder.TOP, null, Color.BLUE));
		panelMensaje.setBounds(0, 273, 684, 46);
		getContentPane().add(panelMensaje);
		panelMensaje.setLayout(null);
		
		lblMensaje = new JLabel("");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setBounds(10, 11, 664, 24);
		panelMensaje.add(lblMensaje);
		lblMensaje.setForeground(Color.RED);
		
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
			cancelButton.setIcon(new ImageIcon(VistaUsuario.class.getResource("/imagenes/iconos/iconos_32x32/door.png")));
			cancelButton.setRolloverIcon(new ImageIcon(VistaUsuario.class.getResource("/imagenes/iconos/iconos_32x32/door_out.png")));
			cancelButton.setCursor(new Cursor(12));
			cancelButton.setActionCommand("Cancel");
		}
		
		btnRegistrar = new JButton("");
		btnRegistrar.setToolTipText("Registrar Usuario");
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.setRolloverIcon(new ImageIcon(VistaUsuario.class.getResource("/imagenes/iconos/iconos_32x32/plus.png")));
		btnRegistrar.setIcon(new ImageIcon(VistaUsuario.class.getResource("/imagenes/iconos/iconos_32x32/group_add.png")));
		btnRegistrar.setBounds(10, 17, 65, 41);
		panelBotones.add(btnRegistrar);
		btnRegistrar.setEnabled(false);
		{
			btnModificar = new JButton("");
			btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnModificar.setRolloverIcon(new ImageIcon(VistaUsuario.class.getResource("/imagenes/iconos/iconos_32x32/pencil2.png")));
			btnModificar.setToolTipText("Modicar Usuario");
			btnModificar.setIcon(new ImageIcon(VistaUsuario.class.getResource("/imagenes/iconos/iconos_32x32/group_edit.png")));
			btnModificar.setBounds(85, 17, 65, 41);
			panelBotones.add(btnModificar);
			btnModificar.setEnabled(false);
		}
		{
			btnEliminar = new JButton("");
			btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEliminar.setToolTipText("Eliminar Usuario");
			btnEliminar.setRolloverIcon(new ImageIcon(VistaUsuario.class.getResource("/imagenes/iconos/iconos_32x32/busy.png")));
			btnEliminar.setIcon(new ImageIcon(VistaUsuario.class.getResource("/imagenes/iconos/iconos_32x32/group_delete.png")));
			btnEliminar.setBounds(160, 17, 65, 41);
			panelBotones.add(btnEliminar);
			btnEliminar.setEnabled(false);
		}
		{
			btnVaciar = new JButton("");
			btnVaciar.setToolTipText("Vaciar Formulario");
			btnVaciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnVaciar.setRolloverIcon(new ImageIcon(VistaUsuario.class.getResource("/imagenes/iconos/iconos_32x32/refresh.png")));
			btnVaciar.setIcon(new ImageIcon(VistaUsuario.class.getResource("/imagenes/iconos/iconos_32x32/page_refresh.png")));
			btnVaciar.setBounds(231, 17, 65, 41);
			panelBotones.add(btnVaciar);
		}
		{
			btnReportePantalla = new JButton("");
			btnReportePantalla.setToolTipText("Reporte Usuario por pantalla");
			btnReportePantalla.setRolloverIcon(new ImageIcon(VistaUsuario.class.getResource("/imagenes/iconos/iconos_32x32/application_view_detail.png")));
			btnReportePantalla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnReportePantalla.setIcon(new ImageIcon(VistaUsuario.class.getResource("/imagenes/iconos/iconos_32x32/graphic-design.png")));
			btnReportePantalla.setBounds(306, 17, 65, 41);
			panelBotones.add(btnReportePantalla);
		}
		
		//----------->enlaces<--------------
		ControladorVistaUsuario eco=new ControladorVistaUsuario(this);
		cancelButton.addActionListener(eco);
		btnVaciar.addActionListener(eco);
		btnRegistrar.addActionListener(eco);
		
		textCedula.addKeyListener(eco);
		textNombres.addKeyListener(eco);
		textApellidos.addKeyListener(eco);
		textTelefono1.addKeyListener(eco);	
		textCorreo.addKeyListener(eco);
		textDireccion.addKeyListener(eco);
		textLogin.addKeyListener(eco);
		textClave.addKeyListener(eco);
		textClave2.addKeyListener(eco);
		
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
	
	}//fin del constructor

	public JTextField getTextCedula() {
		return textCedula;
	}

	

	public JTextField getTextNombres() {
		return textNombres;
	}

	public JTextField getTextApellidos() {
		return textApellidos;
	}

	

	public JTextField getTextTelefono1() {
		return textTelefono1;
	}

	public JTextField getTextCorreo() {
		return textCorreo;
	}

	

	public JTextArea getTextDireccion() {
		return textDireccion;
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

	

	

	public JPanel getPanelMensaje() {
		return panelMensaje;
	}

	public JLabel getLabelMensaje() {
		return lblMensaje;
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

	public JLabel getLblMensaje() {
		return lblMensaje;
	}

	public JComboBox getComboNivel() {
		return comboNivel;
	}
	
}//fin  de la clase
