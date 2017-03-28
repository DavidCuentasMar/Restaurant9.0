package modelo;
public class Cocina {
    ListaPedido pedidos;

    public Cocina() {
        pedidos = new ListaPedido();
    }
    
    public void add(Pedido p){
        pedidos.addPedido(p);
    }
}
