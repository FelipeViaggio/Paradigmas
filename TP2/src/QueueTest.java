import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueueTest {

    private Queue queue = new Queue();
    @BeforeEach
    public void init() { this.queue = new Queue();}

    @Test
    public void test01QueueShouldBeEmptyWhenCreated() { assertTrue(queue.isEmpty());}

    @Test
    public void test02AddElementsToTheQueue() {
        assertFalse(queue.add(something()).isEmpty());
    }

    @Test
    public void test03AddedElementsIsAtHead() { assertEquals(something(), queue.add(something()).head()); }

    @Test
    public void test04TakeRemovesElementsFromTheQueue() {
        queue.add(something());
        queue.take();

        assertTrue(queue.isEmpty());
    }

    @Test
    public void test05TakeReturnsLastAddedObject() { assertEquals(something(), queue.add(something()).take()); }

    @Test
    public void test06QueueBehavesFIFO() {
        QueueWithFirstandSecondStrings();

        assertEquals(queue.take(), First());
        assertEquals(queue.take(), Second());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void test07HeadReturnsFirstAddedObject() {
        QueueWithFirstandSecondStrings();
        assertEquals(First(), queue.head());
    }

    @Test
    public void test08HeadDoesNotRemoveObjectFromQueue() {
        assertEquals(1, queue.add(something()).size());

        queue.head();

        assertEquals(1, queue.size());
    }

    @Test
    public void test09SizeRepresentsObjectInTheQueue() {
        assertEquals(2, QueueWithFirstandSecondStrings().size());
    }

    @Test
    public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
        assertEquals(Queue.EMPTY_QUEUE_ERROR, assertThrows( Error.class, () -> queue.take() ).getMessage());
    }

    @Test
    public void test11CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
        queue.add(something());
        queue.take();
        assertEquals(Queue.EMPTY_QUEUE_ERROR, assertThrows( Error.class, () -> queue.take() ).getMessage());
    }

    @Test
    public void test12CanNotHeadWhenThereAreNoObjectsInTheQueue() {
        assertEquals(Queue.EMPTY_QUEUE_ERROR, assertThrows( Error.class, () -> new Queue().head() ).getMessage());
    }
    private Queue QueueWithFirstandSecondStrings() {
        queue.add(First());
        queue.add(Second());
        return this.queue;
    }

    private String something(){return "Something";};
    private String First(){return "First";};
    private String Second(){return "Second";};



}
