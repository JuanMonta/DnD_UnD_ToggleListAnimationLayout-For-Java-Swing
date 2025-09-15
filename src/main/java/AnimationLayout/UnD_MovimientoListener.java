package AnimationLayout;

import java.awt.Component;

/**
 * Interface para escuchar y ejecutar movimientos de los Items y SubItems desde
 * los componentes que implementan {@link Item} {@link Item.SubItem}.
 */
public interface UnD_MovimientoListener {

    /**
     * Notificar el inicio del movimiento de un Item.
     *
     * @param item el Item a mover.
     * @param direccion dirección en la que se moverá,
     * {@link MovimientoDireccion#UP} {@link MovimientoDireccion#DOWN}
     */
    void moverItem(Component item, int direccion);

    /**
     * Notificar el inicio del movimientos de un SubItem.
     *
     * @param subItem el Item a mover.
     * @param direccion dirección en la que se moverá,
     * {@link MovimientoDireccion#UP} {@link MovimientoDireccion#DOWN}
     */
    void moverSubItem(Component subItem, int direccion);
}
