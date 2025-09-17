package AnimationLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * Para extender a una clase JPanel para tomarlo como item en el layout
 * {@link ToggleListAnimationLayout}. Ejm: public class miPanel extends JPanel{}
 * -> public class miPanel extends Item{}
 */
public abstract class Item extends JPanel implements DnD_AnimationTimeCurrentValue {

    private UnD_MovimientoListener movimientoListener;
    private UnD_EliminacionListener eliminacionListener;
    private final DnD_Activar itemDragAndDropActivar;
    /**
     * Instancia de la clase que permite realizar la animación de mostrar u
     * ocultar los subItems del Item.
     */
    private ToggleList toggleList;

    /**
     * Listener colocado automáticamente por el ToggleAnimationLayout. No
     * actualizar.
     *
     * @param listener
     */
    public void setMovimientoListener(UnD_MovimientoListener listener) {
        this.movimientoListener = listener;
    }

    /**
     * Empezar el movimiento del item en la direcion propuesta.
     *
     * @param direccion UP=-1 o DOWN=1
     */
    public void moverItem(int direccion) {
        this.movimientoListener.moverItem(this, direccion);
    }

    /**
     * Listener colocado autompaticamente por el ToggleAnimationLayout. No
     * actualizar.
     *
     * @param listener
     */
    public void setEliminacionListener(UnD_EliminacionListener listener) {
        this.eliminacionListener = listener;
    }

    /**
     * Inicia la eliminación del item mediante una animación.
     */
    public void deleteItem() {
        //Listener que se agrega automáticamente por el ToggleAnimationLayout.
        if (eliminacionListener != null) {
            //Lanzar el metodo del listener para iniciar la eliminación del item.
            eliminacionListener.deleteItem(this);
        }
    }
    /**
     * Lista de subItems que contiene el Item en cuestion.
     */
    private final List<Item.SubItem> subItemsList;
    /**
     * Para colocarle un ID al Item. Default = ""
     */
    private String itemId = "", itemTitle = "", itemSubTitle = "", itemInfo01 = "", itemInfo02 = "", itemInfo03 = "";
    private int itemIndex = -1;

    public Item() {
        this.subItemsList = new ArrayList<>();
        this.toggleList = new ToggleList();
        this.itemDragAndDropActivar = new DnD_Activar(Item.this, this);
    }

    public int getItemIndex() {
        return itemIndex;
    }

