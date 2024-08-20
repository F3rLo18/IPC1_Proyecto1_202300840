package paquete1;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javax.swing.JOptionPane;

public class ListaInvestigadores {
    //---------------------------------------Variales globales----------------------------------------------
    private static int cantidad=0;
    public static ArrayList <Investigador> listaInvestigadores = new ArrayList<>(); 
    private static File f = new File("C:\\Users\\josue\\Desktop\\Proyecto1-IPC1-Quimik/investigadores.csv");
    //---------------------------------Método para crear Administrador--------------------------------------
    public static void crearAdmin(){
        Investigador admin = new Investigador("admin", "Fernando", "Hombre","admin",true);
        listaInvestigadores.add(admin);
    }
    //--------------------------------Método para crear Investigadores--------------------------------------- 
    //(Todos los investigadores se crear con el parámetro "isAdmin" establecido en false)
    public static void agregarInvestigador(String codigo, String nombre, String genero, String contrasenia){
    Investigador p= new Investigador(codigo, nombre, genero, contrasenia,false);
    listaInvestigadores.add(p);
    try(FileWriter fw = new FileWriter(f)){
        for (Investigador investigador : listaInvestigadores) {
            fw.write(investigador.toCSV()+"\n");
        }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error al escribir en CSV");
    }
    cantidad++;
    }
    //---------------------------Método para verificar la existencia de un usuario--------------------------
    public static boolean comprobarIdentidad(String codigo){
        boolean correcto=false;
        for (Investigador inv : listaInvestigadores) {
            if(inv.getCodigo().equals(codigo)){
               correcto=true;
               break;
            }
        }
        return correcto;
    }
    //---------------------------------Método para comprobar la contraseña----------------------
    public static boolean comprobarContrasenia(String contra,int pos){
        boolean correcto=false;
        if(listaInvestigadores.get(pos).getContrasenia().equals(contra)){
            correcto=true;
        }
    return correcto;
    }
    //--------Método para regenerar el archivo CSV con datos actualizados, eliminaciones, cambios...etc-----
    public static void regenerarCSV(){
        try (FileWriter fw = new FileWriter("C:\\\\Users\\\\josue\\\\Desktop\\\\Proyecto1-IPC1-Quimik/investigadores.csv")){
        //Sobre-escribiendo el archivo para vaciarlo
        }catch (IOException e) {e.printStackTrace();}
        try(FileWriter fw = new FileWriter(f)){
            for(Investigador investigador : listaInvestigadores) {
                fw.write(investigador.toCSV()+"\n");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al escribir en CSV");
        }
    }
    //-----------------Método para obtener la posición de un investigador, sabiendo su código------------------
    public static int obtenerPosicion(String codigo){
        int i=0;  //Si el investigador no existe, la función regresa -1
        int pos=-1;
        for (Investigador inv : listaInvestigadores) {
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
    
    
    
    
   
    




}
