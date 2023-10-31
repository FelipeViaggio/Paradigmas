import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueueTest {
    private Queue queue = new Queue();
    @BeforeEach
    public void init() {
        this.queue = new Queue();
    }

    @Test
    public void test01QueueShouldBeEmptyWhenCreated() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void test02AddElementsToTheQueue() {
        assertFalse(queue.add(StringSomething()).isEmpty());
    }

    @Test
    public void test03AddedElementsIsAtHead() {
        assertEquals(StringSomething(),
                queue.add(StringSomething()).head());
    }

    @Test
    public void test04TakeRemovesElementsFromTheQueue() {
        queue.add(StringSomething());
        queue.take();

        assertTrue(queue.isEmpty());
    }

    @Test
    public void test05TakeReturnsLastAddedObject() {
        assertEquals(StringSomething(),
                queue.add(StringSomething()).take());
    }

    @Test
    public void test06QueueBehavesFIFO() {
        QueueWithFirstandSecondStrings();

        assertEquals(queue.take(), StringFirst());
        assertEquals(queue.take(), StringSecond());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void test07HeadReturnsFirstAddedObject() {
        QueueWithFirstandSecondStrings();
        assertEquals(StringFirst(), queue.head());
    }

    @Test
    public void test08HeadDoesNotRemoveObjectFromQueue() {
        assertEquals(1, queue.add(StringSomething()).size());

        queue.head();

        assertEquals(1, queue.size());
    }

    @Test
    public void test09SizeRepresentsObjectInTheQueue() {
        assertEquals(2, QueueWithFirstandSecondStrings().size());
    }

    @Test
    public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
        assertThrowsLike(Queue.EMPTY_QUEUE_ERROR, () -> queue.take());
    }

    @Test
    public void test11CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
        queue.add(StringSomething());
        queue.take();
        assertThrowsLike(Queue.EMPTY_QUEUE_ERROR, () -> queue.take());
    }

    @Test
    public void test12CanNotHeadWhenThereAreNoObjectsInTheQueue() {
        assertThrowsLike(Queue.EMPTY_QUEUE_ERROR, () -> queue.head());
    }

    private Queue QueueWithFirstandSecondStrings() {
        queue.add(StringFirst());
        queue.add(StringSecond());
        return this.queue;
    }

    private void assertThrowsLike(String expectedErrorMessage, Executable toBeEvaluated) {
        assertEquals(expectedErrorMessage, assertThrows(Error.class, toBeEvaluated).getMessage());
    }

    private String StringSomething() {
        return "Something";
    }

    private String StringFirst() {
        return "First";
    }

    private String StringSecond() {
        return "Second";
    }
}
