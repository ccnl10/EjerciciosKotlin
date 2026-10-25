package Bloque5.EjerciciosB5

// ===================================================================
// EJERCICIO 1 · Tu primera clase
// Lo usa b5Ejercicio1() en EjerciciosB5.kt.
// ===================================================================

/**
 * Cachorro con nombre, raza y edad en meses.
 *
 * Muestra un mensaje al crearse (bloque `init`) y calcula si es adulto
 * cada vez que se consulta [esAdulto] (getter personalizado).
 *
 * @property nombre nombre del cachorro.
 * @property raza raza del cachorro.
 * @property edadMeses edad en meses; puede cambiar con [cumplirMes].
 */
class Cachorro(val nombre: String, val raza: String, var edadMeses: Int) {

    /** `true` si el cachorro tiene 12 meses o más. No se guarda: se calcula al leerla. */
    val esAdulto: Boolean
        get() = edadMeses >= 12

    init {
        println("Nuevo cachorro: $nombre")
    }

    /** Suma un mes a la edad del cachorro. */
    fun cumplirMes() {
        edadMeses++
    }

    /** Muestra los datos del cachorro y si ya es adulto. */
    fun mostrar() {
        println("$nombre ($raza), $edadMeses meses. ¿Adulto? ${if (esAdulto) "Sí" else "No"}")
    }
}
