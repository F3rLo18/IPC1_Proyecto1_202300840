package paquete1;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class moduloAdminEliminar extends JFrame{
    JPanel panel;
    public moduloAdminEliminar(){
        this.setSize(600,500);
        this.setTitle("Eliminar investigador");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        inicializarComponentes();
    }
    private void inicializarComponentes(){
        iniciarPanel();

    }
    private void iniciarPanel(){
        panel= new JPanel();
        panel.setSize(600,500);
        panel.setBackground(new Color(130, 215, 147));
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }



}
