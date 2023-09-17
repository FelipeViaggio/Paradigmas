import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueueTest {
    public static String SOMETHING = "Something";
    public static String FIRST = "First";
    public static String SECOND = "Second";

    @Test
    public void test01QueueShouldBeEmptyWhenCreated() {
        assertTrue(new Queue().isEmpty());
    }

    @Test
    public void test02AddElementsToTheQueue() {
        assertFalse(new Queue().add(SOMETHING).isEmpty());
    }

    @Test
    public void test03AddedElementsIsAtHead() {
        assertEquals(SOMETHING, new Queue().add(SOMETHING).head());
    }

    @Test
    public void test04TakeRemovesElementsFromTheQueue() {
        Queue queue = new Queue().add(SOMETHING);
        queue.take();

        assertTrue(queue.isEmpty());
    }

    @Test
    public void test05TakeReturnsLastAddedObject() {
        assertEquals(SOMETHING, new Queue().add(SOMETHING).take());
    }

    @Test
    public void test06QueueBehavesFIFO() {
        Queue queue = new Queue();

        queue.add(FIRST);
        queue.add(SECOND);

        assertEquals(queue.take(), FIRST);
        assertEquals(queue.take(), SECOND);
        assertTrue(queue.isEmpty());
    }

    @Test
    public void test07HeadReturnsFirstAddedObject() {
        assertEquals(new Queue().add(FIRST).add(SECOND).head(), FIRST);
    }

    @Test
    public void test08HeadDoesNotRemoveObjectFromQueue() {
        Queue queue = new Queue();

        assertEquals(1, queue.add(SOMETHING).size());

        queue.head();

        assertEquals(1, queue.size());
    }

    @Test
    public void test09SizeRepresentsObjectInTheQueue() {
        assertEquals(2, new Queue().add(FIRST).add(SECOND).size());
    }

    @Test
    public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
        assertEquals(Queue.emptyQueueError, assertThrows( Error.class, () -> new Queue().take() ).getMessage());
    }

    @Test
    public void test11CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
        Queue queue = new Queue();

        queue.add(SOMETHING);
        queue.take();

        assertEquals(Queue.emptyQueueError, assertThrows( Error.class, () -> queue.take() ).getMessage());
    }

    @Test
    public void test12CanNotHeadWhenThereAreNoObjectsInTheQueue() {
        assertEquals(Queue.emptyQueueError, assertThrows( Error.class, () -> new Queue().head() ).getMessage());
    }
}