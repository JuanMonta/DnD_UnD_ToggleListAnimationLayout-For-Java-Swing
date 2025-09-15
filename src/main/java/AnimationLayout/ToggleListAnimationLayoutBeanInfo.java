package AnimationLayout;

import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.SimpleBeanInfo;

/**
 * Esta clase proporciona la información necesaria para que NetBeans integre
 * el componente ToggleListAnimationLayout en la paleta y el editor de GUI.
 */
public class ToggleListAnimationLayoutBeanInfo extends SimpleBeanInfo {

    /**
     * Proporciona un descriptor para el bean, incluyendo su nombre para mostrar.
     * @return un BeanDescriptor para el componente.
     */
    @Override
    public BeanDescriptor getBeanDescriptor() {
        BeanDescriptor bd = new BeanDescriptor(ToggleListAnimationLayout.class, null);
        // Este es el nombre que aparecerá en la paleta de componentes
        bd.setDisplayName("Toggle List Layout");
        bd.setShortDescription("Un panel con listas animadas y arrastre de ítems.");
        return bd;
    }

    /**
     * Carga y devuelve el icono que se mostrará en la paleta de NetBeans.
     * @param iconKind El tipo de icono solicitado (ej. 16x16, 32x32).
     * @return la imagen del icono, o null si no se encuentra.
     */
    @Override
    public java.awt.Image getIcon(int iconKind) {
        // ICON_COLOR_16x16 es el icono que se muestra en la paleta de componentes.
        if (iconKind == BeanInfo.ICON_COLOR_16x16) {
            // El archivo del icono debe estar en el mismo paquete que esta clase.
            // Asegúrate de haber creado un icono PNG de 16x16 llamado "ToggleListAnimationLayoutIcon.png"
            java.awt.Image img = loadImage("ToggleListAnimationLayoutIcon.png");
            return img;
        }
        // Opcionalmente, puedes proporcionar un icono de 32x32.
        if (iconKind == BeanInfo.ICON_COLOR_32x32) {
            // Crea un icono de 32x32 si quieres que se vea mejor en otras partes de NetBeans
            // y llámalo "ToggleListAnimationLayoutIcon32.png"
            java.awt.Image img = loadImage("ToggleListAnimationLayoutIcon32.png");
            return img;
        }
        return null;
    }
}
