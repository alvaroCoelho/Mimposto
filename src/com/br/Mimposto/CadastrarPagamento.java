package com.br.Mimposto;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.br.Mimposto.banco.ImpostoBanco;

public class CadastrarPagamento extends Activity implements OnClickListener {
	
	TextView txtCadastrarPagamento,txtCadastrarPeriodo,txtNomeConta,txtValor;
	EditText etNomeConta,etValor;
	Button btnCadastrar;
	Spinner spAno,spMeses;
	
	private String [] meses = new String[]{"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
	private String [] anos = new String[]{"2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastrar_pagamento);
		
		txtCadastrarPagamento = (TextView)findViewById(R.id.txtCadastrarImposto);
		txtNomeConta = (TextView)findViewById(R.id.txtNomeConta);
		txtValor = (TextView)findViewById(R.id.txtValor);
		txtCadastrarPeriodo = (TextView)findViewById(R.id.txtCadastrarPeriodo);
		etNomeConta = (EditText)findViewById(R.id.etNomeConta);
		etValor = (EditText)findViewById(R.id.etValor);
		btnCadastrar = (Button)findViewById(R.id.btnCadastrar);
		
		ArrayAdapter<String> adapterMeses = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,meses);
		ArrayAdapter<String> adapterAno = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,anos);
		
		adapterMeses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapterAno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spMeses = (Spinner)findViewById(R.id.spMes);
		spAno = (Spinner)findViewById(R.id.spAno);
		
		spMeses.setAdapter(adapterMeses);
		spAno.setAdapter(adapterAno);
		
		btnCadastrar.setOnClickListener(this);
	}

	public boolean salvarImposto(){
		
		try {
			
			String nome_conta = etNomeConta.getText().toString();
			String mes = spMeses.getSelectedItem().toString();
			String ano = spAno.getSelectedItem().toString();
			double valor = Double.parseDouble(etValor.getText().toString().trim());
			
			ImpostoBanco impostoBanco = new ImpostoBanco(this);
			impostoBanco.inserir(nome_conta,mes,ano,valor);
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		
		case R.id.btnCadastrar:			
	
	if(salvarImposto()){
				
				Toast.makeText(this, "Imposto Cadastrado com Sucessso ", Toast.LENGTH_LONG).show();	
					
				this.finish();
				
			}else{
				
				Toast.makeText(this, "Erro ao Cadastrar a Imposto ", Toast.LENGTH_LONG).show();	
			}
			
			this.finish();	
			
			
		this.finish();
		break;
		
		}
		
		
	}

}
