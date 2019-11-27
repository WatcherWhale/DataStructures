package sem3.datastructures.ses6;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class QueueTest
{
    @Test
    public void TestCreation()
    {
        Queue<Integer> q = new Queue<>(5);

        assertEquals(q.length(), 0);
    }

    @Test
    public void TestEnDeQueue()
    {
        Queue<Integer> q = new Queue<>(5);

        assertNull(q.dequeue());
        q.enqueue(1);
        q.enqueue(2);

        assertEquals((int)q.dequeue(), 1);
        assertEquals((int)q.dequeue(), 2);
        assertNull(q.dequeue());

        q.Clear();

        q.enqueue(new Integer[] {1,2,3,4,5,6,7});
        assertEquals((int)q.dequeue(), 6);
        assertEquals((int)q.dequeue(), 7);
        assertNull(q.dequeue());

        q.Clear();

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 7; i++)
            list.add(i);

        q.enqueue(list);

        assertEquals((int)q.dequeue(), 6);
        assertEquals((int)q.dequeue(), 7);
        assertNull(q.dequeue());
    }

    @Test
    public void TestLengthClear()
    {
        Queue<Integer> q = new Queue<>(5);
        q.enqueue(new Integer[] {1,2,3,4});

        assertEquals(q.length(), 4);
        assertEquals(q.actualLength(), 4);

        q.enqueue(new Integer[] {5,6,7,8});
        assertEquals(q.length(), 3);
        assertEquals(q.actualLength(), 8);

        q.Clear();
        assertEquals(q.length(), 0);
        assertEquals(q.actualLength(), 0);
    }
}
