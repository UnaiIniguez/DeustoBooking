package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Date;

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

import java.awt.EventQueue;

import javax.swing.AbstractListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;

import javax.swing.JTextField;
import javax.swing.ListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class VentanaPrincipalReserva extends JFrame {

	private static class ListModelInmuebles extends AbstractListModel {

		private ArrayList<Inmueble> lista = new ArrayList<>();

		ListModelInmuebles(ArrayList<Inmueble> seleccionadas) {
			for (Inmueble inmueble : seleccionadas) {
				System.out.println("..");
				lista.add(inmueble);
			}

		}

		@Override
		public int getSize() {
			return lista.size();
		}

		@Override
		public String getElementAt(int index) {
			Inmueble i = lista.get(index);
			return Integer.toString(i.getId_Inmueble());
		}

		public Inmueble getInmueble(int index) {
			return lista.get(index);
		}
	}

	private JPanel contentPane;
	private JTextField txtNumHab, txtNumBany, txtUbicacion, txtMaxHuespedes;
	private JTextField txtTipo, txtMetros, txtPrecio, txtOcupado;

	private ArrayList<JLabel> lblImages;
	private ListModelInmuebles modeloCasas;
	private JList lstCasas;

	public VentanaPrincipalReserva(Gestor g, ArrayList<Inmueble> seleccionadas, Date fechallegada, Date fechaSalida) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 600);
		setTitle("Ventana de Reservas");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Listado de inmuebles");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(36, 11, 163, 14);
		contentPane.add(lblNewLabel);

		modeloCasas = new ListModelInmuebles(seleccionadas);
		lstCasas = new JList(modeloCasas);
		lstCasas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int selection = lstCasas.getSelectedIndex();
				if (selection != -1) {
					Inmueble i = modeloCasas.getInmueble(selection);
					

					txtNumHab.setText(i.getNumHab() + "");
					txtNumBany.setText(i.getNumBany() + "");
					txtUbicacion.setText(i.getUbicacion());
					txtMaxHuespedes.setText(i.getMaxHuespedes() + "");
					txtTipo.setText(i.getTipo() + "");
					txtMetros.setText(i.getMetrosCuadrados() + "");
					txtPrecio.setText(i.getPrecioNoche() + "");
					txtOcupado.setText(i.getOcupado() + "");
					JButton btnReservar = new JButton("Reservar");
					
					btnReservar.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnReservar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							VentanaReserva ventana = new VentanaReserva(g, i, fechallegada,fechaSalida);
							ventana.setVisible(true);
						}
					});
					btnReservar.setBounds(685, 467, 89, 45);
					contentPane.add(btnReservar);
				}
			}
		});
		lstCasas.setBounds(10, 36, 215, 512);
		contentPane.add(lstCasas);

		lblImages = new ArrayList<>(4);
		JLabel lblImage = new JLabel("");
		lblImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImage.setBounds(233, 36, 268, 193);
		contentPane.add(lblImage);
		lblImages.add(lblImage);

		lblImage = new JLabel("");
		lblImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImage.setBounds(506, 36, 268, 193);
		contentPane.add(lblImage);
		lblImages.add(lblImage);

		lblImage = new JLabel("");
		lblImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImage.setBounds(233, 240, 268, 193);
		contentPane.add(lblImage);
		lblImages.add(lblImage);

		lblImage = new JLabel("");
		lblImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImage.setBounds(506, 240, 268, 193);
		contentPane.add(lblImage);
		lblImages.add(lblImage);

		JLabel lblNewLabel_1_1 = new JLabel("Ubicación:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(235, 448, 101, 14);
		contentPane.add(lblNewLabel_1_1);

		txtUbicacion = new JTextField();
		txtUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtUbicacion.setBounds(346, 444, 120, 20);
		txtUbicacion.setColumns(10);
		contentPane.add(txtUbicacion);

		JLabel lblNewLabel_2_1 = new JLabel("Habitaciones:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(235, 473, 101, 14);
		contentPane.add(lblNewLabel_2_1);

		txtNumHab = new JTextField();
		txtNumHab.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNumHab.setBounds(346, 469, 120, 20);
		txtNumHab.setColumns(10);
		contentPane.add(txtNumHab);

		JLabel lblNewLabel_2_2 = new JLabel("Baños:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(235, 498, 101, 14);
		contentPane.add(lblNewLabel_2_2);

		txtNumBany = new JTextField();
		txtNumBany.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNumBany.setBounds(346, 494, 120, 20);
		txtNumBany.setColumns(10);
		contentPane.add(txtNumBany);

		JLabel lblNewLabel_2_3 = new JLabel("Máx.Huéspedes:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_3.setBounds(235, 523, 101, 14);
		contentPane.add(lblNewLabel_2_3);

		txtMaxHuespedes = new JTextField();
		txtMaxHuespedes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMaxHuespedes.setBounds(346, 519, 120, 20);
		txtMaxHuespedes.setColumns(10);
		contentPane.add(txtMaxHuespedes);

		JLabel lblNewLabel_2 = new JLabel("Ocupado:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(490, 521, 67, 14);
		contentPane.add(lblNewLabel_2);

		txtOcupado = new JTextField();
		txtOcupado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtOcupado.setColumns(10);
		txtOcupado.setBounds(559, 519, 120, 20);
		contentPane.add(txtOcupado);

		JLabel lblNewLabel_2_4 = new JLabel("Precio:");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_4.setBounds(490, 496, 67, 14);
		contentPane.add(lblNewLabel_2_4);

		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPrecio.setColumns(4);
		txtPrecio.setBounds(559, 494, 120, 20);
		contentPane.add(txtPrecio);

		JLabel lblNewLabel_2_5 = new JLabel("Metros:");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_5.setBounds(490, 471, 67, 14);
		contentPane.add(lblNewLabel_2_5);

		txtMetros = new JTextField();
		txtMetros.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMetros.setColumns(4);
		txtMetros.setBounds(559, 469, 120, 20);
		contentPane.add(txtMetros);

		JLabel lblNewLabel_1 = new JLabel("Tipo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(490, 444, 67, 14);
		contentPane.add(lblNewLabel_1);

		txtTipo = new JTextField();
		txtTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTipo.setColumns(10);
		txtTipo.setBounds(559, 444, 120, 20);
		contentPane.add(txtTipo);

		

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
