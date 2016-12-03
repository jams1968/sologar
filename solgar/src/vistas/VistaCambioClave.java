package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;

import controladoresVistas.ControladorVistaCambioClave;
import modelos.Usuario;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class VistaCambioClave extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton cancelButton;
	private JPasswordField textClaveActual;
	private JPasswordField txtNuevaClave;
	private JPasswordField txtConfirmar;
	private JLabel lblMensaje;
	private Usuario registroUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
	}

	/**
	 * Create the dialog.
	 */
	public VistaCambioClave(Usuario registroUsuario) {
		this.registroUsuario=registroUsuario;
		setTitle("Cambio de Clave");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaCambioClave.class.getResource("/imagenes/iconos/ventilador.png")));
		setBounds(100, 100, 329, 279);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblClaveActual = new JLabel("Clave Actual:");
		lblClaveActual.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClaveActual.setBounds(33, 13, 89, 14);
		contentPanel.add(lblClaveActual);
		
		textClaveActual = new JPasswordField();
		textClaveActual.setColumns(10);
		textClaveActual.setBounds(116, 11, 111, 26);
		contentPanel.add(textClaveActual);
		
		JLabel lblNuevaClave = new JLabel("Nueva Clave:");
		lblNuevaClave.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNuevaClave.setBounds(33, 63, 89, 14);
		contentPanel.add(lblNuevaClave);
		
		txtNuevaClave = new JPasswordField();
		txtNuevaClave.setEditable(false);
		txtNuevaClave.setColumns(10);
		txtNuevaClave.setBounds(116, 58, 111, 26);
		contentPanel.add(txtNuevaClave);
		
		JLabel lblConfirmar = new JLabel("Confirmar Clave:");
		lblConfirmar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConfirmar.setBounds(10, 97, 111, 14);
		contentPanel.add(lblConfirmar);
		
		txtConfirmar = new JPasswordField();
		txtConfirmar.setEditable(false);
		txtConfirmar.setColumns(10);
		txtConfirmar.setBounds(116, 93, 111, 26);
		contentPanel.add(txtConfirmar);
		
		JPanel panelMensaje = new JPanel();
		panelMensaje.setLayout(null);
		panelMensaje.setBorder(new TitledBorder(null, "Mensaje del Sistema", TitledBorder.RIGHT, TitledBorder.TOP, null, Color.BLUE));
		panelMensaje.setBounds(10, 132, 293, 46);
		contentPanel.add(panelMensaje);
		
		lblMensaje = new JLabel("");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setForeground(Color.RED);
		lblMensaje.setBounds(10, 11, 273, 24);
		panelMensaje.add(lblMensaje);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				cancelButton = new JButton("");
				cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				cancelButton.setRolloverIcon(new ImageIcon(VistaCambioClave.class.getResource("/imagenes/iconos/iconos_32x32/door_out.png")));
				cancelButton.setToolTipText("Cerrar Ventana actual");
				cancelButton.setIcon(new ImageIcon(VistaCambioClave.class.getResource("/imagenes/iconos/iconos_32x32/door.png")));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		//-------->enlaces <----------------
		ControladorVistaCambioClave eco=new ControladorVistaCambioClave(this);
		cancelButton.addActionListener(eco);
		textClaveActual.addKeyListener(eco);
		txtNuevaClave.addKeyListener(eco);
		txtConfirmar.addKeyListener(eco);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		JOptionPane.showMessageDialog(this,"Al cambiar la clave el sistema\n "
				+ "se cerrara y debe reinciar con la nueva clave", "Mensaje del Sistema",1 );
	}//fin del constructor

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JPasswordField getTextClaveActual() {
		return textClaveActual;
	}

	public JPasswordField getTxtNuevaClave() {
		return txtNuevaClave;
	}

	public JPasswordField getTxtConfirmar() {
		return txtConfirmar;
	}

	public JLabel getLblMensaje() {
		return lblMensaje;
	}

	public Usuario getRegistroUsuario() {
		return registroUsuario;
	}
	
}//fin de la clase
