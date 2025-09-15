package AnimationLayout;

import java.util.ArrayList;
import java.util.List;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 * Utilizado para animar los subItems del {@link Item}, haciéndolos visibles u
 * ocultándolos.
 */
class ToggleList {

    /**
     * Valor del {@link ToggleList} para validar si los subItems están visibles.
     *
     * @return
     */
    public boolean isShowing() {
        return showing;
    }

    /**
     * Proceder con la animación que hace visibles u oculta los subItems del
     * Item.
     *
     * @param show true=mostrar subItems false=ocultar subItems.
     */
    public void setShowing(boolean show) {
        if (this.showing != show) {
            this.showing = show;
            if (show) {
                animate = 1f;
            } else {
                animate = 0;
            }
        }
    }

    /**
     * Proceder con la animación que hace visibles u oculta los subItems del
     * Item.
     *
     * @param show true=mostrar subItems false=ocultar subItems.
     * @param animated true=usar animación false=no usar animación.
     */
    public void setShowing(boolean show, boolean animated) {
        if (this.showing != show) {
            this.showing = show;
            runEventShowing();
            if (animated) {
                start(show);
            } else {
                if (show) {
                    animate = 1f;
                } else {
                    animate = 0;
                }

            }
        }
    }

    public void addToggleListListener(ToggleListListener event) {
        this.events.add(event);
    }
    
    public void removeToggleListListener(ToggleListListener event) {
        this.events.remove(event);
    }

    private Animator animator;
    private float animate;
    private boolean showing;
    private final List<ToggleListListener> events = new ArrayList<>();

    public ToggleList() {
        initAnimator();
    }

    /**
     * Inicializar todo lo necesario para las animaciones.
     */
    private void initAnimator() {
        animator = new Animator(350, new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (isShowing()) {
                    animate = fraction;
                } else {
                    animate = 1f - fraction;
                }
                runEventAnimated();
            }

            @Override
            public void end() {
                //System.out.println(".end()");
                runEventAnimatedEnded();
            }
        });
        animator.setResolution(5);
    }

    private void start(boolean selected) {
        if (animator.isRunning()) {
            float f = animator.getTimingFraction();
            animator.stop();
            animator.setStartFraction(1f - f);
        } else {
            animator.setStartFraction(0);
        }
        this.showing = selected;
        animator.start();
    }

    /**
     * Notificar cuando los SubItems de un Item se hacen visibles o se ocultan.
     */
    private void runEventShowing() {
        for (ToggleListListener event : new ArrayList<>(events)) {
            event.onShowing(showing);
        }
    }

    /**
     * Notificar el valor actual que tiene la animación en su duración cuando
     * los SubItems de un Items se vuelven visibles o se ocultan.
     */
    private void runEventAnimated() {
        for (ToggleListListener event : new ArrayList<>(events)) {
            event.onAnimated(animate);
        }
    }

    private void runEventAnimatedEnded() {
        for (ToggleListListener event : new ArrayList<>(events)) {
            event.onAnimatedEnded();
        }
    }
}
