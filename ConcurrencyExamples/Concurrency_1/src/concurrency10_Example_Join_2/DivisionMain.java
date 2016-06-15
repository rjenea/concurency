
package concurrency10_Example_Join_2;

public class DivisionMain {
	public static void main(String[] args){
		Add t1 = new Add();
		Multiply t2 = new Multiply();
 
		t1.start(); // start the addition thread
		t2.start(); // start the multiply thread
 
		try {   System.out.println("Waiting for add and multiply to finish");
			t1.join(); // ie wait for these two to finish before doing our division task
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
                System.out.println("Back in Main ... Add and multiply threads have now finished");
                System.out.println("Add value = " + t1.value + " multiply value = " + t2.value + "  about to do division.." + t2.value +"/"+ t1.value );
		double n = ((double)t2.value/t1.value); // retrieve the values from t1 and t2 and perform division
 
		System.out.println("Division result is " + n);		
	}
}    

