package AnimationLayout;

/**
 * Notifica las acciones de hacer visibles u ocultar los SubItems de un Item.
 * Implementado en {@link ToggleList}
 */
public interface ToggleListListener {

    /**
     * Notifica cada que los SubItems de un Item se vuelven visibles o se
     * ocultan.
     *
     * @param show
     */
    public void onShowing(boolean show);

    /**
     * El valor actual que tiene la animación en su duración cuando los SubItems
     * de un Items se vuelven visibles o se ocultan.
     *
     * @param animated
     */
    public void onAnimated(float animated);

    /**
     * Notifica cuando la animación de mostrar u ocultar los subitems ha
     * terminado.
     */
    public void onAnimatedEnded();
}
