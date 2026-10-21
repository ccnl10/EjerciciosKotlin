package Bloque3

import Utilidades.*

/**
 * Muestra el menú del bloque 3 · parte 1 (funciones) en un bucle.
 *
 * Ejecuta el ejercicio elegido y vuelve a pintar el menú. Con la opción 0 se
 * vuelve a [menuBloque3]. Si el usuario escribe `?`, se muestra
 * [ayudaBloque3Parte1].
 */
fun menuBloque3_1() {
    var opcion: Int?
    var entrada: String?

    do {
        print(CIAN)
        println()
        println("========================================")
        println("     MENÚ - BLOQUE 3 · PARTE 1          ")
        println("              Funciones                 ")
        println("========================================")
        println("1. Saludos")
        println("2. Conversor de unidades")
        println("3. Generador de nombres de usuario")
        println("4. Cláusulas de guarda")
        println("5. Encuentra los errores")
        println("6. Calculadora de productos")
        println("7. Reto: Mes y estación")
        println("8. Reto: Adivina el número")
        println("0. Volver al menú del bloque 3")
        println("?. Ayuda")
        println("========================================")
        print("Elige una opción: ")
        print(RESET)

        entrada = readln().trim()
        opcion = entrada.toIntOrNull()

        // "?" muestra la ayuda de este menú y vuelve a pintarlo
        if (entrada == "?") {
            ayudaBloque3Parte1()
            continue
        }

        when (opcion) {
            1 -> b3_1Ejercicio1()
            2 -> b3_1Ejercicio2()
            3 -> b3_1Ejercicio3()
            4 -> b3_1Ejercicio4()
            5 -> b3_1Ejercicio5()
            6 -> b3_1Ejercicio6()
            7 -> b3_1RetoMesEstacion()
            8 -> b3_1RetoAdivina()
            0 -> mostrarAviso("Volviendo al menú del bloque 3...")
            else -> mostrarError("Opción no válida, inténtalo de nuevo.")
        }
    } while (opcion != 0)
}

/**
 * Muestra la ayuda del menú del bloque 3 · parte 1.
 *
 * Se llama cuando el usuario escribe `?` en lugar de un número.
 */
fun ayudaBloque3Parte1() {
    mostrarAyuda(
        "Menú del bloque 3 · parte 1",
        listOf(
            "Ejercicios de funciones.",
            "",
            "1. Saludos: funciones sin parámetros, con parámetros y con valor por defecto.",
            "2. Conversor de unidades: funciones de una sola expresión.",
            "3. Generador de nombres de usuario: argumentos opcionales y con nombre.",
            "4. Cláusulas de guarda: media de tres notas con retornos anticipados.",
            "5. Encuentra los errores: cinco funciones corregidas y explicadas.",
            "6. Calculadora de productos: cálculo de un precio repartido en funciones.",
            "7. Reto: mes y estación; pide el mes hasta que esté entre 1 y 12.",
            "8. Reto: adivina un número del 1 al 10 en 3 intentos.",
            "0. Volver al menú del bloque 3."
        )
    )
}
