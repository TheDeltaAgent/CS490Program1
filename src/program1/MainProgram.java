package program1;

/**
 *  CS 490
 *  Program 1
 *  @Authors: Ethan McNabb with Bradley Bowen (This is Ethan's version of this project)
 *  This program simulates the creation and execution of prioritized processes.
 */
public class MainProgram
{
    public static void main(String[] args)
    {
        MinHeap heap = new MinHeap();
        Thread producerThread = new Thread(new ProducerThread(heap));
        Thread consumerThread1 = new Thread(new ConsumerThread(heap, 1));
        Thread consumerThread2 = new Thread(new ConsumerThread(heap, 2));
        Thread watcherThread = new Thread(new WatcherThread(heap));

        //HeapSort Test Code
        //Add a few nodes to heap
        /**ProcessNode node1 = new ProcessNode(1, 1, (long)0);
        ProcessNode node2 = new ProcessNode(1, 2, (long)0);
        ProcessNode node3 = new ProcessNode(1, 3, (long)0);

        heap.addProcessToHeap(node1);
        heap.addProcessToHeap(node2);
        heap.addProcessToHeap(node3);

        heap.removeProcessFromHeap();**/

        //Test code for concurrent running threads
        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
        try
        {
            producerThread.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("Exception caught at producer's join: "+ e);
        }
        watcherThread.start();
        try
        {
            watcherThread.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("Exception caught at watcher's join: "+ e);
        }
        System.out.println("Sending 1st interrupt");

        consumerThread1.interrupt();
        System.out.println("Sending 2nd interrupt");

        consumerThread2.interrupt();
    }




    //Thread thread = new Thread(new ConsumerThread());
    //Thread thread = new Thread(new ProducerThread());
}
