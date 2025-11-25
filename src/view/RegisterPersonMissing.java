package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.BaseDao;
import dao.CharacteristicsDao;
import dao.CommunicantDao;
import dao.DisappearanceDao;
import dao.InformsDao;
import dao.PeopleDao;
import dao.RegisterCommunicantDao;
import dao.RegisterDao;
import model.Communicant;
import model.Disappearance;
import model.People;
import model.PhysicalCharacteristics;
import model.Register;
import model.StatusRegister;

public class RegisterPersonMissing {

	private JFrame frame;
	private JTextField inputNome;
	private JTextField inutIdade;
	private JTextField inputLocalDesaparecido;
	private JTextField inputAltura;
	private JTextField inputPeso;
	private JTextField inputNomeComunicante;

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
	
	//para abrir a tela na outra tela
	public void abrir() {
	    frame.setVisible(true);
	}
	
	public RegisterPersonMissing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.getContentPane().setFont(new Font("Arial", Font.BOLD, 18));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(732, 794);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#011826"));

		JLabel titleMain = new JLabel("Registrar Nova Pessoa Desaparecida");
		titleMain.setFont(new Font("Arial", Font.BOLD, 25));
		titleMain.setForeground(new Color(244, 45, 48));
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
		inputNome.setBackground(new Color(10, 46, 66));
		inputNome.setBounds(26, 124, 274, 22);
		frame.getContentPane().add(inputNome);
		inputNome.setColumns(10);
		inputNome.setBorder(BorderFactory.createLineBorder(new Color(99, 187, 242), 1, true));

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
		inutIdade.setBorder(BorderFactory.createLineBorder(new Color(99, 187, 242), 1, true));
		inutIdade.setBackground(new Color(10, 46, 66));
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
		inputSexo.setModel(
				new DefaultComboBoxModel(new String[] { "Selecione a Opção", "Feminino ", "Masculino ", "Outro" }));
		inputSexo.setBounds(149, 181, 134, 24);
		frame.getContentPane().add(inputSexo);
		inputSexo.setBorder(BorderFactory.createLineBorder(new Color(99, 187, 242), 1, true));
		inputSexo.setBackground(new Color(0, 128, 192));

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
		inputCPF.setBorder(BorderFactory.createLineBorder(new Color(99, 187, 242), 1, true));
		inputCPF.setBackground(new Color(10, 46, 66));
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
		inputEndereco.setBackground(new Color(10, 46, 66));
		inputEndereco.setBorder(BorderFactory.createLineBorder(new Color(99, 187, 242), 1, true));
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
		inputDataDesaparecimento.setForeground(new Color(255, 255, 255));
		inputDataDesaparecimento.setBackground(new Color(10, 46, 66));
		inputDataDesaparecimento.setBorder(BorderFactory.createLineBorder(new Color(99, 187, 242), 1, true));
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
		inputHorarioDesaparecimento.setForeground(new Color(255, 255, 255));
		inputHorarioDesaparecimento.setText("--:--");
		inputHorarioDesaparecimento.setBounds(523, 125, 165, 22);
		inputHorarioDesaparecimento.setBorder(BorderFactory.createLineBorder(new Color(99, 187, 242), 1, true));
		inputHorarioDesaparecimento.setBackground(new Color(10, 46, 66));
		frame.getContentPane().add(inputHorarioDesaparecimento);

		JLabel LabelLocaalDesaparecido = new JLabel("Local do Desaparecimento");
		LabelLocaalDesaparecido.setForeground(Color.WHITE);
		LabelLocaalDesaparecido.setFont(new Font("Arial", Font.PLAIN, 13));
		LabelLocaalDesaparecido.setBackground(Color.WHITE);
		LabelLocaalDesaparecido.setBounds(334, 156, 165, 17);
		frame.getContentPane().add(LabelLocaalDesaparecido);

