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

public class VentanaLogCliente extends JFrame {



	Gestor g;
	JPasswordField pfContrasenya;
	JTextField txtUsuario;
	
	public VentanaLogCliente(Gestor gestor) {
	
		
	g = gestor;
	
	//Especificaciones de ventana
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("Inicio de sesión");
	setLocationRelativeTo(null);
	setLayout(new GridLayout(5,1));
	setSize(300,450);
	
	//Creación de contenedores
	JPanel panel1 = new	JPanel(new FlowLayout());
	JPanel panel2 = new	JPanel(new FlowLayout());
	JPanel panel3 = new	JPanel(new FlowLayout());
	JPanel panel4 = new	JPanel(new FlowLayout());
	JPanel panelError = new JPanel();
	
	//Icono de Deusto Booking
	ImageIcon logo = new ImageIcon(new ImageIcon("imagenes/icono.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
	JLabel icono = new JLabel();
	icono.setIcon(logo);
	panel1.add(icono);
	panel1.setBackground(new Color(173, 216, 230));

	//Textfield de usuario
	txtUsuario = new JTextField(15);
	txtUsuario.setText("Introduccir DNI");
	txtUsuario.setForeground(Color.GRAY);
	panel2.add(txtUsuario);
	panel2.setBackground(new Color(173, 216, 230));
	
	//Textfield de contrasenya
	pfContrasenya = new JPasswordField(15);
	panel3.add(pfContrasenya);
	panel3.setBackground(new Color(173, 216, 230));
	
	//Boton de login
	JButton btnLogin = new JButton("Iniciar como cliente");
	btnLogin.setSize(200,100);
	btnLogin.setLocation(300, 200);
	panel4.add(btnLogin);
	panel4.setBackground(new Color(173, 216, 230));
	
	final JButton BTNLOGIN = btnLogin;
	
	// Texto de error 
	JLabel error = new JLabel("Contraseña o usuario erroneo");
	error.setVisible(false);
	panelError.add(error);
	panelError.setBackground(new Color(173, 216, 230));
	
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
	add(panelError);
	add(panel4);
	
	
	
	//Eventos de ventana
	pfContrasenya.addKeyListener(new KeyAdapter() {
		
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == 10) {
				String dni = txtUsuario.getText();
				String contrasenya = pfContrasenya.getText();
				if(gestor.buscarDuenio(dni, contrasenya) == false) {
					error.setVisible(true);
				}
			}
		}
			
		
	});
	
	
	txtUsuario.addFocusListener(new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) {
			txtUsuario.setText(null);
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			txtUsuario.setText(null);		
		}
	});
	
	btnLogin.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
			String dni = txtUsuario.getText();
			String contrasenya = pfContrasenya.getText();
			
			if(gestor.buscarDuenio(dni, contrasenya) == false) {
				error.setVisible(true);
			}
			
			
		}
	});
	
	}
	
}