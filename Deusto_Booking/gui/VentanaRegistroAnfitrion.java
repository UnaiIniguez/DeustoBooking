package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import deustoBooking.Duenio;
import deustoBooking.Gestor;
import deustoBooking.Inmueble;
import deustoBooking.TipoVivienda;

public class VentanaRegistroAnfitrion extends JFrame {
	
	private static JTextField txtDNI = new JTextField(12);
	private static JTextField txtNombre = new JTextField(12);
	private static JTextField txtApellido = new JTextField(12);
	private static JTextField txtpuesto = new JTextField(12);
	private static JTextField txtTelefono = new JTextField(12);
	private static JTextField txtContrasenya = new JTextField(12);
	private static JTextField txtmetros = new JTextField(12);
	private static JTextField txtUbicacion= new JTextField(12);
	private static JTextField txtPrecio = new JTextField(12);
	private static JTextField txtMaxHuespedes = new JTextField(10);
	
	JComboBox boxHabi = new JComboBox();
	JComboBox boxBan = new JComboBox();
	JComboBox comboBoxTipoVivienda = new JComboBox();
	JComboBox boxOcupacion = new JComboBox();

	public VentanaRegistroAnfitrion() {

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(700, 500);
		setLocationRelativeTo(null);
		setTitle("Registro duenyo");
		

		setLayout(new BorderLayout());

		// Creación de contenedores
		JPanel panelInferior = new JPanel();
		JPanel panelCentral = new JPanel(new GridLayout(6, 4));
		JPanel panelSuperior = new JPanel(new FlowLayout());

		JPanel panelDNI = new JPanel();
		JPanel panelNombre = new JPanel();
		JPanel panelApellido = new JPanel();
		JPanel panelTrabajo = new JPanel();
		JPanel panelTelefono = new JPanel();
		JPanel panelContrasenya = new JPanel();
		JPanel panelMetros = new JPanel();
		JPanel panelServicios = new JPanel();
		JPanel panelUbicacion = new JPanel();
		JPanel panelTipoVivienda = new JPanel();
		JPanel panelPrecio = new JPanel();

		// Creación de objetos
		JButton botonRegistrar = new JButton("Registrarse");

		JLabel lbDNI = new JLabel("DNI:");
		JLabel lbNombre = new JLabel("Nombre:");
		JLabel lbApellidos = new JLabel("Apellidos:");
		JLabel lbPuestoDeTrabajo = new JLabel("Puesto de trabajo:");
		JLabel lbTelefono = new JLabel("Teléfono:");
		JLabel lbContrasenya = new JLabel( "Contrase�a" );
		JLabel lbMetros2 = new JLabel("Metros cuadrados:");
		JLabel lbNumHabi = new JLabel("N. Habitaciones:");
		JLabel lbNumBan = new JLabel("N. baños:");
		JLabel lbNumHues = new JLabel( "N. Huespedes" );
		JLabel lbOcupacion = new JLabel( "Ocupacion" ); 
		JLabel lbUbicacion = new JLabel("Ubicacion:");
		JLabel lbTipoVivienda = new JLabel("Tipo de vivienda:");
		JLabel lbPrecio = new JLabel( " Precio por noche " );
		JLabel lbDatosPer = new JLabel("DATOS PERSONALES ");
		JLabel lbVivienda = new JLabel("PRIMERA VIVIENDA");
		JLabel lbEspacio = new JLabel("                                            ");

		
		
		//Asignaciond el numero de Habitaciones
		
		boxHabi.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "+" }));
		
		//Asignacion del numero de Ba�os
		
		boxBan.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "+" }));
		
		//Asignacion del tipo de vivienda
		comboBoxTipoVivienda.setModel(new DefaultComboBoxModel(new String[] { "Tipo de vivienda", "PISO", "CHALET", "ADOSADO", "ESTUDIO" }));
		
		//Asignacion de si esta ocupado o no (1: ocupado, 0: disponible)
		
		boxOcupacion.setModel( new DefaultComboBoxModel( new String[] { "0", "1" }));

		// Anyadir los objetos a los paneles
		panelDNI.add(lbDNI);
		panelDNI.add(txtDNI);
		panelNombre.add(lbNombre);
		panelNombre.add(txtNombre);
		panelApellido.add(lbApellidos);
		panelApellido.add(txtApellido);
		panelTrabajo.add(lbPuestoDeTrabajo);
		panelTrabajo.add(txtpuesto);
		panelTelefono.add(lbTelefono);
		panelTelefono.add(txtTelefono);
		panelContrasenya.add(lbContrasenya);
		panelContrasenya.add(txtContrasenya);
		panelMetros.add(lbMetros2);
		panelMetros.add(txtmetros);
		panelServicios.add(lbNumBan);
		panelServicios.add(boxBan);
		panelServicios.add(lbNumHabi);
		panelServicios.add(boxHabi);
		panelServicios.add(txtMaxHuespedes);
		panelServicios.add(lbNumHues);
		panelServicios.add(lbOcupacion);
		panelServicios.add(boxOcupacion);
		panelUbicacion.add(lbUbicacion);
		panelUbicacion.add(txtUbicacion);
		panelTipoVivienda.add(lbTipoVivienda);
		panelTipoVivienda.add(comboBoxTipoVivienda);
		panelPrecio.add(txtPrecio);
		panelPrecio.add(lbPrecio);

		// Insertar paneles en paneles
		panelInferior.add(botonRegistrar);
		panelCentral.add(panelDNI);
		panelCentral.add(panelMetros);
		panelCentral.add(panelNombre);
		panelCentral.add(panelServicios);
		panelCentral.add(panelApellido);
		panelCentral.add(panelUbicacion);
		panelCentral.add(panelTelefono);
		panelCentral.add(panelUbicacion);
		panelCentral.add(panelTrabajo);
		panelCentral.add(panelTipoVivienda);
		panelCentral.add(panelContrasenya);
		panelCentral.add(panelPrecio);

		panelSuperior.add(lbDatosPer);
		panelSuperior.add(lbEspacio);
		panelSuperior.add(lbVivienda);

		// Cambiar color del fondo

		panelSuperior.setBackground(new Color(173, 216, 230));
		panelInferior.setBackground(new Color(173, 216, 230));

		// Acci�n del bot�n registrar
		
		botonRegistrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//A�ado un nuevo Duenyo
				Duenio nuevoDuenio = new Duenio();
				nuevoDuenio.setDni(txtDNI.getText().toString());
				nuevoDuenio.setCargo(txtpuesto.getText().toString());
				nuevoDuenio.setContrasenya(txtContrasenya.getText().toString()); //Introducir campo para contrase�a
				//nuevoDuenio.setEdad(txt); Introducir campo para edad
				//nuevoDuenio.setMail(txt); Introducir campo para email
				nuevoDuenio.setNombre(txtNombre.getText().toString());
				nuevoDuenio.setTlfNum(txtTelefono.getText().toString());
				
				//A�ado un nuevo Inmueble
				Inmueble nuevoInmueble = new Inmueble();
				nuevoInmueble.setPrecioNoche( Float.parseFloat( txtPrecio.getText().toString() ) );
				nuevoInmueble.setMaxHuespedes( Integer.parseInt (txtMaxHuespedes.getText().toString() ) );
				nuevoInmueble.setOcupado( Integer.parseInt( boxOcupacion.getSelectedItem().toString() ) );
				nuevoInmueble.setNumHab( Integer.parseInt( boxHabi.getSelectedItem().toString() ) );
				nuevoInmueble.setNumBany( Integer.parseInt (boxBan.getSelectedItem().toString() ) );
				nuevoInmueble.setUbicacion( txtUbicacion.getText().toString() );
				nuevoInmueble.setTipo( tipoVivienda(comboBoxTipoVivienda.getSelectedItem().toString()));
				nuevoInmueble.setMetrosCuadrados( Float.parseFloat( txtmetros.getText().toString() ) );
				nuevoInmueble.setDuenio( nuevoDuenio );
				
				
				System.out.println(nuevoDuenio);
				System.out.println(nuevoInmueble);
				
				Gestor.getPropietarios().add(nuevoDuenio);
				Gestor.getInmuebles().add(nuevoInmueble);
				
				Gestor.setChangedP(true);
				Gestor.setChangedI(true);
				
				dispose();
			}
		});

		// Insertar paneles en la ventana
		add(panelSuperior, BorderLayout.NORTH);
		add(panelCentral, BorderLayout.CENTER);
		add(panelInferior, BorderLayout.SOUTH);

	}
	
	private static TipoVivienda tipoVivienda(String tipo) {
		switch (tipo) {
		case "CHALET":
			return TipoVivienda.CHALET;

		case "PISO":
			return TipoVivienda.PISO;

		case "ADOSADO":
			return TipoVivienda.ADOSADO;

		case "ESTUDIO":
			return TipoVivienda.ESTUDIO;

		}
		return null;
	}


}