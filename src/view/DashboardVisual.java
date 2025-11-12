package view;

import javax.swing.*;
import java.awt.*;

public class DashboardVisual extends JFrame {

    public DashboardVisual() {
        setTitle("SCPD - Sistema de Controle de Pessoas Desaparecidas");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ===== Sidebar =====
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(20, 28, 38));
        sidebar.setPreferredSize(new Dimension(250, 700));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

        JLabel logo = new JLabel("🔎 SCPD", SwingConstants.CENTER);
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        logo.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        sidebar.add(logo);

        JLabel subtext = new JLabel("Sistema de Controle de Pessoas Desaparecidas", SwingConstants.CENTER);
        subtext.setForeground(new Color(150, 150, 150));
        subtext.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        subtext.setBorder(BorderFactory.createEmptyBorder(0, 10, 30, 10));
        sidebar.add(subtext);

        String[] menuItems = {"Dashboard", "Pessoas Desaparecidas", "Busca Avançada", "Mapa de Ocorrências", "Relatórios"};
        for (String item : menuItems) {
            JButton btn = new JButton(item);
            btn.setFocusPainted(false);
            btn.setForeground(Color.WHITE);
            btn.setBackground(new Color(30, 40, 50));
            btn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setMaximumSize(new Dimension(220, 40));
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    btn.setBackground(new Color(45, 60, 80));
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    btn.setBackground(new Color(30, 40, 50));
                }
            });

            sidebar.add(Box.createVerticalStrut(10));
            sidebar.add(btn);
        }

        add(sidebar, BorderLayout.WEST);

        // ===== Painel Principal =====
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(33, 43, 54));
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        // ===== Header =====
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(40, 50, 60));
        header.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel title = new JLabel("Dashboard - Visão Geral");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        header.add(title, BorderLayout.WEST);

        JPanel headerButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        headerButtons.setBackground(new Color(40, 50, 60));

        JButton btnNovo = createTopButton("Novo Caso", new Color(200, 50, 50));
        JButton btnFiltro = createTopButton("Filtros", new Color(60, 100, 200));
        JButton btnExportar = createTopButton("Exportar", new Color(100, 100, 100));

        headerButtons.add(btnNovo);
        headerButtons.add(btnFiltro);
        headerButtons.add(btnExportar);

        header.add(headerButtons, BorderLayout.EAST);
        mainPanel.add(header, BorderLayout.NORTH);

        // ===== Painel Central =====
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        centerPanel.setBackground(new Color(33, 43, 54));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // Cards simulando os da imagem
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
