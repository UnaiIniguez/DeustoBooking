package gui;


import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import deustoBooking.Gestor;



public class VentanaPrincipal extends JFrame{
	
	private Gestor gestor;
	
	
	public VentanaPrincipal(Gestor g) {
		
		this.gestor = g;
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
		JPanel panelBuscar = new JPanel();
		JPanel panelTipoVivienda = new JPanel();
		
		JPanel panelInferior = new JPanel();
		JPanel panelSuperior = new JPanel(new BorderLayout());	
		JPanel panelSuperiorDerecho = new JPanel(new BorderLayout());
		JPanel panelSDCentro = new JPanel( new GridLayout(1 , 3, 5 , 100));
		JPanel panelSuperiorIzquierda = new JPanel();
		
		
		//Creación de componentes
		
		JButton regisDuenio = new JButton("Hazte anfitrión");
		JButton iniSesionCl = new JButton("Iniciar como cliente");
		JButton iniSesionAf = new JButton("Iniciar como anfitrión");
		JButton regisCliente = new JButton("Hazte cliente");
		JButton buscar = new JButton("Buscar");
		JLabel vacio1 = new JLabel("       ");
		JLabel vacio2 = new JLabel("       ");
		JLabel vacio3 = new JLabel("       ");	
		JLabel vacio4 = new JLabel(" ");	
		JLabel vacio5 = new JLabel("     ");
		JLabel destino = new JLabel("DESTINO:");
		JTextField destinotxt = new JTextField("", 15);
		JLabel llegada = new JLabel("LLEGADA:");
		JDateChooser diaLlegada = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		JLabel salida = new JLabel("SALIDA:");
		JDateChooser diaSalida = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		JLabel numhuespedes = new JLabel("NÚMERO DE HUESPEDES:");
		JComboBox comboBoxHuespedes = new JComboBox();
		comboBoxHuespedes.setModel(new DefaultComboBoxModel(new String[] {"1", "2","3","4","5","6","7+"}));
		JComboBox comboBoxTipoVivienda = new JComboBox();
		comboBoxTipoVivienda.setModel(new DefaultComboBoxModel(new String[] {"Tipo de vivienda", "PISO", "CHALET","ADOSADO", "ESTUDIO"}));
		
		
		JLabel lblImagen = new JLabel();
		ImageIcon logo = new ImageIcon(new ImageIcon("imagenes/imagenFondo.jpg").getImage().getScaledInstance(800,550, Image.SCALE_DEFAULT));
		lblImagen.setIcon(logo);
		JLabel lblInferior = new JLabel("CREADO POR : UNAI ALONSO, INIGO HERNAEZ, UNAI INIGUEZ y BELTRAN SENDAGORTA");
		
		
		
		
		//Eventos
		
		regisDuenio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VentanaRegistroAnfitrion ventana = new VentanaRegistroAnfitrion(gestor.getPropietarios());
				ventana.setVisible(true);
				
				
			}
		});
		
		iniSesionCl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaLogin ventanaInicio = new VentanaLogin(gestor);
				ventanaInicio.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				ventanaInicio.setVisible(true);
				
			}
		});
		
		iniSesionAf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaLogin ventanaInicio = new VentanaLogin(gestor);
				ventanaInicio.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				ventanaInicio.setVisible(true);	
				
			}
		});
		
		buscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				VisualizarInmuebles ventana = new VisualizarInmuebles(gestor);
				ventana.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				ventana.setVisible(true);
				
				
			}
		});
		
		//Diseño de contenedores
		panelSDCentro.setBackground(new Color(173, 216, 230));
		panelSuperior.setBackground(new Color(173, 216, 230));
		panelSuperiorDerecho.setBackground(new Color(173, 216, 230));
		panelSuperiorIzquierda.setBackground(new Color(173, 216, 230));
		panelInferior.setBackground(new Color(173, 216, 230));
		
		
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
		panelCentralIzquierda.add(panelTipoVivienda);
		panelCentralIzquierda.add(panelBuscar);
		
		
		
		//Anyadir componentes a contenedores
		
		panelSuperiorDerecho.add(vacio1, BorderLayout.EAST);
		panelSuperiorDerecho.add(vacio2, BorderLayout.SOUTH);
		panelSuperiorDerecho.add(vacio3, BorderLayout.NORTH);
		
		panelSDCentro.add(iniSesionCl);
		panelSDCentro.add(regisCliente);
		panelSDCentro.add(iniSesionAf);
		panelSDCentro.add(regisDuenio);
		
		
		panelDestino.add(destino);
		panelDestino.add(destinotxt);
		panelSalida.add(salida);
		panelSalida.add(diaSalida);
		panelLlegada.add(llegada);
		panelLlegada.add(diaLlegada);
		panelHuesped.add(numhuespedes);
		panelHuesped.add(vacio4);
		panelHuesped.add(comboBoxHuespedes);
		panelBuscar.add(buscar);
		panelTipoVivienda.add(comboBoxTipoVivienda);
		
		panelInferior.add(lblInferior, BorderLayout.CENTER);
		
		
		//Anyadir contenedores a contenedor
		add(panelSuperior, BorderLayout.NORTH);
		add(panelCentral, BorderLayout.CENTER);
		add(panelInferior, BorderLayout.SOUTH);
		
		
		
		setVisible(true);
	}
	
	
	
	
	
	
	 
}


