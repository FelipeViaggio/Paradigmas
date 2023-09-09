package queue;

public class Queue {
	private int usedcapacity = 0;

	private Object[] elements = new Object[10];
	public boolean isEmpty() {

		return usedcapacity == 0;
	}

	public Queue add( Object newElement ) {
		if (usedcapacity < capacity()){
			elements[usedcapacity] = newElement;
			usedcapacity++;
		} else {
			System.out.println("Queue is full");
		}
		return this;
	}

	private int capacity() {
		return elements.length;
	}

	public Object take() {
		if (isEmpty()){
			throw new Error("Queue is empty");
		} else {
			Object firstElement = elements[0];
			moveforward(0);

			return firstElement;
		}
	}

	private void moveforward(int index) {
		if (index < usedcapacity){
			elements[index] = elements[index + 1];
			moveforward(index + 1);
		} else {
			elements[usedcapacity - 1] = null;
			usedcapacity--;
		}
	}


	public Object head() {
		if (!isEmpty()){
			return elements[0];
		} else {
			throw new Error("Queue is empty");
		}
	}

	public int size() {
		return usedcapacity;
	}

}