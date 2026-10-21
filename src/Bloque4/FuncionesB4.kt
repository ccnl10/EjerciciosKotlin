package Bloque4

import Utilidades.*
import java.util.Locale

// ===================================================================
// FUNCIONES DEL BLOQUE 4 · Nulos y colecciones
// Aquí está la lógica. Los ejercicios (EjerciciosB4.kt) solo las llaman.
// ===================================================================

// ===================================================================
// CONSTANTES
// ===================================================================

/** Edad que se usa en [b4Ejercicio1] si el usuario no escribe un número válido. */
const val EDAD_POR_DEFECTO = 18

/** Número de entradas que se usa en [b4Ejercicio1] si el usuario no escribe un número válido. */
const val ENTRADAS_POR_DEFECTO = 1

/** Nota mínima para aprobar en [b4Ejercicio4]. */
const val NOTA_APROBADO = 5.0

/** Nota máxima posible en [b4Ejercicio4]. */
const val NOTA_MAXIMA = 10.0

/** IVA que se aplica al carrito en [b4Reto], en %. */
const val IVA = 21.0

/**
 * Configuración regional española (es-ES): hace que [formatearB4] escriba
 * los decimales con coma. No es `const` porque `Locale` es un objeto.
 */
val ESPANOL_B4: Locale = Locale.forLanguageTag("es-ES")

// ===================================================================
// FUNCIONES AUXILIARES DEL BLOQUE
// ===================================================================

/**
 * Convierte un número decimal en texto con dos decimales y coma decimal.
 *
 * @param valor número que se va a formatear.
 * @return el número como texto, por ejemplo `"6,21"`.
 */
fun formatearB4(valor: Double): String = "%.2f".format(ESPANOL_B4, valor)

/**
 * Muestra un mensaje y lee una línea de texto sin espacios al principio ni al final.
 *
 * @param mensaje texto que se muestra antes de leer.
 * @return el texto escrito por el usuario (puede ser una cadena vacía).
 */
fun leerTexto(mensaje: String): String {
    print(mensaje)
    return readln().trim()
}

/**
 * Pide un número decimal positivo (mayor que 0) hasta que el usuario escribe
 * uno válido. Admite coma o punto decimal.
 *
 * @param mensaje texto que se muestra al pedir el número.
 * @return el número escrito por el usuario.
 */
fun leerDecimalPositivo(mensaje: String): Double {
    while (true) {
        val numero = leerTexto(mensaje).replace(',', '.').toDoubleOrNull()
        if (numero != null && numero > 0) return numero
        mostrarError("Escribe un número mayor que 0.")
    }
}

// ===================================================================
// EJERCICIO 1 · Entrada segura
// ===================================================================

/**
 * Muestra un mensaje, lee una línea y la devuelve como `Int`.
 *
 * Si el usuario no escribe un número entero válido, `toIntOrNull()` devuelve
 * `null` y el operador Elvis `?:` hace que se devuelva [porDefecto].
 *
 * @param mensaje texto que se muestra al pedir el número.
 * @param porDefecto valor que se devuelve si la entrada no es un número.
 * @return el número escrito por el usuario, o [porDefecto].
 */
fun leerEnteroOPorDefecto(mensaje: String, porDefecto: Int): Int {
    print(mensaje)
    return readln().trim().toIntOrNull() ?: porDefecto
}

// ===================================================================
// EJERCICIO 3 · Agenda de contactos
// ===================================================================

/**
 * Pide un nombre y lo añade a la agenda si no está vacío ni repetido.
 *
 * La comprobación de repetidos no distingue mayúsculas de minúsculas:
 * "Ana" y "ana" se consideran el mismo contacto.
 *
 * @param contactos lista de contactos que se modifica.
 */
fun anadirContacto(contactos: MutableList<String>) {
    val nombre = leerTexto("Nombre del contacto: ")

    if (nombre.isEmpty()) {
        mostrarError("El nombre no puede estar vacío.")
        return
    }
    if (contactos.any { it.equals(nombre, ignoreCase = true) }) {
        mostrarAviso("$nombre ya está en la agenda.")
        return
    }
    contactos.add(nombre)
    println("$nombre añadido.")
}

