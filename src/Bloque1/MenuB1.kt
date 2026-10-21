package Bloque1
import Utilidades.*

/**
 * Muestra el menú del bloque 1 (variables, tipos y operadores) en un bucle.
 *
 * Ejecuta el ejercicio elegido y vuelve a pintar el menú. Con la opción 0 el
 * bucle termina y el control vuelve a `menuPrincipal`. Si el usuario escribe
 * `?`, se muestra [ayudaBloque1].
 */
fun menuBloque1() {
    var opcion: Int?
    var entrada: String?

    do {
        print(AZUL)
        println()
        println("========================================")
        println("     MENÚ - EJERCICIOS DEL BLOQUE 1     ")
        println("  Variables, tipos y operadores         ")
        println("========================================")
        println("1. Preséntate")
        println("2. ¿val o var?")
        println("3. Encuentra los errores")
        println("4. Conversor de temperatura")
        println("5. Calculadora de precio")
        println("6. Recibo del presupuesto (ampliación)")
        println("0. Volver al menú principal")
        println("?. Ayuda")
        println("========================================")
        print("Elige una opción: ")
        print(RESET)

        entrada = readln().trim()
        opcion = entrada.toIntOrNull()

        // "?" muestra la ayuda de este menú y vuelve a pintarlo
        if (entrada == "?") {
            ayudaBloque1()
            continue
        }

        when (opcion) {
            1 -> b1Ejercicio1()
            2 -> b1Ejercicio2()
            3 -> b1Ejercicio3()
            4 -> b1Ejercicio4()
            5 -> b1Ejercicio5()
            6 -> b1Ejercicio6()
            0 -> mostrarAviso("Volviendo al menú principal...")
            else -> mostrarError("Opción no válida, inténtalo de nuevo.")
        }
    } while (opcion != 0)
}

/**
 * Muestra la ayuda del menú del bloque 1.
 *
 * Se llama cuando el usuario escribe `?` en lugar de un número.
 */
fun ayudaBloque1() {
    mostrarAyuda(
        "Menú del bloque 1",
        listOf(
            "Ejercicios de variables, tipos y operadores.",
            "",
            "1. Preséntate: muestra datos personales con una plantilla de texto.",
            "2. ¿val o var?: ejemplos de cuándo usar val y cuándo var.",
            "3. Encuentra los errores: cinco fragmentos corregidos y explicados.",
            "4. Conversor de temperatura: pide grados Celsius y los pasa a Fahrenheit.",
            "5. Calculadora de precio: pide precio, cantidad, descuento e impuesto.",
            "6. Recibo del presupuesto: como el 5, pero muestra un recibo alineado.",
            "   Si en el impuesto pulsas Intro sin escribir nada, se aplica un 21 %.",
            "0. Volver al menú principal.",
            "",
            "Los números decimales se pueden escribir con coma (21,5) o con punto (21.5)."
        )
    )
}
