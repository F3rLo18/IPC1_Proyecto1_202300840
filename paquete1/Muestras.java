package paquete1;
import java.io.File;

public class Muestras {
private String codigo;
private String descripcion;
private String estado;
private String patron;
private boolean asignado;
private int indiceInvesAsignado;

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
public String getCodigo() {
    return codigo;
}
public String getDescripcion() {
    return descripcion;
}
public String getEstado() {
    return estado;
}
public String getPatron() {
    return patron;
}
public boolean isAsignado() {
    return asignado;
}
public int getIndiceInvesAsignado() {
    return indiceInvesAsignado;
}
public void setEstado(String estado) {
    this.estado = estado;
}
public void setAsignado(boolean asignado) {
    this.asignado = asignado;
}
public void setIndiceInvesAsignado(int indiceInvesAsignado) {
    this.indiceInvesAsignado = indiceInvesAsignado;
}



}
