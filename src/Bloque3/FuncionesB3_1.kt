package Bloque3

import java.util.Locale

// ===================================================================
// FUNCIONES DEL BLOQUE 3_1
// Aquí está la lógica. Los ejercicios (EjerciciosB3_1.kt) solo las llaman.
// ===================================================================

// ----- Constantes -----
const val KM_A_MILLAS = 0.621371      // Ejercicio 2

const val NUMERO_SECRETO = 7          // Reto: juego de adivinar
const val NUMERO_MINIMO = 1
const val NUMERO_MAXIMO = 10
const val MAX_INTENTOS = 3

// Configuración regional española (coma decimal: 7,50).
// No es const porque Locale es un objeto, no un número o un texto.
val ESPANOL: Locale = Locale.forLanguageTag("es-ES")

// Función auxiliar: devuelve un número como texto con coma decimal,
// aunque en main se haya puesto Locale.US para los otros bloques.
fun formatear(valor: Double, decimales: Int = 2): String =
    "%.${decimales}f".format(ESPANOL, valor)

// ===================================================================
// EJERCICIO 1 · Saludos
// ===================================================================

// Sin parámetros y sin valor de retorno (devuelve Unit)
fun mostrarBienvenida() {
    println("¡Bienvenido a los ejercicios de funciones en Kotlin!")
}

// Con un parámetro
fun saludar(nombre: String) {
    println("¡Hola, $nombre!")
}

// idioma tiene valor por defecto "es": si no se pasa, saluda en español
fun saludarEnIdioma(nombre: String, idioma: String = "es") {
    when (idioma) {
        "es" -> println("¡Hola, $nombre!")
        "en" -> println("Hello, $nombre!")
        "fr" -> println("Bonjour, $nombre !")
        else -> println("¡Hola, $nombre! (idioma '$idioma' no disponible)")
    }
}

// ===================================================================
// EJERCICIO 2 · Conversor de unidades
// Funciones de una sola expresión (=) con tipo de retorno explícito
// ===================================================================

fun celsiusAFahrenheit(celsius: Double): Double = celsius * 9 / 5 + 32

fun kmAMillas(km: Double): Double = km * KM_A_MILLAS

fun esPar(numero: Int): Boolean = numero % 2 == 0

// if como expresión: si a es el mayor, a; si no, el mayor entre b y c
fun maximoDeTres(a: Int, b: Int, c: Int): Int =
    if (a >= b && a >= c) a else if (b >= c) b else c

// ===================================================================
// EJERCICIO 3 · Generador de nombres de usuario
// ===================================================================

// anio y separador tienen valores por defecto: son opcionales al llamarla
fun crearNombreUsuario(
    nombre: String,
    apellido: String,
    anio: Int = 2026,
    separador: String = "_"
): String {
    return "${nombre.lowercase()}$separador${apellido.lowercase()}$separador$anio"
}

// ===================================================================
// EJERCICIO 4 · Cláusulas de guarda
// ===================================================================

fun calcularMedia(nota1: Double, nota2: Double, nota3: Double): Double {
    // Retornos anticipados (cláusulas de guarda): si una nota no es válida,
    // salimos ya devolviendo -1.0 y no se ejecuta el resto de la función.
    if (nota1 !in 0.0..10.0) return -1.0
    if (nota2 !in 0.0..10.0) return -1.0
    if (nota3 !in 0.0..10.0) return -1.0

    // Si llegamos aquí, las tres notas son válidas
    return (nota1 + nota2 + nota3) / 3
}

fun mostrarResultado(media: Double) {
    if (media == -1.0) {
        println("Notas no válidas")
        return
    }
    println("Media: ${formatear(media)}")
}

// ===================================================================
// EJERCICIO 5 · Encuentra los errores (versiones corregidas)
// ===================================================================

// a) ERROR: la función no declara tipo de retorno, así que devuelve Unit,
//    y no puede hacer "return numero * 2" (Type mismatch).
//    SOLUCIÓN: indicar que devuelve Int.
fun duplicar(numero: Int): Int {
    return numero * 2
}

// b) ERROR: los parámetros de una función son de solo lectura (como val),
//    así que "puntos = puntos + 10" no compila (Val cannot be reassigned).
//    SOLUCIÓN: devolver directamente el nuevo valor (o usar una var local).
fun incrementar(puntos: Int): Int {
    return puntos + 10
}

// c) ERROR: la llamada total(3, 19.99) pasa los argumentos en el orden
//    equivocado: precio es Double y cantidad es Int (Type mismatch).
//    SOLUCIÓN: respetar el orden total(19.99, 3) o usar argumentos con
//    nombre: total(cantidad = 3, precio = 19.99).
fun total(precio: Double, cantidad: Int) = precio * cantidad

// d) ERROR: si edad < 18 la función llega al final sin devolver nada
//    (A 'return' expression required in a function with a block body).
//    SOLUCIÓN: devolver el resultado de la comparación, que ya es Boolean.
fun esMayorDeEdad(edad: Int): Boolean {
    return edad >= 18
}

// e) ERROR: el parámetro con valor por defecto (precio) va ANTES que el
//    obligatorio (producto). Al llamar a mostrarPrecio("Curso de Kotlin"),
//    el String se asigna al primer parámetro, precio, que es Double
//    (Type mismatch), y además falta producto.
//    SOLUCIÓN: poner los parámetros con valor por defecto al final.
//    (Otra opción: llamar con nombre, mostrarPrecio(producto = "Curso de Kotlin").)
fun mostrarPrecio(producto: String, precio: Double = 9.99) {
    println("$producto: ${formatear(precio)}")
}

