package Server;
public class Event {
    
    private int eventNo;

    private long fromProcessId;
    private long toProcessId;
    private String message;
    private int timeStamp;

    public int getEventNo() {
        return eventNo;
    }

    public void setEventNo(int eventNo) {
        this.eventNo = eventNo;
    }

    public long getFromProcessId() {
        return fromProcessId;
    }

    public void setFromProcessId(long fromProcessId) {
        this.fromProcessId = fromProcessId;
    }

    public long getToProcessId() {
        return toProcessId;
    }

    public void setToProcessId(long toProcessId) {
        this.toProcessId = toProcessId;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Event(int eventNo, long fromProcessId, long toProcessId, int timeStamp) {
        this.eventNo = eventNo;
        this.fromProcessId = fromProcessId;
        this.toProcessId = toProcessId;
        this.timeStamp = timeStamp;
    }

    public void printEvent(Event event) {
        event.message = fromProcessId == toProcessId ? "Internal task of " + fromProcessId : "Message sent from " + fromProcessId + " to " + toProcessId;
        System.out.println("Event " + event.eventNo + ": " + event.message + ", Time Stamp: " + event.timeStamp);
    }
}
