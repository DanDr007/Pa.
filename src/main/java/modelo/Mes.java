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
public class Mes {

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
    
    public Mes(){
    
    }
    
    public static List<Mes> buscarAllMes(){
        List<Mes> lista = new ArrayList<>();
        
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from CMes ORDER BY cmes.id_mes";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Mes e = new Mes();
                e.setId(rs.getInt(1));
                e.setNombre(rs.getString(3));
                lista.add(e);
            }
            
            System.out.println("Mes encontrados");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al buscar a los meses");
            System.out.println(ed.getMessage());
        
        }
        return lista;
    }
}
