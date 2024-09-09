package paquete1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.MouseEvent;

public class moduloInvestigador extends JFrame {
    Color fondo= new Color(40, 144, 89);
    Color frente= new Color(119, 213, 163);
    private int panelActivo=0;
    private JPanel panelGeneral;
    private JPanel panelAnalisis;
    private JPanel panelResultados = new JPanel();
    private String usuarioActivo;
    private boolean panelAnalisisActivo=false;
    private boolean panelResultadosActivo=false;


    private JTable tabla;
    private DefaultTableModel modeloTablaAnalisis;
    private DefaultTableModel modelo; //Para la carga de datos
    private String fuente="Cascadia Code SemiBold";
    public void setUsuarioActivo(String usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }

    
    //-------------------------------------Constructor de la clase(inicializador de la ventana)-------------------------------------
    public moduloInvestigador(){
        this.setSize(1300,800);
        this.setTitle("Investigador IPC-Quimik");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
        addWindowListener((new WindowAdapter() {
            
            @Override
            public void windowClosing(WindowEvent e) {
               moduloLogin ventana= new moduloLogin();
                ventana.setVisible(true);
                dispose();
            }
        })); 

        this.getContentPane().setBackground(fondo);
        this.setLayout(null);
        iniciarComponentes();
    }
    private void iniciarComponentes(){
        iniciarPanelGeneral();
        iniciarEtiquetasGenerales();
        iniciarComponentesPanelAnalisis();
    }
    private void iniciarPanelGeneral(){
        panelGeneral= new JPanel();
        panelGeneral.setBackground(fondo);
        panelGeneral.setLayout(null);
        panelGeneral.setBounds(50,50,1200,650);
        this.getContentPane().add(panelGeneral);
    }
    private void iniciarEtiquetasGenerales(){
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        JLabel etiquetaPanelAnalisis= new JLabel("Análisis ");
        etiquetaPanelAnalisis.setBounds(0,10,180,40);
        etiquetaPanelAnalisis.setFont(new Font(fuente, 0, 25));
        etiquetaPanelAnalisis.setOpaque(true);
        etiquetaPanelAnalisis.setBackground(frente);
        etiquetaPanelAnalisis.setBorder(border);
        panelGeneral.add(etiquetaPanelAnalisis);

        JLabel etiquetaPanelResultados= new JLabel("Muestras ");
        etiquetaPanelResultados.setBounds(180,10,120,40);
        etiquetaPanelResultados.setFont(new Font(fuente, 0, 25));
        etiquetaPanelResultados.setBorder(border);
        etiquetaPanelResultados.setOpaque(true);
        panelGeneral.add(etiquetaPanelResultados);

        etiquetaPanelResultados.setBackground(fondo);


        crearListenerPanelAnalisis(etiquetaPanelAnalisis,etiquetaPanelResultados);
        crearListenerPanelResultados(etiquetaPanelAnalisis,etiquetaPanelResultados);
    }
    //----------------------------------Creando los listeners de las etiquetas------------------------------------------
    private void crearListenerPanelAnalisis(JLabel etiqueta,JLabel etiqueta2){
        
        MouseListener oyente= new MouseListener() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                panelAnalisis.setVisible(true);
                panelResultados.setVisible(false);
                panelActivo=0;
                etiqueta2.setBackground(fondo);
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
           //Método inutilizado
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
            //Método inutilizado
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if(panelActivo==0){
                    etiqueta.setFont(new Font(fuente, 1, 25));
                }
                else{
                    etiqueta.setBackground(frente);
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                if(panelActivo==0){
                    etiqueta.setFont(new Font(fuente, 0, 25));
                }
                else{
                    etiqueta.setBackground(fondo);
                }
            }

           
        };
        etiqueta.addMouseListener(oyente);

    }
    private void crearListenerPanelResultados(JLabel etiqueta, JLabel etiqueta2){
        MouseListener oyente= new MouseListener() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                panelAnalisis.setVisible(false);
                panelResultados.setVisible(true);
                panelActivo=1;
                etiqueta.setBackground(fondo);
                if(!panelAnalisisActivo){
                    iniciarComponentesPanelResultados();
                    panelResultadosActivo=true;
                }

            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
            //Método inutilizado
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
            //Método inutilizado
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if(panelActivo==1){
                    etiqueta2.setFont(new Font(fuente, 1, 25));
                }
                else{
                    etiqueta2.setBackground(frente);
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                if(panelActivo==1){
                    etiqueta2.setFont(new Font(fuente, 0, 25));
                }
                else{
                    etiqueta2.setBackground(fondo);
                }
            }
            
            
        };
        etiqueta2.addMouseListener(oyente);
    }
    //----------------------------------------------Iniciando los métodos del panel de Analisis--------------------------------------------
    private void iniciarComponentesPanelAnalisis(){
        iniciarPanelAnalisis();
        iniciarEtiquetasAnalisis();
    }
    private void iniciarPanelAnalisis(){
        panelAnalisis= new JPanel();
        panelAnalisis.setBounds(0,50,1200,600);
        panelAnalisis.setBackground(new Color(119, 213, 163));
        panelAnalisis.setLayout(null);
        panelGeneral.add(panelAnalisis);
    }
    private void iniciarEtiquetasAnalisis(){
        JLabel etiquetaAnalisis= new JLabel("Análisis de experimentos");
        etiquetaAnalisis.setBounds(300,20,700,70);
        etiquetaAnalisis.setFont(new Font(fuente, 0, 60));
        panelAnalisis.add(etiquetaAnalisis);

        JLabel etiquetaMuestra= new JLabel("Muestra");
        etiquetaMuestra.setBounds(150,200,150,40);
        etiquetaMuestra.setFont(new Font(fuente, 0, 35));
        panelAnalisis.add(etiquetaMuestra);

        JLabel etiquetaPatron= new JLabel("Patrón a analizar");
        etiquetaPatron.setBounds(150,300,300,40);
        etiquetaPatron.setFont(new Font(fuente, 0, 35));
        panelAnalisis.add(etiquetaPatron);

    }

    //----------------------------------------------Iniciando los métodos del panel de Resultados-------------------------------------------
    private void iniciarComponentesPanelResultados(){
        iniciarPanelResultados();
        iniciarTablaPanelResultados();
    }
    private void iniciarPanelResultados(){
        panelResultados= new JPanel();
        panelResultados.setBounds(0,50,1200,600);
        panelResultados.setBackground(new Color(119, 213, 163));
        panelResultados.setLayout(null);
        panelGeneral.add(panelResultados);
    }
    private void iniciarTablaPanelResultados(){
        modeloTablaAnalisis= new DefaultTableModel();
        JScrollPane scrollTabla= new JScrollPane();
        String []titulos= {"No","Muestra","Patrón","Fecha","Hora","Resultado"};
        modeloTablaAnalisis.setColumnIdentifiers(titulos);
        tabla= new JTable(modeloTablaAnalisis);
        tabla.setBounds(25,20,700,400);
        scrollTabla.setBounds(25,20,700,400);
        scrollTabla.setViewportView(tabla);
        panelResultados.add(scrollTabla);

        

    }

    
    

    
}
