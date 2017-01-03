package vistasReportes;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controladoresBD.SqlBD;
import controladoresVistas.ControladorVistaReporteClientesPP;
import controladoresVistas.ControladorVistaReporteRepuestosPP;
import modelos.Cliente;
import modelos.Repuesto;
import vistas.VistaLogin;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;

import java.awt.Toolkit;

public class VistaReporteClientesPP extends JDialog {

	private JButton btnPdf, btnRetornar;
	private JTable tablaRepuestos;

	JScrollPane scrollPane;
	
	private DefaultTableModel datosTabla;


	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { VistaAsignaturasRP dialog = new
	 * VistaAsignaturasRP();
	 * 
	 * }
	 */

	public VistaReporteClientesPP() {
		
		setTitle("CLIENTES REGISTRADOS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaReporteClientesPP.class.getResource("/imagenes/iconos/ventilador.png")));
		setBounds(100, 100, 1113, 540);

		JLabel lblTitulo = new JLabel("REPORTE CLIENTES REGISTRADOS");
		lblTitulo.setForeground(Color.BLUE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTitulo, BorderLayout.NORTH);

		// ------------------------>
		llenarTabla(1, 0);

		// ----------------------->

		JPanel panelPie = new JPanel();
		panelPie.setBackground(Color.WHITE);
		getContentPane().add(panelPie, BorderLayout.SOUTH);
		// *********************

		
		panelPie.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panelBotonera = new JPanel();
		panelPie.add(panelBotonera);
		panelBotonera.setBackground(Color.GRAY);

		btnPdf = new JButton("");
		btnPdf.setRolloverIcon(new ImageIcon(VistaReporteClientesPP.class.getResource("/imagenes/iconos/iconos_32x32/old-versions.png")));
		panelBotonera.add(btnPdf);
		btnPdf.setToolTipText("Genera Reporte en PDF");
		btnPdf.setIcon(new ImageIcon(VistaReporteClientesPP.class.getResource("/imagenes/iconos/iconos_32x32/print.png")));
		btnPdf.setCursor(new Cursor(12));

		btnRetornar = new JButton("");
		btnRetornar.setRolloverIcon(new ImageIcon(VistaReporteClientesPP.class.getResource("/imagenes/iconos/iconos_32x32/door_out.png")));
		panelBotonera.add(btnRetornar);
		btnRetornar.setToolTipText("Salir del Reprote");
		btnRetornar.setIcon(
				new ImageIcon(VistaReporteClientesPP.class.getResource("/imagenes/iconos/iconos_32x32/door.png")));
		btnRetornar.setCursor(new Cursor(12));

		this.setLocationRelativeTo(null);
		// this.setAlwaysOnTop(true);

		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		// enlaces
		ControladorVistaReporteClientesPP eco = new ControladorVistaReporteClientesPP(this);
		btnRetornar.addActionListener(eco);
		btnPdf.addActionListener(eco);

		
		 

	}

	// **************>llenar tabla general<------------------------
	public void llenarTabla(int opcion, int clave) {

		Cliente registro = new Cliente();
		// datosTabla = new DefaultTableModel();

		datosTabla = new DefaultTableModel(new Object[][] {},
				new String[] { "Nro.", "DOC. IDENTIDAD", "CLIENTE", "TELÉFONO", "EMAIL" });

		String sentenciaSql = null;
		sentenciaSql = "SELECT * FROM clientes order by (cliente)";
		
		
		SqlBD codigoSql = new SqlBD();

		ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
		int c = 0, c2 = 0;
		try {

			while (consulta.next()) {
				registro.setId(consulta.getInt("id"));
				registro.setDocumentoIdentidad(consulta.getString("doc_identidad"));
				registro.setCliente(consulta.getString("cliente"));
				registro.setTelefono1(consulta.getString("telefono1"));
				registro.setCorreo(consulta.getString("email"));
				c2++;
								
				
				datosTabla.insertRow(c, new String[] {""+c2, registro.getDocumentoIdentidad(), registro.getCliente(),
						 registro.getTelefono1(), "" + registro.getCorreo()});

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		tablaRepuestos = new JTable(datosTabla);

		tablaRepuestos.setSelectionBackground(Color.LIGHT_GRAY);
		tablaRepuestos.setSelectionForeground(Color.red);
		tablaRepuestos.getColumnModel().getColumn(0).setPreferredWidth(0);
		tablaRepuestos.getColumnModel().getColumn(1).setPreferredWidth(5);
		tablaRepuestos.getColumnModel().getColumn(2).setPreferredWidth(20);
		tablaRepuestos.getColumnModel().getColumn(3).setPreferredWidth(100);

		DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		tablaRepuestos.getColumnModel().getColumn(3).setCellRenderer(Alinear);
		tablaRepuestos.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		scrollPane = new JScrollPane(tablaRepuestos);
		scrollPane.setViewportBorder(new LineBorder(Color.BLUE, 3, true));

		getContentPane().add(scrollPane, BorderLayout.CENTER);
		

	}

	// ---------------->getter <-----------

	public JButton getBtnPdf() {
		return btnPdf;
	}

	public JButton getBtnRetornar() {
		return btnRetornar;
	}

	public JTable getTablaRepuestos() {
		return tablaRepuestos;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public DefaultTableModel getDatosTabla() {
		return datosTabla;
	}



	public static void main(String[] args) {
		new VistaReporteClientesPP();
	}

}// fin de la clase
