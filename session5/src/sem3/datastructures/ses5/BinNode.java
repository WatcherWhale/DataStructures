/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sem3.datastructures.ses5;

/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

/** ADT for binary tree nodes */
public interface BinNode<E> {
  /** Get and set the element value */
  public E element();
  public void setElement(E v);

  /** @return The left child */
  public BinNode<E> left();

  /** @return The right child */
  public BinNode<E> right();

  /** @return True if a leaf node, false otherwise */
  public boolean isLeaf();
}

