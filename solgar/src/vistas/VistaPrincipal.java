package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JSeparator;

public class VistaPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuItem mnReg_Clientes;
	private JMenuItem mnReg_Usuarios;
	private JMenuItem mnReg_TipoAparatos;
	private JMenuItem mnReg_Repuestos;
	private JButton btnClientes;
	private JButton btnRecepcion;
	private JButton btnSalir;
	private JMenuItem mntmPendientes;
	private JMenuItem mntmNewMenuItem_2;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		//setResizable(false);
		setTitle("Control y Seguimiento de Artefactos Electricos en Reparaci\u00F3n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaPrincipal.class.getResource("/imagenes/iconos/iconos_32x32/lightbulb.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 810, 600);
		this.setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.BLUE, 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(633, 567, 788, 113);
		contentPane.add(layeredPane);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(UIManager.getColor("Tree.selectionBackground"));
		panelPrincipal.setBounds(10, 5, 769, 101);
		layeredPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		btnClientes = new JButton("");
		btnClientes.setToolTipText("Modulo Clientes");
		btnClientes.setBounds(10, 11, 141, 81);
		panelPrincipal.add(btnClientes);
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setRolloverIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/iconos/btnCliente2.png")));
		btnClientes.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/iconos/btnCliente1.png")));
		
		btnRecepcion = new JButton("");
		btnRecepcion.setToolTipText("M\u00F3dulo Recepci\u00F3n de Equipos");
		btnRecepcion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRecepcion.setRolloverIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/iconos/recepcion2.png")));
		btnRecepcion.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/iconos/recepcion1.png")));
		btnRecepcion.setBounds(161, 11, 141, 81);
		panelPrincipal.add(btnRecepcion);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("M\u00F3dulo Entrega de Equipos");
		btnNewButton.setRolloverIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/iconos/entrega2.png")));
		btnNewButton.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/iconos/entrega1.png")));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(312, 11, 141, 81);
		panelPrincipal.add(btnNewButton);
		
		JButton btnServicios = new JButton("");
		btnServicios.setToolTipText("M\u00F3dulo de Servicios");
		btnServicios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnServicios.setRolloverIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/iconos/servicios2.png")));
		btnServicios.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/iconos/servicios1.png")));
		btnServicios.setBounds(463, 11, 141, 81);
		panelPrincipal.add(btnServicios);
		
		btnSalir = new JButton("");
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setRolloverIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/iconos/salirV11.png")));
		btnSalir.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/iconos/salirR11.png")));
		btnSalir.setToolTipText("Salir del Sistema");
		btnSalir.setBounds(614, 11, 141, 81);
		panelPrincipal.add(btnSalir);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/solgar.png")));
		lblNewLabel.setBounds(0, 27, 1586, 799);
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(0, 0, 1596, 27);
		contentPane.add(menuBar);
		
		JMenu mnRegistrar = new JMenu("Registrar");
		mnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnRegistrar.setMnemonic('R');
		mnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnRegistrar);
		
		mnReg_Clientes = new JMenuItem("Clientes");
		mnReg_Clientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnRegistrar.add(mnReg_Clientes);
		
		mnReg_Usuarios = new JMenuItem("Usuarios del Sistema");
		mnReg_Usuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnRegistrar.add(mnReg_Usuarios);
		
		mnReg_TipoAparatos = new JMenuItem("Tipos de Aparatos");
		mnReg_TipoAparatos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnRegistrar.add(mnReg_TipoAparatos);
		
		mnReg_Repuestos = new JMenuItem("Registrar Repuestos");
		mnReg_Repuestos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnRegistrar.add(mnReg_Repuestos);
		
		JMenu mnOperaciones = new JMenu("Operaciones");
		mnOperaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnOperaciones.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnOperaciones);
		
		JMenuItem mntmRecepcinDeArtefacto = new JMenuItem("Recepci\u00F3n de Artefactos");
		mntmRecepcinDeArtefacto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnOperaciones.add(mntmRecepcinDeArtefacto);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Entrega de Artefactos");
		mntmNewMenuItem_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnOperaciones.add(mntmNewMenuItem_1);
		
		JSeparator separator = new JSeparator();
		mnOperaciones.add(separator);
		
		JMenuItem mntmDevolucion = new JMenuItem("Devoluci\u00F3n de Artefactos");
		mntmDevolucion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnOperaciones.add(mntmDevolucion);
		
		JMenu mnServicios = new JMenu("Servicios");
		mnServicios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnServicios.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnServicios);
		
		mntmPendientes = new JMenuItem("Artefactos Pendientes");
		mntmPendientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnServicios.add(mntmPendientes);
		
		mntmNewMenuItem_2 = new JMenuItem("Artefactos Reparados");
		mntmNewMenuItem_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnServicios.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Utilidad");
		mnNewMenu_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmQuienesSomos = new JMenuItem("Quienes Somos");
		mntmQuienesSomos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNewMenu_2.add(mntmQuienesSomos);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmAyuda.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/iconos/iconos_16x16/lightbulb.png")));
		mnNewMenu_2.add(mntmAyuda);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Salir del Sistema");
		mntmNewMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmNewMenuItem.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/iconos/iconos_16x16/sign-out.png")));
		mnNewMenu_2.add(mntmNewMenuItem);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
