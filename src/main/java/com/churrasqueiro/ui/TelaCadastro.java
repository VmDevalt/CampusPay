package com.churrasqueiro.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class TelaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelVermelho;
	private static final int LARGURA = 1280;
	private static final int ALTURA = 720;
	private EstilizacaoRedonda.CaixaTextoRedonda campoLogin;
	private EstilizacaoRedonda.CaixaSenhaRedonda campoSenha;
	private EstilizacaoRedonda.CaixaTextoRedonda campoNome;
	private JButton botaoCriarConta;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaCadastro() {
		
		 Color corPaletaVermelho = new Color(179,13,36);
	     Color corPaletaBege = new Color(227,202,187);
	     Color corPaletaVermelhoInteracao = new Color(200,50,50);
	     Color corPaletaVermelhoPressionado = new Color(150,0,0);
	     Color corPaletaPreto = new Color(0,0,0);
	     Color corPaletaPretoInteração = new Color(35,35,35);
	     Color corPaletaCinza = new Color(140,127,127);
		
		setTitle("Cadastro - Churrasqueiro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setSize(LARGURA, ALTURA);
	    setResizable(false);
	    setLocationRelativeTo(null);
	        
	    panelVermelho = new JPanel();
        panelVermelho.setBackground(new Color(179, 13, 36));
		panelVermelho.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelVermelho);
		panelVermelho.setLayout(null);

        final EstilizacaoRedonda.PainelRedondo panelBranco = new EstilizacaoRedonda.PainelRedondo(null,60,4,corPaletaBege,null);
        panelBranco.setFocusable(true);
        panelBranco.requestFocusInWindow();
		panelBranco.setBounds(90, 85, 1098, 505);
		panelVermelho.add(panelBranco);
		panelBranco.setLayout(null);
		
		this.campoNome = new EstilizacaoRedonda.CaixaTextoRedonda("Digite seu nome completo...",corPaletaVermelho,corPaletaBege,corPaletaCinza,2,35);
		campoNome.setFont(new Font("Calibri", Font.PLAIN, 14));
		campoNome.setToolTipText("Digite seu texto");
		campoNome.setBounds(250, 189, 597, 38);
		panelBranco.add(campoNome);
		campoNome.setColumns(10);
		
		this.campoLogin = new EstilizacaoRedonda.CaixaTextoRedonda("Digite seu email...",corPaletaVermelho,corPaletaBege,corPaletaCinza,2,35);
		campoLogin.setFont(new Font("Calibri", Font.PLAIN, 14));
		campoLogin.setToolTipText("Digite seu texto");
		campoLogin.setBounds(250, 280, 597, 38);
		panelBranco.add(campoLogin);
		campoLogin.setColumns(10);
		
		this.campoSenha = new EstilizacaoRedonda.CaixaSenhaRedonda("Digite sua senha...",corPaletaVermelho,corPaletaBege,corPaletaCinza,2,35);
		campoSenha.setToolTipText("Digite seu texto");
		campoSenha.setFont(new Font("Calibri", Font.PLAIN, 14));
		campoSenha.setColumns(10);
		campoSenha.setBounds(250, 367, 597, 38);
		panelBranco.add(campoSenha);
		
		JLabel labelCadastro = new JLabel("Cadastro de Usuário");
		labelCadastro.setHorizontalAlignment(SwingConstants.CENTER);
	    labelCadastro.setForeground(corPaletaPreto);
	    labelCadastro.setFont(new Font("Calibri", Font.PLAIN, 28));
	    labelCadastro.setBounds(349, 0, 345, 32);
	    panelBranco.add(labelCadastro);
		
		JLabel labelLogin = new JLabel("Login");
	    labelLogin.setForeground(corPaletaPreto);
	    labelLogin.setFont(new Font("Calibri", Font.PLAIN, 17));
	    labelLogin.setBounds(505, 239, 58, 32);
	    panelBranco.add(labelLogin);
			
	    JLabel labelSenha = new JLabel("Senha");
	    labelSenha.setForeground(corPaletaPreto);
	    labelSenha.setFont(new Font("Calibri", Font.PLAIN, 17));
	    labelSenha.setBounds(505, 330, 71, 32);
	    panelBranco.add(labelSenha);
		
	    JLabel labelNomeCompleto = new JLabel("Nome Completo");
	    labelNomeCompleto.setForeground(corPaletaPreto);
		labelNomeCompleto.setFont(new Font("Calibri", Font.PLAIN, 17));
		labelNomeCompleto.setBounds(465, 147, 129, 32);
		panelBranco.add(labelNomeCompleto);
		
		String[] tipoUsuarios = {"Administrador", "Funcionário"};
		JComboBox cBoxTipoUsuario = new JComboBox(tipoUsuarios);
		cBoxTipoUsuario.setBorder(new LineBorder(new Color(179, 13, 36), 1));
		cBoxTipoUsuario.setForeground(corPaletaPreto);
		cBoxTipoUsuario.setBackground(corPaletaBege);
		cBoxTipoUsuario.setFont(new Font("Calibri", Font.PLAIN, 17));
		cBoxTipoUsuario.setMaximumRowCount(2);
		cBoxTipoUsuario.setBounds(424, 102, 202, 23);
		panelBranco.add(cBoxTipoUsuario);
		
		JLabel labelTipoUsuario = new JLabel("Tipo de Usuário");
		labelTipoUsuario.setForeground(corPaletaPreto);
		labelTipoUsuario.setFont(new Font("Calibri", Font.PLAIN, 17));
		labelTipoUsuario.setBounds(465, 58, 129, 32);
		panelBranco.add(labelTipoUsuario);
		
		this.botaoCriarConta = new EstilizacaoRedonda.BotaoRedondo("Criar Conta",corPaletaVermelho,corPaletaVermelhoInteracao,corPaletaVermelhoPressionado,35);
	//	botaoLogar.addActionListener(new ActionListener() {
	//		public void actionPerformed(ActionEvent e) {
	//			cadastrar();
	//		}
	//	});
		botaoCriarConta.setForeground(new Color(255, 255, 255));
		botaoCriarConta.setBackground(new Color(179, 13, 36));
		botaoCriarConta.setBounds(399, 433, 268, 38);
        botaoCriarConta.setFont(new Font("Calibri", Font.PLAIN, 17));
        panelBranco.add(botaoCriarConta);
        
        JLabel labelLogo = new JLabel("");
        labelLogo.setIcon(new ImageIcon("src/main/resources/assets/imagens/logoPequena.png"));
        labelLogo.setBounds(996, 394, 90, 99);
        panelBranco.add(labelLogo);
        java.net.URL urlLogo = getClass().getResource("src/main/resources/assets/imagens/logoPequena.png");
		
	}
}