    void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    /**
     * Colocar un ID para el item,
     *
     * @param itemId default "".
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * Obtener el ID asignado al Item.
     *
     * @return ID asignado, por default = "".
     */
    public String getItemId() {
        return itemId;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemSubTitle() {
        return itemSubTitle;
    }

    public void setItemSubTitle(String itemSubTitle) {
        this.itemSubTitle = itemSubTitle;
    }

    public String getItemInfo01() {
        return itemInfo01;
    }

    public void setItemInfo01(String itemInfo01) {
        this.itemInfo01 = itemInfo01;
    }

    public String getItemInfo02() {
        return itemInfo02;
    }

    public void setItemInfo02(String itemInfo02) {
        this.itemInfo02 = itemInfo02;
    }

    public String getItemInfo03() {
        return itemInfo03;
    }

    public void setItemInfo03(String itemInfo03) {
        this.itemInfo03 = itemInfo03;
    }

    /**
     * Clase donde se manejas los Items y SubItems
     */
    private static ToggleListAnimationLayout toggleListLayout;

    /**
     * Obtener la clase donde se manejan los Items y SubItems, Se asigna de
     * manera automática, no tocar.
     *
     * Principalmente aquí para las animaciones de mostrar u ocultar los
     * subItems del Item.
     *
     * @return
     */
    ToggleListAnimationLayout getToggleListLayout() {
        return Item.toggleListLayout;
    }

    /**
     * Obtener la clase que hace la función de mostrar u ocultar los subItems
     * del Item.
     *
     * @return
     */
    ToggleList getToggleList() {
        return this.toggleList;
    }

    public void toggleList() {
        this.getToggleList().setShowing(!this.getToggleList().isShowing(), true);
    }

    public void toggleList(boolean setShowing, boolean animated) {
        this.getToggleList().setShowing(setShowing, animated);
    }

    /**
     * Agregar un subItem al Item.
     *
     * @param subItem Item.SubItem a agregar a la lista.
     */
    public void addSubItem(Item.SubItem subItem) {
        subItem.setSubItemIndex(this.subItemsList.size());
        this.subItemsList.add(subItem);
        this.subItemAdded(subItem);
        subItem.onAdded();
    }

    /**
     * Agregar subItems al Item.
     *
     * @param subItems
     */
    public void addSubItems(List<Item.SubItem> subItems) {
        subItems.forEach(subItem -> {
            this.addSubItem(subItem);
        });
    }

    public void itemAdded() {

    }

    /**
     * Se lanza cada que un SubItem es agregado al Item.
     *
     * @param subItemAdded
     */
    public void subItemAdded(Item.SubItem subItemAdded) {
    }

    /**
     * Obtener la lista de los subItems del Item.
     *
     * @return Lista de subItems del Item.
     */
    public List<Component> getSubItems() {
        return (List<Component>) (List<?>) this.subItemsList;
    }

    /**
     * Obtener la cantidad de subItems del Item.
     *
     * @return numero de subitems del Item.
     */
    public int getSubItemsCount() {
        return this.subItemsList.size();
    }

    //##########################################################################
    //PARA LA ANIMACION DRAG AND DROP-------------------------------------------
    @Override
    public void dragAndDropAnimationTimeCurrentValue(float animatedVal) {

    }

    public void dragAndDropInit() {
        this.itemDragAndDropActivar.dragAndDropInit("ITEM");
    }

    public void dragAndDropCancel() {
        this.itemDragAndDropActivar.dragAndDropCancel();
    }

    public void dragAndDropMouseDragged(java.awt.event.MouseEvent mouseDraggedEvent) {
        this.itemDragAndDropActivar.setMouseDraggedOnItem(mouseDraggedEvent);

    }

    void setDragAndDropAnimationTime(int milis) {
        this.itemDragAndDropActivar.dragAndDropSetAnimationTime(milis);
    }


    //##########################################################################
    /**
     * Para animar ocultar o mostrar los subItems del Item desde ToggleList
     *
     * @param components Lista de subItems
     * @param animated valor de animacion desde ToggleList
     * @param selected determina si se oculta o se muestra los subItems del
     * Item.
     */
    void show(List<Component> components, float animated, boolean selected) {
        int width = (int) (100f * animated);
        int gap = (int) ((50 * (1f - (animated))));
        for (Component com : components) {
            int height = (int) (com.getPreferredSize().height * animated);
            getToggleListLayout().getMigLayout().setComponentConstraints(com, "h " + height + "!, w " + width + "%!, gap " + gap + "%! n 0px 0px");
            if (com instanceof Item) {
                Item item = (Item) com;
                if (item.getSubItems() != null) {
                    if ((!selected && item.getToggleList().isShowing()) || (selected && item.getToggleList().isShowing())) {
                        show(item.getSubItems(), animated, item.getToggleList().isShowing());
                    }
                }
            }
        }
        getToggleListLayout().revalidate();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        // Revisa la propiedad alpha establecida por el animador
        Object alphaValue = getClientProperty("anim.alpha");
        if (alphaValue instanceof Float) {
            float alpha = (Float) alphaValue;
            // Aplica la transparencia a todo el renderizado del componente
            g2d.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER, Math.max(0.0f, Math.min(1.0f, alpha))));
        }

        super.paint(g2d); // Pinta el fondo, borde e hijos con la transparencia

