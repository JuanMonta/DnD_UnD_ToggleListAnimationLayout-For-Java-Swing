package AnimationLayout;

import AnimationLayout.Components.SubItem_BlankComponent;
import AnimationLayout.Components.Item_BlankComponent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComponent;
import net.miginfocom.swing.MigLayout;
import java.awt.Container;
import java.io.Serializable;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

public class ToggleListAnimationLayout extends JComponent implements Serializable {

    /**
     * Donde se manipula las listas de los componentes Items y SubItems del
     * layout.
     */
    private final UnD_ListaManipulador listaManipulador;

    /**
     * Instancia que se usará para representar una copia de un Item que ayudará
     * con la ilusión de movimiento de los Items.
     */
    private final Item_BlankComponent item_Blank;
    /**
     * Instancia que se usará para representar una copia de un subItem que
     * ayudará con la ilusión de movimiento de los subItems.
     */
    private final SubItem_BlankComponent subItem_Blank;

    private int itemDragAndDropAnimationTime = 0;
    private int subItemDragAndDropAnimationTime = 0;

    public ToggleListAnimationLayout() {
        init();
        this.listaManipulador = new UnD_ListaManipulador();
        this.subItem_Blank = new SubItem_BlankComponent();
        this.item_Blank = new Item_BlankComponent();
        // Asigna el listener a todos los items/subitems
        setMovimientoListener(movimientoListener);
        setEliminacionListener(eliminacionListener);
    }

    private MigLayout layout;

    private void init() {
        setBackground(Color.WHITE);
        net.miginfocom.layout.LC lc = new net.miginfocom.layout.LC();
        layout = new MigLayout("wrap, fillx, inset 0, hidemode 1", "[fill]", "[top]0[]");
        setLayout(layout);
    }

    public MigLayout getMigLayout() {
        return layout;
    }

    private JScrollPane jScrollPaneLayoutContainer = null;

    public JScrollPane getjScrollPaneLayoutContainer() {
        if (this.jScrollPaneLayoutContainer == null) {
            Container contenedor = this.getParent();
            if (contenedor != null) {
                System.out.println("Está dentro de un contenedor: " + contenedor.getClass().getName());
                // Si se agrega a un JScrollPane, el contenedor inmediato suele ser un JViewport
                if (contenedor instanceof JViewport) {
                    Container padreDelViewport = contenedor.getParent();
                    if (padreDelViewport instanceof JScrollPane scroll) {
                        System.out.println("El componente está dentro de un JScrollPane: " + scroll.getClass().getName());
                        this.jScrollPaneLayoutContainer = scroll;
                    }
                }
            } else {
                //System.out.println("El componente no está contenido en ningún contenedor.");
            }
        }
        return jScrollPaneLayoutContainer;
    }

    @Override
    public synchronized Component add(Component comp) {
        Component com = super.add(comp);
        checkComponent(comp);
        return com;
    }

    /**
     * Obtener una lista de todos los Items en el layout.
     *
     * @return lista de items.
     */
    public synchronized List<Item> getListaItems() {
        List<Component> listaComponentes = Arrays.asList(this.getComponents());
        List<Item> listaItems = new ArrayList<>();
        for (Component comp : listaComponentes) {
            if (comp instanceof Item item) {
                listaItems.add(item);
            }
        }
        return listaItems;
    }

    /**
     * Tiempo de duración de la animación al mover hacia arriba o abajo un Item,
     * el valor debe ser mayor a cero, caso contrario se tomará el valor por
     * defecto de 350 milis.
     *
     * @param milis tiempo en milisegundos.
     */
    public void setItemUpDownAnimationTime(int milis) {
        this.listaManipulador.setRedimensionItemAnimationTime(milis);
    }

    /**
     * Tiempo de duración de la animación al mover hacia arriba o abajo un SubItem,
     * el valor debe ser mayor a cero, caso contrario se tomará el valor por
     * defecto de 350 milis.
     *
     * @param milis tiempo en milisegundos.
     */
    public void setSubItemUpDownAnimationTime(int milis) {
        this.listaManipulador.setRedimensionSubItemAnimationTime(milis);
    }
    /**
     * Tiempo de duración de la animación al eliminar un Item de la lista,
     * el valor debe ser mayor a cero, caso contrario se tomará el valor por
     * defecto de 350 milis.
     *
     * @param milis tiempo en milisegundos.
     */
    public void setItemDeleteAnimationTime(int milis) {
        this.listaManipulador.setEliminacionItemAnimationTime(milis);
    }
    /**
     * Tiempo de duración de la animación al eliminar un SubItem de la lista,
     * el valor debe ser mayor a cero, caso contrario se tomará el valor por
     * defecto de 350 milis.
     *
     * @param milis tiempo en milisegundos.
     */
    public void setSubItemDeleteAnimationTime(int milis) {
        this.listaManipulador.setEliminacionSubItemAnimationTime(milis);
    }

