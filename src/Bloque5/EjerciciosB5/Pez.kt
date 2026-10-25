package Bloque5.EjerciciosB5

// ===================================================================
// EJERCICIO 2 · Setter con validación y constructor secundario
// Lo usa b5Ejercicio2() en EjerciciosB5.kt.
// ===================================================================

/** Temperatura mínima del agua admitida por [Pez], en grados. */
const val TEMPERATURA_MINIMA = 18.0

/** Temperatura máxima del agua admitida por [Pez], en grados. */
const val TEMPERATURA_MAXIMA = 28.0

/** Temperatura que usa el constructor secundario de [Pez], en grados. */
const val TEMPERATURA_POR_DEFECTO = 24.0

/**
 * Pez con la temperatura del agua controlada por un setter con validación.
 *
 * @property nombre nombre del pez.
 * @param temperatura temperatura inicial del agua.
 */
class Pez(val nombre: String, temperatura: Double) {

    /**
     * Temperatura del agua. El setter solo acepta valores entre
     * [TEMPERATURA_MINIMA] y [TEMPERATURA_MAXIMA]; si no, avisa y no cambia.
     */
    var temperaturaAgua = TEMPERATURA_POR_DEFECTO
        set(valor) {
            if (valor in TEMPERATURA_MINIMA..TEMPERATURA_MAXIMA) {
                field = valor
            } else {
                println("Temperatura $valor no válida para $nombre. Se mantiene $field")
            }
        }

    // PIÉNSALO: si escribiéramos `var temperaturaAgua = temperatura`, el valor
    // del constructor NO pasaría por el setter: la inicialización asigna el
    // campo directamente. Para validarlo también, se asigna en un init, que
    // sí usa el setter (si no es válido, se queda el valor por defecto).
    init {
        temperaturaAgua = temperatura
    }

    /** Constructor secundario: crea el pez con [TEMPERATURA_POR_DEFECTO] grados. */
    constructor(nombre: String) : this(nombre, TEMPERATURA_POR_DEFECTO)
}
