/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency11;

/**
 *
 * @author Administrator
 */
public class MainRunner {
public static void main(String[] args) {
        // Create a ShoppingCart
        SynchronizedShoppingCart cart = new SynchronizedShoppingCart();
        // Add some items
        cart.addItem(new Item(101, "Boomerang", 10.95));
        cart.addItem(new Item(123, "Soccer Ball", 29.95));
        cart.addItem(new Item(45, "Tennis Ball 4 Pack", 17.49));

        // Print some messages about the cart
        cart.printCart();
    }    
}
