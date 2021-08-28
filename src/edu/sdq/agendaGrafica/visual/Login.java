package edu.sdq.agendaGrafica.visual;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	
	//Variables para acceso de administrador con libre acceso al sistema
	public static String usuario="admin";
	public static String clave="admin12345";
	
	//Variables para acceso de visitante con acceso limitado.
	public static String prueba="prueba01";
	public static String clavePrueba="prueba01";
	
	//Variables para facilitar el bloqueo de acceso a funciones segun el usuario que se registre.
	public static int bloquearSistema = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		Label lblUsuario = new Label("Usuario:");
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setBounds(10, 71, 92, 27);
		contentPane.add(lblUsuario);
		
		Label lblClave = new Label("Clave:");
		lblClave.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblClave.setBackground(Color.WHITE);
		lblClave.setBounds(10, 120, 92, 27);
		contentPane.add(lblClave);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(125, 71, 159, 27);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(125, 120, 161, 27);
		contentPane.add(txtClave);
		
		JButton btnLogin = new JButton("Ingresar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Convertimos ese string en un arreglo de char para luego recorrerlo y poder comparar con equals, ya que se convierte en un string.
				String ClaveTemp = "";
				char[]password = txtClave.getPassword();
				for(int i = 0; i<password.length;i++) {
					ClaveTemp = ClaveTemp+password[i];
				}
				//Evaluamos si los datos agregados en la pantalla de login son los de administrador
				if(txtUsuario.getText().equals(usuario) && ClaveTemp.equals(clave)) {
					bloquearSistema = 0;
					Login.this.dispose();
					new PantallaContacto().setVisible(true);
				}
				//Evaluamos si los datos agregados son de visitante
				else if(txtUsuario.getText().equals(prueba) && ClaveTemp.equals(clavePrueba)){
					bloquearSistema = 1;
					Login.this.dispose();
					new PantallaContacto().setVisible(true);

				}
				//Si ninguno de los valores de arriba son correcto saldra una ventana modal que dira: Usuario Invalido
				else {
					JOptionPane.showMessageDialog(Login.this,"Usuario invalido", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnLogin.setBounds(158, 174, 112, 49);
		contentPane.add(btnLogin);
	}
}
