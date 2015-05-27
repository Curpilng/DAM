package Vista;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Inicio inicio = new Inicio();
	private Delincuentes delincuentes = new Delincuentes(this);
	private Antecedentes antecedentes;



	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new CardLayout(0, 0));
		setContentPane(contentPane);
		
		//Añadimos los JPanel
		contentPane.add(inicio,"Inicio");
		contentPane.add(delincuentes,"Delincuentes");

		
		//Barra de menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//Secciones del menu
		JMenu mnInicio = new JMenu("Inicio");
		mnInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CardLayout c = (CardLayout) contentPane.getLayout();
				c.show(contentPane, "Inicio");
			}
		});
		menuBar.add(mnInicio);
		
		JMenu mnDelincuentes = new JMenu("Delincuentes");
		mnDelincuentes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Si estamos logueados nos dejará entrar, sino nos mostrará un mensaje
				if(inicio.isLogIn()==true){
					CardLayout c = (CardLayout)contentPane.getLayout();
					c.show(contentPane, "Delincuentes");
				}else{
					inicio.getLblError().setText("Tienes que hacer LogIn primero");
				}
				
				
			}
		});
		menuBar.add(mnDelincuentes);
		
	}
	
	//Añade y carga el jPanel Antecedentes
	public void ponerAntecedentes(){
		antecedentes = new Antecedentes(delincuentes);
		contentPane.add(antecedentes,"Antecedentes");

		
		CardLayout c = (CardLayout)contentPane.getLayout();
		c.show(contentPane, "Antecedentes");
		
	}

}
