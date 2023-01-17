package gui;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.random.RandomGenerator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import deustoBooking.Gestor;
import deustoBooking.Inmueble;
import deustoBooking.Reserva;

public class VentanaReserva extends JFrame {
	
	private Gestor gestor;
	
	public VentanaReserva(Gestor g, Inmueble inmueble, Date fechallegada, Date fechasalida) {
		
		this.gestor = g;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setTitle("Reserva");
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3,1));
		
		JButton reservar = new JButton("Reservar");
		JLabel lbdni = new JLabel("DNI:");
		JLabel lbContrasenya = new JLabel("Contrasenya:");
		JTextField txtdni = new JTextField(12);
		JPasswordField pContrasenya = new JPasswordField(12);
		
		JPanel paneldni = new JPanel();
		JPanel panelContrasenya = new JPanel();
		
		paneldni.add(lbdni);
		paneldni.add(txtdni);
		panelContrasenya.add(lbContrasenya);
		panelContrasenya.add(pContrasenya);
		
		add(paneldni);
		add(panelContrasenya);
		add(reservar);
		
reservar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String dni = txtdni.getText();
				String contrasenya = pContrasenya.getText();
				if(gestor.buscarHuesped(dni, contrasenya) == true) {
					Reserva r = new Reserva( 3, inmueble.getId_Inmueble(), fechallegada, fechasalida, dni);
					gestor.reservar(dni, r );
				}else {
					
				}
				
			}
		});
		
		
		setVisible(true);
		
	}
}
