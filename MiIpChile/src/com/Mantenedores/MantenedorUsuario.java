package com.Mantenedores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import android.content.Intent;
import android.widget.Toast;


import com.Datos.Conector;
import com.Entidades.Usuario;
import com.presentacion.miipchile.MainActivity;

public class MantenedorUsuario {

public boolean valida(String user, String pass){
	
	
	//Connection conn = null;
	

		String sql = "select * from Login where Usuario='"+user+"'and Pass='"+pass+"'";
		try {
			Connection conn = Conector.conectorBd();
			
			//conn= Conector.conectarBDMySQL();
			
			//Connection conn = AjpdSoftMySQL.conexionMySQL;
			/*AjpdSoftMySQL vali = new AjpdSoftMySQL();
			if(vali.validar(sql)){
				return true;}
			
			else{
				return false;
			} */
			
			//pst= conn.prepareStatement(sql);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			if(res.next()){		
				return true;	
				
			}else{
				return false;
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
		

	}
	
	
			
	
	
	
public void validarUsuario(Usuario usuario){

	Connection conn = null;
	PreparedStatement pst = null;
	
		String sql = "select * from Login where Usuario="+usuario.getUsuario()+ "and Pass="+usuario.getPassword();
		try {
			conn = Conector.conectorBd();
			//pst= conn.prepareStatement(sql);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			if(res.next()){		
				//m.Ok(true);	
				conn.close();
			}else{
				//m.Ok(false);
				conn.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}



}
