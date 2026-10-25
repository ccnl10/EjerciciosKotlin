package Bloque5.EjerciciosB5

// ===================================================================
// EJERCICIO 6 · data class y enum class: fichas del refugio
// Lo usa b5Ejercicio6() en EjerciciosB5.kt.
// La enum Especie también la usa el reto (AnimalesRefugio.kt).
// ===================================================================

/**
 * Especies del refugio, con los minutos de cuidado que necesita cada una al día.
 *
 * @property cuidadoDiarioMin minutos de cuidado diario.
 */
enum class Especie(val cuidadoDiarioMin: Int) {
    PERRO(60),
    GATO(20),
    CONEJO(30)
}

/**
 * Ficha de un animal del refugio. Al ser `data class`, tiene `toString`,
 * `equals`, `copy` y desestructuración automáticos.
 *
 * @property nombre nombre del animal.
 * @property especie especie del animal.
 * @property edad edad en años.
 */
data class FichaAnimal(val nombre: String, val especie: Especie, val edad: Int)

/**
 * Devuelve un consejo de cuidado para cada especie.
 *
 * El `when` no lleva `else`: cubre todos los valores de [Especie]. Si se
 * añade una especie nueva, el compilador avisa de que falta su caso.
 *
 * @param especie especie del animal.
 * @return el consejo para esa especie.
 */
fun consejo(especie: Especie): String = when (especie) {
    Especie.PERRO -> "Necesita paseos diarios"
    Especie.GATO -> "Necesita un rascador"
    Especie.CONEJO -> "Necesita heno fresco"
}
