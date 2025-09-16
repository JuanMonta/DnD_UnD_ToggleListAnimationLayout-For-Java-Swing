package AnimationLayout;

import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;


class DnD_ManipuladorItems extends DnD_MoveComponentAdapter {

    private ToggleListAnimationLayout toggleListAnimationLayout;
    private boolean dragReady = false;
    private int itemMoveIndex = -1;
    private int lastY = -1;
    private Component lastComponentInLayout = null;
    private ItemBlank item_Blank;
    private SubItemBlank subItem_Blank;
    private Component itemToClone;

    public DnD_ManipuladorItems() {
    }

    //##########################################################################
    @Override
    public void onDragItem(int indexItem, Item item, MouseEvent mouseEvent) {
        this.onDragInits(indexItem);
        if (mouseEvent != null) {
            this.handleDragMovement(mouseEvent);
        }
    }

    @Override
    public void onDragSubItem(int indexSubItem, Item.SubItem SubItem, MouseEvent mouseEvent) {
        this.onDragInits(indexSubItem);
        if (mouseEvent != null) {
            this.handleDragMovement(mouseEvent);
        }
    }

    @Override
    public void onDragEnded() {
        mouseRelease();
    }

    private void onDragInits(int index) {
        if (!this.dragReady) {
            this.dragReady = true;
            this.toggleListAnimationLayout.getMigLayout().setComponentConstraints(this.itemToClone, "h 0!");
            this.toggleListAnimationLayout.revalidate();
            this.itemMoveIndex = index;
            if (this.itemToClone instanceof Item) {
                this.toggleListAnimationLayout.add(this.item_Blank, this.itemMoveIndex);
            } else {
                this.toggleListAnimationLayout.add(this.subItem_Blank, this.itemMoveIndex);
            }
            this.toggleListAnimationLayout.revalidate();
            this.toggleListAnimationLayout.repaint();

        }
        if (verComponentes1 != null) {
            verComponentes1.verComponentes();
        }
    }

    public void clonarItemOSubItem(Component compToClone) {
        this.itemToClone = compToClone;
        this.lastComponentInLayout = null; // Reiniciar para el nuevo arrastre
        if (this.itemToClone instanceof Item item) {
            this.toggleListAnimationLayout = item.getToggleListLayout();
        } else if (itemToClone instanceof Item.SubItem subItem) {
            this.toggleListAnimationLayout = subItem.getToggleListLayout();
        }
        //creamos de igual forma las dimensiones para el item en blanco
        if (this.itemToClone instanceof Item) {

            this.item_Blank = new Item_BlankComponent();
            this.item_Blank.setPreferredSize(compToClone.getPreferredSize());
            this.item_Blank.setSize(compToClone.getSize());
            this.item_Blank.setMinimumSize(compToClone.getMinimumSize());
            this.item_Blank.setMaximumSize(compToClone.getMaximumSize());
            this.item_Blank.revalidate();
        } else if (this.itemToClone instanceof Item.SubItem) {
            this.subItem_Blank = new SubItem_BlankComponent();
            this.subItem_Blank.setPreferredSize(compToClone.getSize());
            this.subItem_Blank.setSize(compToClone.getSize());
            this.subItem_Blank.setMinimumSize(compToClone.getMinimumSize());
            this.subItem_Blank.setMaximumSize(compToClone.getSize());
        }

        //System.out.println("AnimationLayout.AnimateDragDrop.DnD_ManipuladorItems.clonarItemOSubItem() CLONADO ");
    }

