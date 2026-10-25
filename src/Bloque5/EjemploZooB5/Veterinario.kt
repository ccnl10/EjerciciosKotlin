package Bloque5.EjemploZooB5

// ===================================================================
// EJEMPLO DEL ZOO · Veterinario
// ===================================================================

/** Veterinario del zoo. Atiende a cualquier animal. */
class Veterinario {

    /**
     * Vacuna a un animal y hace que haga su ruido.
     *
     * El parámetro es de tipo [Animal], así que sirve para cualquier subclase:
     * se ejecuta el [Animal.hacerRuido] del objeto que llega (polimorfismo).
     *
     * @param animal animal que se vacuna.
     */
    fun vacunar(animal: Animal) {
        println("Vacunando a ${animal.nombre}...")
        animal.hacerRuido()
    }
}
