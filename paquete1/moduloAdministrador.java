package paquete1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class moduloAdministrador extends JFrame{
    private String fuente="Cascadia Code SemiBold";
    private static JPanel panelGeneral;
    private static JPanel panelInvestigadores;
    private JPanel panelMuestras;
    private JPanel panelAsignacionExpos;
    private JPanel panelPatrones;
    private JTable tabla;
    DefaultTableModel modeloTabla;
    private DefaultTableModel modelo;
        
//Constructor de la clase(inicializador de la ventana)
    public moduloAdministrador(){
        this.setSize(1300,800);
        this.setTitle("Administrador IPC-Quimik");
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

        
        this.getContentPane().setBackground(new Color(40, 144, 89));
        this.setLayout(null);
        iniciarComponentes();
    }
//-----------------------Iniciando los componenetes del panel general----------------------------------
    private void iniciarComponentes(){
        iniciarPanelGeneral();
        iniciarEtiquetasGenerales();
        iniciarComponentesPanelInvestigadores();
    }
    private void iniciarPanelGeneral(){
        panelGeneral= new JPanel();
        panelGeneral.setBackground(new Color(40, 144, 89));
        panelGeneral.setLayout(null);
        panelGeneral.setBounds(50,50,1200,650);
        
        this.getContentPane().add(panelGeneral);
    }
    private void iniciarEtiquetasGenerales(){
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        JLabel etiquetaPanelInvestigadores= new JLabel("Investigadores ");
        etiquetaPanelInvestigadores.setBounds(0,10,180,40);
        etiquetaPanelInvestigadores.setFont(new Font(fuente, 0, 25));
        etiquetaPanelInvestigadores.setOpaque(true);
        etiquetaPanelInvestigadores.setBackground(new Color(119, 213, 163));
        etiquetaPanelInvestigadores.setBorder(border);
        panelGeneral.add(etiquetaPanelInvestigadores);

        JLabel etiquetaPanelMuestras= new JLabel("Muestras ");
        etiquetaPanelMuestras.setBounds(180,10,120,40);
        etiquetaPanelMuestras.setFont(new Font(fuente, 0, 25));
        etiquetaPanelMuestras.setBorder(border);
        panelGeneral.add(etiquetaPanelMuestras);

        JLabel etiquetaPanelAsignacionExps= new JLabel("Asignación de experimentos ");
        etiquetaPanelAsignacionExps.setBounds(300 ,10,330,40);
        etiquetaPanelAsignacionExps.setFont(new Font(fuente, 0, 25));
        etiquetaPanelAsignacionExps.setBorder(border);
        panelGeneral.add(etiquetaPanelAsignacionExps);
        
        JLabel etiquetaPanelPatrones= new JLabel("Patrones ");
        etiquetaPanelPatrones.setBounds(630,10,150,40);
        etiquetaPanelPatrones.setFont(new Font(fuente, 0, 25));
        etiquetaPanelPatrones.setBorder(border);
        panelGeneral.add(etiquetaPanelPatrones);
    }
//-------------------------Iniciando los componentes del panel de Investigadores------------------------
    private void iniciarComponentesPanelInvestigadores(){
        iniciarPanelInvestigadores();
        iniciarTablaPanelInvestigadores();
        iniciarBotonesPanelInvestigadores();
    }
    private void iniciarPanelInvestigadores(){
        panelInvestigadores= new JPanel();
        panelInvestigadores.setBounds(0,50,1200,600);
        panelInvestigadores.setBackground(new Color(119, 213, 163));
        panelInvestigadores.setLayout(null);
        panelGeneral.add(panelInvestigadores);
    }
    private void iniciarTablaPanelInvestigadores(){
        modeloTabla= new DefaultTableModel();
        JScrollPane scrollTabla= new JScrollPane();
        String []titulos= {"Código","Nombre","Género","Experimentos"};
        modeloTabla.setColumnIdentifiers(titulos);

        tabla= new JTable(modeloTabla);
        tabla.setBounds(25,20,700,400);
        scrollTabla.setBounds(25,20,700,400);

        scrollTabla.setViewportView(tabla);

        panelInvestigadores.add(scrollTabla);
    }
    private void iniciarBotonesPanelInvestigadores(){
        JButton botonCrear= new JButton();
        botonCrear.setBounds(750,30,200,80);
        botonCrear.setText("Crear");
        botonCrear.setFont(new Font(fuente, 0, 25));
        panelInvestigadores.add(botonCrear);

        JButton botonCargar= new JButton();
        botonCargar.setBounds(980,30,200,80);
        botonCargar.setText("Cargar");
        botonCargar.setFont(new Font(fuente, 0, 25));
        panelInvestigadores.add(botonCargar);
        
        JButton botonActualizar= new JButton();
        botonActualizar.setBounds(750,150,200,80);
        botonActualizar.setText("Actualizar");
        botonActualizar.setFont(new Font(fuente, 0, 25));
        panelInvestigadores.add(botonActualizar);
        
        JButton botonEliminar= new JButton();
        botonEliminar.setBounds(980,150,200,80);
        botonEliminar.setText("Eliminar");
        botonEliminar.setFont(new Font(fuente, 0, 25));
        panelInvestigadores.add(botonEliminar);
        
        crearListenerCrear(botonCrear);
        crearListenerCargar(botonCargar);
        crearListenerActualizar(botonActualizar);
        crearListenerEliminar(botonEliminar);
    }
    //------------------------------------Acciones de botón del panel "Investigadores"--------------------------------
    private void crearListenerCrear(JButton botonCrear){
        ActionListener oyenteBoton= new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               moduloCrearInvestigador ventanaCrear= new moduloCrearInvestigador();
               ventanaCrear.setVisible(true);
            }
        };
        botonCrear.addActionListener(oyenteBoton);
    }
    private void crearListenerCargar(JButton boton){
        ActionListener oyenteBoton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            File file = new File("C:\\Users\\josue\\Desktop\\Proyecto1-IPC1-Quimik/investigadores.csv");
            for(int i= modeloTabla.getRowCount()-1;i>=0;i--){
                modeloTabla.removeRow(i);
            }
            try{
                String []titulos= {"Código","Nombre","Género","Experimentos"};
                BufferedReader br = new BufferedReader(new FileReader(file));
                
                modelo= (DefaultTableModel) tabla.getModel();
                modelo.setColumnIdentifiers(titulos);
                Object[] lineaTabla= br.lines().toArray();

                for(int i=0; i<lineaTabla.length; i++){
                    String linea = lineaTabla[i].toString().trim();
                    String[] dataRow= linea.split(",");
                    modelo.addRow(dataRow);
                }
            }catch (Exception ex){
            }
            }
            
        };
        boton.addActionListener(oyenteBoton);
    }
    private void crearListenerActualizar(JButton boton){
    ActionListener oyenteBoton= new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        moduloActualizarDatos ventana = new moduloActualizarDatos();
        ventana.setVisible(true);
        }
        
    };
    boton.addActionListener(oyenteBoton);

    }
    private void crearListenerEliminar(JButton boton){
        ActionListener accion= new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                moduloAdminEliminar ventanaEliminar= new moduloAdminEliminar();
                ventanaEliminar.setVisible(true);
            }
            
        };
        boton.addActionListener(accion);

    }
}


