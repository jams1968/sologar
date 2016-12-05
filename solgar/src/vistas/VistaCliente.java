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

import controladoresVistas.ControladorVistaCliente;
import controladoresVistas.ControladorVistaUsuario;
import modelos.Usuario;

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



public class VistaCliente extends JDialog {
	private JTextField textCedula;
	private JTextField textCliente;
	private JTextField textTelefono1;
	private JTextField textCorreo;
	private JTextArea textDireccion;
	private JPanel panelMensaje;
	private JLabel lblMensaje;
	private JPanel panelBotones;
	private JButton cancelButton;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVaciar;
	private JButton btnReportePantalla;
	private Usuario registroUsuario;
	private JFormattedTextField textTelefono2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario registroUsuario=new Usuario();
					registroUsuario.setCedula("6331034");
					
					VistaCliente dialog = new VistaCliente(registroUsuario);
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
	public VistaCliente(Usuario registroUsuario) {
		this.registroUsuario=registroUsuario;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaCliente.class.getResource("/imagenes/iconos/ventilador.png")));
		setTitle("REGISTRO DE CLIENTES");
		
		setBounds(100, 100, 700, 422);
		getContentPane().setLayout(null);
		
		
		JPanel panelDP = new JPanel();
		panelDP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Cliente", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panelDP.setBounds(0, 0, 689, 253);
		getContentPane().add(panelDP);
		panelDP.setLayout(null);
		
		JLabel labelCedula = new JLabel("C\u00E9dula o Rif:");
		labelCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelCedula.setBounds(10, 24, 84, 24);
		
		panelDP.add(labelCedula);
		
		textCedula = new JTextField();
		textCedula.setColumns(10);
		
		textCedula.setBounds(104, 25, 98, 25);
		panelDP.add(textCedula);
		
		JLabel labelNombres = new JLabel("Cliente:");
		labelNombres.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelNombres.setBounds(212, 24, 123, 24);
		panelDP.add(labelNombres);
		
		textCliente = new JTextField();
		textCliente.setEditable(false);
		textCliente.setColumns(30);
		textCliente.setBounds(267, 23, 360, 25);
		panelDP.add(textCliente);
		MaskFormatter mascaraTelefono,mascaraCorreo;
		try {
			mascaraTelefono = new MaskFormatter("(####)-###-##-##");
			mascaraTelefono.setPlaceholderCharacter('_');
			
			
			JLabel labelCelular = new JLabel("Celular:");
			labelCelular.setFont(new Font("Tahoma", Font.BOLD, 12));
			labelCelular.setBounds(10, 62, 68, 14);
			panelDP.add(labelCelular);
			textTelefono1= new JFormattedTextField(mascaraTelefono);
			textTelefono1.setEditable(false);
			textTelefono1.setBounds(77, 58, 109, 25);
			panelDP.add(textTelefono1);
			textTelefono1.setColumns(10);
			
			textTelefono2 = new JFormattedTextField(mascaraTelefono);
			textTelefono2.setEditable(false);
			textTelefono2.setColumns(10);
			textTelefono2.setBounds(307, 59, 109, 25);
			
			JLabel labelCorreo = new JLabel("Correo:");
			labelCorreo.setFont(new Font("Tahoma", Font.BOLD, 12));
			labelCorreo.setBounds(21, 107, 50, 14);
			panelDP.add(labelCorreo);
			
			textCorreo = new JTextField();
			textCorreo.setEditable(false);
			textCorreo.setColumns(10);
			textCorreo.setBounds(81, 107, 289, 25);
			panelDP.add(textCorreo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel labelDireccion = new JLabel("Direcci\u00F3n:");
		labelDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelDireccion.setBounds(10, 155, 68, 14);
		panelDP.add(labelDireccion);
		
		textDireccion = new JTextArea();
		textDireccion.setEditable(false);
		textDireccion.setCaretColor(Color.BLACK);
		textDireccion.setBorder(new LineBorder(Color.GRAY, 1, true));
		textDireccion.setBounds(73, 156, 573, 86);
		panelDP.add(textDireccion);
		
		JLabel lblOtroTelfono = new JLabel("otro Tel\u00E9fono:");
		lblOtroTelfono.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOtroTelfono.setBounds(206, 62, 98, 14);
		panelDP.add(lblOtroTelfono);
		
		
		panelDP.add(textTelefono2);
		
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
			cancelButton.setIcon(new ImageIcon(VistaCliente.class.getResource("/imagenes/iconos/iconos_32x32/door.png")));
			cancelButton.setRolloverIcon(new ImageIcon(VistaCliente.class.getResource("/imagenes/iconos/iconos_32x32/door_out.png")));
			cancelButton.setCursor(new Cursor(12));
			cancelButton.setActionCommand("Cancel");
		}
		
		btnRegistrar = new JButton("");
		btnRegistrar.setToolTipText("Registrar Cliente");
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.setRolloverIcon(new ImageIcon(VistaCliente.class.getResource("/imagenes/iconos/iconos_32x32/plus.png")));
		btnRegistrar.setIcon(new ImageIcon(VistaCliente.class.getResource("/imagenes/iconos/iconos_32x32/group_add.png")));
		btnRegistrar.setBounds(10, 17, 65, 41);
		panelBotones.add(btnRegistrar);
		btnRegistrar.setEnabled(false);
		{
			btnModificar = new JButton("");
			btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnModificar.setRolloverIcon(new ImageIcon(VistaCliente.class.getResource("/imagenes/iconos/iconos_32x32/pencil2.png")));
			btnModificar.setToolTipText("Modicar Cliente");
			btnModificar.setIcon(new ImageIcon(VistaCliente.class.getResource("/imagenes/iconos/iconos_32x32/group_edit.png")));
			btnModificar.setBounds(85, 17, 65, 41);
			panelBotones.add(btnModificar);
			btnModificar.setEnabled(false);
		}
		{
			btnEliminar = new JButton("");
			btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEliminar.setToolTipText("Eliminar Cliente");
			btnEliminar.setRolloverIcon(new ImageIcon(VistaCliente.class.getResource("/imagenes/iconos/iconos_32x32/busy.png")));
			btnEliminar.setIcon(new ImageIcon(VistaCliente.class.getResource("/imagenes/iconos/iconos_32x32/group_delete.png")));
			btnEliminar.setBounds(160, 17, 65, 41);
			panelBotones.add(btnEliminar);
			btnEliminar.setEnabled(false);
		}
		{
			btnVaciar = new JButton("");
			btnVaciar.setToolTipText("Vaciar Formulario");
			btnVaciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnVaciar.setRolloverIcon(new ImageIcon(VistaCliente.class.getResource("/imagenes/iconos/iconos_32x32/refresh.png")));
			btnVaciar.setIcon(new ImageIcon(VistaCliente.class.getResource("/imagenes/iconos/iconos_32x32/page_refresh.png")));
			btnVaciar.setBounds(231, 17, 65, 41);
			panelBotones.add(btnVaciar);
		}
		{
			btnReportePantalla = new JButton("");
			btnReportePantalla.setToolTipText("Reporte Clientes por pantalla");
			btnReportePantalla.setRolloverIcon(new ImageIcon(VistaCliente.class.getResource("/imagenes/iconos/iconos_32x32/application_view_detail.png")));
			btnReportePantalla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnReportePantalla.setIcon(new ImageIcon(VistaCliente.class.getResource("/imagenes/iconos/iconos_32x32/graphic-design.png")));
			btnReportePantalla.setBounds(306, 17, 65, 41);
			panelBotones.add(btnReportePantalla);
		}
		
		//----------->enlaces<--------------
		ControladorVistaCliente eco=new ControladorVistaCliente(this);
		cancelButton.addActionListener(eco);
		btnVaciar.addActionListener(eco);
		btnRegistrar.addActionListener(eco);
		btnModificar.addActionListener(eco);
		btnEliminar.addActionListener(eco);
		btnReportePantalla.addActionListener(eco);
		
		textCedula.addKeyListener(eco);
		textCliente.addKeyListener(eco);
		textTelefono1.addKeyListener(eco);
		textTelefono2.addKeyListener(eco);	
		textCorreo.addKeyListener(eco);
		textDireccion.addKeyListener(eco);

		btnRegistrar.setEnabled(false);
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(false);
		
		
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
	
	}//fin del constructor

	public JTextField getTextCedula() {
		return textCedula;
	}

	
	

	public JTextField getTextCliente() {
		return textCliente;
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

	
	public JFormattedTextField getTextTelefono2() {
		return textTelefono2;
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
	public Usuario getRegistroUsuario() {
		return registroUsuario;
	}
}//fin  de la clase
