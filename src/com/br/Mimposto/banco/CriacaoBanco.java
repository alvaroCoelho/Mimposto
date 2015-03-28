package com.br.Mimposto.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriacaoBanco extends SQLiteOpenHelper{
	private static final String NOME_DATABASE = "Mimposto";
	private static final int VERSAO_DATABASE = 1;
	
	
	

	
	private static final String SQL_IMPOSTO  = "CREATE TABLE imposto (nome_conta TEXT,"+
			  "mes TEXT,"+
			  "ano TEXT,"+
			   "valor REAL)";
	

	
	public CriacaoBanco(Context context) {
		super(context, NOME_DATABASE, null, VERSAO_DATABASE);
		
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(SQL_IMPOSTO);
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		
		database.execSQL("DROP TABLE IF EXISTS imposto");
		
		onCreate(database);
		
	}
	
	
	
	
	
	
	
	
	
	

}
