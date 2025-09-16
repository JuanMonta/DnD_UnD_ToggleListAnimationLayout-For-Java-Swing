package AnimationLayout.Components;

import AnimationLayout.SubItemBlank;
import java.awt.Component;
import javax.swing.ImageIcon;

/**
 * Componente que se usará y se identificará como un {@link SubItemBlank} para
 * el layout {@link ToggleListAnimationLayout}.
 */
public class SubItem_BlankComponent extends SubItemBlank {

    public SubItem_BlankComponent() {
        initComponents();

    }

    public SubItem_BlankComponent(Component componentToClone) {
        initComponents();

    }

    /**
     * Aquí se agregará la imagen del componente cuando esté listo, se lanza
     * automáticamente desde {@link SubItemBlank}.
     *
     * @param imageIcon
     */
    @Override
    public void imageComponentCloned(ImageIcon imageIcon) {
        this.jLabel1.setIcon(imageIcon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
