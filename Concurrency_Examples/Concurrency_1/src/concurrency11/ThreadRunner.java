/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency11;

import static java.lang.Thread.sleep;

/**
 *
 * @author Administrator
 */
public class ThreadRunner {
    public static void main(String[] args) {
        // Create a ShoppingCart
        SynchronizedShoppingCart cart = new SynchronizedShoppingCart();
       
        
     
    Thread t1 = new Thread() { 
                        public void run(){ 
                        // Add some items
 			cart.addItem(new Item(101, "Boomerang", 10.95));
                        cart.addItem(new Item(123, "Soccer Ball", 29.95));
                        cart.addItem(new Item(45, "Tennis Ball 4 Pack", 17.49));
                        //cart.printCart();
                        try { 
                            sleep(1000);
                                
                            } catch (InterruptedException e) {return;}
			} 
		}; 
        t1.start(); 
    
    Thread t2 = new Thread() { 
                        public void run(){ 
                        // Add some items
 			cart.addItem(new Item(107, "Golf Balls", 8.95));
                        cart.addItem(new Item(103, "Tennis Shoes", 59.95));
                        cart.addItem(new Item(49, "PingPong balls", 1.49));
                        cart.printCart();
                        try { 
                            sleep(100);
                                
                            } catch (InterruptedException e) {return;}
			} 
		}; 
        t2.start(); 
    }
}
