package com.imc.view;

import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import java.text.DecimalFormat;
import javax.swing.*;
import com.imc.controller.ImcController;

public class ImcView extends JFrame implements ActionListener, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon fundo = new ImageIcon(this.getClass().getResource("recursos/IMC.jpg"));
	ImageIcon imcIcon = new ImageIcon(this.getClass().getResource("recursos/IMCicon.jpg"));
	ImageIcon obesidade3 = new ImageIcon(this.getClass().getResource("recursos/obesidade3.png"));
	ImageIcon obesidade2 = new ImageIcon(this.getClass().getResource("recursos/obesidade2.png"));
	ImageIcon obesidade1 = new ImageIcon(this.getClass().getResource("recursos/obesidade1.png"));
	ImageIcon pesoNormal = new ImageIcon(this.getClass().getResource("recursos/peso_normal.png"));
	ImageIcon sobrepeso = new ImageIcon(this.getClass().getResource("recursos/sobrepeso.png"));
	ImageIcon abaixopeso = new ImageIcon(this.getClass().getResource("recursos/abaixo_peso.png"));
	
	
	JTextField txtIdade = new JTextField();
	JTextField txtAltura = new JTextField();
	JTextField txtPeso = new JTextField();
	JButton btnCalcular = new JButton();	
	JTextArea txtPanel = new JTextArea();
	JLabel fundoImg = new JLabel(fundo);
	JLabel statusImc = new JLabel();
	JButton btnLink = new JButton();
	
	
	public ImcView() {
		setBounds(300,100,fundo.getIconWidth(), fundo.getIconHeight());
		setIconImage(imcIcon.getImage());
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
				
		txtIdade.setBounds(58, 175, 175, 30);
		txtIdade.setBorder(null);
		txtIdade.setOpaque(false);
		add(txtIdade);
		txtIdade.addKeyListener(this);
		
		txtAltura.setBounds(58,270,175,30);
		txtAltura.setBorder(null);
		txtAltura.setOpaque(false);
		add(txtAltura);
		txtAltura.addKeyListener(this);
		
		txtPeso.setBounds(58,365,175,30);
		txtPeso.setBorder(null);
		txtPeso.setOpaque(false);
		add(txtPeso);
		txtPeso.addKeyListener(this);
		
		btnCalcular.setBounds(75,450,140,25);
		btnCalcular.setBorderPainted(false);
		btnCalcular.setContentAreaFilled(false);
		btnCalcular.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnCalcular);
		btnCalcular.addActionListener(this);
		
		btnLink.setBounds(600,445,190,25);
		btnLink.setText("Como tratar IMC irregular");
		btnLink.setBackground(new Color(55,55,91));
		btnLink.setForeground(Color.white);
		btnLink.setBorder(null);
		btnLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
		getContentPane().add(btnLink);
		btnLink.setVisible(false);
		btnLink.addActionListener(this);
				
		txtPanel.setBounds(600, 100, 255, 445);
		txtPanel.setFont(new Font("Arial",Font.BOLD,18));
		txtPanel.setOpaque(false);
		txtPanel.setEditable(false);
		txtPanel.setForeground(Color.BLACK);
		add(txtPanel);
		
		statusImc.setBounds(400,90,124,445);
		statusImc.setBorder(null);		
		add(statusImc);
		statusImc.setVisible(false);
				
		fundoImg.setSize(getSize());
		getContentPane().add(fundoImg);
		setPreferredSize(getSize());
		setVisible(false);
		pack();
				
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnLink) {
			try{
				URI link = new URI("https://pt.wikihow.com/Reduzir-o-IMC");
				Desktop.getDesktop().browse(link); }
			catch(Exception erro){
				JOptionPane.showMessageDialog(null, "Erro: "+erro); }
		}
	if(e.getSource()==btnCalcular) {
		if(txtAltura.getText().isEmpty() || txtPeso.getText().isEmpty()	) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			
		}else {ImcController calculo = new ImcController();
		btnLink.setVisible(true);
		
		if(calculo.CalcularImc(this)>=18.5 && calculo.CalcularImc(this)<=24.99) {
			statusImc.setIcon(pesoNormal);
			txtPanel.setText("Seu IMC: "
					+new DecimalFormat("#.#").format(calculo.CalcularImc(this))
					+ "\nParabéns\n"
					+ "Seu Índice de Massa\n"
					+ "Corporal está regular");
			statusImc.setVisible(true);
			
			
	}else if(calculo.CalcularImc(this)<=18.49) {
		statusImc.setIcon(abaixopeso);
		txtPanel.setText("Seu IMC: "
				+new DecimalFormat("#.#").format(calculo.CalcularImc(this))
				+ "\nAlgumas consequências de\n"
				+ "um Índice de Massa Corporal\n"
				+ "baixo podem ser queda de \n"
				+ "cabelo, infertilidade, \n"
				+ "ausência de menstruação,\n"
				+ "fadiga, stress e ansiedade.");
		
		statusImc.setVisible(true);
		
	}else if(calculo.CalcularImc(this)>=25 && calculo.CalcularImc(this)<=29.99) {
		statusImc.setIcon(sobrepeso);
		txtPanel.setText("Seu IMC: "
				+new DecimalFormat("#.#").format(calculo.CalcularImc(this))
				+ "\nSintomas comuns no\n"
				+ "dia-a-dia de quem sofre\n"
				+ "de obesidade ou sobrepeso\n"
				+ "o sentimento de cansaço e\n"
				+ "falta de energia, bem como\n"
				+ "problemas respiratórios \n"
				+ "como falta de ar ao andar\n"
				+ "ou realizar atividades \n"
				+ "físicas, perceber que \n"
				+ "está suando mais em \n"
				+ "comparação com outras \n"
				+ "pessoas, desenvolver \n"
				+ "irritação na pele,(etc)");
		statusImc.setVisible(true);
		
	}else if(calculo.CalcularImc(this)>=30 && calculo.CalcularImc(this)<=34.99) {
		statusImc.setIcon(obesidade1);
		txtPanel.setText("Seu IMC: "
				+new DecimalFormat("#.#").format(calculo.CalcularImc(this))
				+ "\nSintomas comuns no\n"
				+ "dia-a-dia de quem sofre\n"
				+ "de obesidade ou sobrepeso\n"
				+ "o sentimento de cansaço e\n"
				+ "falta de energia, bem como\n"
				+ "problemas respiratórios \n"
				+ "como falta de ar ao andar\n"
				+ "ou realizar atividades \n"
				+ "físicas, perceber que \n"
				+ "está suando mais em \n"
				+ "comparação com outras \n"
				+ "pessoas, desenvolver \n"
				+ "irritação na pele,(etc).");
		statusImc.setVisible(true);
		
	}else if(calculo.CalcularImc(this)>=35 && calculo.CalcularImc(this)<=39.99) {
		statusImc.setIcon(obesidade2);
		txtPanel.setText("Seu IMC: "
				+new DecimalFormat("#.#").format(calculo.CalcularImc(this))
				+ "\nO obeso tem mais propensão\n"
				+ "a desenvolver problemas como\n"
				+ "hipertensão, doenças cardio-\n"
				+ "vasculares, diabetes tipo 2,\n"
				+ "além de problemas físicos \n"
				+ "como artrose, pedra na vesí-\n"
				+ "cula, artrite, cansaço, re-\n"
				+ "fluxo esofágico, tumores de \n"
				+ "intestino e de vesícula.");
		statusImc.setVisible(true);
		
	}else if(calculo.CalcularImc(this)>=40) {
		statusImc.setIcon(obesidade3);
		txtPanel.setText("Seu IMC: "
				+new DecimalFormat("#.#").format(calculo.CalcularImc(this))
				+ "\nObesidade morbida\n"
				+ "Esta forma de obesidade é\n"
				+ "também classificada como \n"
				+ "grau 3, que é a mais grave,\n"
				+ "pois, neste nível, o excesso\n"
				+ "de peso coloca em risco a \n"
				+ "saúde e tende a diminuir o \n"
				+ "tempo de vida.");
		statusImc.setVisible(true);}
		}
		}else {}
	}//FimActionPerformed

	@Override
	public void keyTyped(KeyEvent e) {
			if(txtIdade.getText().length()>=3) {txtIdade.setText(null);}
			if(txtPeso.getText().length()>=4) {txtPeso.setText(null);}
			if(txtAltura.getText().length()>=5) {txtAltura.setText(null);}			
	}
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	public JTextField getTxtIdade() {
		return txtIdade;
	}
	public void setTxtIdade(JTextField txtIdade) {
		this.txtIdade = txtIdade;
	}
	public JTextField getTxtAltura() {
		return txtAltura;
	}
	public void setTxtAltura(JTextField txtAltura) {
		this.txtAltura = txtAltura;
	}
	public JTextField getTxtPeso() {
		return txtPeso;
	}
	public void setTxtPeso(JTextField txtPeso) {
		this.txtPeso = txtPeso;
	}
	public JTextArea getTxtPanel() {
		return txtPanel;
	}
	public void setTxtPanel(JTextArea txtPanel) {
		this.txtPanel = txtPanel;
	}
	
}
