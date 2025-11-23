package com.churrasqueiro.ui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EstilizacaoRedonda {
    public static class BotaoRedondo extends JButton {
        private int raioArredondado;
        private Color corSemInteracao;
        private Color corMouseInteracao;
        private Color corPressionada;

        public BotaoRedondo (String label, Color normal, Color mouseI, Color pressionada, int raio){
        super(label);
        this.raioArredondado = raio;
        this.corSemInteracao = normal;
        this.corMouseInteracao = mouseI;
        this.corPressionada = pressionada;

        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                repaint();
            }
            @Override
            public void mouseExited(MouseEvent e){
                repaint();
            }
            @Override
            public void mousePressed(MouseEvent e){
                repaint();
            }
            @Override
            public void mouseReleased(MouseEvent e){
                repaint();
            }
        });
        }

        @Override
        protected void paintComponent(Graphics graficoBasico) {
            Graphics2D graficoAvancado = (Graphics2D) graficoBasico.create();
            graficoAvancado.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

            if (getModel().isPressed()){
                graficoAvancado.setColor(corPressionada);
            }
            else if (getModel().isRollover()){
                graficoAvancado.setColor(corMouseInteracao);
            }
            else{
                graficoAvancado.setColor(corSemInteracao);
            }
            graficoAvancado.fillRoundRect(0,0,getWidth(),getHeight(),raioArredondado,raioArredondado);
            super.paintComponent(graficoBasico);
            graficoAvancado.dispose();
        }
    }
    public static class PainelRedondo extends JPanel {
    private int raioArredondado;
    private Color corPreenchimento;
    private Color corContorno;
    private int espessuraBorda;

        public PainelRedondo(LayoutManager layout, int raio, int espessura , Color preenchimento, Color contorno){
        super(layout);
        this.raioArredondado = raio;
        this.espessuraBorda = espessura;
        this.corPreenchimento = preenchimento;
        this.corContorno = contorno;

        setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics graficoBasico) {
            Graphics2D graficoAvancado = (Graphics2D) graficoBasico.create();
            graficoAvancado.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            graficoAvancado.setColor(corPreenchimento);
            graficoAvancado.fillRoundRect(0,0,getWidth(),getHeight(),raioArredondado,raioArredondado);
            graficoAvancado.setColor(corContorno);
            graficoAvancado.setStroke(new java.awt.BasicStroke(espessuraBorda));
            graficoAvancado.drawRoundRect(espessuraBorda/2,espessuraBorda/2,getWidth() - espessuraBorda, getHeight()- espessuraBorda, raioArredondado, raioArredondado);
            super.paintComponent(graficoBasico);
            graficoAvancado.dispose();
        }
    }
    public static class CaixaTextoRedonda extends JTextField{
        private String espacoTexto;
        private Color espacoCor;
        private Color corContorno;
        private int espessuraBorda;
        private int raioArredondado;

        public CaixaTextoRedonda(String texto, Color contorno, Color fundo, Color corBase, int espessura, int raio){
            super();
            this.espacoTexto = texto;
            this.corContorno = contorno;
            this.espessuraBorda = espessura;
            this.raioArredondado = raio;
            this.espacoCor = corBase;

            setOpaque(false);
            setBackground(fundo);
            setBorder(javax.swing.BorderFactory.createEmptyBorder(5,raioArredondado,5,raioArredondado));

            addFocusListener(new java.awt.event.FocusAdapter(){
                @Override
                public void focusGained(FocusEvent e) {
                    if (getText().equals(espacoTexto)){
                        setText("");
                        setForeground(Color.BLACK);
                    }
                }
                @Override public void focusLost(FocusEvent e){
                    if (getText().isEmpty()){
                        setText(CaixaTextoRedonda.this.espacoTexto);
                        setForeground(CaixaTextoRedonda.this.espacoCor);
                    }
                }
            });
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics graficoBasico) {
            Graphics2D graficoAvancado = (Graphics2D) graficoBasico.create();
            graficoAvancado.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

            graficoAvancado.setColor(getBackground());
            graficoAvancado.fillRoundRect(0,0,getWidth(),getHeight(),raioArredondado,raioArredondado);
            super.paintComponent(graficoBasico);
            graficoAvancado.dispose();
        }
        @Override
        protected void paintBorder(Graphics graficoBasico){
            Graphics2D graficoAvancado = (Graphics2D) graficoBasico.create();
            graficoAvancado.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

            graficoAvancado.setStroke(new java.awt.BasicStroke(espessuraBorda));
            graficoAvancado.setColor(corContorno);
            graficoAvancado.drawRoundRect(espessuraBorda/2,espessuraBorda/2,getWidth() - espessuraBorda, getHeight()- espessuraBorda, raioArredondado, raioArredondado);
            graficoAvancado.dispose();
        }
    }
}
