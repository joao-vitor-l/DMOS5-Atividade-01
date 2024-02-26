import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    print("Informe um número: ")
    val number = scanner.nextDouble()

    if(isPrime(number)) {
        println("$number é um número primo.")
    } else {
        println("$number não é um número primo.")
    }
}

fun isPrime(number: Double): Boolean {
    if(number <= 1 || number != number.toInt().toDouble()) {
        return false
    }

    for(i in 2 until number.toInt()) {
        if(number % i == 0.0) {
            return false
        }
    }

    return true
}