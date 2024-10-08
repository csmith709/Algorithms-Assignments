package Assignment5;

public class MainApp {
    public static void main(String[] args) {
        UndoRedoManager<String> undoRedoManager = new UndoRedoManager<>();
        undoRedoManager.addState("State 1");
        undoRedoManager.addState("State 2");
        undoRedoManager.addState("State 3");
        undoRedoManager.addState("State 4");
        undoRedoManager.addState("State 5");
        undoRedoManager.addState("State 6");
        undoRedoManager.addState("State 7");

        // Accessing the current state using the public method
        System.out.println("Current State: " + undoRedoManager.getCurrentState());
        System.out.println("Undo: " + undoRedoManager.undo());
        System.out.println("Current State: " + undoRedoManager.getCurrentState());
        System.out.println("Redo: " + undoRedoManager.redo());
        System.out.println("Current State: " + undoRedoManager.getCurrentState());
    }
}
