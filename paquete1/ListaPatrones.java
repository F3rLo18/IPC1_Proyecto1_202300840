package paquete1;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ListaPatrones {
    private static int cantidad=0;
    public static ArrayList <Patron> listaPatrones = new ArrayList<>(); 
    private static File f = new File("C:\\Users\\josue\\Desktop\\Proyecto1-IPC1-Quimik/patrones.csv");

     //--------------------------------Método para crear Patron, recibe la matriz ya creada--------------------------------------- 
    public static void agregarPatron(String codigo, String nombre, String patron){
    Patron p= new Patron(codigo, nombre,patron);

    listaPatrones.add(p);
    try(FileWriter fw = new FileWriter(f)){
        for (Patron patronnn : listaPatrones) {
            fw.write(patronnn.toCSV()+"\n");
        }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error al escribir en CSV");
    }
    cantidad++;
    }
 //--------Método para regenerar el archivo CSV con datos actualizados, eliminaciones, cambios...etc-----
    public static void regenerarCSV(){
        try (FileWriter fw = new FileWriter("C:\\\\Users\\\\josue\\\\Desktop\\\\Proyecto1-IPC1-Quimik/patrones.csv")){
        //Sobre-escribiendo el archivo para vaciarlo
        }catch (IOException e) {e.printStackTrace();}
        try(FileWriter fw = new FileWriter(f)){
            for(Patron patron : listaPatrones) {
                fw.write(patron.toCSV()+"\n");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al escribir en CSV");
        }
    }
    public static boolean comprobarExistencia(String codigo){
        boolean correcto=false;
        for (Patron inv : listaPatrones) {
            if(inv.getCodigo().equals(codigo)){
               correcto=true;
               break;
            }
        }
        return correcto;
    }

//-----------------Método para obtener la posición de un investigador, sabiendo su código------------------
    public static int obtenerPosicion(String codigo){
        int i=0;  //Si el investigador no existe, la función regresa -1
        int pos=-1;
        for (Patron inv : listaPatrones) {
            if(inv.getCodigo().equals(codigo)){
            pos=i;
            break;
            }
            i++;
        }
    return pos;
    }
    //----------------------Método para obtener el contador de operaciones de registro------------------------
    public static int getCantidad() {
        return cantidad;
    }
    //---------------------------Método para obtener todos los patrones en un arreglo de Strings-----------------
    public static String[] toStringTodosPatrones(){
        String[] codigos= new String[listaPatrones.size()];
        int i=0;
        for(Patron pat: listaPatrones){
            codigos[i]= pat.getCodigo();
            i++;
        }
        return codigos;
    }


    }
