import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    var expenses: Double
    do {
        print("Informe o gasto total do espetáculo: R$ ")
        expenses = scanner.nextDouble()

        if(expenses <= 0) {
            println("Insira um valor apropriado.")
        }
    } while(expenses <= 0)

    var ticketPrice: Double
    do {
        print("Informe o preço do convite: R$ ")
        ticketPrice = scanner.nextDouble()

        if(ticketPrice <= 0) {
            println("Insira um valor apropriado.")
        }
    } while(ticketPrice <= 0)

    val minimumTickets = Math.ceil(expenses / ticketPrice).toInt()

    println("Para cobrir o custo do espetáculo, devem ser vendidos ao menos $minimumTickets convites.")
}