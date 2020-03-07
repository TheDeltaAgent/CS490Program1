package program1;

/**
 * Thread that accesses the heap to take away processes and sleep for their timeslice duration.
 *
 * @author Ethan McNabb
 * @author Bradley Bowen
 */
public class ConsumerThread implements Runnable
{
    private MinHeap heapToUse;
    private int ID;
    boolean interrupted = false;
    /**
     * Overloaded constructor
     */
    public ConsumerThread(MinHeap heap, int consumerID)
    {
        heapToUse = heap;
        ID = consumerID;
    }


    public void run()
    {
        while(!interrupted)
        {
            //Get node
            ProcessNode node = heapToUse.removeProcessFromHeap();
            //If I got a node, sleep for duration node's time slice.
            if(node != null)
            {
                try
                {
                    //sleep
                    Thread.sleep(node.m_timeSlice);
                    //print statement of when thread has finished sleeping
                    System.out.println("Consumer " + ID + " has finished Process: " + node.m_processID
                            + " priority: " + node.m_priority + " at time: " + System.currentTimeMillis()
                    );
                }
                catch (InterruptedException e)
                {
                    System.out.println("No more nodes to consume " + ID);
                    interrupted = true;
                }
            }
        }
        return;

    }
}
