package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dto.PersonaBO;
import dto.PersonaVO;
import dto.RolVO;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textMail;
	private JPasswordField passwordClave;
	
	private PersonaBO persona = new PersonaBO();

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		passwordClave.setBounds(213, 121, 111, 20);
		contentPane.add(passwordClave);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo electr\u00F3nico:");
		lblCorreoElectrnico.setBounds(65, 48, 142, 20);
		contentPane.add(lblCorreoElectrnico);
		
		JLabel lblClaveDeAccesso = new JLabel("Clave de accesso:");
		lblClaveDeAccesso.setBounds(65, 123, 116, 17);
		contentPane.add(lblClaveDeAccesso);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textMail.getText();
				String password = passwordClave.getText();
				persona.buscarPersona(username, password);
				PersonaVO peraux = persona.getPersona();
				if(peraux.getId() > 0) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								// Inicio la Aplicacion principal con este usuario administrador de primer uso
								Principal window = new Principal(peraux);
								window.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					Login.this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Usuario o clave no son correctos", "Atento!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnLogin.setBounds(165, 180, 89, 23);
		contentPane.add(btnLogin);
		JLabel lblCorreo = new JLabel("New label");
		lblCorreo.setIcon(new ImageIcon(Login.class.getResource("/imagen/password.png")));
		lblCorreo.setBounds(342, 105, 63, 59);
		contentPane.add(lblCorreo);
		
		
		JLabel lblEmail = new JLabel("New label");
		lblEmail.setIcon(new ImageIcon(Login.class.getResource("/imagen/imail.png")));
		lblEmail.setBounds(336, 6, 85, 71);
		contentPane.add(lblEmail);
	}
}
