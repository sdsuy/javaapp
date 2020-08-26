package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basededatos.DAOPersona;
import dto.PersonaBO;
import dto.PersonaVO;
import dto.RolBO;
import dto.RolVO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class Persona extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre1;
	private JTextField textNombre2;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JPasswordField passwordFieldpaswordClave;
	private JPasswordField passwordFieldRepetirClave;
	private JTextField textMail;
	private JTextField textDocumento;
	
	private PersonaBO persona = new PersonaBO();
	private RolBO rol = new RolBO();

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 491, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNombre1 = new JTextField();
		textNombre1.setBounds(6, 103, 107, 26);
		contentPane.add(textNombre1);
		textNombre1.setColumns(10);
		
		textNombre2 = new JTextField();
		textNombre2.setColumns(10);
		textNombre2.setBounds(125, 103, 107, 26);
		contentPane.add(textNombre2);
		
		textApellido1 = new JTextField();
		textApellido1.setColumns(10);
		textApellido1.setBounds(6, 173, 107, 26);
		contentPane.add(textApellido1);
		
		textApellido2 = new JTextField();
		textApellido2.setColumns(10);
		textApellido2.setBounds(125, 173, 107, 26);
		contentPane.add(textApellido2);
		
		JLabel lblNewLabel = new JLabel("Nombres");
		lblNewLabel.setBounds(6, 81, 107, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(6, 146, 107, 16);
		contentPane.add(lblApellidos);
		
		passwordFieldpaswordClave = new JPasswordField();
		passwordFieldpaswordClave.setBounds(242, 103, 107, 26);
		contentPane.add(passwordFieldpaswordClave);
		
		JLabel lblContrasea = new JLabel("Clave");
		lblContrasea.setBounds(242, 81, 75, 16);
		contentPane.add(lblContrasea);
		
		passwordFieldRepetirClave = new JPasswordField();
		passwordFieldRepetirClave.setBounds(242, 173, 107, 26);
		contentPane.add(passwordFieldRepetirClave);
		
		JComboBox cmbBoxRol = new JComboBox();
		cmbBoxRol.setBounds(6, 233, 226, 26);
		contentPane.add(cmbBoxRol);
		
		
		// Lleno el cmbBoxRol con los nombres de los roles
		rol.obtenerRoles();
		LinkedList<RolVO> roles = rol.getRoles();
		for(RolVO rol: roles) {
			cmbBoxRol.addItem(rol.getNombre());
		}
		
		JLabel lblNewLabel_1 = new JLabel("Documento");
		lblNewLabel_1.setBounds(6, 28, 96, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mail");
		lblNewLabel_1_1.setBounds(242, 28, 107, 16);
		contentPane.add(lblNewLabel_1_1);
		
		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBounds(242, 55, 224, 26);
		contentPane.add(textMail);
		
		JLabel lblRepetirContrasea = new JLabel("Repetir Clave");
		lblRepetirContrasea.setBounds(242, 146, 119, 16);
		contentPane.add(lblRepetirContrasea);
		
		JDateChooser dateFechaNac = new JDateChooser();
		dateFechaNac.setDateFormatString("dd/MM/yyyy");
		dateFechaNac.setBounds(359, 103, 107, 26);
		contentPane.add(dateFechaNac);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textApellido1.getText().isEmpty() || textApellido2.getText().isEmpty() || textNombre1.getText().isEmpty() || textMail.getText().isEmpty() || 
						 passwordFieldRepetirClave.getText().isEmpty() || textDocumento.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No tiene todos lo campos","Error",JOptionPane.ERROR_MESSAGE);
				}else {
					String repClave ="";
					
					// tomo el nombre del rol del comboBox y lo paso a rolaux desde el BO luego de buscarlo
					String nombreRol = cmbBoxRol.getSelectedItem().toString();
					rol.buscarRol(nombreRol);
					RolVO rolaux = rol.getRol();
					
					PersonaBO persona = new PersonaBO();
					PersonaVO peraux = new PersonaVO();
					peraux.setDocumento(textDocumento.getText());
					peraux.setApellido1(textApellido1.getText());
					peraux.setApellido2(textApellido2.getText());
					peraux.setNombre1(textNombre1.getText());
					peraux.setNombre2(textNombre2.getText());
					java.sql.Date sqldate = new java.sql.Date(dateFechaNac.getDate().getTime());
					peraux.setFecha_nac(sqldate);
					peraux.setMail(textMail.getText());
					peraux.setClave(passwordFieldpaswordClave.getText());
					peraux.setRol(rolaux);
					repClave = passwordFieldRepetirClave.getText();
					if(repClave.equals(passwordFieldpaswordClave.getText())) {
						
						
						boolean resultado = persona.agregarPersona(peraux);
						
						if (resultado) {
							limpiarCampos();
							
							JOptionPane.showMessageDialog(null, "La operacion se realizo con exito","Correcto",JOptionPane.INFORMATION_MESSAGE);
						}
						
						else {
							JOptionPane.showMessageDialog(null, "Se produjo un error","Error",JOptionPane.ERROR_MESSAGE);
						}
						
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Clave no coincide","Error",JOptionPane.ERROR_MESSAGE);
					}
				}	
				
			}
		});
		btnAlta.setBounds(6, 283, 107, 29);
		contentPane.add(btnAlta);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textDocumento.getText().isEmpty()) {
					
			    	JOptionPane.showMessageDialog(null, "No tiene todos lo campos","Error",JOptionPane.ERROR_MESSAGE);
			    }
				
				else {
					PersonaVO per = new PersonaVO();
					persona.buscarPersona(textDocumento.getText());
					textDocumento.setText(per.getDocumento());
					textApellido1.setText(per.getApellido1());
					textApellido2.setText(per.getApellido2());
					textNombre1.setText(per.getNombre1());
					textNombre2.setText(per.getNombre2());
					textMail.setText(per.getMail());
					
					limpiarCampos();
					
					JOptionPane.showMessageDialog(null, "La operacion se realizo con exito","Correcto",JOptionPane.INFORMATION_MESSAGE);
				}
				
				
	
			}
		});
		btnBuscar.setBounds(125, 55, 107, 26);
		contentPane.add(btnBuscar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textApellido1.getText().isEmpty() || textApellido2.getText().isEmpty() || textNombre1.getText().isEmpty() || textMail.getText().isEmpty() || passwordFieldpaswordClave.getText().isEmpty() || 
						 passwordFieldRepetirClave.getText().isEmpty() || textDocumento.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "No tiene todos lo campos","Error",JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					PersonaVO peraux = new PersonaVO();
					persona.buscarPersona(textDocumento.getText());
					peraux = persona.getPersona();
					peraux.setDocumento(textDocumento.getText());
					peraux.setApellido1(textApellido1.getText());
					peraux.setApellido2(textApellido2.getText());
					peraux.setNombre1(textNombre1.getText());
					peraux.setNombre2(textNombre2.getText());
					java.sql.Date sqldate = new java.sql.Date(dateFechaNac.getDate().getTime());
					peraux.setFecha_nac(sqldate);
					peraux.setClave(passwordFieldpaswordClave.getText());
					peraux.setMail(textMail.getText());
					
					
					boolean resultado = persona.actualizarPersona(peraux);
					
					if (resultado) {
						limpiarCampos();
						
						JOptionPane.showMessageDialog(null, "La operacion se realizo con exito","Correcto",JOptionPane.INFORMATION_MESSAGE);
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Se produjo un error","Error",JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
				
				
			}
		});
		btnModificar.setBounds(125, 283, 107, 29);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				boolean resultado = persona.eliminarPersona(persona.getPersona().getId());
				
				if (resultado) {
					limpiarCampos();
					
					JOptionPane.showMessageDialog(null, "La operacion se realizo con exito","Correcto",JOptionPane.INFORMATION_MESSAGE);
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Se produjo un error","Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnEliminar.setBounds(242, 283, 107, 29);
		contentPane.add(btnEliminar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// -- Codigo para listar
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							// Actualizo la lista de personas
							persona.obtenerPersonas();
							String[] columnas = { "ID_PERSONA", "DOCUMENTO", "APELLIDO1", "APELLIDO2", "NOMBRE1", "NOMBRE2", "FECHA_NAC", "CLAVE", "MAIL", "ID_Rol" };
							
							Listado frame = new Listado(persona.getPersonas(), columnas);
							frame.setVisible(true);
							
							
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnListar.setBounds(359, 283, 107, 29);
		contentPane.add(btnListar);
		
		JLabel lblNewLabel_1_2 = new JLabel("Rol");
		lblNewLabel_1_2.setBounds(6, 210, 61, 16);
		contentPane.add(lblNewLabel_1_2);
		
		textDocumento = new JTextField();
		textDocumento.setColumns(10);
		textDocumento.setBounds(6, 55, 107, 26);
		contentPane.add(textDocumento);
		
		JLabel lblFechaDeNac = new JLabel("Fecha de Nacimiento");
		lblFechaDeNac.setBounds(359, 82, 107, 15);
		contentPane.add(lblFechaDeNac);
	}
	
    public void limpiarCampos() {
		
    	textDocumento.setText("");
    	textApellido1.setText("");
    	textApellido2.setText("");
    	textNombre1.setText("");
    	textNombre2.setText("");
    	passwordFieldpaswordClave.setText("");
    	textMail.setText("");
    	
	}
}
