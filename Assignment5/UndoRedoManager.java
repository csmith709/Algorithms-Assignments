package Assignment5;

public class UndoRedoManager<T> {
    private class Node {
        private T state;
        private Node prev;
        private Node next;
        private Node(T state) {
            this.state = state;
        }
    }

    private Node currentState;

    // Undo operation
    public T undo() {
        if (currentState == null) {
            System.out.println("No state to undo");
            return null;
        }

        Node previousState = currentState.prev;
        if (previousState == null) {
            System.out.println("No state to undo");
            return null;
        } else {
            currentState = previousState;
        }
        return currentState.state;
    }

    // Perform an operation
    public void addState(T newState) {
        Node newNode = new Node(newState);
        newNode.prev = currentState;
        newNode.next = null;

        if (currentState != null) {
            currentState.next = newNode;
        }
        currentState = newNode;
    }

    // Redo operation
    public T redo() {
        if (currentState == null) {
            System.out.println("No state to redo");
            return null;
        }

        Node nextState = currentState.next;
        if (nextState == null) {
            System.out.println("No state to redo");
            return null;
        } else {
            currentState = nextState;
        }
        return currentState.state;
    }
}