        g2d.setColor(new Color(230, 230, 230));
        g2d.drawLine(0, 0, 0, getHeight() - 1);
        g2d.drawLine(getWidth() - 1, 0, getWidth() - 1, getHeight() - 1);
        g2d.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
        g2d.dispose();
    }

    /**
     * Clase donde se manejan los Items y SubItems, Se asigna de manera
     * automática, no tocar. Principalmente aquí para las animaciones de mostrar
     * u ocultar los subItems del Item.
     *
     * @param toggleListLayout
     */
    void setToggleListLayout(ToggleListAnimationLayout toggleListLayout) {
        this.toggleListLayout = toggleListLayout;
        getToggleList().addToggleListListener(new ToggleListAdapter() {
            @Override
            public void onAnimated(float animated) {
                show(getSubItems(), animated, getToggleList().isShowing());
            }
        });
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        this.subItemsList.forEach(subItem -> {
            if (subItem instanceof SubItemBlank) {
                stringBuilder.append("[SubItem Blank ]");
            } else {
                stringBuilder.append("[SubItem ").append(subItem.subItemId).append("] ");
            }
        });
        return "Item" + this.itemId + "( " + stringBuilder + ")";
    }

    //##########################################################################
    /**
     * Para extender a una clase JPanel para tomarlo como subItem en el layout
     * {@link ToggleListAnimationLayout}. Ejm: public class miPanel extends
     * JPanel{} -> public class miPanel extends Item.SubItem{}
     */
    public abstract static class SubItem extends JPanel implements DnD_AnimationTimeCurrentValue {

        private UnD_MovimientoListener movimientoListener;
        private UnD_EliminacionListener eliminacionListener;
        private final DnD_Activar itemDragAndDropActivar;

        public SubItem() {
            this.itemDragAndDropActivar = new DnD_Activar(Item.SubItem.this, this);
        }

        /**
         * Obtener la clase donde se manejan los Items y SubItems, Se asigna de
         * manera automática, no tocar.
         *
         * Principalmente aquí para las animaciones de mostrar u ocultar los
         * subItems del Item.
         *
         * @return
         */
        ToggleListAnimationLayout getToggleListLayout() {
            return Item.toggleListLayout;
        }

        //##########################################################################
        //PARA LA ANIMACION DRAG AND DROP-------------------------------------------
        @Override
        public void dragAndDropAnimationTimeCurrentValue(float animatedVal) {

        }

        public void dragAndDropInit() {
            this.itemDragAndDropActivar.dragAndDropInit("SUBITEM");
        }

        public void dragAndDropCancel() {
            this.itemDragAndDropActivar.dragAndDropCancel();
        }

        public void dragAndDropMouseDragged(java.awt.event.MouseEvent mouseDraggedEvent) {
            this.itemDragAndDropActivar.setMouseDraggedOnItem(mouseDraggedEvent);
        }

        void setDragAndDropAnimationTime(int milis) {
            this.itemDragAndDropActivar.dragAndDropSetAnimationTime(milis);
        }

        //##########################################################################
        /**
         * Listener colocado autompaticamente por el
         * {@link ToggleListAnimationLayout}. No actualizar.
         *
         * @param listener
         */
        void setEliminacionListener(UnD_EliminacionListener listener) {
            this.eliminacionListener = listener;
        }

        /**
         * Inicia la eliminación del subItem mediante una animación.
         */
        public void deleteSubItem() {
            //Listener que se agrega automáticamente por el {@link ToggleListAnimationLayout}.
            if (eliminacionListener != null) {
                //Lanzar el metodo del listener para iniciar la eliminación del subItem.
                eliminacionListener.deleteSubItem(this);
            }
        }

        /**
         * Listener colocado autompaticamente por el
         * {@link ToggleListAnimationLayout}. No actualizar.
         *
         * @param listener
         */
        void setMovimientoListener(UnD_MovimientoListener listener) {
            this.movimientoListener = listener;
        }

        /**
         * Iniciar el movimiento del subItem del Item.
         *
         * @param direccion
         * {@link MovimientoDireccion#UP} {@link MovimientoDireccion#DOWN}
         */
        public void moverSubItem(int direccion) {
            //Lanzar el método del listener para iniciar el movimiento del subItem.
            this.movimientoListener.moverSubItem(this, direccion);
        }
        /**
         * Para colocarle un ID al subItem. Default = ""
         */
        private String subItemId = "", subItemTitle = "", subItemSubTitle = "", subItemInfo01 = "", subItemInfo02 = "", subItemInfo03 = "";
        private int subItemIndex = -1;

        public int getSubItemIndex() {
            return subItemIndex;
        }

        void setSubItemIndex(int subItemIndex) {
            this.subItemIndex = subItemIndex;
        }

        /**
         * Obtener el ID asignado al subItem.
         *
         * @return ID asignado, por default = ""
         */
        public String getSubItemId() {
            return subItemId;
        }

        /**
         * Colocar un ID para el subItem,
         *
         * @param subItemId ID asignado, default = ""
         */
        public void setSubItemId(String subItemId) {
            this.subItemId = subItemId;
        }

        public String getSubItemTitle() {
            return subItemTitle;
        }

        public void setSubItemTitle(String subItemTitle) {
            this.subItemTitle = subItemTitle;
        }

        public String getSubItemSubTitle() {
            return subItemSubTitle;
        }

        public void setSubItemSubTitle(String subItemSubTitle) {
            this.subItemSubTitle = subItemSubTitle;
        }

        public String getSubItemInfo01() {
            return subItemInfo01;
        }

        public void setSubItemInfo01(String subItemInfo01) {
            this.subItemInfo01 = subItemInfo01;
        }

        public String getSubItemInfo02() {
            return subItemInfo02;
        }

        public void setSubItemInfo02(String subItemInfo02) {
            this.subItemInfo02 = subItemInfo02;
        }

        public String getSubItemInfo03() {
            return subItemInfo03;
        }

        public void setSubItemInfo03(String subItemInfo03) {
            this.subItemInfo03 = subItemInfo03;
        }

        protected void onAdded() {

        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();

            // Revisa la propiedad alpha establecida por el animador
            Object alphaValue = getClientProperty("anim.alpha");
            if (alphaValue instanceof Float) {
                float alpha = (Float) alphaValue;
                // Aplica la transparencia a todo el renderizado del componente
                g2d.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER, Math.max(0.0f, Math.min(1.0f, alpha))));
            }

            super.paint(g2d); // Pinta el fondo, borde e hijos con la transparencia

            g2d.setColor(new Color(230, 230, 230));
            g2d.drawLine(0, 0, 0, getHeight() - 1);
            g2d.drawLine(getWidth() - 1, 0, getWidth() - 1, getHeight() - 1);
            g2d.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
            g2d.dispose();
        }

        @Override
        public String toString() {

            return "(SubItem " + this.subItemId + ")";
        }

    }
}
