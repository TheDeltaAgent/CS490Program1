package program1;

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
