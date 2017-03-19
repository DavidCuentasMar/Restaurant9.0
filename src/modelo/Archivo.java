/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.Configuracion;

/**
 *
 * @author sony
 */
public class Archivo {
    Nodo p = new Nodo();
    
    public void MostrarPrecio(String p, String precio,String ruta, JTable TablePedidos, String type){
        DefaultTableModel model = (DefaultTableModel) TablePedidos.getModel();
        String token = "";
        File archivo = new File(ruta);
        try(Scanner lector = new Scanner(archivo)){
            while(lector.hasNextLine()){
                String linea = lector.nextLine();
                StringTokenizer st = new StringTokenizer(linea,",");
                if (ruta.equals("archivos/platos.txt")) {
                    boolean Sw = true;
                    while(Sw){
                        token = st.nextElement().toString();
                        if (token.equals(p)) {
                            token = st.nextElement().toString();
                            precio = token;
                        }
                        Sw = false;
                    }        
                }
                if (ruta.equals("archivos/productos.txt")) {
                    boolean Sw = true;
                    while(Sw){
                        token = st.nextElement().toString();
                        if (token.equals("Bebida")) {
                            token = st.nextElement().toString();
                            if (p.equals(token)) {
                                token = st.nextElement().toString();
                                token = st.nextElement().toString();
                                precio = token;
                            }
                        }
                        if (token.equals("Postre")) {
                            token = st.nextElement().toString();
                            if (p.equals(token)) {
                                token = st.nextElement().toString();
                                token = st.nextElement().toString();
                                precio = token;
                            }
                        } 
                        Sw=false;
                    }                                     
                }                                             
            }
            
              model.addRow(new Object[]{p,type,precio});
            
        }catch(FileNotFoundException ex){
            
        }
    }
    public void MostrarMenu(JPanel platosPanel, JPanel bebidasPanel, JPanel postresPanel){
        String platosSrc="archivos/platos.txt";        
        FormarMenu(platosSrc, platosPanel, bebidasPanel, postresPanel);
        String productosSrc ="archivos/productos.txt";
        FormarMenu(productosSrc , platosPanel, bebidasPanel, postresPanel);
        
        
    }
    public void FormarMenu(String ruta, JPanel platosPanel, JPanel bebidasPanel, JPanel postresPanel){
    String token = "";
        File archivo = new File(ruta);
        try(Scanner lector = new Scanner(archivo)){
            while(lector.hasNextLine()){
                String linea = lector.nextLine();
                StringTokenizer st = new StringTokenizer(linea,",");
                if (ruta.equals("archivos/platos.txt")) {
                    boolean Sw = true;
                    while(Sw){
                        token = st.nextElement().toString();
                        Sw = false;
                    }
                    JButton B = new JButton(token);
                    platosPanel.add(B);
                    B.setName(token);                    
                }
                if (ruta.equals("archivos/productos.txt")) {
                    boolean Sw = true;
                    while(Sw){
                        token = st.nextElement().toString();
                        if (token.equals("Bebida")) {
                            token = st.nextElement().toString();
                            JButton B = new JButton(token);
                            bebidasPanel.add(B);
                            B.setName(token);                               
                        }
                        if (token.equals("Postre")) {
                            token = st.nextElement().toString();
                            JButton B = new JButton(token);
                            postresPanel.add(B);
                            B.setName(token);                            
                        } 
                        Sw=false;
                    }                                     
                }                                             
            }
            
            
            
        }catch(FileNotFoundException ex){
            
        }
    }
    public void CrearArchivoProductos(DefaultTableModel model, JTable Table){
        //Configuración Inicial, El usuario crea un archivo con los productos
        //que manejará el restaurante.
        try(FileWriter bw = new FileWriter("archivos/productos.txt", true)){         
            BufferedWriter w = new BufferedWriter(bw);
            int Filas = Table.getRowCount();
            for (int i = 0; i < Filas; i++) {
                Object tipo = Table.getValueAt(i, 0);
                Object nombre = Table.getValueAt(i, 1);
                Object cantidad = Table.getValueAt(i, 2);
                Object precio = Table.getValueAt(i, 3);                
                w.write(tipo+","+nombre+","+cantidad+","+precio);
                w.newLine();
            }
            w.close();
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public void CrearArchivoPlatos(String name, int price, Lista list) {
        try(FileWriter bw = new FileWriter("archivos/platos.txt", true)){         
            BufferedWriter w = new BufferedWriter(bw);
            String ingredientes="";
            p = list.getPTR();
            while(p!=null){
                ingredientes = ingredientes+p.getIngrediente()+"+";
                p=p.getSiguiente();
            }            
            ingredientes = ingredientes.substring(0, ingredientes.length()-1);
            w.write(name+","+price+","+ingredientes); // patrón de archivo
            w.newLine();
            w.close();
            list.remove(); // Aquí como se pierde el ptr se muere la list
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
