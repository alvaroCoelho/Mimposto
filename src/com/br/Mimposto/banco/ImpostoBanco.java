package com.br.Mimposto.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class ImpostoBanco {
	
	

		private CriacaoBanco banco;
		
		public ImpostoBanco(Context context) {
			super();
			this.banco = new CriacaoBanco(context);
			
		}
		
		public void inserir(String nome_conta,String mes,String ano, double valor_imposto){
		    
			   ContentValues valores = new ContentValues();
				
				   valores.put("nome_conta", nome_conta);
				   valores.put("mes", mes);
				   valores.put("ano", ano);
				   valores.put("valor", valor_imposto);
			 
			    	banco.getWritableDatabase().insert("imposto",null, valores);	
			    	banco.close();
			    
			}
		
		
		public double consultarValorTotal(){
			
			 Cursor cursor = banco.getWritableDatabase().rawQuery("SELECT * FROM imposto",null);
			 
			  Double SomaValor = 0.0;
			 
			 while (cursor.moveToNext()){
	    	    	
				 Double valor = cursor.getDouble(cursor.getColumnIndex("valor"));
				 SomaValor = SomaValor + valor;
	    	     
	    	     	}
			 
			 
	    	cursor.close();
	    	banco.close();   
			
			
			
			return SomaValor;
		}
		
		public double consultarValorPorPeriodo(String mes,String ano){
			
			 Cursor cursor = banco.getWritableDatabase().rawQuery("SELECT * FROM imposto", null);
			 
			 Double SomaValor = 0.0;
			 
			 while (cursor.moveToNext()){
	    	    	
				 String mes1 = cursor.getString(cursor.getColumnIndex("mes"));
				 String ano1 = cursor.getString(cursor.getColumnIndex("ano"));
				 Double valor = cursor.getDouble(cursor.getColumnIndex("valor"));
				 
				 if (mes1.equalsIgnoreCase(mes) && ano1.equalsIgnoreCase(ano)){
				 SomaValor = SomaValor + valor;
				 }else{
					 SomaValor = SomaValor + 0.0; 
				         }
	    	     	}
			 
		
			
		
	    	cursor.close();
	    	banco.close();   
			
			
			
			return SomaValor;
		}
		

}
