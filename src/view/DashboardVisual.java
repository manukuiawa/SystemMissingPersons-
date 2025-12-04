package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import dao.DashboardDao;

import view.SearchMissingPersons;

public class DashboardVisual extends JFrame {

    private DashboardDao dao;

    public DashboardVisual() {
        dao = new DashboardDao();

        setTitle("Sistema de Controle de Pessoas Desaparecidas");
        setSize(1300, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().setBackground(Color.decode("#011826"));

        //SideBar
        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(260, 750));
        sidebar.setBackground(new Color(25, 35, 45));
        sidebar.setLayout(null);
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


            switch (item) {

            case "Novo Caso" -> btn.addActionListener(e -> SwingUtilities.invokeLater(() -> {
                RegisterPersonMissing tela = new RegisterPersonMissing();
                tela.abrir();
            }));

            case "Dashboard" -> btn.addActionListener(e -> SwingUtilities.invokeLater(() -> {
                new DashboardVisual();
                this.dispose();
            }));
            
            case "Pessoas Desaparecidas" -> btn.addActionListener(e ->
            SwingUtilities.invokeLater(() -> {
                new ScreenDisappearance().setVisible(true);
                this.dispose(); // se quiser fechar a tela atual igual ao Dashboard
            }));
            
            case "Busca Avançada" -> btn.addActionListener(e ->
            SwingUtilities.invokeLater(() -> {
                JFrame tela = new JFrame("Busca Avançada");
                tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                tela.setSize(1100, 700);
                tela.setLocationRelativeTo(null);

                tela.setContentPane(new SearchMissingPersons());

                tela.setVisible(true);

                this.dispose();
            })
        );

        }

            sidebar.add(btn);
            y += 50;
        }


        //Painel Principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(33, 43, 54));
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        //Cabeçalho
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(40, 50, 60));
        header.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        JLabel title = new JLabel("Dashboard - Visão Geral");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        header.add(title, BorderLayout.WEST);
        mainPanel.add(header, BorderLayout.NORTH);

        //Banco
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        centerPanel.setBackground(new Color(33, 43, 54));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // Buscando os totais do banco
        int totalCasos = dao.contarTotalCasos();
        int casosAtivos = dao.contarCasosPorStatus("ANDAMENTO");
        int casosPendentes = dao.contarCasosPorStatus("PENDENTE");
        int casosEncerrados = dao.contarCasosPorStatus("ENCERRADO");

        centerPanel.add(createInfoCard("Total de Casos", String.valueOf(totalCasos), "Todos os registros", new Color(50, 90, 200)));
        centerPanel.add(createInfoCard("Casos Ativos", String.valueOf(casosAtivos), "Em investigação", new Color(200, 60, 60)));
        centerPanel.add(createInfoCard("Casos Pendentes", String.valueOf(casosPendentes), "Aguardando andamento", new Color(230, 180, 60)));
        centerPanel.add(createInfoCard("Casos Encerrados", String.valueOf(casosEncerrados), "Concluídos", new Color(60, 170, 90)));

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
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
