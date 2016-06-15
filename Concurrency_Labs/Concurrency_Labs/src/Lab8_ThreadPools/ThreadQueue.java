package Lab8_ThreadPools;

import java.util.*;


//
    //** TO DO add three private state variables  - all final
    // numOfThreads an int to hold member size
    // threads - the pool (an array of PoolMembers)
    // queue - a Collection (LinkedList) to hold tasks

    //** TO DO Add a constructor (takes size of pool)
    //
    //
        // initialize the three state finals
        // i.e. create new array and new LinkedList

        // Loop through pool and create a new
        // PoolMember (pass it a String for its name)
        // and start them all off

    //

    // ** TO DO implement public execute() method
    // taking a Runnable parameter
    //
        // synchronized a block on queue
	//
            // add Runnable to list - use addList()
            // notify waiting thread
        //
    //

    // a Freebee!! - Please remove comments
    /*
    public void tidyUp()
    {
	for (int i = 0; i < numOfThreads; i++)
	{
		PoolMember thread = threads[i];
		if (thread.isAlive())
		{
			thread.setDead();
		}
	}

    }
    */


    //** TO DO implement PoolMember member class
    // Make it private and extends Thread
    //
        // ** TO add state variable boolean dead
        // Initialize it with false
        //

	//** TO DO Add a default constructor
	//
		// invoke super
	//

        //** TO DO Add an overloaded constructor
        // Takes String for the thread name
        //
	//
		// invoke super with name
        //

        //

	//** Add setDead() method
	//
		// assign true to dead state variable
	//

	//** TO DO - now override the run() method
        //
	//
            // Create local Runnable reference

            // loop while alive (i.e. not dead!)
	    //
                // synchronized block on queue
		//
                    // loop queue is empty (use isEmpty())
		    //
                        // try
                        //
                            // wait() on queue
                        //
                        // catch  an InterruptedException
                        // (ignore it for now)
                        //
                    // End of loop (on queue empty

                    // Remove first from queue cast to Runnable
                    // and assign to local Runnable reference
                //

                // If we don't catch RuntimeException,
                // the pool could leak threads
                // try
		//
                    // invoke Runnable's run() method - at last!

                //
                // catch (RuntimeException e)
		//
                    // You might want to log something here
                    // Ignore it for now!
                //
            // End of loop while thread is alive

        // End of run()
    //  End of member class
// End of ThreadQueue class
