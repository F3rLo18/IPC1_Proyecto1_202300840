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


public class moduloCrearPatron extends JFrame{
private String fuente = "Cascadia Code SemiBold";
    private JPanel panel;
    private int codigoAutoSet= ListaPatrones.getCantidad();

    public moduloCrearPatron(){
        this.setSize(600,800);
        this.setTitle("Crear Patron");
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
        JLabel etiquetaCrearMuestra= new JLabel("Crear Patrón");
        etiquetaCrearMuestra.setBounds(100,20,450,60);
        etiquetaCrearMuestra.setFont(new Font(fuente, 0, 50));
        panel.add(etiquetaCrearMuestra);

        JLabel etiquetaCodigo = new JLabel("Codigo: ");
        etiquetaCodigo.setBounds(90,150,200,45);
        etiquetaCodigo.setFont(new Font(fuente, 0, 35));
        panel.add(etiquetaCodigo);

        JLabel etiquetaNombre = new JLabel("Nombre: ");
        etiquetaNombre.setBounds(90,250,200,45);
        etiquetaNombre.setFont(new Font(fuente, 0, 35));
        panel.add(etiquetaNombre);

        JLabel etiquetaPatron = new JLabel("Patron: ");
        etiquetaPatron.setBounds(90,350,200,45);
        etiquetaPatron.setFont(new Font(fuente, 0, 35));
        panel.add(etiquetaPatron);
    }
    private void crearCajasDeTexto(){
        JTextField cajaCodigo = new JTextField();
        cajaCodigo.setText("PQ-"+codigoAutoSet);
        cajaCodigo.setEnabled(false);
        cajaCodigo.setBounds(250,150,300,45);
        cajaCodigo.setFont(new Font(fuente, 0, 35));
        panel.add(cajaCodigo);

        JTextField cajaNombre = new JTextField();
        cajaNombre.setBounds(250,250,300,45);
        cajaNombre.setFont(new Font(fuente, 0, 35));
        panel.add(cajaNombre);

        JTextField cajaPatron = new JTextField();
        cajaPatron.setBounds(250,350,300,45);
        cajaPatron.setFont(new Font(fuente, 0, 35));
        panel.add(cajaPatron);


        JButton botonCrear = new JButton();
        botonCrear.setText("Crear Muestra");
        botonCrear.setBounds(150,450,300,80);
        botonCrear.setFont(new Font(fuente, 0, 30));
        panel.add(botonCrear);


        crearListenerBoton(cajaCodigo,cajaNombre, cajaPatron,botonCrear);
    }
    private void crearListenerBoton(JTextField codigo,JTextField nombre,JTextField patron, JButton boton){
        ActionListener oyente= new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(codigo.getText().equals("")||nombre.getText().equals("")||patron.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Porfavor llene los campos");
                }
                else{
                    ListaPatrones.agregarPatron(codigo.getText(), nombre.getText(), patron.getText());
                    JOptionPane.showMessageDialog(null, "Patron creado con éxito");

                }
            }

        };
        boton.addActionListener(oyente);
    }
    

}
