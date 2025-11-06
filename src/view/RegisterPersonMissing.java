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

public class RegisterPersonMissing {

	private JFrame frame;
	private JTextField inputNome;
	private JTextField inutIdade;
	private JTextField inputLocalDesaparecido;
	private JTextField inputAltura;
	private JTextField inputPeso;

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
		
		frame.setSize(732,803);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#011826"));
		
		JLabel titleMain = new JLabel("Registrar Nova Pessoa Desaparecida");
		titleMain.setFont(new Font("Arial", Font.BOLD, 25));
		titleMain.setForeground(new Color(217, 4, 61));
		titleMain.setBounds(26, 30, 541, 32);
		frame.getContentPane().add(titleMain);
		
		JLabel titulo1Cadastro = new JLabel("Informações Pessoais");
		titulo1Cadastro.setFont(new Font("Arial", Font.BOLD, 15));
		titulo1Cadastro.setForeground(new Color(4, 85, 191));
		titulo1Cadastro.setBounds(28, 75, 183, 24);
		frame.getContentPane().add(titulo1Cadastro);
		
		JSeparator lineSeparator = new JSeparator();
		lineSeparator.setForeground(new Color(255, 255, 255, 80));
		lineSeparator.setBounds(26, 108, 274, 1);
		frame.getContentPane().add(lineSeparator);
		
		JLabel LabelNome = new JLabel("Nome Completo:");
		LabelNome.setFont(new Font("Arial", Font.PLAIN, 13));
		LabelNome.setForeground(new Color(255, 255, 255));
		LabelNome.setBackground(new Color(255, 255, 255));
		LabelNome.setBounds(26, 138, 113, 16);
		frame.getContentPane().add(LabelNome);
		
		inputNome = new JTextField();
		inputNome.setFont(new Font("Arial", Font.PLAIN, 14));
		inputNome.setBackground(new Color(140, 140, 140));
		inputNome.setBounds(26, 164, 274, 22);
		frame.getContentPane().add(inputNome);
		inputNome.setColumns(10);
		inputNome.setBorder(BorderFactory.createLineBorder(new Color(99,187,242), 1, true));
		
		JLabel labelidade = new JLabel("Idade: ");
		labelidade.setForeground(Color.WHITE);
		labelidade.setFont(new Font("Arial", Font.PLAIN, 13));
		labelidade.setBackground(Color.WHITE);
		labelidade.setBounds(26, 216, 113, 16);
		frame.getContentPane().add(labelidade);
		
		inutIdade = new JTextField();
		inutIdade.setFont(new Font("Arial", Font.PLAIN, 14));
		inutIdade.setColumns(10);
		inutIdade.setBorder(BorderFactory.createLineBorder(new Color(99,187,242), 1, true));
		inutIdade.setBackground(new Color(140, 140, 140));
		inutIdade.setBounds(26, 245, 113, 22);
		frame.getContentPane().add(inutIdade);
		
		JLabel labelSexo = new JLabel("Sexo:");
		labelSexo.setForeground(Color.WHITE);
		labelSexo.setFont(new Font("Arial", Font.PLAIN, 13));
		labelSexo.setBackground(Color.WHITE);
		labelSexo.setBounds(166, 216, 113, 16);
		frame.getContentPane().add(labelSexo);
		
		JComboBox inputSexo = new JComboBox();
		inputSexo.setModel(new DefaultComboBoxModel(new String[] {"Selecione a Opção", "Feminino ", "Masculino ", "Outro"}));
		inputSexo.setBounds(166, 244, 134, 24);
		frame.getContentPane().add(inputSexo);
		
		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setForeground(Color.WHITE);
		labelCPF.setFont(new Font("Arial", Font.PLAIN, 13));
		labelCPF.setBackground(Color.WHITE);
		labelCPF.setBounds(26, 296, 113, 16);
		frame.getContentPane().add(labelCPF);
		
		JFormattedTextField inputCPF = new JFormattedTextField();
		inputCPF.setText("000.000.000-00");
		inputCPF.setBounds(26, 325, 274, 22);
		frame.getContentPane().add(inputCPF);
		
		JLabel labelEndereco = new JLabel("Endereço:");
		labelEndereco.setForeground(Color.WHITE);
		labelEndereco.setFont(new Font("Arial", Font.PLAIN, 13));
		labelEndereco.setBackground(Color.WHITE);
		labelEndereco.setBounds(26, 376, 113, 16);
		frame.getContentPane().add(labelEndereco);
		
		JTextArea inputEndereco = new JTextArea();
		inputEndereco.setBounds(26, 409, 274, 65);
		frame.getContentPane().add(inputEndereco);
		
