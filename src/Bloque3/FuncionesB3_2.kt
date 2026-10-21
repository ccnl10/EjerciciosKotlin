package Bloque3

// ===================================================================
// FUNCIONES DEL BLOQUE 3 · PARTE 2 (Expresiones lambda)
// Los ejercicios (EjerciciosB3_2.kt) solo las llaman.
// Algunas funciones de FuncionesB3.kt (esPar, formatear) se reutilizan
// aquí, porque están en el mismo paquete Bloque3.
// ===================================================================

// ===================================================================
// EJERCICIO 1 · De función a lambda (versiones con fun)
// ===================================================================

fun cuadrado(n: Int): Int {
    return n * n
}

// esPar(numero: Int): Boolean YA EXISTE en FuncionesB3.kt (ejercicio 2 del
// bloque 3) y hace exactamente lo mismo. Si la volviéramos a declarar aquí
// con la misma firma, Kotlin daría el error "Conflicting overloads".
// Por eso en el ejercicio usamos esa.

fun nombreCompleto(nombre: String, apellido: String): String {
    return "$nombre $apellido"
}

fun imprimirSeparador() {
    println("--------------------")
}

// ===================================================================
// EJERCICIO 3 · Calculadora con lambdas
// ===================================================================

// Función de orden superior: recibe otra función (operacion) como parámetro
fun calcular(a: Double, b: Double, operacion: (Double, Double) -> Double): Double {
    return operacion(a, b)
}

// ===================================================================
// EJERCICIO 4 · Analizador de textos
// ===================================================================

fun analizarTexto(frase: String) {
    // count con lambda: cuenta los caracteres que cumplen la condición.
    // Se añaden las vocales con tilde para que "canción" cuente bien.
    val vocales = frase.count { it.lowercaseChar() in "aeiouáéíóúü" }

    val espacios = frase.count { it == ' ' }

    // filter con lambda: se queda solo con los caracteres que cumplen la condición
    val soloLetras = frase.filter { it.isLetter() }

    // any: true si AL MENOS UN carácter cumple la condición
    val tieneDigitos = frase.any { it.isDigit() }

    // all: true si TODOS los caracteres cumplen la condición.
    // Primero nos quedamos solo con las letras (si no, los espacios y los
    // números harían que diera false). Además, all() sobre un texto vacío
    // devuelve true, así que comprobamos que haya al menos una letra.
    val todoMayusculas = soloLetras.isNotEmpty() && soloLetras.all { it.isUpperCase() }

    println("Vocales: $vocales")
    println("Espacios: $espacios")
    println("Solo letras: $soloLetras")
    println("¿Contiene algún dígito? ${if (tieneDigitos) "Sí" else "No"}")
    println("¿Todas las letras en mayúsculas? ${if (todoMayusculas) "Sí" else "No"}")
}

// ===================================================================
// EJERCICIO 5 · Tu propio repeat
// ===================================================================

// accion es una función que recibe el número de vuelta (Int) y no devuelve nada (Unit)
fun repetirAccion(veces: Int, accion: (Int) -> Unit) {
    for (vuelta in 1..veces) {
        accion(vuelta)
    }
}

// ===================================================================
// EJERCICIO 6 · Predice la salida
// ===================================================================

// Función de una sola expresión: aplica la regla recibida al texto
fun transformar(texto: String, regla: (String) -> String): String = regla(texto)

// ===================================================================
// RETO · Reglas de descuento
// ===================================================================

// Porcentajes en constantes (sin números mágicos)
const val DESCUENTO_BLACK_FRIDAY = 30.0
const val DESCUENTO_ESTUDIANTE = 10.0
const val MINIMO_DESCUENTO_ESTUDIANTE = 20.0

// Cada regla es una lambda (Double) -> Double: recibe un precio y devuelve el nuevo
val sinDescuento: (Double) -> Double = { precio -> precio }

val blackFriday: (Double) -> Double = { precio ->
    precio - precio * DESCUENTO_BLACK_FRIDAY / 100
}

// if como expresión: la última expresión de la lambda es su valor de retorno
val descuentoEstudiante: (Double) -> Double = { precio ->
    if (precio >= MINIMO_DESCUENTO_ESTUDIANTE) precio - precio * DESCUENTO_ESTUDIANTE / 100
    else precio
}

fun aplicarRegla(precio: Double, regla: (Double) -> Double): Double = regla(precio)

// Extra: devuelve una lambda NUEVA que aplica primero una regla y luego la otra.
// El orden importa: el descuento de estudiante se calcula sobre el precio
// que deja la primera regla.
fun combinarReglas(primera: (Double) -> Double, segunda: (Double) -> Double): (Double) -> Double {
    return { precio -> segunda(primera(precio)) }
}

fun mostrarPrecioConRegla(nombreRegla: String, precio: Double, regla: (Double) -> Double) {
    println("%-28s %s €".format(nombreRegla, formatear(aplicarRegla(precio, regla))))
}