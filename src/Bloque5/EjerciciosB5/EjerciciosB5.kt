package Bloque5.EjerciciosB5

import Utilidades.*

// ===================================================================
// EJERCICIOS DEL BLOQUE 5 · Clases, herencia, clases abstractas e interfaces
// Cada función b5EjercicioN() es el "main" de su ejercicio: crea los
// objetos de las clases de su archivo (Cachorro.kt, Pez.kt…) y muestra
// el resultado.
// ===================================================================

/**
 * Muestra [mensaje] y lee una línea del teclado, sin espacios al principio ni al final.
 *
 * @param mensaje texto que se muestra antes de leer.
 * @return lo que ha escrito el usuario (puede ser una cadena vacía).
 */
private fun leerLinea(mensaje: String): String {
    print(mensaje)
    return readln().trim()
}

// ===================================================================
// EJERCICIO 1 · Tu primera clase
// ===================================================================

/**
 * Ejercicio 1 · Tu primera clase.
 *
 * Crea un [Cachorro] de 11 meses, lo muestra, hace que cumpla un mes y lo
 * vuelve a mostrar: [Cachorro.esAdulto] cambia sin guardarse en ningún sitio.
 */
fun b5Ejercicio1() {
    val nala = Cachorro("Nala", "Labrador", 11)   // el init muestra "Nuevo cachorro: Nala"
    nala.mostrar()
    nala.cumplirMes()
    nala.mostrar()
}

// ===================================================================
// EJERCICIO 2 · Setter con validación y constructor secundario
// ===================================================================

/**
 * Ejercicio 2 · Setter con validación y constructor secundario.
 *
 * Crea un [Pez] con el constructor secundario y prueba el setter con una
 * temperatura no válida y con otra válida. Después responde al «Piénsalo»:
 * crea un pez con 40 grados en el constructor.
 */
fun b5Ejercicio2() {
    val nemo = Pez("Nemo")                         // constructor secundario: 24 grados
    println("Temperatura inicial: ${nemo.temperaturaAgua}")
    nemo.temperaturaAgua = 35.0                    // fuera de rango: el setter avisa
    nemo.temperaturaAgua = 26.5                    // dentro de rango: se guarda
    println("Temperatura actual: ${nemo.temperaturaAgua}")

    println()
    println("PIÉNSALO · Pez(\"Dory\", 40.0):")
    val dory = Pez("Dory", 40.0)                   // el init usa el setter: también se valida
    println("Temperatura de Dory: ${dory.temperaturaAgua}")
}

// ===================================================================
// EJERCICIO 3 · Encuentra los errores
// ===================================================================

/**
 * Ejercicio 3 · Encuentra los errores.
 *
 * Los fragmentos originales no compilan, así que aquí se muestran el error
 * de cada uno y su corrección. Las clases corregidas están en Errores.kt y
 * se usan para comprobar que ya funcionan.
 */
fun b5Ejercicio3() {
    println("a) class Insecto { ... }  /  class Abeja : Insecto()")
    println("   Error: This type is final, so it cannot be extended.")
    println("   Por qué: en Kotlin las clases son cerradas (final) por defecto.")
    println("   Solución: open class Insecto. En Java compila porque allí las clases se heredan por defecto.")
    Abeja().volar()

    println()
    println("b) class Serpiente : Reptil()")
    println("   Error: No value passed for parameter 'nombre'.")
    println("   Por qué: el constructor de Reptil necesita un nombre.")
    println("   Solución: class Serpiente(nombre: String) : Reptil(nombre)")
    println("   Serpiente creada: ${Serpiente("Kaa").nombre}")

    println()
    println("c) class Ballena : Mamifero() { fun respirar() { } }")
    println("   Error: 'respirar' hides member of supertype 'Mamifero' and needs an 'override' modifier.")
    println("   Por qué: para sobrescribir un método hay que escribir override.")
    println("   Solución: override fun respirar()")
    Ballena().respirar()

    println()
    println("d) val planta = Planta()")
    println("   Error: Cannot create an instance of an abstract class.")
    println("   Por qué: una clase abstracta no se puede instanciar.")
    println("   Solución: crear una subclase concreta (class Cactus : Planta()) y crear objetos de ella.")
    val planta: Planta = Cactus()
    println("   Planta creada: ${planta::class.simpleName}")

    println()
    println("e) class Raton : Roedor() { override fun roer() { } }")
    println("   Error: 'roer' in 'Roedor' is final and cannot be overridden.")
    println("   Por qué: los métodos también son cerrados por defecto.")
    println("   Solución: open fun roer() en Roedor.")
    Raton().roer()
}

// ===================================================================
// EJERCICIO 4 · Herencia y polimorfismo: instrumentos
// ===================================================================

/**
 * Ejercicio 4 · Herencia y polimorfismo: instrumentos.
 *
 * Recorre una `List<Instrumento>`: cada objeto suena y se afina a su manera
 * (polimorfismo). Solo a las guitarras se les cambian las cuerdas, y para
 * saberlo se usa `is`.
 */
