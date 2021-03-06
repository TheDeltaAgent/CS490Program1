package program1;

/**
 * Thread that periodically checks the heap to see if processes still remain inside it.
 *
 * @author Ethan McNabb
 * @author Bradley Bowen
 */
public class WatcherThread implements Runnable
{
    private MinHeap heapReference;
    int processesRemaining;
    public WatcherThread(MinHeap minHeap)
    {
        heapReference = minHeap;
    }
    /**
     * Run function.
     */
    public void run()
    {
        System.out.println("Starting watcher thread");
        processesRemaining = heapReference.m_heap.size();
        //Check the heap to see if there are processes in it until there are none.
        while(processesRemaining != 0)
        {
            try
            {
                System.out.println("Watcher has detected that " + heapReference.m_heap.size()+" processes remain in the heap. Sleeping...");
                Thread.sleep(5000);
                processesRemaining = heapReference.m_heap.size();
            }
            catch (InterruptedException e)
            {
                System.out.println("Exception caught: " + e);
            }
        }
        //No processes left, close watcher
        return;
    }

}
