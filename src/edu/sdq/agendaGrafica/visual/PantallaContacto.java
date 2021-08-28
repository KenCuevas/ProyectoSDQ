package edu.sdq.agendaGrafica.visual;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import edu.sdq.agendaGrafica.Modelo.Modelo;
import edu.sdq.agendaGrafica.entidad.Contacto;
import javax.swing.JTextField;
import java.awt.Button;

public class PantallaContacto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblContactos;
	Modelo modelo = new Modelo();
	private final TextField txtNombre = new TextField();
	private JTextField txtApellido;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaContacto frame = new PantallaContacto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaContacto() {
		setTitle("Pantalla Inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(Login.bloquearSistema == 1) {
			txtNombre.setEnabled(false);
			txtApellido.setEnabled(false);
			//btnEliminar.setEnabled(false);
			//btnGuardar.setEnabled(false);
			//button.setEnabled(false);
		}
		
		setBounds(100, 100, 860, 591);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		tblContactos = new JTable();
		tblContactos.setBounds(46, 161, 501, 322);
		contentPane.add(tblContactos);
		tblContactos.setModel(modelo);

		
		

		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(46, 62, 46, 14);
		contentPane.add(lblNombre);
		txtNombre.setBounds(106, 54, 186, 22);
		contentPane.add(txtNombre);
		
		Label lblApellido = new Label("Apellido");
		lblApellido.setBounds(44, 98, 62, 22);
		contentPane.add(lblApellido);
		txtApellido = new JTextField();
		txtApellido.setBounds(106, 98, 186, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		//Boton para guardar data
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.agregarDatos(new Contacto(txtNombre.getText(), txtApellido.getText()));
			}
		});
		
		//Boton para eliminar datos del Jtable
		btnGuardar.setBounds(348, 62, 155, 58);
		contentPane.add(btnGuardar);
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.eliminarDatos(tblContactos.getSelectedRow());
			}
		});
		btnEliminar.setBounds(583, 271, 122, 47);
		contentPane.add(btnEliminar);

		
	}
}
