package AnimationLayout;

import javax.swing.JComponent;
import net.miginfocom.swing.MigLayout;

/**
 * Usado para animar la eliminación de un Item y SubItems, implementado en la
 * clase {@link ListaManipulador}.
 */
class UnD_AnimadorEliminacion {

    private int animationTime = 0;

    void setEliminacionAnimationTime(int milis) {
        this.animationTime = milis;
    }

    /**
     * Anima el desvanecimiento y la reducción de altura de un componente para
     * eliminarlo.
     *
     * @param layout El JComponent que contiene al componente a eliminar (debe
     * usar MigLayout).
     * @param componenteAEliminar El JComponent que se va a animar y eliminar.
     * @param onEnd La acción a ejecutar cuando la animación termina.
     */
    public void animarParaEliminar(JComponent layout, JComponent componenteAEliminar, Runnable onEnd) {
        if (!(layout.getLayout() instanceof MigLayout)) {
            System.err.println("AnimadorEliminacion requiere un MigLayout en el contenedor.");
            if (onEnd != null) {
                onEnd.run(); //Ejecutar el Runnable si no se puedo animar.
            }
            return;
        }

        final MigLayout migLayout = (MigLayout) layout.getLayout();
        final int alturaOriginal = componenteAEliminar.getPreferredSize().height;

        //Asegurarse de que el componente no sea opaco para que la transparencia funcione
        componenteAEliminar.setOpaque(false);
        //Se reutiliza la clase de animación Adapter con el animationFramework para animar el borrado de un Item - SubItem,
        //de esta manera solo usar los métodos que necesite y no implementarlos todo si se utilizara la clase Listener en lugar de Adapter.
        AnimationTiming anim = new AnimationTiming();
        anim.addEventAnimationTimingAdapter(new AnimationTimingAdapter() {
            @Override
            public void onAnimated(float animated) {
                //animated va de 0.0 a 1.0.
                float factor = 1.0f - animated; // va de 1.0 a 0.0

                //Animar la reducción de altura
                int nuevaAltura = (int) (alturaOriginal * factor);
                migLayout.setComponentConstraints(componenteAEliminar, "h " + Math.max(0, nuevaAltura) + "!, growx");

                //Animar la opacidad (se usará en el método paint del componente)
                componenteAEliminar.putClientProperty("anim.alpha", factor);

                layout.revalidate();
            }

            @Override
            public void onAnimatedEnded(boolean b) {//Se ejecuta una vez terminada la animación.
                if (onEnd != null) {
                    onEnd.run();
                }
            }

        });
        if (this.animationTime > 0) {
            anim.setAnimationTime(this.animationTime); // Duración de la animación en milisegundos
        }
        anim.animar();
    }

}
