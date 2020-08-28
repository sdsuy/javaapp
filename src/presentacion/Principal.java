package presentacion;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import dto.PersonaVO;
import dto.RolVO;

import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	protected JFrame frame;
	private PersonaVO persona;
	private PanelImagen image = new PanelImagen();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Creo un punto de ingreso como administrador saltando la pantalla de login
					PersonaVO persona = new PersonaVO();
					RolVO rol = new RolVO();
					rol.setNombre("Administrador del sistema");
					persona.setRol(rol);
					// Inicio la Aplicacion principal con este usuario administrador de primer uso
					Principal window = new Principal(persona);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal(PersonaVO persona) {
		this.persona = persona;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Menu Principal");
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnAdministrar = new JMenu("Administrar");
		menuBar.add(mnAdministrar);
		
		mnAdministrar.setVisible(false);
		// Si la persona logueada es administrador del sistema muestro el menu administrador
		if(persona.getRol().getNombre().equals("Administrador del sistema")) {
			mnAdministrar.setVisible(true);
		}
		
		JMenuItem mntmPersona = new JMenuItem("Persona");
		mntmPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		mnAdministrar.add(mntmPersona);
		
		JMenuItem mntmRol = new JMenuItem("Rol");
		mntmRol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		});
		mnAdministrar.add(mntmRol);
		
		JMenuItem mntmFuncionalidad = new JMenuItem("Funcionalidad");
		mntmFuncionalidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		});
		mnAdministrar.add(mntmFuncionalidad);
		
		JMenu mnHerramientas = new JMenu("Herramientas");
		menuBar.add(mnHerramientas);
		
		JMenuItem mntmControlDeInventario = new JMenuItem("Control de Inventario");
		mnHerramientas.add(mntmControlDeInventario);
		
		JMenuItem mntmVentas = new JMenuItem("Ventas");
		mnHerramientas.add(mntmVentas);
		
		JMenuItem mntmCompas = new JMenuItem("Compas");
		mnHerramientas.add(mntmCompas);
		
		JMenuItem mntmCuentasCorrientes = new JMenuItem("Cuentas corrientes");
		mnHerramientas.add(mntmCuentasCorrientes);
		
		JMenuItem mntmSueldos = new JMenuItem("Sueldos");
		mnHerramientas.add(mntmSueldos);
	}

}