    private void handleDragMovement(MouseEvent e) {
        if (!dragReady || this.toggleListAnimationLayout == null || e == null) {
            return;
        }
        String movimiento = "";
        final String moveUP = "ARRIBA";
        final String moveDOWN = "ABAJO";

        Point pointInLayout = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), this.toggleListAnimationLayout);
        if (this.lastY == -1) {
            this.lastY = pointInLayout.y;
        }
        if (pointInLayout.y < this.lastY) {
            movimiento = moveUP;
        } else if (pointInLayout.y > this.lastY) {
            movimiento = moveDOWN;
        } else {
            return;
        }
        if (pointInLayout.y <= 0) {
            pointInLayout.y = 0;
        }
        this.lastY = pointInLayout.y;
        Component componentInLayout = null;
        if (movimiento.equals(moveUP)) {
            componentInLayout = this.toggleListAnimationLayout.getComponentAt(pointInLayout);
        } else if (movimiento.equals(moveDOWN)) {
            /*System.out.println("AnimationLayout.AnimateDragDrop.DnD_ManipuladorItems.handleDragMovement() "
                    + " Min:" + this.itemToClone.getMinimumSize()
                    + " Max:" + this.itemToClone.getMaximumSize()
                    + " Pref:" + this.itemToClone.getPreferredSize()
                    + " Siz:" + this.itemToClone.getSize());*/
            //System.out.println("DnD_ManipuladorItems            itemH: " + itemToClone.getPreferredSize().height + " point.y: " + pointInLayout.y);
            pointInLayout.y += this.itemToClone.getPreferredSize().height;
            componentInLayout = this.toggleListAnimationLayout.getComponentAt(pointInLayout);
        } else {
            return;
        }

        /*System.out.println("DnD_ManipuladorItems "
                + " e: " + e.getPoint()
                + " pointLayout: " + pointInLayout.toString()
                + " hoverComponent: " + (componentInLayout != null ? componentInLayout.getLocation().toString() : "null ")
                + "move: " + movimiento);*/
        if (componentInLayout == null || componentInLayout == this.subItem_Blank || componentInLayout == this.item_Blank) {
            this.lastComponentInLayout = null;
            return;
        }
        if (componentInLayout == this.lastComponentInLayout) {
            return;
        }
        int componentInLayoutIndex = this.toggleListAnimationLayout.getComponentZOrder(componentInLayout);
        //System.out.println("AnimationLayout.AnimateDragDrop.DnD_ManipuladorItems.handleDragMovement() componentInLayoutIndex: " + componentInLayoutIndex + " CompInLayout: " + componentInLayout);
        if (componentInLayoutIndex == -1) {
            return;
        }

        // Si estamos arrastrando un SubItem, para evitar soltar el subItem fuera de un Item
        if (this.itemToClone instanceof Item.SubItem && componentInLayout instanceof Item && componentInLayoutIndex <=0) {
            return;
        }
        // Si estamos arrastrando un Item principal
        if (this.itemToClone instanceof Item && componentInLayout instanceof Item.SubItem) {
            return;
        }

        int blankIndex = -1;
        if (this.itemToClone instanceof Item) {
            blankIndex = this.toggleListAnimationLayout.getComponentZOrder(this.item_Blank);
        } else {
            blankIndex = this.toggleListAnimationLayout.getComponentZOrder(this.subItem_Blank);
        }

        Rectangle hoverBounds = componentInLayout.getBounds();
        //limite del 35% para moverse entre items o subItems
        double limite = hoverBounds.height * 0.35;
        boolean debeMoverse = false;

        if (componentInLayoutIndex > blankIndex) {
            if (pointInLayout.y >= hoverBounds.y + limite) {
                debeMoverse = true;
            }
        } else if (componentInLayoutIndex < blankIndex) {
            if (pointInLayout.y <= hoverBounds.y + hoverBounds.height - limite) {
                debeMoverse = true;
            }
        }
        if (debeMoverse) {
            this.lastComponentInLayout = componentInLayout;
            if (this.itemToClone instanceof Item) {
                this.toggleListAnimationLayout.remove(this.item_Blank);
                this.toggleListAnimationLayout.add(this.item_Blank, componentInLayoutIndex);
            } else {
                this.toggleListAnimationLayout.remove(this.subItem_Blank);
                this.toggleListAnimationLayout.add(this.subItem_Blank, componentInLayoutIndex);
            }
            this.itemMoveIndex = componentInLayoutIndex;
            this.toggleListAnimationLayout.revalidate();
            this.toggleListAnimationLayout.repaint();
            if (verComponentes1 != null) {
                verComponentes1.verComponentes();
            }
        }
    }

    private void mouseRelease() {
        this.lastComponentInLayout = null;
        if (this.dragReady) {
            this.toggleListAnimationLayout.add(this.itemToClone, this.itemMoveIndex);
            if (this.itemToClone instanceof Item) {
                this.toggleListAnimationLayout.remove(this.item_Blank);
            } else {
                this.toggleListAnimationLayout.remove(this.subItem_Blank);
            }

            this.toggleListAnimationLayout.getMigLayout().setComponentConstraints(this.itemToClone, "growx");
            this.toggleListAnimationLayout.revalidate();
            this.toggleListAnimationLayout.repaint();
            if (this.itemToClone instanceof Item) {
                this.ordenarItems();
            } else {
                this.ordenarSubitems();
            }

            this.dragReady = false;
            this.itemToClone = null;
            this.itemMoveIndex = -1;
            this.lastY = -1;
        }
        if (verComponentes1 != null) {
            verComponentes1.verComponentes();
        }
    }

    private synchronized void ordenarItems() {
        // Este método ahora solo inicia el proceso de ordenamiento.
        this.toggleListAnimationLayout.renderItems(this.toggleListAnimationLayout.getListaItems());
    }

    /**
     * Reconstruye la estructura de datos de Items y SubItems basándose en el
     * orden visual actual de los componentes en el layout, y luego renderiza el
     * layout para reflejar esta nueva estructura.
     */
    private synchronized void ordenarSubitems() {
        //Obtener todos los componentes de la lista
        Component[] components = this.toggleListAnimationLayout.getComponents();
        //Obtener todos los items para eliminar los subItem para poder reordenarlos
        List<Item> rootItems = this.toggleListAnimationLayout.getListaItems();
        if (rootItems == null) {
            return;
        }
        for (Item item : rootItems) {
            item.getSubItems().clear();
        }
        //Reconstruir la lista
        List<Item> listaNueva = new ArrayList<>();
        Item parentActual = null;

        for (Component comp : components) {
            if (comp instanceof Item) {
                //Si es un Item, añadirlo a la lista, se guarda en parentActual
                //para que sea identificable como padre del siguiente componente
                //si resulta ser un subItem
                parentActual = (Item) comp;
                listaNueva.add(parentActual);

            } else if (comp instanceof Item.SubItem) {
                Item.SubItem subItem = (Item.SubItem) comp;
                if (parentActual != null) {
                    //Se añade el subItem al item parentActual
                    parentActual.addSubItem(subItem);
                } else {
                    System.out.println("Error de ordenamiento: SubItem " + subItem + " no tiene un Item padre válido.");
                }
            }
        }
        this.toggleListAnimationLayout.renderItems(listaNueva);
    }

    //==========================================================================
    //Solo para ver en el JForm principal los componentes en un JList el orden de los componentes.
    private static verComponentes verComponentes1;

    public static void setVerComponentesInterface(verComponentes veComponentes) {
        verComponentes1 = veComponentes;
    }

    public static interface verComponentes {

        public void verComponentes();
    }

}
