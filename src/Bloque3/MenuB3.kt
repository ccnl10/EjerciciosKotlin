package Bloque3

fun menuBloque3() {
    var opcion: Int?

    do {
        println()
        println("========================================")
        println("     MENÚ - EJERCICIOS DEL BLOQUE 3     ")
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
        println("9. Volver al menú principal")
        println("========================================")
        print("Elige una opción: ")

        opcion = readln().toIntOrNull()

        when (opcion) {
            1 -> b3Ejercicio1()
            2 -> b3Ejercicio2()
            3 -> b3Ejercicio3()
            4 -> b3Ejercicio4()
            5 -> b3Ejercicio5()
            6 -> b3Ejercicio6()
            7 -> b3ERetoMesEstacion()
            8 -> b3RetoAdivina()
            9 -> println("Volviendo al menú principal...")
            else -> println("Opción no válida, inténtalo de nuevo.")
        }
    } while (opcion != 9)
}