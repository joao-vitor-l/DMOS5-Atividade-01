import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    var grossIncome: Double
    do {
        print("Informe seu salário bruto: R$ ")
        grossIncome = scanner.nextDouble()

        if(grossIncome <= 0) {
            println("Insira um valor apropriado.")
        }
    } while(grossIncome <= 0)

    var loan: Double
    do {
        print("Informe o valor da prestação: R$ ")
        loan = scanner.nextDouble()

        if(loan <= 0) {
            println("Insira um valor apropriado.")
        }
    } while(loan <= 0)

    val maxAllowedPayment = grossIncome * 0.3

    if(loan <= maxAllowedPayment) {
        println("Empréstimo concedido.")
    } else {
        println("O empréstimo não pode ser concedido. O valor da prestação ultrapassa 30% do salário bruto.")
    }
}