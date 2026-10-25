package Bloque5.EjerciciosB5

// ===================================================================
// EJERCICIO 5 · Interfaces: aves que nadan y vuelan
// Lo usa b5Ejercicio5() en EjerciciosB5.kt.
// ===================================================================

/** Lo que sabe hacer un ave que nada. */
interface Nadador {
    /** Describe cómo nada. */
    fun nadar(): String
}

/**
 * Lo que sabe hacer un ave que vuela.
 *
 * PIÉNSALO: no puede ser una clase abstracta porque Pato ya hereda de [Ave]
 * y en Kotlin solo se hereda de una clase. Con interfaces, Pato puede ser
 * a la vez [Nadador] y [Volador].
 */
interface Volador {
    /** Altura máxima a la que vuela, en metros. La da cada clase. */
    val altitudMaxima: Int

    /** Método con cuerpo: lo heredan todas las clases que implementan la interfaz. */
    fun volar() = "vuela hasta $altitudMaxima m"
}

/**
 * Ave: base común con el nombre.
 *
 * @property nombre nombre del ave.
 */
abstract class Ave(val nombre: String)

/** Pato: nada y vuela. */
class Pato(nombre: String) : Ave(nombre), Nadador, Volador {
    override val altitudMaxima = 1000
    override fun nadar() = "nada en el estanque"
}

/** Pingüino: solo nada. */
class Pinguino(nombre: String) : Ave(nombre), Nadador {
    override fun nadar() = "bucea bajo el hielo"
}

/** Águila: solo vuela. */
class Aguila(nombre: String) : Ave(nombre), Volador {
    override val altitudMaxima = 3000
}

/**
 * Devuelve lo que sabe hacer un ave, comprobando con `is` qué interfaces implementa.
 *
 * @param ave ave que se describe.
 * @return por ejemplo `"Donald: nada en el estanque y vuela hasta 1000 m"`.
 */
fun describirAve(ave: Ave): String {
    val habilidades = mutableListOf<String>()
    if (ave is Nadador) habilidades.add(ave.nadar())     // smart cast a Nadador
    if (ave is Volador) habilidades.add(ave.volar())     // smart cast a Volador
    return "${ave.nombre}: ${habilidades.joinToString(" y ")}"
}
