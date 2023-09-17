public class NotEmptyQueue extends BasicQueue {

    public Object object;
    public NotEmptyQueue(Object object) {
        this.object = object;
    }

    public boolean isEmpty() {
        return false;
    }

    public Object take(Queue queue) {
        return queue.take();
    }

    public Object head(Queue queue) {
        return object;
    }
}
