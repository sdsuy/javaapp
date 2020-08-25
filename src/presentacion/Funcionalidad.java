package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dto.FuncionalidadBO;
import dto.FuncionalidadVO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Funcionalidad extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDescripcion;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(18, 49, 130, 26);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(18, 111, 130, 26);
		contentPane.add(txtDescripcion);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(43, 29, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(43, 93, 88, 16);
		contentPane.add(lblDescripcion);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionalidadBO funcionalidad = new FuncionalidadBO();
				FuncionalidadVO funaux = new FuncionalidadVO();
				funaux.setNombre(txtNombre.getText());
				funaux.setDescripcion(txtDescripcion.getText());
				funcionalidad.agregarFuncionalidad(funaux);
			}
		});
		btnAlta.setBounds(241, 24, 117, 29);
		contentPane.add(btnAlta);
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.setBounds(241, 65, 117, 29);
		contentPane.add(btnBaja);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(241, 108, 117, 29);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(241, 150, 117, 29);
		contentPane.add(btnEliminar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(241, 192, 117, 29);
		contentPane.add(btnListar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(28, 150, 117, 29);
		contentPane.add(btnBuscar);
	}
}