/**
 * Muestra los contactos numerados desde 1, o un aviso si la agenda está vacía.
 *
 * @param contactos lista de contactos.
 */
fun mostrarContactos(contactos: List<String>) {
    if (contactos.isEmpty()) {
        println("Todavía no hay contactos")
        return
    }
    // forEachIndexed da la posición (desde 0) y el elemento
    contactos.forEachIndexed { indice, nombre -> println("${indice + 1}. $nombre") }
}

/**
 * Pide un texto y muestra el primer contacto que lo contiene.
 *
 * `find` devuelve el primer elemento que cumple la condición o `null`;
 * el operador Elvis `?:` sustituye ese `null` por "No encontrado".
 *
 * @param contactos lista de contactos.
 */
fun buscarContacto(contactos: List<String>) {
    val texto = leerTexto("Texto a buscar: ")
    val encontrado = contactos.find { it.contains(texto, ignoreCase = true) }
    println(encontrado ?: "No encontrado")
}

/**
 * Pide un nombre y lo elimina de la agenda, indicando si existía o no.
 *
 * @param contactos lista de contactos que se modifica.
 */
fun eliminarContacto(contactos: MutableList<String>) {
    val nombre = leerTexto("Nombre a eliminar: ")
    // removeIf devuelve true si ha eliminado algún elemento
    val eliminado = contactos.removeIf { it.equals(nombre, ignoreCase = true) }
    if (eliminado) println("$nombre eliminado.") else mostrarAviso("$nombre no estaba en la agenda.")
}

// ===================================================================
// EJERCICIO 4 · Análisis de notas
// ===================================================================

/**
 * Calcula la nota media.
 *
 * @param notas lista de notas.
 * @return la media, o 0.0 si la lista está vacía.
 */
fun mediaNotas(notas: List<Double>): Double = if (notas.isEmpty()) 0.0 else notas.average()

/**
 * Devuelve la nota más alta.
 *
 * `maxOrNull()` devuelve `null` si la lista está vacía; `?:` lo sustituye por 0.0.
 *
 * @param notas lista de notas.
 * @return la nota más alta, o 0.0 si la lista está vacía.
 */
fun notaMasAlta(notas: List<Double>): Double = notas.maxOrNull() ?: 0.0

/**
 * Devuelve la nota más baja.
 *
 * @param notas lista de notas.
 * @return la nota más baja, o 0.0 si la lista está vacía.
 */
fun notaMasBaja(notas: List<Double>): Double = notas.minOrNull() ?: 0.0

/**
 * Cuenta las notas aprobadas (iguales o mayores que [NOTA_APROBADO]).
 *
 * @param notas lista de notas.
 * @return el número de aprobados.
 */
fun contarAprobados(notas: List<Double>): Int = notas.count { it >= NOTA_APROBADO }

/**
 * Devuelve las notas suspensas ordenadas de menor a mayor.
 *
 * @param notas lista de notas.
 * @return una lista nueva con las notas menores que [NOTA_APROBADO], ordenadas.
 */
fun suspensosOrdenados(notas: List<Double>): List<Double> = notas.filter { it < NOTA_APROBADO }.sorted()

/**
 * Sube un punto cada nota sin pasar de [NOTA_MAXIMA].
 *
 * @param notas lista de notas.
 * @return una lista nueva con las notas subidas (la original no cambia).
 */
fun subirUnPunto(notas: List<Double>): List<Double> = notas.map { minOf(it + 1, NOTA_MAXIMA) }

/**
 * Indica si alguna nota es un 10.
 *
 * @param notas lista de notas.
 * @return `true` si al menos una nota es igual a [NOTA_MAXIMA].
 */
fun hayAlgunDiez(notas: List<Double>): Boolean = notas.any { it == NOTA_MAXIMA }

// ===================================================================
// EJERCICIO 5 · Visitantes únicos
// ===================================================================

