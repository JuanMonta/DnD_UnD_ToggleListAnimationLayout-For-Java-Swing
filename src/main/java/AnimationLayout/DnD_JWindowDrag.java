package AnimationLayout;

import AnimationLayout.Components.ComponentImageUtil;
import java.awt.Component;
import java.awt.Container;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.JWindow;
import net.miginfocom.swing.MigLayout;

class DnD_JWindowDrag extends DnD_MoveComponentAdapter {

    private Point dragOffset;
    private int blockX;
    private ToggleListAnimationLayout toggleListAnimationLayout;
    private Container boundsContainer;
    private JScrollPane jScrollListContainer;

    private boolean dragReady = false;
    private final JWindow jWindow;
    private Component itemToJWindow;

    public DnD_JWindowDrag() {
        this.jWindow = new JWindow();
        this.itemToJWindow = new Component() {
        };
        this.jWindow.add(itemToJWindow);
    }

    @Override
    public void onDragItem(int indexItem, Item item, MouseEvent compMousePressed) {
        this.onDragInits(item, compMousePressed);
    }

    @Override
    public void onDragSubItem(int indexSubItem, Item.SubItem SubItem, MouseEvent compMousePressed) {
        this.onDragInits(SubItem, compMousePressed);
    }

    @Override
    public void onDragEnded() {
        this.dragReady = false;
        this.jWindow.getContentPane().removeAll();
        this.jWindow.setVisible(false);
        this.dragOffset = null;
        this.blockX = 0;
    }

    /**
     * Se lanza en {@link DnD_JWindowDrag#} cuando: -Al inicio cuando el
     * animador {@link DnD_Activar#dragAndDropInit(java.lang.String)} termina y
     * lanza {@link DnD_Activar#verificarItems()} que es donde se lanza {@link DnD_Activar#onDragItem(int, AnimationLayout.Item, java.awt.event.MouseEvent) }
     *  0 {@link DnD_Activar#onDragSubItem(int, AnimationLayout.Item.SubItem, java.awt.event.MouseEvent)}
     * -En {@link DnD_Activar#setMouseDraggedOnItem(java.awt.event.MouseEvent)}
     * permite capturar el drag del mouse.
     *
     * @param compToDrag Item o el SubItem a cual sacarle una imagen para ser
     * colocado en el jwindow.
     * @param mouseEvent evento donde nos interesa el mouse drag para usarlo
     * para mover el jwindow.
     */
    private void onDragInits(Component compToDrag, MouseEvent mouseEvent) {
        //al principio
        if (!this.dragReady) {
            this.dragReady = true;
            if (compToDrag instanceof Item item) {
                this.toggleListAnimationLayout = item.getToggleListLayout();
            } else if (compToDrag instanceof Item.SubItem subItem) {
                this.toggleListAnimationLayout = subItem.getToggleListLayout();
            }
            this.jScrollListContainer = this.toggleListAnimationLayout.getjScrollPaneLayoutContainer();
            if (this.jScrollListContainer != null) {
                this.boundsContainer = this.jScrollListContainer;
            } else {
                this.boundsContainer = this.toggleListAnimationLayout.getParent();
            }
            this.mostrarJWindow(compToDrag);
        } else {
            if (mouseEvent != null) {
                this.moverJWindow(mouseEvent);
            }
        }
    }

    private void mostrarJWindow(Component compToDrag) {
        this.jWindow.setLocation(compToDrag.getLocationOnScreen());
        this.blockX = this.jWindow.getX();

        this.jWindow.setMinimumSize(compToDrag.getMinimumSize());
        this.jWindow.setMaximumSize(compToDrag.getMaximumSize());
        this.jWindow.setPreferredSize(compToDrag.getPreferredSize());
        this.jWindow.setSize(compToDrag.getSize());
        this.jWindow.setAlwaysOnTop(true);

        Point initialMouseOnScreen = MouseInfo.getPointerInfo().getLocation();
        Point initialWindowOnScreen = this.jWindow.getLocation();
        this.dragOffset = new Point(initialMouseOnScreen.x - initialWindowOnScreen.x,
                initialMouseOnScreen.y - initialWindowOnScreen.y);

        this.jWindow.setVisible(true);
        this.jWindow.revalidate();
        this.jWindow.repaint();

        this.jWindow.getContentPane().removeAll();
        MigLayout layout = new MigLayout("wrap, fillx, inset 0, hidemode 1", "[fill]", "[top]0[]");
        JPanel panel = new JPanel(layout);
        JLabel label = new JLabel(ComponentImageUtil.createImageIconFromComponent(compToDrag, 1.0f));
        panel.add(label);
        this.itemToJWindow = panel;
        this.jWindow.add(itemToJWindow);

        this.jWindow.revalidate();
        this.jWindow.repaint();
    }

    private void moverJWindow(MouseEvent e) {
        Point locationOnScreen = e.getLocationOnScreen();
        int yNew = locationOnScreen.y - this.dragOffset.y;
        if (this.jWindow.isVisible()) {
            // Autoscroll
            if (this.jScrollListContainer != null) {
                JViewport viewport = this.jScrollListContainer.getViewport();
                int currentY = viewport.getViewPosition().y;
                int viewHeight = viewport.getExtentSize().height;
                int contentHeight = viewport.getView().getHeight();
                boolean isAtTop = currentY == 0;
                boolean isAtBottom = currentY + viewHeight >= contentHeight;

                if (locationOnScreen.y <= this.boundsContainer.getLocationOnScreen().y + 10 && !isAtTop) {
                    viewport.setViewPosition(new Point(viewport.getViewPosition().x, currentY - 3));
                } else if (locationOnScreen.y >= this.boundsContainer.getLocationOnScreen().y + this.boundsContainer.getBounds().height - 10 && !isAtBottom) {
                    viewport.setViewPosition(new Point(viewport.getViewPosition().x, currentY + 3));
                }
            }
            this.jWindow.setLocation(this.blockX, yNew);
        }
    }
}
