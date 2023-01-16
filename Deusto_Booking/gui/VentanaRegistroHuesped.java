package gui;

import java.awt.Button;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import deustoBooking.Gestor;



public class VentanaRegistroHuesped extends JFrame {

	private JPanel j;
	private Gestor gestor;

	public VentanaRegistroHuesped(Gestor g) {

		this.gestor = g;
		getContentPane().setLayout(new GridLayout(7, 1));
		//Paneles para personalizar tamaños de componentes
		JPanel p1 = new JPanel(new GridLayout(1,6));
		JPanel p2 = new JPanel(new GridLayout());
		JPanel p3 = new JPanel(new GridLayout());
		JPanel p4 = new JPanel(new GridLayout());
		JPanel p5 = new JPanel(new GridLayout());
		JPanel p6 = new JPanel(new GridLayout());
		JPanel p7 = new JPanel(new GridLayout());

		JPanel p8 = new JPanel(new FlowLayout());
	
		
		JPanel p11 = new JPanel(new FlowLayout());
		JPanel p22 = new JPanel(new FlowLayout());
		JPanel p33 = new JPanel(new FlowLayout());
		JPanel p44 = new JPanel(new FlowLayout());
		JPanel p55 = new JPanel(new FlowLayout());
		JPanel p66 = new JPanel(new FlowLayout());
		JPanel p77 = new JPanel(new FlowLayout());
		JPanel p88 = new JPanel(new FlowLayout());
		JPanel p99 = new JPanel(new FlowLayout());
		JPanel p100 = new JPanel(new FlowLayout());
		JPanel p101= new JPanel(new FlowLayout());
		JPanel p102= new JPanel(new FlowLayout());
		JPanel p103= new JPanel(new FlowLayout());
		JPanel p104= new JPanel(new FlowLayout());
		
		
		//Componentes de ventana
		JLabel l = new JLabel("Deusto Booking");
		JLabel l1 = new JLabel("DNI      ");
		JLabel l2 = new JLabel("Nombre   ");
		JLabel l3 = new JLabel("Apellido ");
		JLabel l4 = new JLabel("Telefono ");
		JLabel l5 = new JLabel("Fecha Nacimiento ");
		JTextField t = new JTextField(14);
		JTextField t1 = new JTextField(14);
		JTextField t2 = new JTextField(14);
		JTextField t3 = new JTextField(14);
		JDateChooser fechaNacimiento = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		JButton b = new JButton("Registrarse ");
		JButton b1 = new JButton("Cancelar");
		
		p1.add(p11);
		p2.add(p22);
		p2.add(p33);
		p3.add(p44);
		p3.add(p55);
		p4.add(p66);
		p4.add(p77);
		p5.add(p88);
		p5.add(p99);
		p6.add(p100);
		p6.add(p101);
		p7.add(p102);
		p7.add(p103);
		
		
		
		p11.add(l);
		p22.add(l1);
		p33.add(t);
		p44.add(l2);
		p55.add(t1);
		p66.add(l3);
		p77.add(t2);
		p88.add(l4);
		p99.add(t3);
		p100.add(l5);
		p101.add(fechaNacimiento);
		p102.add(b1);
		p103.add(b);
	
		
		
		getContentPane().add(p1);
		getContentPane().add(p2);
		getContentPane().add(p3);
		getContentPane().add(p4);
		getContentPane().add(p5);
		getContentPane().add(p6);
		getContentPane().add(p7);
		
		
		
		
		
		
		
		
		//Especificaciones de ventana
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Registro Huesped");
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(173, 216, 230));
		setSize(400,600);
		p1.setBackground(new Color(173, 216, 230));
		p2.setBackground(new Color(173, 216, 230));
		p3.setBackground(new Color(173, 216, 230));
		p4.setBackground(new Color(173, 216, 230));
		p11.setBackground(new Color(173, 216, 230));
		p22.setBackground(new Color(173, 216, 230));
		p33.setBackground(new Color(173, 216, 230));
		p44.setBackground(new Color(173, 216, 230));
		p55.setBackground(new Color(173, 216, 230));
		p66.setBackground(new Color(173, 216, 230));
		p77.setBackground(new Color(173, 216, 230));
		p88.setBackground(new Color(173, 216, 230));
		p99.setBackground(new Color(173, 216, 230));
		p100.setBackground(new Color(173, 216, 230));
		p101.setBackground(new Color(173, 216, 230));
		p102.setBackground(new Color(173, 216, 230));
		p103.setBackground(new Color(173, 216, 230));
		
	
		//Ajuste del tamaño de los botones
		Dimension dimb = new Dimension(140,20);
		b.setPreferredSize(dimb);
		b1.setPreferredSize(dimb);
		Font bigFont = l.getFont().deriveFont(Font.BOLD, 26f);
		Font mediumFont = l1.getFont().deriveFont(Font.PLAIN, 10f);
		Font mediumFont2 = l2.getFont().deriveFont(Font.PLAIN, 10f);
		Font mediumFont3 = l3.getFont().deriveFont(Font.PLAIN, 10f);
		Font mediumFont4 = l4.getFont().deriveFont(Font.PLAIN, 10f);
		Font mediumFont5 = l5.getFont().deriveFont(Font.PLAIN, 10f);
		l.setFont(bigFont);
		l1.setFont(mediumFont);
		l2.setFont(mediumFont);
		l3.setFont(mediumFont);
		l4.setFont(mediumFont);
		l5.setFont(mediumFont);
		
		
		//Icono de ventana
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/icono.png"));
		
		
		ImageIcon logo = new ImageIcon(new ImageIcon("imagenes/icono.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		l.setIcon(logo);
		
		
		//Eventos
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		
	}


}
