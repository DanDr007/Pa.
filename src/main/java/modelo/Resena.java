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
public class Resena {
  private int id, num, id_lin, id_usu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getId_lin() {
        return id_lin;
    }

    public void setId_lin(int id_pub) {
        this.id_lin = id_pub;
    }

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }
    public Resena (){
    
}
    
    public static int registrarReseña(Reseña e){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "INSERT INTO dreseña(num_res, id_lin, id_usu) "
                    + "values(?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            ps.setInt(1, e.getNum());            
            ps.setInt(2, e.getId_lin());
            ps.setInt(3, e.getId_usu());
            
            estatus = ps.executeUpdate();
            System.out.println("Registro Exitoso del Empleado");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al registrar al empleado");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }
    
    public static int actualizarReseña(Reseña e){
        int estatus = 0;
        try{
            try (Connection con = Conexion.getConnection()) {
                String q = "update dreseña set num_res = ?,"
                        + "id_lin = ?, id_usu = ? "
                        + "where id_res = ?";
                
                PreparedStatement ps = con.prepareStatement(q);
                
                //usar getter and setter
                ps.setInt(1, e.getNum());
                ps.setInt(2, e.getId_lin());
                ps.setInt(3, e.getId_usu());
                ps.setInt(4, e.getId());
                
                estatus = ps.executeUpdate();
                System.out.println("Actualizacion Exitosa del usuario");
            }
        
        }catch(Exception ed){
            System.out.println("Error al actualizar al usuario");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }
    public static List<Reseña> buscarAllReseñaById(int id){
        List<Reseña> lista = new ArrayList<>();
        
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from dreseña where id_lin = ? order by musuarios.id_usu";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Reseña e = new Reseña();
                e.setId(rs.getInt(1));
                e.setNum(rs.getInt(2));
                e.setId_lin(rs.getInt(3));
                e.setId_usu(rs.getInt(4));
                lista.add(e);
            }
            
            System.out.println("Empleado encontrado");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al buscar a los empleado");
            System.out.println(ed.getMessage());
        
        }
        return lista;
    }
    public static float buscarAllResByIdLin(int id){
        List<calificacion> lista = new ArrayList<>();
        int suma=0;
        float promedio = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from dreseña where id_lin = ? order by dreseña.id_usu";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                calificacion e = new calificacion();
                e.setId(rs.getInt(1));
                e.setNum(rs.getInt(2));
                e.setId_pub(rs.getInt(3));
                e.setId_usu(rs.getInt(4));
                lista.add(e);
                suma=suma+e.getNum();
            }
            
            System.out.println("Empleado encontrado");
            con.close();
         promedio = suma/lista.size();
        }catch(Exception ed){
            System.out.println("Error al buscar a los empleado");
            System.out.println(ed.getMessage());
         promedio = 0;
        }
        return promedio;
    }
}  

