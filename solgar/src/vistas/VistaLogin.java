package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.TitledBorder;

import controladoresVistas.ControladorVistaLogin;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class VistaLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblSamasforoR;
	private JTextField textUsuario;
	private JPasswordField textClave;
	private JButton btnOk,btnCancel;
	private JLabel lblMensaje;
	private JPanel panelTotal;

	public VistaLogin() {
		setBounds(100, 100, 277, 156);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panelTotal = new JPanel();
			contentPanel.add(panelTotal, BorderLayout.NORTH);
			panelTotal.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
			panelTotal.setLayout(new BorderLayout(0, 0));
			{
				JPanel panelCampos = new JPanel();
				panelTotal.add(panelCampos, BorderLayout.NORTH);
				panelCampos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2, true), "Acceso al Sistema", TitledBorder.RIGHT, TitledBorder.TOP, null, Color.BLUE));
				GridBagLayout gbl_panelCampos = new GridBagLayout();
				gbl_panelCampos.columnWidths = new int[]{0, 0, 0, 0};
				gbl_panelCampos.rowHeights = new int[]{0, 0, 0, 0};
				gbl_panelCampos.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
				gbl_panelCampos.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
				panelCampos.setLayout(gbl_panelCampos);
				{
					lblSamasforoR = new JLabel("");
					lblSamasforoR.setIcon(new ImageIcon(VistaLogin.class.getResource("/imagenes/iconos/full.png")));
					GridBagConstraints gbc_lblSamasforoR = new GridBagConstraints();
					gbc_lblSamasforoR.gridheight = 2;
					gbc_lblSamasforoR.insets = new Insets(0, 0, 5, 5);
					gbc_lblSamasforoR.gridx = 0;
					gbc_lblSamasforoR.gridy = 0;
					panelCampos.add(lblSamasforoR, gbc_lblSamasforoR);
				}
				{
					JLabel lblUsuario = new JLabel("Usuario:");
					lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
					GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
					gbc_lblUsuario.anchor = GridBagConstraints.EAST;
					gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
					gbc_lblUsuario.gridx = 1;
					gbc_lblUsuario.gridy = 0;
					panelCampos.add(lblUsuario, gbc_lblUsuario);
				}
				{
					textUsuario = new JTextField();
					GridBagConstraints gbc_textUsuario = new GridBagConstraints();
					gbc_textUsuario.fill = GridBagConstraints.HORIZONTAL;
					gbc_textUsuario.insets = new Insets(0, 0, 5, 0);
					gbc_textUsuario.gridx = 2;
					gbc_textUsuario.gridy = 0;
					panelCampos.add(textUsuario, gbc_textUsuario);
					textUsuario.setColumns(10);
				}
				{
					JLabel lblClave = new JLabel("Clave:");
					lblClave.setHorizontalAlignment(SwingConstants.LEFT);
					lblClave.setFont(new Font("Tahoma", Font.BOLD, 12));
					GridBagConstraints gbc_lblClave = new GridBagConstraints();
					gbc_lblClave.anchor = GridBagConstraints.WEST;
					gbc_lblClave.insets = new Insets(0, 0, 5, 5);
					gbc_lblClave.gridx = 1;
					gbc_lblClave.gridy = 1;
					panelCampos.add(lblClave, gbc_lblClave);
				}
				{
					textClave = new JPasswordField();
					textClave.setEchoChar('*');
					textClave.setColumns(10);
					GridBagConstraints gbc_textClave = new GridBagConstraints();
					gbc_textClave.insets = new Insets(0, 0, 5, 0);
					gbc_textClave.fill = GridBagConstraints.HORIZONTAL;
					gbc_textClave.gridx = 2;
					gbc_textClave.gridy = 1;
					panelCampos.add(textClave, gbc_textClave);
				}
				{
					lblMensaje = new JLabel("");
					lblMensaje.setForeground(Color.RED);
					lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 12));
					GridBagConstraints gbc_lblMensaje = new GridBagConstraints();
					gbc_lblMensaje.gridwidth = 3;
					gbc_lblMensaje.insets = new Insets(0, 0, 0, 5);
					gbc_lblMensaje.gridx = 0;
					gbc_lblMensaje.gridy = 2;
					panelCampos.add(lblMensaje, gbc_lblMensaje);
				}
			}
			{
				JPanel buttonPane = new JPanel();
				panelTotal.add(buttonPane, BorderLayout.SOUTH);
				buttonPane.setBackground(Color.GRAY);
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				{
					btnOk = new JButton("OK");
					btnOk.setActionCommand("OK");
					buttonPane.add(btnOk);
					getRootPane().setDefaultButton(btnOk);
				}
				{
					btnCancel = new JButton("Cancel");
					btnCancel.setActionCommand("Cancel");
					buttonPane.add(btnCancel);
				}
			}
			
		}
		//--------->enlaces<-------------
		ControladorVistaLogin eco=new ControladorVistaLogin(this);
		btnOk.addActionListener(eco);
		btnCancel.addActionListener(eco);
		textUsuario.addFocusListener(eco);
		textClave.addFocusListener(eco);
		textUsuario.addKeyListener(eco);
		
		textClave.addKeyListener(eco);
		
		textUsuario.requestFocus();
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//this.pack();
		btnOk.setEnabled(false);
		textClave.setEditable(false);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setVisible(true);
		
	}//fin cosntructor
	
	public JLabel getLblSamasforoR() {
		return lblSamasforoR;
	}

	public JTextField getTextUsuario() {
		return textUsuario;
	}

	public JPasswordField getTextClave() {
		return textClave;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JLabel getLblMensaje() {
		return lblMensaje;
	}

	public static void main(String[] args) {
	/*	try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}*/
		new VistaLogin();
	}

}//fin d ela clase

