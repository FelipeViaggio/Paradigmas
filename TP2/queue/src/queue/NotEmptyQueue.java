package queue;


public class NotEmptyQueue extends BasicQueue {

    @Override
    public Object take2(Queue queue) {
    return queue.isEmpty() ? queue.error() : queue.take();
    }

    @Override
    public Object head2(Queue queue) {
        return queue.head();
    }
}