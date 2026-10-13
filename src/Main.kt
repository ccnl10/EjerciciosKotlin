import Bloque1.menuBloque1
import Bloque2.menuBloque2
import Bloque3.menuBloque3

fun main() {

    menuPrincipal()
}

fun menuPrincipal() {
    var opcion: Int?

    do {
        println()
        println("========================================")
        println("            MENÚ PRINCIPAL              ")
        println("         UT1 · Fundamentos de Kotlin    ")
        println("========================================")
        println("1. Bloque 1 · Variables, tipos y operadores")
        println("2. Bloque 2 · Condicionales, rangos y bucles")
        println("3. Bloque 3 · Funciones")
        println("4. Salir")
        println("========================================")
        print("Elige un bloque: ")

        opcion = readln().toIntOrNull()

        when (opcion) {
            1 -> menuBloque1()
            2 -> menuBloque2()
            3 -> menuBloque3()
            4 -> println("¡Hasta luego!")
            else -> println("Opción no válida, inténtalo de nuevo.")
        }
    } while (opcion != 4)
}