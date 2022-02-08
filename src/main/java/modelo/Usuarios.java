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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PRIDE OTTER
 */
public class Usuarios {



/**
 *
 * @author demon
 */

    
    private int id, rol;

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    private String nombre, email, pas;
    
    public Usuarios(){
    
    }
 public Usuarios verificarUsuario(String user, String pass) throws ClassNotFoundException{
        Usuarios u = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConnection();
            String q = "select * from musuario "
                    + "where correo_usu = ? AND con_usu = ?";
            
            ps = con.prepareStatement(q);
            
            ps.setString(1, user);
            ps.setString(2, pass);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                u = new Usuarios();
                u.setId(rs.getInt("id_usu"));
                u.setNombre(rs.getString("nom_usu"));
                u.setEmail(rs.getString("correo_usu"));
                u.setPas(rs.getString("con_usu"));
                u.setRol(rs.getInt("Rol_usu"));
                System.out.println("Exito al verificar al usuario");

                break;
                
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar al usuario");
            System.out.println(sq.getMessage());
            u = null;
        }finally{
            try{
                rs.close();
                ps.close();
                con.close();
            }catch(Exception e){
                System.out.println("Error al desconectar la BD");
                System.out.println(e.getMessage());
            }
        }
        return u;
    } 

public static int registrarEmpleado(Usuarios e){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "INSERT INTO musuario(nom_usu, correo_usu, con_usu, Rol_usu) "
                    + "values(?,?,?, ?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            ps.setString(1, e.getNombre());            
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getPas());
            ps.setInt(4, e.getRol());
            
            estatus = ps.executeUpdate();
            System.out.println("Registro Exitoso del Empleado");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al registrar al empleado");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }

public static int actualizarEmpleado(Usuarios e){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "update musuario set nom_usu = ?,"
                    + "correo_usu = ?, con_usu = ? "
                    + "where id_usu = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            ps.setString(1, e.getNombre());           
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getPas());
            ps.setInt(4, e.getId());
            
            estatus = ps.executeUpdate();
            System.out.println("Actualizacion Exitosa del usuario");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al actualizar al usuario");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }

public static int borrarEmpleado(int id){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "delete from musuario where id_usu = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            ps.setInt(1, id);
            
            
            estatus = ps.executeUpdate();
            System.out.println("Borrado Exitoso del Usuario");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al borrar al usuario");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }

public static Usuarios buscarEmpleadoById(int id){
        Usuarios e = new Usuarios();
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from musuario where id_usu= ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                e.setId(rs.getInt(1));
                e.setNombre(rs.getString(2));               
                e.setEmail(rs.getString(3));
                e.setPas(rs.getString(4));
                e.setRol(rs.getInt(5));
            }
            
            System.out.println("Usuario encontrado");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al buscar al usuario");
            System.out.println(ed.getMessage());
        
        }
        return e;
    }

 public static ArrayList<Usuarios> buscarAllEmpleados(){
        ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
        
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from musuario order by musuario.id_usu";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Usuarios e = new Usuarios();
                e.setId(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setEmail(rs.getString(3));
                e.setPas(rs.getString(4));
                e.setRol(rs.getInt(5));
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
    
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }
    
    
    
    
}   

