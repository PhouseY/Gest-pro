//Comentario de prueba
//Segundoc comentario de prueba
//Prueba de la prueba
//Genial
//Util
//
package Modelo;

/**
 *
 * @author Usuario
 */
public class Usuario {
    
    private String cedula;
    private String nombre;
    private String usuario;
    private String password;
    private int estado;

    public Usuario() {
        this.cedula = "";
        this.nombre = "";
        this.estado = 0;
        this.password = "";
        this.usuario = "";
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
    
}
