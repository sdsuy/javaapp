package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dto.FuncionalidadBO;
import dto.FuncionalidadVO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Funcionalidad extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	
	private FuncionalidadBO funcionalidad = new FuncionalidadBO();

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
				
			    if (txtNombre.getText().isEmpty() || txtDescripcion.getText().isEmpty()) {
			    	JOptionPane.showMessageDialog(null, "No tiene todos lo campos","Error",JOptionPane.ERROR_MESSAGE);
			    }
				
			    else {
			    	FuncionalidadVO funaux = new FuncionalidadVO();
					funaux.setNombre(txtNombre.getText());
					funaux.setDescripcion(txtDescripcion.getText());
					
					
					boolean resultado = funcionalidad.agregarFuncionalidad(funaux);
					
					if (resultado) {
						JOptionPane.showMessageDialog(null, "La operacion se realizo con exito","Error",JOptionPane.INFORMATION_MESSAGE);
						limpiarCampos();
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Se produjo un error","Error",JOptionPane.ERROR_MESSAGE);
					}
					
					
			    }
				
			}
		});
		btnAlta.setBounds(241, 24, 117, 29);
		contentPane.add(btnAlta);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtNombre.getText().isEmpty() || txtDescripcion.getText().isEmpty()) {
			    	JOptionPane.showMessageDialog(null, "No tiene todos lo campos","Error",JOptionPane.ERROR_MESSAGE);
			    }
				
				else {
					FuncionalidadVO funaux = new FuncionalidadVO();
					funaux.setNombre(txtNombre.getText());
					// primero la busco por el nombre
					funcionalidad.buscarFuncionalidad(funaux.getNombre());
					// segundo recupero la funcionalidad encontrada
					funaux = funcionalidad.getFuncionalidad();
					// tercero cambio y actualizo el valor de descripción por el nuevo
					funaux.setDescripcion(txtDescripcion.getText());
					
					
					boolean resultado = funcionalidad.actualizarFuncionalidad(funaux);
					
					if (resultado) {
						
						limpiarCampos();
						
						JOptionPane.showMessageDialog(null, "La operacion se realizo con exito","Error",JOptionPane.INFORMATION_MESSAGE);
						
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Se produjo un error","Error",JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
				
				
			}
		});
		btnModificar.setBounds(241, 108, 117, 29);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtNombre.getText().isEmpty()) {
			    	JOptionPane.showMessageDialog(null, "No tiene todos lo campos","Error",JOptionPane.ERROR_MESSAGE);
			    }
				
				else {
					String nombre = txtNombre.getText();
					// primero la busco por el nombre
					funcionalidad.buscarFuncionalidad(nombre);
					// luego la elimino
					
					
					boolean resultado = funcionalidad.eliminarFuncionalidad(funcionalidad.getFuncionalidad().getId());
					
					if (resultado) {
						limpiarCampos();
						
						JOptionPane.showMessageDialog(null, "La operacion se realizo con exito","Error",JOptionPane.INFORMATION_MESSAGE);
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Se produjo un error","Error",JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
				
				
			}
		});
		btnEliminar.setBounds(241, 150, 117, 29);
		contentPane.add(btnEliminar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// -- Codigo para listar
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							// Actualizo la lista de funcionalidades
							funcionalidad.obtenerFuncionalidades();
							String[] columnas = { "Nombre", "Descripcion" };
							// envio el
							Listado frame = new Listado(funcionalidad.getFuncionalidades(), columnas);
							frame.setVisible(true);
							
							
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				// -- FIN
			}
		});
		btnListar.setBounds(241, 192, 117, 29);
		contentPane.add(btnListar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtNombre.getText().isEmpty()) {
			    	JOptionPane.showMessageDialog(null, "No tiene todos lo campos","Error",JOptionPane.ERROR_MESSAGE);
			    }
				
				else {
					String nombre = txtNombre.getText();
					// primero la busco por el nombre
					funcionalidad.buscarFuncionalidad(nombre);
					// luego seteo la descripción
					txtDescripcion.setText(funcionalidad.getFuncionalidad().getDescripcion());
					
					limpiarCampos();
					
					JOptionPane.showMessageDialog(null, "La operacion se realizo con exito","Error",JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
		});
		btnBuscar.setBounds(241, 64, 117, 29);
		contentPane.add(btnBuscar);
	}
	
    private void limpiarCampos() {
		
    	txtNombre.setText("");
    	txtDescripcion.setText("");
    	
	}
}
