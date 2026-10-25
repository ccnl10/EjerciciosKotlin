package Bloque5.EjerciciosB5

// ===================================================================
// RETO · Refugio de animales: el refugio
// ===================================================================

/**
 * Registro de una adopción.
 *
 * @property animal nombre del animal adoptado.
 * @property adoptante nombre de la persona que lo adopta.
 */
data class Adopcion(val animal: String, val adoptante: String)

/**
 * El refugio. Es un `object`: solo existe uno en todo el programa y se usa
 * por su nombre, sin crearlo.
 */
object Refugio {

    /** Animales que esperan adopción. */
    val animales = mutableListOf<Animal>()

    /** Adopciones realizadas. */
    val adopciones = mutableListOf<Adopcion>()

    /** Indica si ya se han registrado los animales iniciales. */
    private var inicializado = false

    /**
     * Registra los animales iniciales la primera vez que se llama.
     * Así, al volver a entrar en el reto, no se duplican.
     */
    fun inicializar() {
        if (inicializado) return
        registrar(Perro("Toby", 3))
        registrar(Gato("Misi", 2))
        registrar(Perro("Rufo", 5))
        inicializado = true
    }

    /**
     * Añade un animal al refugio.
     *
     * @param animal animal que se registra.
     */
    fun registrar(animal: Animal) {
        animales.add(animal)
    }

    /**
     * Adopta un animal por su nombre (sin distinguir mayúsculas).
     * El animal sale del refugio y se guarda la adopción.
     *
     * @param nombre nombre del animal.
     * @param adoptante nombre de quien lo adopta.
     * @return `true` si se ha adoptado, `false` si no hay ningún animal con ese nombre.
     */
    fun adoptar(nombre: String, adoptante: String): Boolean {
        val animal = animales.find { it.nombre.equals(nombre, ignoreCase = true) } ?: return false
        animales.remove(animal)
        adopciones.add(Adopcion(animal.nombre, adoptante))
        return true
    }
}
