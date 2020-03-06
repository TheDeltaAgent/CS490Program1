package program1;

import java.util.ArrayList;

public class MinHeap <E extends Comparable<E>>
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

    private void heapify(int heapTop) //top is min value
    {
        int leftChildIndex = (heapTop * 2) + 1;
        int rightChildIndex = (heapTop * 2) + 2;
        int swapIndex;

        //Check to see if 2 children exist
        if(rightChildIndex < m_heap.size() )
        {
            //Find highest priority child (lowest number)
            if (m_heap.get(leftChildIndex).m_priority <= m_heap.get(rightChildIndex).m_priority)
                swapIndex = leftChildIndex;

            //Right child is higher priority (Lower number)
            else
                swapIndex = rightChildIndex;

            //Compare highest p child with parent
            if (m_heap.get(swapIndex).m_priority < m_heap.get(heapTop).m_priority)
            {
                //If true then swap and sort.
                swap(m_heap, swapIndex, heapTop);
                heapify(swapIndex);

                //Else, do nothing.
            }

        }
        //Check if only left child exists
        else if(leftChildIndex < m_heap.size())
        {
            //Check if Parent is higher priority (lowest number) than left child.
            if (m_heap.get(leftChildIndex).m_priority <= m_heap.get(heapTop).m_priority)
            {
                swapIndex = leftChildIndex;
                swap(m_heap, swapIndex, heapTop);
                heapify(swapIndex);

            }
        }

        //Else Process is a leaf node and heapify is finished.




    }

    private void checkHeap()
    {
        //Check that all parents are smaller than children.
        for(int i = 0; i < m_heap.size(); i++)
        {
            System.out.print(m_heap.get(i).m_priority);
        }
        System.out.println("\n");
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
                heapify(0);
                checkHeap();
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
