package vistasReportes;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controladoresBD.SqlBD;
import controladoresVistas.ControladorVistaReporteRepuestosPP;

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

public class VistaReporteRepuestosPP extends JDialog {

	private JButton btnPdf, btnRetornar;
	private JTable tablaRepuestos;

	JScrollPane scrollPane;
	
	private DefaultTableModel datosTabla;
	private JButton btnGrafico;


	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { VistaAsignaturasRP dialog = new
	 * VistaAsignaturasRP();
	 * 
	 * }
	 */

	public VistaReporteRepuestosPP() {
		
		setTitle("INVENTARIO DE REPUESTOS");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VistaReporteRepuestosPP.class.getResource("/imagenes/iconos/logojams2.png")));
		setBounds(100, 100, 1113, 540);

		JLabel lblTitulo = new JLabel("INVENTARIO DE REPUESTOS");
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

		btnGrafico = new JButton("");
		btnGrafico.setRolloverIcon(new ImageIcon(VistaReporteRepuestosPP.class.getResource("/imagenes/iconos/iconos_32x32/chart_pie.png")));
		btnGrafico.setToolTipText("Gr\u00E1fico del Inventario de Repuestos");
		btnGrafico.setIcon(new ImageIcon(VistaReporteRepuestosPP.class.getResource("/imagenes/iconos/iconos_32x32/grafico.png")));
		btnGrafico.setCursor(new Cursor(12));
		panelBotonera.add(btnGrafico);

		btnPdf = new JButton("");
		btnPdf.setRolloverIcon(new ImageIcon(VistaReporteRepuestosPP.class.getResource("/imagenes/iconos/iconos_32x32/old-versions.png")));
		panelBotonera.add(btnPdf);
		btnPdf.setToolTipText("Genera Reporte en PDF");
		btnPdf.setIcon(new ImageIcon(VistaReporteRepuestosPP.class.getResource("/imagenes/iconos/iconos_32x32/print.png")));
		btnPdf.setCursor(new Cursor(12));

		btnRetornar = new JButton("");
		btnRetornar.setRolloverIcon(new ImageIcon(VistaReporteRepuestosPP.class.getResource("/imagenes/iconos/iconos_32x32/door_out.png")));
		panelBotonera.add(btnRetornar);
		btnRetornar.setToolTipText("Salir del Reprote");
		btnRetornar.setIcon(
				new ImageIcon(VistaReporteRepuestosPP.class.getResource("/imagenes/iconos/iconos_32x32/door.png")));
		btnRetornar.setCursor(new Cursor(12));

		this.setLocationRelativeTo(null);
		// this.setAlwaysOnTop(true);

		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		// enlaces
		ControladorVistaReporteRepuestosPP eco = new ControladorVistaReporteRepuestosPP(this);
		btnRetornar.addActionListener(eco);
		btnGrafico.addActionListener(eco);
		btnPdf.addActionListener(eco);

		
		 this.setAlwaysOnTop(true);

	}

	// **************>llenar tabla general<------------------------
	public void llenarTabla(int opcion, int clave) {

		Repuesto registro = new Repuesto();
		// datosTabla = new DefaultTableModel();

		datosTabla = new DefaultTableModel(new Object[][] {},
				new String[] { "CÓDIGO", "REPUESTO", "MARCA", "CANTIDAD", "PRECIO","DESCRIPCION","TIPO APARATO" });

		String sentenciaSql = null;
		sentenciaSql = "SELECT * FROM repuestos a JOIN tipos_aparato b on a.tipo_aparato_id = b.id "
				+ "order by (a.repuesto) ";
		
		System.out.println(sentenciaSql);
		SqlBD codigoSql = new SqlBD();

		ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
		int c = 0, c2 = 0;
		try {

			while (consulta.next()) {
				registro.setId(consulta.getInt("id"));
				registro.setCodigo(consulta.getString("codigo"));
				registro.setRepuesto(consulta.getString("repuesto"));
				registro.setMarca(consulta.getString("marca"));
				registro.setCantidad(consulta.getInt("cantidad"));
				registro.setPrecio_venta(consulta.getDouble("precio_venta"));
				registro.setDescripcion(consulta.getString("descripcion"));
				registro.setAparato_tipo(consulta.getString("tipo"));
								
				
				datosTabla.insertRow(c, new String[] { registro.getCodigo(), registro.getRepuesto(),
						"" + registro.getMarca(), "" + registro.getCantidad(),""+ registro.getPrecio_venta(),
						registro.getDescripcion(), registro.getAparato_tipo()});

				c2++;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		tablaRepuestos = new JTable(datosTabla);

		tablaRepuestos.setSelectionBackground(Color.LIGHT_GRAY);
		tablaRepuestos.setSelectionForeground(Color.red);
		tablaRepuestos.getColumnModel().getColumn(0).setPreferredWidth(0);
		tablaRepuestos.getColumnModel().getColumn(2).setPreferredWidth(5);
		tablaRepuestos.getColumnModel().getColumn(3).setPreferredWidth(20);
		tablaRepuestos.getColumnModel().getColumn(4).setPreferredWidth(100);

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

	public JButton getBtnGrafico() {
		return btnGrafico;
	}

	public static void main(String[] args) {
		new VistaReporteRepuestosPP();
	}

}// fin de la clase
