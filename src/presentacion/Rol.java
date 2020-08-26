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
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Rol extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textDescripcion;
	
	private RolBO rol = new RolBO();
	private FuncionalidadBO funcionalidad = new FuncionalidadBO();
	private List<String> selectedNombresFuncionalidades = new ArrayList<>();

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
		setBounds(100, 100, 483, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setBounds(6, 51, 238, 26);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(6, 119, 238, 26);
		contentPane.add(textDescripcion);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(6, 24, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(6, 92, 95, 16);
		contentPane.add(lblDescripcion);
		
		// Lleno el listFuncionalidades
		funcionalidad.obtenerFuncionalidades();
		LinkedList<FuncionalidadVO> funcionalidades = funcionalidad.getFuncionalidades();
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(FuncionalidadVO funcionalidad: funcionalidades) {
			listModel.addElement(funcionalidad.getNombre());
		}
		
		JList listFuncionalidades = new JList(listModel);
		listFuncionalidades.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(!arg0.getValueIsAdjusting()) {
					selectedNombresFuncionalidades = listFuncionalidades.getSelectedValuesList();
				}
			}
		});
		listFuncionalidades.setBounds(254, 35, 203, 254);
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
					rolaux.setFuncionalidades(selectedFuncionalidades(selectedNombresFuncionalidades)); // llamo al metodo que crea el LinkedList y lo seteo
					
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
		btnListar.setBounds(6, 233, 238, 29);
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
					rolaux.setFuncionalidades(selectedFuncionalidades(selectedNombresFuncionalidades)); // llamo al metodo que crea elLinkedList y lo seteo
					
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
		btnEliminar.setBounds(127, 152, 117, 29);
		contentPane.add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textNombre.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No tiene todos lo campos","Error",JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					String nombre = textNombre.getText();
					rol.buscarRol(nombre);
					textDescripcion.setText(rol.getRol().getDescripcion());
					ListSelectionModel selectionModel = new DefaultListSelectionModel();
					int[] indices = new int[rol.getRol().getFuncionalidades().size()];
					int n = 0;
					for(FuncionalidadVO funaux: rol.getRol().getFuncionalidades()) {
						System.out.println(funaux.getNombre());
						indices[n] = listModel.indexOf(funaux.getNombre());
						n++;
					}
					listFuncionalidades.setSelectedIndices(indices);
				}
				
				
			}
		});
		btnBuscar.setBounds(127, 193, 117, 29);
		contentPane.add(btnBuscar);
		
		JLabel lblFuncionalidades = new JLabel("Funcionalidades:");
		lblFuncionalidades.setBounds(244, 10, 172, 14);
		contentPane.add(lblFuncionalidades);	
		
	}
	
    private void limpiarCampos() {
		
    	textNombre.setText("");
    	textDescripcion.setText("");
    	
	}
    
    private LinkedList<FuncionalidadVO> selectedFuncionalidades(List<String> listaNombresFuncionalidades){
    	LinkedList<FuncionalidadVO> funcionalidades = new LinkedList<>();
    	for(String nombreFuncionalidad: listaNombresFuncionalidades) {
    		funcionalidad.buscarFuncionalidad(nombreFuncionalidad);
    		funcionalidades.add(funcionalidad.getFuncionalidad());
    	}
    	return funcionalidades;
    }
}
