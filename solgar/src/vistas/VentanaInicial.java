package vistas;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.Color;
import javax.swing.UIManager;

import controladoresVistas.ControladorVistaInicial;
import modelos.Usuario;

import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JSeparator;
import java.awt.event.InputEvent;
public class VentanaInicial extends JFrame{
	private JButton btnServicios;
	private JButton btnSalir;
	private JButton btnClientes;
	private JButton btnRecepcion;
	private JButton btnEntrega;
	private JMenuBar menuBarra;
	private JMenu mnRegistrar;
	private JMenuItem mntmClientes;
	private JMenuItem mntmUsuarios;
	private JMenuItem mntmTiposAparatos;
	private JMenuItem mntmRepuestos;
	private JMenu mnArtefactos;
	private JMenuItem mntmRecepcion;
	private JMenuItem mntmEntrega;
	private JSeparator separator;
	private JMenu mnServicios;
	private JMenuItem mntmReparar;
	private JMenuItem mntmReparados;
	private JMenu mnUtilidades;
	private JMenuItem mntmAutor;
	private JMenu mnReportes;
	private JMenuItem mntmClientesR;
	private JMenuItem mntmPendientesR;
	private JMenuItem mntmInventario_1;
	private JMenuItem mntmAyuda;
	private JMenuItem mntmSalirDelSistema;
	private JSeparator separator_1;
	private JPanel panelTitulo;
	private JLabel lblNewLabel;
	private Usuario registroUsuario;
	private JMenuItem mntmCambioDeClave;
	private JMenuItem mntmImprimirRecibo;
	private JMenu mnGraficos;
	private JMenuItem mntmTiposAparatosRecibidos;
	private JSeparator separator_2;
	private JMenuItem mntmRepuestosEnInventario;
	
