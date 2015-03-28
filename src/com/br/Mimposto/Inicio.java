package com.br.Mimposto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Inicio extends ActionBarActivity implements OnClickListener{
	
	Button btnCadastrarImposto, btnSaldoTotal,btnSaldoPeriodo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inicio);
		
		btnCadastrarImposto = (Button)findViewById(R.id.btnCadastrarImposto);
		btnSaldoTotal = (Button)findViewById(R.id.btnSaldoTotal);
		btnSaldoPeriodo = (Button)findViewById(R.id.btnSaldoPeriodo);
		
		btnCadastrarImposto.setOnClickListener(this);
		btnSaldoTotal.setOnClickListener(this);
		btnSaldoPeriodo.setOnClickListener(this);
		
	}

	
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		
		
		case R.id.btnCadastrarImposto:
			Intent CadastrarImposto = new Intent(this,CadastrarPagamento.class);
			startActivity(CadastrarImposto);
			break;
			
		case R.id.btnSaldoTotal:
			Intent saldoTotal = new Intent(this,SaldoTotal.class);
			startActivity(saldoTotal);
			break;
			
		case R.id.btnSaldoPeriodo:
			Intent selecaoPeriodo = new Intent(this,SelecaoPeriodo.class);
			startActivity(selecaoPeriodo);
			break;
		
		
		
		
		}
				
	}
	
	
}
