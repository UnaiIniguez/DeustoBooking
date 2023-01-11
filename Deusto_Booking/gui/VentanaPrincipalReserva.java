package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import deustoBooking.Gestor;
import deustoBooking.Inmueble;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class VentanaPrincipalReserva extends JFrame {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private DefaultTableModel mFotos = new DefaultTableModel(new Object[] { "Propietario", "N.Habitaciones", "Fecha" },
			0);
	private ArrayList<JLabelAjustado> imagenes = new ArrayList<>();
	DefaultListModel<String> modeloCasas = new DefaultListModel<>();
	private JList<String> lCasas = new JList(modeloCasas);
	JPanel pnlInformacion;
	JLabel propietario;
	JLabel habitaciones;
	JLabel fecha;
	JPanel pnlImagenes;

	public VentanaPrincipalReserva(Gestor g, ArrayList<Inmueble> seleccionadas) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(900, 600);
		setTitle("Ventana de Reservas");

		JPanel pnlCasas = new JPanel();
		JLabel texto = new JLabel("Casas");
		pnlCasas.add(texto);
		pnlCasas.add(lCasas);
		for (Inmueble inmueble : seleccionadas) {
			System.out.println("..");
			modeloCasas.addElement(inmueble.getId_Inmueble() + " " + inmueble.getUbicacion());
		}

		pnlImagenes = new JPanel();
		pnlImagenes.setLayout(new GridLayout(2, 2));

		JLabel l1 = new JLabel("Imagen 1");
		JLabel l2 = new JLabel("Imagen 2");
		JLabel l3 = new JLabel("Imagen 3");
		JLabel l4 = new JLabel("Imagen 4");
		pnlImagenes.add(l1);
		pnlImagenes.add(l2);
		pnlImagenes.add(l3);
		pnlImagenes.add(l4);

		JPanel pnlInformacion = new JPanel();
		pnlInformacion.setLayout(new BoxLayout(pnlInformacion, BoxLayout.Y_AXIS));
		propietario = new JLabel("Propietario: ");
		habitaciones = new JLabel("Habitaciones: ");
		fecha = new JLabel("Fecha: ");
		pnlInformacion.add(propietario);
		pnlInformacion.add(habitaciones);
		pnlInformacion.add(fecha);

		JButton btnReservar = new JButton("Reservar");

		JPanel pnlDerecho = new JPanel();
		pnlDerecho.setLayout(new BoxLayout(pnlDerecho, BoxLayout.Y_AXIS));
		pnlDerecho.add(pnlImagenes);
		pnlDerecho.add(pnlInformacion);
		pnlDerecho.add(btnReservar);

		setLayout(new GridBagLayout());
		GridBagConstraints c1 = new GridBagConstraints();
		c1.fill = GridBagConstraints.HORIZONTAL;
		c1.weightx = 0.25;
		c1.gridx = 0;
		c1.gridy = 0;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weighty = 1.0;
		c1.fill = GridBagConstraints.VERTICAL;
		add(pnlCasas, c1);

		GridBagConstraints c2 = new GridBagConstraints();
		c2.fill = GridBagConstraints.BOTH;
		c2.weightx = 0.75;
		c2.gridx = 1;
		c2.gridy = 0;
		c2.gridwidth = 1;
		c2.gridheight = 1;
		c2.weighty = 1.0;
		c2.fill = GridBagConstraints.BOTH;
		add(pnlDerecho, c2);

	}

	private static class JLabelAjustado extends JLabel {
		private ImageIcon imagen;
		private int tamX;
		private int tamY;

		/**
		 * Crea un jlabel que ajusta una imagen cualquiera con fondo blanco a su tamaño
		 * (a la que ajuste más de las dos escalas, horizontal o vertical)
		 * 
		 * @param imagen Imagen a visualizar en el label
		 * 
		 *               try { con =
		 *               DriverManager.getConnection("jdbc:mysql://localhost:3306/login",
		 *               "root", "obierofelix"); stmt = con.createStatement(); rs =
		 *               stmt.executeQuery("select * from images"); rs.next();
		 *               BufferedImage im = ImageIO.read(rs.getBinaryStream("Image"));
		 *               BackGroundImage.setIcon(new ImageIcon(im)); } catch (Exception
		 *               err) { JOptionPane.showMessageDialog(this, err.getMessage()); }
		 * 
		 */
		public JLabelAjustado(ImageIcon imagen) {
			setImagen(imagen);
		}

		/**
		 * Modifica la imagen
		 * 
		 * @param imagen Nueva imagen a visualizar en el label
		 */
		public void setImagen(ImageIcon imagen) {
			this.imagen = imagen;
			if (imagen == null) {
				tamX = 0;
				tamY = 0;
			} else {
				this.tamX = imagen.getIconWidth();
				this.tamY = imagen.getIconHeight();
			}
		}

		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g; // El Graphics realmente es Graphics2D
			g2.setColor(Color.WHITE);
			g2.fillRect(0, 0, getWidth(), getHeight());
			if (imagen != null && tamX > 0 && tamY > 0) {
				g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				double escalaX = 1.0 * getWidth() / tamX;
				double escalaY = 1.0 * getHeight() / tamY;
				double escala = escalaX;
				int x = 0;
				int y = 0;
				if (escalaY < escala) {
					escala = escalaY;
					x = (int) ((getWidth() - (tamX * escala)) / 2);
				} else {
					y = (int) ((getHeight() - (tamY * escala)) / 2);
				}
				g2.drawImage(imagen.getImage(), x, y, (int) (tamX * escala), (int) (tamY * escala), null);
			}
		}
	}

}
