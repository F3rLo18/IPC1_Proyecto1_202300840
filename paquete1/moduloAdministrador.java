package paquete1;
import java.awt.Color;
import java.awt.Font;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class moduloAdministrador extends JFrame{
    //--------------------------------------Creación de variables globales-----------------------------------------
    Color fondo= new Color(40, 144, 89);
    Color frente= new Color(119, 213, 163);
    private int panelActivo=0;
    private String fuente="Cascadia Code SemiBold";
    private JComboBox cajaInvestigadores;
    private JComboBox cajaMuestras;
    private JPanel panelGeneral;
    private JPanel panelInvestigadores;
    private JPanel panelMuestras = new JPanel();
    private JPanel panelAsignacionExpos= new JPanel();
    private JPanel panelPatrones= new JPanel();

    private JTable tabla;
    private DefaultTableModel modeloTablaInvestigadores;
    private DefaultTableModel modelo; //Para la carga de datos

    private JTable tablaMuestras;
    private DefaultTableModel modeloTablaMuestras;

    private JTable tablaPatrones;
    private DefaultTableModel modeloTablaPatrones;

    private boolean panelMuestrasActivado=false;
    private boolean panelAsignacionActivado=false;
    private boolean panelPatronesActivado=false;
    


//-------------------------------------Constructor de la clase(inicializador de la ventana)-------------------------------------
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

        
        this.getContentPane().setBackground(fondo);
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
        panelGeneral.setBackground(fondo);
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
        etiquetaPanelInvestigadores.setBackground(frente);
        etiquetaPanelInvestigadores.setBorder(border);
        panelGeneral.add(etiquetaPanelInvestigadores);

        JLabel etiquetaPanelMuestras= new JLabel("Muestras ");
        etiquetaPanelMuestras.setBounds(180,10,120,40);
        etiquetaPanelMuestras.setFont(new Font(fuente, 0, 25));
        etiquetaPanelMuestras.setBorder(border);
        etiquetaPanelMuestras.setOpaque(true);
        panelGeneral.add(etiquetaPanelMuestras);
        

        JLabel etiquetaPanelAsignacionExps= new JLabel("Asignación de experimentos ");
        etiquetaPanelAsignacionExps.setBounds(300 ,10,330,40);
        etiquetaPanelAsignacionExps.setFont(new Font(fuente, 0, 25));
        etiquetaPanelAsignacionExps.setBorder(border);
        etiquetaPanelAsignacionExps.setOpaque(true);
        panelGeneral.add(etiquetaPanelAsignacionExps);
        
        JLabel etiquetaPanelPatrones= new JLabel("Patrones ");
        etiquetaPanelPatrones.setBounds(630,10,150,40);
        etiquetaPanelPatrones.setFont(new Font(fuente, 0, 25));
        etiquetaPanelPatrones.setBorder(border);
        etiquetaPanelPatrones.setOpaque(true);
        panelGeneral.add(etiquetaPanelPatrones);

        etiquetaPanelMuestras.setBackground(fondo);
        etiquetaPanelAsignacionExps.setBackground(fondo);
        etiquetaPanelPatrones.setBackground(fondo);

        crearListenerPanelInvestigadores(etiquetaPanelInvestigadores,etiquetaPanelMuestras,etiquetaPanelAsignacionExps,etiquetaPanelPatrones);
        crearListenerPanelMuestras(etiquetaPanelMuestras,etiquetaPanelInvestigadores,etiquetaPanelAsignacionExps,etiquetaPanelPatrones);
        crearListenerPanelAsignaciones(etiquetaPanelAsignacionExps,etiquetaPanelInvestigadores,etiquetaPanelMuestras,etiquetaPanelPatrones);
        crearListenerPanelPatrones(etiquetaPanelPatrones,etiquetaPanelInvestigadores,etiquetaPanelMuestras,etiquetaPanelAsignacionExps);

    }
    //-------------------------------------Listeners de las etiquetas del panel general para cambio de pestaña-----------------------
    private void crearListenerPanelInvestigadores(JLabel etiqueta,JLabel etiqueta2,JLabel etiqueta3,JLabel etiqueta4){
        
        MouseListener oyente= new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelInvestigadores.setVisible(true);
                panelMuestras.setVisible(false);
                panelAsignacionExpos.setVisible(false);
                panelPatrones.setVisible(false);
                panelActivo=0;
                etiqueta2.setBackground(fondo);
                etiqueta3.setBackground(fondo);
                etiqueta4.setBackground(fondo);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                //Método inutilizado
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                //Método inutilizado
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                if(panelActivo==0){
                    etiqueta.setFont(new Font(fuente, 1, 25));
                }
                else{
                    etiqueta.setBackground(frente);
                }
                
            }
            @Override
            public void mouseExited(MouseEvent e) {
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
    private void crearListenerPanelMuestras(JLabel etiqueta,JLabel etiqueta2,JLabel etiqueta3,JLabel etiqueta4){
        MouseListener oyente= new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelInvestigadores.setVisible(false);
                panelMuestras.setVisible(true);
                panelAsignacionExpos.setVisible(false);
                panelPatrones.setVisible(false);
                panelActivo=1;
                etiqueta2.setBackground(fondo);
                etiqueta3.setBackground(fondo);
                etiqueta4.setBackground(fondo);
                if(!panelMuestrasActivado){
                    iniciarComponentesPanelMuestras();
                    panelMuestrasActivado=true;
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                //Método inutilizado
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                //Método inutilizado
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                if(panelActivo==1){
                    etiqueta.setFont(new Font(fuente, 1, 25));
                }
                else{
                    etiqueta.setBackground(frente);
                }
                
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if(panelActivo==1){
                    etiqueta.setFont(new Font(fuente, 0, 25));
                }
                else{
                    etiqueta.setBackground(fondo);
                }

                
            }
            
        };
        etiqueta.addMouseListener(oyente);
    }
    private void crearListenerPanelAsignaciones(JLabel etiqueta,JLabel etiqueta2,JLabel etiqueta3,JLabel etiqueta4){
        MouseListener oyente= new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelInvestigadores.setVisible(false);
                panelMuestras.setVisible(false);
                panelAsignacionExpos.setVisible(true);
                panelPatrones.setVisible(false);
                panelActivo=2;
                etiqueta2.setBackground(fondo);
                etiqueta3.setBackground(fondo);
                etiqueta4.setBackground(fondo);
                if(!panelAsignacionActivado){
                    iniciarComponentesPanelAsignacion();
                    panelAsignacionActivado=true;
                }
                else{
                    iniciarBotonesAsignacion();
                }
                
            }
            @Override
            public void mousePressed(MouseEvent e) {
                //Método inutilizado
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                //Método inutilizado
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                if(panelActivo==2){
                    etiqueta.setFont(new Font(fuente, 1, 25));
                }
                else{
                    etiqueta.setBackground(frente);
                }
                
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if(panelActivo==2){
                    etiqueta.setFont(new Font(fuente, 0, 25));
                }
                else{
                    etiqueta.setBackground(fondo);
                }
            }
        };
        etiqueta.addMouseListener(oyente);
    }
    private void crearListenerPanelPatrones(JLabel etiqueta,JLabel etiqueta2,JLabel etiqueta3,JLabel etiqueta4){
        MouseListener oyente= new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelInvestigadores.setVisible(false);
                panelMuestras.setVisible(false);
                panelAsignacionExpos.setVisible(false);
                panelPatrones.setVisible(true);
                panelActivo=3;
                etiqueta2.setBackground(fondo);
                etiqueta3.setBackground(fondo);
                etiqueta4.setBackground(fondo);
                if(!panelPatronesActivado){
                    iniciarComponentesPanelPatrones();
                    panelPatronesActivado=true;
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                //Método inutilizado
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                //Método inutilizado
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                if(panelActivo==3){
                    etiqueta.setFont(new Font(fuente, 1, 25));
                }
                else{
                    etiqueta.setBackground(frente);
                }
                
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if(panelActivo==3){
                    etiqueta.setFont(new Font(fuente, 0, 25));
                }
                else{
                    etiqueta.setBackground(fondo);
                }
            }
        };
        etiqueta.addMouseListener(oyente);
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
        modeloTablaInvestigadores= new DefaultTableModel();
        JScrollPane scrollTabla= new JScrollPane();
        String []titulos= {"Código","Nombre","Género","Experimentos"};
        modeloTablaInvestigadores.setColumnIdentifiers(titulos);

        tabla= new JTable(modeloTablaInvestigadores);
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
    private void iniciarGraficaPanelInvestigadores(){
        
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
            for(int i= modeloTablaInvestigadores.getRowCount()-1;i>=0;i--){
                modeloTablaInvestigadores.removeRow(i);
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
    //---------------------------------------------Panel de muestras--------------------------------------------------
    private void iniciarComponentesPanelMuestras(){
        iniciarPanelMuestras();
        iniciarTablaPanelMuestras();
        iniciarBotonesPanelMuestras();
    }
    private void iniciarPanelMuestras(){
        panelMuestras= new JPanel();
        panelMuestras.setBounds(0,50,1200,600);
        panelMuestras.setBackground(new Color(119, 213, 163));
        panelMuestras.setLayout(null);
        panelGeneral.add(panelMuestras);
    }
    //---------------------------------------Tabla del módulo de muestras---------------------------------------------
    private void iniciarTablaPanelMuestras(){
        modeloTablaMuestras= new DefaultTableModel();
        JScrollPane scrollTabla= new JScrollPane();
        String []titulos= {"Código","Descripción","Estado"};
        modeloTablaMuestras.setColumnIdentifiers(titulos);

        tablaMuestras= new JTable(modeloTablaMuestras);
        tablaMuestras.setBounds(25,20,700,400);
        scrollTabla.setBounds(25,20,700,400);

        scrollTabla.setViewportView(tablaMuestras);
        panelMuestras.add(scrollTabla);
    }
    private void iniciarBotonesPanelMuestras(){
        JButton botonCrear= new JButton();
        botonCrear.setBounds(900,30,200,80);
        botonCrear.setText("Crear");
        botonCrear.setFont(new Font(fuente, 0, 25));
        panelMuestras.add(botonCrear);

        JButton botonCargar= new JButton();
        botonCargar.setBounds(900,150,200,80);
        botonCargar.setText("Cargar");
        botonCargar.setFont(new Font(fuente, 0, 25));
        panelMuestras.add(botonCargar);
        crearListenerCrearMuestras(botonCrear);
        crearListenerCargarMuestras(botonCargar);
    }
    //------------------------------------Acciones de botón del panel "Muestras"--------------------------------
    private void crearListenerCrearMuestras(JButton botonCrear){
        ActionListener oyenteBoton= new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(ListaPatrones.getCantidad()==0){
                    JOptionPane.showMessageDialog(null,"Para crear muestras antes debe de crear patrones...");
                }
                else{
                    moduloCrearMuestra ventanaCrearMuestra= new moduloCrearMuestra();
                    ventanaCrearMuestra.setVisible(true);    
                }
                }
        };
        botonCrear.addActionListener(oyenteBoton);
    }
    private void crearListenerCargarMuestras(JButton boton){
        ActionListener oyenteBoton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            File file = new File("C:\\Users\\josue\\Desktop\\Proyecto1-IPC1-Quimik/muestras.csv");
            for(int i= modeloTablaMuestras.getRowCount()-1;i>=0;i--){
                modeloTablaMuestras.removeRow(i);
            }
            try{
                String []titulos= {"Código","Descripción","Estado"};
                BufferedReader br = new BufferedReader(new FileReader(file));
                
                modeloTablaMuestras= (DefaultTableModel) tablaMuestras.getModel();
                modeloTablaMuestras.setColumnIdentifiers(titulos);
                Object[] lineaTabla= br.lines().toArray();

                for(int i=0; i<lineaTabla.length; i++){
                    String linea = lineaTabla[i].toString().trim();
                    String[] dataRow= linea.split(",");
                    modeloTablaMuestras.addRow(dataRow);
                }
            }catch (Exception ex){
            }
            }
            
        };
        boton.addActionListener(oyenteBoton);
    }
