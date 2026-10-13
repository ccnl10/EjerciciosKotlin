package Bloque1

// Constantes del ejercicio 6 (ampliación)
const val SHOP_NAME = "DAM Store"
const val DEFAULT_TAX = 21.0

fun b1Ejercicio1() {
    val nombre = "Laura"
    val edad = 19
    val ciudad = "Villarrobledo"
    val carne = true

    println("My name is $nombre, I am $edad years old, I live in $ciudad. Driving licence: $carne")
    println("In 10 years I will be ${edad + 10} years old")
}

fun b1Ejercicio2() {
    // 1. Año de nacimiento -> val, Int
    // No cambia nunca: naces una vez. Un año es un número entero.
    val anioNacimiento: Int = 2007

    // 2. Vidas en un juego -> var, Int
    // Cambia durante la partida (pierdes o ganas vidas). No hay medias vidas, así que es entero.
    var vidas: Int = 3

    // 3. Nombre de la app -> val, String
    // Es un texto fijo que no cambia mientras la app se ejecuta.
    val nombreApp: String = "MiApp"

    // 4. Artículos en el carrito (contador) -> var, Int
    // Va subiendo y bajando al añadir o quitar productos. Se cuentan unidades enteras.
    var articulosCarrito: Int = 0

    // 5. Valor de π -> val, Double
    // Es una constante matemática que nunca cambia. Tiene decimales, así que es Double.
    val pi: Double = 3.14159

    println("Año de nacimiento: $anioNacimiento")
    println("Vidas: $vidas")
    println("Nombre de la app: $nombreApp")
    println("Artículos en el carrito: $articulosCarrito")
    println("Valor de π: $pi")
}

fun b1Ejercicio3() {
    // ---------------------------------------------------------------
    // a) Código original:
    //      val score = 10
    //      score = score + 5
    // Problema: NO COMPILA. Una variable declarada con val no se puede
    // reasignar (error: "Val cannot be reassigned").
    // Solución: declararla con var, porque su valor va a cambiar.
    // ---------------------------------------------------------------
    var score = 10
    score = score + 5
    println("a) Score: $score")

    // ---------------------------------------------------------------
    // b) Código original:
    //      var temperature = 21
    //      temperature = 21.5
    // Problema: NO COMPILA. Al inicializarla con 21, Kotlin deduce que
    // es de tipo Int, y a un Int no se le puede asignar un decimal
    // (error: "Type mismatch").
    // Solución: inicializarla con 21.0 para que su tipo sea Double.
    // ---------------------------------------------------------------
    var temperature = 21.0
    temperature = 21.5
    println("b) Temperature: $temperature")

    // ---------------------------------------------------------------
    // c) Código original:
    //      val units: Int = 3
    //      val total: Long = units
    // Problema: NO COMPILA. Kotlin no convierte automáticamente entre
    // tipos numéricos, ni siquiera de Int a Long (error: "Type mismatch").
    // Solución: hacer la conversión explícita con toLong().
    // ---------------------------------------------------------------
    val units: Int = 3
    val total: Long = units.toLong()
    println("c) Total: $total")

    // ---------------------------------------------------------------
    // d) Código original:
    //      val average = 7 / 2
    // Problema: COMPILA, PERO DA 3 en lugar de 3.5. Al dividir dos Int
    // el resultado también es Int y se descartan los decimales.
    // Solución: que al menos uno de los operandos sea Double (7.0).
    // ---------------------------------------------------------------
    val average = 7.0 / 2
    println("d) Average: $average")

    // ---------------------------------------------------------------
    // e) Código original:
    //      val word = "Kotlin"
    //      println("Letters: $word.length")
    // Problema: COMPILA, PERO IMPRIME "Letters: Kotlin.length".
    // $word solo sustituye la variable; ".length" se trata como texto.
    // Solución: usar llaves ${...} para evaluar la expresión completa.
    // ---------------------------------------------------------------
    val word = "Kotlin"
    println("e) Letters: ${word.length}")
}

