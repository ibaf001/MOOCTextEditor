package textgen;

import java.util.AbstractList;




/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		this.size = 0;
		head = new LLNode(null);
		tail = new LLNode(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		LLNode<E> newest = new LLNode(element);
		(tail.prev).next = newest;
		newest.prev = tail.prev;
		newest.next = tail;
		tail.prev = newest;
		size++;
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if(index < 0 || index >= size)throw new IndexOutOfBoundsException("the index is out of bounds");
		LLNode<E> current = head.next;
		int n = 0;
        while(n < index){
        	current = current.next;
        	n++;
        }
		return current.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		LLNode<E> nouveau = new LLNode<E>(element);
	    LLNode<E> current = head.next;
		int n = 0;
        while(n != index){
        	current = current.next;
        	n++;
        }
        nouveau.prev = current.prev;
        (current.prev).next = nouveau;
        nouveau.next = current;
        size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index < 0 || index >= size)throw new IndexOutOfBoundsException("the index is out of bounds");
	    LLNode<E> current = head.next;
		int n = 0;
        while(n != index){
        	current = current.next;
        	n++;
        }
        LLNode<E> toRemove = current;
        (current.prev).next = current.next;
        (current.next).prev = current.prev;
        /*
        nouveau.prev = current.prev;
        (current.prev).next = nouveau;
        nouveau.next = current; */
        size--;
		return current.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(index < 0 || index >= size)throw new IndexOutOfBoundsException("the index is out of bounds");
	    LLNode<E> current = head.next;
		int n = 0;
        while(n != index){
        	current = current.next;
        	n++;
        }
        E replaced = current.data;
        current.data = element;

		return replaced;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
