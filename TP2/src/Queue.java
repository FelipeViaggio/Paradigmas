import java.util.ArrayList;

public class Queue {
    static public String emptyQueueError = "Queue is empty";
    private ArrayList<BasicQueue> queue = new ArrayList<>();

    public Queue(){ this.queue.add(new EmptyQueue()); }
    public boolean isEmpty() { return getLastState().isEmpty(); }

    public Queue add(Object newElement) {
        this.queue.remove(size());
        this.queue.add(new NotEmptyQueue(newElement));
        this.queue.add(new EmptyQueue());
        return this;
    }

    public Object take() {
        BasicQueue state = getLastState();
        Object firstElement = state.head(this);
        this.queue.remove(0);
        return firstElement;
    }

    public Object head() { return getLastState().head(this); }

    public Object error() { throw new Error( emptyQueueError ); }

    public int size() { return this.queue.size() - 1; }

    private BasicQueue getLastState() { return (BasicQueue) this.queue.get(0); }
}