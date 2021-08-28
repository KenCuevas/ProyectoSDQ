package edu.sdq.agendaGrafica;


import edu.sdq.agendaGrafica.visual.Login;

public class Sistema {

	public static void main(String[] args) {
		//Llamamos a nuestra clase Login y la hacemos visible para que la ejecucion del sistema comience desde el login.
		new Login().setVisible(true);
	}

}
