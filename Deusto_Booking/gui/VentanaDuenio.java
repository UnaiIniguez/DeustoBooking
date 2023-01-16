package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controlBD.GestorBD;
import deustoBooking.Gestor;
import deustoBooking.Inmueble;
import deustoBooking.TipoVivienda;

public class VentanaDuenio extends JFrame {

	private Gestor gestor;

	private static JTextField txtID = new JTextField(12);
	private JTextField txtmetros = new JTextField(12);
	private JTextField txtUbicacion = new JTextField(12);
	private JTextField txtPrecio = new JTextField(12);
	private JTextField txtMaxHuespedes = new JTextField(5);

	public VentanaDuenio(Gestor g, String dni) {
		// TODO Auto-generated constructor stub

		this.gestor = g;

		Set<Inmueble> setInmuebles = g.getInmuebles();

		List<Inmueble> listaInmueble = null;

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(700, 500);
		setLocationRelativeTo(null);
		setTitle("Registro dueño");

		setLayout(new BorderLayout());

		// Creación de contenedores

		JPanel panelInferior = new JPanel();
		JPanel panelDerecho = new JPanel(new GridLayout(8, 4));
		JPanel panelIzquierdo = new JPanel(new GridLayout(8, 4));
		JPanel panelSuperior = new JPanel(new FlowLayout());

		JPanel panelElementos_Inmueble = new JPanel();
		JPanel panelTablas_Usuario = new JPanel();
		JPanel panelDuenio = new JPanel();
		JPanel panelInmueble = new JPanel();

		DefaultTableModel modelo_Usuario = new DefaultTableModel();

		modelo_Usuario.addColumn("ID");
		modelo_Usuario.addColumn("Ubicacion");

		JTable tabla_Usuario = new JTable(modelo_Usuario);

		JScrollPane scrollTabla_Usuario = new JScrollPane(tabla_Usuario);

		// Cargo los datos de los Inmuebles:

		for (Inmueble i : setInmuebles) {

			if (i.getDni_Duenio() == dni) {

				listaInmueble = new ArrayList<>(setInmuebles);

			}

		}
		if (listaInmueble != null) {
			for (int i = 0; i < listaInmueble.size(); i++) {
				Object[] fila = new Object[2];
				fila[0] = listaInmueble.get(i).getId_Inmueble();
				fila[1] = listaInmueble.get(i).getUbicacion();
				modelo_Usuario.addRow(fila);

			}
		}

		tabla_Usuario.updateUI();
		scrollTabla_Usuario.setViewportView(tabla_Usuario);

		JButton botonEliminar = new JButton("Eliminar");
		JButton botonEditar = new JButton("Editar Estado");
		JButton botonAnyadir = new JButton("A�adir");

		JLabel lbMetros2 = new JLabel("Metros cuadrados:");
		JLabel lbNumHabi = new JLabel("N. Habitaciones:");
		JLabel lbNumBan = new JLabel("N. baños:");
		JLabel lbNumHues = new JLabel("Num. Huespedes:");
		JLabel lbOcupacion = new JLabel("Ocupacion:");
		JLabel lbUbicacion = new JLabel("Ubicacion:");
		JLabel lbTipoVivienda = new JLabel("Tipo de vivienda:");
		JLabel lbPrecio = new JLabel(" Precio por noche: ");
		JLabel lbImagenes = new JLabel("Imagenes:");

		// Asignaciond el numero de Habitaciones
		JComboBox<String> boxHabi = new JComboBox<>();
		boxHabi.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
		// Asignacion del numero de Baños
		JComboBox<String> boxBan = new JComboBox<>();
		boxBan.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		// Asignacion del tipo de vivienda
		JComboBox<String> boxTipoVivienda = new JComboBox<>();
		boxTipoVivienda.setModel(
				new DefaultComboBoxModel(new String[] { "Tipo de vivienda", "PISO", "CHALET", "ADOSADO", "ESTUDIO" }));
		// Asignacion de si esta ocupado o no (1: ocupado, 0: disponible)
		JComboBox<String> boxOcupacion = new JComboBox<>();
		boxOcupacion.setModel(new DefaultComboBoxModel(new String[] { "NO", "SI" }));

		panelElementos_Inmueble.add(lbMetros2);
		panelElementos_Inmueble.add(txtmetros);
		panelElementos_Inmueble.add(lbNumHabi);
		panelElementos_Inmueble.add(boxHabi);
		panelElementos_Inmueble.add(lbNumBan);
		panelElementos_Inmueble.add(boxBan);
		panelElementos_Inmueble.add(lbNumHues);
		panelElementos_Inmueble.add(txtMaxHuespedes);
		panelElementos_Inmueble.add(lbOcupacion);
		panelElementos_Inmueble.add(boxOcupacion);
		panelElementos_Inmueble.add(lbUbicacion);
		panelElementos_Inmueble.add(txtUbicacion);
		panelElementos_Inmueble.add(lbTipoVivienda);
		panelElementos_Inmueble.add(boxTipoVivienda);
		panelElementos_Inmueble.add(lbPrecio);
		panelElementos_Inmueble.add(txtPrecio);
		panelElementos_Inmueble.add(lbImagenes);
		panelTablas_Usuario.add(scrollTabla_Usuario);
		panelDuenio.add(botonEliminar);
		panelDuenio.add(botonEditar);
		panelInmueble.add(botonAnyadir);

		panelDerecho.add(panelElementos_Inmueble);

		panelIzquierdo.add(panelTablas_Usuario);

		panelInferior.add(panelDuenio);
		panelInferior.add(panelInmueble);

		panelSuperior.setBackground(new Color(173, 216, 230));
		panelInferior.setBackground(new Color(173, 216, 230));

		botonAnyadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// Añado un nuevo Inmueble
				if (Float.parseFloat(txtPrecio.getText()) != 0f && Integer.parseInt(txtMaxHuespedes.getText()) != 0
						&& txtUbicacion.getText() != null && Float.parseFloat(txtmetros.getText().toString()) != 0) {
					Inmueble nuevoInmueble = new Inmueble();
					nuevoInmueble.setPrecioNoche(Float.parseFloat(txtPrecio.getText().toString()));
					nuevoInmueble.setMaxHuespedes(Integer.parseInt(txtMaxHuespedes.getText().toString()));
					if (boxOcupacion.getSelectedItem().toString() == "NO") {
						nuevoInmueble.setOcupado(0);
					} else {
						nuevoInmueble.setOcupado(1);
					}
					nuevoInmueble.setNumHab(Integer.parseInt(boxHabi.getSelectedItem().toString()));
					nuevoInmueble.setNumBany(Integer.parseInt(boxBan.getSelectedItem().toString()));
					nuevoInmueble.setUbicacion(txtUbicacion.getText().toString());
					nuevoInmueble.setTipo(tipoVivienda(boxTipoVivienda.getSelectedItem().toString()));
					nuevoInmueble.setMetrosCuadrados(Float.parseFloat(txtmetros.getText().toString()));

					gestor.anadirInmueble(nuevoInmueble);

				} else {

					System.out.println("No se han rellenado todos los campos necesarios.");
				}

				dispose();

			}
		});

		botonEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		botonEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		add(panelSuperior, BorderLayout.NORTH);
		add(panelDerecho, BorderLayout.EAST);
		add(panelIzquierdo, BorderLayout.WEST);
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