/**
 * Devuelve los usuarios sin repeticiones, en el orden en que aparecen.
 *
 * @param visitas lista de usuarios en el orden de sus visitas.
 * @return un conjunto (`Set`) con cada usuario una sola vez.
 */
fun usuariosUnicos(visitas: List<String>): Set<String> = visitas.toSet()

/**
 * Cuenta cuántas veces aparece cada usuario en la lista de visitas.
 *
 * `groupingBy { it }.eachCount()` agrupa los elementos iguales y cuenta
 * cuántos hay en cada grupo.
 *
 * @param visitas lista de usuarios en el orden de sus visitas.
 * @return un mapa usuario -> número de visitas.
 */
fun visitasPorUsuario(visitas: List<String>): Map<String, Int> = visitas.groupingBy { it }.eachCount()

// ===================================================================
// EJERCICIO 6 · Lista de productos
// ===================================================================

/**
 * Muestra todos los productos y sus precios con dos decimales.
 *
 * @param productos mapa producto -> precio.
 */
fun mostrarProductos(productos: Map<String, Double>) {
    if (productos.isEmpty()) {
        println("No hay productos.")
        return
    }
    for ((nombre, precio) in productos) {
        println("  $nombre: ${formatearB4(precio)} €")
    }
}

/**
 * Pide un producto y un precio. Si el producto existe, actualiza su precio;
 * si no, lo añade.
 *
 * Los nombres se guardan en minúsculas para que "Teclado" y "teclado" sean
 * el mismo producto.
 *
 * @param productos mapa producto -> precio que se modifica.
 */
fun anadirOActualizarProducto(productos: MutableMap<String, Double>) {
    val nombre = leerTexto("Nombre del producto: ").lowercase()
    if (nombre.isEmpty()) {
        mostrarError("El nombre no puede estar vacío.")
        return
    }
    val precio = leerDecimalPositivo("Precio: ")
    val existia = nombre in productos
    productos[nombre] = precio
    println(if (existia) "Precio de $nombre actualizado." else "$nombre añadido.")
}

/**
 * Pide un producto y lo elimina, avisando si no existía.
 *
 * `remove` devuelve el precio del producto eliminado, o `null` si no estaba.
 *
 * @param productos mapa producto -> precio que se modifica.
 */
fun eliminarProducto(productos: MutableMap<String, Double>) {
    val nombre = leerTexto("Producto a eliminar: ").lowercase()
    if (productos.remove(nombre) != null) {
        println("$nombre eliminado.")
    } else {
        mostrarAviso("$nombre no existía.")
    }
}

/**
 * Pide un producto y muestra su precio, o "Producto no encontrado".
 *
 * `productos[nombre]` devuelve `Double?`: `null` si el producto no existe.
 *
 * @param productos mapa producto -> precio.
 */
fun mostrarPrecioProducto(productos: Map<String, Double>) {
    val nombre = leerTexto("Producto: ").lowercase()
    val precio = productos[nombre]
    println(precio?.let { "$nombre: ${formatearB4(it)} €" } ?: "Producto no encontrado")
}

/**
 * Pide un precio y muestra los productos más baratos que él.
 *
 * @param productos mapa producto -> precio.
 */
fun mostrarMasBaratos(productos: Map<String, Double>) {
    val limite = leerDecimalPositivo("Precio máximo: ")
    val baratos = productos.filter { it.value < limite }
    if (baratos.isEmpty()) {
        println("No hay productos por debajo de ${formatearB4(limite)} €.")
    } else {
        mostrarProductos(baratos)
    }
}

/**
 * Muestra el valor total del catálogo y el producto más caro.
 *
 * `maxByOrNull` devuelve `null` si el mapa está vacío, por eso se usa `?.`.
 *
 * @param productos mapa producto -> precio.
 */
fun mostrarResumenCatalogo(productos: Map<String, Double>) {
    println("Valor total del catálogo: ${formatearB4(productos.values.sum())} €")
    val masCaro = productos.maxByOrNull { it.value }
    println(masCaro?.let { "Producto más caro: ${it.key} (${formatearB4(it.value)} €)" }
        ?: "No hay productos.")
}

