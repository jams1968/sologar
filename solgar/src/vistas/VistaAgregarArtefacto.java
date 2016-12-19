package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Font;
import modelosComboBox.ComboTipoAparatos;
import java.awt.Insets;
import javax.swing.JTextArea;

public class VistaAgregarArtefacto extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VistaAgregarArtefacto dialog = new VistaAgregarArtefacto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VistaAgregarArtefacto() {
		setBounds(100, 100, 666, 419);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panelLinea1 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelLinea1.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			GridBagConstraints gbc_panelLinea1 = new GridBagConstraints();
			gbc_panelLinea1.insets = new Insets(0, 0, 5, 0);
			gbc_panelLinea1.fill = GridBagConstraints.BOTH;
			gbc_panelLinea1.gridx = 0;
			gbc_panelLinea1.gridy = 0;
			contentPanel.add(panelLinea1, gbc_panelLinea1);
			{
				JLabel lblTipoAparato = new JLabel("Tipo Aparato:");
				lblTipoAparato.setFont(new Font("Tahoma", Font.BOLD, 12));
				panelLinea1.add(lblTipoAparato);
			}
			{
				ComboTipoAparatos comboTipoAparatos = new ComboTipoAparatos();
				comboTipoAparatos.llenar();
				panelLinea1.add(comboTipoAparatos);
			}
		}
		{
			JPanel panelLinea2 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelLinea2.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			GridBagConstraints gbc_panelLinea2 = new GridBagConstraints();
			gbc_panelLinea2.insets = new Insets(0, 0, 5, 0);
			gbc_panelLinea2.fill = GridBagConstraints.BOTH;
			gbc_panelLinea2.gridx = 0;
			gbc_panelLinea2.gridy = 1;
			contentPanel.add(panelLinea2, gbc_panelLinea2);
			{
				JLabel lblInformacion = new JLabel("Informaci\u00F3n:");
				lblInformacion.setFont(new Font("Tahoma", Font.BOLD, 12));
				panelLinea2.add(lblInformacion);
			}
			{
				JTextArea textArea = new JTextArea(3,38);
				textArea.setWrapStyleWord(true);
				textArea.setLineWrap(true);
				panelLinea2.add(textArea);
			}
		}
		{
			JPanel panelLinea3 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelLinea3.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			GridBagConstraints gbc_panelLinea3 = new GridBagConstraints();
			gbc_panelLinea3.insets = new Insets(0, 0, 5, 0);
			gbc_panelLinea3.fill = GridBagConstraints.BOTH;
			gbc_panelLinea3.gridx = 0;
			gbc_panelLinea3.gridy = 2;
			contentPanel.add(panelLinea3, gbc_panelLinea3);
			{
				JLabel lblDetalles = new JLabel("Detalles:");
				lblDetalles.setFont(new Font("Tahoma", Font.BOLD, 12));
				panelLinea3.add(lblDetalles);
			}
			{
				JTextArea textArea = new JTextArea();
				textArea.setRows(3);
				textArea.setColumns(41);
				panelLinea3.add(textArea);
			}
		}
		{
			JPanel panelLinea4 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelLinea4.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			GridBagConstraints gbc_panelLinea4 = new GridBagConstraints();
			gbc_panelLinea4.insets = new Insets(0, 0, 5, 0);
			gbc_panelLinea4.fill = GridBagConstraints.BOTH;
			gbc_panelLinea4.gridx = 0;
			gbc_panelLinea4.gridy = 3;
			contentPanel.add(panelLinea4, gbc_panelLinea4);
			{
				JLabel lblDiagnstico = new JLabel("Diagn\u00F3stico:");
				lblDiagnstico.setFont(new Font("Tahoma", Font.BOLD, 12));
				panelLinea4.add(lblDiagnstico);
			}
			{
				JTextArea textArea = new JTextArea();
				textArea.setColumns(47);
				textArea.setRows(3);
				panelLinea4.add(textArea);
			}
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 4;
			contentPanel.add(panel, gbc_panel);
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
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
	}

}//fin de la clase
