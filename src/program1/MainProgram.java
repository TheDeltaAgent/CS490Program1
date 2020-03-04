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

        producerThread.run();
        consumerThread1.run();

    }


    //Thread thread = new Thread(new ConsumerThread());
    //Thread thread = new Thread(new ProducerThread());
}
