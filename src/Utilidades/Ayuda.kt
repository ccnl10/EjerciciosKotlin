package Utilidades

/**
 * Muestra un cuadro de ayuda con un título y una lista de líneas explicativas.
 *
 * La usan todos los menús del programa cuando el usuario escribe `?`.
 * Así el formato de la ayuda es igual en todas las pantallas y solo
 * cambia el texto.
 *
 * @param titulo título que aparece en la cabecera del cuadro.
 * @param lineas líneas de texto de la ayuda, en el orden en que se muestran.
 */
fun mostrarAyuda(titulo: String, lineas: List<String>) {
    print(AMARILLO)
    println()
    println("---------------- AYUDA  -----------------")
    println(titulo)
    println("----------------------------------------")
    for (linea in lineas) {
        println(linea)
    }
    println("----------------------------------------")
    println("Pulsa Intro para volver al menú...")
    print(RESET)
    readln()
}
