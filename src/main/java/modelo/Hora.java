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
public class Hora {

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
    
    public Hora(){
    
    }
    
    public static List<Hora> buscarAllhrs(){
        List<Hora> lista = new ArrayList<>();
        
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from Choras order by choras.id_horas";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Hora e = new Hora();
                e.setId(rs.getInt(1));
                e.setNombre(rs.getString(2));
                lista.add(e);
            }
            
            System.out.println("Horas Encontradas");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al buscar a las horas");
            System.out.println(ed.getMessage());
        
        }
        return lista;
    }
}
