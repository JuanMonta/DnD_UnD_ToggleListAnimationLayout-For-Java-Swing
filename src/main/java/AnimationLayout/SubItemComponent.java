package AnimationLayout;

import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;


/**
 * Componente que se usará y se identificará como un {@link Item.SubItem} para el layout
 * {@link ToggleListAnimationLayout}.
 */
public class SubItemComponent extends Item.SubItem {

    private boolean dragReady = false;
    private MouseEvent mouseEventMousePressed;

     private String subItemTitle = "", subItemSubTitle = "", subItemInfo01 = "", subItemInfo02 = "", subItemInfo03 = "";
   
    public SubItemComponent() {
        initComponents();
        this.lbHashCode.setText("" + this.hashCode());
    }

    public void setSubItemTitle(String subItemTitle) {
        this.subItemTitle = subItemTitle;
        this.lbTitle.setText(this.subItemTitle);
    }

    public void setSubItemSubTitle(String subItemSubTitle) {
        this.subItemSubTitle = subItemSubTitle;
        this.lbSubTitle.setText(this.subItemSubTitle);
    }

    public void setSubItemInfo01(String subItemInfo01) {
        this.subItemInfo01 = subItemInfo01;
    }

    public void setSubItemInfo02(String subItemInfo02) {
        this.subItemInfo02 = subItemInfo02;
    }

    public void setSubItemInfo03(String subItemInfo03) {
        this.subItemInfo03 = subItemInfo03;
    }

    @Override
    public void dragAndDropAnimationTimeCurrentValue(float animatedVal) {
     this.rSProgressCircle1.setValue((int)(animatedVal*100));
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
        rSProgressCircle1 = new rojerusan.RSProgressCircle();
        lbHashCode = new javax.swing.JLabel();
        lbLocation = new javax.swing.JLabel();
        btn_DELETE = new javax.swing.JButton();

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

        rSProgressCircle1.setForeground(new java.awt.Color(0, 102, 0));
        rSProgressCircle1.setValue(100);
        rSProgressCircle1.setMinimumSize(new java.awt.Dimension(10, 10));
        rSProgressCircle1.setPreferredSize(new java.awt.Dimension(20, 20));
        rSProgressCircle1.setStringPainted(false);
        rSProgressCircle1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                rSProgressCircle1MouseDragged(evt);
            }
        });
        rSProgressCircle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rSProgressCircle1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rSProgressCircle1MouseReleased(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(rSProgressCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_DELETE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSProgressCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbHxHy)
                        .addComponent(btn_DELETE))))
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

    private void rSProgressCircle1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSProgressCircle1MousePressed
        this.dragAndDropInit();
    }//GEN-LAST:event_rSProgressCircle1MousePressed

    private void rSProgressCircle1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSProgressCircle1MouseReleased
        this.dragAndDropCancel();
    }//GEN-LAST:event_rSProgressCircle1MouseReleased

    private void rSProgressCircle1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSProgressCircle1MouseDragged
        this.dragAndDropMouseDragged(evt);
    }//GEN-LAST:event_rSProgressCircle1MouseDragged

    private void btn_DELETEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DELETEMouseClicked
      if (SwingUtilities.isLeftMouseButton(evt) && evt.getClickCount() == 1) {
            deleteSubItem();
        }
    }//GEN-LAST:event_btn_DELETEMouseClicked
                               


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DELETE;
    private javax.swing.JButton btn_DOWN;
    private javax.swing.JButton btn_UP;
    private javax.swing.JLabel lbHashCode;
    private javax.swing.JLabel lbHeigth;
    private javax.swing.JLabel lbHxHy;
    private javax.swing.JLabel lbLocation;
    private javax.swing.JLabel lbSubTitle;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbWeidth;
    private javax.swing.JLabel lb_SubItemIndex;
    private rojerusan.RSProgressCircle rSProgressCircle1;
    // End of variables declaration//GEN-END:variables

}
