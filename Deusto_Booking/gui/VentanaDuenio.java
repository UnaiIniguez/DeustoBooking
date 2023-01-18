package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.sql.rowset.serial.SerialBlob;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import controlBD.GestorBD;
import deustoBooking.Gestor;
import deustoBooking.Inmueble;
import deustoBooking.InmuebleInexistenteException;
import deustoBooking.TipoVivienda;

public class VentanaDuenio extends JFrame {

	private Gestor gestor;

	private static JTextField txtID = new JTextField(12);
	private JTextField txtmetros = new JTextField(12);
	private JTextField txtUbicacion = new JTextField(12);
	private JTextField txtPrecio = new JTextField(12);
	private JTextField txtMaxHuespedes = new JTextField(5);
	private Blob conFoto1 = null;
	private Blob conFoto2 = null;
	private Blob conFoto3 = null;
	private Blob conFoto4 = null;
	private Set<Inmueble> setInmuebles;

	public VentanaDuenio(Gestor g, String dni) {
		// TODO Auto-generated constructor stub

		this.gestor = g;

		setInmuebles = g.getInmuebles();

		List<Inmueble> listaInmueble = new ArrayList<>();

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(720, 550);
		setLocationRelativeTo(null);
		setTitle("Registro dueño");

		setLayout(new BorderLayout());

		// Creación de contenedores

		JPanel panelInferior = new JPanel();
		JPanel panelDerecho = new JPanel(new GridLayout(8, 4));
		JPanel panelIzquierdo = new JPanel(new GridLayout(8, 4));
		JPanel panelSuperior = new JPanel(new FlowLayout());

		JPanel panelMetros = new JPanel();
		JPanel panelServicios = new JPanel();
		JPanel panelOcupacion = new JPanel();
		JPanel panelUbicacion = new JPanel();
		JPanel panelTipoVivienda = new JPanel();
		JPanel panelPrecio = new JPanel();
		JPanel panelImagenes = new JPanel();
		JPanel panelTablas_Usuario = new JPanel();
		JPanel panelDuenio = new JPanel();
		JPanel panelInmueble = new JPanel();

		DefaultTableModel modelo_Usuario = new DefaultTableModel();

		modelo_Usuario.addColumn("ID");
		modelo_Usuario.addColumn("Ubicacion");

		JTable tabla_Usuario = new JTable(modelo_Usuario);

		JScrollPane scrollTabla_Usuario = new JScrollPane(tabla_Usuario);

		// Cargo los datos de los Inmuebles:

		System.out.println("Tama�o setInmuebles: " + setInmuebles.size());

		for (Inmueble i : setInmuebles) {

			System.out.println("Inmueble " + i);

			if (i.getDni_Duenio().equalsIgnoreCase(dni)) {

				listaInmueble.add(i);

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
		JButton botonAnyadir = new JButton("Añadir");
		JButton imagen1 = new JButton("1");
		JButton imagen2 = new JButton("2");
		JButton imagen3 = new JButton("3");
		JButton imagen4 = new JButton("4");

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
		panelImagenes.add(imagen1);
		panelImagenes.add(imagen2);
		panelImagenes.add(imagen3);
		panelImagenes.add(imagen4);
		panelTablas_Usuario.add(scrollTabla_Usuario);
		panelDuenio.add(botonEliminar);
		panelDuenio.add(botonEditar);
		panelInmueble.add(botonAnyadir);

		panelDerecho.add(panelMetros);
		panelDerecho.add(panelOcupacion);
		panelDerecho.add(panelServicios);
		panelDerecho.add(panelUbicacion);
		panelDerecho.add(panelTipoVivienda);
		panelDerecho.add(panelPrecio);
		panelDerecho.add(lbImagenes);
		panelDerecho.add(panelImagenes);

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
					ArrayList<Blob> im = new ArrayList<>();
					im.add(conFoto1);
					im.add(conFoto2);
					im.add(conFoto3);
					im.add(conFoto4);
					nuevoInmueble.setImagenes(im);
					nuevoInmueble.setDni_Duenio(dni);
					gestor.anadirInmueble(nuevoInmueble);

				} else {

					System.out.println("No se han rellenado todos los campos necesarios.");
				}

				dispose();

			}
		});
		
		
		imagen1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
	               
	               // solo se admiten ficheros con extensión ".txt"
	               FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.jpg", "*.png", "jpg", "png");
	               fileChooser.addChoosableFileFilter(filtro);
	               // en este caso se muestra un dialogo de selección de fichero de
	               // guardado.
	               int result = fileChooser.showSaveDialog(VentanaDuenio.this);
	               if (result == JFileChooser.APPROVE_OPTION) {
	                   // el usuario ha pulsado el boton aceptar
	                   // se obtiene el fichero seleccionado -> File
	                   File file = fileChooser.getSelectedFile();
	                   try {
						byte[] contenido = Files.readAllBytes(file.toPath());
						try {
							conFoto1 = new SerialBlob(contenido);
						} catch (SQLException e1) {
							
							e1.printStackTrace();
						}
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
	                   
				
			}
			}
		});
		
		
		imagen2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
	               
	               // solo se admiten ficheros con extensión ".txt"
	               FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.jpg", "*.png", "jpg", "png");
	               fileChooser.addChoosableFileFilter(filtro);
	               // en este caso se muestra un dialogo de selección de fichero de
	               // guardado.
	               int result = fileChooser.showSaveDialog(VentanaDuenio.this);
	               if (result == JFileChooser.APPROVE_OPTION) {
	                   // el usuario ha pulsado el boton aceptar
	                   // se obtiene el fichero seleccionado -> File
	                   File file = fileChooser.getSelectedFile();
	                   try {
						byte[] contenido = Files.readAllBytes(file.toPath());
						try {
							conFoto2 = new SerialBlob(contenido);
						} catch (SQLException e1) {
						
							e1.printStackTrace();
						}
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
	                   
				
			}
			}
		});
		
		imagen3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
	               
	               // solo se admiten ficheros con extensión ".txt"
	               FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.jpg", "*.png", "jpg", "png");
	               fileChooser.addChoosableFileFilter(filtro);
	               // en este caso se muestra un dialogo de selección de fichero de
	               // guardado.
	               int result = fileChooser.showSaveDialog(VentanaDuenio.this);
	               if (result == JFileChooser.APPROVE_OPTION) {
	                   // el usuario ha pulsado el boton aceptar
	                   // se obtiene el fichero seleccionado -> File
	                   File file = fileChooser.getSelectedFile();
	                   try {
						byte[] contenido = Files.readAllBytes(file.toPath());
						try {
							conFoto3 = new SerialBlob(contenido);
						} catch (SQLException e1) {
							
							e1.printStackTrace();
						}
					} catch (IOException e1) {
					
						e1.printStackTrace();
					}
	                   
				
			}
			}
		});
		
		imagen4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
	               
	               // solo se admiten ficheros con extensión ".txt"
	               FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.jpg", "*.png", "jpg", "png");
	               fileChooser.addChoosableFileFilter(filtro);
	               // en este caso se muestra un dialogo de selección de fichero de
	               // guardado.
	               int result = fileChooser.showSaveDialog(VentanaDuenio.this);
	               if (result == JFileChooser.APPROVE_OPTION) {
	                   // el usuario ha pulsado el boton aceptar
	                   // se obtiene el fichero seleccionado -> File
	                   File file = fileChooser.getSelectedFile();
	                   try {
						byte[] contenido = Files.readAllBytes(file.toPath());
						try {
							conFoto4 = new SerialBlob(contenido);
						} catch (SQLException e1) {
							
							e1.printStackTrace();
						}
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
	                   
				
			}
			}
		});
		

		botonEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// HAcer un getSelectedItem para que me devuelva el objeto id, y poder obteren
				// el ide del inmuebel seleccionado
				int id = (int) modelo_Usuario.getValueAt(tabla_Usuario.getSelectedRow(), 0);

				if (eliminarInmueble(id)) {
					// Mensaje: Inmueble eliminado correctamente
					JOptionPane.showMessageDialog(null, "El inmueble se elimino correctamente", "Informacion",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					// Mensaje de error
					JOptionPane.showMessageDialog(null, "No se pudo eliminar el inmueble", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		botonEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int id = (int) modelo_Usuario.getValueAt(tabla_Usuario.getSelectedRow(), 0);
				List<Inmueble> listaInmueble = new ArrayList<>(setInmuebles);
				for(Inmueble i: listaInmueble) {
					if(i.getId_Inmueble() == id) {
						new VentanaEditar(i).setVisible(true);
						
					}
				}
				
				
				
				

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

	private boolean eliminarInmueble(int id) {

		Inmueble inmueble = null;
		boolean resultado = false;

		for (Inmueble i : setInmuebles) {
			if (i.getId_Inmueble() == id) {
				inmueble = i;
				setInmuebles.remove(i);
			}
		}

		try {
			gestor.eliminarInmueble(inmueble);
			resultado = true;
		} catch (InmuebleInexistenteException e) {
			
			e.printStackTrace();
		}

		return resultado;
	}

}
