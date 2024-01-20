package events;

import listeners.DragAndDropListener;

public class DragAndDropEventHandler implements DragAndDropListener {
    @Override
    public void draggedChildBoxOnTopOfParentBox() {
        System.out.println("Dragged child box on top of parent box \n");
    }

    @Override
    public void draggedBackChildBoxFromTopOfParentBox() {
        System.out.println("Dragged back child box from top of parent box \n");
    }
}