    /**
     * Tiempo que debe pasar para activar el drag and drop de los item, el valor
     * debe ser mayor a cero, caso contrario se tomará el valor por defecto de
     * 350 milis.
     *
     *
     * @param milis tiempo en milisegundos.
     */
    public synchronized void setItemDragAndDropAnimationTime(int milis) {
        this.itemDragAndDropAnimationTime = milis;
        for (Item item : this.getListaItems()) {
            item.setDragAndDropAnimationTime(milis);
        }
    }

    /**
     * Tiempo que debe pasar para activar el drag and drop de los subItems, el
     * valor debe ser mayor a cero, caso contrario se tomará el valor por
     * defecto de 350 milis.
     *
     * @param milis tiempo en milisegundos.
     */
    public synchronized void setSubItemDragAndDropAnimationTime(int milis) {
        this.subItemDragAndDropAnimationTime = milis;
        for (Item item : this.getListaItems()) {
            item.setDragAndDropAnimationTime(milis);
        }
    }

    /**
     * Mover directamente un item.
     *
     * @param itemParent el item a mover.
     * @param direction UP=-1 DOWN=1 valores de la clase
     * {@link UnD_MovimientoDireccion}
     */
    public synchronized void moverItem(Item itemParent, int direction) {
        List<Item> listaItems = this.getListaItems();
        if (listaItems != null && !listaItems.isEmpty() && listaItems.contains(itemParent)) {
            this.listaManipulador.moverItem(listaItems, listaItems.indexOf(itemParent), direction, true, this.item_Blank);
        }
    }

    /**
     * Mover directamente un subItem.
     *
     * @param itemParent item padre del subItem a mover.
     * @param subItemIndex indice dentro de la lista del Item padre del subItem
     * a mover.
     * @param direction UP=-1 DOWN=1
     */
    public synchronized void moverSubItem(Item itemParent, int subItemIndex, int direction) {
        List<Component> listaComponentes = Arrays.asList(this.getComponents());
        if (listaComponentes.contains(itemParent)) {
            if (!itemParent.getSubItems().isEmpty() && subItemIndex > -1 && subItemIndex < itemParent.getSubItemsCount()) {
                List<Item> listaItems = this.getListaItems();
                this.listaManipulador.moverSubItem(listaItems, listaItems.indexOf(itemParent), subItemIndex, direction, true, this.subItem_Blank);
            }
        }
    }
    //==========================================================================
    /**
     * Listener que se activa desde la clase Item e Item.SubItem, que servirá
     * para realizar los movimientos de los Items y SubItems.
     */
    private final UnD_MovimientoListener movimientoListener = new UnD_MovimientoListener() {
        @Override
        public void moverItem(Component item, int direccion) {
            List<Item> items = getListaItems();
            ToggleListAnimationLayout.this.listaManipulador.moverItem(items, items.indexOf(item), direccion, true, ToggleListAnimationLayout.this.item_Blank);
        }

        @Override
        public void moverSubItem(Component subItem, int direccion) {
            List<Item> items = getListaItems();
            int subItemIndex = -1;
            Item itemParent = null;
            for (Item item : items) {
                if (item.getSubItems().contains(subItem)) {
                    itemParent = item;
                    subItemIndex = item.getSubItems().indexOf(subItem);
                    break;
                }
            }
            if (subItemIndex > -1) {
                ToggleListAnimationLayout.this.listaManipulador.moverSubItem(items, items.indexOf(itemParent), subItemIndex, direccion, true, subItem_Blank);
            }
        }
    };

    /**
     * Se coloca la clase UnD_MovimientoListener en cada uno de los Items y
     * SubItems, que ayudará con el movimietnos de los Items y SubItems.
     *
     * @param listener
     */
    public void setMovimientoListener(UnD_MovimientoListener listener) {
        // Asigna a todos los items y subitems actuales
        List<Item> listaItems = this.getListaItems();
        if (listaItems != null) {
            for (Item item : listaItems) {
                item.setMovimientoListener(listener);
                for (Component sub : item.getSubItems()) {
                    if (sub instanceof Item.SubItem subItem) {
                        subItem.setMovimientoListener(listener);
                    }
                }
            }
        }
    }
    //==========================================================================
    /**
     * Listener que se activa desde la clase Item e Item.SubItem, que servirá
     * para realizar los movimientos de los Items y SubItems.
     */
    private final UnD_EliminacionListener eliminacionListener = new UnD_EliminacionListener() {
        @Override
        public void deleteItem(Item item) {
            ToggleListAnimationLayout.this.listaManipulador.eliminarItem(ToggleListAnimationLayout.this, item, () -> {
                ToggleListAnimationLayout.this.remove(item);
                for (Component subItem : item.getSubItems()) {
                    ToggleListAnimationLayout.this.remove(subItem);
                }
                ToggleListAnimationLayout.this.revalidate();
                ToggleListAnimationLayout.this.repaint();
                VerComponentes.verComponentes();
                System.out.println("Item " + item.getItemId() + " eliminado.");
            });
        }

        @Override
        public void deleteSubItem(Item.SubItem subItem) {
            Item parentItem = null;
            for (Item it : ToggleListAnimationLayout.this.getListaItems()) {
                if (it.getSubItems().contains(subItem)) {
                    parentItem = it;
                    break;
                }
            }
            if (parentItem == null) {
                System.out.println("No se pudo encontrar el item padre para el subitem " + subItem.getSubItemId());
                return;
            }
            final Item finalParentItem = parentItem;
            System.out.println("Petición para eliminar SubItem: " + subItem.getSubItemId() + " del Item: " + finalParentItem.getItemId());
            ToggleListAnimationLayout.this.listaManipulador.eliminarSubItem(ToggleListAnimationLayout.this, subItem, () -> {
                finalParentItem.getSubItems().remove(subItem);
                ToggleListAnimationLayout.this.remove(subItem);
                ToggleListAnimationLayout.this.revalidate();
                ToggleListAnimationLayout.this.repaint();
                VerComponentes.verComponentes();
                System.out.println("SubItem " + subItem.getSubItemId() + " eliminado.");
            });
        }
    };

