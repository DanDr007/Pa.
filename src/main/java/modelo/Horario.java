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
public class Horario {
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

    public int getIdhrs() {
        return idhrs;
    }

    public void setIdhrs(int idhrs) {
        this.idhrs = idhrs;
    }

    public String getNombrehrs() {
        return nombrehrs;
    }

    public void setNombrehrs(String nombrehrs) {
        this.nombrehrs = nombrehrs;
    }
   private int id, idhrs;
    private String nombre, nombrehrs; 
    
    public Horario(){
    
    }
    
    public static List<Horario> buscarAllhrs(){
        List<Horario> lista = new ArrayList<>();
        
        try{
            Connection con = Conexion.getConnection();
            String q = "select ehorario.id_hor, ehorario.nom_hor, choras.rango_hrs from Ehorario INNER JOIN choras ON choras.id_hrs=ehorario.id_hrs ORDER BY ehorario.id_hor";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Horario e = new Horario();
                e.setId(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setNombrehrs(rs.getString(3));
                lista.add(e);
            }
            
            System.out.println("Horario Encontrado");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al buscar a las horarios");
            System.out.println(ed.getMessage());
        
        }
        return lista;
    }
}
