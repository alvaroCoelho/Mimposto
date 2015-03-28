package com.br.Mimposto;

import com.br.Mimposto.banco.ImpostoBanco;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class SelecaoPeriodo extends Activity implements OnClickListener{
	
	TextView txtPeriodo,txtResultadoMes,txtResultadoAno,txtResultadoSaldo;
	Spinner spinnerAno,spinnerMeses;
    Button btnConsultar;
    
	private String [] meses = new String[]{"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
	private String [] anos = new String[]{"2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selecao_periodo);
		
		txtPeriodo = (TextView)findViewById(R.id.txtPeriodo);
		txtResultadoMes = (TextView)findViewById(R.id.txtResultadoMes);
		txtResultadoAno = (TextView)findViewById(R.id.txtResultadoAno);
		txtResultadoSaldo = (TextView)findViewById(R.id.txtResultadoValor);
		
		spinnerMeses = (Spinner)findViewById(R.id.spMes);
		spinnerAno = (Spinner)findViewById(R.id.spAno);
		
		btnConsultar = (Button)findViewById(R.id.btnConsultar);
		
		ArrayAdapter<String> adapterMeses = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,meses);
		ArrayAdapter<String> adapterAno = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,anos);
		
		adapterMeses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapterAno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spinnerMeses.setAdapter(adapterMeses);
		spinnerAno.setAdapter(adapterAno);
		
		btnConsultar.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		
		case R.id.btnConsultar:
	
			String mes = spinnerMeses.getSelectedItem().toString();
			String ano = spinnerAno.getSelectedItem().toString();
			
			ImpostoBanco impostoBanco = new ImpostoBanco(this);
			String  valor = String.valueOf( impostoBanco.consultarValorPorPeriodo(mes, ano));
			
			txtResultadoMes.setText(mes);
			txtResultadoAno.setText(ano);
			txtResultadoSaldo.setText("R$ "+valor);
			
			
			break;
		
		}
		
	}
	
}
