# Tetris

Hola Juan, no voy a borrar lo que viene abajo de Platforms y Gradle por si acaso nos hace falta. Nos ponemos por aquí lo que veamos interesante de añadir al código.

El código lo trabajamos integramente en core pero ejecutamos desde la clase main que hay en lwjgl3 :)


## 🔹 **Cómo Representar una Ficha en Código**

Las piezas de Tetris se pueden representar con **matrices de enteros** (arrays bidimensionales).

* Un **`1`** indica que hay un bloque en esa posición.
* Un **`0`** indica que está vacío.

Ejemplo:
📌 **Ficha cuadrada (O)**

```plaintext
1 1
1 1
```

Se representa en código como:

```java
int[][] formaO = {
    {1, 1},
    {1, 1}
};
```

📌 **Ficha T**

```plaintext
0 1 0
1 1 1
```

Se representa como:

```java
int[][] formaT = {
    {0, 1, 0},
    {1, 1, 1}
};
```

📌 **Ficha L**

```plaintext
1 0
1 0
1 1
```

Se representa como:

```java
int[][] formaL = {
    {1, 0},
    {1, 0},
    {1, 1}
};
```

Cada ficha tiene su propia estructura de `1`s y `0`s.

---

## 🔹 **Cómo Se Usa en el Tablero**

El **tablero de Tetris** también es una matriz (ejemplo: `10x20` casillas).

* Para **dibujar una ficha en el tablero**, simplemente copias su estructura en la posición donde aparecerá.
* Para **moverla o rotarla**, cambias su posición en la matriz.

Ejemplo de un tablero vacío (`0`s representan espacios vacíos):

```plaintext
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
```

Si agregamos una ficha "O" en la posición (4,0):

```plaintext
0 0 0 0 1 1 0 0 0 0
0 0 0 0 1 1 0 0 0 0
0 0 0 0 0 0 0 0 0 0
```

---

## 🔹 **Cómo Funciona la Fábrica de Fichas**

En lugar de definir cada ficha manualmente cada vez que la necesitamos, podemos usar un **método estático** en una clase `FichaFactory` que devuelva fichas según el tipo.

📌 **Ejemplo de una `FichaFactory` en Java:**

```java
public class FichaFactory {
    public static Ficha crearFicha(char tipo) {
        switch (tipo) {
            case 'I':
                return new Ficha(new int[][]{
                    {1, 1, 1, 1}
                }, Color.CYAN);
            case 'O':
                return new Ficha(new int[][]{
                    {1, 1},
                    {1, 1}
                }, Color.YELLOW);
            case 'T':
                return new Ficha(new int[][]{
                    {0, 1, 0},
                    {1, 1, 1}
                }, Color.PURPLE);
            case 'L':
                return new Ficha(new int[][]{
                    {1, 0},
                    {1, 0},
                    {1, 1}
                }, Color.ORANGE);
            case 'J':
                return new Ficha(new int[][]{
                    {0, 1},
                    {0, 1},
                    {1, 1}
                }, Color.BLUE);
            case 'S':
                return new Ficha(new int[][]{
                    {0, 1, 1},
                    {1, 1, 0}
                }, Color.GREEN);
            case 'Z':
                return new Ficha(new int[][]{
                    {1, 1, 0},
                    {0, 1, 1}
                }, Color.RED);
            default:
                throw new IllegalArgumentException("Tipo de ficha desconocido: " + tipo);
        }
    }
}
```

📌 **Ejemplo de Uso:**

```java
Ficha fichaT = FichaFactory.crearFicha('T');
```

Esto generará automáticamente una ficha **T** con su matriz correspondiente.

---








## Platforms

- `core`: Main module with the application logic shared by all platforms.
- `lwjgl3`: Primary desktop platform using LWJGL3; was called 'desktop' in older docs.

## Gradle

This project uses [Gradle](https://gradle.org/) to manage dependencies.
The Gradle wrapper was included, so you can run Gradle tasks using `gradlew.bat` or `./gradlew` commands.
Useful Gradle tasks and flags:

- `--continue`: when using this flag, errors will not stop the tasks from running.
- `--daemon`: thanks to this flag, Gradle daemon will be used to run chosen tasks.
- `--offline`: when using this flag, cached dependency archives will be used.
- `--refresh-dependencies`: this flag forces validation of all dependencies. Useful for snapshot versions.
- `build`: builds sources and archives of every project.
- `cleanEclipse`: removes Eclipse project data.
- `cleanIdea`: removes IntelliJ project data.
- `clean`: removes `build` folders, which store compiled classes and built archives.
- `eclipse`: generates Eclipse project data.
- `idea`: generates IntelliJ project data.
- `lwjgl3:jar`: builds application's runnable jar, which can be found at `lwjgl3/build/libs`.
- `lwjgl3:run`: starts the application.
- `test`: runs unit tests (if any).

Note that most tasks that are not specific to a single project can be run with `name:` prefix, where the `name` should be replaced with the ID of a specific project.
For example, `core:clean` removes `build` folder only from the `core` project.
