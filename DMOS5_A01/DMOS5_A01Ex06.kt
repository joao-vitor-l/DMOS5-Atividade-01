import java.util.Scanner

data class Purchase(
    val labelPrice: Double,
    val paymentCode: Int,
    val finalPrice: Double
)

fun main() {
    val scanner = Scanner(System.`in`)

    var labelPrice: Double
    do {
        print("Informe o preço normal da etiqueta: R$ ")
        labelPrice = scanner.nextDouble()

        if(labelPrice <= 0) {
            println("Insira um valor apropriado.")
        }
    } while(labelPrice <= 0)

    var paymentCode: Int
    do {
        print("Escolha a condição de pagamento (1, 2, 3, 4, ou 0 para visualizar as condições): ")
        paymentCode = scanner.nextInt()

        if(paymentCode == 0) {
            println("1 - À vista em dinheiro ou cheque, recebe 10% de desconto.")
            println("2 - À vista no cartão de crédito, recebe 5% de desconto.")
            println("3 - Em 2 vezes, preço normal da etiqueta sem juros.")
            println("4 - Em 3 vezes, preço normal da etiqueta mais juros de 10%.")
        }

        if(paymentCode !in 0..4) {
            println("Código inválido.")
        }
    } while(paymentCode !in 1..4)

    val purchase = calc(labelPrice, paymentCode)

    println(String.format("Seu total é de R$ %.2f", purchase.finalPrice))
}

fun calc(labelPrice: Double, paymentCode: Int): Purchase {
    var pctDiscount: Double
    var pctInterest: Double

    when(paymentCode) {
        1 -> {
            pctDiscount = 0.1
            pctInterest = 0.0
        }
        2 -> {
            pctDiscount = 0.05
            pctInterest = 0.0
        }
        3 -> {
            pctDiscount = 0.0
            pctInterest = 0.0
        }
        4 -> {
            pctDiscount = 0.0
            pctInterest = 0.1
        }
        else -> {
            throw IllegalArgumentException("Código de pagamento inválido.")
        }
    }

    val discountAmount = labelPrice * pctDiscount
    var finalPrice = labelPrice - discountAmount

    if(paymentCode == 4) {
        finalPrice += finalPrice * pctInterest
    }

    return Purchase(labelPrice, paymentCode, finalPrice)
}