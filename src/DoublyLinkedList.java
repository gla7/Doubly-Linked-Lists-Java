
public class DoublyLinkedList {// here we modified the ordered insertion of new elements and also added a sort method analogous to insertion sort but it will be more performant on average
	private DoublyLinkedNode head;
	
	public void insertAtHead (int data) {
		DoublyLinkedNode newNode = new DoublyLinkedNode(data);
		newNode.setNextNode(this.head);
		if (this.head != null) {
			this.head.setPrevNode(newNode);
		}
		this.head = newNode;
	}
	
	public int length () {
		int length = 0;
		DoublyLinkedNode current = this.head;
		while (current != null) {
			current = current.getNextNode();
			length++;
		}
		return length;
	}

	public String toString() {
		String result = "{";
		DoublyLinkedNode current = this.head;
		
		while (current != null) {
			result = result + current.toString() + ", ";
			current = current.getNextNode();
		}
		result = result + "END}";
		return result;
	}
	
	public void deleteFromHead () {
		this.head = this.head.getNextNode();
	}
	
	public DoublyLinkedNode find (int searchingForThis) {
		DoublyLinkedNode current = this.head;
		while (current != null) {
			if (current.getData() == searchingForThis) {
				return current;
			}
			current = current.getNextNode();
		}
		return null;
	}
	
	public void insertNewElement (int data) {// slightly modified for doubly linked lists
		DoublyLinkedNode newNode = new DoublyLinkedNode(data);
		DoublyLinkedNode current = this.head;
		if (current == null) {
			this.insertAtHead(data);
		}
		while (current != null) {
			if (this.head == current) {
				if (current.getData() > newNode.getData()) {
					this.insertAtHead(data);
					break;
				} else if (current.getNextNode() == null) {
					current.setNextNode(newNode);
					newNode.setPrevNode(current);
					break;
				} 
			} else {
				if (current.getData() > newNode.getData()) {
					current.getPrevNode().setNextNode(newNode);
					newNode.setNextNode(current);
					newNode.setPrevNode(current.getPrevNode());
					current.setPrevNode(newNode);
					break;
				} else if (current.getNextNode() == null) {
					current.setNextNode(newNode);
					newNode.setPrevNode(current);
					break;
				} 
			}
			current = current.getNextNode();
		}
	}
	
//	public DoublyLinkedList sort () {// by using the insert method, we can create a new sorted linkedList from the unsorted one of complexity O(n^2) THERE IS A BETTER WAY!
//		DoublyLinkedNode current = this.head;
//		DoublyLinkedList returnList = new DoublyLinkedList();
//		while (current != null) {
//			if (current == this.head) {
//				returnList.insertAtHead(current.getData());
//			} else {
//				returnList.insertNewElement(current.getData());
//			}
//			current = current.getNextNode();
//		}
//		return returnList;
//	}
	
	public DoublyLinkedList sort () {// proper way of doing it
		DoublyLinkedNode current = this.head;// start @ head
		while (current != null) {// check that it aint null
			DoublyLinkedNode comparedTo = current.getPrevNode();
			while (comparedTo != null && (current.getData() < comparedTo.getData())) {// going down from current, when you see that current is greater than an item, it's time to put it in front of it
				comparedTo = comparedTo.getPrevNode(); // loop down until you hit the item that is less than current
			}
			DoublyLinkedNode next = current.getNextNode();// declare the original next node from current
			if (comparedTo != null || current != this.head) {// if current is not null or not the head
				current.getPrevNode().setNextNode(next); //have his old previous get current's next rather than current
				if (next != null) {// if the original next from current aint null
					next.setPrevNode(current.getPrevNode());// have it connect its previous to current's original previous
				}
				current.setPrevNode(comparedTo);// have current previous connect to comparedTo
			}
			
			if (comparedTo == null) {// if comparedTo is null
				if (current != this.head) {// and if current aint the head
					current.setNextNode(this.head); // have the head be current's next node
					current.getNextNode().setPrevNode(current);// and have the previous head's previous be current
					this.insertAtHead(current.getData());// declare current as head
				}
			} else { // if comparedTo is not null, though
				current.setNextNode(comparedTo.getNextNode());// set current's next node to comparedTo's old next
				comparedTo.getNextNode().setPrevNode(current);// have comparedTo's old next to have his previous be current
				comparedTo.setNextNode(current);// and finally have comparedTo's next be current
			}
			current = next;
		}
		return this;
	}

}
