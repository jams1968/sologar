package vistas;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controladoresVistas.ControladorVistaRecepcion;
import modelos.Usuario;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Insets;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class VistaRecepcion extends JDialog {
	private JTextField textNrecibo;
	private JTextField textFechaRecibo;
	private JTextField textHoraRecibo;
	private JTextField textCedula;
	private JTextField textCliente;
	private JTextField textTelefono1;
	private JTextField textTelefono2;
	private JTextField textDireccion;
	private JTextField textCorreo;
	private JTextField textUsuario;
	private  DefaultTableModel datosArtefactos;
	private JTable tablaArtefactos;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnReporteP;
	private JButton btnVaciar;
	private JButton btnCerrar;
	private JLabel lblMensaje;
	private Usuario registroUsuario;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario registroUsuario=new Usuario();
					registroUsuario.setNombre("Erick");
					registroUsuario.setApellido("Guerra");
					
					VistaRecepcion dialog = new VistaRecepcion(registroUsuario);
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
	public VistaRecepcion(Usuario registroUsuario) {
		this.registroUsuario=registroUsuario;
		
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
		setBounds(100, 100, 741, 505);
		
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
		
		textHoraRecibo = new JTextField();
		textHoraRecibo.setEditable(false);
		textHoraRecibo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelCabecera.add(textHoraRecibo);
		textHoraRecibo.setColumns(10);
		textHoraRecibo.setText(""+hora+":"+minutos);
		
		JPanel panelRecepcion = new JPanel();
		getContentPane().add(panelRecepcion, BorderLayout.CENTER);
		panelRecepcion.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCliente = new JPanel();
		panelCliente.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2, true), "Datos de la Recepci\u00F3n", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panelRecepcion.add(panelCliente, BorderLayout.NORTH);
		GridBagLayout gbl_panelCliente = new GridBagLayout();
		gbl_panelCliente.columnWidths = new int[]{0, 0, 0};
		gbl_panelCliente.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panelCliente.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelCliente.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
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
		textCliente.setEditable(false);
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
		
		textTelefono1 = new JTextField();
		textTelefono1.setEditable(false);
		panelLinea2.add(textTelefono1);
		textTelefono1.setColumns(16);
		
		JLabel lblTelefono2 = new JLabel("Otro Tel\u00E9fono:");
		lblTelefono2.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelLinea2.add(lblTelefono2);
		
		textTelefono2 = new JTextField();
		textTelefono2.setEditable(false);
		panelLinea2.add(textTelefono2);
		textTelefono2.setColumns(16);
		
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
		textDireccion.setEditable(false);
		panelLinea3.add(textDireccion);
		textDireccion.setColumns(30);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelLinea3.add(lblCorreo);
		
		textCorreo = new JTextField();
		textCorreo.setEditable(false);
		panelLinea3.add(textCorreo);
		textCorreo.setColumns(20);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		panelCliente.add(panel, gbc_panel);
		
		JLabel labelUsuario = new JLabel("T\u00E9cnico:");
		panel.add(labelUsuario);
		labelUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textUsuario = new JTextField();
		textUsuario.setText(registroUsuario.getNombre()+" "+registroUsuario.getApellido());
		textUsuario.setEditable(false);
		panel.add(textUsuario);
		textUsuario.setColumns(30);
		
		JButton btnAgregarArtefacto = new JButton("Agregar Artefacto");
		btnAgregarArtefacto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarArtefacto.setToolTipText("Agregar artefactos a la tabla");
		panel.add(btnAgregarArtefacto);
		
		JPanel panelTecnico = new JPanel();
		panelTecnico.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2, true), "Artefactos a Recibir", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panelRecepcion.add(panelTecnico, BorderLayout.CENTER);
		 new DefaultTableModel(new Object[][] {},
					new String[] {"Nro.", "CÉDULA", "NOMBRES", "APELLIDOS"}){
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int rowIndex, int columnIndex) {
					    return false;  //
				}
			};
			
		 datosArtefactos= new DefaultTableModel(new Object[][] {},
						new String[] {"Nro.", "Tipo Aparato", "informacion", "Detalles","Diagnóstico Tec"}){
			 	private static final long serialVersionUID = 1L;

			 	public boolean isCellEditable(int rowIndex, int columnIndex) {
					    return false;  //
				}
			};
			 DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
			 Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagLayout gbl_panelTecnico = new GridBagLayout();
		gbl_panelTecnico.columnWidths = new int[]{452, 0};
		gbl_panelTecnico.rowHeights = new int[]{444, 0};
		gbl_panelTecnico.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelTecnico.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelTecnico.setLayout(gbl_panelTecnico);
		
		//----------->modelo tabla<-----------
			 JScrollPane panelScroll=new JScrollPane();
			 //datosArtefactos.addRow(new String[]{"Nro.", "Tipo Aparato", "informacion", "Detalles","Diagnóstico Tec"}); 
			 tablaArtefactos= new JTable();
			 
			 	 tablaArtefactos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			 	 tablaArtefactos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			 	 
			 tablaArtefactos.setModel(datosArtefactos);
			 
			 	
			  tablaArtefactos.setSelectionBackground(Color.LIGHT_GRAY);
			  tablaArtefactos.setSelectionForeground(Color.red);
			  
			   tablaArtefactos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			   tablaArtefactos.getColumnModel().getColumn(0).setPreferredWidth(50);
			   tablaArtefactos.getColumnModel().getColumn(1).setPreferredWidth(100);
			   tablaArtefactos.getColumnModel().getColumn(2).setPreferredWidth(150);
			   tablaArtefactos.getColumnModel().getColumn(3).setPreferredWidth(150);
			   tablaArtefactos.getColumnModel().getColumn(4).setPreferredWidth(100);
			   
			    
			    
			    
			    
		panelScroll.setViewportView(tablaArtefactos);
		GridBagConstraints gbc_panelScroll = new GridBagConstraints();
		gbc_panelScroll.anchor = GridBagConstraints.NORTH;
		gbc_panelScroll.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelScroll.gridx = 0;
		gbc_panelScroll.gridy = 0;
		panelTecnico.add(panelScroll, gbc_panelScroll);
		
		JPanel panelPie = new JPanel();
		getContentPane().add(panelPie, BorderLayout.SOUTH);
		panelPie.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotones = new JPanel();
		panelPie.add(panelBotones);
		panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnRegistrar = new JButton("");
		panelBotones.add(btnRegistrar);
		btnRegistrar.setBounds(new Rectangle(0, 0, 65, 41));
		btnRegistrar.setToolTipText("Registrar Recibo de Recepci\u00F3n de Artefactos");
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.setRolloverIcon(new ImageIcon(VistaRecepcion.class.getResource("/imagenes/iconos/iconos_32x32/plus.png")));
		btnRegistrar.setIcon(new ImageIcon(VistaRecepcion.class.getResource("/imagenes/iconos/iconos_32x32/recepcionRegistrar.png")));
		
		btnModificar = new JButton("");
		panelBotones.add(btnModificar);
		btnModificar.setBounds(new Rectangle(0, 0, 65, 41));
		btnModificar.setToolTipText("Modificar Recibo");
		btnModificar.setRolloverIcon(new ImageIcon(VistaRecepcion.class.getResource("/imagenes/iconos/iconos_32x32/pencil2.png")));
		btnModificar.setIcon(new ImageIcon(VistaRecepcion.class.getResource("/imagenes/iconos/iconos_32x32/recepcionModificar.png")));
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnEliminar = new JButton("");
		panelBotones.add(btnEliminar);
		btnEliminar.setBounds(new Rectangle(0, 0, 65, 41));
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setToolTipText("Eliminar Recibo de Recepci\u00F3n");
		btnEliminar.setRolloverIcon(new ImageIcon(VistaRecepcion.class.getResource("/imagenes/iconos/iconos_32x32/busy.png")));
		btnEliminar.setIcon(new ImageIcon(VistaRecepcion.class.getResource("/imagenes/iconos/iconos_32x32/recepcionEliminar.png")));
		
		btnVaciar = new JButton("");
		panelBotones.add(btnVaciar);
		btnVaciar.setToolTipText("Vaciar campos del Formulario");
		btnVaciar.setRolloverIcon(new ImageIcon(VistaRecepcion.class.getResource("/imagenes/iconos/iconos_32x32/refresh.png")));
		btnVaciar.setIcon(new ImageIcon(VistaRecepcion.class.getResource("/imagenes/iconos/iconos_32x32/page_refresh.png")));
		btnVaciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnReporteP = new JButton("");
		panelBotones.add(btnReporteP);
		btnReporteP.setToolTipText("Reporte por pantalla");
		btnReporteP.setRolloverIcon(new ImageIcon(VistaRecepcion.class.getResource("/imagenes/iconos/iconos_32x32/application_view_detail.png")));
		btnReporteP.setIcon(new ImageIcon(VistaRecepcion.class.getResource("/imagenes/iconos/iconos_32x32/graphic-design.png")));
		btnReporteP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnCerrar = new JButton("");
		panelBotones.add(btnCerrar);
		btnCerrar.setToolTipText("Cerrar Ventana");
		btnCerrar.setRolloverIcon(new ImageIcon(VistaRecepcion.class.getResource("/imagenes/iconos/iconos_32x32/door_out.png")));
		btnCerrar.setIcon(new ImageIcon(VistaRecepcion.class.getResource("/imagenes/iconos/iconos_32x32/door.png")));
		btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JPanel panelMensaje = new JPanel();
		panelMensaje.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2, true), "Mensaje del Sistema", TitledBorder.RIGHT, TitledBorder.TOP, null, Color.BLUE));
		panelPie.add(panelMensaje, BorderLayout.NORTH);
		
		lblMensaje = new JLabel("");
		lblMensaje.setForeground(Color.RED);
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelMensaje.add(lblMensaje);
				 
		//----------------->enlaces controlador <-------------------
		ControladorVistaRecepcion eco=new ControladorVistaRecepcion(this);
		btnCerrar.addActionListener(eco);
		
		textCedula.addKeyListener(eco);
		
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}//fin constructor

	public JTextField getTextNrecibo() {
		return textNrecibo;
	}

	public JTextField getTextFechaRecibo() {
		return textFechaRecibo;
	}

	public JTextField getTextHoraRecibo() {
		return textHoraRecibo;
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

	public JTextField getTextCorreo() {
		return textCorreo;
	}

	public JTextField getTextUsuario() {
		return textUsuario;
	}

	public DefaultTableModel getDatosArtefactos() {
		return datosArtefactos;
	}

	public JTable getTablaArtefactos() {
		return tablaArtefactos;
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

	public JButton getBtnReporteP() {
		return btnReporteP;
	}

	public JButton getBtnVaciar() {
		return btnVaciar;
	}

	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	public JLabel getLblMensaje() {
		return lblMensaje;
	}

	public Usuario getRegistroUsuario() {
		return registroUsuario;
	}
	

}//fin de la clase
