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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import com.churrasqueiro.business.CadastroUsuarioController;
import com.churrasqueiro.entities.Usuario;
import com.churrasqueiro.exceptions.ControllerException;
import com.churrasqueiro.exceptions.DatabaseException;
import javax.swing.JTextArea;

public class TelaPedidoConfirmar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelVermelho;
	private static final int LARGURA = 1280;
	private static final int ALTURA = 720;
	private JButton botaoNovoPedido;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPedidoConfirmar  frame = new TelaPedidoConfirmar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaPedidoConfirmar() {
		
		 Color corPaletaVermelho = new Color(179,13,36);
	     Color corPaletaBege = new Color(227,202,187);
	     Color corPaletaVermelhoInteracao = new Color(200,50,50);
	     Color corPaletaVermelhoPressionado = new Color(150,0,0);
	     Color corPaletaPreto = new Color(0,0,0);
	     Color corPaletaPretoInteração = new Color(35,35,35);
	     Color corPaletaCinza = new Color(140,127,127);
	     Color corPaletaBegeInteracao = new Color(245,225,210);
	     Color corPaletaBegePressionado = new Color(200,175,160);
		
		setTitle("Novo Pedido - Churrasqueiro");
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
		
		JPanel panelBranco = new JPanel();
		panelBranco.setBackground(new Color(227,202,187));
		panelBranco.setBounds(0, 74, 1280, 609);
		panelVermelho.add(panelBranco);
		panelBranco.setLayout(null);
		
		final EstilizacaoRedonda.PainelRedondo panelResumoPedido = new EstilizacaoRedonda.PainelRedondo(null,60,4,corPaletaVermelho,null);
		panelResumoPedido.setFocusable(true);
		panelResumoPedido.requestFocusInWindow();
		panelResumoPedido.setBounds(392, 109, 544, 342);
		panelBranco.add(panelResumoPedido);
		panelResumoPedido.setLayout(null);
		
		JTextArea textResumoPedido = new JTextArea();
		textResumoPedido.setText("1x Hamburguer de Cheedar duplo (R$ 15,00)\n1x Coca Cola de 2 Litros (R$12,00)\n1x Batata com Frango (R$9,00)\n--------------------------------------------------------------------------------------------------------\nTOTAL = R$36,00");
		textResumoPedido.setFont(new Font("Calibri", Font.PLAIN, 16));
		textResumoPedido.setColumns(2);
		textResumoPedido.setForeground(new Color(227,202,187));
		textResumoPedido.setBackground(new Color(179,13,36));
		textResumoPedido.setBounds(12, 12, 520, 318);
		panelResumoPedido.add(textResumoPedido);
		
		JLabel lblConfirmarPedido = new JLabel("Confirmar Pedido");
		lblConfirmarPedido.setForeground(Color.BLACK);
		lblConfirmarPedido.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblConfirmarPedido.setBounds(555, 12, 182, 26);
		panelBranco.add(lblConfirmarPedido);

		final EstilizacaoRedonda.BotaoRedondo botaoConfirmar = new EstilizacaoRedonda.BotaoRedondo("Confirmar",corPaletaVermelho,corPaletaVermelhoInteracao,corPaletaVermelhoPressionado,35);
		botaoConfirmar.setText("Confirmar");
		botaoConfirmar.setFont(new Font("SansSerif", Font.BOLD, 18));
		botaoConfirmar.setForeground(corPaletaBege);
		botaoConfirmar.setBackground(new Color(179,13,36));
		botaoConfirmar.setBounds(565, 509, 182, 38);
        panelBranco.add(botaoConfirmar);
        botaoConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPedidos telaPedidos = new TelaPedidos();
				telaPedidos.setVisible(true);
			}
		});
        
        this.botaoNovoPedido = new EstilizacaoRedonda.BotaoRedondo("Novo Pedido",corPaletaVermelho,corPaletaVermelhoInteracao,corPaletaVermelhoPressionado,35);
        botaoNovoPedido.setText("Novo Pedido");
        botaoNovoPedido.setBounds(519, -13, 233, 97);
        botaoNovoPedido.setForeground(new Color(227,202,187));
    	botaoNovoPedido.setBackground(new Color(179, 13, 36));
    	botaoNovoPedido.setFont(new Font("Calibri", Font.PLAIN, 22));
        panelVermelho.add(botaoNovoPedido);
        	
        final EstilizacaoRedonda.BotaoRedondo botaoSair = new EstilizacaoRedonda.BotaoRedondo("Sair",corPaletaPreto,corPaletaPretoInteração,corPaletaPreto,35);
		botaoSair.setFont(new Font("SansSerif", Font.BOLD, 18));
		botaoSair.setForeground(corPaletaVermelho);
		botaoSair.setBackground(new Color(0, 0, 0));
		botaoSair.setBounds(1149, 24, 83, 38);
        panelVermelho.add(botaoSair);
        botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPedidoAcompanhamento telaPedidoAcompanhamento = new TelaPedidoAcompanhamento();
				telaPedidoAcompanhamento.setVisible(true);
			}
		});
        
        JLabel labelLogoBege = new JLabel("");
        labelLogoBege.setBounds(0, 0, 83, 82);
        panelVermelho.add(labelLogoBege);
        labelLogoBege.setIcon(new ImageIcon("/home/victorscds/Documentos/GitHub/CampusPay/src/main/resources/assets/imagens/iconeJanelaPequena.png"));
        java.net.URL urlLogo = getClass().getResource("/home/victorscds/Documentos/GitHub/CampusPay/src/main/resources/assets/imagens");
        
	}
}