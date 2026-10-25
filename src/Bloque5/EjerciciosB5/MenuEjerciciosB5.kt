package Bloque5.EjerciciosB5

import Utilidades.*

/**
 * Muestra el menú del bloque 5 (clases, herencia e interfaces) en un bucle.
 *
 * Ejecuta el ejercicio elegido y vuelve a pintar el menú. Con la opción 0 el
 * bucle termina y el control vuelve a `menuPrincipal`. Si el usuario escribe
 * `?`, se muestra [ayudaBloque5].
 */
fun menuEjerciciosB5() {
    var opcion: Int?
    var entrada: String?

    do {
        print(CIAN)
        println()
        println("========================================")
        println("     MENÚ - EJERCICIOS DEL BLOQUE 5     ")
        println("     Clases, herencia e interfaces      ")
        println("========================================")
        println("1. Tu primera clase")
        println("2. Setter con validación")
        println("3. Encuentra los errores")
        println("4. Instrumentos (herencia)")
        println("5. Aves (interfaces)")
        println("6. Fichas del refugio")
        println("7. Reto: Refugio de animales")
        println("0. Volver al menú principal")
        println("?. Ayuda")
        println("========================================")
        print("Elige una opción: ")
        print(RESET)

        entrada = readln().trim()
        opcion = entrada.toIntOrNull()

        // "?" muestra la ayuda de este menú y vuelve a pintarlo
        if (entrada == "?") {
            ayudaBloque5()
            continue
        }

        when (opcion) {
            1 -> b5Ejercicio1()
            2 -> b5Ejercicio2()
            3 -> b5Ejercicio3()
            4 -> b5Ejercicio4()
            5 -> b5Ejercicio5()
            6 -> b5Ejercicio6()
            7 -> b5Reto()
            0 -> mostrarAviso("Volviendo al menú del bloque 5...")
            else -> mostrarError("Opción no válida, inténtalo de nuevo.")
        }
    } while (opcion != 0)
}

/**
 * Muestra la ayuda del menú del bloque 5.
 *
 * Se llama cuando el usuario escribe `?` en lugar de un número.
 */
fun ayudaBloque5() {
    mostrarAyuda(
        "Menú del bloque 5",
        listOf(
            "Ejercicios de clases, herencia, clases abstractas e interfaces.",
            "",
            "1. Tu primera clase: cachorro con init y la propiedad calculada esAdulto.",
            "2. Setter con validación: pez con temperatura entre 18 y 28 grados y constructor secundario.",
            "3. Encuentra los errores: cinco fragmentos que no compilan, con su error y su corrección.",
            "4. Instrumentos: clase abstracta, subclases, override y polimorfismo con is.",
            "5. Aves: una clase abstracta y dos interfaces (Nadador y Volador).",
            "6. Fichas del refugio: data class, enum class, copy() y desestructuración.",
            "7. Reto: refugio de animales con companion object, object y extensión (tiene su propio menú).",
            "0. Volver al menú principal."
        )
    )
}
