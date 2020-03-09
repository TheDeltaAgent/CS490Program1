package program1;

/**
 *  CS 490
 *  Program 1
 *  @Author: Ethan McNabb
 *  @Author: Bradley Bowen
 *  This program simulates the creation and execution of prioritized processes.
 *
 *  Testing Notes: This program was developed and run using Java Version 13.0.2 and IntelliJ Idea IDE Version 2019.1.3
 *  Community Edition
 */
public class MainProgram
{
    public static void main(String[] args)
    {
        //Create all the threads
        MinHeap heap = new MinHeap();
        ConsumerThread c1 = new ConsumerThread(heap, 1);
        ConsumerThread c2 = new ConsumerThread(heap, 2);
        Thread producerThread = new Thread(new ProducerThread(heap));
        Thread consumerThread1 = new Thread(c1);
        Thread consumerThread2 = new Thread(c2);
        Thread watcherThread = new Thread(new WatcherThread(heap));

        //start the producer and consumer threads
        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
        try
        {
            //Allow producer thread to finish before watcher thread starts
            producerThread.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("Exception caught at producer's join: "+ e);
        }
        //start watcher thread
        watcherThread.start();
        try
        {
            //allow watcher thread to finish before sending interrupts
            watcherThread.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("Exception caught at watcher's join: "+ e);
        }

        //Send interrupts
        System.out.println("Sending 1st interrupt");
        consumerThread1.interrupt();
        System.out.println("Sending 2nd interrupt");
        consumerThread2.interrupt();

        //Hard check to ensure consumers break their while loops
        c1.setInterrupt();
        c2.setInterrupt();

    }

}
