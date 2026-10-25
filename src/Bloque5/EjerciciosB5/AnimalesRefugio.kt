package Bloque5.EjerciciosB5

import java.util.Locale

// ===================================================================
// RETO · Refugio de animales: las clases de animales
// ===================================================================

/** Lo que tiene un animal que se puede adoptar. */
interface Adoptable {
    /** Cuota de adopción, en euros. */
    val cuota: Double
}

/**
 * Animal del refugio. Cada animal recibe un identificador único (1, 2, 3…)
 * gracias al contador del `companion object`.
 *
 * @property nombre nombre del animal.
 * @property edad edad en años.
 */
abstract class Animal(val nombre: String, val edad: Int) {

    /** Especie del animal. La da cada subclase. */
    abstract val especie: Especie

    /** Identificador único, asignado al crear el animal. */
    val id = siguienteId()

    /** Lo que pertenece a la clase y no a cada animal: el contador de identificadores. */
    companion object {
        private var contador = 0

        /** Devuelve el siguiente identificador libre. */
        fun siguienteId(): Int = ++contador
    }

    /** Descripción del animal, por ejemplo `"#1 Toby (perro, 3 años)"`. */
    open fun describir() = "#$id $nombre (${especie.name.lowercase()}, $edad años)"
}

/** Perro adoptable, con una cuota de 50 €. */
class Perro(nombre: String, edad: Int) : Animal(nombre, edad), Adoptable {
    override val especie = Especie.PERRO
    override val cuota = 50.0
}

/** Gato adoptable, con una cuota de 30 €. */
class Gato(nombre: String, edad: Int) : Animal(nombre, edad), Adoptable {
    override val especie = Especie.GATO
    override val cuota = 30.0
}

/**
 * Función de extensión: añade a [Animal] la descripción con su cuota.
 *
 * `as?` convierte a [Adoptable] o da `null` si el animal no lo es; en ese
 * caso, `?:` pone una cuota de 0.
 *
 * @return por ejemplo `"#1 Toby (perro, 3 años) · cuota 50,00 €"`.
 */
fun Animal.etiqueta(): String {
    val cuota = (this as? Adoptable)?.cuota ?: 0.0
    return "${describir()} · cuota ${"%.2f".format(Locale.forLanguageTag("es-ES"), cuota)} €"
}
