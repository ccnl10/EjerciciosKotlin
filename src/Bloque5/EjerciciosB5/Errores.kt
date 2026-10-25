package Bloque5.EjerciciosB5

// ===================================================================
// EJERCICIO 3 · Encuentra los errores (versiones corregidas)
// Lo usa b5Ejercicio3() en EjerciciosB5.kt.
// ===================================================================

// a) ERROR: "This type is final, so it cannot be extended".
//    En Kotlin las clases son cerradas por defecto. SOLUCIÓN: open.
//    En Java compila porque allí las clases se pueden heredar por defecto
//    (habría que escribir final para impedirlo).
/** Fragmento a) corregido: la superclase lleva `open`. */
open class Insecto {
    /** Hace volar al insecto. */
    fun volar() = println("El insecto vuela")
}

/** Subclase del fragmento a). */
class Abeja : Insecto()

// b) ERROR: "No value passed for parameter 'nombre'".
//    Reptil necesita un nombre en su constructor. SOLUCIÓN: pasarlo.
/** Fragmento b): superclase con un parámetro en el constructor. */
open class Reptil(val nombre: String)

/** Fragmento b) corregido: recibe el nombre y se lo pasa a [Reptil]. */
class Serpiente(nombre: String) : Reptil(nombre)

// c) ERROR: "'respirar' hides member of supertype 'Mamifero' and needs an
//    'override' modifier". SOLUCIÓN: override en la subclase.
/** Fragmento c): superclase con un método que se puede sobrescribir. */
open class Mamifero {
    /** Forma de respirar genérica. */
    open fun respirar() = println("Respira por la nariz")
}

/** Fragmento c) corregido: sobrescribe con `override`. */
class Ballena : Mamifero() {
    override fun respirar() = println("Respira por el espiráculo")
}

// d) ERROR: "Cannot create an instance of an abstract class".
//    SOLUCIÓN: crear una subclase concreta y crear objetos de ella.
/** Fragmento d): clase abstracta, no se puede instanciar. */
abstract class Planta

/** Fragmento d) corregido: subclase concreta de [Planta]. */
class Cactus : Planta()

// e) ERROR: "'roer' in 'Roedor' is final and cannot be overridden".
//    El método del padre no es open. SOLUCIÓN: open en el padre.
/** Fragmento e) corregido: el método lleva `open`. */
open class Roedor {
    /** Forma de roer genérica. */
    open fun roer() = println("El roedor roe")
}

/** Subclase del fragmento e). */
class Raton : Roedor() {
    override fun roer() = println("El ratón roe queso")
}
