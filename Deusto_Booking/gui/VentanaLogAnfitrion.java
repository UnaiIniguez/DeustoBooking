package gui;

import javax.swing.*;

import deustoBooking.Duenio;
import deustoBooking.Gestor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class VentanaLogAnfitrion extends JFrame {

	private static final long serialVersionUID = 1L;

	Gestor g;
	JPasswordField pfContrasenya;
	JTextField txtUsuario;
	JLabel lbUusario;
	JLabel lbContrasenya;
	
	
	public VentanaLogAnfitrion(Gestor gestor) {

		g = gestor;

		// Especificaciones de ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Inicio de sesión");
		setLocationRelativeTo(null);
		setLayout(new GridLayout(5, 1));
		setSize(300, 450);

		// Creación de contenedores
		JPanel panelIcono = new JPanel(new FlowLayout());
		JPanel panelUsuario = new JPanel(new FlowLayout());
		JPanel panelContrasenya = new JPanel(new FlowLayout());
		JPanel panelError = new JPanel();
		JPanel panelIniciar = new JPanel(new FlowLayout());

		// Icono de Deusto Booking
		ImageIcon logo = new ImageIcon(
				new ImageIcon("imagenes/icono.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		JLabel icono = new JLabel();
		icono.setIcon(logo);
		panelIcono.add(icono);
		panelIcono.setBackground(new Color(173, 216, 230));

		// Textfield de usuario
		txtUsuario = new JTextField(10);
		// txtUsuario.setText("Introduccir DNI");
		lbUusario = new JLabel("DNI:");
		txtUsuario.setForeground(Color.BLACK);
		panelUsuario.add(lbUusario);
		panelUsuario.add(txtUsuario);
		panelUsuario.setBackground(new Color(173, 216, 230));

		// Textfield de contrasenya
		pfContrasenya = new JPasswordField(12);
		lbContrasenya = new JLabel("Contrasena:");
		panelContrasenya.add(lbContrasenya);
		panelContrasenya.add(pfContrasenya);
		panelContrasenya.setBackground(new Color(173, 216, 230));

		// Boton de login
		JButton btnLogin = new JButton("Iniciar como anfitrion");
		btnLogin.setSize(200, 100);
		btnLogin.setLocation(300, 200);
		panelIniciar.add(btnLogin);
		panelIniciar.setBackground(new Color(173, 216, 230));


		// Label de error
		JLabel error = new JLabel("Contraseña o usuario erroneo");
		error.setVisible(false);
		panelError.setBackground(new Color(173, 216, 230));
		ImageIcon logoError = new ImageIcon(
				new ImageIcon("imagenes/error_img.jpg").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		error.setIcon(logoError);
		panelError.add(error);

		// Pendiente de terminar

		// Anyadir los contenedores
		add(panelIcono);
		add(panelUsuario);
		add(panelContrasenya);
		add(panelError);
		add(panelIniciar);

		// Eventos de ventana
		pfContrasenya.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == 10) {
					String dni = txtUsuario.getText();
					String contrasenya = pfContrasenya.getText();
					if (gestor.buscarDuenio(dni, contrasenya) == false) {
						error.setVisible(true);
					}else {
						//Meter la ventana
					}
				}
			}

		});

		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String dni = txtUsuario.getText();
				String contrasenya = pfContrasenya.getText();

				if (gestor.buscarDuenio(dni, contrasenya) == false) {
					error.setVisible(true);
				}else {
					//Meter la ventana
				}

			}
		});

	}

}
