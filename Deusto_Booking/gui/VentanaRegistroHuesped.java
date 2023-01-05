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
import java.io.File;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;



public class VentanaRegistroHuesped extends JFrame {

	private JPanel j;

	public VentanaRegistroHuesped() {

		getContentPane().setLayout(new GridLayout(9, 1));
		//Paneles para personalizar tamaños de componentes
		JPanel p1 = new JPanel(new GridLayout());
		JPanel p2 = new JPanel(new GridLayout());
		JPanel p3 = new JPanel(new GridLayout());
		JPanel p4 = new JPanel(new GridLayout());
		JPanel p5 = new JPanel(new GridLayout());
		JPanel p6 = new JPanel(new GridLayout());
		JPanel p7 = new JPanel(new GridLayout());

		JPanel p8 = new JPanel(new GridLayout());
		JPanel p9 = new JPanel(new GridLayout());
		
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
		JPanel p105= new JPanel(new FlowLayout());
		JPanel p106= new JPanel(new FlowLayout());
		JPanel p107= new JPanel(new FlowLayout());
		JPanel p108= new JPanel(new FlowLayout());
		
		
		//Componentes de ventana
		
		JLabel l1 = new JLabel("DNI      ");
		JLabel l2 = new JLabel("Nombre   ");
		JLabel l3 = new JLabel("Edad ");
		JLabel l4 = new JLabel("Telefono ");
		JLabel l5 = new JLabel("Mail ");
		JLabel l6 = new JLabel("Contraseña ");
		JLabel l7 = new JLabel("Cargo ");
		JLabel l8 = new JLabel("Nombre empresa ");
		JTextField t = new JTextField(14);
		JTextField t1 = new JTextField(14);
		JTextField t2 = new JTextField(14);
		JTextField t3 = new JTextField(14);
		JTextField t4 = new JTextField(14);
		JTextField t5 = new JTextField(14);
		JTextField t6 = new JTextField(14);
		JTextField t7 = new JTextField(14);
		JButton b = new JButton("Registrarse ");
		JButton b1 = new JButton("Cancelar");
		
		p1.add(p11);
		p1.add(p104);
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
		p8.add(p105);
		p8.add(p106);
		p9.add(p107);
		p9.add(p108);
		
		p11.add(l6);
		p104.add(t5);
		p22.add(l1);
		p33.add(t);
		p44.add(l2);
		p55.add(t1);
		p66.add(l3);
		p77.add(t2);
		p88.add(l4);
		p99.add(t3);
		p100.add(l5);
		p101.add(t4);
		p105.add(l7);
		p106.add(t6);
		p107.add(l8);
		p108.add(t7);
		p102.add(b1);
		p103.add(b);
		
		

		getContentPane().add(p2);
		getContentPane().add(p3);
		getContentPane().add(p4);
		getContentPane().add(p5);
		getContentPane().add(p1);
		getContentPane().add(p6);
		getContentPane().add(p8);
		getContentPane().add(p9);
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
		p104.setBackground(new Color(173, 216, 230));
		p105.setBackground(new Color(173, 216, 230));
		p106.setBackground(new Color(173, 216, 230));
		p107.setBackground(new Color(173, 216, 230));
		p108.setBackground(new Color(173, 216, 230));
		p7.setBackground(new Color(173, 216, 230));
		p8.setBackground(new Color(173, 216, 230));
		p9.setBackground(new Color(173, 216, 230));
	
		//Ajuste del tamaño de los botones
		Dimension dimb = new Dimension(140,20);
		b.setPreferredSize(dimb);
		b1.setPreferredSize(dimb);
		Font mediumFont = l1.getFont().deriveFont(Font.PLAIN, 10f);
		l1.setFont(mediumFont);
		l2.setFont(mediumFont);
		l3.setFont(mediumFont);
		l4.setFont(mediumFont);
		l5.setFont(mediumFont);
		l6.setFont(mediumFont);
		l7.setFont(mediumFont);
		l8.setFont(mediumFont);
		
		

		
		
		
	}


}
