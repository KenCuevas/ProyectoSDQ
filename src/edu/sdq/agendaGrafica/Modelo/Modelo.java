package edu.sdq.agendaGrafica.Modelo;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import edu.sdq.agendaGrafica.entidad.Contacto;
import edu.sdq.agendaGrafica.persistencia.Conexion;

public class Modelo extends AbstractTableModel {
	
	
	private static final long serialVersionUID = 1L;
	ArrayList<Contacto>listadoContactos = null;
	Conexion conexion = new Conexion();
	
	
	//En este array se muestran los encabezados que tendra la JTABLE
	String[] titulos ={"Id", "Nombres", "Apellidos"};


	//Constructor para agregar los datos
	public Modelo() {
		listadoContactos = conexion.mostrarData();
	}
	 
	
	@Override
	public String getColumnName(int column) {
		return titulos[column];
	}
	
	
	//Metodo para eliminar datos de la tabla
	public void eliminarDatos(int fila) {
		conexion.eliminarData(listadoContactos.get(fila).getIdPersonas());
		listadoContactos.remove(fila);
		fireTableRowsDeleted (fila, fila);
	}
	
	//Metodo para agregar datos a la Jtable desde la Base de datos
	public void agregarDatos(Contacto contacto) {
		conexion.agregarData(contacto);
		listadoContactos = conexion.mostrarData();
		fireTableDataChanged();
	}

	//Metodo para obtener el numero de columnas
	@Override
	public int getColumnCount() {
		return titulos.length;
	}
	//Metodo que nos otorga el numero de filas que tendra el Jtable
	@Override
	public int getRowCount() {
		return listadoContactos.size();
	}

	@Override
	public Object getValueAt(int x, int y) {
		Object retorno = null;
		
		Contacto contacto = listadoContactos.get(x);
		
		
		//Con este switch lo que hacemos es evaluar las columnas y filas y segun corresponda la posicion insertara el Id, nombre o el apellido desde la Base de datos.
		switch(y) {
		case 0:
			retorno = contacto.getIdPersonas();
			break;
		case 1:
			retorno = contacto.getNombre();
			break;
		case 2:
			retorno = contacto.getApellido();
			break;
		}

		
		return retorno;
	}
	

}
