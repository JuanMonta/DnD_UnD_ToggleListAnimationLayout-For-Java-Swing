package AnimationLayout;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.SwingUtilities;

class DnD_Activar extends DnD_MoveComponentAdapter {

    private boolean dragReady = false;
    private Robot robot;
    private Point initialMouseLocation;
    //ITEM ó SUBITEM
    private final String ITEM = "ITEM";
    private final String SUBITEM = "SUBITEM";
    private String esItemSubItem = "";
    private Item item;
    private int indexItem = -1;
    private Item.SubItem subItem;
    private int indexSubItem = -1;
    private DnD_ManipuladorItems manipuladorDragDrop;
    private DnD_JWindowDrag manipuladorJWindowDragged;
    private java.awt.event.MouseEvent mouseDraggedOnItem;

    public void setMouseDraggedOnItem(MouseEvent mouseDraggedOnItem) {
        //System.out.println("AnimationLayout.AnimateDragDrop "+mouseDraggedOnItem.getLocationOnScreen());
        //this.mouseDraggedOnItem = mouseDraggedOnItem;
        this.conversorPoint(mouseDraggedOnItem);
       
        if (this.esItemSubItem.equals(this.ITEM) && this.dragReady) {
            this.onDragItem(this.indexItem, this.item, this.mouseDraggedOnItem);

        } else if (this.esItemSubItem.equals(this.SUBITEM) && this.dragReady) {
            this.onDragSubItem(indexSubItem, subItem, mouseDraggedOnItem);
        }
        //System.out.println("AnimationLayout.AnimateDragDrop.DnD_Activar.setMouseDraggedOnItem(): "+this.mouseDraggedOnItem.getPoint());
    }

    public void dragAndDropInit(String esItemSubItem) {
        this.esItemSubItem = esItemSubItem;
        if (!this.animate.isAnimatorRunnning()) {
            this.animate.animar();
        }
    }

    public void dragAndDropCancel() {
        this.dragReady = false;
        this.initialMouseLocation = null;
        this.indexItem = -1;
        this.indexSubItem = -1;
        if (this.animate.isAnimatorRunnning()) {
            this.animate.animatorStop();
        }
        this.onDragEnded();
    }

    public void dragAndDropSetAnimationTime(int milis) {
        this.animate.setAnimationTime(milis);
    }
    private AnimationTiming animate;
    private DnD_AnimationTimeCurrentValue interfaceDragDropAnimationTimeCurrentValue;

    //##########################################################################
    //CONTRUCTORES--------------------------------------------------------------
    public DnD_Activar(Item item, DnD_AnimationTimeCurrentValue interfaceDragDropAnimationTimeCurrentValue) {
        this.item = item;
        this.iniciar(interfaceDragDropAnimationTimeCurrentValue);
    }

    public DnD_Activar(Item.SubItem subItem, DnD_AnimationTimeCurrentValue interfaceDragDropAnimationTimeCurrentValue) {
        this.subItem = subItem;
        this.iniciar(interfaceDragDropAnimationTimeCurrentValue);
    }
    //##########################################################################

    private void iniciar(DnD_AnimationTimeCurrentValue interfaceDragDropAnimationTimeCurrentValue) {
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        this.interfaceDragDropAnimationTimeCurrentValue = interfaceDragDropAnimationTimeCurrentValue;
        this.manipuladorJWindowDragged = new DnD_JWindowDrag();
        this.manipuladorDragDrop = new DnD_ManipuladorItems();
        this.animate = new AnimationTiming();
        this.animate.addEventAnimationTimingAdapter(this.iniciarTimingAdapterListener());
    }

    private void onAnimatedStarted() {
        if (DnD_Activar.this.item != null) {
            this.indexItem = this.item.getToggleListLayout().getListaItems().indexOf(this.item);
            this.manipuladorDragDrop.clonarItemOSubItem(this.item);
        } else if (DnD_Activar.this.subItem != null) {
            List<Item> items = this.subItem.getToggleListLayout().getListaItems();

            for (Item it : items) {
                if (it.getSubItems().contains(this.subItem)) {

                    this.indexSubItem = it.getToggleListLayout().getComponentZOrder(this.subItem);

                    break;
                }
            }
            this.manipuladorDragDrop.clonarItemOSubItem(this.subItem);
        }
    }

