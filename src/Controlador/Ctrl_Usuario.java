
package Controlador;

import Modelo.Usuario;
import principal.Conexion;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
        

/**
 *
 * @author Usuario
 */
public class Ctrl_Usuario {
    
    Conexion cx;
    public boolean guardar(Usuario objeto){
        boolean respuesta = false;
        cx = new Conexion("bd_gestpro");
        
        PreparedStatement ps;
        String sql = "INSERT INTO usuario (Nombre, Cedula, Password, Usuario, Estado) VALUES (?,?,?,?,?)";
        try {
            cx.conectar();
            ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, objeto.getNombre());
            ps.setString(2, objeto.getCedula());
            ps.setString(3, objeto.getPassword());
            ps.setString(4,objeto.getUsuario());
            ps.setInt(5, 1);
            ps.execute();
            return true;
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error al guardar"+ e.toString());
            return false;
        
        }finally {
            cx.desconectar();
        }
    }
    
    public boolean existeUsuario(String usuario){
        boolean respuesta = false;
        String sql = "Select Usuario from usuario where usuario = '"+ usuario + "';";
        Statement st;
        try{
            cx = new Conexion("bd_gestpro");
            st = cx.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                respuesta = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al consultar usuario: " + ex);
        }
        return respuesta;
    }
    
    
    public boolean actualizar(Usuario objeto,String idUsuario){
        boolean respuesta = false;
        cx = new Conexion("bd_gestpro");
        
        PreparedStatement ps;
        try {
            cx.conectar();
            ps = cx.conectar().prepareStatement("update usuario set  Cedula = ? , Password = ?, Usuario = ?  where Nombre = '" + idUsuario + "'");
            ps.setString(2, objeto.getCedula());
            ps.setString(3, objeto.getPassword());
            ps.setString(4,objeto.getUsuario());
            ps.execute();
            return true;
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error al actualizar"+ e.toString());
            return false;
        
        }finally {
            cx.desconectar();
        }
    }
    
    //Metodo para eliminar un nuevo usuario
    public boolean eliminar(String idUsuario){
        boolean respuesta = false;
        cx = new Conexion("bd_gestpro");
        
        PreparedStatement ps;
        try {
            cx.conectar();
            ps = cx.conectar().prepareStatement("delete from usuario where Nombre = '" + idUsuario + "'");
            ps.executeUpdate();
            return true;
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error al eliminar"+ e.toString());
            return false;
        
        }finally {
            cx.desconectar();
        }
    }
    
    
}
