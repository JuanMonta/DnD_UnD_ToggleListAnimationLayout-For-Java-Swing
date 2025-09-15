package AnimationLayout;

import java.awt.event.MouseEvent;

public interface DnD_MoveComponentListener {

    public void onDragItem(int indexItem, Item item, MouseEvent compMousePressed);

    public void onDragSubItem(int indexSubItem, Item.SubItem SubItem, MouseEvent compMousePressed);
    
    public void onDragSubItem(Item parent, int indexSubItem, Item.SubItem SubItem, MouseEvent compMousePressed);

    public void onDragEnded();
}
