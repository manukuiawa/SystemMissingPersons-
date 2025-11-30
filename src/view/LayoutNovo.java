package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import dao.DisappearanceListDao;
import model.DisappearanceListItem;
import model.StatusRegister;

public class LayoutNovo extends JFrame {

	private JPanel painelAtivos;
	private JPanel listaPendentes;
	private JPanel listaEncerrados;

	private List<DisappearanceListItem> desaparecidos;

	public LayoutNovo() {
		setTitle("SCPD - Sistema de Controle de Pessoas Desaparecidas");
		setSize(1300, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.decode("#011826"));

		// ----------------- SIDEBAR -----------------
		JPanel sidebar = new JPanel();
		sidebar.setLayout(null);
		sidebar.setBackground(new Color(25, 35, 45));
		sidebar.setBounds(0, 0, 260, 750);
		getContentPane().add(sidebar);

		JLabel tituloSidebar = new JLabel("SCPD", SwingConstants.CENTER);
		tituloSidebar.setFont(new Font("Arial", Font.BOLD, 22));
		tituloSidebar.setForeground(Color.WHITE);
		tituloSidebar.setBounds(0, 20, 260, 30);
		sidebar.add(tituloSidebar);

		JLabel subtitulo = new JLabel("Controle de Desaparecidos", SwingConstants.CENTER);
		subtitulo.setFont(new Font("Arial", Font.PLAIN, 12));
		subtitulo.setForeground(new Color(180, 180, 180));
		subtitulo.setBounds(0, 55, 260, 35);
		sidebar.add(subtitulo);

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

			switch (item) {
			case "Novo Caso":
				btn.addActionListener(e -> {
					SwingUtilities.invokeLater(() -> {
						RegisterPersonMissing tela = new RegisterPersonMissing();
						tela.abrir();
					});
				});
				break;

			case "Dashboard":
				btn.addActionListener(e -> {
					SwingUtilities.invokeLater(() -> {
						DashboardVisual dashboard = new DashboardVisual();
						dashboard.setVisible(true);
					});
				});
				break;

			case "Busca Avançada":
				btn.addActionListener(e -> {
					SwingUtilities.invokeLater(() -> {
						SearchMissingPersons busca = new SearchMissingPersons();
						busca.abrir(); // chama o frame interno
					});
				});
				break;

			default:
				System.out.println("Opção não configurada: " + item);
			}

			sidebar.add(btn);
			y += 50;
		}

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(17, 24, 38));
		mainPanel.setBounds(260, 0, 1040, 750);
		mainPanel.setLayout(new BorderLayout());
		getContentPane().add(mainPanel);

		// Header
		JPanel header = new JPanel(new BorderLayout());
		header.setBackground(new Color(17, 24, 38));
		header.setBorder(BorderFactory.createEmptyBorder(15, 20, 10, 20));
		JLabel lblTitulo = new JLabel("Busca Avançada por Características");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		header.add(lblTitulo, BorderLayout.WEST);
		mainPanel.add(header, BorderLayout.NORTH);

		JPanel conteudo = new JPanel();
		conteudo.setLayout(new BoxLayout(conteudo, BoxLayout.Y_AXIS));
		conteudo.setBackground(new Color(17, 24, 38));
		conteudo.setBorder(new EmptyBorder(10, 25, 20, 25));

		JScrollPane scroll = new JScrollPane(conteudo);
		scroll.setBorder(null);
		mainPanel.add(scroll, BorderLayout.CENTER);

		// ----------------- SEÇÕES -----------------
		conteudo.add(criarTituloSecao("Casos Ativos"));
		conteudo.add(Box.createVerticalStrut(10));
		painelAtivos = new JPanel();
		painelAtivos.setLayout(new BoxLayout(painelAtivos, BoxLayout.Y_AXIS));
		painelAtivos.setOpaque(false);
		conteudo.add(painelAtivos);

		conteudo.add(Box.createVerticalStrut(50));
		conteudo.add(criarTituloSecao("Casos Pendentes"));
		listaPendentes = new JPanel();
		listaPendentes.setLayout(new BoxLayout(listaPendentes, BoxLayout.Y_AXIS));
		listaPendentes.setOpaque(false);
		conteudo.add(listaPendentes);

		conteudo.add(Box.createVerticalStrut(50));
		conteudo.add(criarTituloSecao("Casos Encerrados"));
		listaEncerrados = new JPanel();
		listaEncerrados.setLayout(new BoxLayout(listaEncerrados, BoxLayout.Y_AXIS));
		listaEncerrados.setOpaque(false);
		conteudo.add(listaEncerrados);

		// ----------------- CARREGAR DADOS -----------------
		try {
			DisappearanceListDao dao = new DisappearanceListDao();
			desaparecidos = dao.listarTodos();
			carregarCards();
		} catch (Exception e) {
			e.printStackTrace();
		}

		setVisible(true);
	}

	private JLabel criarTituloSecao(String txt) {
		JLabel label = new JLabel(txt);
		label.setFont(new Font("Arial", Font.BOLD, 24));
		label.setForeground(new Color(255, 184, 76));
		return label;
	}

	private void carregarCards() {
		painelAtivos.removeAll();
		listaPendentes.removeAll();
		listaEncerrados.removeAll();

		for (DisappearanceListItem d : desaparecidos) {
			StatusRegister status = d.getStatus();
			if (status == null)
				status = StatusRegister.PENDENTE;

			switch (status) {
			case ANDAMENTO:
				painelAtivos.add(criarCardAtivo(d));
				painelAtivos.add(Box.createVerticalStrut(15));
				break;
			case PENDENTE:
				listaPendentes.add(criarCardAtivo(d));
				listaPendentes.add(Box.createVerticalStrut(15));
				break;
			case ENCERRADO:
				listaEncerrados.add(criarCard(d, "CASO ENCERRADO", new Color(100, 100, 100)));
				listaEncerrados.add(Box.createVerticalStrut(15));
				break;
			}
		}

		revalidate();
		repaint();
	}

	// ----------------- CARD ATIVO/PENDENTE -----------------
	private JPanel criarCardAtivo(DisappearanceListItem d) {
		// Header com status
		String titulo = "CASO ATIVO";
		if (d.getStatus() == StatusRegister.PENDENTE)
			titulo = "CASO PENDENTE";

		JPanel card = new JPanel();
		card.setLayout(null);
		card.setPreferredSize(new Dimension(500, 380));
		card.setMaximumSize(new Dimension(850, 380));
		card.setBackground(new Color(22, 25, 40));
		card.setBorder(BorderFactory.createLineBorder(new Color(40, 40, 55), 2));

		// Header
		JPanel header = new JPanel(null);
		header.setBounds(0, 0, 500, 60);
		header.setBackground(new Color(200, 60, 80));
		JLabel lblTitle = new JLabel(titulo);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
		lblTitle.setBounds(20, 10, 450, 40);
		header.add(lblTitle);
		card.add(header);

		// Nome grande
		JLabel lblNome = new JLabel(d.getName());
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Arial", Font.BOLD, 22));
		lblNome.setBounds(20, 70, 450, 30);
		card.add(lblNome);

		// Idade, gênero e físico
		JLabel lblInfo = new JLabel("Idade: " + d.getAge() + " | Gênero: " + d.getGender());
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setBounds(20, 105, 450, 25);
		card.add(lblInfo);

		JLabel lblFisico = new JLabel("Altura: " + d.getHeight() + " m | Peso: " + d.getWeight() + " kg | Cabelo: "
				+ d.getHairColor() + " | Olhos: " + d.getEyeColor());
		lblFisico.setForeground(Color.WHITE);
		lblFisico.setBounds(20, 135, 450, 25);
		card.add(lblFisico);

		// Contato
		JLabel lblContato = new JLabel("Contato: " + d.getContactName() + " | " + d.getContactPhone());
		lblContato.setForeground(Color.WHITE);
		lblContato.setBounds(20, 165, 450, 25);
		card.add(lblContato);

		// Local
		JLabel lblLocal = new JLabel("Local: " + d.getLocation());
		lblLocal.setForeground(Color.WHITE);
		lblLocal.setBounds(20, 195, 450, 25);
		card.add(lblLocal);

		// Contexto
		JLabel lblDesc = new JLabel("<html>" + d.getDisappearanceContext() + "</html>");
		lblDesc.setForeground(Color.LIGHT_GRAY);
		lblDesc.setBounds(20, 225, 460, 60);
		card.add(lblDesc);

		// Painel de botões
		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new GridLayout(2, 1, 0, 10));
		painelBotoes.setOpaque(false);
		painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JButton btnPendente = new JButton("Marcar como Pendente");
		btnPendente.setBackground(new Color(255, 180, 50));
		btnPendente.setForeground(Color.BLACK);
		btnPendente.setFont(new Font("Arial", Font.BOLD, 16));
		btnPendente.setFocusPainted(false);

		JButton btnEncerrado = new JButton("Encerrar Caso");
		btnEncerrado.setBackground(new Color(200, 60, 80));
		btnEncerrado.setForeground(Color.WHITE);
		btnEncerrado.setFont(new Font("Arial", Font.BOLD, 16));
		btnEncerrado.setFocusPainted(false);

		painelBotoes.add(btnPendente);
		painelBotoes.add(btnEncerrado);

		card.add(painelBotoes);
		painelBotoes.setBounds(20, 295, 460, 70);

		btnPendente.addActionListener(e -> {
			d.setStatus(StatusRegister.PENDENTE); // atualiza localmente
			try {
				DisappearanceListDao dao = new DisappearanceListDao();
				dao.atualizarStatusRegister(d.getIdRegister(), StatusRegister.PENDENTE); // atualiza no banco
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(this, "Erro ao atualizar status no banco!");
			}
			carregarCards(); // atualiza a interface
		});

		btnEncerrado.addActionListener(e -> {
			d.setStatus(StatusRegister.ENCERRADO);
			try {
				DisappearanceListDao dao = new DisappearanceListDao();
				dao.atualizarStatusRegister(d.getIdRegister(), StatusRegister.ENCERRADO);
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(this, "Erro ao atualizar status no banco!");
			}
			carregarCards();
		});

		return card;
	}

	// ----------------- CARD SIMPLES -----------------
	private JPanel criarCard(DisappearanceListItem d, String titulo, Color corHeader) {
		JPanel card = new JPanel();
		card.setLayout(null);
		card.setPreferredSize(new Dimension(500, 380)); // de 300 para 380
		card.setMaximumSize(new Dimension(850, 300));
		card.setBackground(new Color(22, 25, 40));
		card.setBorder(BorderFactory.createLineBorder(new Color(40, 40, 55), 2));

		// Header
		JPanel header = new JPanel(null);
		header.setBounds(0, 0, 500, 60);
		header.setBackground(corHeader);

		JLabel lblTitle = new JLabel(titulo);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
		lblTitle.setBounds(20, 10, 450, 40);
		header.add(lblTitle);

		card.add(header);

		// Nome grande
		JLabel lblNome = new JLabel(d.getName());
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Arial", Font.BOLD, 22));
		lblNome.setBounds(20, 80, 450, 30);
		card.add(lblNome);

		// Idade, gênero e físico
		JLabel lblInfo = new JLabel("Idade: " + d.getAge() + " | Gênero: " + d.getGender());
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setBounds(20, 115, 450, 25);
		card.add(lblInfo);

		JLabel lblFisico = new JLabel("Altura: " + d.getHeight() + " m | Peso: " + d.getWeight() + " kg | Cabelo: "
				+ d.getHairColor() + " | Olhos: " + d.getEyeColor());
		lblFisico.setForeground(Color.WHITE);
		lblFisico.setBounds(20, 145, 450, 25);
		card.add(lblFisico);

		// Contato
		JLabel lblContato = new JLabel("Contato: " + d.getContactName() + " | " + d.getContactPhone());
		lblContato.setForeground(Color.WHITE);
		lblContato.setBounds(20, 175, 450, 25);
		card.add(lblContato);

		// Local
		JLabel lblLocal = new JLabel("Local: " + d.getLocation());
		lblLocal.setForeground(Color.WHITE);
		lblLocal.setBounds(20, 205, 450, 25);
		card.add(lblLocal);

		// Descrição
		JLabel lblDesc = new JLabel("<html>" + d.getDisappearanceContext() + "</html>");
		lblDesc.setForeground(Color.LIGHT_GRAY);
		lblDesc.setBounds(20, 235, 450, 60);
		card.add(lblDesc);

		return card;
	}
}
