package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaRegistroAnfitrion extends JFrame{
	
	
	public VentanaRegistroAnfitrion() {
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(700, 500);
		setLocationRelativeTo(null);
		setTitle("Registro duenyo");
		
		setLayout(new BorderLayout());
		
		
		//Creación de contenedores
		JPanel panelInferior = new JPanel();
		JPanel panelCentral = new JPanel(new GridLayout(5, 4));
		JPanel panelSuperior = new JPanel(new FlowLayout());
		
		
		JPanel panelDNI = new JPanel();
		JPanel panelNombre = new JPanel();
		JPanel panelApellido = new JPanel();
		JPanel panelTrabajo = new JPanel();
		JPanel panelTelefono = new JPanel();
		JPanel panelMetros = new JPanel();
		JPanel panelServicios = new JPanel();
		JPanel panelLocalidad = new JPanel();
		JPanel panelDireccion = new JPanel();
		JPanel panelTipoVivienda = new JPanel();
		
		
		//Creación de objetos
		JButton botonRegistrar = new JButton("Registrarse");
		
		JLabel lbDNI = new JLabel("DNI:");
		JLabel lbNombre = new JLabel("Nombre:");
		JLabel lbApellidos = new JLabel("Apellidos:");
		JLabel lbPuestoDeTrabajo = new JLabel("Puesto de trabajo:");
		JLabel lbTelefono = new JLabel("Teléfono:");
		JLabel lbMetros2 = new JLabel("Metros cuadrados:");
		JLabel lbNumHabi = new JLabel("N. Habitaciones:");
		JLabel lbNumBan = new JLabel("N. baños:");
		JLabel lbLocalidad = new JLabel("Localidad:");
		JLabel lbDireccion = new JLabel("Dirección:");
		JLabel lbTipoVivienda = new JLabel("Tipo de vivienda:");
		JLabel lbDatosPer = new JLabel("DATOS PERSONALES ");
		JLabel lbVivienda = new JLabel("PRIMERA VIVIENDA");
		JLabel lbEspacio = new JLabel("                                            ");
		
		
		JTextField txtDNI = new JTextField(12);
		JTextField txtNombre = new JTextField(12);
		JTextField txtApellido = new JTextField(12);
		JTextField txtpuesto = new JTextField(12);
		JTextField txtTelefono = new JTextField(12);
		JTextField txtmetros = new JTextField(12);
		JComboBox boxHabi = new JComboBox();
		boxHabi.setModel(new DefaultComboBoxModel(new String[] {"1", "2","3","4", "+"}));
		JComboBox boxBan = new JComboBox();
		boxBan.setModel(new DefaultComboBoxModel(new String[] {"1", "2","3","+"}));
		JTextField txtLocalidad = new JTextField(12);
		JTextField txtDireccion = new JTextField(12);
		JComboBox comboBoxTipoVivienda = new JComboBox();
		comboBoxTipoVivienda.setModel(new DefaultComboBoxModel(new String[] {"Tipo de vivienda", "PISO", "CHALET","ADOSADO", "ESTUDIO"}));
		
	
		//Anyadir los objetos a los paneles 
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
		panelMetros.add(lbMetros2);
		panelMetros.add(txtmetros);
		panelServicios.add(lbNumBan);
		panelServicios.add(boxBan);
		panelServicios.add(lbNumHabi);
		panelServicios.add(boxHabi);
		panelLocalidad.add(lbLocalidad);
		panelLocalidad.add(txtLocalidad);
		panelDireccion.add(lbDireccion);
		panelDireccion.add(txtDireccion);
		panelTipoVivienda.add(lbTipoVivienda);
		panelTipoVivienda.add(comboBoxTipoVivienda);
		
		
		//Insertar paneles en paneles 
		panelInferior.add(botonRegistrar);
		panelCentral.add(panelDNI);
		panelCentral.add(panelMetros);
		panelCentral.add(panelNombre);
		panelCentral.add(panelServicios);
		panelCentral.add(panelApellido);
		panelCentral.add(panelLocalidad);
		panelCentral.add(panelTelefono);
		panelCentral.add(panelDireccion);
		panelCentral.add(panelTrabajo);
		panelCentral.add(panelTipoVivienda);
		
		
		panelSuperior.add(lbDatosPer);
		panelSuperior.add(lbEspacio);
		panelSuperior.add(lbVivienda);
		
		//Cambiar color del fondo
		
		panelSuperior.setBackground(new Color(173, 216, 230));
		panelInferior.setBackground(new Color(173, 216, 230));
		
		//Insertar paneles en la ventana
		add(panelSuperior, BorderLayout.NORTH);
		add(panelCentral, BorderLayout.CENTER);
		add(panelInferior, BorderLayout.SOUTH);
	
	}
	
	
}


