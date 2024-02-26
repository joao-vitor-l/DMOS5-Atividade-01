import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    var income: Double
    do {
        print("Informe seu salário: R$ ")
        income = scanner.nextDouble()

        if(income <= 0) {
            println("Insira um valor apropriado.")
        }
    } while(income <= 0)

    var bill1: Double
    do {
        print("Informe o valor da primeira conta atrasada: R$ ")
        bill1 = scanner.nextDouble()

        if(bill1 <= 0) {
            println("Insira um valor apropriado.")
        }
    } while(bill1 <= 0)

    var bill2: Double
    do {
        print("Informe o valor da segunda conta atrasada: R$ ")
        bill2 = scanner.nextDouble()

        if(bill2 <= 0) {
            println("Insira um valor apropriado.")
        }
    } while(bill2 <= 0)

    val remainingIncome = calc(income, bill1, bill2)

    println(String.format("Saldo restante após o pagamento das contas: R$ %.2f", remainingIncome))
}

fun calc(income: Double, bill1: Double, bill2: Double): Double {
    val penaltyRate = 0.02

    val totalBill1 = bill1 + bill1 * penaltyRate
    val totalBill2 = bill2 + bill2 * penaltyRate

    return income - totalBill1 - totalBill2
}