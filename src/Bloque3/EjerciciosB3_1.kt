package Bloque3

// ===================================================================
// EJERCICIOS DEL BLOQUE 3_1
// Cada función hace el papel del "main" de su ejercicio:
// como pide el enunciado, solo llama a otras funciones (FuncionesB3_1.kt).
// ===================================================================

// EJERCICIO 1 · Saludos
fun b3_1Ejercicio1() {
    mostrarBienvenida()
    saludar("Laura")
    saludarEnIdioma("Laura")           // sin segundo argumento -> español
    saludarEnIdioma("Laura", "en")
    saludarEnIdioma("Laura", "fr")
}

// EJERCICIO 2 · Conversor de unidades
fun b3_1Ejercicio2() {
    println("21,5 °C = ${formatear(celsiusAFahrenheit(21.5), 1)} °F")
    println("10 km = ${formatear(kmAMillas(10.0))} millas")
    println("¿Es 4 par? ${esPar(4)}")
    println("¿Es 7 par? ${esPar(7)}")
    println("Máximo de 3, 9 y 5: ${maximoDeTres(3, 9, 5)}")
}

// EJERCICIO 3 · Generador de nombres de usuario
fun b3_1Ejercicio3() {
    // 1. Solo los argumentos obligatorios
    println(crearNombreUsuario("Laura", "Garcia"))
    // 2. Cambiando solo el año
    println(crearNombreUsuario("Laura", "Garcia", 2008))
    // 3. Cambiando solo el separador (argumento con nombre: nos saltamos anio)
    println(crearNombreUsuario("Laura", "Garcia", separador = "."))
    // 4. Con todos los argumentos
    println(crearNombreUsuario("Laura", "Garcia", 2008, "-"))
    // 5. Todos con nombre y en otro orden
    println(crearNombreUsuario(separador = "#", anio = 2030, apellido = "Garcia", nombre = "Laura"))
}

// EJERCICIO 4 · Cláusulas de guarda
fun b3_1Ejercicio4() {
    mostrarResultado(calcularMedia(7.0, 8.5, 7.0))    // válidas -> Media: 7,50
    mostrarResultado(calcularMedia(7.0, 11.0, 6.0))   // 11 fuera de rango
    mostrarResultado(calcularMedia(-2.0, 5.0, 6.0))   // -2 fuera de rango
}

// EJERCICIO 5 · Encuentra los errores
// Las explicaciones están en los comentarios de FuncionesB3_1.kt
fun b3_1Ejercicio5() {
    println("a) duplicar(4) = ${duplicar(4)}")
    println("b) incrementar(5) = ${incrementar(5)}")
    val t = total(19.99, 3)                      // c) orden correcto
    println("c) total = ${formatear(t)}")
    println("d) esMayorDeEdad(20) = ${esMayorDeEdad(20)}, esMayorDeEdad(15) = ${esMayorDeEdad(15)}")
    print("e) ")
    mostrarPrecio("Curso de Kotlin")
}

// EJERCICIO 6 · Calculadora de productos
fun b3_1Ejercicio6() {
    val nombreProducto = "Curso de Kotlin"
    val precioUnitario = 99.0
    val cantidad = 2
    val porcentajeDescuento = 10.0
    val porcentajeImpuesto = 7.0

    mostrarBienvenidaTienda()
    mostrarInfoProducto(nombreProducto, precioUnitario, cantidad, porcentajeDescuento, porcentajeImpuesto)

    val subtotal = calcularSubtotal(precioUnitario, cantidad)
    val importeDescuento = calcularImporteDescuento(subtotal, porcentajeDescuento)
    val precioConDescuento = calcularPrecioConDescuento(subtotal, importeDescuento)
    val importeImpuesto = calcularImporteImpuesto(precioConDescuento, porcentajeImpuesto)
    val precioFinal = calcularPrecioFinal(precioConDescuento, importeImpuesto)

    mostrarResumen(subtotal, importeDescuento, precioConDescuento, importeImpuesto, precioFinal)
    mostrarDespedida()
}

// RETO (parte 1) · Mes y estación refactorizado: 2 líneas
fun b3_1RetoMesEstacion() {
    val mes = leerMes()
    println("${nombreMes(mes)} - ${estacionDe(mes)}")
}

// RETO (parte 2) · Juego de adivinar refactorizado: 3 líneas
// Funciones creadas: mostrarReglasJuego, leerNumeroEnRango, jugarAdivinarNumero,
// mostrarPista y mostrarResultadoJuego. leerNumeroEnRango se reutiliza en leerMes().
fun b3_1RetoAdivina() {
    mostrarReglasJuego()
    val intentos = jugarAdivinarNumero()
    mostrarResultadoJuego(intentos)
}