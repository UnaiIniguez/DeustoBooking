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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import deustoBooking.Duenio;
import deustoBooking.Gestor;
import deustoBooking.Inmueble;
import deustoBooking.TipoVivienda;

public class VentanaRegistroAnfitrion extends JFrame {
	
	
	private Gestor gestor;
	
	private JTextField txtDNI = new JTextField(12);
	private JTextField txtNombre = new JTextField(12);
	private JTextField txtApellido = new JTextField(12);
	private JTextField txtpuesto = new JTextField(12);
	private JTextField txtTelefono = new JTextField(12);
	private JPasswordField txtContrasenya = new JPasswordField(12);
	private JTextField txtEdad = new JTextField(7);
	private JTextField txtmetros = new JTextField(12);
	private JTextField txtUbicacion= new JTextField(12);
	private JTextField txtPrecio = new JTextField(12);
	private JTextField txtCorreo = new JTextField(12);
	private JTextField txtMaxHuespedes = new JTextField(5);
	
	

	public VentanaRegistroAnfitrion(Gestor g) {
		
		this.gestor = g;
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(700, 500);
		setLocationRelativeTo(null);
		setTitle("Registro dueño");
		

		setLayout(new BorderLayout());

		// Creación de contenedores
		JPanel panelInferior = new JPanel();
		JPanel panelCentral = new JPanel(new GridLayout(8, 4));
		JPanel panelSuperior = new JPanel(new FlowLayout());

		JPanel panelDNI = new JPanel();
		JPanel panelNombre = new JPanel();
		JPanel panelApellido = new JPanel();
		JPanel panelTrabajo = new JPanel();
		JPanel panelTelefono = new JPanel();
		JPanel panelContrasenya = new JPanel();
		JPanel panelEdad = new JPanel();
		JPanel panelMetros = new JPanel();
		JPanel panelServicios = new JPanel();
		JPanel panelOcupacion = new JPanel();
		JPanel panelUbicacion = new JPanel();
		JPanel panelTipoVivienda = new JPanel();
		JPanel panelPrecio = new JPanel();
		JPanel panelImagenes = new JPanel();
		JPanel panelCorreo = new JPanel();

		// Creación de objetos
		JButton botonRegistrar = new JButton("Registrarse");
		JButton imagen1 = new JButton("1");
		JButton imagen2 = new JButton("2");
		JButton imagen3 = new JButton("3");
		JButton imagen4 = new JButton("4");
		
		
		JLabel lbDNI = new JLabel("DNI:");
		JLabel lbNombre = new JLabel("Nombre:");
		JLabel lbApellidos = new JLabel("Apellidos:");
		JLabel lbPuestoDeTrabajo = new JLabel("Puesto de trabajo:");
		JLabel lbTelefono = new JLabel("Teléfono:");
		JLabel lbContrasenya = new JLabel( "Contraseña:" );
		JLabel lbEdad = new JLabel("Edad: ");
		JLabel lbMetros2 = new JLabel("Metros cuadrados:");
		JLabel lbNumHabi = new JLabel("N. Habitaciones:");
		JLabel lbNumBan = new JLabel("N. baños:");
		JLabel lbNumHues = new JLabel( "Num. Huespedes:" );
		JLabel lbOcupacion = new JLabel( "Ocupacion:" ); 
		JLabel lbUbicacion = new JLabel("Ubicacion:");
		JLabel lbTipoVivienda = new JLabel("Tipo de vivienda:");
		JLabel lbPrecio = new JLabel( " Precio por noche: " );
		JLabel lbImagenes = new JLabel("Imagenes:");
		JLabel lbCorreo = new JLabel("Gmail: ");
		JLabel lbDatosPer = new JLabel("DATOS PERSONALES ");
		JLabel lbVivienda = new JLabel("PRIMERA VIVIENDA");
		JLabel lbEspacio = new JLabel("                                            ");
		//Asignaciond el numero de Habitaciones
		JComboBox<String> boxHabi = new JComboBox<>();
		boxHabi.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
		//Asignacion del numero de Baños
		JComboBox<String> boxBan = new JComboBox<>();
		boxBan.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		//Asignacion del tipo de vivienda
		JComboBox<String> boxTipoVivienda = new JComboBox<>();
		boxTipoVivienda.setModel(new DefaultComboBoxModel(new String[] { "Tipo de vivienda", "PISO", "CHALET", "ADOSADO", "ESTUDIO" }));
		//Asignacion de si esta ocupado o no (1: ocupado, 0: disponible)
		JComboBox<String> boxOcupacion = new JComboBox<>();
		boxOcupacion.setModel( new DefaultComboBoxModel( new String[] { "NO", "SI" }));

		
		// Añadir los objetos a los paneles
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
		panelOcupacion.add(lbNumHues);
		panelOcupacion.add(txtMaxHuespedes);
		panelOcupacion.add(lbOcupacion);
		panelOcupacion.add(boxOcupacion);
		panelUbicacion.add(lbUbicacion);
		panelUbicacion.add(txtUbicacion);
		panelTipoVivienda.add(lbTipoVivienda);
		panelTipoVivienda.add(boxTipoVivienda);
		panelPrecio.add(lbPrecio);
		panelPrecio.add(txtPrecio);
		panelEdad.add(lbEdad);
		panelEdad.add(txtEdad);
		panelImagenes.add(imagen1);
		panelImagenes.add(imagen2);
		panelImagenes.add(imagen3);
		panelImagenes.add(imagen4);
		panelCorreo.add(lbCorreo);
		panelCorreo.add(txtCorreo);
		
		// Insertar paneles en paneles
		panelInferior.add(botonRegistrar);
		panelCentral.add(panelDNI);
		panelCentral.add(panelMetros);
		panelCentral.add(panelContrasenya);
		panelCentral.add(panelOcupacion);
		panelCentral.add(panelNombre);
		panelCentral.add(panelServicios);
		panelCentral.add(panelApellido);
		panelCentral.add(panelUbicacion);
		panelCentral.add(panelTelefono);
		panelCentral.add(panelTipoVivienda);
		panelCentral.add(panelTrabajo);
		panelCentral.add(panelPrecio);
		panelCentral.add(panelEdad);
		panelCentral.add(lbImagenes);
		panelCentral.add(panelCorreo);
		panelCentral.add(panelImagenes);

		panelSuperior.add(lbDatosPer);
		panelSuperior.add(lbEspacio);
		panelSuperior.add(lbVivienda);

		// Cambiar color del fondo

		panelSuperior.setBackground(new Color(173, 216, 230));
		panelInferior.setBackground(new Color(173, 216, 230));

		// Accion del boton registrar
		
		botonRegistrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Añado un nuevo Duenyo
					
					
					Duenio nuevoDuenio = new Duenio();
					nuevoDuenio.setDni(txtDNI.getText().toString());
					nuevoDuenio.setCargo(txtpuesto.getText().toString());
					nuevoDuenio.setContrasenya(txtContrasenya.getText().toString()); //Introducir campo para contrase�a
					nuevoDuenio.setEdad(Integer.parseInt(txtEdad.getText())); 
					nuevoDuenio.setNombre(txtNombre.getText());
					nuevoDuenio.setTlfNum(txtTelefono.getText());
					nuevoDuenio.setMail(txtCorreo.getText());
					
					//Añado un nuevo Inmueble
					Inmueble nuevoInmueble = new Inmueble();
					nuevoInmueble.setPrecioNoche( Float.parseFloat( txtPrecio.getText().toString() ) );
					nuevoInmueble.setMaxHuespedes( Integer.parseInt (txtMaxHuespedes.getText().toString() ) );
					if(boxOcupacion.getSelectedItem().toString() == "NO") {
						nuevoInmueble.setOcupado(0);
					}else {
						nuevoInmueble.setOcupado(1);
					}
					nuevoInmueble.setNumHab( Integer.parseInt( boxHabi.getSelectedItem().toString() ) );
					nuevoInmueble.setNumBany( Integer.parseInt (boxBan.getSelectedItem().toString() ) );
					nuevoInmueble.setUbicacion( txtUbicacion.getText().toString() );
					nuevoInmueble.setTipo( tipoVivienda(boxTipoVivienda.getSelectedItem().toString()));
					nuevoInmueble.setMetrosCuadrados( Float.parseFloat( txtmetros.getText().toString() ) );
					
					
					gestor.anyadirDuenio(nuevoDuenio);
					gestor.anadirInmueble(nuevoInmueble);	
				
				
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
