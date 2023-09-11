package queue;

public class EmptyQueue extends BasicQueue {

    @Override
    public Object head (Queue queue) {
        return queue.error();
    }

    @Override
    public Object take (Queue queue) {
        return queue.error();
    }
}

