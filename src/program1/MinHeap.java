package program1;

import java.util.ArrayList;

public class MinHeap<E extends Comparable<E>>
{
    //Need to use ArrayList
    //Modified tree structure : parent is (currentIndex -1 / 2)
    // Watch out for correct truncation
    private final Object lock = new Object();
    private ArrayList<ProcessNode> heap;

    /**
     * Constructor
     */
    public MinHeap()
    {
        heap = new ArrayList<ProcessNode>();
    }

    private void heapSort()
    {

    }

    /**
     * This function adds Process to the arrayList and performs a HeapSort
     * @param n The process node to be added
     */
    public void addProcessToHeap(ProcessNode n)
    {
        synchronized (lock)
        {
            heap.add(n);                // Put new value at the end
            int loc = heap.size()-1;    // and gets its location

            //Swap with parent until parent's priority not larger
            while (loc > 0 && heap.get(loc).m_priority < heap.get(parent(loc)).m_priority)
            {
                swap(heap, loc, parent(loc));
                loc = parent(loc);
            }
        }
    }




    public void removeProcessFromHeap(ProcessNode n)
    {
        synchronized (lock)
        {
            //remove process from the arrayList and perform a HeapSort
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
