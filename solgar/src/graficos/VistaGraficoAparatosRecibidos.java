package graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.data.category.DefaultCategoryDataset;

import com.toedter.calendar.JDateChooser;

import controladoresBD.SqlBD;
import controladoresVistas.ControladorVistaGraficoAparatosRecibidos;
import modelos.Grafico;
import modelos.GraficoBarra;

import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Color;

public class VistaGraficoAparatosRecibidos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JDateChooser fecha1,fecha2;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			VistaGraficoAparatosRecibidos dialog = new VistaGraficoAparatosRecibidos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public VistaGraficoAparatosRecibidos(String fecha1,String fecha2) {
		this.setSize(800, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelCabecera = new JPanel();
			contentPanel.add(panelCabecera, BorderLayout.NORTH);
			{
				JLabel lblTipoDeAparatos = new JLabel("TIPO DE APARATOS RECIBIDOS   ");
				lblTipoDeAparatos.setForeground(Color.BLUE);
				lblTipoDeAparatos.setFont(new Font("Tahoma", Font.BOLD, 16));
				panelCabecera.add(lblTipoDeAparatos);
				
				
				
			}
			
		}
		{
			JPanel panelGrafico = new JPanel();
			
			contentPanel.add(panelGrafico, BorderLayout.CENTER);
			String sentenciaSql="SELECT *,count(a.id) as subTotal FROM reparaciones a  "
					+ "join  recepciones b on a.recepcion_id = b.id "
					+ "join tipos_aparato c on a.tipo_aparato_id= c.id "
					+ "WHERE b.fecha_recepcion BETWEEN '"+fecha1+"' and '"+fecha2
					+ "' GROUP BY a.tipo_aparato_id";
			
			
			SqlBD codigoSql = new SqlBD();

			ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
			DefaultCategoryDataset datos = new DefaultCategoryDataset();
			int valor;
			String nombre;
			try {
				while (consulta.next()) {
					valor=consulta.getInt("subTotal");
					nombre=consulta.getString("c.tipo");
					
					datos.addValue(valor, nombre, "");
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
			Grafico data=new Grafico();
			data.setTitulo("Aparatos por Tipo Recibido por fecha");
			data.setAbcisa("Tipo de Aparatos");
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
		ControladorVistaGraficoAparatosRecibidos eco=new ControladorVistaGraficoAparatosRecibidos(this);
		btnCerrar.addActionListener(eco);
		
		
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