// ===================================================================
// RETO · Tienda con stock
// ===================================================================

/**
 * Muestra cada producto con su precio y las unidades que quedan.
 *
 * @param precios mapa producto -> precio.
 * @param stock mapa producto -> unidades disponibles.
 */
fun mostrarCatalogoTienda(precios: Map<String, Double>, stock: Map<String, Int>) {
    for ((nombre, precio) in precios) {
        val unidades = stock[nombre] ?: 0
        val estado = if (unidades > 0) "$unidades en stock" else "agotado"
        println("  $nombre: ${formatearB4(precio)} € ($estado)")
    }
}

/**
 * Pide un producto y lo añade al carrito si existe y queda stock.
 * Al añadirlo, el stock de ese producto baja en uno.
 *
 * @param precios mapa producto -> precio.
 * @param stock mapa producto -> unidades disponibles, que se modifica.
 * @param carrito lista de productos del carrito, que se modifica.
 */
fun anadirAlCarrito(precios: Map<String, Double>, stock: MutableMap<String, Int>, carrito: MutableList<String>) {
    val nombre = leerTexto("Producto: ").lowercase()

    if (nombre !in precios) {
        mostrarError("Producto no encontrado.")
        return
    }
    val unidades = stock[nombre] ?: 0
    if (unidades <= 0) {
        mostrarAviso("No queda stock de $nombre.")
        return
    }
    carrito.add(nombre)
    stock[nombre] = unidades - 1
    println("$nombre añadido al carrito. Quedan ${unidades - 1}.")
}

/**
 * Calcula el importe del carrito sin IVA.
 *
 * Se usa `?: 0.0` por seguridad, aunque el carrito solo contiene productos
 * que existen en [precios].
 *
 * @param precios mapa producto -> precio.
 * @param carrito lista de productos del carrito.
 * @return la suma de los precios de todos los productos del carrito.
 */
fun calcularSubtotalCarrito(precios: Map<String, Double>, carrito: List<String>): Double =
    carrito.sumOf { precios[it] ?: 0.0 }

/**
 * Muestra el contenido del carrito con el subtotal, el IVA y el total.
 *
 * @param precios mapa producto -> precio.
 * @param carrito lista de productos del carrito.
 */
fun mostrarCarrito(precios: Map<String, Double>, carrito: List<String>) {
    if (carrito.isEmpty()) {
        println("El carrito está vacío.")
        return
    }
    println("Carrito: $carrito")
    mostrarTotales(calcularSubtotalCarrito(precios, carrito))
}

/**
 * Muestra el subtotal, el importe del IVA ([IVA] %) y el total.
 *
 * @param subtotal importe sin IVA.
 */
fun mostrarTotales(subtotal: Double) {
    val importeIva = subtotal * IVA / 100
    println("Subtotal: ${formatearB4(subtotal)} €")
    println("IVA (${IVA.toInt()} %): ${formatearB4(importeIva)} €")
    println("Total: ${formatearB4(subtotal + importeIva)} €")
}

/**
 * Muestra el ticket final: cada producto con sus unidades e importe, y los totales.
 *
 * Las unidades se cuentan con `groupingBy { it }.eachCount()`, que indica
 * cuántas veces aparece cada producto en el carrito.
 *
 * @param precios mapa producto -> precio.
 * @param carrito lista de productos comprados.
 */
fun mostrarTicket(precios: Map<String, Double>, carrito: List<String>) {
    println()
    println("========== TICKET ==========")
    for ((nombre, unidades) in carrito.groupingBy { it }.eachCount()) {
        val importe = (precios[nombre] ?: 0.0) * unidades
        println("%-12s x%-3d %10s €".format(nombre, unidades, formatearB4(importe)))
    }
    println("----------------------------")
    mostrarTotales(calcularSubtotalCarrito(precios, carrito))
    println("============================")
    println("¡Gracias por tu compra!")
}