		JLabel titulo2Cadastro = new JLabel("Informações do Desaparecimento");
		titulo2Cadastro.setForeground(new Color(4, 85, 191));
		titulo2Cadastro.setFont(new Font("Arial", Font.BOLD, 15));
		titulo2Cadastro.setBounds(336, 75, 302, 24);
		frame.getContentPane().add(titulo2Cadastro);
		
		JSeparator lineSeparator_1 = new JSeparator();
		lineSeparator_1.setForeground(new Color(255, 255, 255, 80));
		lineSeparator_1.setBounds(336, 108, 315, 1);
		frame.getContentPane().add(lineSeparator_1);
		
		JLabel LabelDataDesaparecimento = new JLabel("Data do Desaparecimento:");
		LabelDataDesaparecimento.setForeground(Color.WHITE);
		LabelDataDesaparecimento.setFont(new Font("Arial", Font.PLAIN, 13));
		LabelDataDesaparecimento.setBackground(Color.WHITE);
		LabelDataDesaparecimento.setBounds(336, 138, 165, 17);
		frame.getContentPane().add(LabelDataDesaparecimento);
		
		JFormattedTextField inputDataDesaparecimento = new JFormattedTextField();
		inputDataDesaparecimento.setText("dd/mm/aaaa");
		inputDataDesaparecimento.setBounds(336, 165, 159, 22);
		frame.getContentPane().add(inputDataDesaparecimento);
		
		JLabel labelHorario = new JLabel("Horário: ");
		labelHorario.setForeground(Color.WHITE);
		labelHorario.setFont(new Font("Arial", Font.PLAIN, 13));
		labelHorario.setBackground(Color.WHITE);
		labelHorario.setBounds(523, 138, 165, 17);
		frame.getContentPane().add(labelHorario);
		
		JFormattedTextField inputHorarioDesaparecimento = new JFormattedTextField();
		inputHorarioDesaparecimento.setText("--:--");
		inputHorarioDesaparecimento.setBounds(523, 165, 165, 22);
		frame.getContentPane().add(inputHorarioDesaparecimento);
		
		JLabel LabelLocaalDesaparecido = new JLabel("Local do Desaparecimento");
		LabelLocaalDesaparecido.setForeground(Color.WHITE);
		LabelLocaalDesaparecido.setFont(new Font("Arial", Font.PLAIN, 13));
		LabelLocaalDesaparecido.setBackground(Color.WHITE);
		LabelLocaalDesaparecido.setBounds(336, 218, 165, 17);
		frame.getContentPane().add(LabelLocaalDesaparecido);
		
		inputLocalDesaparecido = new JTextField();
		inputLocalDesaparecido.setFont(new Font("Arial", Font.PLAIN, 14));
		inputLocalDesaparecido.setColumns(10);
		inputLocalDesaparecido.setBorder(BorderFactory.createLineBorder(new Color(99,187,242), 1, true));
		inputLocalDesaparecido.setBackground(new Color(140, 140, 140));
		inputLocalDesaparecido.setBounds(336, 247, 352, 22);
		frame.getContentPane().add(inputLocalDesaparecido);
		
		JLabel labelRegião = new JLabel("Região: ");
		labelRegião.setForeground(Color.WHITE);
		labelRegião.setFont(new Font("Arial", Font.PLAIN, 13));
		labelRegião.setBackground(Color.WHITE);
		labelRegião.setBounds(336, 298, 113, 16);
		frame.getContentPane().add(labelRegião);
		
		JComboBox inputRegiao = new JComboBox();
		inputRegiao.setModel(new DefaultComboBoxModel(new String[] {"Selecione a Opção: ", "Centro ", "Norte", "Sul", "Leste", "Oeste"}));
		inputRegiao.setBounds(336, 325, 352, 24);
		frame.getContentPane().add(inputRegiao);
		
		JLabel labelCircunstancias = new JLabel("Circunstâncias:");
		labelCircunstancias.setForeground(Color.WHITE);
		labelCircunstancias.setFont(new Font("Arial", Font.PLAIN, 13));
		labelCircunstancias.setBackground(Color.WHITE);
		labelCircunstancias.setBounds(336, 378, 113, 16);
		frame.getContentPane().add(labelCircunstancias);
		
		JFormattedTextField inputCircunstancias = new JFormattedTextField();
		inputCircunstancias.setText("Descreva as Circunstâncias do Desaparecimento");
		inputCircunstancias.setBounds(336, 412, 352, 62);
		frame.getContentPane().add(inputCircunstancias);
		
