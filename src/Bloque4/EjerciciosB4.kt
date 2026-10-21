package Bloque4

import Utilidades.*

// ===================================================================
// EJERCICIOS DEL BLOQUE 4 · Nulos y colecciones
// Cada función b4EjercicioN() es el "main" de su ejercicio: pide los
// datos, llama a las funciones de FuncionesB4.kt y muestra el resultado.
// ===================================================================

// ===================================================================
// EJERCICIO 1 · Entrada segura
// ===================================================================

/**
 * Ejercicio 1 · Entrada segura.
 *
 * Pide la edad y el número de entradas con [leerEnteroOPorDefecto] y muestra
 * los dos valores. Si el usuario no escribe un número, se usan
 * [EDAD_POR_DEFECTO] y [ENTRADAS_POR_DEFECTO].
 */
fun b4Ejercicio1() {
    val edad = leerEnteroOPorDefecto("Edad [$EDAD_POR_DEFECTO]: ", EDAD_POR_DEFECTO)
    val entradas = leerEnteroOPorDefecto("Número de entradas [$ENTRADAS_POR_DEFECTO]: ", ENTRADAS_POR_DEFECTO)

    println("Edad: $edad")
    println("Entradas: $entradas")
}

// ===================================================================
// EJERCICIO 2 · Predice la salida
// ===================================================================

/**
 * Ejercicio 2 · Predice la salida.
 *
 * Ejecuta siete expresiones con el operador de llamada segura `?.`, el
 * operador Elvis `?:` y `toIntOrNull()`. La predicción y la explicación de
 * cada resultado están en los comentarios.
 */
fun b4Ejercicio2() {
    val a: String? = "Kotlin"
    val b: String? = null

    // PREDICCIÓN: 6
    // a no es null, así que a?.length calcula la longitud de "Kotlin".
    println(a?.length)

    // PREDICCIÓN: null
    // b es null: ?. no llama a length y toda la expresión vale null.
    // No da error: println(null) escribe la palabra "null".
    println(b?.length)

    // PREDICCIÓN: -1
    // b?.length vale null, así que ?: usa el valor de la derecha.
    println(b?.length ?: -1)

    // PREDICCIÓN: Kotlin
    // a no es null, así que ?: devuelve a y no llega a usar "vacío".
    println(a ?: "vacío")

    // PREDICCIÓN: vacío
    // b es null, así que ?: devuelve el valor de la derecha.
    println(b ?: "vacío")

    // PREDICCIÓN: 13
    // "12".toIntOrNull() da 12 (Int?), y ?.plus(1) le suma 1.
    println("12".toIntOrNull()?.plus(1))

    // PREDICCIÓN: 0
    // "doce".toIntOrNull() da null, ?.plus(1) no se ejecuta y queda null,
    // y ?: lo sustituye por 0.
    println("doce".toIntOrNull()?.plus(1) ?: 0)
}

// ===================================================================
// EJERCICIO 3 · Agenda de contactos
// ===================================================================

/**
 * Ejercicio 3 · Agenda de contactos.
 *
 * Muestra un menú que se repite hasta elegir «Salir» y gestiona una lista
 * mutable de nombres. Cada opción está en su propia función:
 * [anadirContacto], [mostrarContactos], [buscarContacto] y [eliminarContacto].
 * Una opción no válida muestra un error y vuelve a pintar el menú.
 */
fun b4Ejercicio3() {
    val contactos = mutableListOf<String>()
    var entrada = ""

    do {
        println()
        println("--- AGENDA DE CONTACTOS ---")
        println("1. Añadir contacto")
        println("2. Mostrar contactos")
        println("3. Buscar contacto")
        println("4. Eliminar contacto")
        println("5. Salir")
        entrada = leerTexto("Elige una opción: ")

        when (entrada) {
            "1" -> anadirContacto(contactos)
            "2" -> mostrarContactos(contactos)
            "3" -> buscarContacto(contactos)
            "4" -> eliminarContacto(contactos)
            "5" -> mostrarAviso("Saliendo de la agenda...")
            else -> mostrarError("Opción no válida. Elige un número del 1 al 5.")
        }
    } while (entrada != "5")
}

// ===================================================================
// EJERCICIO 4 · Análisis de notas
// ===================================================================

/**
 * Ejercicio 4 · Análisis de notas.
 *
 * Analiza una lista fija de notas con [mediaNotas], [notaMasAlta],
 * [notaMasBaja], [contarAprobados], [suspensosOrdenados], [subirUnPunto]
 * y [hayAlgunDiez].
 */