	public static void main(String[] args) {
		Usuario registroUsuario=new Usuario();
		registroUsuario.setNombre("Jairo");
		registroUsuario.setApellido("Molina");
		new VentanaInicial(registroUsuario);
	}
	public VentanaInicial(Usuario registroUsuario){
		this.registroUsuario=registroUsuario;
		setTitle("Usuario:   "+this.registroUsuario.getNombre()+" "+this.registroUsuario.getApellido());
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaInicial.class.getResource("/imagenes/iconos/ventilador.png")));
		getContentPane().setBackground(SystemColor.inactiveCaption);
		
		JPanel panelFondo = new JPanel();
		panelFondo.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(panelFondo, BorderLayout.NORTH);
		
		JLabel lblLogo = new JLabel("");
		panelFondo.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/logoSologa2r.png")));
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(panelBotones, BorderLayout.CENTER);
		panelBotones.setLayout(new BorderLayout(0, 0));
		
		JPanel panelControl = new JPanel();
		panelControl.setBackground(SystemColor.inactiveCaption);
		panelBotones.add(panelControl);
		FlowLayout fl_panelControl = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panelControl.setLayout(fl_panelControl);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		panelControl.add(panel);
		
		btnClientes = new JButton("");
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setToolTipText("M\u00F3dulo Clientes");
		panel.add(btnClientes);
		btnClientes.setRolloverIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/btnCliente_2.png")));
		btnClientes.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/btnCliente_1.png")));
		
		btnRecepcion = new JButton("");
		btnRecepcion.setToolTipText("M\u00F3dulo Recepci\u00F3n de Artefactos a Reparar");
		btnRecepcion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnRecepcion);
		btnRecepcion.setRolloverIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/btnRecepecion_2.png")));
		btnRecepcion.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/btnRecepecion_1.png")));
		
		btnEntrega = new JButton("");
		btnEntrega.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEntrega.setToolTipText("M\u00F3dulo Entrega de Artefactos Reparados ");
		panel.add(btnEntrega);
		btnEntrega.setRolloverIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/btnEntrega_2.png")));
		btnEntrega.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/btnEntrega_1.png")));
		
		btnServicios = new JButton("");
		btnServicios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnServicios.setToolTipText("M\u00F3dulo de Estatus de Servicios de los Artefactos");
		panel.add(btnServicios);
		btnServicios.setRolloverIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/btnServicios_2.png")));
		btnServicios.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/btnServicios_1.png")));
		
		btnSalir = new JButton("");
		btnSalir.setToolTipText("Salir del Sistema");
		panel.add(btnSalir);
		btnSalir.setRolloverIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/btnSalir_2.png")));
		btnSalir.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/btnSalir_1.png")));
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(0, 0, 128));
		getContentPane().add(panelTitulo, BorderLayout.SOUTH);
		
		lblNewLabel = new JLabel("Sistema de Control y Seguimiento para Artefactos Electricos en Reparaci\u00F3n");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		panelTitulo.add(lblNewLabel);
		
		menuBarra = new JMenuBar();
		menuBarra.setFont(new Font("Segoe UI", Font.BOLD, 14));
		setJMenuBar(menuBarra);
		
		mnRegistrar = new JMenu("Registrar");
		mnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnRegistrar.setMnemonic(KeyEvent.VK_R);
		mnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBarra.add(mnRegistrar);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mntmClientes.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/iconos_32x32/group_add.png")));
		mntmClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmClientes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnRegistrar.add(mntmClientes);
		
		mntmUsuarios = new JMenuItem("Usuarios");
		mntmUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmUsuarios.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/iconos_32x32/hire-me.png")));
		mntmUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnRegistrar.add(mntmUsuarios);
		
		mntmTiposAparatos = new JMenuItem("Tipos de Aparatos");
		mntmTiposAparatos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmTiposAparatos.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/iconos_32x32/ventilador2.png")));
		mntmTiposAparatos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnRegistrar.add(mntmTiposAparatos);
		
		mntmRepuestos = new JMenuItem("Repuestos");
		mntmRepuestos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmRepuestos.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/iconos_32x32/basket.png")));
		mntmRepuestos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnRegistrar.add(mntmRepuestos);
		
		mnArtefactos = new JMenu("Artefactos");
		mnArtefactos.setMnemonic(KeyEvent.VK_A);
		mnArtefactos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnArtefactos.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBarra.add(mnArtefactos);
		
		mntmRecepcion = new JMenuItem("Recepci\u00F3n");
		mntmRecepcion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		mntmRecepcion.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/iconos_32x32/inconoEntregaR.png")));
		mntmRecepcion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmRecepcion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnArtefactos.add(mntmRecepcion);
		
		mntmEntrega = new JMenuItem("Entrega");
		mntmEntrega.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mntmEntrega.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmEntrega.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/iconos_32x32/inconoReciR.png")));
		mntmEntrega.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnArtefactos.add(mntmEntrega);
		
		separator = new JSeparator();
		mnArtefactos.add(separator);
		
		mnServicios = new JMenu("Servicios");
		mnServicios.setMnemonic(KeyEvent.VK_S);
		mnServicios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnServicios.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBarra.add(mnServicios);
		
		mntmReparar = new JMenuItem("Reparar");
		mntmReparar.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/iconos_32x32/config.png")));
		mntmReparar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmReparar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnServicios.add(mntmReparar);
		
		mntmReparados = new JMenuItem("Reparados");
		mntmReparados.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/iconos_32x32/check.png")));
		mntmReparados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmReparados.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnServicios.add(mntmReparados);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setMnemonic(KeyEvent.VK_E);
		mnReportes.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnReportes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBarra.add(mnReportes);
		
		mntmClientesR = new JMenuItem("Clientes");
		mntmClientesR.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/iconos_32x32/customers.png")));
		mntmClientesR.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnReportes.add(mntmClientesR);
		
		mntmPendientesR = new JMenuItem("\u00D3rdenes Pendientes");
		mntmPendientesR.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/iconos_32x32/config.png")));
		mntmPendientesR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnReportes.add(mntmPendientesR);
		
		mntmImprimirRecibo = new JMenuItem("Recibo en PDF");
		mntmImprimirRecibo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmImprimirRecibo.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/iconos_32x32/page_white_acrobat.png")));
		mnReportes.add(mntmImprimirRecibo);
		
		mntmInventario_1 = new JMenuItem("Inventario");
		mntmInventario_1.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/iconos_32x32/reports-icon2.png")));
		mntmInventario_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmInventario_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnReportes.add(mntmInventario_1);
		
		separator_2 = new JSeparator();
		mnReportes.add(separator_2);
		
		mnGraficos = new JMenu("Gr\u00E1ficos");
		mnGraficos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnGraficos.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/iconos_32x32/chart_pie.png")));
		mnReportes.add(mnGraficos);
		
		mntmTiposAparatosRecibidos = new JMenuItem("Tipos Aparatos Recibidos");
		mntmTiposAparatosRecibidos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmTiposAparatosRecibidos.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/iconos_32x32/grafico.png")));
		mnGraficos.add(mntmTiposAparatosRecibidos);
		
		mntmRepuestosEnInventario = new JMenuItem("Repuestos en Inventario");
		mntmRepuestosEnInventario.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/iconos_32x32/grafico.png")));
		mntmRepuestosEnInventario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnGraficos.add(mntmRepuestosEnInventario);
		
		mnUtilidades = new JMenu("Utilidades");
		mnUtilidades.setMnemonic(KeyEvent.VK_U);
		mnUtilidades.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnUtilidades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBarra.add(mnUtilidades);
		
		mntmAutor = new JMenuItem("Autor");
		mntmAutor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmAutor.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/iconos_32x32/comment.png")));
		mntmAutor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnUtilidades.add(mntmAutor);
		
		mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/iconos_32x32/lightbulb.png")));
		mntmAyuda.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmAyuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnUtilidades.add(mntmAyuda);
		
		mntmCambioDeClave = new JMenuItem("Cambio de Clave");
		mntmCambioDeClave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmCambioDeClave.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/iconos_32x32/key_go.png")));
		mnUtilidades.add(mntmCambioDeClave);
		
		separator_1 = new JSeparator();
		mnUtilidades.add(separator_1);
		
		mntmSalirDelSistema = new JMenuItem("Salir del Sistema");
		mntmSalirDelSistema.setIcon(new ImageIcon(VentanaInicial.class.getResource("/imagenes/iconos/salir.png")));
		mntmSalirDelSistema.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmSalirDelSistema.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmSalirDelSistema.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_Q, ActionEvent.CTRL_MASK)); 
		mnUtilidades.add(mntmSalirDelSistema);
		
		//------------>control de usuario<------------
		if(registroUsuario.getNivel_usuario()==2){
			mntmUsuarios.setEnabled(false);
			mntmRepuestos.setEnabled(false);
			mntmTiposAparatos.setEnabled(false);
		}
		
		//------------->enlaces <-----------------------------
		ControladorVistaInicial eco=new ControladorVistaInicial(this);
		
		btnSalir.addActionListener(eco);
		btnRecepcion.addActionListener(eco);
		btnClientes.addActionListener(eco);
		btnServicios.addActionListener(eco);
	
		
		mntmSalirDelSistema.addActionListener(eco);
		mntmUsuarios.addActionListener(eco);
		mntmClientes.addActionListener(eco);
		mntmRepuestos.addActionListener(eco);
		mntmCambioDeClave.addActionListener(eco);
		mntmTiposAparatos.addActionListener(eco);
		mntmRecepcion.addActionListener(eco);
		mntmInventario_1.addActionListener(eco);
		mntmImprimirRecibo.addActionListener(eco);
		mntmTiposAparatosRecibidos.addActionListener(eco);
		mntmRepuestosEnInventario.addActionListener(eco);
		mntmReparar.addActionListener(eco);
		
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);//maximar automaticamente
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//this.setResizable(false);
		
		
		
		this.setVisible(true);
	}//fin constructor


	public JButton getBtnServicios() {
		return btnServicios;
	}


	public JButton getBtnSalir() {
		return btnSalir;
	}


	public JButton getBtnClientes() {
		return btnClientes;
	}


	public JButton getBtnRecepcion() {
		return btnRecepcion;
	}


	public JButton getBtnEntrega() {
		return btnEntrega;
	}


	public JMenuBar getMenuBarra() {
		return menuBarra;
	}


	public JMenu getMnRegistrar() {
		return mnRegistrar;
	}


	public JMenuItem getMntmClientes() {
		return mntmClientes;
	}


	public JMenuItem getMntmUsuarios() {
		return mntmUsuarios;
	}


	public JMenuItem getMntmTiposAparatos() {
		return mntmTiposAparatos;
	}


	public JMenuItem getMntmRepuestos() {
		return mntmRepuestos;
	}


	public JMenu getMnArtefactos() {
		return mnArtefactos;
	}


	public JMenuItem getMntmRecepcion() {
		return mntmRecepcion;
	}


	public JMenuItem getMntmEntrega() {
		return mntmEntrega;
	}


	

	public JMenu getMnServicios() {
		return mnServicios;
	}


	public JMenuItem getMntmPendientes() {
		return mntmReparar;
	}




	public JMenuItem getMntmReparados() {
		return mntmReparados;
	}


	public JMenu getMnUtilidades() {
		return mnUtilidades;
	}


	public JMenuItem getMntmAutor() {
		return mntmAutor;
	}


	public JMenu getMnReportes() {
		return mnReportes;
	}


	public JMenuItem getMntmClientesR() {
		return mntmClientesR;
	}


	public JMenuItem getMntmPendientesR() {
		return mntmPendientesR;
	}


	public JMenuItem getMntmInventario_1() {
		return mntmInventario_1;
	}


	public JMenuItem getMntmAyuda() {
		return mntmAyuda;
	}


	public JMenuItem getMntmSalirDelSistema() {
		return mntmSalirDelSistema;
	}





	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
	public JMenu getMnGraficos() {
		return mnGraficos;
	}
	public JMenuItem getMntmTiposAparatosRecibidos() {
		return mntmTiposAparatosRecibidos;
	}
	public Usuario getRegistroUsuario() {
		return registroUsuario;
	}


	public JSeparator getSeparator() {
		return separator;
	}


	public JSeparator getSeparator_1() {
		return separator_1;
	}


	public JPanel getPanelTitulo() {
		return panelTitulo;
	}


	public JMenuItem getMntmCambioDeClave() {
		return mntmCambioDeClave;
	}
	public JMenuItem getMntmImprimirRecibo() {
		return mntmImprimirRecibo;
	}
	public JMenuItem getMntmRepuestosEnInventario() {
		return mntmRepuestosEnInventario;
	}
	

	
}//fin de la clase