		inputLocalDesaparecido = new JTextField();
		inputLocalDesaparecido.setForeground(new Color(255, 255, 255));
		inputLocalDesaparecido.setFont(new Font("Arial", Font.PLAIN, 14));
		inputLocalDesaparecido.setColumns(10);
		inputLocalDesaparecido.setBorder(BorderFactory.createLineBorder(new Color(99, 187, 242), 1, true));
		inputLocalDesaparecido.setBackground(new Color(10, 46, 66));
		inputLocalDesaparecido.setBounds(334, 182, 352, 22);
		frame.getContentPane().add(inputLocalDesaparecido);

		JLabel labelRegião = new JLabel("Região: ");
		labelRegião.setForeground(Color.WHITE);
		labelRegião.setFont(new Font("Arial", Font.PLAIN, 13));
		labelRegião.setBackground(Color.WHITE);
		labelRegião.setBounds(334, 218, 113, 16);
		frame.getContentPane().add(labelRegião);

		JComboBox inputRegiao = new JComboBox();
		inputRegiao.setForeground(new Color(255, 255, 255));
		inputRegiao.setModel(new DefaultComboBoxModel(
				new String[] { "Selecione a Opção: ", "Centro ", "Norte", "Sul", "Leste", "Oeste" }));
		inputRegiao.setBounds(336, 242, 352, 24);
		inputRegiao.setBorder(BorderFactory.createLineBorder(new Color(99, 187, 242), 1, true));
		inputRegiao.setBackground(new Color(0, 128, 192));
		frame.getContentPane().add(inputRegiao);

		JLabel labelCircunstancias = new JLabel("Circunstâncias:");
		labelCircunstancias.setForeground(Color.WHITE);
		labelCircunstancias.setFont(new Font("Arial", Font.PLAIN, 13));
		labelCircunstancias.setBackground(Color.WHITE);
		labelCircunstancias.setBounds(334, 284, 113, 16);
		frame.getContentPane().add(labelCircunstancias);

		JFormattedTextField inputCircunstancias = new JFormattedTextField();
		inputCircunstancias.setForeground(new Color(255, 255, 255));
		inputCircunstancias.setText("Descreva as Circunstâncias do Desaparecimento");
		inputCircunstancias.setBounds(336, 310, 352, 62);
		inputCircunstancias.setBorder(BorderFactory.createLineBorder(new Color(99, 187, 242), 1, true));
		inputCircunstancias.setBackground(new Color(10, 46, 66));

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
		inputAltura.setForeground(new Color(255, 255, 255));
		inputAltura.setFont(new Font("Arial", Font.PLAIN, 14));
		inputAltura.setColumns(10);
		inputAltura.setBorder(BorderFactory.createLineBorder(new Color(99, 187, 242), 1, true));
		inputAltura.setBackground(new Color(10, 46, 66));
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
		inputPeso.setForeground(new Color(255, 255, 255));
		inputPeso.setFont(new Font("Arial", Font.PLAIN, 14));
		inputPeso.setColumns(10);
		inputPeso.setBorder(BorderFactory.createLineBorder(new Color(99, 187, 242), 1, true));
		inputPeso.setBackground(new Color(10, 46, 66));
		inputPeso.setBounds(165, 462, 144, 22);
		frame.getContentPane().add(inputPeso);

		JComboBox inputCordoCabelo = new JComboBox();
		inputCordoCabelo.setForeground(new Color(255, 255, 255));
		inputCordoCabelo.setModel(new DefaultComboBoxModel(
				new String[] { "Selecione a Opção: ", "Loiro ", "Castanho", "Preto", "Ruivo ", "Grisalho", "Careca" }));
		inputCordoCabelo.setBounds(334, 461, 177, 24);
		inputCordoCabelo.setBackground(new Color(0, 128, 192));
		inputCordoCabelo.setBorder(BorderFactory.createLineBorder(new Color(99, 187, 242), 1, true));
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

