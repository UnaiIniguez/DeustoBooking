package GUI;

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

public class VentanaLogin extends JFrame {

	private JPanel j;

	public static final Color SKYBLUE = new Color(51, 133, 255);

	public VentanaLogin() {

		getContentPane().setLayout(new GridLayout(4, 1));
		//Paneles para personalizar tamaños de componentes
		JPanel p1 = new JPanel(new GridLayout(1,3));
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
		JLabel l1 = new JLabel("Usuario      ");
		JLabel l2 = new JLabel("Contraseña");
		JTextField t = new JTextField(14);
		JTextField t1 = new JTextField(14);
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
		p66.add(b1);
		p77.add(b);
		
		getContentPane().add(p1);
		getContentPane().add(p2);
		getContentPane().add(p3);
		getContentPane().add(p4);
		
		//Especificaciones de ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Log in");
		setLocationRelativeTo(null);
		getContentPane().setBackground(SKYBLUE);
		setSize(400,600);
		p1.setBackground(SKYBLUE);
		p2.setBackground(SKYBLUE);
		p3.setBackground(SKYBLUE);
		p4.setBackground(SKYBLUE);
		p11.setBackground(SKYBLUE);
		p22.setBackground(SKYBLUE);
		p33.setBackground(SKYBLUE);
		p44.setBackground(SKYBLUE);
		p55.setBackground(SKYBLUE);
		p66.setBackground(SKYBLUE);
		p77.setBackground(SKYBLUE);
	
		//Ajuste del tamaño de los botones
		Dimension dimb = new Dimension(160,40);
		b.setPreferredSize(dimb);
		b1.setPreferredSize(dimb);
		Font bigFont = l.getFont().deriveFont(Font.BOLD, 36f);
		Font mediumFont = l1.getFont().deriveFont(Font.PLAIN, 20f);
		l.setFont(bigFont);
		l1.setFont(mediumFont);
		l2.setFont(mediumFont);
		
		//Icono de ventana
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/icono.png"));
		
		
		ImageIcon logo = new ImageIcon(new ImageIcon("imagenes/icono.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		l.setIcon(logo);
		
		
		
	}

	public static void main(String[] args) {
	 new VentanaLogin().setVisible(true);
	
		
	}
}