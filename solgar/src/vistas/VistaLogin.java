package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class VistaLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;

	public VistaLogin() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelCampos = new JPanel();
			contentPanel.add(panelCampos);
			panelCampos.setLayout(new GridLayout(2, 1, 0, 0));
			{
				JPanel panelLogin = new JPanel();
				FlowLayout fl_panelLogin = (FlowLayout) panelLogin.getLayout();
				fl_panelLogin.setAlignment(FlowLayout.LEFT);
				panelCampos.add(panelLogin);
				{
					JLabel lblUsuario = new JLabel("Usuario:");
					panelLogin.add(lblUsuario);
				}
				{
					textField = new JTextField();
					panelLogin.add(textField);
					textField.setColumns(10);
				}
			}
			{
				JPanel panelClave = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panelClave.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				panelCampos.add(panelClave);
				{
					JLabel lblNewLabel = new JLabel("CLave:   ");
					panelClave.add(lblNewLabel);
				}
				{
					passwordField = new JPasswordField();
					passwordField.setColumns(10);
					panelClave.add(passwordField);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}//fin cosntructor
	
	public static void main(String[] args) {
		new VistaLogin();
	}

}//fin d ela clase
