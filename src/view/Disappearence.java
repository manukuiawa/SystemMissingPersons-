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

        // Dados fake (só visual)
        String[][] people = {
                {"Ana Silva Santos", "Feminino", "Shopping Center Norte", "19/01/2024", "165cm", "55kg"},
                {"João Pedro Costa", "Masculino", "Parque da Cidade", "24/01/2024", "120cm", "25kg"},
                {"Maria Oliveira", "Feminino", "Hospital Central", "27/01/2024", "155cm", "60kg"},
                {"Carlos Lima", "Masculino", "Rodoviária Central", "10/02/2024", "170cm", "70kg"}
        };

        Color ativoColor = new Color(255, 77, 77);
        Color pendenteColor = new Color(255, 165, 0);
        Color encerradoColor = new Color(40, 167, 69);

        for (String[] p : people) {

            JPanel card = new JPanel();
            card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
            card.setBackground(new Color(25, 35, 45));
            card.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            card.setPreferredSize(new Dimension(300, 420));

            // STATUS TOPO (sempre inicia como ATIVO)
            JLabel status = new JLabel("ATIVO", SwingConstants.CENTER);
            status.setForeground(Color.WHITE);
            status.setOpaque(true);
            status.setFont(new Font("Arial", Font.BOLD, 13));
            status.setBackground(ativoColor);
            status.setBorder(new EmptyBorder(8, 10, 8, 10));
            status.setAlignmentX(Component.CENTER_ALIGNMENT);
            status.setMaximumSize(new Dimension(Integer.MAX_VALUE, 85));
            status.setPreferredSize(new Dimension(0, 85));
            status.setMinimumSize(new Dimension(0, 85));

            card.add(status);
            card.add(Box.createVerticalStrut(15));

            
            status.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            // NOME
            JLabel nome = new JLabel(p[0]);
            nome.setForeground(Color.WHITE);
            nome.setFont(new Font("Arial", Font.BOLD, 16));
            card.add(nome);

            // Dados
            card.add(Box.createVerticalStrut(8));
            card.add(makeLabel("Gênero: " + p[1]));
            card.add(makeLabel("Local: " + p[2]));
            card.add(makeLabel("Data: " + p[3]));
            card.add(makeLabel("Altura: " + p[4] + "   Peso: " + p[5]));

            card.add(Box.createVerticalStrut(15));

            // PERGUNTA
            JLabel pergunta = new JLabel("Este caso está:");
            pergunta.setForeground(Color.WHITE);
            pergunta.setFont(new Font("Arial", Font.BOLD, 13));
            card.add(pergunta);

            // RADIO BUTTONS
            JRadioButton pendente = new JRadioButton("Pendente");
            JRadioButton encerrado = new JRadioButton("Encerrado");

            pendente.setBackground(new Color(25, 35, 45));
            pendente.setForeground(Color.WHITE);

            encerrado.setBackground(new Color(25, 35, 45));
            encerrado.setForeground(Color.WHITE);

            ButtonGroup group = new ButtonGroup();
            group.add(pendente);
            group.add(encerrado);

            JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            radioPanel.setBackground(new Color(25, 35, 45));
            radioPanel.add(pendente);
            radioPanel.add(encerrado);

            card.add(radioPanel);

            // Atualiza status ao clicar
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

    private JLabel makeLabel(String text) {
        JLabel lbl = new JLabel(text);
        lbl.setForeground(new Color(200, 200, 200));
        lbl.setFont(new Font("Arial", Font.PLAIN, 13));
        return lbl;
    }
}
