package AnimationLayout;

import java.awt.Component;
import javax.swing.JComponent;
import net.miginfocom.swing.MigLayout;


/**
 * Usado para animar una expansión o reducción Items{@link Item} -
 * SubItems{@link Item.SubItem} en conjunto con su respectivo
 * Item{@link ItemBlank} - SubItem{@link SubItemBlank} en blanco, implementado
 * en la clase {@link ListaManipulador}.
 */
 class UnD_AnimadorRedimension {

    /**
     * Anima el cambio de tamaño de altura entre dos componentes, generalmente
     * los Items{@link Item} - SubItems{@link Item.SubItem} y su respectivo
     * Item{@link ItemBlank} - SubItem{@link SubItemBlank} en blanco.
     *
     * @param layout El layout donde están los componentes.
     * @param componenteReducir El componente que se va a reducir, por lo
     * general, el Item - SubItem en blanco.
     * @param componenteExpandir El componente que se va a expandir por ejemplo,
     * el subitem real de cual se sacó la foto del Item - SubItem en blanco.
     * @param alturaFinal Altura final del componente expandido, tomado la
     * altura que tiene antes de animar.
     * @param animateComponentMoving Animar cuando todos los subItems son
     * visibles.
     * @param onEnd Acción a ejecutar al finalizar la animación, puede ser null.
     */
    public void animarRedimension(
            JComponent layout,
            Component componenteReducir,
            Component componenteExpandir,
            int alturaFinal,
            boolean animateComponentMoving,
            Runnable onEnd
    ) {
        AnimationTiming anim = new AnimationTiming();
        anim.addEventAnimationTimingAdapter(new AnimationTimingAdapter() {

            @Override
            public void onAnimated(float animated) {
                int hReducir = (int) (alturaFinal * (1f - animated));
                int hExpandir = (int) (alturaFinal * animated);
                if (layout.getLayout() instanceof MigLayout mig) {
                    //Reduciendo y expandiendo los componentes.
                    mig.setComponentConstraints(componenteReducir, "growx, h " + Math.max(hReducir, 0) + "!");
                    if (animateComponentMoving == true) {//si los componentes a donde se mueve están visibles.
                        mig.setComponentConstraints(componenteExpandir, "growx, h " + Math.max(hExpandir, 0) + "!");
                    }
                }
                layout.revalidate();
                layout.repaint();
            }

            @Override
            public void onAnimatedEnded(boolean b) {//Al terminar la animación.
                if (onEnd != null) {
                    onEnd.run();
                }
            }
        });
        anim.setAnimationTime(250);//Duración de la animación en milisegundos.
        anim.animar();
    }
}
