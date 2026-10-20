package Utilidades

// Códigos de color ANSI para la consola
const val ROJO = "\u001B[31m"
const val VERDE = "\u001B[32m"
const val AMARILLO = "\u001B[33m"
const val AZUL = "\u001B[34m"
const val CIAN = "\u001B[36m"
const val RESET = "\u001B[0m"
const val MORADO = "\u001B[35m"

// Muestra un mensaje de aviso en AMARILLO y vuelve al color normal
fun mostrarAviso(mensaje: String) {
    println("$AMARILLO$mensaje$RESET")
}
// Muestra un mensaje de error en ROJO y vuelve al color normal
fun mostrarError(mensaje: String) {
    println("$ROJO$mensaje$RESET")
}