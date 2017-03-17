/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.Configuracion;

/**
 *
 * @author sony
 */
public class Archivo {
    Nodo p = new Nodo();
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
                w.write(tipo+","+nombre+","+cantidad);
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
