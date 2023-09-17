public class EmptyQueue extends BasicQueue {


    public boolean isEmpty() {
        return true;
    }

    public Object head (Queue queue) {
        return queue.error();
    }

    public Object take (Queue queue) {
        return queue.error();
    }
}

