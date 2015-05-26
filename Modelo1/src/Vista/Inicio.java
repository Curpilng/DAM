package Vista;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Inicio extends JPanel {
	private JPasswordField passwordField;

	public Inicio() {

		setBounds(100, 100, 430, 459);
		setLayout(null);
		
		//Usuarios
		JComboBox comboBoxUsuario = new JComboBox();
		comboBoxUsuario.setBounds(24, 66, 105, 20);
		add(comboBoxUsuario);
		
		//Contraseña
		passwordField = new JPasswordField();
		passwordField.setBounds(24, 108, 105, 20);
		add(passwordField);
		
		
		//Boton LogIn
		JButton btnLogIn = new JButton("LogIn");
		btnLogIn.setBounds(24, 182, 105, 23);
		add(btnLogIn);
		
		
		//Boton LogOut
		JButton btnLogOut = new JButton("LogOut");
		btnLogOut.setBounds(24, 227, 105, 23);
		add(btnLogOut);
		
		
		//Label para error
		JLabel lblError = new JLabel("");
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblError.setForeground(Color.RED);
		lblError.setBounds(24, 402, 313, 30);
		add(lblError);

	}
}
