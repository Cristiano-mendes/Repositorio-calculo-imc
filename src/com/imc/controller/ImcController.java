package com.imc.controller;

import java.text.DecimalFormat;

import com.imc.model.ImcModel;
import com.imc.view.ImcView;

public class ImcController {
	public ImcController() {}
	
	public double CalcularImc (ImcView view) {
		ImcModel calculo = new ImcModel();
		String altura = view.getTxtAltura().getText();
		String peso = view.getTxtPeso().getText();		
				
		String a = altura.replace(",", ".");
		String b = peso.replace(",", ".");
		return calculo.calcularImc(Double.parseDouble(b), Double.parseDouble(a));
		//double imc =  Double.parseDouble(peso)/(Double.parseDouble(a)*2);	

		

	 	
	 	 
	 
	}

}
