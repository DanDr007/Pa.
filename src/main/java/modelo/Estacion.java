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
public class Estacion {
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
    
    public Estacion(){
    
    }
    
    public static List<Estacion> buscarAllMes(){
        List<Estacion> lista = new ArrayList<>();
        
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from Clinea ORDER BY clinea.id_lin";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Estacion e = new Estacion();
                e.setId(rs.getInt(1));
                e.setNombre(rs.getString(2));
                lista.add(e);
            }
            
            System.out.println("estaciones encontrados");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al buscar a los estaciones");
            System.out.println(ed.getMessage());
        
        }
        return lista;
    }
}
