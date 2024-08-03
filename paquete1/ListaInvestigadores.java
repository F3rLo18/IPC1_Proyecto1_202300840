package paquete1;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class ListaInvestigadores {
    //Creando el arrayList Y el archivo CSV para los investigadores 
    public static ArrayList <Investigador> listaInvestigadores = new ArrayList<Investigador>();
    private static File f = new File("C:\\Users\\josue\\Desktop\\Proyecto1-IPC1-Quimik/investigadores.csv");
    
    public static void crearAdmin(){
        Investigador admin = new Investigador("admin", "Fernando", "Masculino","admin",true);
        listaInvestigadores.add(admin);
    }
    //Método para añadir los datos 
    public static void agregarInvestigador(String codigo, String Nombre, String Genero, String contrasenia){
    Investigador p= new Investigador(codigo, Nombre, Genero, contrasenia,false);
    try(FileWriter fw = new FileWriter(f)){
        for (Investigador investigador : listaInvestigadores) {
            fw.write(investigador.toCSV()+"\n");
        }
    }catch(Exception e){
    }
    }
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
    public static boolean comprobarContrasenia(String contra,int pos){
        boolean correcto=false;
        if(listaInvestigadores.get(pos).getContrasenia().equals(contra)){
            correcto=true;
        }

    return correcto;
    }
    public static int obtenerPosicion(String codigo){
        int i=0;
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





}
