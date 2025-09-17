# ToggleList Animation Layout para Java Swing

Un componente de layout para Java Swing, potente y reutilizable, que da vida a tus listas con animaciones fluidas para expandir/ocultar sub-ítems y reordenarlos mediante arrastrar y soltar (drag-and-drop).

Es ideal para crear interfaces de usuario modernas, dinámicas e intuitivas en aplicaciones de escritorio.

---

## Demostración
### Estructura de la lista
![Demostración de Toggle Animado](https://github.com/JuanMonta/DnD_UnD_ToggleListAnimationLayout-For-Java-Swing/blob/master/gifs/EstructuraLista.png?raw=true)

### Expansión y Colapso de Items
Aquí puedes ver cómo los sub-ítems se muestran y ocultan con una animación fluida.
![Demostración de Toggle Animado](https://github.com/JuanMonta/DnD_UnD_ToggleListAnimationLayout-For-Java-Swing/blob/master/gifs/AnimationItemShow.gif?raw=true)

### Reubicación de Items y SubItems con movimiento Arriba-Abajo
#### Movimiento de Items.
![Demostración de Movimiento Arriba Abajo Items ](https://github.com/JuanMonta/DnD_UnD_ToggleListAnimationLayout-For-Java-Swing/blob/master/gifs/AnimationItemUnD01.gif?raw=true)

#### Movimiento de Sub-Items dentro de un mismo Item.
![Demostración de Movimiento Arriba Abajo Items ](https://github.com/JuanMonta/DnD_UnD_ToggleListAnimationLayout-For-Java-Swing/blob/master/gifs/AnimationSubItemUnD01.gif?raw=true)

#### Movimiento de Sub-Items entre diferentes Items.
![Demostración de Movimiento Arriba Abajo Items ](https://github.com/JuanMonta/DnD_UnD_ToggleListAnimationLayout-For-Java-Swing/blob/master/gifs/AnimationSubItemUnD02.gif?raw=true)

### Arrastrar y Soltar para Reordenar
Observa la facilidad para reordenar ítems y sub-ítems. Los demás elementos se mueven suavemente para hacer espacio.

#### Demostración arrastrar y soltar Items.
![Demostración de Arrastrar y Soltar Items 01](https://github.com/JuanMonta/DnD_UnD_ToggleListAnimationLayout-For-Java-Swing/blob/master/gifs/AnimationItemDnD01.gif?raw=true)

#### Demostración arrastrar y soltar Items con Sub-Items expandidos.
![Demostración de Arrastrar y Soltar Items 02](https://github.com/JuanMonta/DnD_UnD_ToggleListAnimationLayout-For-Java-Swing/blob/master/gifs/AnimationItemDnD02.gif?raw=true)

#### Demostración arrastrar y soltar Sub-Items dentro de un mismo Item.
![Demostración de Arrastrar y Soltar Sub-Items 01](https://github.com/JuanMonta/DnD_UnD_ToggleListAnimationLayout-For-Java-Swing/blob/master/gifs/AnimationSubItemDnD01.gif?raw=true)

#### Demostración arrastrar y soltar Sub-Items entre diferentes Items.
![Demostración de Arrastrar y Soltar Sub-Items 02](https://github.com/JuanMonta/DnD_UnD_ToggleListAnimationLayout-For-Java-Swing/blob/master/gifs/AnimationSubItemDnD02.gif?raw=true)

Moviendo Sub-Items entre Items que 
- No tienen su lista de Sub-Items expandida
- Items sin Sub-Items
- Item que no tenga Sub-Items pero aún así con el atributo de mostrar lista de Sub-Items expandida.

![Demostración de Arrastrar y Soltar Sub-Items 03](https://github.com/JuanMonta/DnD_UnD_ToggleListAnimationLayout-For-Java-Swing/blob/master/gifs/AnimationSubItemDnD03.gif?raw=true)

### Eliminación de un Item y SubItem de la lista.
Eliminación de elementos de la lista con una animación suave.

#### Eliminación de un Item.
![Demostración de Eliminación de Item](https://github.com/JuanMonta/DnD_UnD_ToggleListAnimationLayout-For-Java-Swing/blob/master/gifs/AnimationDeleteItem.gif?raw=true)

#### Eliminación de un SubItem.
![Demostración de Eliminación de SubItem](https://github.com/JuanMonta/DnD_UnD_ToggleListAnimationLayout-For-Java-Swing/blob/master/gifs/AnimationDeleteSubItem.gif?raw=true)
---

## Características Principales

- **Lista Anidable con Toggle Animado:** Los ítems pueden contener sub-ítems que se muestran y ocultan con una animación suave.
- **Arrastrar y Soltar (Drag and Drop):** Reordena ítems y sub-ítems de forma intuitiva simplemente arrastrándolos a su nueva posición.
- **Animaciones Inteligentes de Reordenamiento:** Al arrastrar un ítem, los demás se desplazan suavemente para hacerle espacio, proporcionando una experiencia de usuario muy pulida.
- **Componente JavaBean:** Diseñado desde cero para ser un componente reutilizable. Incluye una clase `BeanInfo` para una integración perfecta con la paleta de diseñadores GUI como el de NetBeans.
- **Construido sobre MigLayout:** Aprovecha la flexibilidad y potencia del gestor de layouts MigLayout.

---

## Cómo Usarlo

Este es un proyecto de Maven, por lo que la forma más fácil de usarlo es añadiéndolo como una dependencia a tu `pom.xml`.

*(Pendiente de publicar el artefacto en un repositorio Maven Central. Alternativamente, por ahora un usuario puede clonar el proyecto y construir el JAR localmente para añadirlo a su proyecto.)*

### Dependencia de Maven

```xml
<dependency>
    <groupId>com.github.tu-usuario</groupId>
    <artifactId>TestComponents07_ToggleList_ItemAnimation8</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Ejemplo de Código
Crea y customiza el diseño de tu propio modelo de Item y subItem.
```java
//=======PARA CREAR EL MODELO DE ITEM===========
import AnimationLayout.Item;
// Item extiende de JPanel
public class MyItemComponent extends Item {

}

//=======PARA CREAR EL MODELO DE SUB-ITEM===========
import AnimationLayout.Item.SubItem;
// Item.SubItem extiende de JPanel
public class MySubItemComponent extends Item.SubItem {

}
```
Pobla la lista con tus ítems y sub-ítems customizados.

```java
import AnimationLayout.ToggleListAnimationLayout;
import MyItemComponent; //Asegurate de que tu componente extienda de Item.
import MySubItemComponent; //Asegurate de que tu componente extienda de Item.SubItem.


// --- En tu clase de UI ---

// 1. Una vez tengas tu instancia del layout en tu UI
ToggleListAnimationLayout listLayout = new ToggleListAnimationLayout();

// 2. Crea tus componentes de ítem (que deben extender de AnimationLayout.Item)
//    Añadele informacion (opcional) a tu componente con los metodos incluidos 
//    al exteder la clase Item.
MyItemComponent itemComponent1 = new MyItemComponent();
itemComponent1.setItemId("1");
itemComponent1.setItemTitle("Item 01");
itemComponent1.setItemSubTitle("SubTittle 01");
// 3. Crea tus subItems a partir de tu componente (que deben extender de AnimationLayout.Item.SubItem)
//    Añadele informacion (opcional) a tu componente con los metodos incluidos 
//    al exteder la clase Item.SubItem.
MySubItemComponent subItemComponent11 = new MySubItemComponent();
subItemComponent11.setSubItemId("11");
subItemComponent11.setSubItemTitle("SubItem 11");
subItemComponent11.setSubItemSubTitle("SubItemTitle 11");

MySubItemComponent subItemComponent12 = new MySubItemComponent();
subItemComponent12.setSubItemId("12");
subItemComponent12.setSubItemTitle("SubItem 12");
        subItemComponent12.setSubItemSubTitle("SubItemTitle 12");

MySubItemComponent subItemComponent13 = new MySubItemComponent();
subItemComponent13.setSubItemId("13");
subItemComponent13.setSubItemTitle("SubItem 13");
subItemComponent13.setSubItemSubTitle("SubItemTitle 13");
// 4. Añade tus subItems a tu Item
itemComponent1.addSubItem(subItemComponent11);
itemComponent1.addSubItem(subItemComponent12);
itemComponent1.addSubItem(subItemComponent13);

//=======SIGUE CREANDO MÁS ITEMS Y SUBITEMS
ItemComponent itemComponent2 = new ItemComponent();
itemComponent2.setItemId("2");
itemComponent2.setItemTitle("Item 02");
itemComponent2.setItemSubTitle("SubTittle 02");

SubItemComponent subItemComponent2 = new SubItemComponent();
subItemComponent2.setSubItemId("21");
subItemComponent2.setSubItemTitle("SubItem 21");
subItemComponent2.setSubItemSubTitle("SubItemTitle 21");

itemComponent2.addSubItem(subItemComponent2);
        
//Los items pueden crearse sin necesariamente tener subItems
ItemComponent itemComponent3 = new ItemComponent();
itemComponent3.setItemId("3");
itemComponent3.setItemTitle("Item 03");
itemComponent3.setItemSubTitle("SubTittle 03");

// 5. Crea un ArrayList<item>  donde guardar tus items
ArrayList<AnimationLayout.Item> listaItems = new ArrayList();
listaItems.add(itemComponent1);
listaItems.add(itemComponent2);
listaItems.add(itemComponent3);

// 6. Agrega los items al layout ToggleListAnimationLayout 
// usando el método .renderItems(...)
listLayout.renderItems(listaItems);
```

---

## Cómo Construir el Proyecto

Puedes construir el componente tú mismo fácilmente.

1.  **Clona el repositorio:**
    ```sh
    git clone https://github.com/tu-usuario/tu-repositorio.git
    ```
2.  **Navega al directorio del proyecto:**
    ```sh
    cd tu-repositorio
    ```
3.  **Ejecuta el comando de construcción de Maven:**
    ```sh
    mvn clean install
    ```
4.  El archivo `.jar` del componente estará disponible en el directorio `target/`.
