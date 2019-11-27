package sem3.datastructures.ses6;

import java.util.Collection;

public class Queue<E> implements IQueue<E>
{
    private E[] _arr;
    private int _size = 0;
    private int _actualSize = 0;
    private int _maxSize = 0;

    public Queue(int size)
    {
        this._arr = (E[])new Object[size];
        this._size = 0;
        this._actualSize = 0;
        this._maxSize = size;
    }

    @Override
    public void enqueue(E it)
    {
        this._arr[this._actualSize % this._maxSize] = it;

        this._actualSize++;
        this._size = this._actualSize % this._maxSize;
    }

    @Override
    public void enqueue(E[] it)
    {
        for(int i = 0; i < it.length; i++)
        {
            this.enqueue(it[i]);
        }
    }

    @Override
    public void enqueue(Collection<E> it)
    {
        for(int i = 0; i < it.size(); i++)
        {
            this.enqueue((E)it.toArray()[i]);
        }
    }

    @Override
    public E dequeue()
    {
        if(this._size == 0 && this._actualSize == 0)
            return null;

        E outp = this._arr[0];

        for(int i = 1; i < this._size; i++)
        {
            this._arr[i-1] = this._arr[i];
        }

        this._actualSize--;
        this._size--;

        if(this._size == 0)
        {
            this._actualSize = 0;
            this.Clear();
        }


        return outp;
    }

    @Override
    public int length()
    {
        return this._size;
    }

    public int actualLength()
    {
        return this._actualSize;
    }

    @Override
    public boolean IsEmpty()
    {
        return this._size == 0;
    }

    @Override
    public boolean IsFull()
    {
        return this._size == this._maxSize;
    }

    @Override
    public void Clear()
    {
        for(int i = 0; i < this._size; i++)
        {
            this._arr[0] = null;
        }

        this._size = 0;
        this._actualSize = 0;
    }
}