//------------------------------------------Inicialización de los componentes del panel de asignación de experimentos------------------------------------
    private void iniciarComponentesPanelAsignacion(){
            iniciarPanelAsignacion();
            iniciarEtiquetasPanelAsignaciones();
            iniciarBotonesAsignacion();
    }
    private void iniciarPanelAsignacion(){
        panelAsignacionExpos= new JPanel();
        panelAsignacionExpos.setBounds(0,50,1200,600);
        panelAsignacionExpos.setBackground(new Color(119, 213, 163));
        panelAsignacionExpos.setLayout(null);
        panelGeneral.add(panelAsignacionExpos);
    }
    private void iniciarEtiquetasPanelAsignaciones(){
        JLabel etiquetaInvestigador= new JLabel("Investigador: ");
        etiquetaInvestigador.setBounds(100,150,350,60);
        etiquetaInvestigador.setFont(new Font(fuente, 0, 50));
        panelAsignacionExpos.add(etiquetaInvestigador);

        JLabel etiquetaMuestra= new JLabel("Muestra: ");
        etiquetaMuestra.setBounds(100,250,250,60);
        etiquetaMuestra.setFont(new Font(fuente, 0, 50));
        panelAsignacionExpos.add(etiquetaMuestra);
    }
    private void iniciarBotonesAsignacion(){
        if(!panelAsignacionActivado){
            cajaInvestigadores= new JComboBox<>(ListaInvestigadores.toStringTodosNombres());
            cajaInvestigadores.setBounds(450,150,350,60);
            cajaInvestigadores.setFont(new Font(fuente, 0, 50));
            panelAsignacionExpos.add(cajaInvestigadores);        
            
            cajaMuestras= new JComboBox<>(ListaMuestras.toStringTodasMuestras());
            cajaMuestras.setBounds(450,250,350,60);
            cajaMuestras.setFont(new Font(fuente, 0, 50));
            panelAsignacionExpos.add(cajaMuestras);        
            
        }
        else{
            cajaInvestigadores.removeAllItems();
            DefaultComboBoxModel<String> modelll= new DefaultComboBoxModel<>(ListaInvestigadores.toStringTodosNombres());
            cajaInvestigadores.setModel(modelll);
            cajaMuestras.removeAllItems();
            DefaultComboBoxModel<String> modellll= new DefaultComboBoxModel<>(ListaMuestras.toStringTodasMuestras());
            cajaMuestras.setModel(modellll);
        }
    JButton botonAsignar= new JButton();
    botonAsignar.setText("Asignar");
    botonAsignar.setBounds(350,350,250,80);
    botonAsignar.setFont(new Font(fuente, 0, 50));
    panelAsignacionExpos.add(botonAsignar);

        crearListenerAsignarMuestra(botonAsignar);
    }

    private void crearListenerAsignarMuestra(JButton boton){
        ActionListener oyente= new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            if(ListaMuestras.getCantidad()==0){
                JOptionPane.showMessageDialog(null, "Para asignar una muestra antes debe de crear alguna...");
            }
            else{
                if(cajaInvestigadores.getSelectedItem().equals("admin")){
                JOptionPane.showMessageDialog(null,"El administrador no puede tener muestras asignadas....");
                }
                else{
                   if(ListaMuestras.listaMuestras.get(ListaMuestras.obtenerPosicion((String)cajaMuestras.getSelectedItem())).isAsignado()){ //Si la muestra ya fué asignada
            JOptionPane.showMessageDialog(null,"Esta muestra ya ha sido asignada a un investigador");
            }
            else{
            ListaInvestigadores.asignarMuestra((String) cajaInvestigadores.getSelectedItem(), (String) cajaMuestras.getSelectedItem());
            JOptionPane.showMessageDialog(null,"Se ha asignado la muestra al investigador correctamente");
            } 
                }

            }

            

            
            
            }
            
        };
        boton.addActionListener(oyente);
    }



