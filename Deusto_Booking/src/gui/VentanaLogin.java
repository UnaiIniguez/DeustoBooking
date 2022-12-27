package gui;

import javax.swing.*;

import deustoBooking.Gestor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VentanaLogin extends JFrame {



	Gestor g;
	JPasswordField pfContrasenya;
	JTextField txtUsuario;
	
	public VentanaLogin(Gestor gestor) {
	
		
	g = gestor;
	
	//Especificaciones de ventana
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("Inicio de sesión");
	setLocationRelativeTo(null);
	setLayout(new GridLayout(4,1));
	setSize(300,450);
	
	//Creación de contenedores
	JPanel panel1 = new	JPanel(new FlowLayout());
	JPanel panel2 = new	JPanel(new FlowLayout());
	JPanel panel3 = new	JPanel(new FlowLayout());
	JPanel panel4 = new	JPanel(new FlowLayout());
	
	
	//Icono de Deusto Booking
	ImageIcon logo = new ImageIcon(new ImageIcon("imagenes/icono.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
	JLabel icono = new JLabel();
	icono.setIcon(logo);
	panel1.add(icono);
	panel1.setBackground(new Color(173, 216, 230));

	//Textfield de usuario
	txtUsuario = new JTextField(15);
	txtUsuario.setText("Nombre de usuario");
	txtUsuario.setForeground(Color.GRAY);
	panel2.add(txtUsuario);
	panel2.setBackground(new Color(173, 216, 230));
	
	//Textfield de contrasenya
	pfContrasenya = new JPasswordField(15);
	panel3.add(pfContrasenya);
	panel3.setBackground(new Color(173, 216, 230));
	
	//Boton de login
	JButton btnLogin = new JButton("Iniciar sesión");
	btnLogin.setSize(200,100);
	btnLogin.setLocation(300, 200);
	panel4.add(btnLogin);
	panel4.setBackground(new Color(173, 216, 230));
	
	final JButton BTNLOGIN = btnLogin;
	SwingUtilities.invokeLater(new Runnable() {
		
		@Override
		public void run() {
			BTNLOGIN.requestFocus();
			
		}
	});
	
	
	

	//Anyadir los contenedores 
	add(panel1);
	add(panel2);
	add(panel3);
	add(panel4);
	
	
	//Eventos de ventana
	pfContrasenya.addKeyListener(new KeyAdapter() {
		
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == 10 || BTNLOGIN.isSelected()) {
				if (g.iniSesion(txtUsuario.getText(), pfContrasenya.getText()) == true) {
					System.out.println("Inicio de sesion correcto");
					dispose();	
				}else {
					System.out.println("Inicio de sesion incorrecto");
				}
				

			}
			
		}
	});
	
	
	txtUsuario.addFocusListener(new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) {
			txtUsuario.setText("Nombre de Usuario");
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			txtUsuario.setText(null);		
		}
	});
	
	}
	
}