package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
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
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnAdministrar = new JMenu("Administrar");
		menuBar.add(mnAdministrar);
		
		JMenuItem mntmPersona = new JMenuItem("Persona");
		mnAdministrar.add(mntmPersona);
		
		JMenuItem mntmRol = new JMenuItem("Rol");
		mnAdministrar.add(mntmRol);
		
		JMenuItem mntmFuncionalidad = new JMenuItem("Funcionalidad");
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
