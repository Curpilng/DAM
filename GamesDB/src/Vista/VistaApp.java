package Vista;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VistaApp extends JFrame {

	private static JPanel contentPane;
	VistaPrincipal vP = new VistaPrincipal();
	VistaJuegos vJ = new VistaJuegos();

	
	public VistaApp() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 456);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		this.setResizable(false);
		
		//Añadimos JPanel
		contentPane.add(vP, "vistaPrincipal");
		vP.setLayout(null);
		
		contentPane.add(vJ, "vistaJuegos");
		vJ.setLayout(null);
		
		//Añadimos Barra de menus
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//Añadimos los distintos menus
		JMenu mnPrincipal = new JMenu("Principal");
		menuBar.add(mnPrincipal);
		
		JMenu mnJuegos = new JMenu("Juegos");
		menuBar.add(mnJuegos);
		
		JMenu mnPerfil = new JMenu("Perfil");
		menuBar.add(mnPerfil);
		
		//Añadimos los distintos submenus
		JMenuItem mntmPrincipal = new JMenuItem("Principal");
		mnPrincipal.add(mntmPrincipal);
		
		JMenuItem mntmListaJuegos = new JMenuItem("Lista Juegos");
		mnJuegos.add(mntmListaJuegos);
		
		JMenuItem mntmPerfil = new JMenuItem("Perfil");
		mnPerfil.add(mntmPerfil);
		
	}
	
	//Carga jPanel vistaJuegos
	public static void ponerVistaJuegos(){
		CardLayout c= (CardLayout) contentPane.getLayout();
		c.show(contentPane, "vistaJuegos");
	}
	
	//Carga jPanel vistaPrincipal
	public static void ponerVistaPrincipal(){
		CardLayout c= (CardLayout) contentPane.getLayout();
		c.show(contentPane, "vistaPrincipal");
	}
}
