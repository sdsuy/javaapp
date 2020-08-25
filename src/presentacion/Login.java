package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textMail;
	private JPasswordField passwordClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textMail = new JTextField();
		textMail.setBounds(213, 48, 111, 20);
		contentPane.add(textMail);
		textMail.setColumns(10);
		
		passwordClave = new JPasswordField();
		passwordClave.setBounds(213, 87, 111, 20);
		contentPane.add(passwordClave);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo electr\u00F3nico:");
		lblCorreoElectrnico.setBounds(87, 48, 116, 20);
		contentPane.add(lblCorreoElectrnico);
		
		JLabel lblClaveDeAccesso = new JLabel("Clave de accesso:");
		lblClaveDeAccesso.setBounds(87, 89, 116, 17);
		contentPane.add(lblClaveDeAccesso);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(156, 146, 89, 23);
		contentPane.add(btnLogin);
	}
}
