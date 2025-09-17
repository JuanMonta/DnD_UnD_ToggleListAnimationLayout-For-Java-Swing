package AnimationLayout.Components;

import AnimationLayout.Components.CircularProgressBarUI;
import AnimationLayout.Item;
import AnimationLayout.UnD_MovimientoDireccion;
import java.awt.Point;
import javax.swing.SwingUtilities;

/**
 * Componente que se usará y se identificará como un {@link Item} para el layout
 * {@link ToggleListAnimationLayout}.
 */
public class ItemComponent extends Item {


    public ItemComponent() {
        initComponents();
        this.lb_HashCode.setText("hashCode: " + this.hashCode());
        this.jProgressBar1.setUI(new CircularProgressBarUI());
        this.colocarSize(this.getPreferredSize().width, this.getPreferredSize().height);
    }

    @Override
    public void itemAdded() {
        this.lb_ItemIndex.setText(""+this.getItemIndex());
        this.lb_Title.setText(this.getItemTitle());
        this.lb_SubTitle.setText(this.getItemSubTitle());
    }

    @Override
    public void subItemAdded(Item.SubItem subItemAdded) {
        this.lb_SubItemNumber.setText("" + this.getSubItemsCount());
    }

    @Override
    public void dragAndDropAnimationTimeCurrentValue(float animatedVal) {
        //System.out.println("Test.ItemComponent.dragDropAnimationTimeCurrentValue() "+animatedVal);
        //this.rSProgressCircle1.setValue((int)(animatedVal*100));
        this.jProgressBar1.setValue((int) (animatedVal * 100));
    }

    private void mirarLocationOnScreenComponente() {
        if (ItemComponent.this.isShowing()) {
            Point p = this.getLocationOnScreen();
            ItemComponent.this.lb_Location.setText("Loct: [x:" + p.x + " y:" + p.y + "]");
        }
    }

    public void mirarLocationOnScreenComponente(Point p) {
        ItemComponent.this.lb_Location.setText("Loct: [x:" + p.x + " y:" + p.y);
        ItemComponent.this.lb_HxHy.setText("Hy: {" + (this.getHeight() + p.y) + "}");
    }

    public void colocarSize(int w, int h) {
        this.lb_Height.setText("H:" + h);
        this.lb_Width.setText("W:" + w);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_SubTitle = new javax.swing.JLabel();
        lb_Title = new javax.swing.JLabel();
        btn_UP = new javax.swing.JButton();
        btn_DOWN = new javax.swing.JButton();
        toggleButton_ShowSubItems = new javax.swing.JToggleButton();
        lb_SubItemNumber = new javax.swing.JLabel();
        lb_HashCode = new javax.swing.JLabel();
        lb_Parent = new javax.swing.JLabel();
        lb_ItemIndex = new javax.swing.JLabel();
        lb_Location = new javax.swing.JLabel();
        lb_Width = new javax.swing.JLabel();
        lb_Height = new javax.swing.JLabel();
        lb_HxHy = new javax.swing.JLabel();
        btn_DELETE = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(448, 110));

        lb_SubTitle.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lb_SubTitle.setForeground(new java.awt.Color(99, 98, 98));
        lb_SubTitle.setText("Item Description");

        lb_Title.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lb_Title.setText("Item Title");

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

        toggleButton_ShowSubItems.setText("SHOW");
        toggleButton_ShowSubItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toggleButton_ShowSubItemsMouseClicked(evt);
            }
        });

        lb_SubItemNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_SubItemNumber.setForeground(new java.awt.Color(102, 102, 102));
        lb_SubItemNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_SubItemNumber.setText("0");

        lb_HashCode.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lb_HashCode.setForeground(new java.awt.Color(99, 98, 98));
        lb_HashCode.setText("hashCode: ");

        lb_Parent.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lb_Parent.setForeground(new java.awt.Color(99, 98, 98));
        lb_Parent.setText("parent: ");

        lb_ItemIndex.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_ItemIndex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_ItemIndex.setText("0");

        lb_Location.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lb_Location.setForeground(new java.awt.Color(99, 98, 98));
        lb_Location.setText("LctOnScrn: ");

        lb_Width.setForeground(new java.awt.Color(102, 102, 102));
        lb_Width.setText("W:000");

        lb_Height.setForeground(new java.awt.Color(102, 102, 102));
        lb_Height.setText("H:000");

        lb_HxHy.setForeground(new java.awt.Color(102, 102, 102));
        lb_HxHy.setText("Hy ");

        btn_DELETE.setText("DELETE");
        btn_DELETE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DELETEMouseClicked(evt);
            }
        });

        jProgressBar1.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar1.setForeground(new java.awt.Color(102, 102, 255));
        jProgressBar1.setValue(100);
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
                .addGap(10, 10, 10)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_ItemIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_SubItemNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lb_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lb_SubTitle))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(toggleButton_ShowSubItems))
                    .addComponent(lb_HashCode, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_UP)
                    .addComponent(btn_DOWN)))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_Height)
                    .addComponent(lb_Width))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_Parent, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_Location, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lb_HxHy, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(btn_DELETE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lb_ItemIndex)
                        .addGap(9, 9, 9)
                        .addComponent(lb_SubItemNumber))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_Title)
                        .addGap(9, 9, 9)
                        .addComponent(lb_SubTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(toggleButton_ShowSubItems)
                        .addGap(7, 7, 7)
                        .addComponent(lb_HashCode))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btn_UP)
                        .addGap(6, 6, 6)
                        .addComponent(btn_DOWN)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lb_Height)
                        .addGap(9, 9, 9)
                        .addComponent(lb_Width))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_Parent)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_Location)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lb_HxHy))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btn_DELETE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_UPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_UPMouseClicked
        if (SwingUtilities.isLeftMouseButton(evt) && evt.getClickCount() == 1) {
            this.moverItem(UnD_MovimientoDireccion.UP);
        }
    }//GEN-LAST:event_btn_UPMouseClicked

    private void toggleButton_ShowSubItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toggleButton_ShowSubItemsMouseClicked
        if (SwingUtilities.isLeftMouseButton(evt) && evt.getClickCount() == 1) {
            this.toggleList();
        }
    }//GEN-LAST:event_toggleButton_ShowSubItemsMouseClicked

    private void btn_DOWNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DOWNMouseClicked
        if (SwingUtilities.isLeftMouseButton(evt) && evt.getClickCount() == 1) {
            this.moverItem(UnD_MovimientoDireccion.DOWN);
        }
    }//GEN-LAST:event_btn_DOWNMouseClicked

    private void btn_DELETEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DELETEMouseClicked
        if (SwingUtilities.isLeftMouseButton(evt) && evt.getClickCount() == 1) {
            deleteItem();
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
    private javax.swing.JLabel lb_HashCode;
    private javax.swing.JLabel lb_Height;
    private javax.swing.JLabel lb_HxHy;
    private javax.swing.JLabel lb_ItemIndex;
    private javax.swing.JLabel lb_Location;
    private javax.swing.JLabel lb_Parent;
    private javax.swing.JLabel lb_SubItemNumber;
    private javax.swing.JLabel lb_SubTitle;
    private javax.swing.JLabel lb_Title;
    private javax.swing.JLabel lb_Width;
    private javax.swing.JToggleButton toggleButton_ShowSubItems;
    // End of variables declaration//GEN-END:variables

}
