package com.datastructure.ses2;

public class BLList<E> extends LList<E>
{
    @Override
    public void insert(E it)
    {
        this.prev();
        super.insert(it);
    }

    @Override
    public E remove()
    {
        this.prev();
        return super.remove();
    }
}