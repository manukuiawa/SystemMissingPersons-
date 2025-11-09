package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SearchMissingPersons {

	private JFrame frame;
	private JPanel sidebar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchMissingPersons window = new SearchMissingPersons();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchMissingPersons() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.getContentPane().setFont(new Font("Arial", Font.BOLD, 18));
		
		
		frame.setSize(1300, 750);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#011826"));
		
		
		//Sidebar 
		
		sidebar = new JPanel();
		sidebar.setLayout(null);
		sidebar.setBackground(new Color(25,35,45));
		sidebar.setBounds(0,0,260,750);
		frame.getContentPane().add(sidebar);
		
		//titulo do sidebar
		JLabel tituloSidebar = new JLabel("...", SwingConstants.CENTER);
		tituloSidebar.setFont(new Font("Arial", Font.BOLD, 22));
		tituloSidebar.setForeground(Color.WHITE);
		tituloSidebar.setBounds(0, 20, 260, 30);
		sidebar.add(tituloSidebar);
		
		//subtitulo do sidebar
		JLabel subtitulo = new JLabel("...............", SwingConstants.CENTER);
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 12));
        subtitulo.setForeground(new Color(180, 180, 180));
        subtitulo.setBounds(0, 55, 260, 35);
        sidebar.add(subtitulo);
		
        
		
	}

}
