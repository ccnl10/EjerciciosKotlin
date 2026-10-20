# UT1 · Fundamentos de Kotlin

Aplicación de consola que reúne los ejercicios resueltos de la **UT1** del módulo
*Desarrollo de Interfaces* (2º DAM). Desde un menú principal se elige el bloque y,
después, el ejercicio que se quiere ejecutar.

| Bloque | Contenido | Ejercicios |
|---|---|---|
| Bloque 1 | Variables, tipos de datos, operadores y plantillas de cadena | 6 |
| Bloque 2 | Condicionales (`if`, `when`), rangos y bucles | 6 + reto |
| Bloque 3 · parte 1 | Funciones: parámetros, valores por defecto, argumentos con nombre, retornos anticipados | 6 + 2 retos |
| Bloque 3 · parte 2 | Expresiones lambda y funciones de orden superior | 6 + reto |

## Requisitos

- JDK 21 (configurado: Microsoft OpenJDK 21). Sirve cualquier JDK 17 o superior.
- IntelliJ IDEA con el plugin de Kotlin (incluido de serie).
- Kotlin 2.4. El proyecto es un módulo de IntelliJ, sin Gradle.

## Cómo ejecutarlo

1. Abre la carpeta `prueba_1` en IntelliJ (**File → Open**).
2. Abre `src/Main.kt`.
3. Pulsa el ▶ verde junto a `fun main()`.

En cada menú, escribe el número de la opción y pulsa Intro. Escribe `?` para ver la
ayuda del menú. La última opción numerada vuelve al menú anterior; en el menú
principal, cierra el programa.

Para ejecutarlo fuera de IntelliJ, genera un `.jar` (ver el manual técnico) y en Windows:

```
chcp 65001
java -jar prueba_1.jar
```

## Estructura

```
src/
├── Main.kt                 main() y menú principal
├── Utilidades/
│   ├── Colores.kt          Colores ANSI, mostrarAviso(), mostrarError()
│   └── Ayuda.kt            mostrarAyuda(): cuadro de ayuda común a todos los menús
├── Bloque1/
│   ├── MenuB1.kt           menuBloque1()
│   └── Ejercicios1.kt      b1Ejercicio1() … b1Ejercicio6()
├── Bloque2/
│   ├── MenuB2.kt           menuBloque2()
│   └── Ejercicios2.kt      b2Ejercicio1() … b2Ejercicio6(), b2Reto()
└── Bloque3/
    ├── MenuB3.kt           menuBloque3(): elige parte 1 o parte 2
    ├── MenuB3_1.kt         menuBloque3_1()
    ├── EjerciciosB3_1.kt   b3_1Ejercicio1() … b3_1RetoAdivina()
    ├── FuncionesB3_1.kt    Lógica de la parte 1 (funciones)
    ├── MenuB3_2.kt         menuBloque3_2()
    ├── EjerciciosB3_2.kt   b3_2Ejercicio1() … b3_2RetoReglaDescuento()
    └── FuncionesB3_2.kt    Lógica de la parte 2 (lambdas)
```

Capas: **menús** (navegación) → **ejercicios** (piden datos y muestran resultados) →
**funciones** (lógica). `Utilidades` la usan todos los menús y no depende de ningún bloque.

Los menús usan un bucle `do-while`: para volver al menú anterior, el bucle termina; nunca
se vuelve llamando otra vez al menú anterior (eso provocaría recursión).

## Colores de la consola

| Color | Uso |
|---|---|
| Verde | Menú principal |
| Azul | Menús de bloque |
| Cian | Submenús del bloque 3 |
| Amarillo | Avisos y ayuda |
| Rojo | Errores |

Los colores se ven en la consola de IntelliJ y en Windows Terminal. El cmd clásico de
Windows 10 puede mostrar los códigos como texto (`←[32m`).

## Documentación

| Documento | Contenido |
|---|---|
| Comentarios KDoc en el código | Descripción, `@param` y `@return` de cada función y constante |
| `docs/api/index.html` | Documentación HTML de la API generada a partir de los KDoc, con buscador |
| `docs/Manual_Usuario_UT1_Kotlin.docx` | Cómo usar el programa, con un ejemplo de cada ejercicio |
| `docs/Manual_Tecnico_UT1_Kotlin.docx` | Arquitectura, decisiones de diseño, ayuda, Dokka, distribución y cómo ampliar el proyecto |

## Añadir un bloque nuevo (resumen)

1. Crea el paquete `BloqueN` con `EjerciciosBN.kt` (y `FuncionesBN.kt` si hay lógica reutilizable).
2. Crea `MenuBN.kt` copiando el patrón de `MenuB2.kt`, con su función de ayuda.
3. En `Main.kt`: importa `BloqueN.menuBloqueN`, añade la opción al menú y al `when`,
   mueve «Salir» y actualiza la condición `while (opcion != …)` y `ayudaMenuPrincipal()`.
4. Documenta las funciones nuevas con KDoc.