//--------------------------------------------------Panel del módulo de patrones--------------------------------------------
private void iniciarComponentesPanelPatrones(){
    iniciarPanelPatrones();
    iniciarTablaPanelPatrones();
    iniciarBotonesPanelPatrones();
}
private void iniciarPanelPatrones(){
    panelPatrones= new JPanel();
    panelPatrones.setBounds(0,50,1200,600);
    panelPatrones.setBackground(new Color(119, 213, 163));
    panelPatrones.setLayout(null);
    panelGeneral.add(panelPatrones);
}
//---------------------------------------Tabla del módulo de Patrones---------------------------------------------
    private void iniciarTablaPanelPatrones(){
        modeloTablaPatrones= new DefaultTableModel();
        JScrollPane scrollTabla= new JScrollPane();
        String []titulos= {"Código","Nombre"};
        modeloTablaPatrones.setColumnIdentifiers(titulos);
        tablaPatrones= new JTable(modeloTablaPatrones);
        tablaPatrones.setBounds(25,20,700,400);
        scrollTabla.setBounds(25,20,700,400);
        scrollTabla.setViewportView(tablaPatrones);
        panelPatrones.add(scrollTabla);
    }
    private void iniciarBotonesPanelPatrones(){
        JButton botonCrear= new JButton();
        botonCrear.setBounds(750,80,200,80);
        botonCrear.setText("Crear");
        botonCrear.setFont(new Font(fuente, 0, 25));
        panelPatrones.add(botonCrear);

        JButton botonCargar= new JButton();
        botonCargar.setBounds(980,80,200,80);
        botonCargar.setText("Cargar");
        botonCargar.setFont(new Font(fuente, 0, 25));
        panelPatrones.add(botonCargar);
        
        JButton botonEliminar= new JButton();
        botonEliminar.setBounds(750,180,420,80);
        botonEliminar.setText("Eliminar");
        botonEliminar.setFont(new Font(fuente, 0, 25));
        panelPatrones.add(botonEliminar);
        
        crearListenerCrearPatron(botonCrear);
        crearListenerCargarPatron(botonCargar);
        crearListenerEliminarPatron(botonEliminar);
    }
    private void crearListenerCrearPatron(JButton boton){
        ActionListener oyente= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moduloCrearPatron ventana = new moduloCrearPatron();
                ventana.setVisible(true);
            }
        };
        boton.addActionListener(oyente);
    }
    private void crearListenerCargarPatron(JButton boton){
        ActionListener oyente= new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("C:\\Users\\josue\\Desktop\\Proyecto1-IPC1-Quimik/patrones.csv");
                for(int i= modeloTablaPatrones.getRowCount()-1;i>=0;i--){
                    modeloTablaPatrones.removeRow(i);
                }
                try{
                    String []titulos= {"Código","Nombre"};
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    
                    modeloTablaPatrones= (DefaultTableModel) tablaPatrones.getModel();
                    modeloTablaPatrones.setColumnIdentifiers(titulos);
                    Object[] lineaTabla= br.lines().toArray();
    
                    for(int i=0; i<lineaTabla.length; i++){
                        String linea = lineaTabla[i].toString().trim();
                        String[] dataRow= linea.split(",");
                        modeloTablaPatrones.addRow(dataRow);
                    }
                }catch (Exception ex){}
            }
        };
        boton.addActionListener(oyente);
    }
    private void crearListenerEliminarPatron(JButton boton){
        ActionListener oyente= new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            moduloEliminarPatron ventana= new moduloEliminarPatron();
            ventana.setVisible(true);
            }
            
        };
        boton.addActionListener(oyente);

    }

}