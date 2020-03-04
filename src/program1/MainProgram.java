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
        ConsumerThread consumerThread1 = new ConsumerThread(heap);
        ProducerThread producerThread = new ProducerThread(heap);


    }


    //Thread thread = new Thread(new ConsumerThread());
    //Thread thread = new Thread(new ProducerThread());
}
