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
        Integer processIDToGive = m_procID + 1;
        float randFloat = rand.nextFloat();
        randFloat = randFloat * (float).4 + (float)1.0;
        Long timesliceToGive = (long) randFloat;

        ProcessNode procNode = new ProcessNode(processIDToGive, priorityToGive, timesliceToGive);

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
            for(int j = 0; i < 5; j++)
            {
                produceProcess();
            }
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                System.out.println("Exception caught:" + e);
            }
        }
    }
}
