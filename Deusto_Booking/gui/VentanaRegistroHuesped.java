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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import deustoBooking.Gestor;
import deustoBooking.Huesped;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class VentanaRegistroHuesped extends JFrame {

	private JPanel j;
	private JTextField txtNombre;
	private JTextField txtDNI;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtEdad;
	private JTextField txtEmpresa;
	private JTextField txtCargo;
	private JTextField txtContrasenya;

	public VentanaRegistroHuesped(Gestor gestor) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Registro Huesped");
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(173, 216, 230));
		setSize(300,560);
		getContentPane().setLayout(null);

		
		
		//Componentes de ventana
		JLabel l = new JLabel("");
		l.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel l1 = new JLabel("DNI:");
		JLabel l2 = new JLabel("Nombre:");
		JLabel l3 = new JLabel("Email:");
		JLabel l4 = new JLabel("Telefono:");
		JLabel l5 = new JLabel("Edad:");
		JLabel l6 = new JLabel("Empresa:");
		JLabel l7 = new JLabel("Cargo:");
		JLabel l8 = new JLabel("Contraseña:");
		
		l.setBounds(40, 11, 204, 135);		
		l.setFont(new Font("Tahoma", Font.BOLD, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/icono.png"));
		ImageIcon logo = new ImageIcon(new ImageIcon("imagenes/icono.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		l.setIcon(logo);
		
		l1.setBounds(28, 202, 85, 14);
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		l2.setBounds(28, 170, 85, 14);
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		l3.setBounds(28, 271, 85, 14);
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		l4.setBounds(28, 236, 85, 14);
		l4.setFont(new Font("Tahoma", Font.BOLD, 14));
		l5.setBounds(28, 307, 85, 14);
		l5.setFont(new Font("Tahoma", Font.BOLD, 14));
		l6.setBounds(28, 339, 85, 20);
		l6.setFont(new Font("Tahoma", Font.BOLD, 14));
		l7.setBounds(28, 375, 85, 20);
		l7.setFont(new Font("Tahoma", Font.BOLD, 14));		
		l8.setBounds(28, 413, 85, 14);
		l8.setFont(new Font("Tahoma", Font.BOLD, 14));

		getContentPane().add(l);
		
		getContentPane().add(l1);
		getContentPane().add(l2);
		getContentPane().add(l3);
		getContentPane().add(l4);
		getContentPane().add(l5);
		getContentPane().add(l6);
		getContentPane().add(l7);
		getContentPane().add(l8);

		JButton btnRegistrarse = new JButton("Registrarse ");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestor g = new Gestor();
				
				g.registroHuesped(
						txtDNI.getText().trim(),
						txtNombre.getText().trim(),
						Integer.parseInt(txtEdad.getText().trim()),
						txtEmail.getText().trim(),
						txtTelefono.getText().trim(),
						txtContrasenya.getText().trim(),
						txtCargo.getText().trim(),
						txtEmpresa.getText().trim() );
				
				dispose();
				JOptionPane.showMessageDialog(VentanaRegistroHuesped.this, "El cliente se ha creado adecuadamente", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegistrarse.setBounds(12, 475, 115, 20);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(162, 475, 112, 20);

		Dimension dimb = new Dimension(140,20);
		btnRegistrarse.setPreferredSize(dimb);
		btnCancelar.setPreferredSize(dimb);
		
		getContentPane().add(btnCancelar);
		getContentPane().add(btnRegistrarse);
	
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setBounds(146, 167, 112, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDNI.setColumns(10);
		txtDNI.setBounds(146, 199, 112, 20);
		getContentPane().add(txtDNI);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(146, 233, 112, 20);
		getContentPane().add(txtTelefono);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(146, 268, 112, 20);
		getContentPane().add(txtEmail);
		
		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEdad.setColumns(10);
		txtEdad.setBounds(146, 304, 112, 20);
		getContentPane().add(txtEdad);
		
		txtEmpresa = new JTextField();
		txtEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmpresa.setColumns(10);
		txtEmpresa.setBounds(146, 339, 112, 20);
		getContentPane().add(txtEmpresa);
		
		txtCargo = new JTextField();
		txtCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCargo.setColumns(10);
		txtCargo.setBounds(146, 375, 112, 20);
		getContentPane().add(txtCargo);
		
		txtContrasenya = new JTextField();
		txtContrasenya.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtContrasenya.setColumns(10);
		txtContrasenya.setBounds(146, 410, 112, 20);
		getContentPane().add(txtContrasenya);
		
		
	}
}
