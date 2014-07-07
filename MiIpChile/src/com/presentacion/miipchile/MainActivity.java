package com.presentacion.miipchile;


import com.Entidades.Usuario;
import com.Mantenedores.MantenedorUsuario;
import com.example.miipchile.R;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	EditText usu, pass;

	@TargetApi(Build.VERSION_CODES.GINGERBREAD) //soobre escribe el método
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		usu = (EditText)findViewById(R.id.etUsuario);
		pass = (EditText)findViewById(R.id.etPass1);
		// valida la versión y da permisos en las políticas de seguridad al android para conectarse
		if (android.os.Build.VERSION.SDK_INT > 9) {
   		  StrictMode.ThreadPolicy policy = 
   		          new StrictMode.ThreadPolicy.Builder().permitAll().build();
   		  StrictMode.setThreadPolicy(policy);
   		  }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void validarUsuario(View v){
		
		Usuario u = new Usuario();
		u.setUsuario(usu.getText().toString());
		u.setPassword(pass.getText().toString());
		MantenedorUsuario m = new MantenedorUsuario();
		m.validarUsuario(u);
		
	}
	public void validarUsuario2(View v){
		
		Usuario u = new Usuario();
		String us = usu.getText().toString();
		String pa = pass.getText().toString();
		MantenedorUsuario m = new MantenedorUsuario();
		if(m.valida(us,pa)){
			Toast toast = Toast.makeText(this, "datos  ok", Toast.LENGTH_SHORT);
	        toast.show();
		}else{
			Toast toast = Toast.makeText(this, "datos erronea", Toast.LENGTH_SHORT);
	        toast.show();
		}
		
		
	}
	
	
	public void Ok(boolean valor){
		if(valor == true){
		Toast toast = Toast.makeText(this, "coonexion ok", Toast.LENGTH_SHORT);
        toast.show();
        Intent i = new Intent(this, inicio.class );
        startActivity(i);
		}else{
			Toast toast = Toast.makeText(this, "Mensaje 1", Toast.LENGTH_SHORT);
	        toast.show();
		}
	}

}
