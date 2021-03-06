package program1;

/**
 * This class represents a process that will be generated by the producer, stored in the MinHeap, and consumed by the consumers.
 * @author Ethan McNabb
 * @author Bradley Bowen
 */
public class ProcessNode
{
    public Integer m_processID;
    public Integer m_priority;
    public Long m_timeSlice;

    /**
     * Overloaded constructor
     * @param procID Unique ID determined by order of creation in respect to other processes.
     * @param priorityLvl 0-9 with the highest priority being 0.
     * @param time amount of time the consumer thread sleeps (in milliseconds)
     */
    public ProcessNode(Integer procID, Integer priorityLvl, Long time)
    {
        m_processID = procID;
        m_priority = priorityLvl;
        m_timeSlice = time;
    }
}