    /**
     * Se coloca la clase UnD_EliminacionListener en cada uno de los Items y
     * SubItems, que ayudará con la eliminación de los Items y SubItems del
     * layout.
     *
     * @param listener
     */
    public void setEliminacionListener(UnD_EliminacionListener listener) {
        // Asigna a todos los items y subitems actuales
        List<Item> listaItems = this.getListaItems();
        if (listaItems != null) {
            for (Item item : listaItems) {
                item.setEliminacionListener(listener);
                for (Component sub : item.getSubItems()) {
                    if (sub instanceof Item.SubItem subItem) {
                        subItem.setEliminacionListener(listener);
                    }
                }
            }
        }
    }

    //==========================================================================
    /**
     * Colocar todos los componentes Items y SubItems en el layout en el orden
     * de la lista.
     *
     * @param items lista ordenada de Items y SubItems.
     */
    public synchronized void renderItems(List<Item> items) {
        removeAll();
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            item.setMovimientoListener(movimientoListener);
            item.setEliminacionListener(eliminacionListener);
            item.setToggleListLayout(this);
            if (this.itemDragAndDropAnimationTime > 0) {
                item.setDragAndDropAnimationTime(this.itemDragAndDropAnimationTime);
            }
            item.setItemIndex(i);
            item.itemAdded();
            this.add(item);
            if (item.getSubItems() != null) {
                boolean selected = item.getToggleList() != null && item.getToggleList().isShowing();
                for (Component subItem : item.getSubItems()) {
                    if (subItem instanceof Item.SubItem sub) {
                        sub.setMovimientoListener(movimientoListener);//Colocando el listener de movimiento para los Items y SubItems
                        sub.setEliminacionListener(eliminacionListener);//Colocando el listener de eliminación de los Items y SubItems
                        if (this.subItemDragAndDropAnimationTime > 0) {
                            sub.setDragAndDropAnimationTime(this.subItemDragAndDropAnimationTime);
                        }
                    }
                    if (selected) {
                        this.add(subItem);
                    } else {
                        //this.add(subItem, "gapleft 20, growx, h 0!");
                        this.add(subItem, "h 0!");
                    }
                }
            }
        }
        this.revalidate();
        this.repaint();
    }

    /**
     * Renderiza los items sin llamar a revalidate() o repaint(). Esto es útil
     * para preparar el layout para una animación sin causar un parpadeo. La
     * lógica de animación se encargará de llamar a revalidate() cuando esté
     * lista.
     *
     * @param items La lista de items a renderizar.
     */
    public synchronized void renderAnimatedItems(List<Item> items) {
        removeAll();
        for (Item item : items) {
            item.setMovimientoListener(movimientoListener);
            item.setEliminacionListener(eliminacionListener);
            item.setToggleListLayout(this);
            this.add(item);
            if (item.getSubItems() != null) {
                boolean selected = item.getToggleList() != null && item.getToggleList().isShowing();
                for (Component subItem : item.getSubItems()) {
                    if (subItem instanceof Item.SubItem sub) {
                        sub.setMovimientoListener(movimientoListener);
                        sub.setEliminacionListener(eliminacionListener);
                    }
                    this.add(subItem, selected ? "growx" : "h 0!");
                }
            }
        }
    }

    //CheckComponent ahora solo inicializa la relación layout, no añade ni pone restricciones a los componentes.
    private void checkComponent(Component comp) {
        if (comp instanceof Item) {
            Item item = (Item) comp;
            item.setToggleListLayout(this);
        }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        if (isOpaque()) {
            grphcs.setColor(getBackground());
            grphcs.fillRect(0, 0, getWidth(), getHeight());
        }
        super.paintComponent(grphcs);
    }

}
