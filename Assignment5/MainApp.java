package Assignment5;

public class MainApp {
    public static void main(String[] args) {
        // Create an instance of UndoRedoManager
        UndoRedoManager<String> undoRedoManager = new UndoRedoManager<>();

        // Add states to the manager
        undoRedoManager.addState("State 1");
        undoRedoManager.addState("State 2");
        undoRedoManager.addState("State 3");
        undoRedoManager.addState("State 4");
        undoRedoManager.addState("State 5");
        undoRedoManager.addState("State 6");
        undoRedoManager.addState("State 7");

        // Output current state
        System.out.println("Current State: " + undoRedoManager.currentState.state);

        // Undo a few times
        System.out.println("Undo: " + undoRedoManager.undo());
        System.out.println("Current State: " + undoRedoManager.currentState.state);

        // Redo once
        System.out.println("Redo: " + undoRedoManager.redo());
        System.out.println("Current State: " + undoRedoManager.currentState.state);
    }
}
