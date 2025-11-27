package view; 

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LayoutNovo {

    private JFrame frame;

    public LayoutNovo() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Casos");
        frame.setSize(1300, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel root = new JPanel(null);
        root.setBackground(new Color(10, 12, 25)); // fundo escuro igual imagem
        frame.setContentPane(root);

        //----------------------------------------------
        // CARD "CASO ATIVO"
        //----------------------------------------------
        JPanel activeCard = new JPanel(null);
        activeCard.setBounds(20, 20, 420, 450);
        activeCard.setBackground(new Color(22, 25, 40));
        activeCard.setBorder(BorderFactory.createLineBorder(new Color(40, 40, 55), 2));
        root.add(activeCard);

        // Header vermelho
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
        // Informações
        //----------------------------------------------
        JLabel nome = new JLabel("teste");
        nome.setForeground(Color.WHITE);
        nome.setFont(new Font("Arial", Font.BOLD, 22));
        nome.setBounds(20, 90, 300, 30);
        activeCard.add(nome);

        JLabel idade = new JLabel("<html>Idade<br><b>10 anos</b></html>");
        idade.setForeground(Color.WHITE);
        idade.setBounds(20, 130, 150, 50);
        activeCard.add(idade);

        JLabel data = new JLabel("<html>Data<br><b>30/06/4177</b></html>");
        data.setForeground(Color.WHITE);
        data.setBounds(200, 130, 150, 50);
        activeCard.add(data);

        JLabel localTitle = new JLabel("Local do Desaparecimento");
        localTitle.setForeground(Color.LIGHT_GRAY);
        localTitle.setBounds(20, 190, 250, 20);
        activeCard.add(localTitle);

        JLabel local = new JLabel("teste");
        local.setForeground(Color.WHITE);
        local.setBounds(20, 210, 250, 20);
        activeCard.add(local);

        JLabel descTitle = new JLabel("Descrição Física");
        descTitle.setForeground(Color.LIGHT_GRAY);
        descTitle.setBounds(20, 235, 200, 20);
        activeCard.add(descTitle);

        JLabel desc = new JLabel("teste teste teste");
        desc.setForeground(Color.WHITE);
        desc.setBounds(20, 255, 350, 20);
        activeCard.add(desc);

        //----------------------------------------------
        // CARD de informações (telefone)
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

        JLabel phone = new JLabel("4799969999");
        phone.setForeground(Color.WHITE);
        phone.setBounds(50, 20, 250, 30);
        infoCard.add(phone);

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
        // Título "Casos Pendentes"
        //----------------------------------------------
        JLabel pendTitle = new JLabel("Casos Pendentes");
        pendTitle.setForeground(new Color(255, 170, 50));
        pendTitle.setFont(new Font("Arial", Font.BOLD, 24));
        pendTitle.setBounds(20, 490, 300, 40);
        root.add(pendTitle);

        //----------------------------------------------
        // LISTA (painel cinza)
        //----------------------------------------------
        JPanel listPanel = new JPanel(null);
        listPanel.setBounds(20, 530, 1250, 170);
        listPanel.setBackground(new Color(22, 25, 40));
        listPanel.setBorder(BorderFactory.createLineBorder(new Color(40, 40, 55), 2));
        root.add(listPanel);

        JLabel dot = new JLabel("●");
        dot.setForeground(Color.YELLOW);
        dot.setBounds(20, 30, 40, 30);
        listPanel.add(dot);

        JLabel pendingName = new JLabel("teste");
        pendingName.setForeground(Color.WHITE);
        pendingName.setFont(new Font("Arial", Font.BOLD, 16));
        pendingName.setBounds(60, 30, 150, 30);
        listPanel.add(pendingName);

        JLabel idade2 = new JLabel("<html>Idade<br><b>34 anos</b></html>");
        idade2.setForeground(Color.WHITE);
        idade2.setBounds(250, 20, 150, 50);
        listPanel.add(idade2);

        JLabel data2 = new JLabel("<html>Data do Desaparecimento<br><b>17/07/4558</b></html>");
        data2.setForeground(Color.WHITE);
        data2.setBounds(400, 20, 200, 50);
        listPanel.add(data2);

        JLabel local2 = new JLabel("<html>Local<br><b>tste</b></html>");
        local2.setForeground(Color.WHITE);
        local2.setBounds(650, 20, 150, 50);
        listPanel.add(local2);

        JLabel desc2 = new JLabel("<html>Descrição Física<br><b>teste</b></html>");
        desc2.setForeground(Color.WHITE);
        desc2.setBounds(800, 20, 180, 50);
        listPanel.add(desc2);

        JLabel contato2 = new JLabel("<html>Contato<br><b>2555565555</b></html>");
        contato2.setForeground(Color.WHITE);
        contato2.setBounds(1020, 20, 200, 50);
        listPanel.add(contato2);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Disappearence::new);
    }
}
