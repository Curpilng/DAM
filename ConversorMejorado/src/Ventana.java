import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import java.awt.Color;


public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textEuros;
	private JTextField textDolares;

	/**
	 * Create the frame.
	 */
	public Ventana(float valorDolar) {
		//Panel (Ventana)
		setTitle("Ventana Conversor");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 308);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Label Euros
		JLabel lblEuros = new JLabel("EUROS");
		lblEuros.setBounds(60, 56, 47, 50);
		contentPane.add(lblEuros);
		
		
		//Label Dolares
		JLabel lblDolares = new JLabel("DOLARES");
		lblDolares.setBounds(60, 117, 62, 50);
		contentPane.add(lblDolares);
		
		
		//Caja texto Euros
		textEuros = new JTextField();
		textEuros.setBounds(181, 73, 86, 20);
		contentPane.add(textEuros);
		textEuros.setColumns(10);
		
		
		//Caja texto Dolares
		textDolares = new JTextField();
		textDolares.setBounds(181, 132, 86, 20);
		contentPane.add(textDolares);
		textDolares.setColumns(10);
		
		//Label Mensaje de Informacion
		JLabel lblInformacion = new JLabel("INTRODUCIR UN VALOR EN EUROS ENTRE 0 Y 500 \u20AC");
		lblInformacion.setBounds(35, 16, 299, 14);
		contentPane.add(lblInformacion);
		
		//Label Mensaje de Control
		JLabel lblMensajeDeControl = new JLabel("MENSAJE DE CONTROL");
		lblMensajeDeControl.setBounds(35, 215, 151, 14);
		contentPane.add(lblMensajeDeControl);
		
		//Texto Informativo
		JTextPane textMensaje = new JTextPane();
		textMensaje.setForeground(Color.RED);
		textMensaje.setEditable(false);
		textMensaje.setBounds(35, 240, 271, 20);
		contentPane.add(textMensaje);
		
		
		
		//Boton Convertir
		JButton btnConvertir = new JButton("CONVERTIR");
		btnConvertir.setBounds(95, 178, 119, 23);
		btnConvertir.addActionListener(new ActionListener() {
			//Accion del boton
			public void actionPerformed(ActionEvent arg0) {
				
				try{
				float valorEuros;
				valorEuros=Float.parseFloat(textEuros.getText());
				
				if(valorEuros<0 || valorEuros>500){
					
					textMensaje.setText("Los euros deben estar entre 0 y 500 €");
				}else{
					textDolares.setText(String.valueOf(valorEuros*valorDolar));
					textMensaje.setText("TODO OK");
				}
				
				}catch(NumberFormatException n){
					textMensaje.setText("Se ha producido un error en la conversión");
				}

				
					
				
			}
		});
		contentPane.add(btnConvertir);
		
		
	}
}
