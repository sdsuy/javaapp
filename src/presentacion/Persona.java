package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Persona extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre1;
	private JTextField textNombre2;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JPasswordField passwordFieldpaswordClave;
	private JPasswordField passwordFieldRepetirClave;
	private JTextField textMail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Persona frame = new Persona();
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
	public Persona() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNombre1 = new JTextField();
		textNombre1.setBounds(6, 38, 107, 26);
		contentPane.add(textNombre1);
		textNombre1.setColumns(10);
		
		textNombre2 = new JTextField();
		textNombre2.setColumns(10);
		textNombre2.setBounds(6, 76, 107, 26);
		contentPane.add(textNombre2);
		
		textApellido1 = new JTextField();
		textApellido1.setColumns(10);
		textApellido1.setBounds(6, 140, 107, 26);
		contentPane.add(textApellido1);
		
		textApellido2 = new JTextField();
		textApellido2.setColumns(10);
		textApellido2.setBounds(6, 178, 107, 26);
		contentPane.add(textApellido2);
		
		JLabel lblNewLabel = new JLabel("Nombres");
		lblNewLabel.setBounds(6, 16, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(6, 114, 61, 16);
		contentPane.add(lblApellidos);
		
		passwordFieldpaswordClave = new JPasswordField();
		passwordFieldpaswordClave.setBounds(125, 104, 107, 26);
		contentPane.add(passwordFieldpaswordClave);
		
		JLabel lblContrasea = new JLabel("Clave");
		lblContrasea.setBounds(125, 76, 96, 16);
		contentPane.add(lblContrasea);
		
		passwordFieldRepetirClave = new JPasswordField();
		passwordFieldRepetirClave.setBounds(125, 178, 107, 26);
		contentPane.add(passwordFieldRepetirClave);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(52, 216, 82, 27);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Rol");
		lblNewLabel_1.setBounds(6, 216, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mail");
		lblNewLabel_1_1.setBounds(125, 16, 61, 16);
		contentPane.add(lblNewLabel_1_1);
		
		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBounds(125, 38, 107, 26);
		contentPane.add(textMail);
		
		JLabel lblRepetirContrasea = new JLabel("Repetir Clave");
		lblRepetirContrasea.setBounds(125, 140, 119, 16);
		contentPane.add(lblRepetirContrasea);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.setBounds(271, 38, 117, 29);
		contentPane.add(btnAlta);
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.setBounds(271, 76, 117, 29);
		contentPane.add(btnBaja);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(271, 109, 117, 29);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(271, 140, 117, 29);
		contentPane.add(btnEliminar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(271, 178, 117, 29);
		contentPane.add(btnListar);
	}
}
