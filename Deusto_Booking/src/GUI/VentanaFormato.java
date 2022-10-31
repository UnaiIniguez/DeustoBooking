package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaFormato extends JFrame {

	private JPanel j;

	public static final Color SKYBLUE = new Color(51, 133, 255);

	public VentanaFormato() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setTitle("Sign in");
		setLocationRelativeTo(null);
		getContentPane().setBackground(SKYBLUE);
		// Icono de ventana
		ImageIcon img = new ImageIcon("icono.png");
		setIconImage(img.getImage());

		setVisible(true);
	}

	public static void main(String[] args) {
		new VentanaFormato();
	}
}
