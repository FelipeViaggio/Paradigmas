import java.util.ArrayList;

public class Queue {

    private int getLastIndexingQueue() {
        return this.queue.size() - 1;
    }

    static public String emptyQueueError = "Queue is empty";

    private ArrayList<BasicQueue> queue = new ArrayList<>();

    public Queue(){
        this.queue.add(new EmptyQueue());
    }

    public boolean isEmpty() {
        return getState().isEmpty();
    }


    private BasicQueue getState() {
        return (BasicQueue) this.queue.get(getLastIndexingQueue());
    }

    public Queue add(Object newElement) {
        this.queue.add(new NotEmptyQueue(newElement));
        return this;
    }

    public Object take() {
        BasicQueue state = getState();
        Object firstElement = state.head(this);
        this.queue.remove(getLastIndexingQueue());
        return firstElement;
    }

    public Object head() {
        return getState().head(this);
    }

    public Object error() {
        throw new Error( emptyQueueError );
    }

    public int size() {
        return getLastIndexingQueue();
    }
}
