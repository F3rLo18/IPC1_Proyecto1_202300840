package paquete1;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class moduloAdministrador extends JFrame{
    private static JPanel panelInvestigadores;

    public moduloAdministrador(){
        this.setSize(1000,800);
        this.setTitle("Administrador IPC-Quimik");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(new Color(40, 144, 89));
        this.setLayout(null);
        iniciarComponentes();
    }
    private void iniciarComponentes(){
        iniciarPanel();

    }
    private void iniciarPanel(){
        panelInvestigadores= new JPanel();
        panelInvestigadores.setLayout(null);
        panelInvestigadores.setBounds(50,50,900,650);
        panelInvestigadores.setBackground(new Color(119, 213, 163));
        this.getContentPane().add(panelInvestigadores);
    }



}
