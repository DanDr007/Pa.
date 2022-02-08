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
public class Parada {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_est() {
        return id_est;
    }

    public void setId_est(int id_est) {
        this.id_est = id_est;
    }

    public int getId_lin() {
        return id_lin;
    }

    public void setId_lin(int id_lin) {
        this.id_lin = id_lin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNom_est() {
        return nom_est;
    }

    public void setNom_est(String nom_est) {
        this.nom_est = nom_est;
    }

    public String getNom_lin() {
        return nom_lin;
    }

    public void setNom_lin(String nom_lin) {
        this.nom_lin = nom_lin;
    }
    private int id, id_est, id_lin;
    private String nombre, nom_est, nom_lin;
    
    public static List<Parada> buscarAllParbyLin(int id){
        List<Parada> lista = new ArrayList<>();
        
        try{
            try (Connection con = Conexion.getConnection()) {
                String q = "select eparadas.id_par, clinea.nom_lin, cestacion.nom_est FROM eparadas INNER JOIN clinea ON clinea.id_lin = eparadas.id_lin INNER JOIN cestacion ON cestacion.id_est=eparadas.id_est where eparadas.id_lin = ? ORDER BY eparadas.id_par;";
                
                PreparedStatement ps = con.prepareStatement(q);
                
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Parada e = new Parada();
                    e.setId(rs.getInt(1));
                    e.setNom_lin(rs.getString(2));
                    e.setNom_est(rs.getString(3));
                    lista.add(e);
                }
                
                System.out.println("estaciones encontrados");
            }
        
        }catch(Exception ed){
            System.out.println("Error al buscar a los estaciones");
            System.out.println(ed.getMessage());
        
        }
        return lista;
    }
}
