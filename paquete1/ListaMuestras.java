package paquete1;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javax.swing.JOptionPane;

public class ListaMuestras {
    private static int cantidadMuestras=0;
    public static ArrayList <Muestras> listaMuestras = new ArrayList<>(); 
    private static File f = new File("C:\\Users\\josue\\Desktop\\Proyecto1-IPC1-Quimik/muestras.csv");
//------------------------------------Método para agregar muestras a la base de datos--------------------------------
    public static void agregarmuestra(String codigo, String descripcion,String estado, String patron){
        Muestras m= new Muestras(codigo, descripcion,estado, patron);
        listaMuestras.add(m);
        try(FileWriter fw = new FileWriter(f)){
            for (Muestras muestras : listaMuestras) {
                fw.write(muestras.toCSV()+"\n");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al escribir en CSV");
        }
        cantidadMuestras++;
        }


//--------Método para regenerar el archivo CSV con datos actualizados, eliminaciones, cambios...etc-----
public static void regenerarCSVMuestras(){
    try (FileWriter fw = new FileWriter("C:\\\\Users\\\\josue\\\\Desktop\\\\Proyecto1-IPC1-Quimik/muestras.csv")){
    //Sobre-escribiendo el archivo para vaciarlo
    }catch (IOException e) {e.printStackTrace();}
    try(FileWriter fw = new FileWriter(f)){
        for(Muestras muestra : listaMuestras) {
            fw.write(muestra.toCSV()+"\n");
        }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error al escribir en CSV");
    }
}
 //----------------------Método para obtener el contador de operaciones de registro------------------------
 public static int getCantidad() {
    return cantidadMuestras;
}
}
