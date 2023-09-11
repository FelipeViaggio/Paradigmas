package queue;

public class NotEmptyQueue extends BasicQueue {

    @Override
    public Object take(Queue queue) {
        return queue.isEmpty() ? queue.error() : queue.notEmptytake();
    }

    @Override
    public Object head(Queue queue) {
        return queue.notEmptyhead();
    }
}
