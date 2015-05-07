package Vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaJuegos extends JPanel {

	public VistaJuegos() {
		setLayout(null);
		this.setBounds(0, 0, 414, 497);
		
		//Boton volver
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaApp.ponerVistaPrincipal();
			}
		});
		btnVolver.setBounds(149, 121, 89, 23);
		add(btnVolver);

	}
}
