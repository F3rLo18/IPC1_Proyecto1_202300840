package paquete1;

import java.util.ArrayList;

public class Investigador {
    private String codigo;
    private String nombre;
    private String genero;
    private String contrasenia;
    private boolean isAdmin;
    private int experimentos=0;
    public static ArrayList <Muestras> arrayMuestras = new ArrayList<>(); 

    //------------------------------------------Constructor de la clase------------------------------------------
    public Investigador(String codigo, String nombre, String genero, String contrasenia, boolean isAdmin) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.genero = genero;
        this.isAdmin= isAdmin;
        this.contrasenia = contrasenia;
    }
    //--------------------Método para asignarle una muestra al investigador----------------------------------
    public void agregarMuestraInvestigador(Muestras muestra){
        arrayMuestras.add(muestra);
        experimentos++;
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
    public int getExpos(){
        return this.experimentos;
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
    public int getExperimentos() {
        return experimentos;
    }
    public ArrayList<Muestras> getArrayMuestras() {
        return arrayMuestras;
    }

    
}
