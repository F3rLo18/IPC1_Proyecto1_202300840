package paquete1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class moduloCrearMuestra extends JFrame {
private String fuente = "Cascadia Code SemiBold";
    private JPanel panel;
    private int codigoAutoSet= ListaMuestras.getCantidad();

    public moduloCrearMuestra(){
        this.setSize(600,800);
        this.setTitle("Crear Investigador");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        iniciarComponentes();
    }
    private void iniciarComponentes(){
        crearPanel();
        crearEtiquetas();
        crearCajasDeTexto();
    }
    private void crearPanel(){
        panel= new JPanel();
        panel.setSize(600,800);
        panel.setBackground(new Color(130, 215, 147));
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    private void crearEtiquetas(){
        JLabel etiquetaCrearMuestra= new JLabel("Crear muestra");
        etiquetaCrearMuestra.setBounds(100,20,450,60);
        etiquetaCrearMuestra.setFont(new Font(fuente, 0, 50));
        panel.add(etiquetaCrearMuestra);

        JLabel etiquetaCodigo = new JLabel("Codigo: ");
        etiquetaCodigo.setBounds(90,150,200,45);
        etiquetaCodigo.setFont(new Font(fuente, 0, 35));
        panel.add(etiquetaCodigo);

        JLabel etiquetaDescripcion = new JLabel("Descripcion: ");
        etiquetaDescripcion.setBounds(20,250,200,45);
        etiquetaDescripcion.setFont(new Font(fuente, 0, 35));
        panel.add(etiquetaDescripcion);
        
        JLabel etiquetaPatron = new JLabel("Patrón: ");
        etiquetaPatron.setBounds(85,350,200,45);
        etiquetaPatron.setFont(new Font(fuente, 0, 35));
        panel.add(etiquetaPatron);
    }
    private void crearCajasDeTexto(){
         JTextField cajaCodigo = new JTextField();
        cajaCodigo.setText("MQ-"+codigoAutoSet);
        cajaCodigo.setEnabled(false);
        cajaCodigo.setBounds(250,150,300,45);
        cajaCodigo.setFont(new Font(fuente, 0, 35));
        panel.add(cajaCodigo);

        JTextField cajaNombre = new JTextField();
        cajaNombre.setBounds(250,250,300,45);
        cajaNombre.setFont(new Font(fuente, 0, 35));
        panel.add(cajaNombre);
        JComboBox cajaPatron = new JComboBox<>();

        if(ListaPatrones.getCantidad()==0){
        cajaPatron.setBounds(250,350,300,45);
        cajaPatron.setFont(new Font(fuente, 0, 35));
        panel.add(cajaPatron);
        }
        else{
        DefaultComboBoxModel<String> modellll= new DefaultComboBoxModel<>(ListaPatrones.toStringTodosPatrones());
        cajaPatron.setModel(modellll);
        cajaPatron.setBounds(250,350,300,45);
        cajaPatron.setFont(new Font(fuente, 0, 35));
        panel.add(cajaPatron);
        }
        JButton botonCrear = new JButton();
        botonCrear.setText("Crear Muestra");
        botonCrear.setBounds(150,450,300,80);
        botonCrear.setFont(new Font(fuente, 0, 30));
        panel.add(botonCrear);

        crearListenerCrear(cajaCodigo,cajaNombre,cajaPatron,botonCrear);
    }
    private void crearListenerCrear(JTextField codigo,JTextField descripcion,JComboBox patron, JButton boton){
        ActionListener oyente= new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            ListaMuestras.agregarmuestra(codigo.getText(), descripcion.getText(), "Ingreso", (String) patron.getSelectedItem() );
            JOptionPane.showMessageDialog(null,"Muestra creada con éxito");
            codigoAutoSet++;
            codigo.setText("MQ-"+ codigoAutoSet);
            }
            
        };
        boton.addActionListener(oyente);
    }


}
