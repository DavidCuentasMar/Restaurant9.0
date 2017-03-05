package modelo;

/**
 *
 * @author Administrador
 */
public class Producto {
    private String name;
    private int price;

    public Producto(String name, int price) {
        this.name = name;
        this.price=price;
    }
     public Producto(String name) { // Poloformismo para ingredientes
         this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
    
}
