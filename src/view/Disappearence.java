package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.DisappearanceListDao;
import model.DisappearanceListItem;

public class Disappearence {

    private JFrame frame;
    private JPanel sidebar;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Disappearence window = new Disappearence();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Disappearence() {
        initialize();
    }

    private void initialize() {

        // Frame principal
        frame = new JFrame();
        frame.setTitle("SCPD - Sistema de Controle de Pessoas Desaparecidas");
        frame.setBounds(100, 100, 1300, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.decode("#011826"));

        // Sidebar
        sidebar = new JPanel();
        sidebar.setLayout(null);
        sidebar.setBackground(new Color(25, 35, 45));
        sidebar.setPreferredSize(new Dimension(260, 750));
        frame.add(sidebar, BorderLayout.WEST);

        // Título
        JLabel tituloSidebar = new JLabel("SCPD", SwingConstants.CENTER);
        tituloSidebar.setFont(new Font("Arial", Font.BOLD, 22));
        tituloSidebar.setForeground(Color.WHITE);
        tituloSidebar.setBounds(0, 20, 260, 30);
        sidebar.add(tituloSidebar);

        // Subtítulo
        JLabel subtitulo = new JLabel("Controle de Pessoas", SwingConstants.CENTER);
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

     // Top bar
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(25, 35, 45));
        topPanel.setPreferredSize(new Dimension(0, 60));
        topPanel.setBorder(new EmptyBorder(0, 20, 0, 20));

        JLabel title = new JLabel("Pessoas Desaparecidas - Casos");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        topPanel.add(title, BorderLayout.WEST);
        frame.add(topPanel, BorderLayout.NORTH);

        // MAIN PANEL
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(17, 24, 38));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        frame.add(mainPanel, BorderLayout.CENTER);

        // Painel dos cards
        JPanel cardsPanel = new JPanel(new GridLayout(0, 3, 20, 20));
        cardsPanel.setBackground(new Color(17, 24, 38));

        // BUSCANDO DO BANCO DE DADOS
        DisappearanceListDao listDao = new DisappearanceListDao();
        List<DisappearanceListItem> lista = listDao.listarTodos();

        Color ativoColor = new Color(255, 77, 77);
        Color pendenteColor = new Color(255, 165, 0);
        Color encerradoColor = new Color(40, 167, 69);

        // GERANDO OS CARDS COM BASE NOS DADOS DO BD 
        for (DisappearanceListItem p : lista) {

            JPanel card = new JPanel();
            card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
            card.setBackground(new Color(25, 35, 45));
            card.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            card.setPreferredSize(new Dimension(300, 420));

            // STATUS TOPO
            JLabel status = new JLabel(p.getStatus().toUpperCase(), SwingConstants.CENTER);
            status.setForeground(Color.WHITE);
            status.setOpaque(true);
            status.setFont(new Font("Arial", Font.BOLD, 13));
            status.setBorder(new EmptyBorder(8, 10, 8, 10));
            status.setAlignmentX(Component.CENTER_ALIGNMENT);
            status.setMaximumSize(new Dimension(Integer.MAX_VALUE, 85));
            status.setPreferredSize(new Dimension(0, 85));
            status.setMinimumSize(new Dimension(0, 85));

            
            switch (p.getStatus().toLowerCase()) {
                case "pendente":
                    status.setBackground(pendenteColor);
                    break;
                case "encerrado":
                    status.setBackground(encerradoColor);
                    break;
                default:
                    status.setBackground(ativoColor);
                    break;
            }

            card.add(status);
            card.add(Box.createVerticalStrut(15));

            
         // NOME
            JLabel nome = new JLabel(p.getName());
            nome.setForeground(Color.WHITE);
            nome.setFont(new Font("Arial", Font.BOLD, 24));
            nome.setAlignmentX(Component.LEFT_ALIGNMENT);
            card.add(nome);

            card.add(Box.createVerticalStrut(8));

            // GÊNERO
            JLabel genero = new JLabel("Gênero: " + p.getGender());
            genero.setForeground(Color.WHITE);
            genero.setAlignmentX(Component.LEFT_ALIGNMENT);
            card.add(genero);

            // LOCAL
            JLabel local = new JLabel("Local: " + p.getLocation());
            local.setForeground(Color.WHITE);
            local.setAlignmentX(Component.LEFT_ALIGNMENT);
            card.add(local);

            // DATA EM FORMATO BR
            String dataFormatada = "—";
            if (p.getDate() != null) {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                dataFormatada = sdf.format(p.getDate());
            }

            JLabel dataLbl = new JLabel("Data: " + dataFormatada);
            dataLbl.setForeground(Color.WHITE);
            dataLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
            card.add(dataLbl);

            card.add(Box.createVerticalStrut(15));

            // TEXTO "ESSE CASO ESTÁ:"
            JLabel pergunta = new JLabel("Este caso está:");
            pergunta.setForeground(Color.WHITE);
            pergunta.setFont(new Font("Arial", Font.BOLD, 13));
            pergunta.setAlignmentX(Component.LEFT_ALIGNMENT);
            card.add(pergunta);

            // RADIOS
            JRadioButton pendente = new JRadioButton("Pendente");
            JRadioButton encerrado = new JRadioButton("Encerrado");

            pendente.setBackground(new Color(25, 35, 45));
            pendente.setForeground(Color.WHITE);
            pendente.setAlignmentX(Component.LEFT_ALIGNMENT);

            encerrado.setBackground(new Color(25, 35, 45));
            encerrado.setForeground(Color.WHITE);
            encerrado.setAlignmentX(Component.LEFT_ALIGNMENT);

            // GRUPO
            ButtonGroup group = new ButtonGroup();
            group.add(pendente);
            group.add(encerrado);

            // PAINEL ALINHADO
            JPanel radioPanel = new JPanel();
            radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
            radioPanel.setBackground(new Color(25, 35, 45));
            radioPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

            radioPanel.add(pendente);
            radioPanel.add(encerrado);

            card.add(radioPanel);

            // AÇÕES
            pendente.addActionListener(e -> {
                status.setText("PENDENTE");
                status.setBackground(pendenteColor);
            });

            encerrado.addActionListener(e -> {
                status.setText("ENCERRADO");
                status.setBackground(encerradoColor);
            });


            pendente.addActionListener(e -> {
                status.setText("PENDENTE");
                status.setBackground(pendenteColor);
            });

            encerrado.addActionListener(e -> {
                status.setText("ENCERRADO");
                status.setBackground(encerradoColor);
            });

            cardsPanel.add(card);
        }

        mainPanel.add(cardsPanel, BorderLayout.NORTH);
    }
}
