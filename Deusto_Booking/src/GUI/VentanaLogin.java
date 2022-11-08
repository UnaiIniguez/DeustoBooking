package GUI;

import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JFrame {

	public static final Color SKYBLUE = new Color(51, 133, 255);

	public VentanaLogin() {
	JPanel panel1 = new	JPanel(new FlowLayout());
	JPanel panel2 = new	JPanel(new FlowLayout());
	JPanel panel3 = new	JPanel(new FlowLayout());
	JPanel panel4 = new	JPanel(new FlowLayout());
	
	//Icono de Deusto Booking
	ImageIcon logo = new ImageIcon(new ImageIcon("imagenes/icono.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
	JLabel icono = new JLabel();
	icono.setIcon(logo);
	panel1.add(icono);
	panel1.setBackground(SKYBLUE);

	//Textfield de usuario
	JTextField txtUsuario = new JTextField(15);
	panel2.add(txtUsuario);
	panel2.setBackground(SKYBLUE);

	//Textfield de contrasenya
	JPasswordField pfContrasenya = new JPasswordField(15);
	panel3.add(pfContrasenya);
	panel3.setBackground(SKYBLUE);
	
	//Boton de login
	JButton btnLogin = new JButton("Iniciar sesión");
	btnLogin.setSize(200,100);
	btnLogin.setLocation(300, 200);
	panel4.add(btnLogin);
	panel4.setBackground(SKYBLUE);
	
	//Especificaciones de ventana
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("Inicio de sesión");
	setLocationRelativeTo(null);
	setLayout(new GridLayout(4,1));
	setSize(300,400);
	add(panel1);
	add(panel2);
	add(panel3);
	add(panel4);
		
		
	}

	public static void main(String[] args) {
		new VentanaLogin().setVisible(true);
		
	}
}