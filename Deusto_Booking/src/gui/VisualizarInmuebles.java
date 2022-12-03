package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import deustoBooking.Gestor;

public class VisualizarInmuebles extends JFrame{
	
		
		private Gestor gestor;
		
		
		public VisualizarInmuebles(Gestor g) {
			
			this.gestor = g;
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(950, 650);
			setTitle("Deusto Booking");
			setLocationRelativeTo(null);
			setLayout(new BorderLayout());
			
			JPanel panelInmuebles = new JPanel();
			JPanel panelDerecho = new JPanel();
			JPanel panelSuperior = new JPanel();
			
			
			JButton seleccionar = new JButton("Seleccionar vivienda");
			JButton volver = new JButton("Volver");
			
			panelSuperior.add(volver, BorderLayout.WEST);
			panelDerecho.add(seleccionar, BorderLayout.SOUTH);
		
			
			
			add(panelDerecho, BorderLayout.EAST);
			add(panelInmuebles, BorderLayout.WEST);
		}
		
}
