package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import controladoresVistas.ControladorVistaReparacionNueva;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import modelosComboBox.ComboArtefactosRecibo;
import modelosComboBox.ComboRepuestos;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;

public class VistaReparacionNueva extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnGuardar;
	private JButton btnCerrar;
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
	private JLabel labelArtefacto;
	private ComboArtefactosRecibo comboArtefactosRecibo;
	private JTextField textInformacion;
	private JTextField textDetalles;
	private JTextField textDiagnostico;
	private ComboRepuestos comboRepuestos;
	private JTextField textCodigo;
	private JTextField textRepuesto;
	private JTextField textCantidadActual;
	private JTextField textCantidadUsar;
	private JTextField textPrecio;
	private JTextField textMonto;
	private DefaultTableModel datosTabla;
	private JComboBox comboStatus;
	private JButton btnAgregarRepuesto;
	private JTable tablaRepuestoReparacion;
	private JLabel lblMensaje;
	private JTextField textMontoGeneral;
	private JTextField textManoObra;
	private JTextArea textDetallesRep;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VistaReparacionNueva dialog = new VistaReparacionNueva();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VistaReparacionNueva() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaReparacionNueva.class.getResource("/imagenes/iconos/iconos_32x32/ventilador2.png")));
		setBounds(100, 100, 981, 662);
		setTitle("REPARACI\u00D3N DE ARTEFACTOS");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelCabecera = new JPanel();
			FlowLayout fl_panelCabecera = (FlowLayout) panelCabecera.getLayout();
			fl_panelCabecera.setAlignment(FlowLayout.LEFT);
			contentPanel.add(panelCabecera, BorderLayout.NORTH);
			{
				JLabel label = new JLabel("Recibo Nro.:");
				label.setHorizontalAlignment(SwingConstants.LEFT);
				label.setFont(new Font("Tahoma", Font.BOLD, 14));
				panelCabecera.add(label);
			}
			{
				textNrecibo = new JTextField();
				textNrecibo.setFont(new Font("Tahoma", Font.BOLD, 14));
				textNrecibo.setColumns(4);
				panelCabecera.add(textNrecibo);
			}
			{
				JLabel label = new JLabel("Fecha Recepci\u00F3n:");
				label.setFont(new Font("Tahoma", Font.BOLD, 14));
				panelCabecera.add(label);
			}
			{
				textFechaRecepcion = new JTextField();
				textFechaRecepcion.setEditable(false);
				textFechaRecepcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
				textFechaRecepcion.setColumns(10);
				panelCabecera.add(textFechaRecepcion);
			}
			{
				JLabel label = new JLabel("Fecha de Entrega:");
				label.setFont(new Font("Tahoma", Font.BOLD, 14));
				panelCabecera.add(label);
			}
			{
				textFechaEntrega = new JTextField();
				textFechaEntrega.setEditable(false);
				textFechaEntrega.setColumns(10);
				panelCabecera.add(textFechaEntrega);
			}
		}
		{
			JPanel panelRecepcion = new JPanel();
			panelRecepcion.setAlignmentX(Component.RIGHT_ALIGNMENT);
			contentPanel.add(panelRecepcion, BorderLayout.CENTER);
			GridBagLayout gbl_panelRecepcion = new GridBagLayout();
			gbl_panelRecepcion.columnWidths = new int[]{0, 0};
			gbl_panelRecepcion.rowHeights = new int[]{43, 51, 0, 0, 53, 0, 0, 103, 55, 0, 0};
			gbl_panelRecepcion.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panelRecepcion.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panelRecepcion.setLayout(gbl_panelRecepcion);
			{
				JPanel panelLinea1 = new JPanel();
				panelLinea1.setBorder(null);
				GridBagConstraints gbc_panelLinea1 = new GridBagConstraints();
				gbc_panelLinea1.fill = GridBagConstraints.HORIZONTAL;
				gbc_panelLinea1.insets = new Insets(0, 0, 5, 0);
				gbc_panelLinea1.gridx = 0;
				gbc_panelLinea1.gridy = 0;
				panelRecepcion.add(panelLinea1, gbc_panelLinea1);
				FlowLayout fl_panelLinea1 = (FlowLayout) panelLinea1.getLayout();
				fl_panelLinea1.setAlignment(FlowLayout.LEFT);
				{
					JLabel labelCedula = new JLabel("Cedula o Rif:");
					labelCedula.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panelLinea1.add(labelCedula);
				}
				{
					textCedula = new JTextField();
					textCedula.setEditable(false);
					textCedula.setColumns(10);
					panelLinea1.add(textCedula);
				}
				{
					JLabel labelCliente = new JLabel("Cliente:");
					labelCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panelLinea1.add(labelCliente);
				}
				{
					textCliente = new JTextField();
					textCliente.setEditable(false);
					textCliente.setColumns(20);
					panelLinea1.add(textCliente);
				}
				{
					JLabel labelTelefono = new JLabel("Celular:");
					labelTelefono.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panelLinea1.add(labelTelefono);
				}
				{
					textTelefono1 = new JTextField();
					textTelefono1.setEditable(false);
					textTelefono1.setColumns(12);
					panelLinea1.add(textTelefono1);
				}
				{
					JLabel labelTelefono2 = new JLabel("Otro Tel\u00E9fono:");
					labelTelefono2.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panelLinea1.add(labelTelefono2);
				}
				{
					textTelefono2 = new JTextField();
					textTelefono2.setEditable(false);
					textTelefono2.setColumns(12);
					panelLinea1.add(textTelefono2);
				}
			}
			{
				JPanel panelLinea2 = new JPanel();
				FlowLayout fl_panelLinea2 = (FlowLayout) panelLinea2.getLayout();
				fl_panelLinea2.setAlignment(FlowLayout.LEFT);
				GridBagConstraints gbc_panelLinea2 = new GridBagConstraints();
				gbc_panelLinea2.insets = new Insets(0, 0, 5, 0);
				gbc_panelLinea2.fill = GridBagConstraints.HORIZONTAL;
				gbc_panelLinea2.gridx = 0;
				gbc_panelLinea2.gridy = 1;
				panelRecepcion.add(panelLinea2, gbc_panelLinea2);
				{
					JLabel labelDireccion = new JLabel("Direcci\u00F3n:");
					labelDireccion.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panelLinea2.add(labelDireccion);
				}
				{
					textDireccion = new JTextField();
					textDireccion.setEditable(false);
					textDireccion.setColumns(36);
					panelLinea2.add(textDireccion);
				}
				{
					JLabel labelCorreo = new JLabel("Correo:");
					labelCorreo.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panelLinea2.add(labelCorreo);
				}
				{
					textCorrero = new JTextField();
					textCorrero.setEditable(false);
					textCorrero.setColumns(20);
					panelLinea2.add(textCorrero);
				}
				{
					JLabel labelTecnico = new JLabel("T\u00E9cnico:");
					labelTecnico.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panelLinea2.add(labelTecnico);
				}
				{
					textTecnico = new JTextField();
					textTecnico.setEditable(false);
					textTecnico.setColumns(15);
					panelLinea2.add(textTecnico);
				}
			}
			{
				JPanel panelLinea3 = new JPanel();
				FlowLayout fl_panelLinea3 = (FlowLayout) panelLinea3.getLayout();
				fl_panelLinea3.setAlignment(FlowLayout.LEFT);
				GridBagConstraints gbc_panelLinea3 = new GridBagConstraints();
				gbc_panelLinea3.insets = new Insets(0, 0, 5, 0);
				gbc_panelLinea3.fill = GridBagConstraints.HORIZONTAL;
				gbc_panelLinea3.gridx = 0;
				gbc_panelLinea3.gridy = 2;
				panelRecepcion.add(panelLinea3, gbc_panelLinea3);
				{
					labelArtefacto = new JLabel("Artefactos del Recibo:");
					labelArtefacto.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panelLinea3.add(labelArtefacto);
				}
				{
					comboArtefactosRecibo = new ComboArtefactosRecibo();
					comboArtefactosRecibo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					comboArtefactosRecibo.setEnabled(false);
					panelLinea3.add(comboArtefactosRecibo);
				}
				{
					JLabel labelInformacion = new JLabel("Diagn\u00F3stico del Cliente:");
					labelInformacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panelLinea3.add(labelInformacion);
				}
				{
					textInformacion = new JTextField();
					textInformacion.setEditable(false);
					textInformacion.setColumns(35);
					panelLinea3.add(textInformacion);
				}
			}
			{
				JPanel panelLinea4 = new JPanel();
				FlowLayout fl_panelLinea4 = (FlowLayout) panelLinea4.getLayout();
				fl_panelLinea4.setAlignment(FlowLayout.LEFT);
				GridBagConstraints gbc_panelLinea4 = new GridBagConstraints();
				gbc_panelLinea4.insets = new Insets(0, 0, 5, 0);
				gbc_panelLinea4.fill = GridBagConstraints.HORIZONTAL;
				gbc_panelLinea4.gridx = 0;
				gbc_panelLinea4.gridy = 3;
				panelRecepcion.add(panelLinea4, gbc_panelLinea4);
				{
					JLabel labelDetalles = new JLabel("Detalles:");
					labelDetalles.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panelLinea4.add(labelDetalles);
				}
				{
					textDetalles = new JTextField();
					textDetalles.setEditable(false);
					textDetalles.setColumns(20);
					panelLinea4.add(textDetalles);
				}
				{
					JLabel labelDiagnostico = new JLabel("Diagn\u00F3stico T\u00E9cnico:");
					labelDiagnostico.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panelLinea4.add(labelDiagnostico);
				}
				{
					textDiagnostico = new JTextField();
					textDiagnostico.setEditable(false);
					textDiagnostico.setColumns(30);
					panelLinea4.add(textDiagnostico);
				}
				{
					JLabel lblStatus = new JLabel("Reparaci\u00F3n:");
					panelLinea4.add(lblStatus);
					lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 11));
				}
				{
					comboStatus = new JComboBox();
					panelLinea4.add(comboStatus);
					comboStatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					comboStatus.setModel(new DefaultComboBoxModel(new String[] {"Pendiente", "Reparado"}));
					comboStatus.setSelectedIndex(-1);
				}
			}
			{
				JPanel panelDetalles = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panelDetalles.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				GridBagConstraints gbc_panelDetalles = new GridBagConstraints();
				gbc_panelDetalles.insets = new Insets(0, 0, 5, 0);
				gbc_panelDetalles.fill = GridBagConstraints.BOTH;
				gbc_panelDetalles.gridx = 0;
				gbc_panelDetalles.gridy = 4;
				panelRecepcion.add(panelDetalles, gbc_panelDetalles);
				{
					JLabel lblDetalle = new JLabel("Detalles Reparaci\u00F3n");
					lblDetalle.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panelDetalles.add(lblDetalle);
				}
				{
					textDetallesRep = new JTextArea();
					textDetallesRep.setEditable(false);
					textDetallesRep.setRows(2);
					textDetallesRep.setColumns(70);
					textDetallesRep.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
					panelDetalles.add(textDetallesRep);
				}
			}
			
			{
				JPanel panelLinea5 = new JPanel();
				FlowLayout fl_panelLinea5 = (FlowLayout) panelLinea5.getLayout();
				fl_panelLinea5.setAlignment(FlowLayout.LEFT);
				GridBagConstraints gbc_panelLinea5 = new GridBagConstraints();
				gbc_panelLinea5.insets = new Insets(0, 0, 5, 0);
				gbc_panelLinea5.fill = GridBagConstraints.BOTH;
				gbc_panelLinea5.gridx = 0;
				gbc_panelLinea5.gridy = 5;
				panelRecepcion.add(panelLinea5, gbc_panelLinea5);
				{
					JLabel lblRepuestos = new JLabel("Repuestos a usar:");
					lblRepuestos.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panelLinea5.add(lblRepuestos);
				}
				{
					comboRepuestos = new ComboRepuestos();
					comboRepuestos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					comboRepuestos.setEnabled(false);
					comboRepuestos.llenar();
					panelLinea5.add(comboRepuestos);
				}
				{
					JLabel lblCodigo = new JLabel("C\u00F3digo:");
					lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panelLinea5.add(lblCodigo);
				}
				{
					textCodigo = new JTextField();
					textCodigo.setEditable(false);
					textCodigo.setColumns(10);
					panelLinea5.add(textCodigo);
				}
				{
					JLabel lblRepuesto = new JLabel("Repuesto:");
					lblRepuesto.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panelLinea5.add(lblRepuesto);
				}
				{
					textRepuesto = new JTextField();
					textRepuesto.setEditable(false);
					textRepuesto.setColumns(15);
					panelLinea5.add(textRepuesto);
				}
				{
					JLabel lblCantidadActual = new JLabel("Cantidad Actual:");
					panelLinea5.add(lblCantidadActual);
					lblCantidadActual.setFont(new Font("Tahoma", Font.PLAIN, 11));
				}
				{
					textCantidadActual = new JTextField();
					panelLinea5.add(textCantidadActual);
					textCantidadActual.setEditable(false);
					textCantidadActual.setColumns(4);
				}
			}
			{
				JPanel panelLinea6 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panelLinea6.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				GridBagConstraints gbc_panelLinea6 = new GridBagConstraints();
				gbc_panelLinea6.insets = new Insets(0, 0, 5, 0);
				gbc_panelLinea6.fill = GridBagConstraints.HORIZONTAL;
				gbc_panelLinea6.gridx = 0;
				gbc_panelLinea6.gridy = 6;
				panelRecepcion.add(panelLinea6, gbc_panelLinea6);
				{
					JLabel lblCantidadUsar = new JLabel("Cantidad a Usar:");
					lblCantidadUsar.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panelLinea6.add(lblCantidadUsar);
				}
				{
					textCantidadUsar = new JTextField();
					textCantidadUsar.setEditable(false);
					textCantidadUsar.setColumns(4);
					panelLinea6.add(textCantidadUsar);
				}
				{
					JLabel lblPrecioRepuesto = new JLabel("Precio:");
					lblPrecioRepuesto.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panelLinea6.add(lblPrecioRepuesto);
				}
				{
					textPrecio = new JTextField();
					textPrecio.setEditable(false);
					textPrecio.setColumns(8);
					panelLinea6.add(textPrecio);
				}
				{
					JLabel labelSubMonto = new JLabel("Monto:");
					labelSubMonto.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panelLinea6.add(labelSubMonto);
				}
				{
					textMonto = new JTextField();
					textMonto.setEditable(false);
					textMonto.setColumns(8);
					panelLinea6.add(textMonto);
				}
				{
					btnAgregarRepuesto = new JButton("");
					panelLinea6.add(btnAgregarRepuesto);
					btnAgregarRepuesto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnAgregarRepuesto.setRolloverIcon(new ImageIcon(VistaReparacionNueva.class.getResource("/imagenes/iconos/iconos_32x32/order.png")));
					btnAgregarRepuesto.setIcon(new ImageIcon(VistaReparacionNueva.class.getResource("/imagenes/iconos/iconos_32x32/order-1.png")));
					btnAgregarRepuesto.setEnabled(false);
				}
				
			}
			{
				
				
//					datosTabla = new DefaultTableModel(new Object[][] {},
//							new String[] { "Nro.", "C\u00F3digo", "Repuesto", "Precio", "Cantidad", "Monto" });
				
				
			}
			{
				JScrollPane scrollPaneTabla = new JScrollPane((Component) null);
				GridBagConstraints gbc_scrollPaneTabla = new GridBagConstraints();
				gbc_scrollPaneTabla.insets = new Insets(0, 0, 5, 0);
				gbc_scrollPaneTabla.fill = GridBagConstraints.BOTH;
				gbc_scrollPaneTabla.gridx = 0;
				gbc_scrollPaneTabla.gridy = 7;
				panelRecepcion.add(scrollPaneTabla, gbc_scrollPaneTabla);
				{
					tablaRepuestoReparacion = new JTable();
					//tablaRepuestoReparacion
					datosTabla=new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Nro.", "C\u00F3digo", "Repuesto", "Cantidad", "Precio", "Monto"
						}
					);
					tablaRepuestoReparacion.setModel(datosTabla);
					tablaRepuestoReparacion.getColumnModel().getColumn(0).setPreferredWidth(37);
					tablaRepuestoReparacion.getColumnModel().getColumn(2).setPreferredWidth(129);
					tablaRepuestoReparacion.getColumnModel().getColumn(4).setPreferredWidth(69);
					scrollPaneTabla.setViewportView(tablaRepuestoReparacion);
				}
			}
			{
				JPanel panelMensaje = new JPanel();
				panelMensaje.setBorder(new TitledBorder(null, "Mensaje del Sistema", TitledBorder.RIGHT, TitledBorder.TOP, null, Color.BLUE));
				GridBagConstraints gbc_panelMensaje = new GridBagConstraints();
				gbc_panelMensaje.insets = new Insets(0, 0, 5, 0);
				gbc_panelMensaje.fill = GridBagConstraints.BOTH;
				gbc_panelMensaje.gridx = 0;
				gbc_panelMensaje.gridy = 8;
				panelRecepcion.add(panelMensaje, gbc_panelMensaje);
				{
					lblMensaje = new JLabel("");
					lblMensaje.setForeground(Color.RED);
					lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 12));
					panelMensaje.add(lblMensaje);
				}
			}
			{
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setAlignment(FlowLayout.RIGHT);
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.gridx = 0;
				gbc_panel.gridy = 9;
				panelRecepcion.add(panel, gbc_panel);
				{
					JLabel lblManoObra = new JLabel("Mano de Obra Reparaciones por Equipo:");
					panel.add(lblManoObra);
					lblManoObra.setFont(new Font("Tahoma", Font.BOLD, 12));
				}
				{
					textManoObra = new JTextField();
					textManoObra.setForeground(Color.BLUE);
					textManoObra.setFont(new Font("Tahoma", Font.BOLD, 12));
					panel.add(textManoObra);
					textManoObra.setEditable(false);
					textManoObra.setColumns(10);
				}
				{
					JLabel lblMontoGeneral = new JLabel("Monto  Repuestos:");
					lblMontoGeneral.setFont(new Font("Tahoma", Font.BOLD, 12));
					panel.add(lblMontoGeneral);
				}
				{
					textMontoGeneral = new JTextField();
					panel.add(textMontoGeneral);
					textMontoGeneral.setFont(new Font("Tahoma", Font.BOLD, 12));
					textMontoGeneral.setForeground(Color.BLUE);
					textMontoGeneral.setEditable(false);
					textMontoGeneral.setColumns(10);
				}
				
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnGuardar = new JButton("");
				btnGuardar.setEnabled(false);
				btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnGuardar.setRolloverIcon(new ImageIcon(VistaReparacionNueva.class.getResource("/imagenes/iconos/iconos_32x32/iconoRepuesto.png")));
				btnGuardar.setIcon(new ImageIcon(VistaReparacionNueva.class.getResource("/imagenes/iconos/iconos_32x32/plus.png")));
				buttonPane.add(btnGuardar);
				getRootPane().setDefaultButton(btnGuardar);
			}
			{
				btnCerrar = new JButton("");
				btnCerrar.setRolloverIcon(new ImageIcon(VistaReparacionNueva.class.getResource("/imagenes/iconos/iconos_32x32/door_out.png")));
				btnCerrar.setIcon(new ImageIcon(VistaReparacionNueva.class.getResource("/imagenes/iconos/iconos_32x32/door.png")));
				btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnCerrar.setActionCommand("Cancel");
				buttonPane.add(btnCerrar);
			}
		}
		//-------------> enlaces <----------------
				ControladorVistaReparacionNueva eco= new ControladorVistaReparacionNueva(this);
				comboArtefactosRecibo.addActionListener(eco);
				textNrecibo.addKeyListener(eco);
				comboRepuestos.addActionListener(eco);
				btnCerrar.addActionListener(eco);
				btnGuardar.addActionListener(eco);
				comboRepuestos.addActionListener(eco);
				btnAgregarRepuesto.addActionListener(eco);
				textCantidadUsar.addKeyListener(eco);
				textDetallesRep.addKeyListener(eco);
				textManoObra.addKeyListener(eco);
				textNrecibo.addFocusListener(eco);
				
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}//fin constructor

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnCerrar() {
		return btnCerrar;
	}

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

	public JLabel getLabelArtefacto() {
		return labelArtefacto;
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

	public ComboRepuestos getComboRepuestos() {
		return comboRepuestos;
	}

	public JTextField getTextCodigo() {
		return textCodigo;
	}

	public JTextField getTextRepuesto() {
		return textRepuesto;
	}

	public JTextField getTextCantidadActual() {
		return textCantidadActual;
	}

	public JTextField getTextCantidadUsar() {
		return textCantidadUsar;
	}

	public JTextField getTextPrecio() {
		return textPrecio;
	}

	public JTextField getTextMonto() {
		return textMonto;
	}

	

	
	

	public JButton getBtnAgregarRepuesto() {
		return btnAgregarRepuesto;
	}

	

	public JComboBox getComboStatus() {
		return comboStatus;
	}

	public DefaultTableModel getDatosTabla() {
		return datosTabla;
	}

	public JTable getTablaRepuestoReparacion() {
		return tablaRepuestoReparacion;
	}

	public JLabel getLblMensaje() {
		return lblMensaje;
	}

	public JTextField getTextMontoGeneral() {
		return textMontoGeneral;
	}

	public JTextField getTextManoObra() {
		return textManoObra;
	}

	public JTextArea getTextDetallesRep() {
		return textDetallesRep;
	}
	
	

}//fi clase
