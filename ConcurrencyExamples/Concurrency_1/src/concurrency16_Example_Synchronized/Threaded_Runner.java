
package concurrency16_Example_Synchronized;

import static java.lang.Thread.sleep;

public class Threaded_Runner {
    public static void main(String[] args) {
        // Create a ShoppingCart
        SynchronizedShoppingCart cart = new SynchronizedShoppingCart();
   
        Thread t1 = new Thread() { 
             public void run(){ 
                System.out.println(Thread.currentThread().getName() + " now Buying!");
                // Buy things....
                cart.addItem(new Item(101, "Boomerang", 10.95));
                cart.addItem(new Item(123, "Football", 29.95));
                cart.addItem(new Item(45, "Tennis Ball", 17.49));
                //cart.printCart();
               
             } 
	}; 
        t1.start(); 
    
        Thread t2 = new Thread() { 
             public void run(){      
                System.out.println(Thread.currentThread().getName() + " now Buying!");
             // Buy things....
 		cart.addItem(new Item(107, "Golf Ball", 8.95));
                cart.addItem(new Item(103, "Tennis Shoes", 59.95));
                cart.addItem(new Item(49, "PingPong ball", 1.49));
                cart.printCart();
                
             } 
	}; 
        t2.start(); 
        
    }
}
