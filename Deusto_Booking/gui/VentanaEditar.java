package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlBD.GestorBD;
import deustoBooking.Gestor;
import deustoBooking.Inmueble;

public class VentanaEditar extends JFrame{

	private static final long serialVersionUID = 1L;
	
	Gestor g;
	JComboBox jc;
	
	public VentanaEditar(Inmueble i, Gestor g) {
		
		this.g = g;

		// Especificaciones de ventana
		setTitle("Inicio de sesión");
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3, 1));
		setSize(300, 450);
		
		//Panel para el combo box
		JPanel pArriba = new JPanel();
		JPanel pAbajo = new JPanel();
		JPanel pFoto = new JPanel();
		pArriba.setBackground(new Color(173, 216, 230));
		pAbajo.setBackground(new Color(173, 216, 230));
		pFoto.setBackground(new Color(173, 216, 230));
		
		//Jlabel identificativos de la izquierda
		JLabel lbl = new JLabel("Ocupado: ");
		JLabel icono = new JLabel();
		//ComboBox para elegir si esta ocupado el inmueble o no
		jc = new JComboBox<String>();
		jc.setModel(new DefaultComboBoxModel(new String[] { "SI", "NO"}));
		
		//Boton de submit
		JButton b = new JButton();
		b.setText("Confirmar");
		
		//Foto de arriba
		ImageIcon logo = new ImageIcon(new ImageIcon("imagenes/icono.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		icono.setIcon(logo);
		
		pFoto.add(icono);
		pArriba.add(lbl);
		pArriba.add(jc);
		pAbajo.add(b);
		
		add(pFoto);
		add(pArriba);
		add(pAbajo);
		
		b.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String ocupado = jc.getSelectedItem().toString();
				if(ocupado == "SI") {
					i.setOcupado(1);
					setVisible(false);
				}else {
					i.setOcupado(0);
					setVisible(false);
				}
				
			}
			
			
			
			
		});
		
	}
	
	
	
}
