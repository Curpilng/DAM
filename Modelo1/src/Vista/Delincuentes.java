package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import Modelo.ModeloDelincuentes;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Color;
import java.awt.Font;

public class Delincuentes extends JPanel {
	private JTextField textNombre;
	private JTextField textEdad;
	private JTextField textSexo;
	private JTextField textNacionalidad;
	private JTextField textDireccion;
	private JTextField textPoblacion;
	private ModeloDelincuentes mDelincuentes;
	private String[] delincuente;
	private JList list;

	public Delincuentes(Principal p) {
		setBounds(100, 100, 430, 459);
		setLayout(null);
		
		//Scroll
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 186, 405);
		add(scrollPane);
		
		//Lista
		mDelincuentes = new ModeloDelincuentes();
		//Hacemos un array con los datos cogidos de la base de datos, para poder hacer la lista
		String[] delincuentes = mDelincuentes.getUsuarios().toArray(new String[mDelincuentes.getUsuarios().size()]);
		list = new JList(delincuentes);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				//Cogemos los datos del delincuente y los plasmamos en el textfield
				Iterator<String[]> it = mDelincuentes.getDelincuentes((String)list.getSelectedValue()).iterator();
				while(it.hasNext()){
					delincuente = it.next();
					textNombre.setText(delincuente[0]);
					textEdad.setText(delincuente[1]);
					textSexo.setText(delincuente[2]);
					textNacionalidad.setText(delincuente[3]);
					textDireccion.setText(delincuente[4]);
					textPoblacion.setText(delincuente[5]);
				}
			
			}
		});
		
		scrollPane.setViewportView(list);

		
		//Nombre
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(218, 30, 58, 14);
		add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(218, 55, 164, 20);
		add(textNombre);
		textNombre.setColumns(10);
		
		//Edad
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(218, 99, 46, 14);
		add(lblEdad);
		
		textEdad = new JTextField();
		textEdad.setEditable(false);
		textEdad.setBounds(218, 123, 58, 20);
		add(textEdad);
		textEdad.setColumns(10);
		
		//Sexo
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(312, 99, 46, 14);
		add(lblSexo);
		
		textSexo = new JTextField();
		textSexo.setEditable(false);
		textSexo.setBounds(312, 123, 70, 20);
		add(textSexo);
		textSexo.setColumns(10);
		
		//Nacionalidad
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(218, 175, 84, 14);
		add(lblNacionalidad);
		
		textNacionalidad = new JTextField();
		textNacionalidad.setEditable(false);
		textNacionalidad.setBounds(218, 210, 164, 20);
		add(textNacionalidad);
		textNacionalidad.setColumns(10);
		
		//Direccion
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(218, 258, 70, 14);
		add(lblDireccin);
		
		textDireccion = new JTextField();
		textDireccion.setEditable(false);
		textDireccion.setBounds(218, 289, 164, 20);
		add(textDireccion);
		textDireccion.setColumns(10);
		
		//Poblacion
		JLabel lblPoblacin = new JLabel("Poblaci\u00F3n");
		lblPoblacin.setBounds(218, 331, 58, 14);
		add(lblPoblacin);
		
		textPoblacion = new JTextField();
		textPoblacion.setEditable(false);
		textPoblacion.setBounds(218, 365, 164, 20);
		add(textPoblacion);
		textPoblacion.setColumns(10);
		
		//Mensaje de advertencia
		JLabel lblElijaUnDelincuente = new JLabel("Elija un delincuente primero");
		lblElijaUnDelincuente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblElijaUnDelincuente.setForeground(Color.RED);
		lblElijaUnDelincuente.setBounds(10, 0, 266, 25);
		lblElijaUnDelincuente.setVisible(false);
		add(lblElijaUnDelincuente);
		
		
		//Boton Antecedentes
		JButton btnAntecedentes = new JButton("Antecedentes >>");
		btnAntecedentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Miramos si no ha sido escogido un delincuente
				if(list.isSelectionEmpty()){
					lblElijaUnDelincuente.setVisible(true);
				}else{
					p.ponerAntecedentes();
				}
				
			}
		});
		btnAntecedentes.setBounds(218, 412, 164, 23);
		add(btnAntecedentes);
		
		
		

		
		

	}

	//Nos devuelve el array con los datos del delincuente
	public String[] getDelincuente() {
		return delincuente;
	}

	//Cogemos la lista para ver en Antecedentes el Delincuente escogido
	public JList getList() {
		return list;
	}

}
