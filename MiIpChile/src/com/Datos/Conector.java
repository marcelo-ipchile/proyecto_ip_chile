package com.Datos;

import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.*;

import com.presentacion.miipchile.MainActivity;




import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

public class Conector extends Activity {
	
	 
	
	
	 static Connection conexionMySQL = null;
  Connection conn = null;
  
  /*StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

  StrictMode.setThreadPolicy(policy); */
  
  /*Thread thread = new Thread(new Runnable(){
	    @Override
	    public void run() {
	        try {
	            //Your code goes here
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	});

	thread.start(); */
  
  


    public static Connection conectorBd(){
    	
        try{
        
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://mysql.betatest.cl:3306/android1","anbd2014","aqnhdbdc");
            
            return conn;
        
        
        }catch(Exception e){
           //JOptionPane.showMessageDialog(null,e);
        	//System.out.println("No");
        	// Toast.makeText(null, "hay connexion", Toast.LENGTH_LONG).show();
        	System.out.println(e);
            return null;
        
            
        }
    }
    

    
}
