public class input extends Thread{

    private String processID;
    private long burstTime;
    private int processPriority;

    // Constructor
    public input(String processID, long burstTime, int processPriority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.processPriority = processPriority;
    }

    // Getters
    // Getting burstTime
    public long getBurstTime() {
        return burstTime;
    }

    // Getting Priority
    public int getProcessPriority() {
        return processPriority;
    }

    // Setters
    // Setting burstTime
    public void setBurstTime(long burstTime) {
        this.burstTime = burstTime;
    }

    // Showing data store in string instead of unreadable output
    public String toString() {
        return "Process ID: " + processID + " Burst Time: " + burstTime + " Priority: " + processPriority;
    }

    // This simulates the process of running for burstTime until the scheduler interrupts it
    @Override
    public void run() {
        try {
            Thread.sleep(burstTime);
        } catch (InterruptedException e) {
            // interrupted by scheduler (quantum expired)
        }
    }
}
