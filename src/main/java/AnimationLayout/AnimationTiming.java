package AnimationLayout;

import java.util.ArrayList;
import java.util.List;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 * Usado en las clases {@link AnimadorEliminacion} {@link AnimadorRedimension}
 * sobre los Items y SubItems para crear animaciones de expansión, ocultación y
 * eliminación.
 *
 */
class AnimationTiming {

    private Animator animator;
    private float animate;
    private final List<AnimationTimingListener> events = new ArrayList<>();
    private int animationTime = 350;
    private int animationRepeatCount = 1;

    public AnimationTiming() {
        this.initAnimator();
    }

    /**
     * Determinar el comportamiento de la animación con repeticiones.
     */
    public static class ComportamientoOnRepeat {
        /**
         * HOLD - valores de 0.0 a 1.0 y se repite desde cero.
         */
        public static final String HOLD = "HOLD";
        /**
         * REVERSE - valores de 0.0 a 1.0 y luego en reversa 1.0 a 0.0
         */
        public static final String REVERSE = "REVERSE";
    }

    /**
     * Iniciar la animación.
     */
    public void animar() {
        this.setFade(true, true);
    }

    private void setFade(boolean ocultar, boolean animated) {
        if (!this.animator.isRunning()) {
            if (animated) {
                animator.start();
            } else {
                if (ocultar) {
                    animate = 1f;
                } else {
                    animate = 0;
                }

            }
        }
    }

    /**
     * Añade a una lista el AnimationTimingListener, no reemplaza.
     *
     * @param event
     */
    public void addEventAnimationTimingAdapter(AnimationTimingListener event) {
        this.events.add(event);
    }

    /**
     * Tiempo en milis, el valor debe ser mayor a cero, caso contrario se tomará
     * el valor por defecto de 350 milis.
     *
     * @param milis
     */
    public void setAnimationTime(int milis) {
        if (milis > 0) {
            this.animationTime = milis;
            this.initAnimator();
        }
    }

    public boolean isAnimatorRunnning() {
        return this.animator.isRunning();
    }

    private boolean animationStop = false;

    /**
     * Para detener la animación si se estpá ejecutando.
     */
    public void animatorStop() {
        this.animationStop = true;
        this.animator.stop();
    }

    /**
     * Las veces que en animator se repetirá, por defecto se lanzará solo una
     * vez.
     *
     * @param animationRepeatCount valores mayores a cero. Si es cero o menor a
     * cero se establecerá a 1 por defecto.
     * org.jdesktop.animation.timing.Animator.INFINITE public static final int
     * INFINITE = -1 Se utiliza para especificar una duración interminable o
     * repetirCount
     */
    public void setAnimationRepeatCount(int animationRepeatCount) {
        if (animationRepeatCount < -1) {
            animationRepeatCount = -1;
        }
        if (org.jdesktop.animation.timing.Animator.INFINITE == animationRepeatCount) {
            this.animationRepeatCount = animationRepeatCount;
        } else {
            this.animationRepeatCount = animationRepeatCount <= 0 ? 1 : animationRepeatCount;
        }
        this.initAnimator();
    }

    /**
     * REVERSE - valores de 0.0 a 1.0 y luego en reversa 1.0 a 0.0 , HOLD -
     * valores de 0.0 a 1.0 y se repite desde cero. Por defecto es HOLD.
     *
     * @param onRepeatBehavior
     */
    public void setAnimationComportamientoOnRepeat(Animator.RepeatBehavior onRepeatBehavior) {
        animator.setRepeatBehavior(onRepeatBehavior);
    }

    /**
     * Instancia todo lo necesario para el animador para usarse con los Items y
     * SubItems como ocultar, redimensionar y eliminar.
     */
    private void initAnimator() {
        int animationRepeatC = this.animationRepeatCount > 0 ? this.animationRepeatCount : this.animationRepeatCount * -1;
        //Para que concuerde la duración de la animación junto con el número de repeticiones, de esta manera
        //no importa cuantas repeticiones se le coloque, siempre durará lo que dicta la duración de la animación.
        animator = new Animator(this.animationTime / animationRepeatC, new TimingTargetAdapter() {
            /**
             * Inicia la animación del AnimationFramework.
             */
            @Override
            public void begin() {
                runEventAnimatedStarted();
            }

            /**
             * Se lanza cada que AnimationFramework actualiza los valores que
             * van de 1.0 a 0.0 ó 0.0 a 1.0.
             */
            @Override
            public void timingEvent(float fraction) {
                animate = fraction;
                runEventAnimated();
                //System.out.println(AnimationTiming.this.getClass().getName() + "-> timingEvent: animate " + animate + " fraction " + fraction);
            }

            /**
             * Se lanza cada que el
             * {@link TimingTargetAdapter#timingEvent(float)} completa el
             * recorrido de los valores 1.0 a 0.0 ó 0.0 a 1.0, dictando así el
             * comienzo de la(s) repetición(es).
             */
            @Override
            public void repeat() {
                runEventAnimatedRepeated();
            }

            /**
             * Se lanza cuando el {@link TimingTargetAdapter#timingEvent(float)}
             * y si existen repeticion para que se lanze
             * {@link TimingTargetAdapter#repeat()} hayan terminado.
             */
            @Override
            public void end() {
                if (AnimationTiming.this.animationStop == false) {
                    //Notificamos al listener que el Animator ha terminado.
                    runEventAnimatedEnded();
                }
                AnimationTiming.this.animationStop = false;
            }

        });
        animator.setResolution(5);
        //numero de repeticiones del animator
        animator.setRepeatCount(animationRepeatC);

    }

    /**
     * Notificar al listener el inicio de la animación.
     */
    private void runEventAnimatedStarted() {
        for (AnimationTimingListener event : events) {
            event.onAnimatedStarted(true);
        }
    }

    /**
     * Notificar al listener el valor que tine la fracción 1.0 a 0.0 ó 0.0 a 1.0
     * en la animación.
     */
    private void runEventAnimated() {
        for (AnimationTimingListener event : events) {
            event.onAnimated(animate);
        }
    }

    /**
     * Notificar al listener que la animación a terminado.
     */
    private void runEventAnimatedEnded() {
        for (AnimationTimingListener event : events) {
            event.onAnimatedEnded(true);
        }
    }

    /**
     * Notificar al listener cada que la animación se vuelve a repetir.
     */
    private void runEventAnimatedRepeated() {
        for (AnimationTimingListener event : events) {
            event.onAnimatedRepeated(true);
        }
    }

}
