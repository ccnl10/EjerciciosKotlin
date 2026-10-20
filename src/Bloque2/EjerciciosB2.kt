package Bloque2

import java.util.Locale

// ===================================================================
// CONSTANTES (evitan los "números mágicos", como pide el enunciado)
// ===================================================================
// Ejercicio 1
const val MINIMO_ENVIO_GRATIS = 50.0
const val GASTOS_ENVIO = 4.99

// Reto
const val NUMERO_SECRETO = 7
const val NUMERO_MINIMO = 1
const val NUMERO_MAXIMO = 10
const val MAX_INTENTOS = 3

// Configuración regional española: hace que format() escriba 4,99 y no 4.99,
// aunque en main se haya puesto Locale.US. No es const porque Locale es un objeto.
val ESPANOL: Locale = Locale.forLanguageTag("es-ES")

// ===================================================================
// EJERCICIO 1 · Gastos de envío
// ===================================================================
fun b2Ejercicio1() {
    print("Total del pedido: ")
    // replace(',', '.') permite escribir el total con coma decimal (42,5)
    val totalPedido = readln().replace(',', '.').toDoubleOrNull() ?: 0.0

    // Un único val con if como expresión: el if devuelve el valor
    // que se guarda en envio (equivale al operador ternario de Java).
    val envio = if (totalPedido >= MINIMO_ENVIO_GRATIS) 0.0 else GASTOS_ENVIO

    println("Envío: ${"%.2f".format(ESPANOL, envio)} €")
    println("A pagar: ${"%.2f".format(ESPANOL, totalPedido + envio)} €")
}

// ===================================================================
// EJERCICIO 2 · De nota a calificación
// ===================================================================
fun b2Ejercicio2() {
    print("Nota (0-10): ")
    // Si se escribe algo que no es un número, se usa -1,
    // que cae en el else y muestra "Nota no válida".
    val nota = readln().toIntOrNull() ?: -1

    // when como expresión con rangos. Los rangos no se solapan:
    // cada uno empieza justo después de donde termina el anterior.
    val calificacion = when (nota) {
        in 0..4 -> "Insuficiente"
        5 -> "Suficiente"
        6 -> "Bien"
        in 7..8 -> "Notable"
        in 9..10 -> "Sobresaliente"
        else -> "Nota no válida"
    }

    println(calificacion)
}

// ===================================================================
// EJERCICIO 3 · Tabla de multiplicar
// ===================================================================
fun b2Ejercicio3() {
    print("Número: ")
    val numero = readln().toIntOrNull() ?: 0

    // Orden normal: rango ascendente 1..10
    println("--- Tabla del $numero ---")
    for (i in 1..10) {
        println("$numero x $i = ${numero * i}")
    }

    // Orden inverso: downTo, porque 10..1 sería un rango vacío
    println("--- Orden inverso ---")
    for (i in 10 downTo 1) {
        println("$numero x $i = ${numero * i}")
    }
}

// ===================================================================
// EJERCICIO 4 · Predice la salida
// ===================================================================
fun b2Ejercicio4() {
    // a) PREDICCIÓN: 1 4 7 10
    // step 3 avanza de 3 en 3 desde 1: 1, 4, 7, 10.
    // El 10 se incluye porque el rango .. es cerrado.
    print("a) ")
    for (i in 1..10 step 3) print("$i ")
    println()

    // b) PREDICCIÓN: fin
    // 5..1 es un rango VACÍO: .. siempre cuenta hacia arriba.
    // El bucle se ejecuta 0 veces (sin error) y solo se imprime "fin".
    // Para contar hacia atrás habría que usar 5 downTo 1.
    print("b) ")
    for (i in 5..1) print("$i ")
    println("fin")

    // c) PREDICCIÓN: grande
    // when ejecuta solo la PRIMERA rama que se cumple. 12 > 5 ya es true,
    // así que nunca llega a comprobar x > 10. La rama "enorme" no se alcanza
    // nunca. Solución: poner primero la condición más específica (x > 10).
    val x = 12
    val r = when {
        x > 5 -> "grande"
        x > 10 -> "enorme"
        else -> "pequeño"
    }
    println("c) $r")

    // d) PREDICCIÓN: 1
    // do-while comprueba la condición AL FINAL, así que el bloque se
    // ejecuta al menos una vez: n pasa de 0 a 1. Después, 1 < 0 es false
    // y el bucle termina. Con un while normal, n se quedaría en 0.
    var n = 0
    do {
        n++
    } while (n < 0)
    println("d) $n")

    // e) PREDICCIÓN: 1 2 4
    // i = 3 -> continue: se salta el print y pasa a la siguiente vuelta.
    // i = 5 -> break: sale del bucle, así que 5 y 6 no se imprimen.
    print("e) ")
    for (i in 1..6) {
        if (i == 3) continue
        if (i == 5) break
        print("$i ")
    }
    println()
}

