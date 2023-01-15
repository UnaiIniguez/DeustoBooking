package gui;

import java.awt.BorderLayout;



import java.awt.Color;


import java.awt.GridLayout;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



import com.toedter.calendar.JDateChooser;

import deustoBooking.Duenio;
import deustoBooking.Gestor;
import deustoBooking.Inmueble;
import deustoBooking.Reserva;
import deustoBooking.TipoVivienda;


public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Gestor gestor;
	
	public VentanaPrincipal(Gestor g) {
		
		this.gestor = g;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(950, 650);
		setTitle("Deusto Booking");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		

		// Creación de contenedores
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
		JPanel panelSDCentro = new JPanel(new GridLayout(1, 3, 5, 100));
		JPanel panelSuperiorIzquierda = new JPanel();

		// Creación de componentes

		JButton regisDuenio = new JButton("Hazte anfitrión");
		JButton iniSesionCl = new JButton("Ver reservas");
		JButton iniSesionAf = new JButton("Ver mis casas");
		JButton regisCliente = new JButton("Hazte cliente");
		JButton buscar = new JButton("Buscar");
		JLabel vacio1 = new JLabel("       ");
		JLabel vacio2 = new JLabel("       ");
		JLabel vacio3 = new JLabel("       ");
		JLabel vacio5 = new JLabel("     ");
		JLabel destino = new JLabel("DESTINO:");
		JTextField destinotxt = new JTextField("", 15);
		JLabel llegada = new JLabel("LLEGADA:");
		JDateChooser diaLlegada = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		JLabel salida = new JLabel("SALIDA:");
		JDateChooser diaSalida = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		JLabel lbHuespedes = new JLabel("HUESPEDES:");
		JTextField huespedes = new JTextField(5);
		
		JComboBox<String> comboBoxTipoVivienda = new JComboBox<>();
		comboBoxTipoVivienda.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Tipo de vivienda", "PISO", "CHALET", "ADOSADO", "ESTUDIO" }));

		JLabel lblImagen = new JLabel();
		ImageIcon logo = new ImageIcon(
				new ImageIcon("imagenes/imagenFondo.jpg").getImage().getScaledInstance(800, 550, Image.SCALE_DEFAULT));
		lblImagen.setIcon(logo);
		JLabel lblInferior = new JLabel("CREADO POR : UNAI ALONSO, INIGO HERNAEZ, UNAI INIGUEZ y BELTRAN SENDAGORTA");

		// Eventos

		regisCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaRegistroHuesped ventana = new VentanaRegistroHuesped(gestor);
				ventana.setVisible(true);		
				
			}
		});
		regisDuenio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VentanaRegistroAnfitrion ventana = new VentanaRegistroAnfitrion(gestor);
				ventana.setVisible(true);

			}
		});

		iniSesionCl.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaLogCliente ventanaInicio = new VentanaLogCliente(gestor);
				ventanaInicio.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				ventanaInicio.setVisible(true);

			}
		});

		iniSesionAf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				VentanaLogAnfitrion ventanaInicio = new VentanaLogAnfitrion(gestor);
				ventanaInicio.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				ventanaInicio.setVisible(true);

			}
		});
		
		
		
		
		
		buscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Inmueble> seleccionadas = new ArrayList<>();
				
				TipoVivienda tipo = null;
				
				if(comboBoxTipoVivienda.getSelectedIndex() == 1) {
					tipo = TipoVivienda.PISO;
				}else if(comboBoxTipoVivienda.getSelectedIndex() == 2) {
					tipo = TipoVivienda.CHALET;
				}else if(comboBoxTipoVivienda.getSelectedIndex() == 3) {	
					tipo = TipoVivienda.ADOSADO;
				}else if(comboBoxTipoVivienda.getSelectedIndex() == 4) {
					tipo = TipoVivienda.ESTUDIO;
				}
				
				String ubicacion = destinotxt.getText();
				Date diallegada = diaLlegada.getDate();
				Date diasalida = diaSalida.getDate();
				int h = Integer.parseInt(huespedes.getText());
						
				seleccionadas = gestor.filtrar(tipo, ubicacion, diallegada, diasalida, h);
				
				if(seleccionadas.isEmpty()) {
					System.out.println("No hay casas que cumplan esas caracteristicas:" + tipo + "-" + ubicacion + "-" + diallegada + "-" + diasalida + "-" + h);
				}else {
					VentanaPrincipalReserva ventana = new VentanaPrincipalReserva(gestor, seleccionadas);
					ventana.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					ventana.setVisible(true);
				}
				
				

			}
		});
		
		

	

		// Diseño de contenedores
		panelSDCentro.setBackground(new Color(173, 216, 230));
		panelSuperior.setBackground(new Color(173, 216, 230));
		panelSuperiorDerecho.setBackground(new Color(173, 216, 230));
		panelSuperiorIzquierda.setBackground(new Color(173, 216, 230));
		panelInferior.setBackground(new Color(173, 216, 230));

		// Contenedores dentro de contenedores

		panelCentral.add(panelCentralIzquierda, BorderLayout.WEST);
		panelCentral.add(lblImagen, BorderLayout.EAST);
		panelSuperior.add(panelSuperiorDerecho, BorderLayout.EAST);
		panelSuperior.add(panelSuperiorIzquierda, BorderLayout.WEST);
		panelSuperiorDerecho.add(panelSDCentro);
		panelCentralIzquierda.add(vacio5);
		panelCentralIzquierda.add(panelDestino);
		panelCentralIzquierda.add(panelLlegada);
		panelCentralIzquierda.add(panelSalida);
		panelCentralIzquierda.add(panelHuesped);
		panelCentralIzquierda.add(panelTipoVivienda);
		panelCentralIzquierda.add(panelBuscar);

		// Anyadir componentes a contenedores

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
		
		panelHuesped.add(lbHuespedes);
		panelHuesped.add(huespedes);
		panelBuscar.add(buscar);
		panelTipoVivienda.add(comboBoxTipoVivienda);

		panelInferior.add(lblInferior, BorderLayout.CENTER);

		// Anyadir contenedores a contenedor
		add(panelSuperior, BorderLayout.NORTH);
		add(panelCentral, BorderLayout.CENTER);
		add(panelInferior, BorderLayout.SOUTH);

		setVisible(true);
		
		
	}
}


