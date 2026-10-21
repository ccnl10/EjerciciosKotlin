package Bloque4

import Utilidades.*

/**
 * Muestra el menú del bloque 4 (nulos y colecciones) en un bucle.
 *
 * Ejecuta el ejercicio elegido y vuelve a pintar el menú. Con la opción 0 el
 * bucle termina y el control vuelve a `menuPrincipal`. Si el usuario escribe
 * `?`, se muestra [ayudaBloque4].
 */
fun menuBloque4() {
    var opcion: Int?
    var entrada: String?

    do {
        print(AZUL)
        println()
        println("========================================")
        println("     MENÚ - EJERCICIOS DEL BLOQUE 4     ")
        println("        Nulos y colecciones             ")
        println("========================================")
        println("1. Entrada segura")
        println("2. Predice la salida")
        println("3. Agenda de contactos")
        println("4. Análisis de notas")
        println("5. Visitantes únicos")
        println("6. Lista de productos")
        println("7. Reto: Tienda con stock")
        println("0. Volver al menú principal")
        println("?. Ayuda")
        println("========================================")
        print("Elige una opción: ")
        print(RESET)

        entrada = readln().trim()
        opcion = entrada.toIntOrNull()

        // "?" muestra la ayuda de este menú y vuelve a pintarlo
        if (entrada == "?") {
            ayudaBloque4()
            continue
        }

        when (opcion) {
             1 -> b4Ejercicio1()
             2 -> b4Ejercicio2()
             3 -> b4Ejercicio3()
             4 -> b4Ejercicio4()
             5 -> b4Ejercicio5()
             6 -> b4Ejercicio6()
             7 -> b4Reto()
             0 -> mostrarAviso("Volviendo al menú principal...")
            else -> mostrarError("Opción no válida, inténtalo de nuevo.")
        }
    } while (opcion != 0)
}

/**
 * Muestra la ayuda del menú del bloque 4.
 *
 * Se llama cuando el usuario escribe `?` en lugar de un número.
 */
fun ayudaBloque4() {
    mostrarAyuda(
        "Menú del bloque 4",
        listOf(
            "Ejercicios de tipos nulables y colecciones (listas, conjuntos y mapas).",
            "",
            "1. Entrada segura: pide edad y entradas; si no escribes un número, usa un valor por defecto.",
            "2. Predice la salida: resultados de ?., ?: y toIntOrNull() con valores nulos.",
            "3. Agenda de contactos: añade, muestra, busca y elimina nombres (tiene su propio menú).",
            "4. Análisis de notas: media, máxima, mínima, aprobados y suspensos de una lista.",
            "5. Visitantes únicos: visitas totales, usuarios distintos y visitas por usuario.",
            "6. Lista de productos: gestiona productos y precios (tiene su propio menú).",
            "7. Reto: tienda con precios, stock, carrito y ticket con IVA.",
            "0. Volver al menú principal."
        )
    )
}