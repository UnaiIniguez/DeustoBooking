package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import deustoBooking.Gestor;
import deustoBooking.Reserva;
import deustoBooking.ReservaInexistenteException; 



public class VentanaCliente extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Gestor gestor;
	JTable tabla;

	
	
	
	public VentanaCliente(Gestor g, String dni) {
		gestor = g;
		 ArrayList<Reserva> reservas = gestor.getReservas().get(dni);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Reservas Huesped");
		setLocationRelativeTo(null);
		setSize(700,450);
		setLayout(new GridLayout(1,2)); 
		
		JPanel panelIzquierdo = new JPanel(new GridLayout(6 , 1));
		JPanel panelDerecho = new JPanel();
		
		//Contenedores
		JPanel panelIDEliminar = new JPanel();
		JPanel panelBotonEliminar = new JPanel();
		JPanel panelEditarID = new JPanel();
		JPanel panelBotonEditar = new JPanel();
		JPanel panelFechas = new JPanel();
		JPanel panelEspacio = new JPanel();
		
		
		panelIDEliminar.setBackground(new Color(173, 216, 230));
		panelBotonEliminar.setBackground(new Color(173, 216, 230));
		panelEditarID.setBackground(Color.WHITE);
		panelBotonEditar.setBackground(Color.WHITE);
		panelFechas.setBackground(Color.WHITE);
		panelEspacio.setBackground(Color.WHITE);
		
		//Objetos
		JLabel lbIdEliminar = new JLabel("ID:");
		JTextField txtEliminar = new JTextField(12);
		JButton bteliminar = new  JButton("Eliminar reserva");
		
		JLabel lbIdEditar = new JLabel("ID:");
		JTextField txtEditar = new JTextField(12);
		JLabel lbFcehaIni = new JLabel("Fecha ini:");
		JLabel lbFcehaFin = new JLabel("Fecha fin:");
		JDateChooser fechaIni = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		JDateChooser fechaFin = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		JButton btEditar = new JButton("Editar Reserva");
		JLabel espacio = new JLabel(" ");
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		modelo.addColumn("ID");
		modelo.addColumn("Fecha de Entrada");
		modelo.addColumn("Fecha de Salida");
		
		tabla = new JTable( modelo );
		
		if (reservas != null) {
			for (int i = 0; i < reservas.size(); i++) {
				Object[] fila = new Object[3];
				fila[0] = reservas.get(i).getId_Reserva();
				fila[1] = reservas.get(i).getFecha_Entrada();
				fila[2] = reservas.get(i).getFecha_Salida();
				modelo.addRow(fila);

			}
		}
		
		//Insertar objetos dentro de paneles
		
		panelIDEliminar.add(lbIdEliminar);
		panelIDEliminar.add(txtEliminar);
		panelEditarID.add(lbIdEditar);
		panelEditarID.add(txtEditar);
		panelFechas.add(lbFcehaIni);
		panelFechas.add(fechaIni);
		panelFechas.add(lbFcehaFin);
		panelFechas.add(fechaFin);
		panelBotonEditar.add(btEditar);
		panelBotonEliminar.add(bteliminar);
		panelEspacio.add(espacio);
		
		
		//Insertar los contenedores en los paneles principales
		panelIzquierdo.add(panelIDEliminar);
		panelIzquierdo.add(panelBotonEliminar);
		panelIzquierdo.add(panelEspacio);
		panelIzquierdo.add(panelEditarID);
		panelIzquierdo.add(panelFechas);
		panelIzquierdo.add(panelBotonEditar);
		
		panelDerecho.add(tabla);
		
		
		add(panelIzquierdo);
		add(panelDerecho);
		
		bteliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id= Integer.parseInt(txtEliminar.getText());
				
				for(Reserva r : reservas) {
					
					if(r.getId_Reserva() == id ){
							try {
								
								gestor.anularReserva(r.getDni_Huesped(), r);
								
							} catch (ReservaInexistenteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					}
				}
				
			}
		});
		
		btEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Date fi = fechaIni.getDate();
				fi.setHours(0);
				fi.setMinutes(0);
				fi.setSeconds(0);
				Date ff = fechaFin.getDate();
				ff.setHours(0);
				ff.setMinutes(0);
				ff.setSeconds(0);
				int id= Integer.parseInt(txtEditar.getText());
				
				for(Reserva r : reservas) {
					if(r.getId_Reserva() == id) {
						try {
							gestor.editarFechaReserva(dni, r, fi, ff);
						} catch (ReservaInexistenteException e1) {
							
							e1.printStackTrace();
						}
					}
				}
				
			}
		});

		setVisible(true);
	}
	
}

