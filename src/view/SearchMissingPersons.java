package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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
        // Frame principal
        frame = new JFrame();
        frame.setTitle("SCPD - Sistema de Controle de Pessoas Desaparecidas");
        frame.setBounds(100, 100, 1300, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.decode("#011826"));

        // Sidebar
        sidebar = new JPanel();
        sidebar.setLayout(null);
        sidebar.setBackground(new Color(25, 35, 45));
        sidebar.setBounds(0, 0, 260, 750);
        frame.getContentPane().add(sidebar);

        // Título
        JLabel tituloSidebar = new JLabel("...", SwingConstants.CENTER);
        tituloSidebar.setFont(new Font("Arial", Font.BOLD, 22));
        tituloSidebar.setForeground(Color.WHITE);
        tituloSidebar.setBounds(0, 20, 260, 30);
        sidebar.add(tituloSidebar);

        // Subtítulo
        JLabel subtitulo = new JLabel("......", SwingConstants.CENTER);
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 12));
        subtitulo.setForeground(new Color(180, 180, 180));
        subtitulo.setBounds(0, 55, 260, 35);
        sidebar.add(subtitulo);

        // Botões do menu
        String[] menu = {"Dashboard", "Pessoas Desaparecidas", "Busca Avançada", "Novo Caso"};
        int y = 120;
        for (String item : menu) {
            JButton btn = new JButton(item);
            btn.setBounds(15, y, 230, 40);
            btn.setFocusPainted(false);
            btn.setForeground(Color.WHITE);
            btn.setBackground(new Color(25, 35, 45));
            btn.setFont(new Font("Arial", Font.PLAIN, 14));
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btn.setBorder(BorderFactory.createEmptyBorder());

            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setBackground(new Color(35, 50, 65));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(new Color(25, 35, 45));
                }
            });

            sidebar.add(btn);
            y += 50;
        }

        
    }
		
	}