    private AnimationTimingAdapter iniciarTimingAdapterListener() {
        return new AnimationTimingAdapter() {
            @Override
            public void onAnimatedRepeated(boolean repeated) {
            }

            @Override
            public void onAnimatedStarted(boolean started) {
                //System.out.println(".onAnimatedStarted() DnD_Activar");
                DnD_Activar.this.onAnimatedStarted();
            }

            @Override
            public void onAnimated(float animated) {
                //System.out.println(".onAnimated() DnD_Activar");
                DnD_Activar.this.interfaceDragDropAnimationTimeCurrentValue.dragAndDropAnimationTimeCurrentValue(animated);
            }

            @Override
            public void onAnimatedEnded(boolean ended) {
                //System.out.println(".onAnimatedEnded() DnD_Activar");
                //ItemDragAndDropActivar.this.dragReady = true;
                DnD_Activar.this.verificarItems();
            }
        };
    }

    private void verificarItems() {
        if (this.esItemSubItem.equals(this.ITEM)) {
            this.onDragItem(this.indexItem, this.item, this.mouseDraggedOnItem);
            List<Item> listaItems = item.getToggleListLayout().getListaItems();
            final List<ToggleListListener> listaListenersTemp = new CopyOnWriteArrayList<>();
            for (Item it : listaItems) {
                if (it.getToggleList().isShowing()) {
                    ToggleListListener listener = new ToggleListAdapter() {
                        @Override
                        public void onAnimatedEnded() {
                            //System.out.println(".onAnimatedEnded(): La animación terminó. hash: " + this.hashCode());
                            it.getToggleList().removeToggleListListener(this);
                            listaListenersTemp.remove(this);
                            if (listaListenersTemp.isEmpty()) {
                                DnD_Activar.this.dragReady = true;
                                //System.out.println(".onAnimatedEnded() todos los listeners eliminados");
                            }
                        }
                    };
                    listaListenersTemp.add(listener);
                    it.getToggleList().addToggleListListener(listener);
                    it.getToggleList().setShowing(false, true);
                }
            }
            if (listaListenersTemp.isEmpty()) {
                this.dragReady = true;
            }

        } else if (this.esItemSubItem.equals(this.SUBITEM)) {
            this.onDragSubItem(this.indexSubItem, this.subItem, this.mouseDraggedOnItem);
            this.dragReady = true;
        }
    }

    private void conversorPoint(MouseEvent mouseDraggedEvent) {
        // Componente que originó el evento
        Component sourceComponent = (Component) mouseDraggedEvent.getSource();
        Component itemOrSubItemConvert = DnD_Activar.this.esItemSubItem.equals(ITEM)
                ? DnD_Activar.this.item : DnD_Activar.this.subItem;
        // Convertir el punto del evento desde las coordenadas del componente activador.
        // a las coordenadas de ESTE componente (la instancia de Item/SubItem).
        Point targetPoint = SwingUtilities.convertPoint(sourceComponent, mouseDraggedEvent.getPoint(), itemOrSubItemConvert);
        
        if (!this.dragReady) {
            if (initialMouseLocation == null) {
                initialMouseLocation = MouseInfo.getPointerInfo().getLocation();
            }
            if (robot != null) {
                robot.mouseMove(initialMouseLocation.x, initialMouseLocation.y);
            }
        } else {
            if (initialMouseLocation != null) {
                initialMouseLocation = null;
            }
        }
        
        // Crear un nuevo evento del mouse con las coordenadas corregidas,
        // y con (el Item/SubItem) como el nuevo origen del evento.
        MouseEvent newMouseEvent = new MouseEvent(
                itemOrSubItemConvert, // Nuevo origen
                mouseDraggedEvent.getID(),
                mouseDraggedEvent.getWhen(),
                mouseDraggedEvent.getModifiersEx(),
                targetPoint.x,
                targetPoint.y,
                mouseDraggedEvent.getClickCount(),
                mouseDraggedEvent.isPopupTrigger(),
                mouseDraggedEvent.getButton()
        );
        this.mouseDraggedOnItem = newMouseEvent;
    }

    @Override
    public void onDragItem(int indexItem, Item item, MouseEvent compMousePressed) {
        //System.out.println("AnimationLayout.AnimateDragDrop.DnD_Activar.onDragItem() " + compMousePressed.getPoint());
        this.manipuladorJWindowDragged.onDragItem(indexItem, item, compMousePressed);
        this.manipuladorDragDrop.onDragItem(indexItem, item, compMousePressed);
    }

    @Override
    public void onDragSubItem(int indexSubItem, Item.SubItem SubItem, MouseEvent compMousePressed) {
        //System.out.println("AnimationLayout.AnimateDragDrop.DnD_Activar.onDragSubItem() " + compMousePressed.getPoint());
        this.manipuladorJWindowDragged.onDragSubItem(indexSubItem, SubItem, compMousePressed);
        this.manipuladorDragDrop.onDragSubItem(indexSubItem, SubItem, compMousePressed);
    }

    @Override
    public void onDragEnded() {
        this.manipuladorJWindowDragged.onDragEnded();
        this.manipuladorDragDrop.onDragEnded();
    }

}