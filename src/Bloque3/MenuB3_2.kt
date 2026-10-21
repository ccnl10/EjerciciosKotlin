package Bloque3

import Utilidades.*

/**
 * Muestra el menú del bloque 3 · parte 2 (expresiones lambda) en un bucle.
 *
 * Ejecuta el ejercicio elegido y vuelve a pintar el menú. Con la opción 0 se
 * vuelve a [menuBloque3]. Si el usuario escribe `?`, se muestra
 * [ayudaBloque3Parte2].
 */
fun menuBloque3_2() {
    var opcion: Int?
    var entrada: String?

    do {
        print(CIAN)
        println()
        println("========================================")
        println("   MENÚ - BLOQUE 3 · PARTE 2            ")
        println("        Expresiones lambda              ")
        println("========================================")
        println("1. De función a lambda")
        println("2. Ponle nombre al tipo")
        println("3. Calculadora con lambdas")
        println("4. Analizador de textos")
        println("5. Tu propio repeat")
        println("6. Predice la salida")
        println("7. Reto: Reglas de descuento")
        println("0. Volver al menú del bloque 3")
        println("?. Ayuda")
        println("========================================")
        print("Elige una opción: ")
        print(RESET)

        entrada = readln().trim()
        opcion = entrada.toIntOrNull()

        // "?" muestra la ayuda de este menú y vuelve a pintarlo
        if (entrada == "?") {
            ayudaBloque3Parte2()
            continue
        }

        when (opcion) {
            1 -> b3_2Ejercicio1()
            2 -> b3_2Ejercicio2()
            3 -> b3_2Ejercicio3()
            4 -> b3_2Ejercicio4()
            5 -> b3_2Ejercicio5()
            6 -> b3_2Ejercicio6()
            7 -> b3_2RetoReglaDescuento()
            0 -> mostrarAviso("Volviendo al menú del bloque 3...")
            else -> mostrarError("Opción no válida, inténtalo de nuevo.")
        }
    } while (opcion != 0)
}

/**
 * Muestra la ayuda del menú del bloque 3 · parte 2.
 *
 * Se llama cuando el usuario escribe `?` en lugar de un número.
 */
fun ayudaBloque3Parte2() {
    mostrarAyuda(
        "Menú del bloque 3 · parte 2",
        listOf(
            "Ejercicios de expresiones lambda.",
            "",
            "1. De función a lambda: las mismas funciones escritas como lambdas.",
            "2. Ponle nombre al tipo: el tipo de función de cinco lambdas.",
            "3. Calculadora con lambdas: pide dos números y un operador (+ - * /).",
            "4. Analizador de textos: vocales, espacios, letras, dígitos y mayúsculas.",
            "5. Tu propio repeat: una función que repite una acción varias veces.",
            "6. Predice la salida: resultado de aplicar distintas reglas a un texto.",
            "7. Reto: precios de 50 € y 15 € con distintas reglas de descuento.",
            "0. Volver al menú del bloque 3."
        )
    )
}
