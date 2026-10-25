package Bloque5

import Bloque5.EjemploZooB5.menuZooB5
import Bloque5.EjerciciosB5.menuEjerciciosB5
import Utilidades.*

/**
 * Muestra el menú del bloque 5, que da paso a sus dos partes.
 *
 * La opción 1 abre [menuEjerciciosB5] (los ejercicios del bloque) y la 2 abre
 * [menuZooB5] (el ejemplo completo del zoo). Con la opción 0 se vuelve a
 * `menuPrincipal`. Si el usuario escribe `?`, se muestra [ayudaBloque5].
 */
fun menuBloque5() {
    var opcion: Int?
    var entrada: String?

    do {
        print(AZUL)
        println()
        println("========================================")
        println("     MENÚ - EJERCICIOS DEL BLOQUE 5     ")
        println("     Clases, herencia e interfaces      ")
        println("========================================")
        println("1. Ejemplo del zoo")
        println("2. Ejercicios del bloque 5")
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
            1 -> menuZooB5()
            2 -> menuEjerciciosB5()
            0 -> mostrarAviso("Volviendo al menú principal...")
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
            "El bloque 5 está dividido en dos partes, cada una con su propio menú.",
            "",
            "1. Ejemplo del zoo: la jerarquía Animal, Canino, Felino y la interfaz",
            "   Mascota del ejemplo de Java, terminada y escrita en Kotlin.",
            "2. Ejercicios: clases, init, getters y setters, herencia, clases",
            "   abstractas, interfaces, data class, enum, object y companion object.",
            "0. Volver al menú principal."
        )
    )
}