		JLabel lblCaractersticasFsicas = new JLabel("Características Físicas");
		lblCaractersticasFsicas.setForeground(new Color(4, 85, 191));
		lblCaractersticasFsicas.setFont(new Font("Arial", Font.BOLD, 15));
		lblCaractersticasFsicas.setBounds(26, 511, 183, 24);
		frame.getContentPane().add(lblCaractersticasFsicas);
		
		JSeparator lineSeparator_2 = new JSeparator();
		lineSeparator_2.setForeground(new Color(255, 255, 255, 80));
		lineSeparator_2.setBounds(26, 545, 662, 1);
		frame.getContentPane().add(lineSeparator_2);
		
		inputAltura = new JTextField();
		inputAltura.setFont(new Font("Arial", Font.PLAIN, 14));
		inputAltura.setColumns(10);
		inputAltura.setBorder(BorderFactory.createLineBorder(new Color(99,187,242), 1, true));
		inputAltura.setBackground(new Color(140, 140, 140));
		inputAltura.setBounds(26, 583, 130, 22);
		frame.getContentPane().add(inputAltura);
		
		JLabel labelAltura = new JLabel("Altura: ");
		labelAltura.setForeground(Color.WHITE);
		labelAltura.setFont(new Font("Arial", Font.PLAIN, 13));
		labelAltura.setBackground(Color.WHITE);
		labelAltura.setBounds(26, 557, 113, 16);
		frame.getContentPane().add(labelAltura);
		
		JLabel labelPeso = new JLabel("Peso: ");
		labelPeso.setForeground(Color.WHITE);
		labelPeso.setFont(new Font("Arial", Font.PLAIN, 13));
		labelPeso.setBackground(Color.WHITE);
		labelPeso.setBounds(166, 557, 113, 16);
		frame.getContentPane().add(labelPeso);
		
		inputPeso = new JTextField();
		inputPeso.setFont(new Font("Arial", Font.PLAIN, 14));
		inputPeso.setColumns(10);
		inputPeso.setBorder(BorderFactory.createLineBorder(new Color(99,187,242), 1, true));
		inputPeso.setBackground(new Color(140, 140, 140));
		inputPeso.setBounds(166, 583, 144, 22);
		frame.getContentPane().add(inputPeso);
		
		JComboBox inputCordoCabelo = new JComboBox();
		inputCordoCabelo.setModel(new DefaultComboBoxModel(new String[] {"Selecione a Opção: ", "Loiro ", "Castanho", "Preto", "Ruivo ", "Grisalho", "Careca"}));
		inputCordoCabelo.setBounds(336, 582, 177, 24);
		frame.getContentPane().add(inputCordoCabelo);
		
		JLabel labelCorDoCabelo = new JLabel("Cor do Cabelo:");
		labelCorDoCabelo.setForeground(Color.WHITE);
		labelCorDoCabelo.setFont(new Font("Arial", Font.PLAIN, 13));
		labelCorDoCabelo.setBackground(Color.WHITE);
		labelCorDoCabelo.setBounds(336, 559, 113, 16);
		frame.getContentPane().add(labelCorDoCabelo);
		
		JLabel labelCorDosOlhos = new JLabel("Cor dos Olhos:");
		labelCorDosOlhos.setForeground(Color.WHITE);
		labelCorDosOlhos.setFont(new Font("Arial", Font.PLAIN, 13));
		labelCorDosOlhos.setBackground(Color.WHITE);
		labelCorDosOlhos.setBounds(523, 559, 113, 16);
		frame.getContentPane().add(labelCorDosOlhos);
		
		JComboBox inputCordoCabelo_1 = new JComboBox();
		inputCordoCabelo_1.setModel(new DefaultComboBoxModel(new String[] {"Selecione a Opção: ", "Castanhos ", "Azuis", "Verdes", "Pretos", "Mel "}));
		inputCordoCabelo_1.setBounds(523, 582, 165, 24);
		frame.getContentPane().add(inputCordoCabelo_1);
		
		JLabel labelRoupasNoDesaparecimento = new JLabel("Roupas no Desaparecimento: ");
		labelRoupasNoDesaparecimento.setForeground(Color.WHITE);
		labelRoupasNoDesaparecimento.setFont(new Font("Arial", Font.PLAIN, 13));
		labelRoupasNoDesaparecimento.setBackground(Color.WHITE);
		labelRoupasNoDesaparecimento.setBounds(26, 631, 185, 16);
		frame.getContentPane().add(labelRoupasNoDesaparecimento);

	
	

		
	}
}
