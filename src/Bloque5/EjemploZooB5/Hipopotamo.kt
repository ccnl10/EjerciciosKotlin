package Bloque5.EjemploZooB5

// ===================================================================
// EJEMPLO DEL ZOO · Hipopotamo
// Hereda directamente de Animal: usa el deambular() de Animal.
// ===================================================================

/** Hipopótamo: hereda de [Animal] y no cambia su forma de deambular. */
class Hipopotamo(nombre: String) : Animal(nombre) {

    override fun hacerRuido() = println("$nombre: ¡Grooar!")

    override fun comer() {
        println("$nombre come hierba")
        hambre = HAMBRE_MINIMA
    }
}
