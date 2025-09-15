package AnimationLayout.Components;

import java.awt.AlphaComposite;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 * Utilidad para clonar componentes como imagen con transparencia, utilizado en
 * {@link ItemBlank} {@link SubItemBlank} para crear una imagen de un componente
 * que sea una instancia de {@link Item} o {@link Item.SubItem}.
 */
public class ComponentImageUtil {
    /**
     * Crear la imagen de un componente.
     * @param component Componente al cual se le hará una imagen.
     * @param opacity Transparencia que tendrá la imagen resultante.
     * @return ImageIcon de la imagen del componente.
     */
    public static ImageIcon createImageIconFromComponent(Component component, float opacity) {
        BufferedImage image = getPanelImageWithTransparency(component, opacity);
        return new ImageIcon(image);
    }
    /**
     * Crear la imagen de un componente.
     * @param component Componente al cual se le hará una imagen.
     * @param opacity Transparencia que tendrá la imagen resultante.
     * @return BufferedImage de la imagen del componente.
     */
    public static BufferedImage getPanelImageWithTransparency(Component component, float opacity) {
        if (component.getWidth() == 0 || component.getHeight() == 0) {
            component.setSize(new Dimension(300, 200));
        }
        BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        component.paint(g2d);
        BufferedImage transparentImage = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2dTrans = transparentImage.createGraphics();
        g2dTrans.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        g2dTrans.drawImage(image, 0, 0, null);
        g2d.dispose();
        g2dTrans.dispose();
        return transparentImage;
    }
}
