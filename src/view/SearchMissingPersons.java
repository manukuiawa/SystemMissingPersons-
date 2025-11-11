package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
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
		String[] menu = { "Dashboard", "Pessoas Desaparecidas", "Busca Avançada", "Novo Caso" };
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

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(new Color(17, 24, 38));
		mainPanel.setBounds(260, 0, 1040, 750);
		frame.getContentPane().add(mainPanel);

		JPanel header = new JPanel(new BorderLayout());
		header.setBackground(new Color(17, 24, 38));
		header.setBorder(BorderFactory.createEmptyBorder(15, 20, 10, 20));

		JLabel lblTitulo = new JLabel("Busca Avançada por Características");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		header.add(lblTitulo, BorderLayout.WEST);

		JPanel conteudo = new JPanel();
		conteudo.setBackground(new Color(17, 24, 38));
		conteudo.setLayout(new BoxLayout(conteudo, BoxLayout.Y_AXIS));
		conteudo.setBorder(BorderFactory.createEmptyBorder(10, 25, 20, 25));

		JPanel filtroCard = new JPanel();
		filtroCard.setBackground(new Color(33, 43, 54));
		filtroCard.setLayout(new BoxLayout(filtroCard, BoxLayout.Y_AXIS));
		filtroCard.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JLabel tituloFiltro = new JLabel("Busca Avançada");
		tituloFiltro.setForeground(Color.WHITE);
		tituloFiltro.setFont(new Font("Segoe UI", Font.BOLD, 16));
		filtroCard.add(tituloFiltro);
		filtroCard.add(Box.createVerticalStrut(10));

		filtroCard.add(criarLinhaCampos(new String[] { "Altura", "Cor do Cabelo", "Cor dos Olhos" }));
		filtroCard.add(Box.createVerticalStrut(20));
		filtroCard.add(criarLinhaCampos(new String[] { "Tatuagens", "Cicatrizes", "Outros sinais" }));
		filtroCard.add(Box.createVerticalStrut(20));
		filtroCard.add(criarLinhaCampos(new String[] { "Cor da roupa", "Tipo de roupa", "Acessórios" }));
		filtroCard.add(Box.createVerticalStrut(5));

		JPanel botoesBusca = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 5));
		botoesBusca.setBackground(new Color(33, 43, 54));
		JButton btnBuscar = criarBotaoTopo("Buscar", new Color(0, 123, 255));
		JButton btnLimpar = criarBotaoTopo("Limpar", new Color(244, 45, 48));
		botoesBusca.add(btnBuscar);
		botoesBusca.add(btnLimpar);

		filtroCard.add(botoesBusca);

		conteudo.add(filtroCard);
		conteudo.add(Box.createVerticalStrut(25));

		JPanel resultadosCard = new JPanel(new BorderLayout());
		resultadosCard.setBackground(new Color(33, 43, 54));
		resultadosCard.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));

		JLabel tituloResultados = new JLabel("Resultados da Busca");
		tituloResultados.setForeground(Color.WHITE);
		tituloResultados.setFont(new Font("Segoe UI", Font.BOLD, 16));
		resultadosCard.add(tituloResultados, BorderLayout.NORTH);

		JLabel iconeBusca = new JLabel("🔍", SwingConstants.CENTER);
		iconeBusca.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 48));
		iconeBusca.setForeground(new Color(150, 150, 150));

		JLabel textoResultados = new JLabel("Utilize os filtros acima para realizar uma busca", SwingConstants.CENTER);
		textoResultados.setForeground(new Color(150, 150, 150));
		textoResultados.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		JPanel centro = new JPanel(new BorderLayout());
		centro.setOpaque(false);
		centro.add(iconeBusca, BorderLayout.CENTER);
		centro.add(textoResultados, BorderLayout.SOUTH);
		resultadosCard.add(centro, BorderLayout.CENTER);

		conteudo.add(resultadosCard);

		JScrollPane scroll = new JScrollPane(conteudo);
		scroll.setBorder(null);
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		mainPanel.add(scroll, BorderLayout.CENTER);
	}

	private JPanel criarLinhaCampos(String[] nomes) {
		JPanel linha = new JPanel(new GridLayout(1, nomes.length, 15, 0));
		linha.setBackground(new Color(26, 36, 46));

		for (String nome : nomes) {
			JTextField campo = new JTextField(nome);
			campo.setBackground(new Color(25, 35, 45));
			campo.setForeground(new Color(200, 200, 200));
			campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			campo.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
			linha.add(campo);
		}
		return linha;
	}

	private JButton criarBotaoTopo(String texto, Color cor) {
		JButton btn = new JButton(texto);
		btn.setFocusPainted(false);
		btn.setBackground(cor);
		btn.setForeground(Color.WHITE);
		btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn.setBorder(BorderFactory.createEmptyBorder(8, 18, 8, 18));
		btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		return btn;
	}

}
