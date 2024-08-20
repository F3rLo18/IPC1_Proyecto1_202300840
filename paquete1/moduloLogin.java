package paquete1;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
public class moduloLogin extends JFrame{
    private JPanel panel;
    private String fuente="Cascadia Code SemiBold";
    public moduloLogin(){
        this.setSize(800,600);
        this.setTitle("Login-IPC Quimik");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        inicializarComponentes();
    }
    private void inicializarComponentes(){
        crearPanel();
        crearEtiquetas();
        crearCajasDeTexto();
    }
    private void crearPanel(){
        panel= new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(130, 215, 147));
        this.getContentPane().add(panel);
    }
    private void crearEtiquetas(){
        JLabel etiquetaIPC= new JLabel("IPC Quimik");
        etiquetaIPC.setBounds(150,100,500,80);
        etiquetaIPC.setFont(new Font(fuente, 0, 80));
        panel.add(etiquetaIPC);

        JLabel etiquetaIcono= new JLabel();
        ImageIcon imagen= new ImageIcon("prueba.png");
        etiquetaIcono.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH)));
        etiquetaIcono.setBounds(570,100,80,80);
        panel.add(etiquetaIcono);
        

        JLabel etiquetaCodigo = new JLabel("Código: ");
        etiquetaCodigo.setBounds(200,250,400,45);
        etiquetaCodigo.setFont(new Font(fuente, 0, 40));
        panel.add(etiquetaCodigo);

        JLabel etiquetaContrasenia = new JLabel("Contraseña: ");
        etiquetaContrasenia.setBounds(125,350,400,45);
        etiquetaContrasenia.setFont(new Font(fuente, 0, 40));
        panel.add(etiquetaContrasenia);
    }
    private void crearCajasDeTexto(){
        JTextField cajaCodigo= new JTextField();
        cajaCodigo.setBounds(350,250,300,50);
        cajaCodigo.setFont(new Font(fuente, 0, 40));
        panel.add(cajaCodigo);
        JPasswordField cajaContrasenia = new JPasswordField();
        cajaContrasenia.setBounds(350,350,300,50);
        cajaContrasenia.setFont(new Font(fuente, 0, 40));
        panel.add(cajaContrasenia);
        JButton botonIniciarSesion= new JButton();
        botonIniciarSesion.setText("Iniciar sesión");
        botonIniciarSesion.setBounds(250,450,300,80);
        botonIniciarSesion.setFont(new Font(fuente, 0, 30));
        listenerBoton(botonIniciarSesion,cajaCodigo,cajaContrasenia);
        panel.add(botonIniciarSesion);
    }

   private void listenerBoton(JButton boton, JTextField cajaCodigo, JPasswordField contrasenia){
    
    ActionListener oyenteBoton= new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        String contra= new String(contrasenia.getPassword());
        if(ListaInvestigadores.comprobarIdentidad(cajaCodigo.getText())){
            JOptionPane.showMessageDialog(null,"El usuario ha sido encontrado en los datos");
            if(ListaInvestigadores.comprobarContrasenia(contra,ListaInvestigadores.obtenerPosicion(cajaCodigo.getText()))){
            JOptionPane.showMessageDialog(null,"Contraseña correcta!!");
            if(ListaInvestigadores.listaInvestigadores.get(ListaInvestigadores.obtenerPosicion(cajaCodigo.getText())).isAdmin()){
                JOptionPane.showMessageDialog(null, "Mostrando panel de administrador: ");
                moduloAdministrador ventanaAdmin = new moduloAdministrador();
                ventanaAdmin.setVisible(true);
                dispose();

            }
        
            }
            else{
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta...");
            }
        }
    }
    };
    boton.addActionListener(oyenteBoton);
   }

}