fun b1Ejercicio4() {
    print("Temperature in Celsius: ")

    // toDoubleOrNull() devuelve null si no se escribe un número válido.
    // replace(",", ".") permite escribir el decimal con coma (21,5) o con punto (21.5).
    val celsius = readln().replace(",", ".").toDoubleOrNull()

    if (celsius == null) {
        println("Valor no válido")
        return
    }

    // Fórmula: F = C × 9 / 5 + 32
    // Como celsius es Double, celsius * 9 da Double y la división / 5 conserva los decimales.
    val fahrenheit = celsius * 9 / 5 + 32

    // "%.1f" muestra el número con un solo decimal.
    // Locale.US hace que el decimal salga con punto (70.7) y no con coma (70,7),
    // que es lo que pondría Java con la configuración regional española.
    println("$celsius °C = ${"%.1f".format(java.util.Locale.US, fahrenheit)} °F")

    // ---------------------------------------------------------------
    // PIÉNSALO: ¿qué ocurre si escribimos c * (9 / 5) + 32?
    //
    // Los paréntesis hacen que primero se calcule 9 / 5. Como 9 y 5 son Int,
    // la división es entera: 9 / 5 = 1 (se descarta el decimal, no da 1.8).
    // Entonces la fórmula queda c * 1 + 32, es decir, solo suma 32.
    //
    // Ejemplo con 21.5 °C:
    //   Correcto:   21.5 * 9 / 5 + 32   = 70.7 °F
    //   Incorrecto: 21.5 * (9 / 5) + 32 = 21.5 * 1 + 32 = 53.5 °F
    //
    // Compila sin errores, pero el resultado es incorrecto.
    // Solución: usar decimales en la fracción: c * (9.0 / 5) + 32
    // ---------------------------------------------------------------
    val incorrecto = celsius * (9 / 5) + 32
    println("Con c * (9 / 5) + 32 daría: $incorrecto °F (incorrecto)")
}

fun b1Ejercicio5() {
    // ----- Lectura de datos -----
    // replace(",", ".") permite escribir decimales con coma o con punto.
    // toDoubleOrNull() ?: 0.0 evita que el programa falle si se escribe algo no numérico.
    print("Product name: ")
    val productName = readln()

    print("Unit price: ")
    val unitPrice = readln().replace(",", ".").toDoubleOrNull() ?: 0.0

    print("Quantity: ")
    val quantity = readln().toIntOrNull() ?: 0

    print("Discount (%): ")
    val discountPercentage = readln().replace(",", ".").toDoubleOrNull() ?: 0.0

    print("Tax (%): ")
    val taxPercentage = readln().replace(",", ".").toDoubleOrNull() ?: 0.0

    // ----- Cálculos -----
    // Todos son val porque, una vez calculados, no cambian.
    // unitPrice es Double, así que unitPrice * quantity da Double (no hay división entera).
    val subtotal = unitPrice * quantity
    val discountAmount = subtotal * discountPercentage / 100
    val priceAfterDiscount = subtotal - discountAmount
    val taxAmount = priceAfterDiscount * taxPercentage / 100
    val total = priceAfterDiscount + taxAmount

    // ----- Resultados con dos decimales -----
    println()
    println("Product: $productName")
    println("Subtotal: ${"%.2f".format(subtotal)}")
    println("Discount amount: ${"%.2f".format(discountAmount)}")
    println("Price after discount: ${"%.2f".format(priceAfterDiscount)}")
    println("Tax amount: ${"%.2f".format(taxAmount)}")
    println("Total: ${"%.2f".format(total)}")
}

fun b1Ejercicio6() {
    // ----- Lectura de datos -----
    print("Product name: ")
    val productName = readln()

    print("Unit price: ")
    val unitPrice = readln().replace(",", ".").toDoubleOrNull() ?: 0.0

    print("Quantity: ")
    val quantity = readln().toIntOrNull() ?: 0

    print("Discount (%): ")
    val discountPercentage = readln().replace(",", ".").toDoubleOrNull() ?: 0.0

    // Si el usuario pulsa Intro sin escribir nada, readln() devuelve "".
    // "".toDoubleOrNull() da null, y el operador ?: usa entonces DEFAULT_TAX.
    print("Tax (%) [Intro = $DEFAULT_TAX]: ")
    val taxPercentage = readln().replace(",", ".").toDoubleOrNull() ?: DEFAULT_TAX

    // ----- Cálculos (igual que en el ejercicio 5) -----
    val subtotal = unitPrice * quantity
    val discountAmount = subtotal * discountPercentage / 100
    val priceAfterDiscount = subtotal - discountAmount
    val taxAmount = priceAfterDiscount * taxPercentage / 100
    val total = priceAfterDiscount + taxAmount

    // ----- Recibo -----
    // "%-21s" escribe el texto ocupando 21 caracteres, alineado a la izquierda
    //         (el "-" indica alineación a la izquierda; se rellena con espacios).
    // "%10.2f" escribe el número con 2 decimales ocupando 10 caracteres,
    //          alineado a la derecha. Así todos los importes quedan en columna.
    println()
    println("========== $SHOP_NAME ==========")
    println("Product:   $productName x $quantity")
    println("%-21s%10.2f".format("Subtotal:", subtotal))
    println("%-21s%10.2f".format("Discount ($discountPercentage%):", -discountAmount))
    println("%-21s%10.2f".format("After discount:", priceAfterDiscount))
    println("%-21s%10.2f".format("Tax ($taxPercentage%):", taxAmount))
    println("-".repeat(31))
    println("%-21s%10.2f".format("TOTAL:", total))
}