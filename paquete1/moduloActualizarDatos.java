package paquete1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class moduloActualizarDatos extends JFrame {
    private JPanel panel;   
    private String fuente = "Cascadia Code SemiBold";
    public moduloActualizarDatos(){
        this.setSize(600,800);
        this.setTitle("Actualizar datos de investigador");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        iniciarComponentes();
    }
    private void iniciarComponentes(){
        iniciarPanel();
        iniciarEtiquetas();
        iniciarCajasDeTexto();
    }
    private void iniciarPanel(){
        panel= new JPanel();
        panel.setSize(600,800);
        panel.setBackground(new Color(130, 215, 147));
        panel.setLayout(null);
        this.getContentPane().add(panel);

    }
    private void iniciarEtiquetas(){
        JLabel etiquetaEditar= new JLabel("Editar investigador");
        etiquetaEditar.setBounds(85,20,450,60);
        etiquetaEditar.setFont(new Font(fuente, 0, 50));
        panel.add(etiquetaEditar);
        JLabel etiquetaCodigo= new JLabel("Código:");
        etiquetaCodigo.setBounds(90,150,350,40);
        etiquetaCodigo.setFont(new Font(fuente, 0, 30));
        panel.add(etiquetaCodigo);
        JLabel etiquetaNombre= new JLabel("Nombre:");
        etiquetaNombre.setBounds(80,250,350,40);
        etiquetaNombre.setFont(new Font(fuente, 0, 30));
        panel.add(etiquetaNombre);
        JLabel etiquetaGenero= new JLabel("Género:");
        etiquetaGenero.setBounds(85,350,350,40);
        etiquetaGenero.setFont(new Font(fuente, 0, 30));
        panel.add(etiquetaGenero);
        JLabel etiquetaContra= new JLabel("Contraseña: ");
        etiquetaContra.setBounds(30,450,350,40);
        etiquetaContra.setFont(new Font(fuente, 0, 30));
        panel.add(etiquetaContra);
        
    }
    
    private void iniciarCajasDeTexto(){
    JTextField cajaCodigo = new JTextField();
        cajaCodigo.setBounds(250,150,120,45);
        cajaCodigo.setFont(new Font(fuente, 0, 35));
        panel.add(cajaCodigo);

        JTextField cajaNombre = new JTextField();
        cajaNombre.setEnabled(false);
        cajaNombre.setBounds(250,250,300,45);
        cajaNombre.setFont(new Font(fuente, 0, 35));
        panel.add(cajaNombre);
        
        @SuppressWarnings("rawtypes")
        JComboBox cajaGenero = new JComboBox<>();
        cajaGenero.addItem("Hombre");
        cajaGenero.addItem("Mujer");
        cajaGenero.setEnabled(false);
        cajaGenero.setBounds(250,350,300,45);
        cajaGenero.setFont(new Font(fuente, 0, 35));
        panel.add(cajaGenero);
        
        JTextField cajaContra = new JTextField();
        cajaContra.setEnabled(false);
        cajaContra.setBounds(250,450,300,45);
        cajaContra.setFont(new Font(fuente, 0, 35));
        panel.add(cajaContra);

        JButton botonBuscar= new JButton();
        botonBuscar.setText("Buscar");
        botonBuscar.setBounds(400,150,120,40);
        botonBuscar.setFont(new Font(fuente, 0, 15));
        panel.add(botonBuscar);

        JButton botonActualizar = new JButton();
        botonActualizar.setText("Actualizar");
        botonActualizar.setBounds(150,550,300,80);
        botonActualizar.setFont(new Font(fuente, 0, 30));
        botonActualizar.setEnabled(false);
        panel.add(botonActualizar);

        crearListenerBuscar(botonBuscar,cajaCodigo,cajaNombre,cajaGenero,cajaContra,botonActualizar);
        crearListenerActualizar(botonActualizar, cajaCodigo, cajaNombre, cajaGenero, cajaContra,botonBuscar);
    }
    private void crearListenerBuscar(JButton boton,JTextField cajaCodigo,JTextField cajaNombre,JComboBox cajaGenero,JTextField cajaContra,JButton botonActualizar){
        ActionListener oyenteBuscar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            if(cajaCodigo.getText().equals("admin")){
                JOptionPane.showMessageDialog(null, "Los datos del administrador no pueden ser actualizados...");
            }
            else if(ListaInvestigadores.comprobarIdentidad(cajaCodigo.getText())){
            cajaNombre.setEnabled(true);
            cajaGenero.setEnabled(true);
            cajaContra.setEnabled(true);
            botonActualizar.setEnabled(true);
            cajaCodigo.setEnabled(false);
            cajaNombre.setText(ListaInvestigadores.listaInvestigadores.get(ListaInvestigadores.obtenerPosicion(cajaCodigo.getText())).getNombre());
            if(ListaInvestigadores.listaInvestigadores.get(ListaInvestigadores.obtenerPosicion(cajaCodigo.getText())).getGenero().equals("Hombre")){
                cajaGenero.setSelectedIndex(0);
            }else{
                cajaGenero.setSelectedIndex(1);
            }
            cajaContra.setText(ListaInvestigadores.listaInvestigadores.get(ListaInvestigadores.obtenerPosicion(cajaCodigo.getText())).getContrasenia());
            JOptionPane.showMessageDialog(null,"Mostrando datos del usuario: ");
            boton.setEnabled(false);
        }
            else{
            cajaNombre.setEnabled(false);
            cajaGenero.setEnabled(false);
            cajaContra.setEnabled(false);
            botonActualizar.setEnabled(false);
            JOptionPane.showMessageDialog(null,"No se ha encontrado el usuario ingresado...");
            }
            }
            
        };
        boton.addActionListener(oyenteBuscar);
    }
    private void crearListenerActualizar(JButton boton,JTextField cajaCodigo , JTextField cajaNombre,JComboBox cajaGenero,JTextField cajaContra,JButton botonBuscar){
        ActionListener oyente= new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            if(cajaNombre.getText().equals("")||cajaContra.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Porfavor llene los campos...");
                cajaNombre.setBackground(new Color(239, 170, 170));
                cajaContra.setBackground(new Color(239, 170, 170));
            }
            else{
                ListaInvestigadores.listaInvestigadores.get(ListaInvestigadores.obtenerPosicion(cajaCodigo.getText())).setNombre(cajaNombre.getText());
                ListaInvestigadores.listaInvestigadores.get(ListaInvestigadores.obtenerPosicion(cajaCodigo.getText())).setContrasenia(cajaContra.getText());
                if(cajaGenero.getSelectedIndex()==0){
                    ListaInvestigadores.listaInvestigadores.get(ListaInvestigadores.obtenerPosicion(cajaCodigo.getText())).setGenero("Hombre");
                }
                else{
                    ListaInvestigadores.listaInvestigadores.get(ListaInvestigadores.obtenerPosicion(cajaCodigo.getText())).setGenero("Mujer");
                
                }
                JOptionPane.showMessageDialog(null, "Los datos del investigador han sido actualizados!");
                ListaInvestigadores.regenerarCSV();
                cajaNombre.setEnabled(false);
                cajaGenero.setEnabled(false);
                cajaContra.setEnabled(false);
                botonBuscar.setEnabled(true);
                boton.setEnabled(false);
                cajaCodigo.setEnabled(true);
                cajaNombre.setBackground(Color.white);
                cajaContra.setBackground(Color.white);
                cajaNombre.setText("");
                cajaContra.setText("");


            }
            
            }
            
        };
        boton.addActionListener(oyente);
    }

}
