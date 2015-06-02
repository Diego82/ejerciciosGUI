package ejercicio2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import javax.swing.JPasswordField;

public class Formulario {

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEmail;
	private JTextField txtLogin;
	private JPasswordField pwdContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario window = new Formulario();
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
	public Formulario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 500, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelSur = new JPanel();
		frame.getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JLabel lblErrorNombre = new JLabel("<-- Nombre no valido");
		lblErrorNombre.setVisible(false);
		
		JLabel lblErrorApellidos = new JLabel("<-- Apellido no valido");
		lblErrorApellidos.setVisible(false);
		
		JLabel lblErrorEmail = new JLabel("<-- Email no valido");
		lblErrorEmail.setVisible(false);
		
		JLabel lblErrorContrasena = new JLabel("<-- Contraseña no valida");
		lblErrorContrasena.setVisible(false);
		
		pwdContrasena = new JPasswordField();
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblErrorNombre.setVisible(false);
				lblErrorApellidos.setVisible(false);
				lblErrorEmail.setVisible(false);
				lblErrorContrasena.setVisible(false);
				
				//Activamos las alertas en caso que sea necesario
				if (txtNombre.getText().length()==0) lblErrorNombre.setVisible(true);
				if (txtApellidos.getText().length()==0) lblErrorApellidos.setVisible(true);
				if (!txtEmail.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) lblErrorEmail.setVisible(true);
				if (pwdContrasena.getPassword().length<7) lblErrorContrasena.setVisible(true);
				if (txtNombre.getText().length()==0 || txtApellidos.getText().length()==0
						|| !txtEmail.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
						|| txtEmail.getText().length()==0 ||pwdContrasena.getPassword().length<7){
					JOptionPane.showMessageDialog(frame, "El usuario no se ha creado correctamente", "WTF", JOptionPane.ERROR_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(frame, "El usuario se ha creado correctamente", "Eso es!!!", JOptionPane.INFORMATION_MESSAGE);
					try (PrintWriter out = new PrintWriter(new FileOutputStream("/home/diego/Escritorio/salida.csv"));){
						
						String nombre = txtNombre.getText();
						String apellidos = txtApellidos.getText();
						String email = txtEmail.getText();
						String login = txtLogin.getText();
						char[] password = pwdContrasena.getPassword();
						
						String usuario = nombre+";"+apellidos+";"+email+";"+login+";"+password.toString();
						
						out.println(usuario);
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
					
				
			}
		});
		panelSur.add(botonGuardar);
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		panelSur.add(botonSalir);
		
		JPanel panelCentral = new JPanel();
		frame.getContentPane().add(panelCentral, BorderLayout.CENTER);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblApellidos = new JLabel("Apellidos");
		
		JLabel lblEmail = new JLabel("Email");
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setEnabled(false);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		
		txtNombre = new JTextField();
		txtNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(txtApellidos.getText().length()!=0){
					txtLogin.setText(txtNombre.getText().toLowerCase().substring(0, 1)+txtApellidos.getText().toLowerCase().replace(" ", ""));
				}
			}
		});
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(txtNombre.getText().length()!=0){
					txtLogin.setText(txtNombre.getText().toLowerCase().substring(0, 1)+txtApellidos.getText().toLowerCase().replace(" ", ""));
				}
			}
		});
		txtApellidos.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setEnabled(false);
		txtLogin.setColumns(10);
				
		GroupLayout gl_panelCentral = new GroupLayout(panelCentral);
		gl_panelCentral.setHorizontalGroup(
			gl_panelCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCentral.createSequentialGroup()
							.addComponent(lblContrasena)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(pwdContrasena, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCentral.createSequentialGroup()
							.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lblApellidos)
								.addComponent(lblEmail)
								.addComponent(lblLogin))
							.addGap(35)
							.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtApellidos)
								.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
								.addComponent(txtEmail)
								.addComponent(txtLogin))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
						.addComponent(lblErrorNombre)
						.addComponent(lblErrorApellidos)
						.addComponent(lblErrorEmail)
						.addComponent(lblErrorContrasena))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		gl_panelCentral.setVerticalGroup(
			gl_panelCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblErrorNombre))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCentral.createSequentialGroup()
							.addComponent(lblApellidos)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEmail)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblErrorEmail))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLogin)
								.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblContrasena)
								.addComponent(lblErrorContrasena)
								.addComponent(pwdContrasena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblErrorApellidos)))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		panelCentral.setLayout(gl_panelCentral);
	}
}
