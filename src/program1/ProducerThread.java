package program1;

import java.util.Random;

public class ProducerThread implements Runnable
{
    //private final Object lock = new Object();
    private Integer m_runsRemaining = 3;
    private Integer m_procID = 0;

    public void produceProcess(MinHeap heap)
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
        heap.addProcessToHeap(procNode);
    }

    public void run()
    {
        //run function
    }
}
