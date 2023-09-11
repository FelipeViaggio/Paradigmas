package queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    static public String emptyQueueError = "Queue is empty";

    private List queue = new ArrayList<Object> ();

    private BasicQueue elements = new EmptyQueue();

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public Queue add(String newElement) {
        this.queue.add(newElement);
        this.elements = new NotEmptyQueue();
        return this;
    }

    public int size() {
        return queue.size();
    }

    public Object take() {
        return elements.take( this );
    }

    public Object head() {
        return elements.head( this );
    }

    public Object error() {
        throw new Error( emptyQueueError );
    }

    public Object notEmptyhead() {

        return this.queue.get(0);
    }

    public Object notEmptytake() {
        return this.queue.remove(0);
    }
}