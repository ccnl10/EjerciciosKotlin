package Bloque5.EjemploZooB5

// ===================================================================
// EJEMPLO DEL ZOO · Caninos
// La familia completa en un archivo: Canino, Lobo y Perro.
// ===================================================================

/** Canino: clase abstracta intermedia. Todos los caninos van en manada. */
abstract class Canino(nombre: String) : Animal(nombre) {
    override fun deambular() = println("$nombre va en manada")
}

/** Lobo: es un [Canino], pero no es mascota. */
class Lobo(nombre: String) : Canino(nombre) {

    override fun hacerRuido() = println("$nombre: ¡Auuuu!")

    override fun comer() {
        println("$nombre come carne")
        hambre = HAMBRE_MINIMA
    }
}

/**
 * Perro: es un [Canino] y además una [Mascota].
 *
 * No escribe `override val nombre`: la propiedad que pide [Mascota] ya la
 * hereda de [Animal].
 */
class Perro(nombre: String) : Canino(nombre), Mascota {

    override fun hacerRuido() = println("$nombre: ¡Guau!")

    override fun comer() {
        println("$nombre come pienso")
        hambre = HAMBRE_MINIMA
    }

    override fun serAmigable() = println("$nombre mueve la cola")

    override fun jugar() = println("$nombre persigue la pelota")

    /** Método que solo tienen los perros: para usarlo desde un [Animal] hay que comprobar el tipo. */
    fun traerPalo() = println("$nombre trae el palo")
}
