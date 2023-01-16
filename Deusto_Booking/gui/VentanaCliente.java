package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import deustoBooking.Gestor;
import deustoBooking.Reserva; 



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
		setTitle("Registro Huesped");
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
		
		tabla = new JTable();
		TableModel modelo = tabla.getModel();
		int fila = 0;
		for(Reserva r : reservas) {
			int dato1 = r.getId_Reserva();
			Date dato2 = r.getFecha_Entrada();
			Date dato3 = r.getFecha_Salida();
			
			
			modelo.setValueAt(dato1, fila, 0);
			modelo.setValueAt(dato2, fila, 1);
			modelo.setValueAt(dato3, fila, 1);
			fila++;
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
		

		setVisible(true);
	}
}
