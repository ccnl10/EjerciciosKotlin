import Bloque1.menuBloque1
import Bloque2.menuBloque2
import Bloque3.menuBloque3
import Utilidades.*

fun main() {

    menuPrincipal()
}

fun menuPrincipal() {
    var opcion: Int?
    var entrada: String?

    do {
        println(VERDE)
        println("========================================")
        println("            MENÚ PRINCIPAL              ")
        println("         UT1 · Fundamentos de Kotlin    ")
        println("========================================")
        println("1. Bloque 1 · Variables, tipos y operadores")
        println("2. Bloque 2 · Condicionales, rangos y bucles")
        println("3. Bloque 3 · Funciones")
        println("4. Salir")
        println("?. Ayuda")
        println("========================================")
        print("Elige un bloque: ")
        print(RESET)

        entrada = readln().trim()
        opcion = entrada.toIntOrNull()

        // "?" muestra la ayuda de este menú y vuelve a pintarlo
        if (entrada == "?") {
            ayudaMenuPrincipal()
            continue
        }

        when (opcion) {
            1 -> menuBloque1()
            2 -> menuBloque2()
            3 -> menuBloque3()
            4 -> mostrarAviso("¡Hasta luego!")
            else -> mostrarError("Opción no válida, inténtalo de nuevo.")
            //else -> println("${AMARILLO}Opción no válida, inténtalo de nuevo.${RESET}")
        }
    } while (opcion != 4)
}


fun ayudaMenuPrincipal() {
    mostrarAyuda(
        "Menú principal",
        listOf(
            "Este programa reúne los ejercicios de la UT1 · Fundamentos de Kotlin.",
            "",
            "1. Bloque 1: variables, tipos de datos, operadores y plantillas de texto.",
            "2. Bloque 2: condicionales (if, when), rangos y bucles (for, while).",
            "3. Bloque 3: funciones (parte 1) y expresiones lambda (parte 2).",
            "4. Salir: termina el programa.",
            "",
            "Escribe el número de una opción y pulsa Intro.",
            "En cualquier menú puedes escribir ? para ver su ayuda.",
            "Colores: verde = menú principal, azul = menús de bloque,",
            "cian = submenús, amarillo = avisos, rojo = errores."
        )
    )
}
