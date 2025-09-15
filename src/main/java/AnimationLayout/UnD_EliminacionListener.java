package AnimationLayout;

/**
 * Listener para notificar que se eliminará un componente que es instancia de
 * {@link Item} y @link Item.SubItem} del layout, usado en
 * {@link ToggleListAnimationLayout} que asignará éste listener a cada uno de
 * los componentes Items - SubItems agregados en el layout de manera automática
 * usando {@link Item#setEliminacionListener(Utils.EliminacionListener)} y
 * {@link Item.SubItem#setEliminacionListener(Utils.EliminacionListener)}.
 */
public interface UnD_EliminacionListener {
    /**
     * Notificar que se debe eliminar el Item que corresponda.
     * @param item Item a eliminar.
     */
    void deleteItem(Item item);
    /**
     * Notificar que se debe eliminar el SubItem que corresponda.
     * @param subItem SubItem a eliminar.
     */
    void deleteSubItem(Item.SubItem subItem);
}
