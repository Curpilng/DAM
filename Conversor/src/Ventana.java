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
		setBounds(100, 100, 322, 280);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Label Euros
		JLabel lblEuros = new JLabel("EUROS");
		lblEuros.setBounds(50, 26, 47, 50);
		contentPane.add(lblEuros);
		
		
		//Label Dolares
		JLabel lblDolares = new JLabel("DOLARES");
		lblDolares.setBounds(50, 87, 62, 50);
		contentPane.add(lblDolares);
		
		
		//Caja texto Euros
		textEuros = new JTextField();
		textEuros.setBounds(171, 43, 86, 20);
		contentPane.add(textEuros);
		textEuros.setColumns(10);
		
		
		//Caja texto Dolares
		textDolares = new JTextField();
		textDolares.setBounds(171, 102, 86, 20);
		contentPane.add(textDolares);
		textDolares.setColumns(10);
		
		
		
		//Boton Convertir
		JButton btnConvertir = new JButton("CONVERTIR");
		btnConvertir.addActionListener(new ActionListener() {
			//Accion del boton
			public void actionPerformed(ActionEvent arg0) {
				float valorEuros;
				valorEuros=Float.parseFloat(textEuros.getText());
				textDolares.setText(String.valueOf(valorEuros*valorDolar));
				
			}
		});
		btnConvertir.setBounds(83, 159, 119, 23);
		contentPane.add(btnConvertir);
	}
}
