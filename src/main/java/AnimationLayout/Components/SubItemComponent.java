package AnimationLayout.Components;

import AnimationLayout.Item;
import AnimationLayout.ToggleListAnimationLayout;
import AnimationLayout.UnD_MovimientoDireccion;
import java.awt.Point;
import javax.swing.SwingUtilities;

/**
 * Componente que se usará y se identificará como un {@link Item.SubItem} para
 * el layout {@link ToggleListAnimationLayout}.
 */
public class SubItemComponent extends Item.SubItem {

    public SubItemComponent() {
        initComponents();
        this.jProgressBar1.setUI(new CircularProgressBarUI());
        this.lbHashCode.setText("" + this.hashCode());
    }

    @Override
    public void onAdded() {
        this.lb_SubItemIndex.setText(this.getSubItemIndex() + "");
        this.lbTitle.setText(this.getSubItemTitle());
        this.lbSubTitle.setText(this.getSubItemSubTitle());
    }

    @Override
    public void dragAndDropAnimationTimeCurrentValue(float animatedVal) {
        //this.rSProgressCircle1.setValue((int)(animatedVal*100));
        this.jProgressBar1.setValue((int) (animatedVal * 100));
    }

    private void mirarLocationOnScreenComponente() {
        if (SubItemComponent.this.isShowing()) {
            Point p = this.getLocationOnScreen();
            SubItemComponent.this.lbLocation.setText("Loct: [x:" + p.x + " y:" + p.y + "]");
        }
    }

    public void colocarSize(int w, int h) {
        this.lbHeigth.setText("H:" + h);
        this.lbWeidth.setText("W:" + w);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        lbSubTitle = new javax.swing.JLabel();
        btn_UP = new javax.swing.JButton();
        btn_DOWN = new javax.swing.JButton();
        lb_SubItemIndex = new javax.swing.JLabel();
        lbHxHy = new javax.swing.JLabel();
        lbWeidth = new javax.swing.JLabel();
        lbHeigth = new javax.swing.JLabel();
        lbHashCode = new javax.swing.JLabel();
        lbLocation = new javax.swing.JLabel();
        btn_DELETE = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(448, 93));

        lbTitle.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(99, 98, 98));
        lbTitle.setText("SubItem Title");

        lbSubTitle.setForeground(new java.awt.Color(99, 98, 98));
        lbSubTitle.setText("SubItem Description");

        btn_UP.setText("UP");
        btn_UP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_UPMouseClicked(evt);
            }
        });

        btn_DOWN.setText("DOWN");
        btn_DOWN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DOWNMouseClicked(evt);
            }
        });

        lb_SubItemIndex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_SubItemIndex.setText("0");

        lbHxHy.setForeground(new java.awt.Color(99, 98, 98));
        lbHxHy.setText("Hy");

        lbWeidth.setForeground(new java.awt.Color(99, 98, 98));
        lbWeidth.setText("W:000");

        lbHeigth.setForeground(new java.awt.Color(99, 98, 98));
        lbHeigth.setText("H:000");

        lbHashCode.setForeground(new java.awt.Color(99, 98, 98));
        lbHashCode.setText("hashCode: ");

        lbLocation.setForeground(new java.awt.Color(99, 98, 98));
        lbLocation.setText("LctOnScrn: ");

        btn_DELETE.setText("DELETE");
        btn_DELETE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DELETEMouseClicked(evt);
            }
        });

        jProgressBar1.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar1.setForeground(new java.awt.Color(51, 153, 0));
        jProgressBar1.setValue(100);
        jProgressBar1.setPreferredSize(new java.awt.Dimension(20, 20));
        jProgressBar1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jProgressBar1MouseDragged(evt);
            }
        });
        jProgressBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jProgressBar1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jProgressBar1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lb_SubItemIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSubTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btn_UP)
                .addGap(8, 8, 8)
                .addComponent(btn_DOWN))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbHeigth)
                .addGap(50, 50, 50)
                .addComponent(lbHashCode, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbWeidth)
                .addGap(48, 48, 48)
                .addComponent(lbLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lbHxHy, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btn_DELETE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_SubItemIndex)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTitle)
                        .addGap(1, 1, 1)
                        .addComponent(lbSubTitle))
                    .addComponent(btn_UP)
                    .addComponent(btn_DOWN))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbHeigth)
                    .addComponent(lbHashCode))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbWeidth)
                    .addComponent(lbLocation)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbHxHy))
                    .addComponent(btn_DELETE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_UPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_UPMouseClicked
        if (SwingUtilities.isLeftMouseButton(evt) && evt.getClickCount() == 1) {
            this.moverSubItem(UnD_MovimientoDireccion.UP);
        }
    }//GEN-LAST:event_btn_UPMouseClicked

    private void btn_DOWNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DOWNMouseClicked
        if (SwingUtilities.isLeftMouseButton(evt) && evt.getClickCount() == 1) {
            this.moverSubItem(UnD_MovimientoDireccion.DOWN);
        }
    }//GEN-LAST:event_btn_DOWNMouseClicked

    private void btn_DELETEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DELETEMouseClicked
        if (SwingUtilities.isLeftMouseButton(evt) && evt.getClickCount() == 1) {
            deleteSubItem();
        }
    }//GEN-LAST:event_btn_DELETEMouseClicked

    private void jProgressBar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBar1MousePressed
        this.dragAndDropInit();
    }//GEN-LAST:event_jProgressBar1MousePressed

    private void jProgressBar1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBar1MouseReleased
        this.dragAndDropCancel();
    }//GEN-LAST:event_jProgressBar1MouseReleased

    private void jProgressBar1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBar1MouseDragged
        this.dragAndDropMouseDragged(evt);
    }//GEN-LAST:event_jProgressBar1MouseDragged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DELETE;
    private javax.swing.JButton btn_DOWN;
    private javax.swing.JButton btn_UP;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lbHashCode;
    private javax.swing.JLabel lbHeigth;
    private javax.swing.JLabel lbHxHy;
    private javax.swing.JLabel lbLocation;
    private javax.swing.JLabel lbSubTitle;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbWeidth;
    private javax.swing.JLabel lb_SubItemIndex;
    // End of variables declaration//GEN-END:variables

}
