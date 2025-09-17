package AnimationLayout;

import java.awt.Component;
import java.util.Collections;
import java.util.List;
import javax.swing.JComponent;

class UnD_ListaManipulador {

    private UnD_AnimadorRedimension animadorRedimensionItems, animadorRedimensionSubItems;
    private UnD_AnimadorEliminacion animadorEliminacionItems, animadorEliminacionSubItems;

    public UnD_ListaManipulador() {
        this.animadorRedimensionItems = new UnD_AnimadorRedimension();
        this.animadorRedimensionSubItems = new UnD_AnimadorRedimension();
        
        this.animadorEliminacionItems = new UnD_AnimadorEliminacion();
        this.animadorEliminacionSubItems = new UnD_AnimadorEliminacion();
    }
    
    void setRedimensionItemAnimationTime(int milis){
        this.animadorRedimensionItems.setRedimensionAnimationTime(milis);
    }
    void setRedimensionSubItemAnimationTime(int milis){
        this.animadorRedimensionSubItems.setRedimensionAnimationTime(milis);
    }
    void setEliminacionItemAnimationTime(int milis){
        this.animadorEliminacionItems.setEliminacionAnimationTime(milis);
    }
    
    void setEliminacionSubItemAnimationTime(int milis){
        this.animadorEliminacionSubItems.setEliminacionAnimationTime(milis);
    }
    

    /**
     * Animar el movimiento UP - DOWN de los items del layout con o sin
     * animaciones.
     *
     * @param items lista de los items en el layout.
     * @param index índice del item al que se dará la ilusión de movimiento.
     * @param direccion
     * {@link UnD_MovimientoDireccion#UP} {@link UnD_MovimientoDireccion#DOWN}
     * @param animated true=animar false=no animar
     * @param itemBlank Instancia del item en blanco donde se colocará la "foto"
     * de otro item que corresponda para dar la ilusión de movimiento.
     */
    public void moverItem(List<Item> items, int index, int direccion, boolean animated, ItemBlank itemBlank) {
        int nuevoIndex = index + direccion;

        // Evitar un movimiento fuera de los indices de la lista de items.
        if (index < 0 || nuevoIndex < 0 || index >= items.size() || nuevoIndex >= items.size()) {
            System.out.println("X Movimiento de Item fuera de los límites. index: " + index + ", nuevoIndex: " + nuevoIndex);
            return;
        }
        //para mover sin animación
        if (!animated) {
            Collections.swap(items, index, nuevoIndex);
            items.get(index).getToggleListLayout().renderItems(items);
            System.out.println("OK Item " + items.get(nuevoIndex).getItemId() + " se movió de posición " + index + " a " + nuevoIndex);
            return;
        }

        //-------Lógica de animación--------------------------------------------
        Item movingItem = items.get(index);//item que simula el movimiento
        Item itemToSwapWith = items.get(nuevoIndex);// item con cual intercambiar con otro item para dar la ilusión de movimiento.
        ItemBlank blank = itemBlank; //instancia de un item en blanco para colocar una "foto" del item real del que se sacó la "foto".

        if (blank == null) {
            System.out.println("X No se proporcionó una instancia de ItemBlank.");
            return;
        }

        ToggleListAnimationLayout layout = movingItem.getToggleListLayout();
        if (layout == null) {
            System.out.println("X No se encontró el layout para la animación.");
            return;
        }
        //Colocando la imagen del item con la que generar la imagen de movimiento,
        //itemBlank se eliminará al final de la animacióm de movimiento.
        blank.setComponentToImage(itemToSwapWith);
        //Identificamos la dirección de movimiento del item.
        if (direccion == UnD_MovimientoDireccion.DOWN) {
            //Intercambiamos el index del item que se moverá con el index del item siguiente.
            Collections.swap(items, index, nuevoIndex);
            //Para agregar el item en blanco, itemBlank.
            //Verifica si el item a mover no está al final de la lista de items.
            //Se verifica así para saber cual es el nuevo index del item al que se dará la ilusión de movimiento despues del Collentions.swap()
            if (items.indexOf(movingItem) < items.size()) {
                //Se agrega el item en blanco un puesto adelante del item a quien se le dará la ilusión de movimiento.
                items.add(items.indexOf(movingItem) + 1, blank);
            } else {//Cuando está al final de la lista de items, simplementa agregar.
                items.add(blank);
            }
        } else {//Movimiento hacia abajo.
            //Si el index del item a cual darle la ilusión de movimiento no está al final de la lista de items.
            if (index < items.size()) {
                //Se agrega el item en blanco un puesto adelante del item a quien se le dará la ilusión de movimiento.
                items.add(index + 1, blank);
            } else {//Cuando está al final de la lista de items, simplemente agregar.
                items.add(blank);
            }
            //Intercamviamos los items que estan un indice antes (nuevoIndex) del item a quien se la dará la ilusión
            //de movimiento tomando el indice del item en blanco.
            Collections.swap(items, nuevoIndex, items.indexOf(blank));
        }

        //Renderizar todos los componentes que ya estpan ordenados.
        layout.renderAnimatedItems(items);

        //Ocultar el item real que creará la ilusion de movimiento mediandte animacion aumentando sun altura
        layout.getMigLayout().setComponentConstraints(itemToSwapWith, "growx, h 0!");
        //Asegurar que el item a quien se le dará la ilusión de movimiento sea visible
        layout.getMigLayout().setComponentConstraints(movingItem, "growx");
        //el item en blando contiene la foto del item real (itemToSwaapWith)
        layout.getMigLayout().setComponentConstraints(blank, "growx"); // Asegurar que el item en blanco sea visible
        layout.revalidate();
        layout.repaint();

        VerComponentes.verComponentes();
        //obtener la altura para usarla en la animacioón de movimiento mediante 
        //redimensiones de los items involucrados.
        int itemHeight = itemToSwapWith.getPreferredSize().height;
        this.animadorRedimensionItems.animarRedimension(
                layout,
                blank, //Componente a reducir
                itemToSwapWith, //Componente a expandir
                itemHeight, //Altura del componente a expandir.
                true, //Animar true false
                () -> {//Runnable, se ejecura al finalizar la animación de expandir reducir.
                    // Una vez completado la animación
                    items.remove(blank);//Removemos el irem blanco de la lisa de items.
                    layout.remove(blank);//Removemos el item blanco del propio layout.
                    layout.getMigLayout().setComponentConstraints(itemToSwapWith, "growx");// Asegurar que ocupe todo el ancho del layout.
                    layout.getMigLayout().setComponentConstraints(movingItem, "growx");// Asegurar que ocupe todo el ancho del layout.
                    layout.renderItems(items); //Renderizar los componentes
                    VerComponentes.verComponentes();
                }
        );
    }

