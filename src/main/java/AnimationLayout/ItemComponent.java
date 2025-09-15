package AnimationLayout;

import java.awt.Point;
import javax.swing.SwingUtilities;


/**
 * Componente que se usará y se identificará como un {@link Item} para el layout
 * {@link ToggleListAnimationLayout}.
 */
public class ItemComponent extends Item {

    private String itemTitle = "", itemSubTitle = "", itemInfo01 = "", itemInfo02 = "", itemInfo03 = "";

    private int itemIndex = 0; 

    public ItemComponent() {
        initComponents();
        this.lb_HashCode.setText("hashCode: " + this.hashCode());
        this.colocarSize(this.getPreferredSize().width, this.getPreferredSize().height);
        this.dragAndDropSetAnimationTime(1000);
    }

    public void setItemIndex(int index) {
        this.itemIndex = index;
        this.lb_ItemIndex.setText(String.valueOf(index));
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
        this.lb_Title.setText(this.getItemTitle());
    }

    public void setItemSubTitle(String itemSubTitle) {
        this.itemSubTitle = itemSubTitle;
        this.lb_SubTitle.setText(this.getItemSubTitle());
    }

    public void setItemInfo01(String itemInfo01) {
        this.itemInfo01 = itemInfo01;
    }

    public void setItemInfo02(String itemInfo02) {
        this.itemInfo02 = itemInfo02;
    }

    public void setItemInfo03(String itemInfo03) {
        this.itemInfo03 = itemInfo03;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public String getItemSubTitle() {
        return itemSubTitle;
    }

    public String getItemInfo01() {
        return itemInfo01;
    }

    public String getItemInfo02() {
        return itemInfo02;
    }

    public String getItemInfo03() {
        return itemInfo03;
    }

    @Override
    public void subItemAdded(Item.SubItem subItemAdded) {
        this.lb_SubItemNumber.setText("" + this.getSubItemsCount());
    }

    @Override
    public void dragAndDropAnimationTimeCurrentValue(float animatedVal) {
        //System.out.println("Test.ItemComponent.dragDropAnimationTimeCurrentValue() "+animatedVal);
        this.rSProgressCircle1.setValue((int)(animatedVal*100));
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
        rSProgressCircle1 = new rojerusan.RSProgressCircle();
        lb_Width = new javax.swing.JLabel();
        lb_Height = new javax.swing.JLabel();
        lb_HxHy = new javax.swing.JLabel();
        btn_DELETE = new javax.swing.JButton();

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

        toggleButton_ShowSubItems.setSelected(true);
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

        rSProgressCircle1.setValue(100);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSProgressCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_Height)
                    .addComponent(lb_Width))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_ItemIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_SubItemNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lb_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lb_SubTitle))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(toggleButton_ShowSubItems))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lb_HashCode, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_UP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_DOWN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_Parent, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_Location, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lb_HxHy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_DELETE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(rSProgressCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_Parent)
                            .addComponent(lb_Height))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_Location)
                            .addComponent(lb_Width)
                            .addComponent(lb_HxHy)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
            this.getToggleList().setShowing(!this.getToggleList().isShowing(), true);
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

    private void rSProgressCircle1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSProgressCircle1MousePressed
        this.ragAndDropInit();
    }//GEN-LAST:event_rSProgressCircle1MousePressed

    private void rSProgressCircle1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSProgressCircle1MouseReleased
        this.dragAndDropCancel();
    }//GEN-LAST:event_rSProgressCircle1MouseReleased

    private void rSProgressCircle1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSProgressCircle1MouseDragged
       this.dragAndDropMouseDragged(evt);
    }//GEN-LAST:event_rSProgressCircle1MouseDragged



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DELETE;
    private javax.swing.JButton btn_DOWN;
    private javax.swing.JButton btn_UP;
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
    private rojerusan.RSProgressCircle rSProgressCircle1;
    private javax.swing.JToggleButton toggleButton_ShowSubItems;
    // End of variables declaration//GEN-END:variables

}
