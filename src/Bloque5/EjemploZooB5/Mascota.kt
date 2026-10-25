package Bloque5.EjemploZooB5

// ===================================================================
// EJEMPLO DEL ZOO · Mascota
// Comportamiento que solo tienen algunos animales (Perro y Gato), por eso
// va en una interfaz y no en Animal.
// ===================================================================

/**
 * Lo que sabe hacer una mascota.
 *
 * No puede ser una clase abstracta porque [Perro] y [Gato] ya heredan de
 * [Canino] y [Felino], y en Kotlin solo se hereda de una clase.
 */
interface Mascota {

    /** Nombre de la mascota. [Animal] ya lo proporciona. */
    val nombre: String

    /** Muestra cómo demuestra cariño la mascota. */
    fun serAmigable()

    /** Muestra cómo juega la mascota. */
    fun jugar()

    /** Método con cuerpo: lo heredan todas las mascotas sin escribirlo. */
    fun saludar() = println("Hola, soy $nombre")
}