		JComboBox inputCordosOlhos = new JComboBox();
		inputCordosOlhos.setForeground(new Color(255, 255, 255));
		inputCordosOlhos.setModel(new DefaultComboBoxModel(
				new String[] { "Selecione a Opção: ", "Castanhos ", "Azuis", "Verdes", "Pretos", "Mel " }));
		inputCordosOlhos.setBounds(523, 461, 165, 24);
		inputCordosOlhos.setBorder(BorderFactory.createLineBorder(new Color(99, 187, 242), 1, true));
		inputCordosOlhos.setBackground(new Color(0, 128, 192));
		frame.getContentPane().add(inputCordosOlhos);

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
		inputSinais.setForeground(new Color(255, 255, 255));
		inputSinais.setText("Tatuagens, cicatrizes, marcas de nascença...");
		inputSinais.setBounds(334, 520, 352, 62);
		inputSinais.setBackground(new Color(10, 46, 66));
		inputSinais.setBorder(BorderFactory.createLineBorder(new Color(99, 187, 242), 1, true));
		frame.getContentPane().add(inputSinais);

		JFormattedTextField inputDescrevaAsRoupas = new JFormattedTextField();
		inputDescrevaAsRoupas.setForeground(new Color(255, 255, 255));
		inputDescrevaAsRoupas.setText("Descreva as roupas que a pessoa estava usando...");
		inputDescrevaAsRoupas.setBounds(25, 520, 284, 62);
		inputDescrevaAsRoupas.setBorder(BorderFactory.createLineBorder(new Color(99, 187, 242), 1, true));
		inputDescrevaAsRoupas.setBackground(new Color(10, 46, 66));
		frame.getContentPane().add(inputDescrevaAsRoupas);

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

		inputNomeComunicante = new JTextField();
		inputNomeComunicante.setForeground(new Color(255, 255, 255));
		inputNomeComunicante.setFont(new Font("Arial", Font.PLAIN, 14));
		inputNomeComunicante.setColumns(10);
		inputNomeComunicante.setBorder(BorderFactory.createLineBorder(new Color(99, 187, 242), 1, true));
		inputNomeComunicante.setBackground(new Color(10, 46, 66));
		inputNomeComunicante.setBounds(26, 661, 239, 22);
		frame.getContentPane().add(inputNomeComunicante);

