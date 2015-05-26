package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Modelo.ModeloUsuarios;

public class Inicio extends JPanel {
	private JPasswordField passwordField;
	private ModeloUsuarios mUsuarios;
	private boolean logIn;
	private JLabel lblError;
	private JButton btnLogIn;
	
	public Inicio() {

		setBounds(100, 100, 430, 459);
		setLayout(null);
		
		//Usuarios
		JComboBox comboBoxUsuario = new JComboBox();
		comboBoxUsuario.setBounds(24, 66, 105, 20);
		
		mUsuarios = new ModeloUsuarios();
		
		Iterator<String> it = mUsuarios.getUsuarios().iterator();
		while(it.hasNext()){
			comboBoxUsuario.addItem((String)it.next());
		}
		
		add(comboBoxUsuario);
		
		//Contraseña
		passwordField = new JPasswordField();
		passwordField.setBounds(24, 108, 105, 20);
		add(passwordField);
		
		//Label para error
				lblError = new JLabel("");
				lblError.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblError.setForeground(Color.RED);
				lblError.setBounds(24, 392, 385, 40);
				add(lblError);
				
				
		//Boton LogOut
		JButton btnLogOut = new JButton("LogOut");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logIn=false;
				btnLogOut.setEnabled(false);
				btnLogIn.setEnabled(true);
				lblError.setText("Has hecho LogOut");

			}
		});
		btnLogOut.setEnabled(false);
		btnLogOut.setBounds(24, 227, 105, 23);
		add(btnLogOut);
		
		
		//Boton LogIn
		btnLogIn = new JButton("LogIn");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String contrasenya = String.valueOf(passwordField.getPassword());

				if(contrasenya.isEmpty()){
					lblError.setText("El campo contraseña no puede estar vacío");
				}else{
					if(mUsuarios.logIn((String) comboBoxUsuario.getSelectedItem()).equals(contrasenya)){
						btnLogOut.setEnabled(true);
						btnLogIn.setEnabled(false);	
						lblError.setText("Has hecho LogIn perfectamente");
						passwordField.setText("");
						logIn=true;
					}else{
						lblError.setText("Contraseña incorrecta");
					}
					
				}
			}
		});
		btnLogIn.setBounds(24, 182, 105, 23);
		add(btnLogIn);
		
		

	}

	public boolean isLogIn() {
		return logIn;
	}

	public JLabel getLblError() {
		return lblError;
	}


}
