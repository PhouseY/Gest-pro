
package principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    String bd = "bd_gestpro";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "Administrador";
    String password = "MCS/M9[QxqGK)Q@7";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;
    
    public Conexion(String bd){
        this.bd=bd;
    }
    public Connection conectar(){
        try{
            Class.forName(driver);
            cx = DriverManager.getConnection(url+bd,user,password);
            System.out.println("SE CONECTO A BD "+ bd);
        } catch(ClassNotFoundException |SQLException ex) {
            System.out.println("NO SE CONECTO A BD "+bd);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;
    }
    
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args){
        Conexion conexion = new Conexion("bd_gestpro");
        conexion.conectar();
    }
    
}
