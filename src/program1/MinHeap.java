package program1;

import java.util.ArrayList;

public class MinHeap
{
    //Need to use ArrayList
    //Modified tree structure : parent is (currentIndex -1 / 2)
    // Watch out for correct truncation
    private final Object lock = new Object();
    private ArrayList<ProcessNode> heap = new ArrayList<>();

    private void heapSort()
    {

    }

    public void addProcessToHeap(ProcessNode n)
    {
        synchronized (lock)
        {
            //add Process to the arrayList and perform a HeapSort
        }
    }

    public void removeProcessFromHeap(ProcessNode n)
    {
        synchronized (lock)
        {
            //remove process from the arrayList and perform a HeapSort
        }

    }

}