fun b4Ejercicio4() {
    val notas = listOf(7.5, 4.0, 9.0, 5.5, 3.0, 8.0, 6.5)

    println("Notas: $notas")
    println("Nota media: ${formatearB4(mediaNotas(notas))}")
    println("Nota más alta: ${notaMasAlta(notas)}")
    println("Nota más baja: ${notaMasBaja(notas)}")
    println("Aprobados: ${contarAprobados(notas)} de ${notas.size}")
    println("Suspensos (de menor a mayor): ${suspensosOrdenados(notas)}")
    println("Notas subidas un punto: ${subirUnPunto(notas)}")
    println("¿Algún 10? ${if (hayAlgunDiez(notas)) "Sí" else "No"}")
}

// ===================================================================
// EJERCICIO 5 · Visitantes únicos
// ===================================================================

/**
 * Ejercicio 5 · Visitantes únicos.
 *
 * A partir de una lista de visitas, muestra el total de visitas, los usuarios
 * distintos ([usuariosUnicos]) y cuántas veces visitó la página cada uno
 * ([visitasPorUsuario]).
 */
fun b4Ejercicio5() {
    val visitas = listOf("ana", "luis", "ana", "marta", "luis", "ana", "pablo")
    val unicos = usuariosUnicos(visitas)

    println("Visitas totales: ${visitas.size}")
    println("Usuarios distintos: ${unicos.size}")
    println("Usuarios: $unicos")
    println("Visitas por usuario:")
    for ((usuario, veces) in visitasPorUsuario(visitas)) {
        println("  $usuario: $veces")
    }
}

// ===================================================================
// EJERCICIO 6 · Lista de productos
// ===================================================================

/**
 * Ejercicio 6 · Lista de productos.
 *
 * Gestiona un `MutableMap<String, Double>` (producto -> precio) con un menú.
 * Cada operación está en su propia función: [mostrarProductos],
 * [anadirOActualizarProducto], [eliminarProducto], [mostrarPrecioProducto],
 * [mostrarMasBaratos] y [mostrarResumenCatalogo].
 */
fun b4Ejercicio6() {
    val productos = mutableMapOf(
        "teclado" to 25.0,
        "ratón" to 12.5,
        "monitor" to 149.99,
        "auriculares" to 39.9
    )
    var entrada = ""

    do {
        println()
        println("--- LISTA DE PRODUCTOS ---")
        println("1. Mostrar productos")
        println("2. Añadir o actualizar producto")
        println("3. Eliminar producto")
        println("4. Consultar precio")
        println("5. Productos más baratos que...")
        println("6. Valor total y producto más caro")
        println("7. Salir")
        entrada = leerTexto("Elige una opción: ")

        when (entrada) {
            "1" -> mostrarProductos(productos)
            "2" -> anadirOActualizarProducto(productos)
            "3" -> eliminarProducto(productos)
            "4" -> mostrarPrecioProducto(productos)
            "5" -> mostrarMasBaratos(productos)
            "6" -> mostrarResumenCatalogo(productos)
            "7" -> mostrarAviso("Saliendo de la lista de productos...")
            else -> mostrarError("Opción no válida. Elige un número del 1 al 7.")
        }
    } while (entrada != "7")
}

// ===================================================================
// RETO · Tienda con stock
// ===================================================================

/**
 * Reto · Tienda con stock.
 *
 * Tienda con menú que usa un mapa de precios, un mapa de stock y una lista
 * mutable como carrito. Solo se puede añadir un producto si queda stock, y al
 * añadirlo el stock baja en uno. Ninguna entrada hace fallar el programa y no
 * se usa `!!` en ningún sitio.
 */
fun b4Reto() {
    val precios = mapOf("camiseta" to 15.0, "gorra" to 9.5, "taza" to 7.25, "sudadera" to 32.0)
    val stock = mutableMapOf("camiseta" to 3, "gorra" to 1, "taza" to 5, "sudadera" to 0)
    val carrito = mutableListOf<String>()
    var entrada = ""

    do {
        println()
        println("--- TIENDA ---")
        println("1. Ver productos")
        println("2. Añadir al carrito")
        println("3. Ver carrito")
        println("4. Terminar la compra")
        println("5. Salir sin comprar")
        entrada = leerTexto("Elige una opción: ")

        when (entrada) {
            "1" -> mostrarCatalogoTienda(precios, stock)
            "2" -> anadirAlCarrito(precios, stock, carrito)
            "3" -> mostrarCarrito(precios, carrito)
            "4" -> if (carrito.isEmpty()) {
                mostrarAviso("El carrito está vacío.")
                entrada = ""            // no se termina: sigue en la tienda
            } else {
                mostrarTicket(precios, carrito)
            }
            "5" -> mostrarAviso("Has salido sin comprar.")
            else -> mostrarError("Opción no válida. Elige un número del 1 al 5.")
        }
    } while (entrada != "4" && entrada != "5")
}