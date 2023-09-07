package queue;

import java.util.ArrayList;
import java.util.List;

public class Queue<queuethings> {
	private final List<queuethings> elements = new ArrayList<>();

	public boolean isEmpty() {
		return elements.isEmpty();
	}

	public Queue<queuethings> add(queuethings newElement) {
		elements.add(newElement);
		return this;
	}

	public queuethings take() {
		if (isEmpty()) {
			throw new Error("Queue is empty");
		} else {
			queuethings firstElement = elements.get(0);
			elements.remove(0);
			return firstElement;
		}
	}

	public int size() {
		return elements.size();
	}

	public queuethings head() {
		if (isEmpty()) {
			throw new Error("Queue is empty");
		} else {
			return elements.get(0);
		}
	}
}