package com.emergentes.dao;
import com.emergentes.modelo.Usuario;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOimpl  extends  ConexionDB implements  UsuarioDAO{

    @Override
    public void insert(Usuario usuario) throws Exception {
        String sql = "insert into usuarios(nombres, apellidos, email,password) values(?,?,?,md5(?))";
        this.conectar();
        PreparedStatement ps =this.conn.prepareStatement(sql);
        ps.setString(1,usuario.getNombres() );
        ps.setString(2, usuario.getApellidos());
        ps.setString(3,usuario.getCorreo());
        ps.setString(4, usuario.getPassword());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Usuario usuario) throws Exception {
        String sql = "update usuarios set  nombres=?, apellidos=?, email=?,password=md5(?) where id=?";
        this.conectar();
        PreparedStatement ps =this.conn.prepareStatement(sql);
        ps.setString(1,usuario.getNombres() );
        ps.setString(2, usuario.getApellidos());
        ps.setString(3,usuario.getCorreo());
        ps.setString(4, usuario.getPassword());
        ps.setInt(5, usuario.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from usuarios where id=?";
        PreparedStatement ps =this.conn.prepareStatement(sql);
        ps.setInt(1, id);
         ps.executeUpdate();
        this.desconectar();
        
    }
        

    @Override
    public Usuario  getById(int id) throws Exception {
        Usuario usr=new Usuario();
        String sql = "select * from usuarios where id=?";
        this.conectar();
        PreparedStatement ps =this.conn.prepareStatement(sql);
        ps.setInt(1, id);
         ResultSet rs=ps.executeQuery();
         while(rs.next()){
             usr.setId(rs.getInt("id"));
             usr.setNombres(rs.getString("nombres"));
             usr.setApellidos(rs.getString("apellidos"));
             usr.setCorreo(rs.getString("email"));
         }
        this.desconectar();
        return usr;
    }

    @Override
    public List<Usuario> getAll() throws Exception {
          List<Usuario>lista=null;
        String sql = "select * from usuarios";
        PreparedStatement ps =this.conn.prepareStatement(sql);
        this.conectar();
        ResultSet rs=ps.executeQuery();
         lista = new ArrayList<Usuario>();
         while(rs.next()){
             Usuario usr=new Usuario();
             usr.setId(rs.getInt("id"));
             usr.setNombres(rs.getString("nombres"));
             usr.setApellidos(rs.getString("apellidos"));
             usr.setCorreo(rs.getString("email"));
             usr.setPassword("password");
             lista.add(usr);
         }
        this.desconectar();
        return lista;
    }
}
