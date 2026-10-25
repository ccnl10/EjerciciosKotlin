package Bloque5.EjerciciosB5

// ===================================================================
// EJERCICIO 4 · Herencia y polimorfismo: instrumentos
// Lo usa b5Ejercicio4() en EjerciciosB5.kt.
// ===================================================================

/**
 * Instrumento musical. Es abstracta: no se puede crear "un instrumento"
 * sin más, solo guitarras, pianos o baterías.
 *
 * @property nombre nombre del instrumento.
 */
abstract class Instrumento(val nombre: String) {

    /** Sonido que hace el instrumento. Cada subclase da el suyo. */
    abstract fun sonar(): String

    /** Afina el instrumento. Es `open` para que las subclases puedan cambiarlo. */
    open fun afinar() = println("Afinando $nombre...")
}

/**
 * Guitarra: añade una propiedad y un método propios.
 *
 * @property cuerdas número de cuerdas.
 */
class Guitarra(nombre: String, val cuerdas: Int) : Instrumento(nombre) {
    override fun sonar() = "Tlan, tlan"

    /** Método que solo tienen las guitarras. */
    fun cambiarCuerdas() = println("Cambiando las $cuerdas cuerdas de $nombre")
}

/** Piano: usa el [afinar] heredado. */
class Piano(nombre: String) : Instrumento(nombre) {
    override fun sonar() = "Plin, plin"
}

/** Batería: sobrescribe [afinar] porque no se afina como los demás. */
class Bateria(nombre: String) : Instrumento(nombre) {
    override fun sonar() = "Pom, pom, chas"
    override fun afinar() = println("$nombre no se afina: se ajustan los parches")
}
