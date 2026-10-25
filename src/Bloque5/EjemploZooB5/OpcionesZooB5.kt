package Bloque5.EjemploZooB5

// ===================================================================
// EJEMPLO DEL ZOO · Opciones del menú
// Cada función es una opción de menuZooB5() y enseña una parte del
// ejemplo usando los mismos animales.
// ===================================================================

/**
 * Crea los animales del zoo: uno de cada clase concreta.
 *
 * La lista es de tipo `List<Animal>`: puede guardar cualquier subclase.
 *
 * @return la lista con un hipopótamo, un lobo, un perro y un gato.
 */
fun crearZoo(): List<Animal> = listOf(
    Hipopotamo("Pepa"),
    Lobo("Lupo"),
    Perro("Toby"),
    Gato("Misi")
)

/**
 * Opción 1 · Censo: nombre, clase y si es mascota de cada animal.
 *
 * `a::class.simpleName` da el nombre de la clase real del objeto, y
 * `is Mascota` comprueba si implementa la interfaz.
 *
 * @param animales animales del zoo.
 */
fun censo(animales: List<Animal>) {
    for (a in animales) {
        println("${a.nombre} es ${a::class.simpleName}. ¿Mascota? ${if (a is Mascota) "Sí" else "No"}")
    }
}

/**
 * Opción 2 · Polimorfismo: cada animal hace su ruido y deambula a su manera.
 *
 * Con un Lobo, `hacerRuido()` se ejecuta en Lobo y `deambular()` en Canino;
 * con un Hipopotamo, `deambular()` sube hasta Animal.
 *
 * @param animales animales del zoo.
 */
fun ruidosYPaseos(animales: List<Animal>) {
    for (a in animales) {
        a.hacerRuido()
        a.deambular()
    }
}

/**
 * Opción 3 · Hambre: da de comer a los que tienen hambre y luego todos duermen.
 *
 * Usa la propiedad calculada [Animal.tieneHambre]. Desde aquí el hambre solo
 * se puede leer: su setter es `protected`, y solo la cambia `comer()`.
 *
 * @param animales animales del zoo.
 */
fun horaDeComer(animales: List<Animal>) {
    for (a in animales) {
        if (a.tieneHambre) {
            print("Hambre ${a.hambre} → ")
            a.comer()
        } else {
            println("${a.nombre} no tiene hambre (hambre ${a.hambre})")
        }
    }
    println()
    for (a in animales) {
        a.dormir()          // el mismo método, heredado de Animal, para todos
    }
}

/**
 * Opción 4 · El veterinario vacuna a todos los animales.
 *
 * [Veterinario.vacunar] recibe un [Animal], así que acepta cualquier subclase.
 *
 * @param animales animales del zoo.
 */
fun visitaVeterinario(animales: List<Animal>) {
    val veterinario = Veterinario()
    for (a in animales) {
        veterinario.vacunar(a)
    }
}

/**
 * Opción 5 · Interfaz: solo las mascotas saludan, son amigables y juegan.
 *
 * `filterIsInstance<Mascota>()` se queda con los animales que implementan
 * [Mascota] y los devuelve ya como `List<Mascota>`.
 *
 * @param animales animales del zoo.
 */
fun horaDeJugar(animales: List<Animal>) {
    for (m in animales.filterIsInstance<Mascota>()) {
        m.saludar()
        m.serAmigable()
        m.jugar()
    }
}

/**
 * Opción 6 · Comprobar el tipo: solo el perro trae el palo.
 *
 * Con `is`, dentro del `if` el animal ya es un [Perro] (smart cast). Con
 * `as?`, si el animal no es un perro se obtiene `null` y `?.` no llama al método.
 *
 * @param animales animales del zoo.
 */
fun paseoConElPerro(animales: List<Animal>) {
    for (a in animales) {
        if (a is Perro) {
            a.traerPalo()
        }
    }

    val gato = animales.find { it is Gato }
    val comoPerro = gato as? Perro            // un gato no es un perro: null
    comoPerro?.traerPalo()                    // no hace nada y no da error
    println("¿${gato?.nombre} puede traer el palo? ${if (comoPerro != null) "Sí" else "No"}")
}