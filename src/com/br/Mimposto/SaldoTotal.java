package com.br.Mimposto;

import com.br.Mimposto.banco.ImpostoBanco;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SaldoTotal extends Activity{
	
	TextView txtTituloSaldo,txtData,txtCifrao,txtValorTotal;

  @Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.saldo_total);
	
	txtTituloSaldo = (TextView)findViewById(R.id.txtTituloSaldo);
	txtData = (TextView)findViewById(R.id.txtData);
	txtCifrao = (TextView)findViewById(R.id.txtCifrao);
	txtValorTotal = (TextView)findViewById(R.id.txtvalorTotal);
	
	ImpostoBanco impostoBanco = new ImpostoBanco(this);
	Double valorTotal = impostoBanco.consultarValorTotal();
	
	txtValorTotal.setText(String.valueOf(valorTotal));
	
	
}	
	
}
