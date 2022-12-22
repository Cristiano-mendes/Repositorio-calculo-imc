package com.imc.controller;

import com.imc.model.ImcModel;
import com.imc.view.ImcView;

public class ImcController {
	public ImcController() {}
	
	public Double CalcularImc (ImcView view) {
		ImcModel calculo = new ImcModel();
		double altura = Double.parseDouble(view.getTxtAltura().getText());
		double peso = Double.parseDouble(view.getTxtPeso().getText());
		calculo.calcularImc(altura, peso);
		Double resp = (peso/(altura*altura));
		
		String res = String.format("%s", resp);
	 	
	 	return resp;
	 	 
	 
	}

}
