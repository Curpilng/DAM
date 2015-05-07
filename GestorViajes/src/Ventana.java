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
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textEuros;
	private JTextField textResultado;
	String divisa;
	DatosGenerales datos = new DatosGenerales();

	/**
	 * Create the frame.
	 */
	public Ventana() {
		
		
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
		
		
		//Caja texto Euros
		textEuros = new JTextField();
		textEuros.setBounds(181, 73, 86, 20);
		contentPane.add(textEuros);
		textEuros.setColumns(10);
		
		
		//Caja texto Dolares
		textResultado = new JTextField();
		textResultado.setBounds(181, 132, 86, 20);
		contentPane.add(textResultado);
		textResultado.setColumns(10);
		
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
		
		//Desplegable de Divisas
		JComboBox despDivisas = new JComboBox();
		despDivisas.setBounds(60, 132, 77, 20);
		contentPane.add(despDivisas);
		
		//Llenamos el desplegable
		for(int i=0;i<datos.getNombre().length;i++){
			despDivisas.addItem(datos.getNombre()[i]);
		}
		
		//Cogemos el valor inicial del desplegable
		divisa = (String)despDivisas.getSelectedItem();
		textMensaje.setText("SELECCIONADA LA MONEDA: "+divisa);
		
		//Cogemos el valor del item seleccionado en el desplegable
		despDivisas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				divisa = (String)despDivisas.getSelectedItem();
				textMensaje.setText("SELECCIONADA LA MONEDA: "+divisa);
			}
		});
		
		
		
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
					//Dependiendo de lo que escojamos en el desplegable se hará unas cosas o otras.
					switch(divisa){
						case "Dolares":
							textResultado.setText(String.valueOf(valorEuros*datos.getValor()[0]));
							textMensaje.setText("TODO OK");
							break;
						case "Libras":
							textResultado.setText(String.valueOf(valorEuros*datos.getValor()[1]));
							textMensaje.setText("TODO OK");
							break;
						case "Yen":
							textResultado.setText(String.valueOf(valorEuros*datos.getValor()[2]));
							textMensaje.setText("TODO OK");
							break;
					}

				}
				
				}catch(NumberFormatException n){
					textMensaje.setText("Se ha producido un error en la conversión");
				}
				
			}
		});
		
		contentPane.add(btnConvertir);
		
	}
}

