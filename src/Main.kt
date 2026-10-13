import Bloque1.menuBloque1   // o Bloque1.menuBloque1 si no cambiaste el nombre del paquete
import Bloque2.menuBloque2
import java.util.Locale

fun main() {
    Locale.setDefault(Locale.US)   // configuración inicial, una sola vez
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
        println("3. Salir")
        println("========================================")
        print("Elige un bloque: ")

        opcion = readln().toIntOrNull()

        when (opcion) {
            1 -> menuBloque1()
            2 -> menuBloque2()
            3 -> println("¡Hasta luego!")
            else -> println("Opción no válida, inténtalo de nuevo.")
        }
    } while (opcion != 3)
}