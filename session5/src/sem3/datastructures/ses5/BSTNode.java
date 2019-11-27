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

        // Calculate left height
        if(this.left != null)
            leftHeight = this.left.height();

        // Calculate right height
        if(this.right != null)
            rightHeight = this.right.height();

        // Check which length is the biggest and return it
        // Add one to add the current node
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

    public void levelOrder()
    {
        // Create queue/linkedlist (has interface Queue)
        LinkedList<BSTNode<Key, E>> q = new LinkedList<>();
        // Add the current element
        q.add(this);

        // While the queue is not empty add an element
        while (!q.isEmpty())
        {
            // Get the element on top and remove it
            BSTNode<Key, E> node = q.poll();
            // If the node is null continue to the next element in the queue
            if(node == null) continue;

            // If the element exists print its value
            System.out.print(node.element().toString() + " ");

            // Add the left and right node (can be null)
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
        // Type check
        if(key instanceof Integer)
        {
            // Check if the key of the new element is bigger or smaller than the key of this node
            if((int)key < (int)this.key)
            {
                // If the left node is not empty call the insert method from the left node
                // Else create a new left node
                if(this.left != null)
                    this.left.insert(key,value);
                else
                    this.setLeft(new BSTNode<>(key,value));
            }
            else
            {
                // If the right node is not empty call the insert method from the right node
                // Else create a new right node
                if(this.right != null)
                    this.right.insert(key,value);
                else
                    this.setRight(new BSTNode<>(key,value));
            }
        }
    }
}

