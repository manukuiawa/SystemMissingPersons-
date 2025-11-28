package view;

import dao.DisappearanceListDao;
import model.DisappearanceListItem;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class LayoutNovo {

    private JFrame frame;

    // Componentes do caso ativo
    private JLabel lblNome, lblIdade, lblData, lblLocal, lblDesc, lblPhone;
    private JPanel listPanel;

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public LayoutNovo() {
        initialize();
        carregarDados();
    }

    private void initialize() {
        frame = new JFrame("Casos");
        frame.setSize(1300, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel root = new JPanel(null);
        root.setBackground(new Color(10, 12, 25));
        frame.setContentPane(root);

        //----------------------------------------------
        // CARD "CASO ATIVO"
        //----------------------------------------------
        JPanel activeCard = new JPanel(null);
        activeCard.setBounds(20, 20, 420, 450);
        activeCard.setBackground(new Color(22, 25, 40));
        activeCard.setBorder(BorderFactory.createLineBorder(new Color(40, 40, 55), 2));
        root.add(activeCard);

        JPanel header = new JPanel(null);
        header.setBounds(0, 0, 420, 80);
        header.setBackground(new Color(200, 60, 80));
        activeCard.add(header);

        JLabel lblTitle = new JLabel("CASO ATIVO");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setBounds(20, 20, 300, 40);
        header.add(lblTitle);

        //----------------------------------------------
        // Informações do caso ativo
        //----------------------------------------------
        lblNome = new JLabel("—");
        lblNome.setForeground(Color.WHITE);
        lblNome.setFont(new Font("Arial", Font.BOLD, 22));
        lblNome.setBounds(20, 90, 350, 30);
        activeCard.add(lblNome);

        lblIdade = new JLabel("<html>Idade<br><b>—</b></html>");
        lblIdade.setForeground(Color.WHITE);
        lblIdade.setBounds(20, 130, 150, 50);
        activeCard.add(lblIdade);

        lblData = new JLabel("<html>Data<br><b>—</b></html>");
        lblData.setForeground(Color.WHITE);
        lblData.setBounds(200, 130, 180, 50);
        activeCard.add(lblData);

        JLabel localTitle = new JLabel("Local do Desaparecimento");
        localTitle.setForeground(Color.LIGHT_GRAY);
        localTitle.setBounds(20, 190, 250, 20);
        activeCard.add(localTitle);

        lblLocal = new JLabel("—");
        lblLocal.setForeground(Color.WHITE);
        lblLocal.setBounds(20, 210, 350, 20);
        activeCard.add(lblLocal);

        JLabel descTitle = new JLabel("Descrição Física");
        descTitle.setForeground(Color.LIGHT_GRAY);
        descTitle.setBounds(20, 235, 200, 20);
        activeCard.add(descTitle);

        lblDesc = new JLabel("—");
        lblDesc.setForeground(Color.WHITE);
        lblDesc.setBounds(20, 255, 350, 20);
        activeCard.add(lblDesc);

        //----------------------------------------------
        // Card informativo
        //----------------------------------------------
        JPanel infoCard = new JPanel(null);
        infoCard.setBounds(20, 285, 380, 70);
        infoCard.setBackground(new Color(15, 18, 30));
        infoCard.setBorder(BorderFactory.createLineBorder(new Color(30, 30, 45)));
        activeCard.add(infoCard);

        JLabel phoneIcon = new JLabel("📞");
        phoneIcon.setBounds(10, 20, 30, 30);
        phoneIcon.setForeground(Color.PINK);
        infoCard.add(phoneIcon);

        lblPhone = new JLabel("—");
        lblPhone.setForeground(Color.WHITE);
        lblPhone.setBounds(50, 20, 300, 30);
        infoCard.add(lblPhone);

        //----------------------------------------------
        // Botões
        //----------------------------------------------
        JButton btnPendente = new JButton("PENDENTE");
        btnPendente.setBounds(20, 365, 160, 40);
        btnPendente.setBackground(new Color(255, 170, 40));
        btnPendente.setForeground(Color.BLACK);
        btnPendente.setFont(new Font("Arial", Font.BOLD, 14));
        btnPendente.setFocusPainted(false);
        activeCard.add(btnPendente);

        JButton btnEncerrar = new JButton("ENCERRADO");
        btnEncerrar.setBounds(200, 365, 160, 40);
        btnEncerrar.setBackground(new Color(50, 200, 150));
        btnEncerrar.setForeground(Color.BLACK);
        btnEncerrar.setFont(new Font("Arial", Font.BOLD, 14));
        btnEncerrar.setFocusPainted(false);
        activeCard.add(btnEncerrar);

        //----------------------------------------------
        // Lista de pendentes
        //----------------------------------------------
        JLabel pendTitle = new JLabel("Casos Pendentes");
        pendTitle.setForeground(new Color(255, 170, 50));
        pendTitle.setFont(new Font("Arial", Font.BOLD, 24));
        pendTitle.setBounds(20, 490, 300, 40);
        root.add(pendTitle);

        JPanel listContainer = new JPanel(new BorderLayout());
        listContainer.setBounds(20, 530, 1250, 170);
        listContainer.setBackground(new Color(22, 25, 40));
        listContainer.setBorder(BorderFactory.createLineBorder(new Color(40, 40, 55), 2));
        root.add(listContainer);

        JScrollPane jsp = new JScrollPane();
        jsp.setBorder(null);
        listContainer.add(jsp, BorderLayout.CENTER);

        listPanel = new JPanel(null);
        listPanel.setBackground(new Color(22, 25, 40));
        jsp.setViewportView(listPanel);

        frame.setVisible(true);
    }

    //----------------------------------------------------------
    // CARREGA DO DAO
    //----------------------------------------------------------
    private void carregarDados() {
        SwingUtilities.invokeLater(() -> {
            try {
                DisappearanceListDao dao = new DisappearanceListDao();
                List<DisappearanceListItem> lista = dao.listarTodos();

                if (lista == null || lista.isEmpty()) {
                    lblNome.setText("Nenhum caso encontrado");
                    return;
                }

                // Mostra o primeiro como caso ativo
                preencherAtivo(lista.get(0));

                // Lista os outros abaixo
                preencherLista(lista);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    //----------------------------------------------------------
    // PREENCHE O CARD PRINCIPAL
    //----------------------------------------------------------
    private void preencherAtivo(DisappearanceListItem item) {

        lblNome.setText(item.getName());

        lblIdade.setText("<html>Idade<br><b>" + item.getAge() + "</b></html>");

        lblData.setText("<html>Data<br><b>" +
                (item.getDate() != null ? sdf.format(item.getDate()) : "—") +
                "</b></html>");

        lblLocal.setText(item.getLocation());

        lblDesc.setText(
                item.getHeight() + "m • " +
                item.getWeight() + "kg • " +
                item.getGender()
        );

        lblPhone.setText("Status: " + item.getStatus());
    }

    //----------------------------------------------------------
    // LISTA OS OUTROS CASOS
    //----------------------------------------------------------
    private void preencherLista(List<DisappearanceListItem> lista) {

        listPanel.removeAll();

        int y = 10;

        for (DisappearanceListItem item : lista) {

            JPanel card = new JPanel(null);
            card.setBackground(new Color(30, 33, 50));
            card.setBounds(10, y, 1200, 60);
            card.setBorder(BorderFactory.createLineBorder(new Color(50, 50, 70)));
            listPanel.add(card);

            JLabel lbl = new JLabel(
                    item.getName() + " — " +
                    item.getAge() + " anos — " +
                    item.getLocation() + " — " +
                    "Status: " + item.getStatus()
            );
            lbl.setForeground(Color.WHITE);
            lbl.setBounds(20, 20, 900, 20);
            card.add(lbl);

            y += 70;
        }

        listPanel.setPreferredSize(new Dimension(1200, y + 10));
        listPanel.revalidate();
        listPanel.repaint();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LayoutNovo());
    }

}
