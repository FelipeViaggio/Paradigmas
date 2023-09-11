package queue;

public class NotEmptyQueue extends BasicQueue {

    public Object object;
    public NotEmptyQueue(Object object) {
        this.object = object;
    }

    public Object getObject(Queue queue) {
        return this.object;
    }

    public boolean isEmpty() {
        return false;
    }

    public Object take(Queue queue) {
        return queue.notEmptytake();
    }

    public Object head(Queue queue) {
        return queue.notEmptyhead();
    }
}
