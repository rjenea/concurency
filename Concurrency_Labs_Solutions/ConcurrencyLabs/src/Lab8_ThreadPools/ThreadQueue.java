package Lab8_ThreadPools;

import java.util.*;

public class ThreadQueue
{
    private final int numOfThreads;
    private final PoolMember[] threads;
    private final LinkedList queue;

    public ThreadQueue(int numOfThreads)
    {
        this.numOfThreads = numOfThreads;
        queue = new LinkedList();
        threads = new PoolMember[numOfThreads];

        for (int i=0; i<numOfThreads; i++)
	{
            threads[i] = new PoolMember("thread" + i);
            threads[i].start();
        }
    }

    public void execute(Runnable r)
    {
        synchronized(queue)
	{
            queue.addLast(r);
            queue.notify();
        }
    }

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



    //
    private class PoolMember extends Thread
    {

	private boolean dead = false;

	PoolMember()
	{
		super();
	}
        PoolMember(String name)
	{
		super(name);
	}

	public void setDead()
	{
		dead = true;
		System.out.println("Pool Member: " + getName() + " just died");
	}

	public void run()
	{
            Runnable r;
	    System.out.println("Pool Member: " + getName() + " started up");
            while (!dead)
	    {
                synchronized(queue)
		{
                    while (queue.isEmpty())
		    {
                        try
                        {
                            queue.wait();
                        }
                        catch (InterruptedException ignored)
                        {
                        }
                    }

                    r = (Runnable) queue.removeFirst();
                }

                // If we don't catch RuntimeException,
                // the pool could leak threads
                try
		{
                    r.run();

                }
                catch (RuntimeException e)
		{
                    // You might want to log something here
                }
            }

        }
    }
}
