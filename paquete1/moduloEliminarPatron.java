package paquete1;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class moduloEliminarPatron extends JFrame{
//-------------------------------------Creación de variables globales------------------------------------
    JPanel panel;
    private String fuente = "Cascadia Code SemiBold";
    //----------------------------------------Constructor de la clase----------------------------------------
    public moduloEliminarPatron(){
        this.setSize(600,400);
        this.setTitle("Eliminar Patron");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        inicializarComponentes();
    }
    //-----------------------------------Métodos de inicialización de componentes----------------------------
    private void inicializarComponentes(){
        iniciarPanel();
        iniciarEtiquetas();
        iniciarCajas();
    }
    private void iniciarPanel(){
        panel= new JPanel();
        panel.setSize(600,400);
        panel.setBackground(new Color(130, 215, 147));
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    private void iniciarEtiquetas(){
        JLabel etiquetaEditar= new JLabel("Eliminar Patron");
        etiquetaEditar.setBounds(60,20,550,60);
        etiquetaEditar.setFont(new Font(fuente, 0, 50));
        panel.add(etiquetaEditar);
        JLabel etiquetaCodigo= new JLabel("Código:");
        etiquetaCodigo.setBounds(90,150,350,40);
        etiquetaCodigo.setFont(new Font(fuente, 0, 30));
        panel.add(etiquetaCodigo);
    }
    //--------------------------------------Métodos con entradas y acciones---------------------------------
    private void iniciarCajas(){
        JTextField cajaCodigo= new JTextField();
        cajaCodigo.setBounds(200,150,250,45);
        cajaCodigo.setFont(new Font(fuente, 0, 35));
        panel.add(cajaCodigo);
        JButton botonEliminar= new JButton();
        botonEliminar.setText("Eliminar");
        botonEliminar.setBounds(180,250,250,75);
        botonEliminar.setFont(new Font(fuente, 0, 25));
        panel.add(botonEliminar);
        crearListenerEliminar(botonEliminar,cajaCodigo);
    }
    //---------------------------Método para añadir listener de eliminación--------------------------------
    private void crearListenerEliminar(JButton boton, JTextField cajaCodigo){
        ActionListener oyente = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            if(ListaPatrones.comprobarExistencia(cajaCodigo.getText())){
            ListaPatrones.listaPatrones.remove(ListaPatrones.listaPatrones.get(ListaPatrones.obtenerPosicion(cajaCodigo.getText())));
            ListaPatrones.regenerarCSV();
            JOptionPane.showMessageDialog(null, "El patron ha sido borrado con éxito");
            }
            else{
                JOptionPane.showMessageDialog(null, "No existe el patron con el codigo ingresado...");
            }   
            }
            
        };
        boton.addActionListener(oyente);
    }

}
