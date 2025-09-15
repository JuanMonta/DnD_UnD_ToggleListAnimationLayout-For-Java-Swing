package AnimationLayout;

import java.awt.event.MouseEvent;

public abstract class DnD_MoveComponentAdapter implements DnD_MoveComponentListener {

    @Override
    public void onDragItem(int indexItem, Item item, MouseEvent compMousePressed) {
    }

    @Override
    public void onDragSubItem(int indexSubItem, Item.SubItem SubItem, MouseEvent compMousePressed) {
    }

    @Override
    public void onDragSubItem(Item parent, int indexSubItem, Item.SubItem SubItem, MouseEvent compMousePressed) {
    }

    @Override
    public void onDragEnded() {
    }

}
