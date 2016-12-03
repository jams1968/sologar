package vistas;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTable;

public class VistaRecepcion extends JDialog {
	private JTextField textNrecibo;
	private JTextField textFechaRecibo;
	private JTextField textHoraREcibo;
	private JTextField textCedula;
	private JTextField textCliente;
	private JTextField textTelefono2;
	private JTextField textField;
	private JTextField textDireccion;
	private JTextField textCorreo;
	private JTextField textUsuario;
	private JTable tablaArtefactos;
	private DefaultTableModel modeloTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaRecepcion dialog = new VistaRecepcion();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
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
	public VistaRecepcion() {
		//---->hora y fecha de la recepcion<--------------
		Calendar calendario = Calendar.getInstance();
		int hora, minutos, segundos;
		Calendar c = new GregorianCalendar();
		String dia_hoy,mes_hoy,year_hoy;
		dia_hoy = Integer.toString(c.get(Calendar.DATE));
		mes_hoy = Integer.toString(c.get(Calendar.MONTH)+1);
		year_hoy = Integer.toString(c.get(Calendar.YEAR));
		hora =calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		
		setTitle("RECEPCI\u00D3N DE ARTEFACTOS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaRecepcion.class.getResource("/imagenes/iconos/ventilador.png")));
		setBounds(100, 100, 585, 505);
		
		JPanel panelCabecera = new JPanel();
		FlowLayout fl_panelCabecera = (FlowLayout) panelCabecera.getLayout();
		fl_panelCabecera.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panelCabecera, BorderLayout.NORTH);
		
		JLabel labelNroRecibo = new JLabel("Recibo Nro.:");
		labelNroRecibo.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelNroRecibo.setHorizontalAlignment(SwingConstants.LEFT);
		panelCabecera.add(labelNroRecibo);
		
		textNrecibo = new JTextField();
		textNrecibo.setEditable(false);
		textNrecibo.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelCabecera.add(textNrecibo);
		textNrecibo.setColumns(6);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelCabecera.add(lblFecha);
		
		textFechaRecibo = new JTextField();
		textFechaRecibo.setEditable(false);
		textFechaRecibo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelCabecera.add(textFechaRecibo);
		textFechaRecibo.setColumns(10);
		textFechaRecibo.setText(dia_hoy+"/"+mes_hoy+"/"+year_hoy);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelCabecera.add(lblHora);
		
		textHoraREcibo = new JTextField();
		textHoraREcibo.setEditable(false);
		textHoraREcibo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelCabecera.add(textHoraREcibo);
		textHoraREcibo.setColumns(10);
		textHoraREcibo.setText(""+hora+":"+minutos);
		
		JPanel panelRecepcion = new JPanel();
		getContentPane().add(panelRecepcion, BorderLayout.CENTER);
		panelRecepcion.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCliente = new JPanel();
		panelCliente.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2, true), "Datos del Cliente", TitledBorder.RIGHT, TitledBorder.TOP, null, Color.BLUE));
		panelRecepcion.add(panelCliente, BorderLayout.NORTH);
		GridBagLayout gbl_panelCliente = new GridBagLayout();
		gbl_panelCliente.columnWidths = new int[]{0, 0, 0};
		gbl_panelCliente.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelCliente.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panelCliente.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panelCliente.setLayout(gbl_panelCliente);
		
		JPanel panelLinea1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelLinea1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panelLinea1 = new GridBagConstraints();
		gbc_panelLinea1.insets = new Insets(0, 0, 5, 0);
		gbc_panelLinea1.gridwidth = 2;
		gbc_panelLinea1.fill = GridBagConstraints.BOTH;
		gbc_panelLinea1.gridx = 0;
		gbc_panelLinea1.gridy = 0;
		panelCliente.add(panelLinea1, gbc_panelLinea1);
		
		JLabel lblCedula = new JLabel("Cedula o Rif:");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelLinea1.add(lblCedula);
		
		textCedula = new JTextField();
		panelLinea1.add(textCedula);
		textCedula.setColumns(12);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelLinea1.add(lblCliente);
		
		textCliente = new JTextField();
		panelLinea1.add(textCliente);
		textCliente.setColumns(37);
		
		JPanel panelLinea2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelLinea2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panelLinea2 = new GridBagConstraints();
		gbc_panelLinea2.gridwidth = 2;
		gbc_panelLinea2.insets = new Insets(0, 0, 5, 0);
		gbc_panelLinea2.fill = GridBagConstraints.BOTH;
		gbc_panelLinea2.gridx = 0;
		gbc_panelLinea2.gridy = 1;
		panelCliente.add(panelLinea2, gbc_panelLinea2);
		
		JLabel lblTelefono1 = new JLabel("Tel\u00E9fono Celular:");
		lblTelefono1.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelLinea2.add(lblTelefono1);
		
		textTelefono2 = new JTextField();
		panelLinea2.add(textTelefono2);
		textTelefono2.setColumns(16);
		
		JLabel lblTelefono2 = new JLabel("Otro Tel\u00E9fono:");
		lblTelefono2.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelLinea2.add(lblTelefono2);
		
		textField = new JTextField();
		panelLinea2.add(textField);
		textField.setColumns(16);
		
		JPanel panelLinea3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panelLinea3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panelLinea3 = new GridBagConstraints();
		gbc_panelLinea3.gridwidth = 2;
		gbc_panelLinea3.insets = new Insets(0, 0, 5, 0);
		gbc_panelLinea3.fill = GridBagConstraints.BOTH;
		gbc_panelLinea3.gridx = 0;
		gbc_panelLinea3.gridy = 2;
		panelCliente.add(panelLinea3, gbc_panelLinea3);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelLinea3.add(lblDireccion);
		
		textDireccion = new JTextField();
		panelLinea3.add(textDireccion);
		textDireccion.setColumns(30);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelLinea3.add(lblCorreo);
		
		textCorreo = new JTextField();
		panelLinea3.add(textCorreo);
		textCorreo.setColumns(20);
		
		JPanel panelTecnico = new JPanel();
		panelTecnico.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2, true), "T\u00E9cnico Receptor", TitledBorder.RIGHT, TitledBorder.TOP, null, Color.BLUE));
		FlowLayout fl_panelTecnico = (FlowLayout) panelTecnico.getLayout();
		fl_panelTecnico.setAlignment(FlowLayout.LEFT);
		panelRecepcion.add(panelTecnico, BorderLayout.CENTER);
		
		JLabel labelUsuario = new JLabel("T\u00E9cnico:");
		labelUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelTecnico.add(labelUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setColumns(30);
		panelTecnico.add(textUsuario);
		
		JButton btnAgregarArtefacto = new JButton("Agregar Artefacto");
		panelTecnico.add(btnAgregarArtefacto);
		
		JPanel panelArtefactos = new JPanel();
		panelRecepcion.add(panelArtefactos, BorderLayout.SOUTH);
		
		tablaArtefactos = new JTable();
		tablaArtefactos.setBorder(new LineBorder(Color.BLUE, 2, true));
		
		//----------->modelo tabla<-----------
		modeloTabla = new DefaultTableModel(new Object[][] {},
				new String[] {"Nro.", "Tipo Aparato", "informacion", "Detalles","Diagnóstico Tec"}){
				private static final long serialVersionUID = 1L;
				public boolean isCellEditable(int rowIndex, int columnIndex) {
				    return false;  //
			}
		};
		 tablaArtefactos.setModel(new DefaultTableModel(
		 	new Object[][] {
		 		{null, null, null, null, null},
		 		{null, null, null, null, null},
		 		{null, null, null, null, null},
		 		{null, null, null, null, null},
		 	},
		 	new String[] {
		 		"Nro.", "Tipo Aparato", "informacion", "Detalles", "Diagn\u00F3stico Tec"
		 	}
		 ));
		 panelArtefactos.add(tablaArtefactos);


	}

}
