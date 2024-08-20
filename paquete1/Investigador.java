package paquete1;

public class Investigador {
    private String codigo;
    private String nombre;
    private String genero;
    private String contrasenia;
    private boolean isAdmin;
    private String experimentos = " 0 ";

    //------------------------------------------Constructor de la clase------------------------------------------
    public Investigador(String codigo, String nombre, String genero, String contrasenia, boolean isAdmin) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.genero = genero;
        this.isAdmin= isAdmin;
        this.contrasenia = contrasenia;
    }
    //-------------------Método para obtener la información del investigador en formato CSV------------------------
    public String toCSV(){
        return this.codigo+","+this.nombre+","+this.genero+","+this.experimentos;
    }
    //--------------------------------------------Métodos getter----------------------------------------------------
    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public String getGenero() {
        return genero;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public boolean isAdmin() {
        return isAdmin;
    }
    //--------------------------------------------Métodos setter---------------------------------------------------
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    
}
