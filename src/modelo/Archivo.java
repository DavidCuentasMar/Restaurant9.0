/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
    public void FormarMenu(JPanel platosPanel, JPanel bebidasPanel, JPanel postresPanel){
        String platosSrc="archivos/platos.txt";        
        formarMenu(platosSrc, platosPanel, bebidasPanel, postresPanel);
        String productosSrc ="archivos/productos.txt";
        formarMenu(productosSrc , platosPanel, bebidasPanel, postresPanel);
        
        
    }
    public void formarMenu(String ruta, JPanel platosPanel, JPanel bebidasPanel, JPanel postresPanel){
    String token = "";
    String p="";
    String c="";
        File archivo = new File(ruta);
        try(Scanner lector = new Scanner(archivo)){
            while(lector.hasNextLine()){
                String linea = lector.nextLine();
                StringTokenizer st = new StringTokenizer(linea,",");
                if (ruta.equals("archivos/platos.txt")) {
                    boolean Sw = true;
                    while(Sw){
                        token = st.nextElement().toString();
                        p = st.nextElement().toString();
                        Sw = false;
                    }
                    c = token+" $"+p;
                    JButton B = new JButton(c);
                    platosPanel.add(B);
                    B.setName(token);                    
                }
                if (ruta.equals("archivos/productos.txt")) {
                    boolean Sw = true;
                    while(Sw){
                        token = st.nextElement().toString();
                        if (token.equals("Bebida")) {
                            token = st.nextElement().toString();
                            p = st.nextElement().toString();
                            p = st.nextElement().toString();
                            c = token+" $"+p;
                            JButton B = new JButton(c);
                            bebidasPanel.add(B);
                            B.setName(token);                               
                        }
                        if (token.equals("Postre")) {
                            token = st.nextElement().toString();
                            p = st.nextElement().toString();
                            p = st.nextElement().toString();
                            c = token+" $"+p;
                            JButton B = new JButton(c);
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

    public void archivoTemp(String name,String type, int cant, int price){
        try(FileWriter bw = new FileWriter("archivos/temp.txt", true)){         
            BufferedWriter w = new BufferedWriter(bw);
            String cadena;
            try(FileReader f = new FileReader("archivos/productos.txt")){
                BufferedReader b = new BufferedReader(f);            
                while((cadena = b.readLine())!=null) {
//                  System.out.println(cadena);
                    StringTokenizer st = new StringTokenizer(cadena,",");
                    String typeToken = st.nextElement().toString();
                    String nameToken = st.nextElement().toString();
                    String cantToken = st.nextElement().toString();
                    String priceToken = st.nextElement().toString();                    
                    if (type.equals(typeToken)) {                        
                        if (nameToken.equals(name)) {
                            w.write(typeToken+","+nameToken+","+cant+","+priceToken);                       
                        }else{                            
                            w.write(typeToken+","+nameToken+","+cantToken+","+priceToken);                            
                        }
                        w.newLine();
                    }else{
                        w.write(typeToken+","+nameToken+","+cantToken+","+priceToken);
                        w.newLine();                    
                    }
                }
                b.close();
            } catch (IOException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }               
            w.close();
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File fichero = new File("archivos/productos.txt");
        fichero.delete();
        File fichero2 = new File("archivos/temp.txt");
        fichero2.renameTo(fichero);    
    
    }
    public int getCantidad(String name) {
        String cadena;
        try(FileReader f = new FileReader("archivos/productos.txt")){
            BufferedReader b = new BufferedReader(f);            
            while((cadena = b.readLine())!=null) {
                StringTokenizer st = new StringTokenizer(cadena,",");
                while(st.hasMoreElements()){
                    String token=st.nextElement().toString();
                    token=st.nextElement().toString();
                    if (name.equals(token)) {
                        token=st.nextElement().toString();
                        return Integer.parseInt(token);                        
                    }
                    
                }
            }
            b.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -666;
    }
    public String getPlatoIngredientes(String name){
        String cadena;
        try(FileReader f = new FileReader("archivos/platos.txt")){
            BufferedReader b = new BufferedReader(f);            
            while((cadena = b.readLine())!=null) {
                StringTokenizer st = new StringTokenizer(cadena,",");
                while(st.hasMoreElements()){
                    String token=st.nextElement().toString();
                    if (name.equals(token)) {
                        token=st.nextElement().toString();
                        token=st.nextElement().toString();
                        return token;                        
                    }                                      
                }
            }
            b.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "[PLATO NO ENCONTRADO]";
    }
    public int getPrice(String name) {
        String cadena;
        try(FileReader f = new FileReader("archivos/productos.txt")){
            BufferedReader b = new BufferedReader(f);            
            while((cadena = b.readLine())!=null) {
                StringTokenizer st = new StringTokenizer(cadena,",");
                while(st.hasMoreElements()){
                    String token=st.nextElement().toString();
                    token=st.nextElement().toString();
                    if (name.equals(token)) {
                        token=st.nextElement().toString();
                        token=st.nextElement().toString();
                        return Integer.parseInt(token);                        
                    }                    
                }
            }
            b.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return -15;
    }



}
