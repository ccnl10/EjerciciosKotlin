package Bloque3

// ===================================================================
// EJERCICIOS DEL BLOQUE 3 · PARTE 2 (Expresiones lambda)
// ===================================================================

// EJERCICIO 1 · De función a lambda
fun b3_2Ejercicio1() {
    // Lambdas guardadas en val, con el tipo de función explícito
    val cuadradoLambda: (Int) -> Int = { n: Int -> n * n }
    val esParLambda: (Int) -> Boolean = { n: Int -> n % 2 == 0 }
    val nombreCompletoLambda: (String, String) -> String =
        { nombre: String, apellido: String -> "$nombre $apellido" }
    val imprimirSeparadorLambda: () -> Unit = { println("--------------------") }

    // Versión con it: cuando la lambda tiene UN solo parámetro, se puede
    // omitir y usar it. El tipo de it lo saca Kotlin del tipo declarado.
    val cuadradoIt: (Int) -> Int = { it * it }
    val esParIt: (Int) -> Boolean = { it % 2 == 0 }

    // Comprobación: las dos versiones dan el mismo resultado
    println("cuadrado(5): fun = ${cuadrado(5)}, lambda = ${cuadradoLambda(5)}, it = ${cuadradoIt(5)}")
    println("esPar(8): fun = ${esPar(8)}, lambda = ${esParLambda(8)}, it = ${esParIt(8)}")
    println("esPar(7): fun = ${esPar(7)}, lambda = ${esParLambda(7)}, it = ${esParIt(7)}")
    println("nombreCompleto: fun = ${nombreCompleto("Laura", "García")}, " +
            "lambda = ${nombreCompletoLambda("Laura", "García")}")
    print("imprimirSeparador (fun):    ")
    imprimirSeparador()
    print("imprimirSeparador (lambda): ")
    imprimirSeparadorLambda()
}

// EJERCICIO 2 · Ponle nombre al tipo
fun b3_2Ejercicio2() {
    // Respuesta: el tipo de cada lambda es (tipos de los parámetros) -> tipo del resultado
    val a: (Double) -> Double = { x: Double -> x / 2 }                 // divide un Double: devuelve Double
    val b: (String) -> Int = { texto: String -> texto.length }        // length es Int
    val c: (String, Int) -> String =
        { nombre: String, edad: Int -> "$nombre tiene $edad años" }   // plantilla: String
    val d: () -> Unit = { println("Cargando...") }                    // sin parámetros; println devuelve Unit
    val e: (Int) -> Boolean = { n: Int -> n in 1..10 }                // in devuelve Boolean

    // Si el tipo escrito no coincidiera con la lambda, IntelliJ lo marcaría
    // en rojo (Type mismatch). Como compila, los tipos son correctos.
    println("a(9.0) = ${a(9.0)}")
    println("b(\"Kotlin\") = ${b("Kotlin")}")
    println("c(\"Laura\", 19) = ${c("Laura", 19)}")
    print("d() -> ")
    d()
    println("e(5) = ${e(5)}, e(15) = ${e(15)}")
}

// EJERCICIO 3 · Calculadora con lambdas
fun b3_2Ejercicio3() {
    // Cuatro lambdas con su tipo de función explícito
    val sumar: (Double, Double) -> Double = { a, b -> a + b }
    val restar: (Double, Double) -> Double = { a, b -> a - b }
    val multiplicar: (Double, Double) -> Double = { a, b -> a * b }
    val dividir: (Double, Double) -> Double = { a, b -> a / b }

    print("Primer número: ")
    val numero1 = readln().replace(',', '.').toDoubleOrNull() ?: 0.0
    print("Segundo número: ")
    val numero2 = readln().replace(',', '.').toDoubleOrNull() ?: 0.0
    print("Operador (+ - * /): ")
    val operador = readln().trim()

    // PIÉNSALO: el when devuelve una lambda o null (si el operador no es
    // válido), así que el tipo de la variable es ((Double, Double) -> Double)?
    // Los paréntesis son necesarios: sin ellos, el ? afectaría solo al
    // Double del resultado, no a la función entera.
    val operacion: ((Double, Double) -> Double)? = when (operador) {
        "+" -> sumar
        "-" -> restar
        "*" -> multiplicar
        "/" -> dividir
        else -> null
    }

    if (operacion == null) {
        println("Operador no válido: '$operador'")
        return
    }

    println("$numero1 $operador $numero2 = ${calcular(numero1, numero2, operacion)}")
}

// EJERCICIO 4 · Analizador de textos
fun b3_2Ejercicio4() {
    print("Escribe una frase: ")
    val frase = readln()
    analizarTexto(frase)
}

// EJERCICIO 5 · Tu propio repeat
fun b3_2Ejercicio5() {
    val veces = 3
    // Lambda final: como accion es el último parámetro, la lambda va fuera
    // de los paréntesis. Tiene un solo parámetro, así que se puede usar it.
    repetirAccion(veces) {
        println("Vuelta $it de $veces")
    }
}

// EJERCICIO 6 · Predice la salida
fun b3_2Ejercicio6() {
    val gritar: (String) -> String = { it.uppercase() + "!" }
    val susurrar: (String) -> String = { "..." + it.lowercase() }

    // PREDICCIÓN: HOLA!      -> uppercase() pasa a mayúsculas y se añade "!"
    println(transformar("Hola", gritar))
    // PREDICCIÓN: ...hola    -> se añade "..." delante del texto en minúsculas
    println(transformar("Hola", susurrar))
    // PREDICCIÓN: aloH       -> reversed() le da la vuelta (respeta la H mayúscula)
    println(transformar("Hola") { it.reversed() })
    // PREDICCIÓN: 4          -> "Hola" tiene 4 caracteres, convertido a String
    println(transformar("Hola") { texto -> texto.length.toString() })

    // PREDICCIÓN: 6          -> repeat(4) pasa it = 0, 1, 2, 3 (empieza en 0,
    //                           no en 1): 0 + 1 + 2 + 3 = 6
    var total = 0
    repeat(4) { total += it }
    println(total)
}

// RETO · Reglas de descuento
fun b3_2RetoReglaDescuento() {
    val precios = listOf(50.0, 15.0)

    for (precio in precios) {
        println("--- Producto de ${formatear(precio)} € ---")
        mostrarPrecioConRegla("Sin descuento:", precio, sinDescuento)
        mostrarPrecioConRegla("Black Friday (30 %):", precio, blackFriday)
        mostrarPrecioConRegla("Estudiante (10 %, >= 20 €):", precio, descuentoEstudiante)

        // Extra: una regla nueva que aplica Black Friday y después estudiante
        val blackFridayYEstudiante = combinarReglas(blackFriday, descuentoEstudiante)
        mostrarPrecioConRegla("Black Friday + estudiante:", precio, blackFridayYEstudiante)
    }
}