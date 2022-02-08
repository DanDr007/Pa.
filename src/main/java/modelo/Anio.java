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
public class Anio {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
   private int id, nombre;
    
    
    public Anio(){
    
    }
    
    public static List<Anio> buscarAllAnios(){
        List<Anio> lista = new ArrayList<>();
        
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from CAnio ORDER BY canio.id_ano";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Anio e = new Anio();
                e.setId(rs.getInt(1));
                e.setNombre(rs.getInt(2));
                lista.add(e);
            }
            
            System.out.println("Años encontrados");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al buscar a los años");
            System.out.println(ed.getMessage());
        
        }
        return lista;
    }
}
