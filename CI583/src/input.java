public class input extends Thread{

    private String processID;
    private int burstTime;
    private int processPriority;

    // Constructor
    public input(String processID, int burstTime, int processPriority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.processPriority = processPriority;
    }

    // Getters
    public String getProcessID() {
        return processID;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getProcessPriority() {
        return processPriority;
    }

    // Setters
    public void setProcessID(String processID) {
        this.processID = processID;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public void setProcessPriority(int processPriority) {
        this.processPriority = processPriority;
    }

    public String toString() {
        return "Process ID: " + processID + " Burst Time: " + burstTime + " Priority: " + processPriority;
    }
}
