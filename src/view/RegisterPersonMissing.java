package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import javax.swing.JButton;

public class RegisterPersonMissing {

	private JFrame frame;
	private JTextField inputNome;
	private JTextField inutIdade;
	private JTextField inputLocalDesaparecido;
	private JTextField inputAltura;
	private JTextField inputPeso;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPersonMissing window = new RegisterPersonMissing();
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
	public RegisterPersonMissing() {    
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(732,794);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#011826"));
		
		JLabel titleMain = new JLabel("Registrar Nova Pessoa Desaparecida");
		titleMain.setFont(new Font("Arial", Font.BOLD, 25));
		titleMain.setForeground(new Color(244,45,48));
		titleMain.setBounds(26, 10, 541, 32);
		frame.getContentPane().add(titleMain);
		
		JLabel titulo1Cadastro = new JLabel("Informações Pessoais");
		titulo1Cadastro.setFont(new Font("Arial", Font.BOLD, 15));
		titulo1Cadastro.setForeground(new Color(4, 85, 191));
		titulo1Cadastro.setBounds(26, 52, 183, 24);
		frame.getContentPane().add(titulo1Cadastro);
		
		JSeparator lineSeparator = new JSeparator();
		lineSeparator.setForeground(new Color(255, 255, 255, 80));
		lineSeparator.setBounds(26, 87, 274, 1);
		frame.getContentPane().add(lineSeparator);
		
		JLabel LabelNome = new JLabel("Nome Completo:");
		LabelNome.setFont(new Font("Arial", Font.PLAIN, 13));
		LabelNome.setForeground(new Color(255, 255, 255));
		LabelNome.setBackground(new Color(255, 255, 255));
		LabelNome.setBounds(26, 98, 113, 16);
		frame.getContentPane().add(LabelNome);
		
		inputNome = new JTextField();
		inputNome.setForeground(new Color(255, 255, 255));
		inputNome.setFont(new Font("Arial", Font.PLAIN, 14));
		inputNome.setBackground(new Color(10,46,66));
		inputNome.setBounds(26, 124, 274, 22);
		frame.getContentPane().add(inputNome);
		inputNome.setColumns(10);
		inputNome.setBorder(BorderFactory.createLineBorder(new Color(99,187,242), 1, true));
		
		JLabel labelidade = new JLabel("Idade: ");
		labelidade.setForeground(Color.WHITE);
		labelidade.setFont(new Font("Arial", Font.PLAIN, 13));
		labelidade.setBackground(Color.WHITE);
		labelidade.setBounds(26, 156, 113, 16);
		frame.getContentPane().add(labelidade);
		
		inutIdade = new JTextField();
		inutIdade.setForeground(new Color(255, 255, 255));
		inutIdade.setFont(new Font("Arial", Font.PLAIN, 14));
		inutIdade.setColumns(10);
		inutIdade.setBorder(BorderFactory.createLineBorder(new Color(99,187,242), 1, true));
		inutIdade.setBackground(new Color(10,46,66));
		inutIdade.setBounds(26, 182, 113, 22);
		frame.getContentPane().add(inutIdade);
		
		JLabel labelSexo = new JLabel("Sexo:");
		labelSexo.setForeground(Color.WHITE);
		labelSexo.setFont(new Font("Arial", Font.PLAIN, 13));
		labelSexo.setBackground(Color.WHITE);
		labelSexo.setBounds(149, 156, 113, 16);
		frame.getContentPane().add(labelSexo);
		
		JComboBox inputSexo = new JComboBox();
		inputSexo.setForeground(new Color(255, 255, 255));
		inputSexo.setModel(new DefaultComboBoxModel(new String[] {"Selecione a Opção", "Feminino ", "Masculino ", "Outro"}));
		inputSexo.setBounds(149, 181, 134, 24);
		frame.getContentPane().add(inputSexo);
		inputSexo.setBorder(BorderFactory.createLineBorder(new Color(99,187,242), 1, true));
		inputSexo.setBackground(new Color(10,46,66));
		
		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setForeground(Color.WHITE);
		labelCPF.setFont(new Font("Arial", Font.PLAIN, 13));
		labelCPF.setBackground(Color.WHITE);
		labelCPF.setBounds(26, 218, 113, 16);
		frame.getContentPane().add(labelCPF);
		
		JFormattedTextField inputCPF = new JFormattedTextField();
		inputCPF.setForeground(new Color(255, 255, 255));
		inputCPF.setText("000.000.000-00");
		inputCPF.setBounds(26, 244, 274, 22);
		inputCPF.setBorder(BorderFactory.createLineBorder(new Color(99,187,242), 1, true));
		inputCPF.setBackground(new Color(10,46,66));
		frame.getContentPane().add(inputCPF);
		
		JLabel labelEndereco = new JLabel("Endereço:");
		labelEndereco.setForeground(Color.WHITE);
		labelEndereco.setFont(new Font("Arial", Font.PLAIN, 13));
		labelEndereco.setBackground(Color.WHITE);
		labelEndereco.setBounds(26, 284, 113, 16);
		frame.getContentPane().add(labelEndereco);
		
		JTextArea inputEndereco = new JTextArea();
		inputEndereco.setForeground(new Color(255, 255, 255));
		inputEndereco.setBounds(26, 310, 274, 65);
		inputEndereco.setBackground(new Color(10,46,66));
		inputEndereco.setBorder(BorderFactory.createLineBorder(new Color(99,187,242), 1, true));
		frame.getContentPane().add(inputEndereco);
		
		JLabel titulo2Cadastro = new JLabel("Informações do Desaparecimento");
		titulo2Cadastro.setForeground(new Color(4, 85, 191));
		titulo2Cadastro.setFont(new Font("Arial", Font.BOLD, 15));
		titulo2Cadastro.setBounds(334, 52, 302, 24);
		frame.getContentPane().add(titulo2Cadastro);
		
		JSeparator lineSeparator_1 = new JSeparator();
		lineSeparator_1.setForeground(new Color(255, 255, 255, 80));
		lineSeparator_1.setBounds(334, 87, 315, 1);
		frame.getContentPane().add(lineSeparator_1);
		
		JLabel LabelDataDesaparecimento = new JLabel("Data do Desaparecimento:");
		LabelDataDesaparecimento.setForeground(Color.WHITE);
		LabelDataDesaparecimento.setFont(new Font("Arial", Font.PLAIN, 13));
		LabelDataDesaparecimento.setBackground(Color.WHITE);
		LabelDataDesaparecimento.setBounds(334, 98, 165, 17);
		frame.getContentPane().add(LabelDataDesaparecimento);
		
		JFormattedTextField inputDataDesaparecimento = new JFormattedTextField();
		inputDataDesaparecimento.setText("dd/mm/aaaa");
		inputDataDesaparecimento.setBounds(334, 125, 159, 22);
		frame.getContentPane().add(inputDataDesaparecimento);
		
		JLabel labelHorario = new JLabel("Horário: ");
		labelHorario.setForeground(Color.WHITE);
		labelHorario.setFont(new Font("Arial", Font.PLAIN, 13));
		labelHorario.setBackground(Color.WHITE);
		labelHorario.setBounds(523, 98, 165, 17);
		frame.getContentPane().add(labelHorario);
		
		JFormattedTextField inputHorarioDesaparecimento = new JFormattedTextField();
		inputHorarioDesaparecimento.setText("--:--");
		inputHorarioDesaparecimento.setBounds(523, 125, 165, 22);
		frame.getContentPane().add(inputHorarioDesaparecimento);
		
		JLabel LabelLocaalDesaparecido = new JLabel("Local do Desaparecimento");
		LabelLocaalDesaparecido.setForeground(Color.WHITE);
		LabelLocaalDesaparecido.setFont(new Font("Arial", Font.PLAIN, 13));
		LabelLocaalDesaparecido.setBackground(Color.WHITE);
		LabelLocaalDesaparecido.setBounds(334, 156, 165, 17);
		frame.getContentPane().add(LabelLocaalDesaparecido);
		
		inputLocalDesaparecido = new JTextField();
		inputLocalDesaparecido.setFont(new Font("Arial", Font.PLAIN, 14));
		inputLocalDesaparecido.setColumns(10);
		inputLocalDesaparecido.setBorder(BorderFactory.createLineBorder(new Color(99,187,242), 1, true));
		inputLocalDesaparecido.setBackground(new Color(140, 140, 140));
		inputLocalDesaparecido.setBounds(334, 182, 352, 22);
		frame.getContentPane().add(inputLocalDesaparecido);
		
		JLabel labelRegião = new JLabel("Região: ");
		labelRegião.setForeground(Color.WHITE);
		labelRegião.setFont(new Font("Arial", Font.PLAIN, 13));
		labelRegião.setBackground(Color.WHITE);
		labelRegião.setBounds(334, 218, 113, 16);
		frame.getContentPane().add(labelRegião);
		
		JComboBox inputRegiao = new JComboBox();
		inputRegiao.setModel(new DefaultComboBoxModel(new String[] {"Selecione a Opção: ", "Centro ", "Norte", "Sul", "Leste", "Oeste"}));
		inputRegiao.setBounds(336, 242, 352, 24);
		frame.getContentPane().add(inputRegiao);
		
		JLabel labelCircunstancias = new JLabel("Circunstâncias:");
		labelCircunstancias.setForeground(Color.WHITE);
		labelCircunstancias.setFont(new Font("Arial", Font.PLAIN, 13));
		labelCircunstancias.setBackground(Color.WHITE);
		labelCircunstancias.setBounds(334, 284, 113, 16);
		frame.getContentPane().add(labelCircunstancias);
		
		JFormattedTextField inputCircunstancias = new JFormattedTextField();
		inputCircunstancias.setText("Descreva as Circunstâncias do Desaparecimento");
		inputCircunstancias.setBounds(336, 310, 352, 62);
		frame.getContentPane().add(inputCircunstancias);
		
		JLabel lblCaractersticasFsicas = new JLabel("Características Físicas");
		lblCaractersticasFsicas.setForeground(new Color(4, 85, 191));
		lblCaractersticasFsicas.setFont(new Font("Arial", Font.BOLD, 15));
		lblCaractersticasFsicas.setBounds(26, 391, 183, 24);
		frame.getContentPane().add(lblCaractersticasFsicas);
		
		JSeparator lineSeparator_2 = new JSeparator();
		lineSeparator_2.setForeground(new Color(255, 255, 255, 80));
		lineSeparator_2.setBounds(26, 425, 662, 1);
		frame.getContentPane().add(lineSeparator_2);
		
		inputAltura = new JTextField();
		inputAltura.setFont(new Font("Arial", Font.PLAIN, 14));
		inputAltura.setColumns(10);
		inputAltura.setBorder(BorderFactory.createLineBorder(new Color(99,187,242), 1, true));
		inputAltura.setBackground(new Color(140, 140, 140));
		inputAltura.setBounds(25, 462, 130, 22);
		frame.getContentPane().add(inputAltura);
		
		JLabel labelAltura = new JLabel("Altura: ");
		labelAltura.setForeground(Color.WHITE);
		labelAltura.setFont(new Font("Arial", Font.PLAIN, 13));
		labelAltura.setBackground(Color.WHITE);
		labelAltura.setBounds(26, 436, 113, 16);
		frame.getContentPane().add(labelAltura);
		
		JLabel labelPeso = new JLabel("Peso: ");
		labelPeso.setForeground(Color.WHITE);
		labelPeso.setFont(new Font("Arial", Font.PLAIN, 13));
		labelPeso.setBackground(Color.WHITE);
		labelPeso.setBounds(165, 436, 113, 16);
		frame.getContentPane().add(labelPeso);
		
		inputPeso = new JTextField();
		inputPeso.setFont(new Font("Arial", Font.PLAIN, 14));
		inputPeso.setColumns(10);
		inputPeso.setBorder(BorderFactory.createLineBorder(new Color(99,187,242), 1, true));
		inputPeso.setBackground(new Color(140, 140, 140));
		inputPeso.setBounds(165, 462, 144, 22);
		frame.getContentPane().add(inputPeso);
		
		JComboBox inputCordoCabelo = new JComboBox();
		inputCordoCabelo.setModel(new DefaultComboBoxModel(new String[] {"Selecione a Opção: ", "Loiro ", "Castanho", "Preto", "Ruivo ", "Grisalho", "Careca"}));
		inputCordoCabelo.setBounds(334, 461, 177, 24);
		frame.getContentPane().add(inputCordoCabelo);
		
		JLabel labelCorDoCabelo = new JLabel("Cor do Cabelo:");
		labelCorDoCabelo.setForeground(Color.WHITE);
		labelCorDoCabelo.setFont(new Font("Arial", Font.PLAIN, 13));
		labelCorDoCabelo.setBackground(Color.WHITE);
		labelCorDoCabelo.setBounds(336, 436, 113, 16);
		frame.getContentPane().add(labelCorDoCabelo);
		
		JLabel labelCorDosOlhos = new JLabel("Cor dos Olhos:");
		labelCorDosOlhos.setForeground(Color.WHITE);
		labelCorDosOlhos.setFont(new Font("Arial", Font.PLAIN, 13));
		labelCorDosOlhos.setBackground(Color.WHITE);
		labelCorDosOlhos.setBounds(536, 436, 113, 16);
		frame.getContentPane().add(labelCorDosOlhos);
		
		JComboBox inputCordoCabelo_1 = new JComboBox();
		inputCordoCabelo_1.setModel(new DefaultComboBoxModel(new String[] {"Selecione a Opção: ", "Castanhos ", "Azuis", "Verdes", "Pretos", "Mel "}));
		inputCordoCabelo_1.setBounds(523, 461, 165, 24);
		frame.getContentPane().add(inputCordoCabelo_1);
		
		JLabel labelRoupasNoDesaparecimento = new JLabel("Roupas no Desaparecimento: ");
		labelRoupasNoDesaparecimento.setForeground(Color.WHITE);
		labelRoupasNoDesaparecimento.setFont(new Font("Arial", Font.PLAIN, 13));
		labelRoupasNoDesaparecimento.setBackground(Color.WHITE);
		labelRoupasNoDesaparecimento.setBounds(26, 494, 185, 16);
		frame.getContentPane().add(labelRoupasNoDesaparecimento);
		
		JLabel lblSinaisParticulares = new JLabel("Sinais Particulares: ");
		lblSinaisParticulares.setForeground(Color.WHITE);
		lblSinaisParticulares.setFont(new Font("Arial", Font.PLAIN, 13));
		lblSinaisParticulares.setBackground(Color.WHITE);
		lblSinaisParticulares.setBounds(334, 494, 113, 16);
		frame.getContentPane().add(lblSinaisParticulares);
		
		JFormattedTextField inputSinais = new JFormattedTextField();
		inputSinais.setText("Tatuagens, cicatrizes, marcas de nascença...");
		inputSinais.setBounds(334, 520, 352, 62);
		frame.getContentPane().add(inputSinais);
		
		JFormattedTextField frmtdtxtfldDescrevaAsRoupas = new JFormattedTextField();
		frmtdtxtfldDescrevaAsRoupas.setText("Descreva as roupas que a pessoa estava usando...");
		frmtdtxtfldDescrevaAsRoupas.setBounds(25, 520, 284, 62);
		frame.getContentPane().add(frmtdtxtfldDescrevaAsRoupas);
		
		JLabel lblDadosDoComunicante = new JLabel("Dados do Comunicante");
		lblDadosDoComunicante.setForeground(new Color(4, 85, 191));
		lblDadosDoComunicante.setFont(new Font("Arial", Font.BOLD, 15));
		lblDadosDoComunicante.setBounds(26, 601, 183, 24);
		frame.getContentPane().add(lblDadosDoComunicante);
		
		JSeparator lineSeparator_2_1 = new JSeparator();
		lineSeparator_2_1.setForeground(new Color(255, 255, 255, 80));
		lineSeparator_2_1.setBounds(26, 624, 662, 1);
		frame.getContentPane().add(lineSeparator_2_1);
		
		JLabel labelNomeComunicante = new JLabel("Nome do Comunicante:");
		labelNomeComunicante.setForeground(Color.WHITE);
		labelNomeComunicante.setFont(new Font("Arial", Font.PLAIN, 13));
		labelNomeComunicante.setBackground(Color.WHITE);
		labelNomeComunicante.setBounds(26, 635, 185, 16);
		frame.getContentPane().add(labelNomeComunicante);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBorder(BorderFactory.createLineBorder(new Color(99,187,242), 1, true));
		textField.setBackground(new Color(140, 140, 140));
		textField.setBounds(26, 661, 239, 22);
		frame.getContentPane().add(textField);
		
		JLabel lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 13));
		lblTelefone.setBackground(Color.WHITE);
		lblTelefone.setBounds(275, 635, 185, 16);
		frame.getContentPane().add(lblTelefone);
		
		JFormattedTextField frmtdtxtfldxxXxxxxxxxx = new JFormattedTextField();
		frmtdtxtfldxxXxxxxxxxx.setText("(xx) xxxxx-xxxx");
		frmtdtxtfldxxXxxxxxxxx.setBounds(275, 662, 196, 22);
		frame.getContentPane().add(frmtdtxtfldxxXxxxxxxxx);
		
		JLabel labelParentesco = new JLabel("Parentesco: ");
		labelParentesco.setForeground(Color.WHITE);
		labelParentesco.setFont(new Font("Arial", Font.PLAIN, 13));
		labelParentesco.setBackground(Color.WHITE);
		labelParentesco.setBounds(481, 635, 185, 16);
		frame.getContentPane().add(labelParentesco);
		
		JComboBox inputCordoCabelo_2 = new JComboBox();
		inputCordoCabelo_2.setModel(new DefaultComboBoxModel(new String[] {"Selecione a Opção: ", "Pai ", "Mãe", "Filho(a)", "Cônjuge", "Irmão(a)", "Amigo(a)", "Outro"}));
		inputCordoCabelo_2.setBounds(481, 662, 196, 21);
		frame.getContentPane().add(inputCordoCabelo_2);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(484, 712, 113, 32);
		frame.getContentPane().add(btnCancelar);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(607, 712, 101, 32);
		frame.getContentPane().add(btnRegistrar);

	
	

		
	}
}
