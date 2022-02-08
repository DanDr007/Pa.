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
public class publicacion {
    private int id, id_hor, id_ins, id_par, id_usu, id_mes, id_anio, repeticiones, id_lin;

    public int getId_lin() {
        return id_lin;
    }

    public void setId_lin(int id_lin) {
        this.id_lin = id_lin;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }
    private String contenido, nom_hor, nom_ins, nom_lin, nom_est, nom_usu, nom_mes, num_ano;

    public int getId_hor() {
        return id_hor;
    }

    public void setId_hor(int id_hor) {
        this.id_hor = id_hor;
    }

    public int getId_ins() {
        return id_ins;
    }

    public void setId_ins(int id_ins) {
        this.id_ins = id_ins;
    }

    public int getId_par() {
        return id_par;
    }

    public void setId_par(int id_par) {
        this.id_par = id_par;
    }

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public int getId_mes() {
        return id_mes;
    }

    public void setId_mes(int id_mes) {
        this.id_mes = id_mes;
    }

    public int getId_anio() {
        return id_anio;
    }

    public void setId_anio(int id_anio) {
        this.id_anio = id_anio;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getNom_hor() {
        return nom_hor;
    }

    public void setNom_hor(String nom_hor) {
        this.nom_hor = nom_hor;
    }

    public String getNom_ins() {
        return nom_ins;
    }

    public void setNom_ins(String nom_ins) {
        this.nom_ins = nom_ins;
    }

    public String getNom_lin() {
        return nom_lin;
    }

    public void setNom_lin(String nom_lin) {
        this.nom_lin = nom_lin;
    }

    public String getNom_est() {
        return nom_est;
    }

    public void setNom_est(String nom_est) {
        this.nom_est = nom_est;
    }

    public String getNom_usu() {
        return nom_usu;
    }

    public void setNom_usu(String nom_usu) {
        this.nom_usu = nom_usu;
    }

    public String getNom_mes() {
        return nom_mes;
    }

    public void setNom_mes(String nom_mes) {
        this.nom_mes = nom_mes;
    }

    public String getNum_ano() {
        return num_ano;
    }

    public void setNum_ano(String num_ano) {
        this.num_ano = num_ano;
    }
    
    public publicacion(){
    
    }


public static int registrarPublicacion(publicacion e){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "INSERT INTO mpublicacion(Des_pub, id_hor, id_ins, id_par, id_usu, id_mes, id_anio) "
                    + "values(?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            ps.setString(1, e.getContenido());            
            ps.setInt(2, e.getId_hor());
            ps.setInt(3, e.getId_ins());
            ps.setInt(4, e.getId_par());
            ps.setInt(5, e.getId_usu());
            ps.setInt(6, e.getId_mes());
            ps.setInt(7, e.getId_anio());
            
            estatus = ps.executeUpdate();
            System.out.println("Registro Exitoso del publicacion");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al registrar al publicacion");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }

public static int actualizarPublicacion(publicacion e){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "update mpublicacion set des_pub = ?, id_hor = ?, id_ins = ?,"
                    + "id_par = ?, id_mes = ?, id_anio = ? "
                    + "where id_pub = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            ps.setString(1, e.getContenido());            
            ps.setInt(2, e.getId_hor());
            ps.setInt(3, e.getId_ins());
            ps.setInt(4, e.getId_par());
           
            ps.setInt(5, e.getId_mes());
            ps.setInt(6, e.getId_anio());
            ps.setInt(7, e.getId());
            
            estatus = ps.executeUpdate();
            System.out.println("Actualizacion Exitosa del publicacion");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al actualizar al publicacion");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }

public static int borrarPublicacion(int id){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "delete from mpublicacion where id_pub = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            ps.setInt(1, id);
            
            
            estatus = ps.executeUpdate();
            System.out.println("Borrado Exitoso del publicacion");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al borrar al publicacion");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }

public static publicacion buscarPublicacionById(int id){
        publicacion e = new publicacion();
        try{
            Connection con = Conexion.getConnection();
            String q = "select mpublicacion.ID_pub, mpublicacion.des_pub, ehorario.nom_hor, ctipoinseguridad.nom_ins, clinea.nom_lin, cestacion.nom_est, musuario.nom_usu, cmes.nom_mes, canio.num_ano FROM mpublicacion INNER JOIN eparadas ON eparadas.id_par = mpublicacion.id_par INNER JOIN clinea ON clinea.id_lin = eparadas.id_lin INNER JOIN cestacion ON cestacion.id_est=eparadas.id_est INNER JOIN ehorario ON ehorario.id_hor=mpublicacion.id_hor INNER JOIN ctipoinseguridad ON ctipoinseguridad.id_ins=mpublicacion.id_ins INNER JOIN musuario ON musuario.id_usu=mpublicacion.id_usu INNER JOIN cmes ON cmes.id_mes=mpublicacion.id_mes INNER JOIN canio ON canio.id_ano=mpublicacion.id_anio WHERE id_pub = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                e.setId(rs.getInt(1));
                e.setContenido(rs.getString(2));               
                e.setNom_hor(rs.getString(3));
                e.setNom_ins(rs.getString(4));
                e.setNom_lin(rs.getString(5));
                e.setNom_est(rs.getString(6));
                e.setNom_usu(rs.getString(7));
                e.setNom_mes(rs.getString(8));
                e.setNum_ano(rs.getString(9));
            }   
            
            System.out.println("Publicacion encontrado");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al buscar al Publicacion");
            System.out.println(ed.getMessage());
        
        }
        return e;
    }

 public static List<publicacion> buscarAllPublicaciones(){
        List<publicacion> lista = new ArrayList<publicacion>();
        
        try{
            Connection con = Conexion.getConnection();
            String q = "select mpublicacion.ID_pub, mpublicacion.des_pub, ehorario.nom_hor, ctipoinseguridad.nom_ins, clinea.nom_lin, cestacion.nom_est, musuario.nom_usu, cmes.nom_mes, canio.num_ano, eparadas.id_lin FROM mpublicacion INNER JOIN eparadas ON eparadas.id_par = mpublicacion.id_par INNER JOIN clinea ON clinea.id_lin = eparadas.id_lin INNER JOIN cestacion ON cestacion.id_est=eparadas.id_est INNER JOIN ehorario ON ehorario.id_hor=mpublicacion.id_hor INNER JOIN ctipoinseguridad ON ctipoinseguridad.id_ins=mpublicacion.id_ins INNER JOIN musuario ON musuario.id_usu=mpublicacion.id_usu INNER JOIN cmes ON cmes.id_mes=mpublicacion.id_mes INNER JOIN canio ON canio.id_ano=mpublicacion.id_anio ORDER BY mpublicacion.id_pub";
            
            PreparedStatement ps = con.prepareStatement(q);
            
           
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                publicacion e = new publicacion();
                e.setId(rs.getInt(1));
                e.setContenido(rs.getString(2));               
                e.setNom_hor(rs.getString(3));
                e.setNom_ins(rs.getString(4));
                e.setNom_lin(rs.getString(5));
                e.setNom_est(rs.getString(6));
                e.setNom_usu(rs.getString(7));
                e.setNom_mes(rs.getString(8));
                e.setNum_ano(rs.getString(9));
                e.setId_lin(rs.getInt(10));
                lista.add(e);
            }
            
            System.out.println("Publicacion encontrado");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al buscar a los Publicacion");
            System.out.println(ed.getMessage());
        
        }
        return lista;
    }
 
public static List<publicacion> buscarAllPublicacionesByLinea(int id){
        List<publicacion> lista = new ArrayList<>();
       
        try{
            Connection con = Conexion.getConnection();
            String q = "select mpublicacion.ID_pub, mpublicacion.des_pub, mpublicacion.id_usu, ehorario.nom_hor, ctipoinseguridad.nom_ins, clinea.nom_lin, cestacion.nom_est, musuario.nom_usu, cmes.nom_mes, canio.num_ano FROM mpublicacion INNER JOIN eparadas ON eparadas.id_par = mpublicacion.id_par INNER JOIN clinea ON clinea.id_lin = eparadas.id_lin INNER JOIN cestacion ON cestacion.id_est=eparadas.id_est INNER JOIN ehorario ON ehorario.id_hor=mpublicacion.id_hor INNER JOIN ctipoinseguridad ON ctipoinseguridad.id_ins=mpublicacion.id_ins INNER JOIN musuario ON musuario.id_usu=mpublicacion.id_usu INNER JOIN cmes ON cmes.id_mes=mpublicacion.id_mes INNER JOIN canio ON canio.id_ano=mpublicacion.id_anio where eparadas.id_lin = ? ORDER BY mpublicacion.id_pub DESC";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                publicacion e = new publicacion();
                e.setId(rs.getInt(1));
                e.setContenido(rs.getString(2));
                e.setId_usu(rs.getInt(3)); 
                e.setNom_hor(rs.getString(4));
                e.setNom_ins(rs.getString(5));
                e.setNom_lin(rs.getString(6));
                e.setNom_est(rs.getString(7));
                e.setNom_usu(rs.getString(8));
                e.setNom_mes(rs.getString(9));
                e.setNum_ano(rs.getString(10));
                lista.add(e);
                System.out.println(e.getContenido());
            }
            System.out.println(lista.get(1).getContenido());
            System.out.println("Publicacion encontrado");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al buscar a los Publicacion");
            System.out.println(ed.getMessage());
        
        }
        return lista;
    }
public static List<publicacion> buscarAllRepeticiones(int id){
        List<publicacion> lista = new ArrayList<>();
       
        try{
            Connection con = Conexion.getConnection();
            String q = "select COUNT(mpublicacion.id_ins) as Repetidos, ctipoinseguridad.nom_ins, MPUBLICACION.ID_INS FROM mpublicacion INNER JOIN eparadas ON eparadas.id_par=mpublicacion.id_par INNER JOIN ctipoinseguridad ON ctipoinseguridad.id_ins=mpublicacion.id_ins where eparadas.id_lin=? group by mpublicacion.id_ins order by repetidos DESC";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                publicacion e = new publicacion();
                e.setRepeticiones(rs.getInt(1));
                e.setNom_ins(rs.getString(2));
                
                lista.add(e);
                System.out.println(e.getContenido());
            }
            System.out.println(lista.get(1).getContenido());
            System.out.println("Publicacion encontrado");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al buscar a los Publicacion");
            System.out.println(ed.getMessage());
        
        }
        return lista;
    }
public static List<publicacion> buscarAllRepeticiones2(int id){
        List<publicacion> lista = new ArrayList<>();
       
        try{
            Connection con = Conexion.getConnection();
            String q = "select COUNT(mpublicacion.id_hor) as Repetidos, ehorario.nom_hor, MPUBLICACION.ID_hor FROM mpublicacion INNER JOIN eparadas ON eparadas.id_par=mpublicacion.id_par INNER JOIN ehorario ON ehorario.id_hor=mpublicacion.id_hor where eparadas.id_lin=? group by mpublicacion.id_hor order by repetidos DESC";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                publicacion e = new publicacion();
                e.setRepeticiones(rs.getInt(1));
                e.setNom_ins(rs.getString(2));
                
                lista.add(e);
                System.out.println(e.getContenido());
            }
            System.out.println(lista.get(1).getContenido());
            System.out.println("Publicacion encontrado");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al buscar a los Publicacion");
            System.out.println(ed.getMessage());
        
        }
        return lista;
    }

