package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DashboardVisual extends JFrame {

    public DashboardVisual() {
        setTitle("SCPD - Sistema de Controle de Pessoas Desaparecidas");
        setSize(1300, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Layout principal
        getContentPane().setLayout(new BorderLayout());
        getContentPane().setBackground(Color.decode("#011826"));

        // ----------------- SIDEBAR -----------------
        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(260, 750));
        sidebar.setBackground(new Color(25, 35, 45));
        sidebar.setLayout(null); // Apenas para posicionamento interno dos botões e labels
        getContentPane().add(sidebar, BorderLayout.WEST);

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

            switch (item) {
                case "Novo Caso":
                    btn.addActionListener(e -> SwingUtilities.invokeLater(() -> {
                        RegisterPersonMissing tela = new RegisterPersonMissing();
                        tela.abrir();
                    }));
                    break;

                case "Dashboard":
                    btn.addActionListener(e -> SwingUtilities.invokeLater(() -> {
                        DashboardVisual dashboard = new DashboardVisual();
                        dashboard.setVisible(true);
                        this.dispose();
                    }));
                    break;

                case "Busca Avançada":
                    btn.addActionListener(e -> SwingUtilities.invokeLater(() -> {
                        SearchMissingPersons busca = new SearchMissingPersons();
                        busca.abrir();
                    }));
                    break;

                default:
                    System.out.println("Opção não configurada: " + item);
            }

            sidebar.add(btn);
            y += 50;
        }

        // ===== PAINEL PRINCIPAL =====
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(33, 43, 54));
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        // ===== HEADER =====
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(40, 50, 60));
        header.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel title = new JLabel("Dashboard - Visão Geral");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        header.add(title, BorderLayout.WEST);

        JPanel headerButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        headerButtons.setBackground(new Color(40, 50, 60)); 

        header.add(headerButtons, BorderLayout.EAST);
        mainPanel.add(header, BorderLayout.NORTH);

        // ===== PAINEL CENTRAL (CARDS) =====
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        centerPanel.setBackground(new Color(33, 43, 54));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        centerPanel.add(createInfoCard("Total de Casos", "156", "18% este mês", new Color(50, 90, 200)));
        centerPanel.add(createInfoCard("Casos Ativos", "47", "3 novos hoje", new Color(200, 60, 60)));
        centerPanel.add(createInfoCard("Encontrados", "97", "62% taxa de sucesso", new Color(60, 170, 90)));
        centerPanel.add(createInfoCard("Em Investigação", "23", "49% do total ativo", new Color(230, 180, 60)));

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JButton createTopButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 13));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }

    private JPanel createInfoCard(String title, String number, String desc, Color color) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(new Color(40, 50, 60));
        card.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblTitle = new JLabel(title);
        lblTitle.setForeground(new Color(200, 200, 200));
        lblTitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JLabel lblNumber = new JLabel(number);
        lblNumber.setForeground(Color.WHITE);
        lblNumber.setFont(new Font("Segoe UI", Font.BOLD, 28));

        JLabel lblDesc = new JLabel(desc);
        lblDesc.setForeground(color);
        lblDesc.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setBackground(new Color(40, 50, 60));
        info.add(lblTitle);
        info.add(Box.createVerticalStrut(10));
        info.add(lblNumber);
        info.add(Box.createVerticalStrut(5));
        info.add(lblDesc);

        card.add(info, BorderLayout.WEST);
        return card;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DashboardVisual::new);
    }
}
