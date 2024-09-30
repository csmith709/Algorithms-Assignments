package Assignment4;

// Charity Smith
// Assignment 4
// 30 Sept 2024
// SD10

public class DeleteFromList {

    // Deleting a node from a single list

    // if link doesn't exist
    // if deleting at the beginning
    // if deleting at the end
    // if deleting anywhere else
    
    private Node head;


    // Constructor to initialize the list
    public DeleteFromList() {
        this.head = null;
    }

    // Method to delete a node with a given value from the list
    public void deleteNode(int key) {
        // Case 1: if the list is empty
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Case 2: if the node to be deleted is at the head (beginning of the list)
        if (head.value == key) {
            head = head.next; // Move head to the next node
            System.out.println("Node with value " + key + " is deleted from the beginning.");
            return;
        }

        // Traverse the list to find the node to delete
        Node current = head;
        Node previous = null;

        // Case 3: if the node is at the end or middle
        while (current != null && current.value != key) {
            previous = current;
            current = current.next;
        }

        // If the node with the given value is not found
        if (current == null) {
            System.out.println("Node with value " + key + " is not found.");
            return;
        }

        // Case 4: If the node to be deleted is found and is the last node
        if (current.next == null) {
            previous.next = null;
            System.out.println("Node with value " + key + " is deleted from the end.");
        } else {
            // Deleting a node that is in the middle
            previous.next = current.next;
            System.out.println("Node with value " + key + " is deleted from the middle.");
        }
    }

    // Insert a new node at the end of the list (for testing)
    public void insertNode(int value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Print the list (for testing)
    public void printList() {
        Node current = head;
        if (current == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DeleteFromList list = new DeleteFromList();
        
        // Insert nodes into the list
        list.insertNode(10);
        list.insertNode(20);
        list.insertNode(30);
        list.insertNode(40);
        list.insertNode(50);

        // Print the list
        System.out.println("Original list:");
        list.printList();
        
        // Delete nodes
        // Beginning
        list.deleteNode(10);
        list.printList();

        // End
        list.deleteNode(50);
        list.printList();

        // Middle
        list.deleteNode(30);
        list.printList();

        // Node not found
        list.deleteNode(60);
        list.printList();
    }
}