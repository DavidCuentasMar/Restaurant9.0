/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author pc
 */
public class Producto {
      public String Producto;
        public int Cant;
        public String Tipo;
        public int NroPedid;
        public String Mesa;
        public String Camarero;
        public Producto link;
        
        public Producto LlenarList(Producto ptr,String X, String T,int Nro,String M,String C){
        Producto p = new Producto();
        Producto r = ptr;
        boolean SW = true;
         while(r != null && SW == true){
             if (r.Producto.equals(X)) {
                 SW = false;
             }else{
                r = r.link;
             }
        }
        p.Producto = X;
        p.Cant = 1;
        p.Tipo = T;
        p.NroPedid = Nro;
        p.Mesa = M;
        p.Camarero = C;
        if (ptr == null) {
            ptr = p;
        }else if(SW != false){
            Producto q = ptr;
            while(q.link != null){
                q = q.link;
            }
            q.link = p;
        }else{
            r.Cant++;
        }
        return ptr;
    }
     public String GetMesa(Producto Ptr,int NroPedido){
         Producto P = Ptr;
         boolean SW = false;
         String X = "";
         while(P != null && SW == false){
             if (P.NroPedid == NroPedido) {
                 X = P.Mesa;
                 SW = true;
             }
             P = P.link;
         }
         return X;
    }
    public String GetCamarero(Producto Ptr,int NroPedido){
        Producto P = Ptr;
        boolean SW = false;
        String X = "";
        while(P!= null && SW == false){
            if (P.NroPedid == NroPedido) {
                X = P.Camarero;
            }
            P = P.link;
        }
        return X;
    }
    
    public String GetPlato(Producto Ptr,int NroPedido){
        Producto P = Ptr;
        String X = "";
        while(P!= null){
            if (P.NroPedid == NroPedido && P.Tipo.equals("Plato")) {
                X = X + P.Producto+" x"+P.Cant+" ";
            }
            P = P.link;
        }
        return X;
    }
    public String GetBebida(Producto Ptr,int NroPedido){
        Producto P = Ptr;
        String X = "";
        while(P!= null){
            if (P.NroPedid == NroPedido && P.Tipo.equals("Bebida")) {
                X = X + P.Producto+" x"+P.Cant+" ";
            }
            P = P.link;
        }
        return X;
    }
    
    public String GetPostre(Producto Ptr,int NroPedido){
        Producto P = Ptr;
        String X = "";
        while(P!= null){
            if (P.NroPedid == NroPedido && P.Tipo.equals("Postre")) {
                X = X + P.Producto+" x"+P.Cant+" ";
            }
            P = P.link;    
        }
        return X;
    }
}
        
        

