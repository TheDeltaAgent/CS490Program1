package program1;

import java.util.Random;

public class ProducerThread implements Runnable
{
    //private final Object lock = new Object();
    private Integer m_runsRemaining = 3;
    private Integer m_procID = 0;
    private MinHeap heapReference;

    public ProducerThread(MinHeap heapRef)
    {
        heapReference = heapRef;
    }

    public void produceProcess()
    {
        Random rand = new Random();
        Integer priorityToGive = rand.nextInt(10);
        m_procID = m_procID + 1;
        //Create timeslice that is between 10 and 15 seconds
        float randFloat = rand.nextFloat();
        randFloat = randFloat * (float)5 + (float)10;
        randFloat = randFloat * 1000;
        Long timesliceToGive = (long) randFloat;

        ProcessNode procNode = new ProcessNode(m_procID, priorityToGive, timesliceToGive);

        //Add to the heap
        //Critical Region
        heapReference.addProcessToHeap(procNode);
    }

    public void run()
    {

        //run function
        for(int i = 1; i<=3; i++)
        {
            System.out.println("Producer adding nodes");
            for(int j = 0; j < 5; j++)
            {
                produceProcess();
            }
            try {
                //Sleep for a random interval between 5 to 10 seconds
                Random rand = new Random();
                float randFloat = rand.nextFloat();
                randFloat = randFloat * (float)5 + (float)5.0;
                randFloat = randFloat * 1000;
                Thread.sleep((long)randFloat);
            } catch (InterruptedException e) {
                System.out.println("Exception caught:" + e);
            }
        }
        System.out.println("Producer has completed its tasks");
        return;
    }
}
