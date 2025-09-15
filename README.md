# ToggleList Animation Layout para Java Swing

Un componente de layout para Java Swing, potente y reutilizable, que da vida a tus listas con animaciones fluidas para expandir/ocultar sub-ítems y reordenarlos mediante arrastrar y soltar (drag-and-drop).

Es ideal para crear interfaces de usuario modernas, dinámicas e intuitivas en aplicaciones de escritorio.

---

## Demostración

### Expansión y Colapso de Ítems
Aquí puedes ver cómo los sub-ítems se muestran y ocultan con una animación fluida.

![Demostración de Toggle Animado](https://via.placeholder.com/600x300.png?text=REEMPLAZAR+CON+GIF+DE+ANIMACIÓN+DE+TOGGLE)
*(Pendiente de reemplazar la imagen de arriba con un GIF del componente en acción)*

### Arrastrar y Soltar para Reordenar
Observa la facilidad para reordenar ítems y sub-ítems. Los demás elementos se mueven suavemente para hacer espacio.

![Demostración de Arrastrar y Soltar](https://via.placeholder.com/600x300.png?text=REEMPLAZAR+CON+GIF+DE+DRAG+AND+DROP)
*(Pendiente de reemplazar la imagen de arriba con un GIF del componente en acción)*

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
Crea y customiza el diseño de tu propio modelo de Item.
```java
import AnimationLayout.ToggleListAnimationLayout;
import AnimationLayout.Components.Item; // Asegúrate de que tus componentes hereden de esta clase

// --- En tu clase de UI ---

// 1. Crea una instancia del layout
ToggleListAnimationLayout listLayout = new ToggleListAnimationLayout();

// 2. Crea tus componentes de ítem (que deben extender de AnimationLayout.Components.Item)
//    y sub-ítems (que deben extender de AnimationLayout.Components.Item.SubItem)
ItemComponent item1 = new ItemComponent("ID-1", "Configuración General");
ItemComponent item2 = new ItemComponent("ID-2", "Perfil de Usuario");

SubItemComponent subItem2_1 = new SubItemComponent("SUB-ID-2-1", "Cambiar nombre");
SubItemComponent subItem2_2 = new SubItemComponent("SUB-ID-2-2", "Cambiar avatar");
item2.addSubItem(subItem2_1);
item2.addSubItem(subItem2_2);

ItemComponent item3 = new ItemComponent("ID-3", "Notificaciones");

// 3. Añade los ítems al layout
listLayout.addItem(item1);
listLayout.addItem(item2);
listLayout.addItem(item3);

// 4. Añade el layout a tu JFrame o JPanel principal
miPanelPrincipal.add(listLayout, "grow, push"); // Usando MigLayout, por ejemplo
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
