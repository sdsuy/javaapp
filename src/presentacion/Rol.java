package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dto.FuncionalidadBO;
import dto.FuncionalidadVO;
import dto.RolBO;
import dto.RolVO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Rol extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textDescripcion;
	private RolBO rol = new RolBO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rol frame = new Rol();
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
	public Rol() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setBounds(18, 51, 130, 26);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(18, 119, 130, 26);
		contentPane.add(textDescripcion);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(20, 27, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(18, 91, 95, 16);
		contentPane.add(lblDescripcion);
		
		JList listFuncionalidades = new JList();
		listFuncionalidades.setBounds(234, 22, 197, 235);
		contentPane.add(listFuncionalidades);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textNombre.getText().isEmpty() || textDescripcion.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No tiene todos lo campos","Error",JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					RolVO rolaux = new RolVO();
					rolaux.setNombre(textNombre.getText());//Busco por nombre
					rolaux = rol.getRol();//Recupero el rol encontrado 
					rolaux.setDescripcion(textDescripcion.getText());//Actualizo el valor de descripcion
					rol.actualizarRol(rolaux);
					
					boolean retorno =  rol.actualizarRol(rolaux);
					
					if (retorno) {
						JOptionPane.showMessageDialog(null, "La operacion se realizo con exito","Correcto",JOptionPane.INFORMATION_MESSAGE);
						limpiarCampos();
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Se produjo un error","Error",JOptionPane.ERROR_MESSAGE);
					}
					
				
				}
				
			}
		});
		btnModificar.setBounds(6, 193, 117, 29);
		contentPane.add(btnModificar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// -- Codigo para listar
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							// Actualizo la lista de roles
							rol.obtenerRoles();
							String[] columnas = { "Nombre", "Descripcion" };
							// envio el
							Listado frame = new Listado(rol.getRoles(), columnas);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				// -- FIN
			}
		});
		btnListar.setBounds(18, 228, 172, 29);
		contentPane.add(btnListar);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (textNombre.getText().isEmpty() || textDescripcion.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No tiene todos lo campos","Error",JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					RolVO rolaux = new RolVO();
					rolaux.setNombre(textNombre.getText());
					rolaux.setDescripcion(textDescripcion.getText());
					rol.agregarRol(rolaux);
					
					boolean resultado = rol.agregarRol(rolaux);
					
					if (resultado) {
						JOptionPane.showMessageDialog(null, "La operacion se realizo con exito","Correcto",JOptionPane.INFORMATION_MESSAGE);
						limpiarCampos();
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Se produjo un error","Error",JOptionPane.ERROR_MESSAGE);
					}
					
					
					
					
				}
				
				
				
			}
		});
		btnAlta.setBounds(6, 152, 117, 29);
		contentPane.add(btnAlta);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textNombre.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No tiene todos lo campos","Error",JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					String nombre = textNombre.getText();
					// primero la busco por el nombre
					rol.buscarRol(nombre);
					// luego la elimino
					rol.eliminarRol(rol.getRol().getId());
					
					boolean resultado = rol.eliminarRol(rol.getRol().getId());
					
					if (resultado) {
						JOptionPane.showMessageDialog(null, "La operacion se realizo con exito","Correcto",JOptionPane.INFORMATION_MESSAGE);
						limpiarCampos();
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Se produjo un error","Error",JOptionPane.ERROR_MESSAGE);
					}
					
					
					
				}
				
			}
		});
		btnEliminar.setBounds(117, 152, 117, 29);
		contentPane.add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textNombre.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No tiene todos lo campos","Error",JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					String nombre =textNombre.getText();
					rol.buscarRol(nombre);
					textDescripcion.setText(rol.getRol().getDescripcion());
					
				}
				
				
			}
		});
		btnBuscar.setBounds(112, 193, 110, 29);
		contentPane.add(btnBuscar);
		
		
		
		
	}
	
    public void limpiarCampos() {
		
    	textNombre.setText("");
    	textDescripcion.setText("");
    	
	}
}
