package Server;
import java.util.ArrayList;
import java.util.List;

public class Processor extends Thread {

    private long id;
    private int currentTimeStamp;
    private List<Integer> timeStamps = new ArrayList<Integer>();

    public long getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentTimeStamp() {
        return currentTimeStamp;
    }

    public void setCurrentTimeStamp(int currentTimeStamp) {
        this.currentTimeStamp = currentTimeStamp;
    }

    public Processor(int id, int currentTimeStamp) {
        this.id = id;
        this.currentTimeStamp = currentTimeStamp;
    }

    public void run() {
        timeStamps.add(currentTimeStamp);
        System.out.println("Processor " + id + " is running");
    }

    public void printTimeStamps() {
        System.out.println("Time stamps of processor: " + id);
        System.out.println(timeStamps.toString());
    }

    public void sendMessage() {
        this.currentTimeStamp++;
        timeStamps.add(currentTimeStamp);
    }

    public void receiveMessage(Event event) {
        if (event.getFromProcessId() != event.getToProcessId()) {
            if(event.getTimeStamp() >= this.currentTimeStamp) {
                Byzantine byzantine = new Byzantine();
                boolean error = byzantine.byzantineError();
                if(error) {
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("Byzantine error occured while receiving the message in processor: " + event.getToProcessId());
                    System.out.println("----------------------------------------------------------------------");
                }
                else                 
                    this.currentTimeStamp = event.getTimeStamp() + 1;
            }
            timeStamps.add(currentTimeStamp);
        }
    }
}
