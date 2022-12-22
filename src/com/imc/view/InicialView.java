package com.imc.view;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class InicialView extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon fundo = new ImageIcon(getClass().getResource("recursos/Inicial.jpg"));
	JButton btnIniciar = new JButton();
	JButton btnSair = new JButton();
	JButton btnLink = new JButton();
	JLabel Fundo = new JLabel(fundo);
		
	public InicialView() {
		setBounds(200,0,900,700);
		setLayout(null);
		setResizable(false);
		setUndecorated(true);
		setIconImage(new ImcView().getIconImage());
		btnIniciar.setBounds(562,68,250,50);
		btnIniciar.setContentAreaFilled(false);
		btnIniciar.setBorder(null);
		btnIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		getContentPane().add(btnIniciar);
		btnIniciar.addActionListener(this);
		
		btnSair.setBounds(562,205,250,50);
		btnSair.setContentAreaFilled(false);
		btnSair.setBorder(null);
		btnSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
		getContentPane().add(btnSair);
		btnSair.addActionListener(this);
		
		btnLink.setBounds(562,136,250,50);
		btnLink.setContentAreaFilled(false);
		btnLink.setBorder(null);
		btnLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
		getContentPane().add(btnLink);
		btnLink.addActionListener(this);
		
		Fundo.setBounds(0,0,getWidth(),getHeight());	
		getContentPane().add(Fundo);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnIniciar) {
			new ImcView().setVisible(true);
			dispose();
		}else if(e.getSource()==btnLink) {
			//String[] args;
			try{
				URI link = new URI("https://www.significados.com.br/imc/");
				Desktop.getDesktop().browse(link); }
			catch(Exception erro){
				JOptionPane.showMessageDialog(null, "Erro: "+erro); }
			
		}else if(e.getSource()==btnSair) {			
			int res = JOptionPane.showConfirmDialog(
				Fundo, "Deseja sair?","Confirmação",JOptionPane.YES_NO_OPTION);
			if(res == JOptionPane.YES_OPTION) {System.exit(0);}
			
		}
		else{};
	}

}
