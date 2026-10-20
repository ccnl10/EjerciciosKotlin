package Bloque2

import Utilidades.*

// ===================================================================
// MENÚ DEL BLOQUE 2
// ===================================================================
/**
 * Muestra el menú del bloque 2 (condicionales, rangos y bucles) en un bucle.
 *
 * Ejecuta el ejercicio elegido y vuelve a pintar el menú. Con la opción 8 el
 * bucle termina y el control vuelve a `menuPrincipal`. Si el usuario escribe
 * `?`, se muestra [ayudaBloque2].
 */
fun menuBloque2() {
    var opcion: Int?
    var entrada: String?

    do {
        print(AZUL)
        println()
        println("========================================")
        println("     MENÚ - EJERCICIOS DEL BLOQUE 2     ")
        println("   Condicionales, rangos y bucles       ")
        println("========================================")
        println("1. Gastos de envío")
        println("2. De nota a calificación")
        println("3. Tabla de multiplicar")
        println("4. Predice la salida")
        println("5. Mes del año")
        println("6. Mes y estación")
        println("7. Reto: Adivina el número")
        println("8. Volver al menú principal")
        println("?. Ayuda")
        println("========================================")
        print("Elige una opción: ")
        print(RESET)

        entrada = readln().trim()
        opcion = entrada.toIntOrNull()

        // "?" muestra la ayuda de este menú y vuelve a pintarlo
        if (entrada == "?") {
            ayudaBloque2()
            continue
        }

        when (opcion) {
            1 -> b2Ejercicio1()
            2 -> b2Ejercicio2()
            3 -> b2Ejercicio3()
            4 -> b2Ejercicio4()
            5 -> b2Ejercicio5()
            6 -> b2Ejercicio6()
            7 -> b2Reto()
            8 -> mostrarAviso("Volviendo al menú principal...")
            else -> mostrarError("Opción no válida, inténtalo de nuevo.")
        }
    } while (opcion != 8)
}

/**
 * Muestra la ayuda del menú del bloque 2.
 *
 * Se llama cuando el usuario escribe `?` en lugar de un número.
 */
fun ayudaBloque2() {
    mostrarAyuda(
        "Menú del bloque 2",
        listOf(
            "Ejercicios de condicionales, rangos y bucles.",
            "",
            "1. Gastos de envío: envío gratis a partir de 50 €; si no, 4,99 €.",
            "2. De nota a calificación: convierte una nota de 0 a 10 en su calificación.",
            "3. Tabla de multiplicar: tabla de un número del 1 al 10 y al revés.",
            "4. Predice la salida: muestra el resultado de cinco fragmentos de código.",
            "5. Mes del año: escribe un número del 1 al 12 y verás el nombre del mes.",
            "6. Mes y estación: igual que el 5, añadiendo la estación del año.",
            "7. Reto: adivina un número del 1 al 10 en 3 intentos.",
            "   Los números fuera de rango no gastan intento.",
            "8. Volver al menú principal."
        )
    )
}
