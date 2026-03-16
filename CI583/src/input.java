public class input {

    private static String processID;
    private static int burstTime;
    private static int priority;

    // Constructor
    public input(String processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.priority = priority;
    }

    // Getters
    public static String getProcessID() {
        return processID;
    }

    public static int getBurstTime() {
        return burstTime;
    }

    public static int getPriority() {
        return priority;
    }

    // Setters
    public void setProcessID(String processID) {
        this.processID = processID;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String toString() {
        return "Process ID: " + processID + " Burst Time: " + burstTime + " Priority: " + priority;
    }
}
