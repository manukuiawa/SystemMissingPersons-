package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


public class RegisterPerson extends JFrame {
	
	//Criação da Tela
	
	public RegisterPerson() {
		setTitle("Registrar Nova Pessoa Desaparecida"); 
		setSize(750, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setLocationRelativeTo(null);
		
		//Cores
		
		Color backgroundColor = new Color(33, 43, 54);
		Color accentolor = new Color(70, 130, 180);
		Color textColor = Color.WHITE; 
		Color titleColor = Color.MAGENTA;
		
		//Painel Principal
		
		JPanel mainPanel = new JPanel(); 
		mainPanel.setBackground(backgroundColor);
		mainPanel.setLayout(new BorderLayout(20, 20));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
		add(mainPanel);
		
		//Título Principal 
		
		JLabel title = new JLabel("Registrar Nova Pessoa Desaparecida", SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 24));
		title.setForeground(titleColor);
		mainPanel.add(title, BorderLayout.NORTH);
		
		//Conteúdos
		
		JPanel contentPanel = new JPanel (new GridLayout( 1, 2, 30,0));
		contentPanel.setBackground(backgroundColor);
		mainPanel.add(contentPanel, BorderLayout.CENTER);	
		
		//Painel Esquerdo
		JPanel personalPanel = new JPanel();
		personalPanel.setLayout(new BoxLayout(personalPanel, BoxLayout.Y_AXIS));
		personalPanel.setBackground(backgroundColor);

		//Título do Painel Esquerdo
		JLabel subtitleIP = new JLabel("Informações Pessoais");
		subtitleIP.setFont(new Font("Arial", Font.BOLD, 18));
		subtitleIP.setForeground(textColor);
		subtitleIP.setAlignmentX(Component.LEFT_ALIGNMENT);
		personalPanel.add(subtitleIP);
		contentPanel.add(personalPanel);

		//Linha 
		JSeparator lineOne = new JSeparator(); 
		lineOne.setForeground(accentolor);
		lineOne.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
		personalPanel.add(lineOne); 
		personalPanel.add(Box.createVerticalStrut(15));
		setVisible(true);
		
		//Inputs 
		JTextField nomeField = new JTextField(15) {
		    @Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        // Placeholder
		        if (getText().isEmpty()) {
		            Graphics2D g2 = (Graphics2D) g.create();
		            g2.setFont(getFont().deriveFont(Font.ITALIC));
		            g2.setColor(Color.GRAY);
		            g2.drawString("Nome completo", 10, getHeight() / 2 + 5);
		            g2.dispose();
		        }
		    }
		};
		nomeField.setFont(new Font("Arial", Font.PLAIN, 14));
		nomeField.setForeground(Color.WHITE);
		nomeField.setBackground(new Color(33, 43, 54));
		nomeField.setBorder(BorderFactory.createCompoundBorder(
		        new LineBorder(new Color(70, 130, 180), 2, true), // borda arredondada azul
		        BorderFactory.createEmptyBorder(8, 10, 8, 10)
		));

		
		
		
	}
	
	public static void main(String[] args) {
        new RegisterPerson();
    }
}
