package Bloque5.EjemploZooB5

// ===================================================================
// EJEMPLO DEL ZOO · Animal
// Raíz de la jerarquía: todos los animales del zoo heredan de ella.
// ===================================================================

/** Valor mínimo del hambre de un animal. */
const val HAMBRE_MINIMA = 0

/** Valor máximo del hambre de un animal. */
const val HAMBRE_MAXIMA = 10

/** Hambre con la que llega cada animal al zoo. */
const val HAMBRE_INICIAL = 5

/** A partir de este valor, el animal tiene hambre. */
const val UMBRAL_HAMBRE = 5

/**
 * Animal del zoo. Es abstracta: no se puede crear «un animal» sin más,
 * solo hipopótamos, lobos, perros o gatos.
 *
 * - [hacerRuido] y [comer] son abstractos: cada animal los hace a su manera.
 * - [deambular] es `open`: lo cambian [Canino] y [Felino].
 * - [dormir] está cerrado: todos los animales duermen igual.
 *
 * @property nombre nombre del animal.
 */
abstract class Animal(val nombre: String) {

    /**
     * Hambre del animal, entre [HAMBRE_MINIMA] y [HAMBRE_MAXIMA].
     *
     * El setter es `protected`: solo esta clase y sus subclases pueden
     * cambiarla (por ejemplo, al comer). Desde fuera solo se puede leer.
     * Si se intenta guardar un valor fuera del rango, no se guarda y se avisa.
     */
    var hambre = HAMBRE_INICIAL
        protected set(valor) {
            if (valor in HAMBRE_MINIMA..HAMBRE_MAXIMA) {
                field = valor
            } else {
                println("Hambre $valor no válida para $nombre. Se mantiene $field")
            }
        }

    /** `true` si [hambre] es [UMBRAL_HAMBRE] o más. Se calcula cada vez que se lee. */
    val tieneHambre: Boolean
        get() = hambre >= UMBRAL_HAMBRE

    /** Muestra el ruido del animal. Cada subclase da el suyo. */
    abstract fun hacerRuido()

    /** Muestra lo que come el animal y le quita el hambre. Cada subclase da el suyo. */
    abstract fun comer()

    /** Muestra cómo se mueve el animal. Lo sobrescriben [Canino] y [Felino]. */
    open fun deambular() = println("$nombre deambula por el zoo")

    /** Muestra al animal durmiendo. Es igual para todos, así que no se puede sobrescribir. */
    fun dormir() = println("$nombre duerme: Zzz")
}
