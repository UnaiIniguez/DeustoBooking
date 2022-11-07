package GUI;


import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;



public class VentanaPrincipal extends JFrame{

	
	
	public VentanaPrincipal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(950, 650);
		setTitle("Deusto Booking");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		//Creación de contenedores
		JPanel panelCentral = new JPanel(new BorderLayout());
		JPanel panelCentralIzquierda = new JPanel();
		panelCentralIzquierda.setLayout(new BoxLayout(panelCentralIzquierda, BoxLayout.Y_AXIS));
		JPanel panelDestino = new JPanel();
		JPanel panelLlegada = new JPanel();
		JPanel panelSalida = new JPanel();
		JPanel panelHuesped = new JPanel();
		JPanel panelInferior = new JPanel();
		JPanel panelSuperior = new JPanel(new BorderLayout());	
		JPanel panelSuperiorDerecho = new JPanel(new BorderLayout());
		JPanel panelSDCentro = new JPanel( new GridLayout(1 , 2, 5 , 100));
		JPanel panelSuperiorIzquierda = new JPanel();
		
		
		//Creación de componentes
		
		JButton anfitrion = new JButton("Hazte anfitrión");
		JButton iniSesion = new JButton("Iniciar sesion");
		JLabel vacio1 = new JLabel("       ");
		JLabel vacio2 = new JLabel("       ");
		JLabel vacio3 = new JLabel("       ");	
		JLabel vacio4 = new JLabel(" ");	
		JLabel vacio5 = new JLabel("     ");
		JLabel destino = new JLabel("DESTINO:");
		JTextField Destinotxt = new JTextField("", 15);
		JLabel llegada = new JLabel("LLEGADA:");
		JTextField Llegadatxt = new JTextField("", 15);
		JLabel salida = new JLabel("SALIDA:");
		JTextField Salidatxt = new JTextField("", 15);
		JLabel numhuespedes = new JLabel("NÚMERO DE HUESPEDES:");
		JComboBox ComboBoxHuespedes = new JComboBox();
		ComboBoxHuespedes.setModel(new DefaultComboBoxModel(new String[] {"1", "2","3","4","5","6","7+"}));
		
		
		JLabel lblImagen = new JLabel();
		lblImagen.setIcon(new ImageIcon("img/Casa_Fondo.jpg"));
		JLabel lblInferior = new JLabel("CREADO POR : UNAI ALONSO, IÑIGO HERNAEZ, UNAI IÑIGUEZ y BELTRÁN SENDAGORTA");
		
		//Diseño de contenedores
		panelSDCentro.setBackground(SystemColor.activeCaption);
		panelSuperior.setBackground(SystemColor.activeCaption);
		panelSuperiorDerecho.setBackground(SystemColor.activeCaption);
		panelSuperiorIzquierda.setBackground(SystemColor.activeCaption);
		panelInferior.setBackground(SystemColor.activeCaption);
		panelCentral.setBackground(Color.WHITE);
		
		//Contenedores dentro de contenedores
		
		panelCentral.add(panelCentralIzquierda,  BorderLayout.WEST);
		panelCentral.add(lblImagen, BorderLayout.EAST);
		panelSuperior.add(panelSuperiorDerecho, BorderLayout.EAST);
		panelSuperior.add(panelSuperiorIzquierda,BorderLayout.WEST);
		panelSuperiorDerecho.add(panelSDCentro);
		panelCentralIzquierda.add(vacio5);
		panelCentralIzquierda.add(panelDestino);
		panelCentralIzquierda.add(panelLlegada);
		panelCentralIzquierda.add(panelSalida);
		panelCentralIzquierda.add(panelHuesped);
		
		
		//Anyadir componentes a contenedores
		
		panelSuperiorDerecho.add(vacio1, BorderLayout.EAST);
		panelSuperiorDerecho.add(vacio2, BorderLayout.SOUTH);
		panelSuperiorDerecho.add(vacio3, BorderLayout.NORTH);
		
		panelSDCentro.add(iniSesion);
		panelSDCentro.add(anfitrion);
		
		panelDestino.add(destino);
		panelDestino.add(Destinotxt);
		panelSalida.add(salida);
		panelSalida.add(Salidatxt);
		panelLlegada.add(llegada);
		panelLlegada.add(Llegadatxt);
		panelHuesped.add(numhuespedes);
		panelHuesped.add(vacio4);
		panelHuesped.add(ComboBoxHuespedes);
		
		panelInferior.add(lblInferior, BorderLayout.CENTER);
		
		
		//Anyadir contenedores a contenedor
		add(panelSuperior, BorderLayout.NORTH);
		add(panelCentral, BorderLayout.CENTER);
		add(panelInferior, BorderLayout.SOUTH);
		
		
		
		setVisible(true);
	}
	
	
	
	
	
	
	 public static void main(String args[]) {
		new VentanaPrincipal();
	}
}