// ===================================================================
// EJERCICIO 5 · Mes del año
// ===================================================================
fun b2Ejercicio5() {
    print("Número de mes (1-12): ")
    val mes = readln().toIntOrNull() ?: 0

    val nombreMes = when (mes) {
        1 -> "Enero"
        2 -> "Febrero"
        3 -> "Marzo"
        4 -> "Abril"
        5 -> "Mayo"
        6 -> "Junio"
        7 -> "Julio"
        8 -> "Agosto"
        9 -> "Septiembre"
        10 -> "Octubre"
        11 -> "Noviembre"
        12 -> "Diciembre"
        else -> "Mes no válido"
    }

    println(nombreMes)
}

// ===================================================================
// EJERCICIO 6 · Mes y estación
// ===================================================================
fun b2Ejercicio6() {
    print("Número de mes (1-12): ")
    val mes = readln().toIntOrNull() ?: 0

    // Primero se valida el número con !in. Si no es válido,
    // se muestra el error y return sale de la función.
    if (mes !in 1..12) {
        println("Mes no válido")
        return
    }

    val nombreMes = when (mes) {
        1 -> "Enero"
        2 -> "Febrero"
        3 -> "Marzo"
        4 -> "Abril"
        5 -> "Mayo"
        6 -> "Junio"
        7 -> "Julio"
        8 -> "Agosto"
        9 -> "Septiembre"
        10 -> "Octubre"
        11 -> "Noviembre"
        else -> "Diciembre"   // aquí solo puede ser 12, ya está validado
    }

    // PIÉNSALO: el invierno (12, 1, 2) no se puede escribir como un único
    // rango porque sus meses no son consecutivos: 12..2 sería un rango
    // VACÍO (.. solo cuenta hacia arriba).
    //
    // Forma 1 (la usada aquí): when sin sujeto, combinando un valor
    // suelto y un rango con ||.
    val estacion = when {
        mes == 12 || mes in 1..2 -> "Invierno"
        mes in 3..5 -> "Primavera"
        mes in 6..8 -> "Verano"
        else -> "Otoño"   // 9, 10, 11
    }
    //
    // Forma 2: when con sujeto, enumerando los meses separados por comas:
    //     val estacion = when (mes) {
    //         12, 1, 2 -> "Invierno"
    //         in 3..5 -> "Primavera"
    //         in 6..8 -> "Verano"
    //         else -> "Otoño"
    //     }

    println("$nombreMes - $estacion")
}

// ===================================================================
// RETO · Juego de adivinar el número
// ===================================================================
fun b2Reto() {
    var intentosUsados = 0     // var: aumenta con cada intento válido
    var haGanado = false       // var: pasa a true si se acierta

    println("Adivina el número ($NUMERO_MINIMO-$NUMERO_MAXIMO). Tienes $MAX_INTENTOS intentos.")

    // while: no sabemos cuántas vueltas dará (los números fuera de rango
    // no cuentan como intento y el juego acaba antes si se acierta).
    while (intentosUsados < MAX_INTENTOS) {
        print("Intento ${intentosUsados + 1}: ")
        val entrada = readln()
        val numero = entrada.toIntOrNull()

        // Número fuera del rango (o texto no numérico):
        // mensaje de error y continue, que vuelve al inicio del bucle
        // SIN sumar el intento.
        if (numero == null || numero !in NUMERO_MINIMO..NUMERO_MAXIMO) {
            println("$entrada no está entre $NUMERO_MINIMO y $NUMERO_MAXIMO. Inténtalo de nuevo.")
            continue
        }

        intentosUsados++

        if (numero == NUMERO_SECRETO) {
            haGanado = true
            break    // sale del bucle: el juego ha terminado
        } else if (numero < NUMERO_SECRETO) {
            println("¡Has fallado! El número secreto es mayor. Intentos restantes: ${MAX_INTENTOS - intentosUsados}")
        } else {
            println("¡Has fallado! El número secreto es menor. Intentos restantes: ${MAX_INTENTOS - intentosUsados}")
        }
    }

    // if como expresión dentro de la plantilla para el singular/plural
    if (haGanado) {
        println("¡Enhorabuena, lo has adivinado en $intentosUsados ${if (intentosUsados == 1) "intento" else "intentos"}!")
    } else {
        println("¡Has perdido! No te quedan intentos. El número secreto era $NUMERO_SECRETO.")
    }
}