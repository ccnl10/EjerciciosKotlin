package Bloque5.EjemploZooB5

// ===================================================================
// EJEMPLO DEL ZOO · Felinos
// La familia completa en un archivo: Felino y Gato.
// ===================================================================

/** Felino: clase abstracta intermedia. Todos los felinos pasean solos. */
abstract class Felino(nombre: String) : Animal(nombre) {
    override fun deambular() = println("$nombre pasea solo")
}

/** Gato: es un [Felino] y además una [Mascota]. */
class Gato(nombre: String) : Felino(nombre), Mascota {

    override fun hacerRuido() = println("$nombre: ¡Miau!")

    override fun comer() {
        println("$nombre come pescado")
        hambre = HAMBRE_MINIMA
    }

    override fun serAmigable() = println("$nombre ronronea")

    override fun jugar() = println("$nombre persigue un ovillo")
}
