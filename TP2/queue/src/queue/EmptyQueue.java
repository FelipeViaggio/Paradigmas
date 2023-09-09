package queue;

public class EmptyQueue extends BasicQueue {

    @Override
    public Object head2 (Queue queue) {
        return queue.error();
    }

    @Override
    public Object take2 (Queue queue) {
        return queue.error();
    }
}
