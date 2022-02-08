/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Control.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PRIDE OTTER
 */
public class inseguridad {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    private int id;
    private String nombre;
    
    public inseguridad(){
    
    }
  public static List<inseguridad> buscarAllIns(){
        List<inseguridad> lista = new ArrayList<>();
        
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from Ctipoinseguridad ORDER BY ctipoinseguridad.id_ins";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                inseguridad e = new inseguridad();
                e.setId(rs.getInt(1));
                e.setNombre(rs.getString(2));
                lista.add(e);
            }
            
            System.out.println("Inseguridades encontradas(¿");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al encontrar inseguridades");
            System.out.println(ed.getMessage());
        
        }
        return lista;
    }   
}
