import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    var number: Int

    do {
        print("Informe um número inteiro positivo: ")
        number = scanner.nextInt()

        if(number < 0) {
            println("Número inválido.")
        }
    } while(number < 0)

    val factorialResult = calc(number)

    println("$number! = $factorialResult")
}

fun calc(number: Int): Long {
    if(number == 0 || number == 1) {
        return 1
    }

    var result: Long = 1
    for(i in 2..number) {
        result *= i
    }

    return result
}