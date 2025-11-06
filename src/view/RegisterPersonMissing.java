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
	private JTextField inputName;
	private JTextField inputAge;

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
		
		frame.setSize(732,646);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#011826"));
		
		JLabel titleMain = new JLabel("Registrar Nova Pessoa Desaparecida");
		titleMain.setFont(new Font("Arial", Font.BOLD, 25));
		titleMain.setForeground(new Color(217, 4, 61));
		titleMain.setBounds(26, 30, 541, 32);
		frame.getContentPane().add(titleMain);
		
		JLabel lblNewLabel = new JLabel("Informações Pessoais");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(4, 85, 191));
		lblNewLabel.setBounds(28, 75, 183, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator lineSeparator = new JSeparator();
		lineSeparator.setForeground(new Color(255, 255, 255, 80));
		lineSeparator.setBounds(26, 108, 326, 1);
		frame.getContentPane().add(lineSeparator);
		
		JLabel LabelName = new JLabel("Nome Completo:");
		LabelName.setFont(new Font("Arial", Font.PLAIN, 13));
		LabelName.setForeground(new Color(255, 255, 255));
		LabelName.setBackground(new Color(255, 255, 255));
		LabelName.setBounds(26, 138, 113, 16);
		frame.getContentPane().add(LabelName);
		
		inputName = new JTextField();
		inputName.setFont(new Font("Arial", Font.PLAIN, 14));
		inputName.setBackground(new Color(140, 140, 140));
		inputName.setBounds(26, 164, 315, 22);
		frame.getContentPane().add(inputName);
		inputName.setColumns(10);
		inputName.setBorder(BorderFactory.createLineBorder(new Color(99,187,242), 1, true));
		
		JLabel labelAge = new JLabel("Idade: ");
		labelAge.setForeground(Color.WHITE);
		labelAge.setFont(new Font("Arial", Font.PLAIN, 13));
		labelAge.setBackground(Color.WHITE);
		labelAge.setBounds(26, 216, 113, 16);
		frame.getContentPane().add(labelAge);
		
		inputAge = new JTextField();
		inputAge.setFont(new Font("Arial", Font.PLAIN, 14));
		inputAge.setColumns(10);
		inputAge.setBorder(BorderFactory.createLineBorder(new Color(99,187,242), 1, true));
		inputAge.setBackground(new Color(140, 140, 140));
		inputAge.setBounds(26, 245, 148, 22);
		frame.getContentPane().add(inputAge);
		
		JLabel labelSexo = new JLabel("Sexo:");
		labelSexo.setForeground(Color.WHITE);
		labelSexo.setFont(new Font("Arial", Font.PLAIN, 13));
		labelSexo.setBackground(Color.WHITE);
		labelSexo.setBounds(203, 216, 113, 16);
		frame.getContentPane().add(labelSexo);
		
		JComboBox inputSexo = new JComboBox();
		inputSexo.setModel(new DefaultComboBoxModel(new String[] {"Selecione a Opção", "Feminino ", "Masculino ", "Outro"}));
		inputSexo.setBounds(203, 243, 138, 24);
		frame.getContentPane().add(inputSexo);
		
		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setForeground(Color.WHITE);
		labelCPF.setFont(new Font("Arial", Font.PLAIN, 13));
		labelCPF.setBackground(Color.WHITE);
		labelCPF.setBounds(26, 296, 113, 16);
		frame.getContentPane().add(labelCPF);
		
		JFormattedTextField inputCPF = new JFormattedTextField();
		inputCPF.setText("000.000.000-00");
		inputCPF.setBounds(26, 325, 315, 22);
		frame.getContentPane().add(inputCPF);
		
		JLabel labelEndereco = new JLabel("Endereço:");
		labelEndereco.setForeground(Color.WHITE);
		labelEndereco.setFont(new Font("Arial", Font.PLAIN, 13));
		labelEndereco.setBackground(Color.WHITE);
		labelEndereco.setBounds(26, 376, 113, 16);
		frame.getContentPane().add(labelEndereco);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(26, 409, 315, 65);
		frame.getContentPane().add(textArea);

	
	

		
	}
}
