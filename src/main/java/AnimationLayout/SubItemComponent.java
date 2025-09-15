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
        this.jProgressBar1.setUI(new CircularProgressBarUI());
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
     //this.rSProgressCircle1.setValue((int)(animatedVal*100));
     this.jProgressBar1.setValue((int)(animatedVal*100));
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
        setLayout(null);

        lbTitle.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(99, 98, 98));
        lbTitle.setText("SubItem Title");
        add(lbTitle);
        lbTitle.setBounds(90, 10, 111, 19);

        lbSubTitle.setForeground(new java.awt.Color(99, 98, 98));
        lbSubTitle.setText("SubItem Description");
        add(lbSubTitle);
        lbSubTitle.setBounds(90, 30, 111, 16);

        btn_UP.setText("UP");
        btn_UP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_UPMouseClicked(evt);
            }
        });
        add(btn_UP);
        btn_UP.setBounds(230, 10, 72, 23);

        btn_DOWN.setText("DOWN");
        btn_DOWN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DOWNMouseClicked(evt);
            }
        });
        add(btn_DOWN);
        btn_DOWN.setBounds(310, 10, 72, 23);

        lb_SubItemIndex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_SubItemIndex.setText("0");
        add(lb_SubItemIndex);
        lb_SubItemIndex.setBounds(50, 10, 30, 16);

        lbHxHy.setForeground(new java.awt.Color(99, 98, 98));
        lbHxHy.setText("Hy");
        add(lbHxHy);
        lbHxHy.setBounds(230, 70, 111, 16);

        lbWeidth.setForeground(new java.awt.Color(99, 98, 98));
        lbWeidth.setText("W:000");
        add(lbWeidth);
        lbWeidth.setBounds(10, 67, 32, 16);

        lbHeigth.setForeground(new java.awt.Color(99, 98, 98));
        lbHeigth.setText("H:000");
        add(lbHeigth);
        lbHeigth.setBounds(10, 50, 30, 16);

        lbHashCode.setForeground(new java.awt.Color(99, 98, 98));
        lbHashCode.setText("hashCode: ");
        add(lbHashCode);
        lbHashCode.setBounds(90, 50, 111, 16);

        lbLocation.setForeground(new java.awt.Color(99, 98, 98));
        lbLocation.setText("LctOnScrn: ");
        add(lbLocation);
        lbLocation.setBounds(90, 67, 111, 16);

        btn_DELETE.setText("DELETE");
        btn_DELETE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DELETEMouseClicked(evt);
            }
        });
        add(btn_DELETE);
        btn_DELETE.setBounds(353, 67, 72, 23);

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
        add(jProgressBar1);
        jProgressBar1.setBounds(15, 10, 20, 20);
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
