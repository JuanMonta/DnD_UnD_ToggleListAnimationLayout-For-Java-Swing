package AnimationLayout;

import AnimationLayout.Components.ComponentImageUtil;
import java.awt.Component;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 * Usado para crear un {@link Item} en blanco, al cual en esta clase se le asignará una
 * copia de su Item real como imagen para representarlo como duplicado, extiende
 * de {@link Item} para usar la mayoría de sus métodos.
 *
 */
public abstract class ItemBlank extends Item {

    private ImageIcon imageIcon = null;

    public ItemBlank() {
    }

    /**
     * Recuperar la imagen creada del componente si está disponible, de lo
     * contrario null.
     *
     * @return null si aún no ha sido creada una imagen de componente.
     */
    public ImageIcon getImageComponentCloned() {
        return imageIcon;
    }

    /**
     * Crear la imagen del componente deseado.
     *
     * @param componentToClone componente al cual sacar la imagen.
     */
    public void setComponentToImage(Component componentToClone) {
        this.imageIcon = ComponentImageUtil.createImageIconFromComponent(componentToClone, 1.0f);
        this.imageComponentCloned(imageIcon);
    }

    /**
     * Notifica al componente que haya extendido {@link ItemBlank} que una
     * imagen de un componente ha sido creada.
     *
     * @param imageIcon Imagen creada del componente.
     */
    public abstract void imageComponentCloned(ImageIcon imageIcon);

    /**
     * Notifica al componente que haya extendido {@link ItemBlank} que una
     * imagen de un componente ha sido creada.
     *
     * @param imageBuff Imagen creada del componente.
     */
    public void imageComponentCloned(BufferedImage imageBuff) {

    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return "ItemBlank" + "( " + stringBuilder + ")";
    }

}
