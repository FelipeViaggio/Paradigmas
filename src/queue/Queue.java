package queue;

import java.util.ArrayList;

public class Queue {

    private int getPosition() {
        return this.queue.size() - 1;
    }

    static public String emptyQueueError = "Queue is empty";

    private final ArrayList<BasicQueue> queue = new ArrayList<>();

    public Queue(){
        this.queue.add(new EmptyQueue());
    }

    public boolean isEmpty() {
        return getState(getPosition()).isEmpty();
    }


    private BasicQueue getState(int position) {
        return (BasicQueue) this.queue.get(position);
    }

    public Queue add(Object newElement) {
        this.queue.add(new NotEmptyQueue(newElement));
        return this;
    }

    public Object take() {
        return getState(getPosition()).take(this);
    }

    public Object head() {
        return getState(getPosition()).head(this);
    }

    public Object error() {
        throw new Error( emptyQueueError );
    }

    public Object notEmptyhead() {
        return getState(1).getObject( this );
    }

    public Object notEmptytake() {
        Object firstElement = getState(1).getObject(this);
        this.queue.remove(1);
        return firstElement;
    }

    public int size() {
        return getPosition();
    }
}
