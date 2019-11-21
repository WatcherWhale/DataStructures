/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sem3.datastructures.ses5;

/**
 * Source code example for "A Practical Introduction to Data
 * Structures and Algorithm Analysis, 3rd Edition (Java)"
 * by Clifford A. Shaffer
 * Copyright 2008-2011 by Clifford A. Shaffer
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class BSTNode<Key, E> implements BinNode<E>
{
    private Key key;              // Key for this node
    private E element;            // Element for this node
    private BSTNode<Key, E> left;  // Pointer to left child
    private BSTNode<Key, E> right; // Pointer to right child

    /**
     * Constructors
     */
    public BSTNode()
    {
        left = right = null;
    }

    public BSTNode(Key k, E val)
    {
        left = right = null;
        key = k;
        element = val;
    }

    public BSTNode(Key k, E val,
                   BSTNode<Key, E> l, BSTNode<Key, E> r)
    {
        left = l;
        right = r;
        key = k;
        element = val;
    }

    /**
     * Get and set the key value
     */
    public Key key()
    {
        return key;
    }

    public void setKey(Key k)
    {
        key = k;
    }

    /**
     * Get and set the element value
     */
    public E element()
    {
        return element;
    }

    public void setElement(E v)
    {
        element = v;
    }

    /**
     * Get and set the left child
     */
    public BSTNode<Key, E> left()
    {
        return left;
    }

    public void setLeft(BSTNode<Key, E> p)
    {
        left = p;
    }

    /**
     * Get and set the right child
     */
    public BSTNode<Key, E> right()
    {
        return right;
    }

    public void setRight(BSTNode<Key, E> p)
    {
        right = p;
    }

    /**
     * @return True if a leaf node, false otherwise
     */
    public boolean isLeaf()
    {
        return (left == null) && (right == null);
    }

    public int height()
    {
        int leftHeight = 0;
        int rightHeight = 0;

        if(this.left != null)
            leftHeight = this.left.height();
        if(this.right != null)
            rightHeight = this.right.height();

        if(leftHeight > rightHeight)
            return leftHeight + 1;
        else
            return rightHeight + 1;
    }

    public void preOrder(boolean isRoot)
    {
        if(isRoot) System.out.print("<");

        System.out.print(" " + this.element.toString());
        if(this.left != null) this.left.preOrder(false);
        if(this.right != null) this.right.preOrder(false);

        if(isRoot) System.out.print(" >\n");
    }

    public void inOrder(boolean isRoot)
    {
        if(isRoot) System.out.print("<");

        if(this.left != null) this.left.inOrder(false);
        System.out.print(" " + this.element.toString());
        if(this.right != null) this.right.inOrder(false);

        if(isRoot) System.out.print(" >\n");
    }

    public void postOrder(boolean isRoot)
    {
        if(isRoot) System.out.print("<");

        if(this.left != null) this.left.postOrder(false);
        if(this.right != null) this.right.postOrder(false);
        System.out.print(" " + this.element.toString());

        if(isRoot) System.out.print(" >\n");
    }

    public void levelOrderSlow()
    {
        ArrayList<BSTNode<Key, E>> top = new ArrayList<>();
        ArrayList<BSTNode<Key, E>> bottom = new ArrayList<>();

        bottom.add(this);

        do
        {
            top = bottom;
            bottom = new ArrayList<>();

            for(int i = 0; i < top.size(); i++)
            {
                if(top.get(i) == null) continue;

                System.out.print(top.get(i).element().toString() + " ");

                bottom.add(top.get(i).left());
                bottom.add(top.get(i).right());
            }

            System.out.print("\n");
        }
        while(bottom.size() != 0);
    }

    public void levelOrder()
    {
        LinkedList<BSTNode<Key, E>> q = new LinkedList<>();
        q.add(this);

        while (!q.isEmpty())
        {
            BSTNode<Key, E> node = q.poll();
            if(node == null) continue;

            System.out.print(node.element().toString() + " ");

            q.add(node.left);
            q.add(node.right);
        }
    }

    public void insert(Key key)
    {
        this.insert(key, (E)key);
    }

    public void insert(Key key, E value)
    {
        if(key instanceof Integer)
        {
            if((int)key < (int)this.key)
            {
                if(this.left != null)
                    this.left.insert(key,value);
                else
                    this.setLeft(new BSTNode<>(key,value));
            }
            else
            {
                if(this.right != null)
                    this.right.insert(key,value);
                else
                    this.setRight(new BSTNode<>(key,value));
            }
        }
    }
}

