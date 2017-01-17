package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import controladoresVistas.ControladorVistaReparacion;

import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import modelosComboBox.ComboTipoAparatos;
import modelosComboBox.ComboArtefactosRecibo;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import modelosComboBox.ComboRepuestos;

public class VistaReparacion extends JFrame {
	private JTextField textNrecibo;
	private JTextField textFechaRecepcion;
	private JTextField textFechaEntrega;
	private JTextField textCedula;
	private JTextField textCliente;
	private JTextField textTelefono1;
	private JTextField textTelefono2;
	private JTextField textDireccion;
	private JTextField textCorrero;
	private JTextField textTecnico;
	private ComboArtefactosRecibo comboArtefactosRecibo;
	private JTextField textInformacion;
	private JTextField textDiagnostico;
	private JTextField textDetalles;
	private JButton btnReparacion;
	private JComboBox comboStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VistaReparacion dialog = new VistaReparacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VistaReparacion() {
		setTitle("REPARACI\u00D3N DE ARTEFACTOS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaReparacion.class.getResource("/imagenes/iconos/iconos_32x32/ventilador2.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panelCabecera = new JPanel();
			FlowLayout fl_panelCabecera = (FlowLayout) panelCabecera.getLayout();
			fl_panelCabecera.setAlignment(FlowLayout.LEFT);
			getContentPane().add(panelCabecera, BorderLayout.NORTH);
			{
				JLabel labelNRecibo = new JLabel("Recibo Nro.:");
				labelNRecibo.setHorizontalAlignment(SwingConstants.LEFT);
				labelNRecibo.setFont(new Font("Tahoma", Font.BOLD, 14));
				panelCabecera.add(labelNRecibo);
			}
			{
				textNrecibo = new JTextField();
				textNrecibo.setFont(new Font("Tahoma", Font.BOLD, 14));
				textNrecibo.setColumns(6);
				panelCabecera.add(textNrecibo);
			}
			{
				JLabel labelFechaRecepcion = new JLabel("Fecha Recepci\u00F3n:");
				labelFechaRecepcion.setFont(new Font("Tahoma", Font.BOLD, 14));
				panelCabecera.add(labelFechaRecepcion);
			}
			{
				textFechaRecepcion = new JTextField();
				textFechaRecepcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
				textFechaRecepcion.setEditable(false);
				textFechaRecepcion.setColumns(10);
				panelCabecera.add(textFechaRecepcion);
			}
			{
				JLabel labelFechaEntrega = new JLabel("Fecha de Entrega:");
				labelFechaEntrega.setFont(new Font("Tahoma", Font.BOLD, 14));
				panelCabecera.add(labelFechaEntrega);
			}
			{
				textFechaEntrega = new JTextField();
				textFechaEntrega.setEditable(false);
				panelCabecera.add(textFechaEntrega);
				textFechaEntrega.setColumns(10);
			}
		}
		{
			JPanel panelRecepcion = new JPanel();
			getContentPane().add(panelRecepcion, BorderLayout.CENTER);
			GridBagLayout gbl_panelRecepcion = new GridBagLayout();
			gbl_panelRecepcion.columnWidths = new int[]{1596, 0};
			gbl_panelRecepcion.rowHeights = new int[]{117, 596, 30, 0};
			gbl_panelRecepcion.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_panelRecepcion.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			panelRecepcion.setLayout(gbl_panelRecepcion);
			{
				JPanel panelCliente = new JPanel();
				panelCliente.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2, true), "Datos de la Recepci\u00F3n", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 0, 255)));
				GridBagConstraints gbc_panelCliente = new GridBagConstraints();
				gbc_panelCliente.anchor = GridBagConstraints.NORTH;
				gbc_panelCliente.fill = GridBagConstraints.HORIZONTAL;
				gbc_panelCliente.insets = new Insets(0, 0, 5, 0);
				gbc_panelCliente.gridx = 0;
				gbc_panelCliente.gridy = 0;
				panelRecepcion.add(panelCliente, gbc_panelCliente);
				GridBagLayout gbl_panelCliente = new GridBagLayout();
				gbl_panelCliente.columnWidths = new int[]{0, 0, 0};
				gbl_panelCliente.rowHeights = new int[]{0, 0, 0, 0, 0};
				gbl_panelCliente.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
				gbl_panelCliente.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
				panelCliente.setLayout(gbl_panelCliente);
				{
					JPanel panel_liena1 = new JPanel();
					FlowLayout fl_panel_liena1 = (FlowLayout) panel_liena1.getLayout();
					fl_panel_liena1.setAlignment(FlowLayout.LEFT);
					GridBagConstraints gbc_panel_liena1 = new GridBagConstraints();
					gbc_panel_liena1.fill = GridBagConstraints.BOTH;
					gbc_panel_liena1.gridwidth = 2;
					gbc_panel_liena1.insets = new Insets(0, 0, 5, 0);
					gbc_panel_liena1.gridx = 0;
					gbc_panel_liena1.gridy = 0;
					panelCliente.add(panel_liena1, gbc_panel_liena1);
					{
						JLabel labelCedula = new JLabel("Cedula o Rif:");
						labelCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
						panel_liena1.add(labelCedula);
					}
					{
						textCedula = new JTextField();
						textCedula.setEditable(false);
						textCedula.setColumns(12);
						panel_liena1.add(textCedula);
					}
					{
						JLabel labelCliente = new JLabel("Cliente:");
						labelCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
						panel_liena1.add(labelCliente);
					}
					{
						textCliente = new JTextField();
						textCliente.setEditable(false);
						textCliente.setColumns(37);
						panel_liena1.add(textCliente);
					}
					{
						JLabel labelTelefono = new JLabel("Tel\u00E9fono Celular:");
						labelTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
						panel_liena1.add(labelTelefono);
					}
					{
						textTelefono1 = new JTextField();
						textTelefono1.setEditable(false);
						textTelefono1.setColumns(16);
						panel_liena1.add(textTelefono1);
					}
					{
						JLabel labelTelefono2 = new JLabel("Otro Tel\u00E9fono:");
						labelTelefono2.setFont(new Font("Tahoma", Font.BOLD, 12));
						panel_liena1.add(labelTelefono2);
					}
					{
						textTelefono2 = new JTextField();
						textTelefono2.setEditable(false);
						textTelefono2.setColumns(16);
						panel_liena1.add(textTelefono2);
					}
				}
				{
					JPanel panel_linea2 = new JPanel();
					GridBagConstraints gbc_panel_linea2 = new GridBagConstraints();
					gbc_panel_linea2.fill = GridBagConstraints.BOTH;
					gbc_panel_linea2.gridwidth = 2;
					gbc_panel_linea2.insets = new Insets(0, 0, 5, 0);
					gbc_panel_linea2.gridx = 0;
					gbc_panel_linea2.gridy = 1;
					panelCliente.add(panel_linea2, gbc_panel_linea2);
				}
				{
					JPanel panel_linea3 = new JPanel();
					FlowLayout fl_panel_linea3 = (FlowLayout) panel_linea3.getLayout();
					fl_panel_linea3.setAlignment(FlowLayout.LEFT);
					GridBagConstraints gbc_panel_linea3 = new GridBagConstraints();
					gbc_panel_linea3.fill = GridBagConstraints.BOTH;
					gbc_panel_linea3.gridwidth = 2;
					gbc_panel_linea3.insets = new Insets(0, 0, 5, 0);
					gbc_panel_linea3.gridx = 0;
					gbc_panel_linea3.gridy = 2;
					panelCliente.add(panel_linea3, gbc_panel_linea3);
					{
						JLabel labelDireccion = new JLabel("Direcci\u00F3n:");
						labelDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
						panel_linea3.add(labelDireccion);
					}
					{
						textDireccion = new JTextField();
						textDireccion.setEditable(false);
						textDireccion.setColumns(60);
						panel_linea3.add(textDireccion);
					}
					{
						JLabel labelCorreo = new JLabel("Correo:");
						labelCorreo.setFont(new Font("Tahoma", Font.BOLD, 12));
						panel_linea3.add(labelCorreo);
					}
					{
						textCorrero = new JTextField();
						textCorrero.setEditable(false);
						textCorrero.setColumns(20);
						panel_linea3.add(textCorrero);
					}
					{
						JLabel labelTecnico = new JLabel("T\u00E9cnico:");
						labelTecnico.setFont(new Font("Tahoma", Font.BOLD, 12));
						panel_linea3.add(labelTecnico);
					}
					{
						textTecnico = new JTextField();
						textTecnico.setEditable(false);
						panel_linea3.add(textTecnico);
						textTecnico.setColumns(20);
					}
				}
				{
					JPanel panel_linea4 = new JPanel();
					GridBagConstraints gbc_panel_linea4 = new GridBagConstraints();
					gbc_panel_linea4.fill = GridBagConstraints.BOTH;
					gbc_panel_linea4.gridwidth = 2;
					gbc_panel_linea4.gridx = 0;
					gbc_panel_linea4.gridy = 3;
					panelCliente.add(panel_linea4, gbc_panel_linea4);
				}
			}
			{
				JPanel panelArtefactos = new JPanel();
				panelArtefactos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2, true), "Agregar Artefactos", TitledBorder.RIGHT, TitledBorder.TOP, null, Color.BLUE));
				GridBagConstraints gbc_panelArtefactos = new GridBagConstraints();
				gbc_panelArtefactos.anchor = GridBagConstraints.WEST;
				gbc_panelArtefactos.fill = GridBagConstraints.VERTICAL;
				gbc_panelArtefactos.insets = new Insets(0, 0, 5, 0);
				gbc_panelArtefactos.gridx = 0;
				gbc_panelArtefactos.gridy = 1;
				panelRecepcion.add(panelArtefactos, gbc_panelArtefactos);
				GridBagLayout gbl_panelArtefactos = new GridBagLayout();
				gbl_panelArtefactos.columnWidths = new int[]{1584, 0};
				gbl_panelArtefactos.rowHeights = new int[]{30, 544, 0};
				gbl_panelArtefactos.columnWeights = new double[]{0.0, Double.MIN_VALUE};
				gbl_panelArtefactos.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
				panelArtefactos.setLayout(gbl_panelArtefactos);
				{
					JPanel panelLinea1 = new JPanel();
					FlowLayout fl_panelLinea1 = (FlowLayout) panelLinea1.getLayout();
					fl_panelLinea1.setAlignment(FlowLayout.LEFT);
					GridBagConstraints gbc_panelLinea1 = new GridBagConstraints();
					gbc_panelLinea1.anchor = GridBagConstraints.NORTH;
					gbc_panelLinea1.fill = GridBagConstraints.HORIZONTAL;
					gbc_panelLinea1.insets = new Insets(0, 0, 5, 0);
					gbc_panelLinea1.gridx = 0;
					gbc_panelLinea1.gridy = 0;
					panelArtefactos.add(panelLinea1, gbc_panelLinea1);
					{
						JLabel labelArtefacto = new JLabel("Artefactos del Recibo:");
						labelArtefacto.setFont(new Font("Tahoma", Font.BOLD, 12));
						panelLinea1.add(labelArtefacto);
					}
					{
						comboArtefactosRecibo = new ComboArtefactosRecibo();
						comboArtefactosRecibo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						panelLinea1.add(comboArtefactosRecibo);
					}
					{
						JLabel labelInformacion = new JLabel("Diagn\u00F3stico del Cliente:");
						labelInformacion.setFont(new Font("Tahoma", Font.BOLD, 12));
						panelLinea1.add(labelInformacion);
					}
					{
						textInformacion = new JTextField();
						textInformacion.setEditable(false);
						textInformacion.setColumns(43);
						panelLinea1.add(textInformacion);
					}
				}
				
				{
					JPanel panelLinea2 = new JPanel();
					FlowLayout flowLayout = (FlowLayout) panelLinea2.getLayout();
					flowLayout.setAlignment(FlowLayout.LEFT);
					GridBagConstraints gbc_panelLinea2 = new GridBagConstraints();
					gbc_panelLinea2.anchor = GridBagConstraints.NORTH;
					gbc_panelLinea2.fill = GridBagConstraints.HORIZONTAL;
					gbc_panelLinea2.gridx = 0;
					gbc_panelLinea2.gridy = 1;
					panelArtefactos.add(panelLinea2, gbc_panelLinea2);
					{
						JLabel labelDetalles = new JLabel("Detalles del Aparato:");
						labelDetalles.setFont(new Font("Tahoma", Font.BOLD, 12));
						panelLinea2.add(labelDetalles);
					}
					{
						textDetalles = new JTextField();
						textDetalles.setEditable(false);
						textDetalles.setColumns(44);
						panelLinea2.add(textDetalles);
					}
					{
						JLabel labelDiagnostico = new JLabel("Diagn\u00F3stico T\u00E9cnico:");
						labelDiagnostico.setFont(new Font("Tahoma", Font.BOLD, 12));
						panelLinea2.add(labelDiagnostico);
					}
					{
						textDiagnostico = new JTextField();
						textDiagnostico.setEditable(false);
						textDiagnostico.setColumns(50);
						panelLinea2.add(textDiagnostico);
					}
					{
						JLabel lblStatus = new JLabel("Estado Reparaci\u00F3n:");
						lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
						panelLinea2.add(lblStatus);
					}
					{
						comboStatus = new JComboBox();
						comboStatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						comboStatus.setModel(new DefaultComboBoxModel(new String[] {"Pendiente", "Reparado"}));
						comboStatus.setSelectedIndex(-1);
						panelLinea2.add(comboStatus);
					}
				}
			}
			{
				JPanel panelRepuestos = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panelRepuestos.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				GridBagConstraints gbc_panelRepuestos = new GridBagConstraints();
				gbc_panelRepuestos.anchor = GridBagConstraints.NORTH;
				gbc_panelRepuestos.fill = GridBagConstraints.HORIZONTAL;
				gbc_panelRepuestos.gridx = 0;
				gbc_panelRepuestos.gridy = 2;
				panelRecepcion.add(panelRepuestos, gbc_panelRepuestos);
				{
					JLabel lblRepuestos = new JLabel("Repuestos a usar:");
					lblRepuestos.setFont(new Font("Tahoma", Font.BOLD, 12));
					panelRepuestos.add(lblRepuestos);
				}
				{
					ComboRepuestos comboRepuestos = new ComboRepuestos();
					comboRepuestos.llenar();
					panelRepuestos.add(comboRepuestos);
				}
			}
		}
		{
			JPanel panelBotones = new JPanel();
			getContentPane().add(panelBotones, BorderLayout.SOUTH);
			{
				JPanel panel = new JPanel();
				panel.setBackground(Color.GRAY);
				panelBotones.add(panel);
				{
					btnReparacion = new JButton("");
					panel.add(btnReparacion);
					btnReparacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnReparacion.setRolloverIcon(new ImageIcon(VistaReparacion.class.getResource("/imagenes/iconos/iconos_32x32/plus.png")));
					btnReparacion.setIcon(new ImageIcon(VistaReparacion.class.getResource("/imagenes/iconos/iconos_32x32/iconoRepuesto.png")));
				}
			}
		}
		
		//-------------> enlaces <----------------
		ControladorVistaReparacion eco= new ControladorVistaReparacion(this);
		comboArtefactosRecibo.addActionListener(eco);
		textNrecibo.addKeyListener(eco);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);//maximar automaticamente
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}//fin constructor

	public JTextField getTextNrecibo() {
		return textNrecibo;
	}

	public JTextField getTextFechaRecepcion() {
		return textFechaRecepcion;
	}

	public JTextField getTextFechaEntrega() {
		return textFechaEntrega;
	}

	public JTextField getTextCedula() {
		return textCedula;
	}

	public JTextField getTextCliente() {
		return textCliente;
	}

	public JTextField getTextTelefono1() {
		return textTelefono1;
	}

	public JTextField getTextTelefono2() {
		return textTelefono2;
	}

	public JTextField getTextDireccion() {
		return textDireccion;
	}

	public JTextField getTextCorrero() {
		return textCorrero;
	}

	public JTextField getTextTecnico() {
		return textTecnico;
	}

	public ComboArtefactosRecibo getComboArtefactosRecibo() {
		return comboArtefactosRecibo;
	}

	public JTextField getTextInformacion() {
		return textInformacion;
	}

	public JTextField getTextDetalles() {
		return textDetalles;
	}

	public JTextField getTextDiagnostico() {
		return textDiagnostico;
	}

	public JButton getBtnReparacion() {
		return btnReparacion;
	}

	public JComboBox getComboStatus() {
		return comboStatus;
	}
	

}//fin de la clase
