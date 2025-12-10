package view;

import dao.SearchMissingDao;
import model.DisappearanceListItem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SearchMissingPersons extends JPanel {

    private final JTextField campoNome;
    private final JTextField campoIdade;
    private final JTextField campoAltura;
    private final JTextField campoCabelo;
    private final JTextField campoOlhos;
    private final JTextField campoRoupas;
    private final JTextField campoLocal;

    private final JTable tabela;
    private final DefaultTableModel modelo;

    private final SearchMissingDao dao;

    public SearchMissingPersons() {

        this.dao = new SearchMissingDao();

        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(12, 12, 12, 12));

        Color darkBg = new Color(33, 43, 54);
        Color darkPanel = new Color(45,55,67);
        Color textColor = new Color(230, 230, 230);

        setBackground(darkBg);
        
        JPanel topo = new JPanel(new GridLayout(4, 4, 10, 10));
        topo.setBackground(darkPanel);
        topo.setBorder(new LineBorder(new Color(70, 70, 70), 1, true));

        campoNome = criarCampo(darkPanel, textColor);
        campoIdade = criarCampo(darkPanel, textColor);
        campoAltura = criarCampo(darkPanel, textColor);
        campoCabelo = criarCampo(darkPanel, textColor);
        campoOlhos = criarCampo(darkPanel, textColor);
        campoRoupas = criarCampo(darkPanel, textColor);
        campoLocal = criarCampo(darkPanel, textColor);

        adicionarCampo(topo, "Nome:", campoNome, textColor);
        adicionarCampo(topo, "Idade:", campoIdade, textColor);
        adicionarCampo(topo, "Altura:", campoAltura, textColor);
        adicionarCampo(topo, "Cabelo:", campoCabelo, textColor);
        adicionarCampo(topo, "Olhos:", campoOlhos, textColor);
        adicionarCampo(topo, "Roupas:", campoRoupas, textColor);
        adicionarCampo(topo, "Local:", campoLocal, textColor);

        add(topo, BorderLayout.NORTH);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        painelBotoes.setBackground(darkBg);

        JButton botaoPesquisar = criarBotao("Pesquisar", new Color(37, 150, 190));
        JButton botaoLimpar = criarBotao("Limpar", new Color(200, 50, 70));

        painelBotoes.add(botaoPesquisar);
        painelBotoes.add(botaoLimpar);

        add(painelBotoes, BorderLayout.SOUTH);
        
        modelo = new DefaultTableModel(new String[]{
                "Nome", "Idade", "Gênero",
                "Altura", "Peso", "Cabelo", "Olhos",
                "Roupas", "Local", "Contexto",
                "Parente/Contato", "Telefone", "Status"
        }, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };

        tabela = new JTable(modelo);
        tabela.setRowHeight(26);
        tabela.setShowGrid(false);
        tabela.setIntercellSpacing(new Dimension(0, 0));
        tabela.setAutoCreateRowSorter(true);

        tabela.setBackground(darkPanel);
        tabela.setForeground(textColor);
        tabela.setSelectionBackground(new Color(60, 60, 60));
        tabela.setSelectionForeground(Color.WHITE);

        tabela.getTableHeader().setBackground(new Color(55, 55, 55));
        tabela.getTableHeader().setForeground(Color.WHITE);
        tabela.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));

        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBorder(new LineBorder(new Color(70, 70, 70), 1, true));
        scroll.getViewport().setBackground(darkPanel);

        add(scroll, BorderLayout.CENTER);

        // Ações dos botões
        botaoPesquisar.addActionListener(e -> pesquisar());
        botaoLimpar.addActionListener(e -> limparCampos());
    }

    
    private JTextField criarCampo(Color bg, Color fg) {
        JTextField campo = new JTextField();
        campo.setBorder(new LineBorder(new Color(120, 120, 120), 1, true));
        campo.setBackground(bg);
        campo.setForeground(fg);
        campo.setCaretColor(Color.WHITE);
        return campo;
    }

    
    private void adicionarCampo(JPanel painel, String texto, JTextField campo, Color textColor) {
        JLabel label = new JLabel(texto);
        label.setForeground(textColor);
        label.setFont(new Font("SansSerif", Font.PLAIN, 13));
        painel.add(label);
        painel.add(campo);
    }

  
    private JButton criarBotao(String texto, Color cor) {
        JButton botao = new JButton(texto);
        botao.setFocusPainted(false);
        botao.setBackground(cor);
        botao.setForeground(Color.WHITE);
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botao.setBorder(new EmptyBorder(7, 14, 7, 14));
        return botao;
    }

  
    private void pesquisar() {
        String nome = campoNome.getText().trim();
        String idade = campoIdade.getText().trim();
        String altura = campoAltura.getText().trim();
        String cabelo = campoCabelo.getText().trim();
        String olhos = campoOlhos.getText().trim();
        String roupas = campoRoupas.getText().trim();
        String local = campoLocal.getText().trim();

        List<DisappearanceListItem> lista = dao.pesquisar(
                nome, idade, altura, cabelo, olhos, roupas, local
        );

        modelo.setRowCount(0);

        if (lista == null || lista.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Nenhum dado encontrado.\nTente novamente!",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        for (DisappearanceListItem item : lista) {
            modelo.addRow(new Object[]{
                    item.getPersonName(),
                    item.getAge(),
                    item.getGender(),
                    item.getHeight(),
                    item.getWeight(),
                    item.getHairColor(),
                    item.getEyesColor(),
                    item.getClothesDisappearance(),
                    item.getLocation(),
                    item.getContextDisappearance(),
                    item.getKinship(),
                    item.getCellphone(),
                    item.getStatus()
            });
        }
    }

    private void limparCampos() {
        campoNome.setText("");
        campoIdade.setText("");
        campoAltura.setText("");
        campoCabelo.setText("");
        campoOlhos.setText("");
        campoRoupas.setText("");
        campoLocal.setText("");
        modelo.setRowCount(0);
    }
}
