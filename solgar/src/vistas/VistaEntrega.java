package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controladoresVistas.ControladorVistaEntrega;

import java.awt.Color;

import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;

public class VistaEntrega extends JDialog {

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
	private DefaultTableModel datosTabla;
	private JTable tablaRepuestoReparacion;
	private JLabel lblMensaje;
	private JTextField textMontoGeneral;
	private JButton btnVaciar;
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VistaEntrega dialog = new VistaEntrega();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VistaEntrega() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaEntrega.class.getResource("/imagenes/iconos/iconos_32x32/ventilador2.png")));
		setBounds(100, 100, 981, 662);
		setTitle("ENTREGA DE ARTEFACTOS");
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
				btnBuscar = new JButton("");
				btnBuscar.setRolloverIcon(new ImageIcon(VistaEntrega.class.getResource("/imagenes/iconos/iconos_32x32/zoom.png")));
				btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnBuscar.setIcon(new ImageIcon(VistaEntrega.class.getResource("/imagenes/iconos/iconos_32x32/search.png")));
				panelCabecera.add(btnBuscar);
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
			gbl_panelRecepcion.rowHeights = new int[]{43, 51, 103, 55, 0, 0};
			gbl_panelRecepcion.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panelRecepcion.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
				JScrollPane scrollPaneTabla = new JScrollPane((Component) null);
				GridBagConstraints gbc_scrollPaneTabla = new GridBagConstraints();
				gbc_scrollPaneTabla.insets = new Insets(0, 0, 5, 0);
				gbc_scrollPaneTabla.fill = GridBagConstraints.BOTH;
				gbc_scrollPaneTabla.gridx = 0;
				gbc_scrollPaneTabla.gridy = 2;
				panelRecepcion.add(scrollPaneTabla, gbc_scrollPaneTabla);
				{
					tablaRepuestoReparacion = new JTable();
					//tablaRepuestoReparacion
					datosTabla=new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Nro.", "Tipo Aparato", "Detalles Reparaci\u00F3n", "Monto Repuestos", "Precio Mano Obra", "Subtotal","Condición"
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
				gbc_panelMensaje.gridy = 3;
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
				gbc_panel.gridy = 4;
				panelRecepcion.add(panel, gbc_panel);
				{
					JLabel lblMontoGeneral = new JLabel("Monto  Total:");
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
				btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnGuardar.setRolloverIcon(new ImageIcon(VistaEntrega.class.getResource("/imagenes/iconos/iconos_32x32/iconoRepuesto.png")));
				btnGuardar.setIcon(new ImageIcon(VistaEntrega.class.getResource("/imagenes/iconos/iconos_32x32/plus.png")));
				buttonPane.add(btnGuardar);
				getRootPane().setDefaultButton(btnGuardar);
			}
			{
				btnVaciar = new JButton("");
				btnVaciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnVaciar.setRolloverIcon(new ImageIcon(VistaEntrega.class.getResource("/imagenes/iconos/iconos_32x32/refresh.png")));
				btnVaciar.setIcon(new ImageIcon(VistaEntrega.class.getResource("/imagenes/iconos/iconos_32x32/page_refresh.png")));
				btnVaciar.setToolTipText("Vaciar Formulario");
				buttonPane.add(btnVaciar);
			}
			{
				btnCerrar = new JButton("");
				btnCerrar.setRolloverIcon(new ImageIcon(VistaEntrega.class.getResource("/imagenes/iconos/iconos_32x32/door_out.png")));
				btnCerrar.setIcon(new ImageIcon(VistaEntrega.class.getResource("/imagenes/iconos/iconos_32x32/door.png")));
				btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnCerrar.setActionCommand("Cancel");
				buttonPane.add(btnCerrar);
			}
		}
		
		//-----------> enlaces<------------------
		ControladorVistaEntrega eco=new ControladorVistaEntrega(this);
		btnCerrar.addActionListener(eco);
		btnGuardar.addActionListener(eco);
		btnBuscar.addActionListener(eco);
		
		textNrecibo.addKeyListener(eco);
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

	public JButton getBtnVaciar() {
		return btnVaciar;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}


	
	
	

}//fi clase
