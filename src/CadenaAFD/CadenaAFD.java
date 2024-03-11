package CadenaAFD;

import java.awt.Graphics;
import java.awt.Image;
import javaswingdev.message.MessageDialog;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class CadenaAFD extends javax.swing.JFrame 
{
    MessageDialog OptionPane = new MessageDialog(this);
    FondoPanel fondo = new FondoPanel();
    boolean ban = true;
    String alfabeto = ""; 
    String estados = "";
    String estfinales = "";
    String cadena = "";
    String[][] matriz;

    public CadenaAFD() 
    {
        setContentPane(fondo);
        initComponents();
        setResizable(false);
        setSize(1000,800);
        setLocationRelativeTo(null);
        
        lblAlfabeto.setVisible(false);
        lblEstados.setVisible(false);
        lblEstAceptacion.setVisible(false);
    }

    private void mostrarError(String msj)
    {
	OptionPane.showMessage("ERROR", msj, "/img/Close.png");
    }
    
    private boolean Empty(String cadena, String msj, JTextField texto)
    {
        if(cadena.isEmpty()) {
            mostrarError(msj);
            texto.requestFocus();
            return true;
        }
        else
            return false;
    }
    
    private void mostrarRes(JTextField texto, String original, int valor, JLabel etiqueta) 
    {
        StringBuilder cadena = new StringBuilder();
        texto.setVisible(false);
        if(valor == 0 && !original.isEmpty())
            for(int i = 0; i < original.length(); i++)
                cadena.append(original.charAt(i)).append(",");
        else
            for(int i = 0; i < valor; i++)
                cadena.append(i).append(",");
        cadena.deleteCharAt(cadena.length() - 1);
        etiqueta.setText("{" + cadena + "}");
        etiqueta.setVisible(true);
    }

    private void validateInputAndUpdateTable(DefaultTableModel modeloTabla, String estados) 
    {            
        modeloTabla.addTableModelListener(new TableModelListener() 
        {                  
            public void tableChanged(TableModelEvent e) {
                if(e.getType() == TableModelEvent.UPDATE) {
                    boolean ban = true;
                    if(ban){
                        int fila = e.getFirstRow();
                        int columna = e.getColumn();
                        Object valor = tblTransicion.getValueAt(fila, columna);                                                   
                
                        if(valor == null || valor.toString().isEmpty()) {                                
                            mostrarError("No se permiten celdas vacías en la tabla"); 
                            modeloTabla.setValueAt("-1", fila, columna);
                        }
                        else
                            if(!valor.toString().matches("^[0-9]*|-1$")) {
                                mostrarError("Debe ingresar una transición válida");
                                modeloTabla.setValueAt("-1", fila, columna);
                            }
                            else
                                if(Integer.parseInt(valor.toString()) >= Integer.parseInt(estados)) {
                                    mostrarError("El estado " + valor + " no es válido");
                                    modeloTabla.setValueAt("-1", fila, columna);
                                }
                                else
                                    matriz[(fila + 1)][columna] = valor.toString();                                
                    }                
                }            
            }        
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtEstAceptacion = new javax.swing.JTextField();
        txtAlfabeto = new javax.swing.JTextField();
        txtEstados = new javax.swing.JTextField();
        txtCadena = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCadena = new javax.swing.JLabel();
        btnValidar = new javax.swing.JLabel();
        lblq0 = new javax.swing.JLabel();
        lblEstAceptacion = new javax.swing.JLabel();
        lblEstados = new javax.swing.JLabel();
        lblAlfabeto = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tblGen = new javax.swing.JScrollPane();
        tblTransicion = new rojeru_san.complementos.RSTableMetro();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEstAceptacion.setBackground(new java.awt.Color(96, 200, 180, 50));
        txtEstAceptacion.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        txtEstAceptacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtEstAceptacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEstAceptacionFocusLost(evt);
            }
        });
        getContentPane().add(txtEstAceptacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 205, 450, 30));

        txtAlfabeto.setBackground(new java.awt.Color(96, 200, 180, 50));
        txtAlfabeto.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        txtAlfabeto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtAlfabeto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAlfabetoFocusLost(evt);
            }
        });
        getContentPane().add(txtAlfabeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 105, 450, 30));

        txtEstados.setBackground(new java.awt.Color(96, 200, 180, 50));
        txtEstados.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        txtEstados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtEstados.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEstadosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEstadosFocusLost(evt);
            }
        });
        getContentPane().add(txtEstados, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 155, 450, 30));

        txtCadena.setBackground(new java.awt.Color(96, 200, 180, 50));
        txtCadena.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        txtCadena.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtCadena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCadenaFocusLost(evt);
            }
        });
        getContentPane().add(txtCadena, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 510, 450, 30));

        jLabel6.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        jLabel6.setText("Ingrese la quíntupla del autómata");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        jLabel2.setText("Estados:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        jLabel4.setText("Estados de aceptación:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        lblCadena.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        lblCadena.setText("Cadena a Validar:");
        getContentPane().add(lblCadena, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 515, -1, -1));

        btnValidar.setBackground(new java.awt.Color(0, 153, 153));
        btnValidar.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        btnValidar.setForeground(new java.awt.Color(255, 255, 255));
        btnValidar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnValidar.setText("Validar Cadena");
        btnValidar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnValidar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnValidar.setOpaque(true);
        btnValidar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnValidarMouseClicked(evt);
            }
        });
        getContentPane().add(btnValidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 610, 270, 40));

        lblq0.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        lblq0.setText("{0}");
        getContentPane().add(lblq0, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, -1));

        lblEstAceptacion.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        lblEstAceptacion.setText("q0");
        getContentPane().add(lblEstAceptacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 450, -1));

        lblEstados.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        lblEstados.setText("q0");
        getContentPane().add(lblEstados, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 450, -1));

        lblAlfabeto.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        lblAlfabeto.setText("q0");
        getContentPane().add(lblAlfabeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 450, -1));

        jLabel7.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        jLabel7.setText("Alfabeto:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        jLabel8.setText("Estado inicial:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 260, -1, -1));

        tblTransicion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblTransicion.setColorBackgoundHead(new java.awt.Color(96, 200, 180, 50));
        tblTransicion.setColorFilasBackgound2(new java.awt.Color(204,189,176,57));
        tblTransicion.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tblTransicion.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tblTransicion.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tblTransicion.setColorSelBackgound(new java.awt.Color(96, 200, 180, 50));
        tblTransicion.setColorSelForeground(new java.awt.Color(0, 0, 0));
        tblTransicion.setFuenteFilas(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        tblTransicion.setFuenteFilasSelect(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        tblTransicion.setFuenteHead(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        tblTransicion.setRowHeight(30);
        tblGen.setViewportView(tblTransicion);

        getContentPane().add(tblGen, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 460, 150));

        jLabel9.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        jLabel9.setText("Función de Transición:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnValidarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnValidarMouseClicked
        cadena = txtCadena.getText();
        ban = true;
        
        if(Empty(cadena, "Debes ingresar la cadena a validar por el autómata", txtCadena));
        else {
            for(int i = 0; i < cadena.length(); i++)
                if(!alfabeto.contains(String.valueOf(cadena.charAt(i)))) {
                    mostrarError("La cadena debe contener sólo elementos del alfabeto dado");
                    ban = false;
                    break;
                }
            if(ban) {
                int row = 1;
                for(int i = 0; i < cadena.length(); i++) {
                    char car = cadena.charAt(i);
                    
                    int columna = 0;
                    for(int j = 1; j < matriz[0].length; j++) {
                        if(matriz[0][j].equals(String.valueOf(car))) {                       
                            columna = j;
                            break;
                        }
                    }                                     
                    row = Integer.parseInt(matriz[row + 1][columna]);
                    
                    if(row == -1)
                        break;
                }
                System.out.println("Estado final: " + row);
                System.out.println("Estados finales: " + estfinales);
                
                for(int i = 0; i < estfinales.length(); i++)
                    if(row == Integer.parseInt(String.valueOf(estfinales.charAt(i))))
                        OptionPane.showMessage("Registro en el Sistema", "Usuario registrado exitosamente, por favor ingrese con su nueva cuenta", "/img/iconos/Info.png");
            }
        }
    }//GEN-LAST:event_btnValidarMouseClicked

    private void txtAlfabetoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAlfabetoFocusLost
        alfabeto = txtAlfabeto.getText();
        char caracter;
        ban = true;
        
        if(Empty(alfabeto, "El alfabeto no puede estar vacío", txtAlfabeto));
        else {
            alfabeto = alfabeto.replaceAll("[,\\s]", "");
            for(int i = 0; i < alfabeto.length(); i++) {
                caracter = alfabeto.charAt(i);
                for(int j = i + 1; j < alfabeto.length(); j++)
                    if(caracter == alfabeto.charAt(j)) {
                        if(ban) {
                            mostrarError("No debe haber símbolos repetidos dentro del alfabeto");
                            txtAlfabeto.requestFocus();
                            ban = false;
                        }
                        break;              
                    }
            }
            if(ban)
                mostrarRes(txtAlfabeto, alfabeto, 0, lblAlfabeto);
        }       
    }//GEN-LAST:event_txtAlfabetoFocusLost

    private void txtEstadosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEstadosFocusGained
        
    }//GEN-LAST:event_txtEstadosFocusGained

    private void txtEstadosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEstadosFocusLost
        estados = txtEstados.getText();
        
        if(lblAlfabeto.isVisible())
            if(Empty(estados, "Debe indicar la cantidad de estados", txtEstados));
            else
                if(!estados.matches("^[1-9]([0-9])*$")) {
                    mostrarError("Debe ingresar una cantidad válida de estados");
                    txtEstados.requestFocus();
                }
                else
                    mostrarRes(txtEstados,"", Integer.parseInt(estados), lblEstados);                                    
    }//GEN-LAST:event_txtEstadosFocusLost

    private void txtEstAceptacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEstAceptacionFocusLost
        estfinales = txtEstAceptacion.getText();
        char caracter;
        ban = true;
        
        if(lblEstados.isVisible())
            if(Empty(estfinales, "Debe indicar cuáles son los estados finales", txtEstAceptacion));
            else
                if(!estados.matches("^([0-9])*$")) {
                    mostrarError("Debe ingresar estados finales válidos");
                    txtEstAceptacion.requestFocus();
                }
                else {
                    estfinales = estfinales.replaceAll("[,\\s]", ""); 
                    for(int i = 0; i < estfinales.length(); i++) {
                        caracter = estfinales.charAt(i);
                        for(int j = i + 1; j < estfinales.length(); j++)
                            if(caracter == estfinales.charAt(j)) {
                                if(ban){
                                    mostrarError("No debe haber estados finales repetidos");
                                    txtEstAceptacion.requestFocus();
                                    ban = false;
                                }
                                break;           
                            }
                        if(Integer.parseInt(String.valueOf(estfinales.charAt(i))) >= Integer.parseInt(estados)) {
                            mostrarError("El estado final " + estfinales.charAt(i) + " no se encuentra dentro de la cantidad de estados ingresados");
                            txtEstAceptacion.requestFocus();
                            ban = false;
                            break;
                        }
                    }
                    if(ban) {
                        mostrarRes(txtEstAceptacion, estfinales, 0, lblEstAceptacion);
                        
                        String[] alf = new String[alfabeto.length() + 1];
                        alf[0] = "";
                        for(int i = 0; i < alfabeto.length(); i++)
                            alf[i + 1] = alfabeto.charAt(i) + "";
                        
                        DefaultTableModel modeloTabla = new DefaultTableModel(alf, 0) {
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return column != 0; // No editar la 1 columna 
                            }
                        };
                        for(int i = 0; i < Integer.parseInt(estados); i++)
                            modeloTabla.addRow(new Object[]{i});                                     
                        tblTransicion.setModel(modeloTabla);
                        
                        matriz = new String[Integer.parseInt(estados) + 1][alfabeto.length() + 1];
                        matriz[0][0] = "";
                        for(int i = 0; i < Math.min(matriz[0].length - 1, alfabeto.length()); i++)
                            matriz[0][i + 1] = alfabeto.charAt(i) + "";
                        for(int j = 1; j < matriz.length; j++)
                            matriz[j][0] = String.valueOf(j - 1);
                                                
                        validateInputAndUpdateTable(modeloTabla, estados);
                    }
                }                             
    }//GEN-LAST:event_txtEstAceptacionFocusLost

    private void txtCadenaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCadenaFocusLost
        
    }//GEN-LAST:event_txtCadenaFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadenaAFD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadenaAFD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadenaAFD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadenaAFD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CadenaAFD().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnValidar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblAlfabeto;
    private javax.swing.JLabel lblCadena;
    private javax.swing.JLabel lblEstAceptacion;
    private javax.swing.JLabel lblEstados;
    private javax.swing.JLabel lblq0;
    private javax.swing.JScrollPane tblGen;
    private rojeru_san.complementos.RSTableMetro tblTransicion;
    private javax.swing.JTextField txtAlfabeto;
    private javax.swing.JTextField txtCadena;
    private javax.swing.JTextField txtEstAceptacion;
    private javax.swing.JTextField txtEstados;
    // End of variables declaration//GEN-END:variables
}

class FondoPanel extends JPanel
    {
        private Image imagen;
        @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("/img/Fondos.jpeg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }