package Bloque1

fun menuBloque1() {
    var opcion: Int?

    do {
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
        println("7. Volver al menú principal")
        println("========================================")
        print("Elige una opción: ")

        opcion = readln().toIntOrNull()

        when (opcion) {
            1 -> b1Ejercicio1()
            2 -> b1Ejercicio2()
            3 -> b1Ejercicio3()
            4 -> b1Ejercicio4()
            5 -> b1Ejercicio5()
            6 -> b1Ejercicio6()
            7 -> println("Volviendo al menú principal...")
            else -> println("Opción no válida, inténtalo de nuevo.")
        }
    } while (opcion != 7)
}