fun b5Ejercicio4() {
    val instrumentos: List<Instrumento> = listOf(
        Guitarra("Guitarra española", 6),
        Piano("Piano de cola"),
        Bateria("Batería")
    )

    for (i in instrumentos) {
        println("${i.nombre}: ${i.sonar()}")
        i.afinar()
        // PIÉNSALO: dentro del if, i ya es Guitarra (smart cast) y no hace falta
        // convertirlo. En Java habría que escribir ((Guitarra) i).cambiarCuerdas().
        if (i is Guitarra) {
            i.cambiarCuerdas()
        }
    }
}

// ===================================================================
// EJERCICIO 5 · Interfaces: aves que nadan y vuelan
// ===================================================================

/**
 * Ejercicio 5 · Interfaces: aves que nadan y vuelan.
 *
 * Recorre una lista de aves y muestra lo que sabe hacer cada una con
 * [describirAve], que comprueba con `is` qué interfaces implementa.
 */
fun b5Ejercicio5() {
    val aves: List<Ave> = listOf(Pato("Donald"), Pinguino("Pingu"), Aguila("Real"))
    for (ave in aves) {
        println(describirAve(ave))
    }
}

// ===================================================================
// EJERCICIO 6 · data class y enum class: fichas del refugio
// ===================================================================

/**
 * Ejercicio 6 · data class y enum class: fichas del refugio.
 *
 * Recorre las fichas con desestructuración, crea una copia con `copy()`,
 * compara dos fichas con `==` y suma los minutos de cuidado de todas.
 */
fun b5Ejercicio6() {
    val fichas = listOf(
        FichaAnimal("Toby", Especie.PERRO, 3),
        FichaAnimal("Misi", Especie.GATO, 2),
        FichaAnimal("Copo", Especie.CONEJO, 4)
    )

    // Desestructuración: cada ficha se separa en sus tres propiedades
    for ((nombre, especie, edad) in fichas) {
        println("$nombre · ${especie.name.lowercase()} · $edad años · ${consejo(especie)} · ${especie.cuidadoDiarioMin} min/día")
    }

    val tobyMayor = fichas[0].copy(edad = fichas[0].edad + 1)   // misma ficha con un año más
    println(tobyMayor)                                          // toString automático

    val otraToby = FichaAnimal("Toby", Especie.PERRO, 4)
    println("¿Son iguales? ${tobyMayor == otraToby}")           // == compara los datos

    val total = fichas.sumOf { it.especie.cuidadoDiarioMin }
    println("Cuidado total: $total min")
}

// ===================================================================
// RETO · Refugio de animales
// ===================================================================

/**
 * Reto · Refugio de animales.
 *
 * Menú propio para ver los animales del [Refugio], adoptar uno y ver las
 * adopciones. Ninguna entrada del usuario hace fallar el programa: las
 * opciones se comparan como texto y los nombres vacíos se rechazan.
 */
fun b5Reto() {
    Refugio.inicializar()
    var entrada: String

    do {
        println()
        println("--- REFUGIO ---")
        println("1. Ver animales")
        println("2. Adoptar")
        println("3. Ver adopciones")
        println("0. Salir")
        entrada = leerLinea("Elige una opción: ")

        when (entrada) {
            "1" -> verAnimales()
            "2" -> adoptarAnimal()
            "3" -> verAdopciones()
            "0" -> mostrarAviso("Saliendo del refugio...")
            else -> mostrarError("Opción no válida. Elige 1, 2, 3 o 0.")
        }
    } while (entrada != "0")
}

/** Muestra la etiqueta de cada animal del refugio, o un aviso si no queda ninguno. */
private fun verAnimales() {
    if (Refugio.animales.isEmpty()) {
        mostrarAviso("No quedan animales en el refugio.")
        return
    }
    for (animal in Refugio.animales) {
        println(animal.etiqueta())
    }
}

/** Pide el nombre del animal y del adoptante e intenta la adopción. */
private fun adoptarAnimal() {
    val nombre = leerLinea("Nombre del animal: ")
    if (nombre.isEmpty()) {
        mostrarError("Tienes que escribir el nombre del animal.")
        return
    }
    val adoptante = leerLinea("Tu nombre: ")
    if (adoptante.isEmpty()) {
        mostrarError("Tienes que escribir tu nombre.")
        return
    }

    if (Refugio.adoptar(nombre, adoptante)) {
        val adoptado = Refugio.adopciones.last().animal
        mostrarAviso("¡$adoptado tiene nueva familia!")
    } else {
        mostrarError("No hay ningún animal con ese nombre.")
    }
}

/** Muestra las adopciones realizadas, o un aviso si todavía no hay ninguna. */
private fun verAdopciones() {
    if (Refugio.adopciones.isEmpty()) {
        mostrarAviso("Todavía no hay adopciones.")
        return
    }
    for (adopcion in Refugio.adopciones) {
        println(adopcion)
    }
}
