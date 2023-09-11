package queue;

public abstract class BasicQueue {
    public abstract boolean isEmpty();

    public abstract Object getObject(Queue queue);

    public abstract Object head(Queue queue);

    public abstract Object take(Queue queue);
}
