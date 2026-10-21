package Bloque3

import Utilidades.*

/**
 * Muestra el menú del bloque 3, que da paso a sus dos partes.
 *
 * La opción 1 abre [menuBloque3_1] (funciones) y la 2 abre [menuBloque3_2]
 * (expresiones lambda). Con la opción 0 se vuelve a `menuPrincipal`. Si el
 * usuario escribe `?`, se muestra [ayudaBloque3].
 */
fun menuBloque3() {
    var opcion: Int?
    var entrada: String?

    do {
        print(AZUL)
        println()
        println("========================================")
        println("     MENÚ - EJERCICIOS DEL BLOQUE 3     ")
        println("              Funciones                 ")
        println("========================================")
        println("1. Ejercicios 3. Parte 1 Funciones")
        println("2. Ejercicios 3. Parte 2 Funciones lambda")
        println("0. Volver al menú principal")
        println("?. Ayuda")
        println("========================================")
        print("Elige una opción: ")
        print(RESET)

        entrada = readln().trim()
        opcion = entrada.toIntOrNull()

        // "?" muestra la ayuda de este menú y vuelve a pintarlo
        if (entrada == "?") {
            ayudaBloque3()
            continue
        }

        when (opcion) {
            1 -> menuBloque3_1()
            2 -> menuBloque3_2()
            0 -> mostrarAviso("Volviendo al menú principal...")
            else -> mostrarError("Opción no válida, inténtalo de nuevo.")
        }
    } while (opcion != 0)
}

/**
 * Muestra la ayuda del menú del bloque 3.
 *
 * Se llama cuando el usuario escribe `?` en lugar de un número.
 */
fun ayudaBloque3() {
    mostrarAyuda(
        "Menú del bloque 3",
        listOf(
            "El bloque 3 está dividido en dos partes, cada una con su propio menú.",
            "",
            "1. Parte 1 · Funciones: parámetros, valores por defecto, argumentos",
            "   con nombre, valores de retorno y retornos anticipados.",
            "2. Parte 2 · Expresiones lambda: tipos de función, funciones de orden",
            "   superior, it, lambdas finales y funciones que devuelven funciones.",
            "0. Volver al menú principal."
        )
    )
}