// ===================================================================
// EJERCICIO 6 · Calculadora de productos
// ===================================================================

// ----- Funciones sin parámetros -----
fun mostrarBienvenidaTienda() {
    println("===== Bienvenido a la calculadora de productos =====")
}

fun mostrarDespedida() {
    println("===== ¡Gracias por su compra! =====")
}

// ----- Funciones con parámetros de entrada (no devuelven nada) -----
fun mostrarInfoProducto(
    nombreProducto: String,
    precioUnitario: Double,
    cantidad: Int,
    porcentajeDescuento: Double,
    porcentajeImpuesto: Double
) {
    println("Producto: $nombreProducto")
    println("Precio unitario: ${formatear(precioUnitario)} €")
    println("Cantidad: $cantidad")
    println("Descuento: ${formatear(porcentajeDescuento, 1)} %")
    println("Impuesto: ${formatear(porcentajeImpuesto, 1)} %")
}

fun mostrarResumen(
    subtotal: Double,
    importeDescuento: Double,
    precioConDescuento: Double,
    importeImpuesto: Double,
    precioFinal: Double
) {
    println("---------------------------------")
    println("Subtotal: ${formatear(subtotal)} €")
    println("Importe del descuento: ${formatear(importeDescuento)} €")
    println("Precio tras el descuento: ${formatear(precioConDescuento)} €")
    println("Importe del impuesto: ${formatear(importeImpuesto)} €")
    println("Precio final: ${formatear(precioFinal)} €")
    println("---------------------------------")
}

// ----- Funciones con valor de retorno (hacen los cálculos) -----
fun calcularSubtotal(precioUnitario: Double, cantidad: Int): Double =
    precioUnitario * cantidad

fun calcularImporteDescuento(subtotal: Double, porcentajeDescuento: Double): Double =
    subtotal * porcentajeDescuento / 100

fun calcularPrecioConDescuento(subtotal: Double, importeDescuento: Double): Double =
    subtotal - importeDescuento

fun calcularImporteImpuesto(precio: Double, porcentajeImpuesto: Double): Double =
    precio * porcentajeImpuesto / 100

fun calcularPrecioFinal(precio: Double, importeImpuesto: Double): Double =
    precio + importeImpuesto

// ===================================================================
// RETO · Refactorización del Bloque 3
// ===================================================================

// Función reutilizable: pide un número hasta que esté entre minimo y maximo.
// La usan leerMes() y el juego de adivinar (respuesta a la pregunta
// "¿Se podría reutilizar alguna función en el otro programa?": SÍ, esta).
fun leerNumeroEnRango(mensaje: String, minimo: Int, maximo: Int): Int {
    while (true) {
        print(mensaje)
        val entrada = readln()
        val numero = entrada.toIntOrNull()

        // Retorno anticipado: en cuanto el número es válido, se devuelve
        if (numero != null && numero in minimo..maximo) return numero

        println("$entrada no está entre $minimo y $maximo. Inténtalo de nuevo.")
    }
}

// ----- Mes y estación -----
fun leerMes(): Int = leerNumeroEnRango("Número de mes (1-12): ", 1, 12)

fun nombreMes(mes: Int): String = when (mes) {
    1 -> "Enero"
    2 -> "Febrero"
    3 -> "Marzo"
    4 -> "Abril"
    5 -> "Mayo"
    6 -> "Junio"
    7 -> "Julio"
    8 -> "Agosto"
    9 -> "Septiembre"
    10 -> "Octubre"
    11 -> "Noviembre"
    12 -> "Diciembre"
    else -> "Mes no válido"
}

fun estacionDe(mes: Int): String = when (mes) {
    12, 1, 2 -> "Invierno"
    in 3..5 -> "Primavera"
    in 6..8 -> "Verano"
    in 9..11 -> "Otoño"
    else -> "Mes no válido"
}

// ----- Juego de adivinar el número -----
fun mostrarReglasJuego() {
    println("Adivina el número ($NUMERO_MINIMO-$NUMERO_MAXIMO). Tienes $MAX_INTENTOS intentos.")
}

// Devuelve en qué intento se ha acertado, o -1 si se agotan los intentos.
// Los números fuera de rango no cuentan: leerNumeroEnRango los rechaza
// antes de que lleguen aquí.
fun jugarAdivinarNumero(): Int {
    for (intento in 1..MAX_INTENTOS) {
        val numero = leerNumeroEnRango("Intento $intento: ", NUMERO_MINIMO, NUMERO_MAXIMO)
        if (numero == NUMERO_SECRETO) return intento   // retorno anticipado
        mostrarPista(numero, MAX_INTENTOS - intento)
    }
    return -1
}

fun mostrarPista(numero: Int, intentosRestantes: Int) {
    val direccion = if (numero < NUMERO_SECRETO) "mayor" else "menor"
    println("¡Fallo! El número secreto es $direccion. Intentos restantes: $intentosRestantes")
}

fun mostrarResultadoJuego(intentos: Int) {
    if (intentos == -1) {
        println("¡Fin del juego! No te quedan intentos. El número secreto era $NUMERO_SECRETO.")
        return
    }
    val palabra = if (intentos == 1) "intento" else "intentos"
    println("¡Enhorabuena, lo has adivinado en $intentos $palabra!")
}