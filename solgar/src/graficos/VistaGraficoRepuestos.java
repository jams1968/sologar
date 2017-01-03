package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.data.category.DefaultCategoryDataset;

import com.toedter.calendar.JDateChooser;

import controladoresBD.SqlBD;
import controladoresVistas.ControladorVistaGraficoAparatosRecibidos;
import controladoresVistas.ControladorVistaGraficoRepuestos;
import librerias.Funciones;
import modelos.Grafico;
import modelos.GraficoBarra;

public class VistaGraficoRepuestos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JDateChooser fecha1,fecha2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VistaGraficoRepuestos dialog = new VistaGraficoRepuestos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VistaGraficoRepuestos() {
		this.setSize(800, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			Funciones funcion=new Funciones();
			
		}
		{
			JPanel panelGrafico = new JPanel();
			
			contentPanel.add(panelGrafico, BorderLayout.CENTER);
			String sentenciaSql="SELECT repuesto,sum(cantidad) as subTotal FROM repuestos GROUP by codigo";
			
			
			SqlBD codigoSql = new SqlBD();

			ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
			DefaultCategoryDataset datos = new DefaultCategoryDataset();
			int valor;
			String nombre;
			try {
				while (consulta.next()) {
					valor=consulta.getInt("subTotal");
					nombre=consulta.getString("repuesto");
					
					datos.addValue(valor, nombre, "");
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
			Grafico data=new Grafico();
			data.setTitulo("Cantidad por  Repuestos en el Inventario");
			data.setAbcisa("Repuestos");
			data.setOrdenada("Cantidad");
			data.setOrientacion(1);
			data.setData(datos);
			data.setLeyenda(true);
			data.setEtiqueta(true);
			
			GraficoBarra graficador=new GraficoBarra(data);
			
			
			panelGrafico.add(graficador);
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnCerrar = new JButton("");
				btnCerrar.setRolloverIcon(new ImageIcon(VistaGraficoAparatosRecibidos.class.getResource("/imagenes/iconos/iconos_32x32/door_out.png")));
				btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnCerrar.setToolTipText("Cerrar Ventana");
				btnCerrar.setIcon(new ImageIcon(VistaGraficoAparatosRecibidos.class.getResource("/imagenes/iconos/iconos_32x32/door.png")));
				btnCerrar.setActionCommand("Cancel");
				buttonPane.add(btnCerrar);
			}
		}
		
		//------------>enlaces <---------------
		ControladorVistaGraficoRepuestos eco=new ControladorVistaGraficoRepuestos(this);
		btnCerrar.addActionListener(eco);
		
		this.isAlwaysOnTop();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}//fin del constructor

	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	public JDateChooser getFecha1() {
		return fecha1;
	}

	public JDateChooser getFecha2() {
		return fecha2;
	}
	

}//fin de la clase
