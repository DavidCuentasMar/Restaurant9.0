/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Restaurant;

/**
 *
 * @author Administrador
 */
public class Controlador {
    public Restaurant restaurant;

    public Controlador() {
        restaurant = new Restaurant();

    }
    
    public void InitialConfig(String type, String name, int amount, int price){
        restaurant.InitialConfig(type, name, amount, price);
    }
    
}