public static List<publicacion> buscarAllRepeticiones3(){
        List<publicacion> lista = new ArrayList<>();
       
        try{
            Connection con = Conexion.getConnection();
            String q = "select COUNT(mpublicacion.id_mes) as Repetidos, ehorario.nom_hor, ctipoinseguridad.nom_ins, cmes.nom_mes FROM mpublicacion INNER JOIN eparadas ON eparadas.id_par=mpublicacion.id_par INNER JOIN clinea ON clinea.id_lin = eparadas.id_lin INNER JOIN ehorario ON ehorario.id_hor=mpublicacion.id_hor INNER JOIN cmes ON cmes.id_mes=mpublicacion.id_mes INNER JOIN ctipoinseguridad ON ctipoinseguridad.id_ins=mpublicacion.id_ins group by mpublicacion.id_mes order by repetidos DESC";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                publicacion e = new publicacion();
                e.setRepeticiones(rs.getInt(1));
                e.setNom_hor(rs.getString(2));
                e.setNom_ins(rs.getString(3));
                e.setNom_mes(rs.getString(4));
                lista.add(e);
                System.out.println(e.getContenido());
            }
            System.out.println(lista.get(1).getContenido());
            System.out.println("Publicacion encontrado");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al buscar a los Publicacion");
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

    
}
