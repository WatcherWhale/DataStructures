package sem3.datastructures.ses6;

import java.util.Collection;

public interface IQueue<E>
{
        void enqueue(E it);
        void enqueue(E[] arr);
        void enqueue(Collection<E> list);
        E dequeue();
        int length();
        boolean IsEmpty();
        boolean IsFull();
        void Clear();
}
