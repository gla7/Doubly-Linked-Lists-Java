
public class DoublyLinkedListDemo {

	public static void main(String[] args) {
		DoublyLinkedList orderedList = new DoublyLinkedList();
		
		orderedList.insertAtHead(10);
		orderedList.insertAtHead(8);
		orderedList.insertAtHead(6);
		orderedList.insertAtHead(4);
		orderedList.insertAtHead(2);
		
		System.out.println(orderedList);
		
		orderedList.insertNewElement(1);
		orderedList.insertNewElement(3);
		orderedList.insertNewElement(5);
		orderedList.insertNewElement(7);
		orderedList.insertNewElement(9);
		
		System.out.println(orderedList);
		
		DoublyLinkedList orderedList2 = new DoublyLinkedList();
		
		orderedList2.insertNewElement(50);
		
		System.out.println(orderedList2);
		
		orderedList2.insertNewElement(49);
		
		System.out.println(orderedList2);
		
		orderedList2.insertNewElement(4);
		orderedList2.insertNewElement(3);
		orderedList2.insertNewElement(1);
		orderedList2.insertNewElement(67);
		orderedList2.insertNewElement(65);
		orderedList2.insertNewElement(88);
		
		System.out.println(orderedList2);
	}

}
