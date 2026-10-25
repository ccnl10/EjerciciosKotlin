package Bloque5.EjemploZooB5

import Utilidades.*

// ===================================================================
// EJEMPLO DEL ZOO · Menú
// Cada opción enseña una parte del ejemplo usando los mismos animales.
// ===================================================================


/**
 * Muestra el menú del ejemplo del zoo en un bucle.
 *
 * Los animales se crean al entrar y se mantienen mientras se está en este
 * menú (por ejemplo, después de comer ya no tienen hambre). Con la opción 0
 * se vuelve a `menuBloque5`. Si el usuario escribe `?`, se muestra [ayudaZooB5].
 */
fun menuZooB5() {
    val animales = crearZoo()
    var opcion: Int?
    var entrada: String?

    do {
        print(CIAN)
        println()
        println("========================================")
        println("     MENÚ - BLOQUE 5 · EJEMPLO DEL ZOO  ")
        println("  Animal, Canino, Felino y Mascota      ")
        println("========================================")
        println("1. Censo del zoo")
        println("2. Ruidos y paseos")
        println("3. Hora de comer")
        println("4. Visita del veterinario")
        println("5. Hora de jugar")
        println("6. Paseo con el perro")
        println("0. Volver al menú del bloque 5")
        println("?. Ayuda")
        println("========================================")
        print("Elige una opción: ")
        print(RESET)

        entrada = readln().trim()
        opcion = entrada.toIntOrNull()

        // "?" muestra la ayuda de este menú y vuelve a pintarlo
        if (entrada == "?") {
            ayudaZooB5()
            continue
        }

        when (opcion) {
            1 -> censo(animales)
            2 -> ruidosYPaseos(animales)
            3 -> horaDeComer(animales)
            4 -> visitaVeterinario(animales)
            5 -> horaDeJugar(animales)
            6 -> paseoConElPerro(animales)
            0 -> mostrarAviso("Volviendo al menú del bloque 5...")
            else -> mostrarError("Opción no válida, inténtalo de nuevo.")
        }
    } while (opcion != 0)
}


/**
 * Muestra la ayuda del menú del ejemplo del zoo.
 *
 * Se llama cuando el usuario escribe `?` en lugar de un número.
 */
fun ayudaZooB5() {
    mostrarAyuda(
        "Menú del ejemplo del zoo",
        listOf(
            "El zoo del ejemplo de Java, terminado en Kotlin: Animal (abstracta),",
            "Canino y Felino (abstractas), Hipopotamo, Lobo, Perro, Gato y la",
            "interfaz Mascota. Hay un animal de cada clase: Pepa, Lupo, Toby y Misi.",
            "",
            "1. Censo: clase de cada animal y si es mascota.",
            "2. Ruidos y paseos: polimorfismo, cada uno a su manera.",
            "3. Hora de comer: comen los que tienen hambre y luego duermen.",
            "4. Visita del veterinario: vacunar(animal: Animal) sirve para todos.",
            "5. Hora de jugar: solo las mascotas (interfaz Mascota).",
            "6. Paseo con el perro: is y as? para usar un método que solo tiene Perro.",
            "0. Volver al menú del bloque 5."
        )
    )
}
