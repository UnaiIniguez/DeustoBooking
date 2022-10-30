package GUI;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaFormato extends JFrame{
	
	private JPanel j;
	
	public static final Color SKYBLUE = new Color(51,133,255);
	
	public VentanaFormato() {
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(400,600);
	setLocationRelativeTo(null);
	
	//Icono de ventana
	//setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/icono.png"));

	getContentPane().setLayout(new GridLayout(4, 1));
	//Paneles para personalizar tamaños de componentes
	JPanel p1 = new JPanel(new FlowLayout());
	JPanel p2 = new JPanel(new GridLayout());
	JPanel p3 = new JPanel(new GridLayout());
	JPanel p4 = new JPanel(new FlowLayout());
	JPanel p11 = new JPanel(new FlowLayout());
	JPanel p22 = new JPanel(new FlowLayout());
	JPanel p33 = new JPanel(new FlowLayout());
	JPanel p44 = new JPanel(new FlowLayout());
	JPanel p55 = new JPanel(new FlowLayout());
	JPanel p66 = new JPanel(new FlowLayout());
	JPanel p77 = new JPanel(new FlowLayout());
	//Componentes de ventana
	JLabel l = new JLabel("Deusto Booking");
	JLabel l1 = new JLabel("Usuario");
	JLabel l2 = new JLabel("Contraseña");
	JTextField t = new JTextField(10);
	JTextField t1 = new JTextField(10);
	JButton b = new JButton("Iniciar sesión");
	JButton b1 = new JButton("Cancelar");
	
	p1.add(p11);
	p2.add(p22);
	p2.add(p33);
	p3.add(p44);
	p3.add(p55);
	p4.add(p66);
	p4.add(p77);
	p11.add(l);
	p22.add(l1);
	p33.add(t);
	p44.add(l2);
	p55.add(t1);
	p66.add(b);
	p77.add(b1);
	
	
	getContentPane().add(p1);
	getContentPane().add(p2);
	getContentPane().add(p3);
	getContentPane().add(p4);
	}
	
	public static void main(String[] args) {
		new VentanaFormato().setVisible(true);
		
	}
}
