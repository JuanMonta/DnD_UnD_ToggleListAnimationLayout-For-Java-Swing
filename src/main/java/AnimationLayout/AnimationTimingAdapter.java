package AnimationLayout;

/**
 * Adaptador creado para implementar los métodos de la clase
 * {@link AnimationTimingListener} para que los métodos del listener se puedan
 * usar solo los que se necesiten.
 */
public abstract class AnimationTimingAdapter implements AnimationTimingListener {

    /**
     * Notificar el inicio de la animación.
     *
     * @param started true
     */
    @Override
    public void onAnimatedStarted(boolean started) {

    }

    /**
     * Notificar el valor que tine la fracción 1.0 a 0.0 ó 0.0 a 1.0 en la
     * animación.
     *
     * @param animated
     */
    @Override
    public void onAnimated(float animated) {
    }

    /**
     * Notificar que la animación a terminado.
     *
     * @param ended true=finalizado
     */
    @Override
    public void onAnimatedEnded(boolean ended) {

    }

    /**
     * Notificar al listener cada que la animación se vuelve a repetir.
     *
     * @param repeated true= se ha repetido
     */
    @Override
    public void onAnimatedRepeated(boolean repeated) {

    }

}
