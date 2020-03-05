package program1;

import java.util.ArrayList;

public class MinHeap<E extends Comparable<E>>
{
    //Need to use ArrayList
    //Modified tree structure : parent is (currentIndex -1 / 2)
    // Watch out for correct truncation
    private final Object lock = new Object();
    public ArrayList<ProcessNode> m_heap;

    /**
     * Constructor
     */
    public MinHeap()
    {
        m_heap = new ArrayList<ProcessNode>();
    }

    private void heapSort(int heapTop) //top is min value
    {
        int leftChildIndex = (heapTop * 2) + 1;
        int rightChildIndex = (heapTop + 1) * 2;
        int swapIndex;

        //Check to see if children exist
        if(rightChildIndex < m_heap.size() )
        {
            if (m_heap.get(leftChildIndex).m_priority <= m_heap.get(rightChildIndex).m_priority)
            {
                swapIndex = leftChildIndex;
                swap(m_heap, swapIndex, heapTop);
                heapSort(swapIndex);
            }
            else {
                swapIndex = rightChildIndex;
                swap(m_heap, swapIndex, heapTop);
                heapSort(swapIndex);
            }
        }
        //Check if only left child exists
        else if(leftChildIndex < m_heap.size())
            if (m_heap.get(heapTop).m_priority <= m_heap.get(leftChildIndex).m_priority)
            {
                swapIndex = leftChildIndex;
                swap(m_heap, swapIndex, heapTop);
                heapSort(swapIndex);
            }




    }

    /**
     * This function adds Process to the arrayList and sorts it
     * @param n The process node to be added
     */
    public void addProcessToHeap(ProcessNode n)
    {
        System.out.println("Adding process");
        synchronized (lock)
        {
            m_heap.add(n);                // Put new value at the end
            int loc = m_heap.size()-1;    // and gets its location

            //Swap with parent until parent's priority not larger
            while (loc > 0 && m_heap.get(loc).m_priority < m_heap.get(parent(loc)).m_priority)
            {
                swap(m_heap, loc, parent(loc));
                loc = parent(loc);
            }
        }
    }




    public ProcessNode removeProcessFromHeap()
    {
        synchronized (lock)
        {
            //remove process from the arrayList and perform a HeapSort
            if (m_heap.size() <= 0)
                return null;
            else {
                ProcessNode topProcess = m_heap.get(0);
                m_heap.set(0, m_heap.get(m_heap.size()-1));         // Move last to position 0
                m_heap.remove(m_heap.size()-1);              // Removes copy at the bottom of the heap
                heapSort(0);
                return topProcess;
            }
        }
    }

    /**
     * Swap two locations i and j in ArrayList a.
     * @param a the arrayList
     * @param i first position
     * @param j second position
     */
    private static <E> void swap(ArrayList<E> a, int i, int j) {
        E t = a.get(i);
        a.set(i, a.get(j));
        a.set(j, t);
    }

    /**
     * Return the index of the parent of node i
     * (Parent of root will be -1)
     * @param i index of the child
     * @return index of the parent of node i
     */
    private static int parent(int i) {
        return (i-1)/2;
    }

}
