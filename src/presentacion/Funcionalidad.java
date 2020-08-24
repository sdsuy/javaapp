package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Funcionalidad extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcionalidad frame = new Funcionalidad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Funcionalidad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setBounds(18, 49, 130, 26);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(18, 111, 130, 26);
		contentPane.add(textDescripcion);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(43, 29, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(43, 93, 88, 16);
		contentPane.add(lblDescripcion);
		
		JButton btnNewButton = new JButton("Alta");
		btnNewButton.setBounds(241, 24, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.setBounds(241, 65, 117, 29);
		contentPane.add(btnBaja);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(241, 108, 117, 29);
		contentPane.add(btnModificar);
		
		JButton btnNewButton_2_1 = new JButton("Eliminar");
		btnNewButton_2_1.setBounds(241, 150, 117, 29);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2 = new JButton("Listar");
		btnNewButton_2.setBounds(241, 201, 117, 29);
		contentPane.add(btnNewButton_2);
	}
}
