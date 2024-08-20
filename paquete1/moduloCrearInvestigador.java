package paquete1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

public class moduloCrearInvestigador extends JFrame{
    private String fuente = "Cascadia Code SemiBold";
    private JPanel panel;

    private int codigoAutoSet= ListaInvestigadores.getCantidad();
    public moduloCrearInvestigador(){

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
        JLabel etiquetaCrearInvestigador= new JLabel("Crear investigador");
        etiquetaCrearInvestigador.setBounds(85,20,450,60);
        etiquetaCrearInvestigador.setFont(new Font(fuente, 0, 50));
        panel.add(etiquetaCrearInvestigador);

        JLabel etiquetaCodigo = new JLabel("Codigo: ");
        etiquetaCodigo.setBounds(90,150,200,45);
        etiquetaCodigo.setFont(new Font(fuente, 0, 35));
        panel.add(etiquetaCodigo);

        JLabel etiquetaNombre = new JLabel("Nombre: ");
        etiquetaNombre.setBounds(80,250,200,45);
        etiquetaNombre.setFont(new Font(fuente, 0, 35));
        panel.add(etiquetaNombre);
        
        JLabel etiquetaGenero = new JLabel("Género: ");
        etiquetaGenero.setBounds(85,350,200,45);
        etiquetaGenero.setFont(new Font(fuente, 0, 35));
        panel.add(etiquetaGenero);

        JLabel etiquetacontrasenia = new JLabel("Contraseña: ");
        etiquetacontrasenia.setBounds(30,450,200,45);
        etiquetacontrasenia.setFont(new Font(fuente, 0, 35));
        panel.add(etiquetacontrasenia);
    }
    @SuppressWarnings("unchecked")
    private void crearCajasDeTexto(){
        JTextField cajaCodigo = new JTextField();
        cajaCodigo.setText("QI-"+String.valueOf(codigoAutoSet));
        cajaCodigo.setEnabled(false);
        cajaCodigo.setBounds(250,150,300,45);
        cajaCodigo.setFont(new Font(fuente, 0, 35));
        panel.add(cajaCodigo);

        JTextField cajaNombre = new JTextField();
        cajaNombre.setBounds(250,250,300,45);
        cajaNombre.setFont(new Font(fuente, 0, 35));
        panel.add(cajaNombre);
        
        @SuppressWarnings("rawtypes")
        JComboBox cajaGenero = new JComboBox<>();
        cajaGenero.addItem("Hombre");
        cajaGenero.addItem("Mujer");
        cajaGenero.setBounds(250,350,300,45);
        cajaGenero.setFont(new Font(fuente, 0, 35));
        panel.add(cajaGenero);
        
        JPasswordField cajaContra = new JPasswordField();
        cajaContra.setBounds(250,450,300,45);
        cajaContra.setFont(new Font(fuente, 0, 35));
        panel.add(cajaContra);
        
        JButton botonCrear = new JButton();
        botonCrear.setText("Crear investigador");
        botonCrear.setBounds(150,550,300,80);
        botonCrear.setFont(new Font(fuente, 0, 30));
        panel.add(botonCrear);
        listenerBoton(cajaCodigo, cajaNombre, cajaGenero, cajaContra, botonCrear);
    }

    private void listenerBoton(JTextField codigo, JTextField nombre, JComboBox genero, JPasswordField contrasenia, JButton boton){
        ActionListener listenerBotonCrear = new ActionListener() {
            String generoTxt; 
            @Override
            public void actionPerformed(ActionEvent e) {
            
            
        if(codigo.getText().equals("") || nombre.getText().equals("") || contrasenia.getPassword().equals("")){
            JOptionPane.showMessageDialog(null, "Porfavor llene los campos");
            nombre.setBackground(new Color(239, 170, 170));
            contrasenia.setBackground(new Color(239, 170, 170));
        }
        else{
            if(genero.getSelectedIndex()==1){generoTxt = "Mujer";}else{ generoTxt= "Hombre" ;}
            String contra= new String (contrasenia.getPassword());
            ListaInvestigadores.agregarInvestigador(codigo.getText(), nombre.getText(), generoTxt, contra);
            JOptionPane.showMessageDialog(null, "Investigador creado correctamente!!");
            codigoAutoSet++;
            codigo.setText("QI-"+ String.valueOf(codigoAutoSet));
        }
            
        
        }
            
        };
        boton.addActionListener(listenerBotonCrear);
    }

}


