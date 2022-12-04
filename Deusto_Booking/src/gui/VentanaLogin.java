package gui;

import javax.swing.*;

import deustoBooking.Gestor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	setLayout(new GridLayout(5,1));
	setSize(300,450);
	
	//Creación de contenedores
	JPanel panel1 = new	JPanel(new FlowLayout());
	JPanel panel2 = new	JPanel(new FlowLayout());
	JPanel panel3 = new	JPanel(new FlowLayout());
	JPanel panel4 = new	JPanel(new FlowLayout());
	JPanel panel5 = new	JPanel(new FlowLayout());
	JPanel panel6 = new JPanel(new FlowLayout());
	
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
	panel4.add(pfContrasenya);
	panel4.setBackground(new Color(173, 216, 230));
	
	//Boton de login
	JButton btnLogin = new JButton("Iniciar sesión");
	btnLogin.setSize(200,100);
	btnLogin.setLocation(300, 200);
	panel5.add(btnLogin);
	panel5.setBackground(new Color(173, 216, 230));
	
	//Boton de registrarse
	JButton btnRegistrarse = new JButton("Registrar cliente");
	panel6.add(btnRegistrarse);
	panel6.setBackground(new Color(173, 216, 230));
	

	//Anyadir los contenedores 
	add(panel1);
	add(panel2);
	add(panel4);
	add(panel5);
	add(panel6);
	
	
	//Eventos de ventana
	pfContrasenya.addKeyListener(new KeyAdapter() {
		
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == 10) {
				if (txtUsuario.getText().equals("cliente") && pfContrasenya.getText().equals("cliente")) {
					
					VentanaPrincipal ventana = new VentanaPrincipal(g);
					ventana.setVisible(true);
					dispose();	
				}
				

			}
			
		}
	});
	
	btnLogin.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			VentanaPrincipal ventana = new VentanaPrincipal(g);
			ventana.setVisible(true);
			dispose();	
			
		}
	});
	
	btnRegistrarse.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			VentanaRegistroHuesped ventana = new VentanaRegistroHuesped();
			ventana.setVisible(true);
			dispose();
			
		}
	});
		
		
	}

	
}