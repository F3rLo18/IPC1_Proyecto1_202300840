package paquete1;

public class Patron {
    private String codigo;
    private String nombre;
    private String patron;
    public Patron(String codigo, String nombre, String patron) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.patron = patron;
    }
    //-------------------Método para obtener la información del investigador en formato CSV------------------------
    public String toCSV(){
        return this.codigo+","+this.nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    

}
