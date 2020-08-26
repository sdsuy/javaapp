package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.lang.reflect.Field;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Listado extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listado frame = new Listado(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param <T>
	 */
	public <T> Listado(LinkedList<T> lista, String[] columnas) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		int x = lista.size();
		int y = columnas.length;
		
		Object[][] datos = new Object[x][y];
		
		for(T elemento: lista) {
			int count = -1;
			Class<?> clase = elemento.getClass();
			for(Field campo: clase.getDeclaredFields()) {
				if(count >=0 && count < y) {
					campo.setAccessible(true); // permite acceder a los atributos privados
					try {
						datos[lista.indexOf(elemento)][count] = campo.get(elemento);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
				count++;
			}
		}
		contentPane.setLayout(null);
		
		table = new JTable(datos, columnas);
		table.setBounds(0, 0, 1, 1);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(5, 5, 424, 251);
		contentPane.add(scrollPane);
	}
}
