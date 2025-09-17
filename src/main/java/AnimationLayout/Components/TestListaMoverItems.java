package AnimationLayout.Components;

import AnimationLayout.Item;
import AnimationLayout.SubItemBlank;
import AnimationLayout.VerComponentes;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

public class TestListaMoverItems extends javax.swing.JFrame implements VerComponentes.verComponentes {

    List<Item> lista;
    DefaultListModel<String> listaModel;

    public TestListaMoverItems() {
        initComponents();
        VerComponentes.setVerComponentesInterface(this);
        this.lista = new ArrayList<>();
        //----------------------------------------------------------------------
        ItemComponent itemComponent1 = new ItemComponent();
        itemComponent1.setItemId("1");
        itemComponent1.setItemTitle("Item 01");
        itemComponent1.setItemSubTitle("SubTittle 01");

        SubItemComponent subItemComponent11 = new SubItemComponent();
        subItemComponent11.setSubItemId("11");
        subItemComponent11.setSubItemTitle("SubItem 11");
        subItemComponent11.setSubItemSubTitle("SubItemTitle 11");

        SubItemComponent subItemComponent12 = new SubItemComponent();
        subItemComponent12.setSubItemId("12");
        subItemComponent12.setSubItemTitle("SubItem 12");
        subItemComponent12.setSubItemSubTitle("SubItemTitle 12");

        SubItemComponent subItemComponent13 = new SubItemComponent();
        subItemComponent13.setSubItemId("13");
        subItemComponent13.setSubItemTitle("SubItem 13");
        subItemComponent13.setSubItemSubTitle("SubItemTitle 13");

        itemComponent1.addSubItem(subItemComponent11);
        itemComponent1.addSubItem(subItemComponent12);
        itemComponent1.addSubItem(subItemComponent13);
        //----------------------------------------------------------------------
        ItemComponent itemComponent2 = new ItemComponent();
        itemComponent2.setItemId("2");
        itemComponent2.setItemTitle("Item 02");
        itemComponent2.setItemSubTitle("SubTittle 02");

        SubItemComponent subItemComponent2 = new SubItemComponent();
        subItemComponent2.setSubItemId("21");
        subItemComponent2.setSubItemTitle("SubItem 21");
        subItemComponent2.setSubItemSubTitle("SubItemTitle 21");

        itemComponent2.addSubItem(subItemComponent2);
        //----------------------------------------------------------------------

        ItemComponent itemComponent3 = new ItemComponent();
        itemComponent3.setItemId("3");
        itemComponent3.setItemTitle("Item 03");
        itemComponent3.setItemSubTitle("SubTittle 03");

        lista.add(itemComponent1);
        lista.add(itemComponent2);
        lista.add(itemComponent3);

        System.out.println("Estado inicial:");
        lista.forEach(System.out::println);
        /*
        // Mover item 0 a la posición 1
        listaManipulador.moverItem(lista, 0, +1);

        // Mover subitem 0 del item 1 hacia abajo
        listaManipulador.moverSubItem(lista, 1, 0, +1);

        // Mover subitem 1 del item 0 hacia arriba (debería ir al final del item anterior)
        listaManipulador.moverSubItem(lista, 0, 1, -1);
         */
        //System.out.println("\nEstado final:");
        //lista.forEach(System.out::println);
        listaModel = new DefaultListModel<>();
        lista.forEach(p -> {
            listaModel.addElement(p.toString());
        });
        this.toggleListAnimationLayout1.setItemDragAndDropAnimationTime(3000);
        this.toggleListAnimationLayout1.setSubItemDragAndDropAnimationTime(2000);

        this.toggleListAnimationLayout1.setItemUpDownAnimationTime(3000);
        this.toggleListAnimationLayout1.setSubItemUpDownAnimationTime(2000);

        this.toggleListAnimationLayout1.setItemDeleteAnimationTime(2000);
        this.toggleListAnimationLayout1.setSubItemDeleteAnimationTime(2000);

        this.toggleListAnimationLayout1.renderItems(lista);
        this.verComponentes();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        txt_ItemPos = new javax.swing.JTextField();
        txt_ItemToPos = new javax.swing.JTextField();
        btn_MoverItem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_SubItemPos = new javax.swing.JTextField();
        txt_SubItemToPos = new javax.swing.JTextField();
        btn_MoverSubItem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        toggleListAnimationLayout1 = new AnimationLayout.ToggleListAnimationLayout();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_ItemParent = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jList1);

        btn_MoverItem.setText("MOVER");
        btn_MoverItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_MoverItemMouseClicked(evt);
            }
        });

        jLabel1.setText("Item");

        jLabel2.setText("to Pos");

        btn_MoverSubItem.setText("Mover SubItem");
        btn_MoverSubItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_MoverSubItemMouseClicked(evt);
            }
        });

        jScrollPane2.setPreferredSize(new java.awt.Dimension(460, 704));
        jScrollPane2.setViewportView(toggleListAnimationLayout1);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("SubItemsPos");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("SubItems to Pos");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Item parent");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_MoverItem)
                        .addGap(229, 229, 229)
                        .addComponent(btn_MoverSubItem))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_ItemPos)
                            .addComponent(txt_ItemToPos, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_SubItemPos)
                            .addComponent(txt_SubItemToPos)
                            .addComponent(txt_ItemParent, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ItemParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_SubItemPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_SubItemToPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ItemPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ItemToPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_MoverItem)
                    .addComponent(btn_MoverSubItem))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void verComponentes() {
        listaModel.removeAllElements();
        for (Component item : toggleListAnimationLayout1.getComponents()) {
            if (item instanceof Item.SubItem || item instanceof SubItemBlank) {
                listaModel.addElement("   ->" + item.toString());
            } else {
                listaModel.addElement(item.toString());
            }
        }
        jList1.setModel(listaModel);
    }


    private void btn_MoverItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MoverItemMouseClicked
        int itemPos = Integer.parseInt(this.txt_ItemPos.getText().trim());
        int itemToPos = Integer.parseInt(this.txt_ItemToPos.getText().trim());

        toggleListAnimationLayout1.moverItem(toggleListAnimationLayout1.getListaItems().get(itemPos), itemToPos);
    }//GEN-LAST:event_btn_MoverItemMouseClicked

    private void btn_MoverSubItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MoverSubItemMouseClicked
        int itemParent = Integer.parseInt(this.txt_ItemParent.getText().trim());
        int subItemPos = Integer.parseInt(this.txt_SubItemPos.getText().trim());
        int subItemToPos = Integer.parseInt(this.txt_SubItemToPos.getText().trim());

        toggleListAnimationLayout1.moverSubItem(toggleListAnimationLayout1.getListaItems().get(itemParent), subItemPos, subItemToPos);

    }//GEN-LAST:event_btn_MoverSubItemMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestListaMoverItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestListaMoverItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestListaMoverItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestListaMoverItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestListaMoverItems().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_MoverItem;
    private javax.swing.JButton btn_MoverSubItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private AnimationLayout.ToggleListAnimationLayout toggleListAnimationLayout1;
    private javax.swing.JTextField txt_ItemParent;
    private javax.swing.JTextField txt_ItemPos;
    private javax.swing.JTextField txt_ItemToPos;
    private javax.swing.JTextField txt_SubItemPos;
    private javax.swing.JTextField txt_SubItemToPos;
    // End of variables declaration//GEN-END:variables
}