		JLabel lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 13));
		lblTelefone.setBackground(Color.WHITE);
		lblTelefone.setBounds(275, 635, 185, 16);
		frame.getContentPane().add(lblTelefone);

		JFormattedTextField inputTelefone = new JFormattedTextField();
		inputTelefone.setForeground(new Color(255, 255, 255));
		inputTelefone.setText("(xx) xxxxx-xxxx");
		inputTelefone.setBounds(275, 662, 196, 22);
		inputTelefone.setBackground(new Color(10, 46, 66));
		inputTelefone.setBorder(BorderFactory.createLineBorder(new Color(99, 187, 242), 1, true));
		frame.getContentPane().add(inputTelefone);

		JLabel labelParentesco = new JLabel("Parentesco: ");
		labelParentesco.setForeground(Color.WHITE);
		labelParentesco.setFont(new Font("Arial", Font.PLAIN, 13));
		labelParentesco.setBackground(Color.WHITE);
		labelParentesco.setBounds(481, 635, 185, 16);
		frame.getContentPane().add(labelParentesco);

		JComboBox inputParentesco = new JComboBox();
		inputParentesco.setForeground(new Color(255, 255, 255));
		inputParentesco.setModel(new DefaultComboBoxModel(new String[] { "Selecione a Opção: ", "Pai ", "Mãe",
				"Filho(a)", "Cônjuge", "Irmão(a)", "Amigo(a)", "Outro" }));
		inputParentesco.setBounds(481, 662, 196, 21);
		inputParentesco.setBorder(BorderFactory.createLineBorder(new Color(99, 187, 242), 1));
		inputParentesco.setBackground(new Color(0, 128, 192));
		frame.getContentPane().add(inputParentesco);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(244, 45, 48));
		btnCancelar.setBounds(484, 712, 113, 32);
		frame.getContentPane().add(btnCancelar);
		
		//Para fechar, quando clica em cancelar
		btnCancelar.addActionListener(e -> {
		    frame.dispose(); 
		});

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        BaseDao base = new BaseDao();
		        Connection conn = null;

		        try {
		            conn = base.getConnection();
		            conn.setAutoCommit(false);
		            
		            //CADASTRAR PESSOA
		        
		            People pessoa = new People();
		            pessoa.setPersonName(inputNome.getText());
		            pessoa.setAge(Integer.parseInt(inutIdade.getText()));
		            pessoa.setGender(inputSexo.getSelectedItem().toString());
		            pessoa.setCPF(inputCPF.getText());
		            pessoa.setAddress(inputEndereco.getText());

		            PeopleDao pdao = new PeopleDao();
		            pdao.insert(conn, pessoa);

		            int idPeople = base.getLastInsertedId(conn);


		            //CADASTRAR DESAPARECIMENTO
		      
		            Disappearance d = new Disappearance();

		            try {
		                DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		                DateTimeFormatter hf = DateTimeFormatter.ofPattern("HH:mm");

		                d.setDateDisappearance(LocalDate.parse(inputDataDesaparecimento.getText(), df));
		                d.setHourDisappearance(LocalTime.parse(inputHorarioDesaparecimento.getText(), hf));

		            } catch (Exception ex) {
		                JOptionPane.showMessageDialog(null, "Data ou hora inválida!");
		                return;
		            }

		            d.setLocation(inputLocalDesaparecido.getText());
		            d.setContextDisappearance(inputCircunstancias.getText());
		            d.setClothesDisappearance(inputDescrevaAsRoupas.getText());
		            d.setId_peoples(idPeople);

		            DisappearanceDao ddao = new DisappearanceDao();
		            ddao.insert(conn, d);

		            int idDisappearance = base.getLastInsertedId(conn);


		            //CARACTERISTICAS FÍSICAS
		        
		            PhysicalCharacteristics pc = new PhysicalCharacteristics();

		            pc.setHeight(Double.parseDouble(inputAltura.getText()));
		            pc.setWeight(Double.parseDouble(inputPeso.getText()));
		            pc.setHairColor(inputCordoCabelo.getSelectedItem().toString());
		            pc.setEyesColor(inputCordosOlhos.getSelectedItem().toString());
		            pc.setSigns(inputSinais.getText());
		            pc.setIdPeople(idPeople);

		            CharacteristicsDao cdao = new CharacteristicsDao();
		            cdao.insert(conn, pc);

		            // COMUNICANTE
		            
		            Communicant com = new Communicant();
		            com.setCellphone(inputTelefone.getText());
		            com.setKinship(inputParentesco.getSelectedItem().toString());

		            CommunicantDao comdao = new CommunicantDao();
		            comdao.insert(conn, com);

		            int idCommunicant = base.getLastInsertedId(conn);

		
		            // REGISTRO
		          
		            Register reg = new Register();
		            reg.setDateReport(new java.util.Date());
		            reg.setStatusRegister(StatusRegister.ANDAMENTO);
		            reg.setIdPeople(idPeople);

		            RegisterDao rdao = new RegisterDao();
		            rdao.insert(conn, reg);

		            int idRegister = base.getLastInsertedId(conn);
		           
		            // VINCULAR REGISTRO + COMUNICANTE
		           
		            RegisterCommunicantDao rcdao = new RegisterCommunicantDao();
		            rcdao.insert(conn, idRegister, idCommunicant);


		            
		            // VINCULAR COMUNICANTE + DESAPARECIMENTO
		            
		            InformsDao idao = new InformsDao();
		            idao.insert(conn, idCommunicant, idDisappearance);

		            
		            // FINALIZAR TRANSAÇÃO
		            
		            conn.commit();
		            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");

		        } catch (Exception ex) {
		            try {
		                if (conn != null) conn.rollback();
		            } catch (Exception e2) {}

		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Erro ao registrar: " + ex.getMessage());

		        } finally {
		            try {
		                if (conn != null) conn.close();
		            } catch (SQLException ex) {}
		        }

		    }
		});

		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 13));
		btnRegistrar.setBackground(new Color(4, 85, 191));
		btnRegistrar.setBounds(607, 712, 101, 32);
		frame.getContentPane().add(btnRegistrar);
	}
}