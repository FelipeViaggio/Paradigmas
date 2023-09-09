package queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	static public String emptyQueueError = "Queue is empty";

	private final List queue = new ArrayList();

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
		return this.queue.remove(0);
	}

	public Object take2() {
		return elements.take2( this );
	}

	public Object head() {

		return this.queue.get(0);
	}
}