    /**
     * Animar el movimiento UP - DOWN de los subItems del layout con o sin
     * animaciones.
     *
     * @param items lista de los items en el layout.
     * @param itemIndex índice del item padre del subItem al que se le dará la
     * ilusión de movimiento.
     * @param subItemIndex índice del subItem al que se dará la ilusión de
     * movimiento.
     * @param direccion
     * {@link UnD_MovimientoDireccion#UP} {@link UnD_MovimientoDireccion#DOWN}
     * @param animated true=animar false=no animar
     * @param subItemBlank Instancia del subItem en blanco donde se colocará la
     * "foto" de otro subItem que corresponda para dar la ilusión de movimiento.
     */
    public void moverSubItem(List<Item> items, int itemIndex, int subItemIndex, int direccion, boolean animated, SubItemBlank subItemBlank) {
        //Validaar que el movimiento de el subItem no sobrepase el primer item o mayor al último item.
        if (itemIndex < 0 || itemIndex >= items.size()) {
            System.out.println("X Índice de item padre fuera de límites: " + itemIndex);
            return;
        }
        //Item padre del subItem a quien se le dará la ilusión de movimiento.
        Item itemActual = items.get(itemIndex);
        //Lista de subItems del item padre del subItems a quien se dará la ilusión de movimiento.
        List<Component> subItems = itemActual.getSubItems();
        //Para que se encuentre dentro de los límites de la lista de subItems-
        if (subItemIndex < 0 || subItemIndex >= subItems.size()) {
            System.out.println("X Índice de subitem fuera de límites: " + subItemIndex);
            return;
        }
        //Tomamos el subItem a quien se darpa la ilusión de movimiento.
        Item.SubItem subItem = (Item.SubItem) subItems.get(subItemIndex);
        //Verificar que no suba más arriba que el index del primer Item del layout
        if (direccion < 0 && subItemIndex == 0 && itemIndex == 0) {
            System.out.println("X SubItem no puede moverse más arriba. Ya está en el primer Item en posición 0.");
            return;
        }
        //Verifica si el subItems ya está en el final de todos los componentes del layout.
        if (direccion > 0 && itemIndex == items.size() - 1 && subItemIndex == subItems.size() - 1) {
            System.out.println("X SubItem no puede moverse más abajo. Ya está al final del último Item.");
            return;
        }

        if (!animated) {
            subItems.remove(subItemIndex);
            int nuevoIndex = subItemIndex + direccion;

            if (nuevoIndex >= 0 && nuevoIndex <= subItems.size()) {
                subItems.add(nuevoIndex, subItem);
                System.out.println("OK SubItem " + subItem.getSubItemId() + " se movió dentro del Item " + itemActual.getItemId() + " de " + subItemIndex + " a " + nuevoIndex + ".");
            } else if (direccion < 0 && itemIndex > 0) {
                Item anterior = items.get(itemIndex - 1);
                anterior.getSubItems().add(subItem);
                System.out.println("OK SubItem " + subItem.getSubItemId() + " se movió de Item " + itemActual.getItemId() + " a Item " + anterior.getItemId() + " (al final).");
            } else if (direccion > 0 && itemIndex < items.size() - 1) {
                Item siguiente = items.get(itemIndex + 1);
                siguiente.getSubItems().add(0, subItem);
                System.out.println("OK SubItem " + subItem.getSubItemId() + " se movió de Item " + itemActual.getItemId() + " a Item " + siguiente.getItemId() + " (al inicio).");
            } else {
                subItems.add(subItemIndex, subItem);
                System.out.println("X Movimiento inválido. SubItem no se movió.");
            }
            return;
        }

        //-------Lógica de animación--------------------------------------------
        ToggleListAnimationLayout layout = itemActual.getToggleListLayout();
        if (layout == null) {
            System.out.println("X No se encontró el layout para la animación.");
            return;
        }
        //subItem en blanco para colocar la "foto" del subItem real de quies se ha sacado la "foto".
        SubItemBlank blank = subItemBlank;
        if (blank == null) {
            System.out.println("X No se proporcionó una instancia de SubItemBlank.");
            return;
        }

        // Determinar el tipo de movimiento
        // subItem moviéndose al siguiente Item.
        // subItem moviéndose al anterior Item
        // subItem moviéndose entre la lista de subItems de un mismo Item
        boolean movingToNextItem = (direccion > 0) && (subItemIndex == subItems.size() - 1) && (itemIndex < items.size() - 1);
        boolean movingToPreviousItem = (direccion < 0) && (subItemIndex == 0) && (itemIndex > 0);
        boolean movingWithinItem = !movingToNextItem && !movingToPreviousItem;

        if (movingWithinItem) {
            // --- Animación de intercambio dentro del mismo Item ---
            int swapIndex = subItemIndex + direccion;
            //Guardar el subItem el item real que debe expandirse en la animación.
            Item.SubItem subItemToGrow = (Item.SubItem) subItems.get(swapIndex);
            // Segun la dirección se determina si se mueve un indice arrba(-1) o abajo(+1)
            Collections.swap(subItems, subItemIndex, swapIndex);
            //Creamos la imagen del item que interventdrá en la ilusión de animación., el que se expandirá.
            blank.setComponentToImage(subItemToGrow);
            if (direccion > 0) {
                // Hacia abajo: , indice +1 del subItem al cual se le dará la ilusión de movimiento.
                subItems.add(swapIndex + 1, blank);
            } else {
                // Hacia arriba: en el mismo índice para que ocupe el lugar e índice del subItem a quien se dará la ilusión de movimiento.
                subItems.add(swapIndex, blank);
            }
            //Renderizar todos los componentes que ya estpan ordenados.
            layout.renderAnimatedItems(items);
            //Ocultar el subItem real para expandir su tamaño mediante animacion.
            layout.getMigLayout().setComponentConstraints(subItemToGrow, "growx, h 0!"); // Ocultar el real (altura 0)
            //Asegurar que el subItem blanco sea visible en el layout.
            layout.getMigLayout().setComponentConstraints(blank, "growx");
            layout.revalidate();
            layout.repaint();
            VerComponentes.verComponentes();
            
            // Tomando la altura del subItem que se debe expandir mediante animación.
            int subItemHeight = subItemToGrow.getPreferredSize().height;
            this.animadorRedimensionSubItems.animarRedimension(
                    layout,
                    blank, // subItem blanco que se reducirá el tamaño.
                    subItemToGrow, // subItem el cual se expandirá.
                    subItemHeight,
                    true,
                    () -> {//Runnble que se ejecutará cuando termine la animasión de expandir reducir.
                        subItems.remove(blank);//removemos el subItem en blanco de la lista de subItems.
                        layout.remove(blank);//removemos el subItem en blanco del layout.
                        //Asegurar que se ocupe todo el ancho del layout.
                        layout.getMigLayout().setComponentConstraints(subItemToGrow, "growx");
                        layout.renderItems(items); //Renderizar todos los componentes
                        VerComponentes.verComponentes();
                    }
            );

        } else {
            // --- Movimientos de subItem entre Items ---
            //Respaldando el subItem a quien se le dará la ilusión de movimiento.
            Item.SubItem movingSubItem = subItem;
            //Tomamos la "foto" del subItem a quien se le dará al ilusión de movimiento.
            blank.setComponentToImage(movingSubItem);
            //Valida si el item al que se trasladará el subItem tiene o no visibles sus subItems 
            //Si no está visible, entonces la animación de expandir no se dará pero la animación de reducir si se podrá ver.
            //Si están visibles, entonces las animaciones de expandir y reducir se podrán observar.
            boolean itemIsShowingSubItems = false;
            // subIem moviéndose al siguiente Item.
            if (movingToNextItem) {
                //Tomamos el siguiente item al item parent del subItem al que se dará la ilusión de movimiento.
                Item nextItem = items.get(itemIndex + 1);
                //Si se está o no mostrando los subItems del siguiente Item.
                itemIsShowingSubItems = nextItem.getToggleList().isShowing();
                //Colocamos el subItem blanco en el mismo indice del subItem que se dará la ilusión de movimeinto, en este caso hacia abajo.
                subItems.add(subItemIndex, blank);
                //Retiramos de la lista de subItems el subItem al cual se le dará la ilusión de movimiento.
                subItems.remove(movingSubItem);
                //Agregamos en el indice cero en la lista de subItems del item siguiente.
                nextItem.getSubItems().add(0, movingSubItem);
            } else { //sunIem moviéndose al anterior Item.
                //Tomamos el anterior Item al item parent del subItem al que se darpa la ilusión de movimiento.
                Item prevItem = items.get(itemIndex - 1);
                //Si se está o no mostrando los subItems del siguiente Item.
                itemIsShowingSubItems = prevItem.getToggleList().isShowing();
                //Colocamos el subItem blanco en el mismo indice del subItem que se dará la ilusión de movimeinto, en este caso hacia arriba.
                subItems.add(subItemIndex, blank);
                //Retiramos de la lista de subItems el subItem al cual se le dará la ilusión de movimiento.
                subItems.remove(movingSubItem);
                //Agregamos el item al que se dará la ilusión de movimiento en el Item anterior, lo agregamos por defecto para que se vaya al final de la lista de subItems del Item anterior.
                prevItem.getSubItems().add(movingSubItem);
            }

            // Renderizar todos los componentes ya teniendo el orden deseado.
            layout.renderAnimatedItems(items);
            //Ocultar el subItem real que se expandirá con animación.
            layout.getMigLayout().setComponentConstraints(movingSubItem, "growx, h 0!");
            //Asegurar que el subItem en blanco sea visible
            layout.getMigLayout().setComponentConstraints(blank, "growx");
            layout.revalidate();
            layout.repaint();
            VerComponentes.verComponentes();

            //Tomamos la altura del subItem a expandir mediante animación.
            int subItemHeight = movingSubItem.getPreferredSize().height;

            this.animadorRedimensionSubItems.animarRedimension(
                    layout,
                    blank, //subItem en blanco que se reducirá su tamaño mediante animación.
                    movingSubItem,//subItem que se expandirá su tamaño mediante animación.
                    subItemHeight,
                    itemIsShowingSubItems,
                    () -> {
                        //Removmos el subItem en blanco de la lista de subItems.
                        subItems.remove(blank);
                        //Removemos el subItem en blanco del layout.
                        layout.remove(blank);
                        //Aseguramos que el item que se expandió sea visible.
                        layout.getMigLayout().setComponentConstraints(movingSubItem, "growx");
                        //Renderizar todos los componentes ya ordenados.
                        layout.renderItems(items);
                        VerComponentes.verComponentes();

                    });
        }
    }

    /**
     * Animar la eliminación de un Item.
     *
     * @param layout Clase {@link ToggleListAnimationLayout}
     * @param itemAEliminar El item a elimnar.
     * @param onEnd Runnable a ejecutarse cuando termine la animación.
     */
    public void eliminarItem(JComponent layout, Item itemAEliminar, Runnable onEnd) {
        this.animadorEliminacionItems.animarParaEliminar(layout, itemAEliminar, onEnd);
    }

    /**
     * Animar la eliminación de un SubItem.
     *
     * @param layout Clase {@link ToggleListAnimationLayout}
     * @param subItemAEliminar El subItem a elimnar.
     * @param onEnd Runnable a ejecutarse cuando termine la animación.
     */
    public void eliminarSubItem(JComponent layout, Item.SubItem subItemAEliminar, Runnable onEnd) {
        this.animadorEliminacionSubItems.animarParaEliminar(layout, subItemAEliminar, onEnd);
    }

}
