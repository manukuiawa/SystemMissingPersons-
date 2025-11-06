package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class RegisterPersonMissing {

	private JFrame frame;
	private JTextField inputName;

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
		
		frame.setSize(732,500);
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

	
	

		
	}
}
