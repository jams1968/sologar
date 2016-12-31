package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JOptionPane;

import graficos.VistaGraficoAparatosRecibidos;
import vistas.VistaRangoFecha;

public class ControladorVistaRangoFechas implements ActionListener {
	
	private VistaRangoFecha vista;
	
	public ControladorVistaRangoFechas(VistaRangoFecha vista) {
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent accion) {
		if (accion.getSource().equals(vista.getCancelButton()))
			vista.dispose();
		else if(accion.getSource().equals(vista.getOkButton())&&
				(vista.getFecha1().getDate()!=null)&&(vista.getFecha2().getDate()!=null)){
			if(vista.getFecha1().getDate().before(vista.getFecha2().getDate())){
				String dia=Integer.toString(vista.getFecha1().getCalendar().get(Calendar.DAY_OF_MONTH));
				String mes=Integer.toString(vista.getFecha1().getCalendar().get(Calendar.MONTH)+1);
				String anno=Integer.toString(vista.getFecha1().getCalendar().get(Calendar.YEAR));
				String fecha1=""+anno+"/"+mes+"/"+dia;
				
				dia=Integer.toString(vista.getFecha2().getCalendar().get(Calendar.DAY_OF_MONTH));
				mes=Integer.toString(vista.getFecha2().getCalendar().get(Calendar.MONTH)+1);
				anno=Integer.toString(vista.getFecha2().getCalendar().get(Calendar.YEAR));
				String fecha2=""+anno+"/"+mes+"/"+dia;
				
				new VistaGraficoAparatosRecibidos(fecha1,fecha2);
			}else
				JOptionPane.showMessageDialog(vista, "rango incongruente");
			
		}
			
		
	}
	
	

}
