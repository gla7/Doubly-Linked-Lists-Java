
public class DoublyLinkedList {
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
}
