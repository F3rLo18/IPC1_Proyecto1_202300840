package paquete1;
import java.io.File;

public class Muestras {
private String codigo;
private String descripcion;
private String estado;
private String patron;
private boolean asignado;

public Muestras(String codigo, String descripcion,String estado, String patron) {
    this.codigo = codigo;
    this.descripcion = descripcion;
    this.estado= estado;
    this.patron = patron;
    asignado=false;
}
//-------------------Método para obtener la información del investigador en formato CSV------------------------
public String toCSV(){
    return this.codigo+","+this.descripcion+","+this.estado;
}


}
