package edu.sdq.agendaGrafica.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.sdq.agendaGrafica.entidad.Contacto;

public class Conexion {
private Connection con;
private Statement statement;
public PreparedStatement psInsertar;
	
	public Conexion(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost/agendaSDQ?user=root&password=");
			statement = con.createStatement();
			
	} catch(ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	//Metodo para agregar los datos al jtable y actualizar la base de datos OPTIMIZADO
	public void agregarData(Contacto contacto) {
		try {
			psInsertar = con.prepareStatement("Insert into persona (Nombre, Apellido)values(?,?)");
			psInsertar.setString(1,contacto.getNombre() );
			psInsertar.setString(2,contacto.getApellido() );
			psInsertar.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//Funcion para eliminar los datos del Jtable en conjunto con la base de datos.
	public void eliminarData (int IdPersonas){
		try {
			statement.execute("delete from persona where IdPersonas=" +IdPersonas);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Metodo para mostrar los datos insertado en el jtable
	public ArrayList<Contacto> mostrarData(){
		ArrayList<Contacto>listaDeContactos = new ArrayList<Contacto>();
		ResultSet resultado = null;
		
		
		try {
			resultado = statement.executeQuery("Select IdPersonas, Nombre, Apellido from persona");
			
			while(resultado.next()) {
				listaDeContactos.add(new Contacto(resultado.getInt("IdPersonas"),resultado.getString("Nombre"),resultado.getString("Apellido")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listaDeContactos;
	
	}
}
