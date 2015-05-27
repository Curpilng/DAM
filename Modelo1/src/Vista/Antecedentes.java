package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modelo.ModeloDelincuentes;

public class Antecedentes extends JPanel {
	private JTextField textAntecedentes;
	private String[] antecedentes;
	private ModeloDelincuentes mDelincuentes;

	public Antecedentes(Delincuentes delincuentes) {
		setBounds(100, 100, 430, 459);
		setLayout(null);
		
		//Antecedentes
		JLabel lblAntecedentes = new JLabel("Antecedentes");
		lblAntecedentes.setBounds(27, 45, 95, 14);
		add(lblAntecedentes);
		
		//Recogemos el array con los datos del delincuente, 6(campo Antecedentes)
		antecedentes=delincuentes.getDelincuente();
		
		textAntecedentes = new JTextField();
		textAntecedentes.setBounds(27, 87, 379, 276);
		textAntecedentes.setColumns(10);
		textAntecedentes.setText(antecedentes[6]);
		add(textAntecedentes);
		
		
		//Boton Guardar
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mDelincuentes = new ModeloDelincuentes();
				mDelincuentes.guardarAntecedente((String)delincuentes.getList().getSelectedValue(),textAntecedentes.getText());
			}
		});
		btnGuardar.setBounds(27, 411, 115, 23);
		add(btnGuardar);

	}

}
