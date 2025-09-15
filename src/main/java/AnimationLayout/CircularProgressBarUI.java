package AnimationLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicProgressBarUI;

class CircularProgressBarUI extends BasicProgressBarUI {

    @Override
    public Dimension getPreferredSize(JComponent c) {
        Dimension d = super.getPreferredSize(c);
        int v = Math.max(d.width, d.height);
        d.setSize(v, v);
        return d;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        // A diferencia de paintComponent, no necesitamos llamar a super.paint().
        Graphics2D g2d = (Graphics2D) g.create();

        // Activar antialiasing para tener bordes suaves
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Insets b = progressBar.getInsets(); // border insets
        int barRectWidth = progressBar.getWidth() - b.right - b.left;
        int barRectHeight = progressBar.getHeight() - b.top - b.bottom;

        if (barRectWidth <= 0 || barRectHeight <= 0) {
            return;
        }

        double degree = 360 * progressBar.getPercentComplete();
        double sz = Math.min(barRectWidth, barRectHeight);
        double cx = b.left + barRectWidth * .5;
        double cy = b.top + barRectHeight * .5;
        double or = sz * .5;
        double ir = or * .8; // Grosor del anillo

        // Crear el anillo exterior
        Shape outer = new Ellipse2D.Double(cx - or, cy - or, sz, sz);
        Shape inner = new Ellipse2D.Double(cx - ir, cy - ir, ir * 2, ir * 2);

        //Fondo del anillo (para la parte "vacía")
        Area background = new Area(outer);
        background.subtract(new Area(inner));
        g2d.setColor(new Color(230, 230, 230)); // Gris claro
        g2d.fill(background);
        // Para el arco de progreso
        Area foreground = new Area(new Arc2D.Double(cx - or, cy - or, sz, sz, 90, -degree, Arc2D.PIE));
        foreground.subtract(new Area(inner));
        g2d.setColor(progressBar.getForeground()); // Usa el color definido en el JProgressBar
        g2d.fill(foreground);
        g2d.dispose();

        //Opcional: Dibuja el texto del porcentaje si está activado
        if (progressBar.isStringPainted()) {
            paintString(g, b.left, b.top, barRectWidth, barRectHeight, 0, b);
        }
    }
}
