package program1;

public class ProcessNode
{
    public static Integer m_processID;
    public Integer m_priority;
    public Long m_timeSlice;         //amount of time the consumer thread sleeps (in milliseconds)

    //Overloaded Constructor
    public ProcessNode(Integer procID, Integer priorityLvl, Long time)
    {
        m_processID = procID;
        m_priority = priorityLvl;
        m_timeSlice = time;
    }
}
