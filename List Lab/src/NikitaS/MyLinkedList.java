package NikitaS;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T>{

	private Node<T> head;
	private int size = 0;

	public int getSize() {
		return size;
	}

	public boolean remove(int index) {
		//Set both initial nodes to be head.
		if (size ==0){
			return false;
		}
		size--;
		Node<T> nextNode= head;
		Node<T> previousNode=head; //To avoid null exceptions
		for (int i=0;i<index;i++) { //Use "<" because the 0th index is not the head, but the node the head is pointing to.
			previousNode= nextNode;//Keep track of previous node. On the first iteration it will remain head.
			nextNode = nextNode.getNext(); //Get current node's reference to next node.
		}
		Node<T> newTarget = nextNode.getNext(); //Get the nextNode reference of the node to be removed.
		previousNode.setNext(newTarget); //Set that new reference to the node that came before the previous one.
		return true;

	}

	public T get(int index) {
		Node<T> returnedNode = head;
		for (int i = 0; i <index ; i++) {
			returnedNode = returnedNode.getNext();
		}
		return returnedNode.getData();
	}

	public void add(T obj) {
		size++;
		if (head==null){
			head = new Node<T>(obj);
		}else {
			Node<T> modifiedNode;
			Node<T> nextNode = head;
			while (nextNode != null) {
				modifiedNode = nextNode;
				nextNode = modifiedNode.getNext();
				if (nextNode == null) { //As soon as we find a null reference that means we reached end of list.
					Node<T> lastNode = new Node<>(obj);//Create new node
					modifiedNode.setNext(lastNode);//Add reference from previously last node pointing to new last node.
					break;
				}
			}
		}
	}

	//The methods below are bonus

	public void add(int index, T obj){
		size++;
		Node<T> replacedNode = head;
		Node<T> previousNode;
		for (int i = 0; i <index ; i++) {
			previousNode = replacedNode;
			replacedNode = replacedNode.getNext();
			if (i == index-1){
				Node<T> insertedNode = new Node<T>(obj,replacedNode);//Create a new node
				previousNode.setNext(insertedNode); //Change the reference of previous node to be pointing to the newly created node.
			}
		}
		//to-do
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator<T>(head);
	}

	private class MyIterator<T> implements Iterator<T> {

		private Node<T> node;

		public MyIterator(Node<T> node) {
			//to-do
		}
		@Override
		public boolean hasNext() {
			//to-do
			return false;
		}

		@Override
		public T next() {
			//to-do
			return null;
		}

		@Override
		public void remove() {
			// to-do

		}

	}
}
