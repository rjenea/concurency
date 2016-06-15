
package concurrency16_Example_Synchronized;

public class Main_Runner {
public static void main(String[] args) {
        
        SynchronizedShoppingCart cart = new SynchronizedShoppingCart();
        // Add some items
        cart.addItem(new Item(101, "Boomerang", 10.95));
        cart.addItem(new Item(123, "Football", 29.95));
        cart.addItem(new Item(45, "Tennis Ball", 17.49));       
        cart.printCart(); // Print cart contents
    }    
}
