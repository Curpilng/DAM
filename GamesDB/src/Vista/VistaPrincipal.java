package Vista;

import java.awt.Image;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Modelo.UsuariosModelo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaPrincipal extends JPanel {
	private JPasswordField passwordField;
	private UsuariosModelo usuarios;

	public VistaPrincipal() {
		setLayout(null);
		this.setBounds(0, 0, 414, 497);
		
		// Label para Avatar
		Image avatar = new ImageIcon(this.getClass().getResource("/images/descarga.png")).getImage();
		JLabel lblAvatar = new JLabel("Avatar");
		lblAvatar.setBounds(10, 11, 154, 164);
		lblAvatar.setIcon(new ImageIcon(avatar));
		this.add(lblAvatar);
		
		//Boton Juegos
		JButton btnJuegos = new JButton("Juegos >");
		btnJuegos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VistaApp.ponerVistaJuegos();
			}
		});
		btnJuegos.setBounds(205, 11, 185, 23);
		add(btnJuegos);
		
		//Boton Perfil
		JButton btnPerfil = new JButton("Perfil >");
		btnPerfil.setBounds(205, 42, 185, 23);
		add(btnPerfil);
		
		//Label Usuario
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 186, 46, 14);
		add(lblUsuario);
		
		//ComboBox Usuario
		JComboBox boxUsuario = new JComboBox();
		boxUsuario.setBounds(10, 217, 154, 20);
		add(boxUsuario);
		
		//Rellenamos el comboBox
		usuarios = new UsuariosModelo();
		
		Iterator<String> it = usuarios.getUsuarios().iterator();
			while(it.hasNext()){
				boxUsuario.addItem((String)it.next());
			}
		
		
		//Label Contraseña
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a");
		lblNewLabel.setBounds(10, 257, 86, 14);
		add(lblNewLabel);
		
		//Campo para contraseña
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 282, 154, 20);
		add(passwordField);
		
		//Boton Login
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(10, 324, 154, 23);
		btnLogin.setEnabled(false);
		add(btnLogin);
		
		//Boton Registrarse
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(10, 358, 154, 23);
		btnRegistrarse.setEnabled(false);
		add(btnRegistrarse);

		
	}
}
