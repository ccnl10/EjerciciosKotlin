package Bloque2

import menuPrincipal

// ===================================================================
// MENÚ DEL BLOQUE 2
// ===================================================================
fun menuBloque2() {
    var opcion: Int?

    do {
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
        println("8. Salir")
        println("========================================")
        print("Elige una opción: ")

        opcion = readln().toIntOrNull()

        when (opcion) {
            1 -> b2Ejercicio1()
            2 -> b2Ejercicio2()
            3 -> b2Ejercicio3()
            4 -> b2Ejercicio4()
            5 -> b2Ejercicio5()
            6 -> b2Ejercicio6()
            7 -> b2Reto()
            8 -> menuPrincipal()
            else -> println("Opción no válida, inténtalo de nuevo.")
        }
    } while (opcion != 8)
}